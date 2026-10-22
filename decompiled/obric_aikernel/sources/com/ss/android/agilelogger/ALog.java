package com.ss.android.agilelogger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import androidx.profileinstaller.ProfileVerifier;
import com.bytedance.android.alog.Alog;
import com.bytedance.android.alog.IMessageInterceptor;
import com.bytedance.android.alog.Log;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeInfo;
import com.ss.android.agilelogger.utils.FormatUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class ALog {
    private static final int MSG_ASYNC_FLUSH = 2;
    private static final int MSG_ASYNC_LOG = 1;
    private static volatile Set<String> mBlockTagSet = null;
    private static Alog mainThreadRef = null;
    private static int prio = 3;
    private static Handler sAsyncHandler = null;
    private static HandlerThread sAsyncLogThread = null;
    public static com.ss.android.agilelogger.a sConfig = null;
    private static volatile boolean sDebug = false;
    private static volatile com.ss.android.agilelogger.b sILogCacheCallback = null;
    private static volatile List<com.ss.android.agilelogger.c> sINativeFuncAddrCallbackList = null;
    private static Object sInitLock = null;
    private static volatile boolean sInitSuccess = false;
    private static boolean sInitialized;
    private static ScheduledExecutorService sOuterExecutorService;
    private static ExecutorService sSingleThreadExecutor;
    private static ArrayList<WeakReference<Alog>> sStandaloneInstances;
    private static final ThreadLocal<Long> sThreadId = null;

    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.asyncFlush();
        }
    }

    static class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.asyncFlush();
        }
    }

    static class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.asyncFlush();
        }
    }

    static class d implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f7781c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ FormatUtils.TYPE f7782g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Throwable f7783h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f7784i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ Object f7785j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ String f7786k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ long f7787l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ long f7788m;

        d(int r10, FormatUtils.TYPE r11, Throwable r12, String r13, Object r14, String r15, long r16, long r17) {
            this.f7781c = r10;
            this.f7782g = r11;
            this.f7783h = r12;
            this.f7784i = r13;
            this.f7785j = r14;
            this.f7786k = r15;
            this.f7787l = r16;
            this.f7788m = r17;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r10 = ALog.access$400(this.f7781c);
            FormatUtils.TYPE r11 = this.f7782g;
            if (r11 == null) goto L5;
            FormatUtils.TYPE r12 = FormatUtils.TYPE.BORDER;
            if (r11 != r12) goto L15;
        L14:
            FormatUtils.c(r12, this.f7784i);
        L33:
            Log.innerWriteAsyncMsg(r10, this.f7786k, this.f7784i, this.f7787l, this.f7788m);
            return;
        L15:
            r12 = FormatUtils.TYPE.JSON;
            if (r11 == r12) goto L14;
            FormatUtils.TYPE r13 = FormatUtils.TYPE.BUNDLE;
            if (r11 != r13) goto L21;
            FormatUtils.b(r13, (Bundle) this.f7785j);
            goto L33
        L21:
            FormatUtils.TYPE r14 = FormatUtils.TYPE.INTENT;
            if (r11 != r14) goto L24;
            FormatUtils.a(r14, (Intent) this.f7785j);
            goto L33
        L24:
            FormatUtils.TYPE r15 = FormatUtils.TYPE.THROWABLE;
            if (r11 != r15) goto L27;
            FormatUtils.e(r15, (Throwable) this.f7785j);
            goto L33
        L27:
            FormatUtils.TYPE r16 = FormatUtils.TYPE.THREAD;
            if (r11 != r16) goto L30;
            FormatUtils.d(r16, (Thread) this.f7785j);
            goto L33
        L30:
            FormatUtils.TYPE r17 = FormatUtils.TYPE.STACKTRACE;
            if (r11 != r17) goto L33;
            FormatUtils.f(r17, (StackTraceElement[]) this.f7785j);
            goto L33
        L5:
            if (this.f7783h == null) goto L33;
            if (this.f7784i == null) goto L11;
            StringBuilder r18 = new StringBuilder();
            r18.append(this.f7784i);
            r18.append("\n");
        L11:
            xa.c.a(this.f7783h);
            goto L33
        }
    }

    static /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7789a = null;

        static {
            int[] r10 = new int[FormatUtils.TYPE.values().length];
            f7789a = r10;
            r10[FormatUtils.TYPE.MSG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            f7789a[FormatUtils.TYPE.STACKTRACE_STR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            f7789a[FormatUtils.TYPE.BORDER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            f7789a[FormatUtils.TYPE.JSON.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            f7789a[FormatUtils.TYPE.BUNDLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            f7789a[FormatUtils.TYPE.INTENT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            f7789a[FormatUtils.TYPE.THROWABLE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            f7789a[FormatUtils.TYPE.THREAD.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            f7789a[FormatUtils.TYPE.STACKTRACE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    static class f extends ThreadLocal<Long> {
        f() {
        }

        protected Long a() {
            return Long.valueOf(Process.myTid());
        }

        @Override // java.lang.ThreadLocal
        protected /* bridge */ /* synthetic */ Long initialValue() {
            return a();
        }
    }

    static class g implements ThreadFactory {
        g() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r10) {
            Thread r11 = new Thread(r10);
            r11.setName("Alog_newthreadpoolimpl");
            return r11;
        }
    }

    static class h extends Handler {
        h(Looper r10) {
            super(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            int r11 = r10.what;
            if (r11 != 1) goto L5;
            Object r12 = r10.obj;
            if (r12 != null) goto L11;
            return;
        L11:
            if ((r12 instanceof o) == false) goto L16;
            ALog.access$000((o) r12);
            return;
        L16:
            return;
        L5:
            if (r11 != 2) goto L17;
            Log.asyncFlush();
            return;
        }
    }

    static class i implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Queue f7790c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f7791g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f7792h;

        i(Queue r10, String r11, String r12) {
            this.f7790c = r10;
            this.f7791g = r11;
            this.f7792h = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            Queue r10 = this.f7790c;
            if (r10 == null) goto L5;
            ALog.access$100(r10);
            ALog.access$200().a();
        L5:
            Iterator<com.ss.android.agilelogger.c> r11 = ALog.getNativeFuncAddrCallbackList().iterator();
        L7:
            if (r11.hasNext() == false) goto L16;
            com.ss.android.agilelogger.c r12 = r11.next();
            if (r12 == null) goto L7;
            r12.a(Log.getLegacyWriteFuncAddr());
            goto L7
        L16:
            Thread.sleep(15000);     // Catch: Exception -> L15
        L13:
            ALog.access$300(this.f7791g, this.f7792h);
        }
    }

    static class j extends TimerTask {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f7793c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f7794g;

        j(String r10, String r11) {
            this.f7793c = r10;
            this.f7794g = r11;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            ALog.access$300(this.f7793c, this.f7794g);
        }
    }

    static class k implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f7795c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f7796g;

        k(String r10, String r11) {
            this.f7795c = r10;
            this.f7796g = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            ALog.access$300(this.f7795c, this.f7796g);
        }
    }

    static class l implements FilenameFilter {
        l() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r10, String r11) {
            return r11.startsWith(".logCache_");
        }
    }

    static class m implements FilenameFilter {
        m() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r10, String r11) {
            if (r11.endsWith(".hoting") == false) goto L6;
            return true;
        L6:
            if (r11.endsWith(".hot") == true) goto L8;
            return false;
        L8:
            if (r11.endsWith(".alog.hot") == true) goto L12;
            return true;
        L12:
            return false;
        }
    }

    static class n implements Runnable {
        n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.asyncFlush();
        }
    }

    private static class o {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final Object f7797j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static o f7798k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static int f7799l;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f7801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f7802c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Throwable f7803d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public FormatUtils.TYPE f7804e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Object f7805f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f7806g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f7807h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public o f7808i;

        static {
            f7797j = new Object();
        }

        private o() {
            this.f7804e = null;
        }

        public static o a() {
            Object r10 = f7797j;
            monitor-enter(r10);
            o r11 = f7798k;     // Catch: Throwable -> L12
            if (r11 == null) goto L9;
            f7798k = r11.f7808i;     // Catch: Throwable -> L12
            r11.f7808i = null;     // Catch: Throwable -> L12
            f7799l--;     // Catch: Throwable -> L12
            monitor-exit(r10);     // Catch: Throwable -> L12
            return r11;
        L9:
            monitor-exit(r10);     // Catch: Throwable -> L12
            return new o();
        L12:
            th = move-exception;
            throw th;
        }

        public void b() {
            this.f7801b = null;
            this.f7802c = null;
            this.f7803d = null;
            this.f7804e = null;
            this.f7805f = null;
            this.f7806g = -1;
            this.f7807h = 0;
            this.f7808i = null;
            Object r10 = f7797j;
            monitor-enter(r10);
            int r11 = f7799l;     // Catch: Throwable -> L9
            if (r11 >= 50) goto L7;
            this.f7808i = f7798k;     // Catch: Throwable -> L9
            f7798k = this;     // Catch: Throwable -> L9
            f7799l = r11 + 1;     // Catch: Throwable -> L9
        L7:
            monitor-exit(r10);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    public static class p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Alog f7809a;

        p(Alog r10) {
            this.f7809a = r10;
        }
    }

    static {
        sINativeFuncAddrCallbackList = new ArrayList();
        sOuterExecutorService = null;
        mainThreadRef = null;
        sStandaloneInstances = new ArrayList();
        sSingleThreadExecutor = null;
        sInitialized = false;
        sInitLock = new Object();
        sThreadId = new f();
    }

    public ALog() {
    }

    static /* synthetic */ void access$000(o r10) {
        handleAsyncLog(r10);
    }

    static /* synthetic */ void access$100(Queue r10) {
        writeCachedItems(r10);
    }

    static /* synthetic */ com.ss.android.agilelogger.b access$200() {
        return sILogCacheCallback;
    }

    static /* synthetic */ void access$300(String r10, String r11) {
        removeLegacyFiles(r10, r11);
    }

    static /* synthetic */ int access$400(int r10) {
        return level2AlogCoreLevel(r10);
    }

    public static void addMessageInterceptor(IMessageInterceptor r10) {
        Alog.addMessageInterceptor(r10);
    }

    public static void addNativeFuncAddrCallback(com.ss.android.agilelogger.c r10) {
        sINativeFuncAddrCallbackList.add(r10);
    }

    public static void asyncFlush() {
        ExecutorService r10 = sSingleThreadExecutor;
        if (r10 == null) goto L5;
        r10.execute(new n());
    L8:
        Log.asyncFlush();
        Alog r11 = mainThreadRef;
        if (r11 == null) goto L11;
        r11.asyncFlush();
    L11:
        Iterator<WeakReference<Alog>> r12 = sStandaloneInstances.iterator();
    L13:
        if (r12.hasNext() == false) goto L20;
        WeakReference<Alog> r13 = r12.next();
        if (r13 == null) goto L13;
        Alog r14 = r13.get();
        if (r14 == null) goto L13;
        r14.asyncFlush();
        goto L13
    L20:
        return;
    L5:
        Handler r15 = sAsyncHandler;
        if (r15 == null) goto L8;
        r15.sendEmptyMessage(2);
        goto L8
    }

    public static void bundle(int r10, String r11, Bundle r12) {
        if (checkPrioAndTag(r10, r11) == false) goto L37;
        com.ss.android.agilelogger.a r13 = sConfig;
        if (r13 != null) goto L7;
    L12:
        com.ss.android.agilelogger.a r14 = sConfig;
        if (r14 != null) goto L15;
    L20:
        boolean r15 = com.ss.android.agilelogger.f.c();
        if (r15 == true) goto L23;
    L26:
        if (r15 == true) goto L28;
    L31:
        int r16 = level2AlogCoreLevel(r10);
        String r17 = FormatUtils.b(FormatUtils.TYPE.BUNDLE, r12);
        Alog r18 = mainThreadRef;
        if (r18 == null) goto L35;
        if (r15 == false) goto L35;
        r18.write(r16, r11, r17);
        return;
    L35:
        Log.innerWrite(r16, r11, r17);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(r10, r11, null, null, FormatUtils.TYPE.BUNDLE, r12);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(r10, r11, null, null, FormatUtils.TYPE.BUNDLE, r12);
        return;
    L15:
        if (r14.b() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(r10, r11, null, null, FormatUtils.TYPE.BUNDLE, r12);
        return;
    L7:
        if (r13.b() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(r10, r11, null, null, FormatUtils.TYPE.BUNDLE, r12);
        return;
    }

    public static void changeLevel(int r10) {
        prio = r10;
        Log.setLevel(level2AlogCoreLevel(r10));
        Alog r11 = mainThreadRef;
        if (r11 == null) goto L6;
        r11.setLevel(level2AlogCoreLevel(r10));
        return;
    }

    public static boolean checkPrioAndTag(int r10, String r11) {
        if (r10 >= prio) goto L5;
        return false;
    L5:
        Set<String> r12 = mBlockTagSet;
        if (r12 != null) goto L8;
        return true;
    L8:
        if (TextUtils.isEmpty(r11) == false) goto L10;
        return true;
    L10:
        if (r12.contains(r11) == false) goto L15;
        return false;
    L15:
        return true;
    }

    public static p createInstance(String r10, Context r11) {
        if (r11 != null) goto L6;
        return null;
    L6:
        return createInstance(r10, new com.ss.android.agilelogger.a.b(r11).a());
    }

    public static p createInstance(String r10, com.ss.android.agilelogger.a r11) {
        if (r11 != null) goto L6;
        return null;
    L6:
        if (sInitSuccess == false) goto L35;
    L10:
        Alog.Builder r12 = new Alog.Builder(r11.e()).setInstanceName(r10).setLevel(level2AlogCoreLevel(r11.f())).setSyslog(sDebug);
        com.ss.android.agilelogger.a r13 = sConfig;
        if (r13 == null) goto L13;
        String r14 = r13.g();
    L14:
        Alog.Builder r15 = r12.setLogFileDir(r14).setLogFileSizeEach(r11.j()).setLogFileSizeTotal(r11.i()).setLogFileExpDays(r11.h());
        com.ss.android.agilelogger.a r16 = sConfig;
        if (r16 == null) goto L17;
        String r17 = r16.c();
    L18:
        Alog.Builder r18 = r15.setCacheFileDir(r17).setCacheFileSizeEach(65536).setCacheFileSizeTotal(ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE).setMode(Alog.Mode.SAFE).setTimeFormat(Alog.TimeFormat.RAW).setPrefixFormat(Alog.PrefixFormat.LEGACY);
        if (r11.m() == false) goto L21;
        Alog.Compress r19 = Alog.Compress.ZSTD;
    L22:
        Alog.Builder r20 = r18.setCompress(r19);
        if (r11.n() == false) goto L25;
        Alog.SymCrypt r21 = Alog.SymCrypt.TEA_16;
    L26:
        Alog.Builder r22 = r20.setSymCrypt(r21);
        if (r11.n() == false) goto L29;
        Alog.AsymCrypt r23 = Alog.AsymCrypt.EC_SECP256K1;
    L30:
        Alog r24 = r22.setAsymCrypt(r23).setServerPublicKey(r11.k()).build();
        if (r24 != null) goto L33;
        return null;
    L33:
        sStandaloneInstances.add(new WeakReference(r24));
        return new p(r24);
    L29:
        r23 = Alog.AsymCrypt.NONE;
        goto L30
    L25:
        r21 = Alog.SymCrypt.NONE;
        goto L26
    L21:
        r19 = Alog.Compress.NONE;
        goto L22
    L17:
        r17 = r11.c();
        goto L18
    L13:
        r14 = r11.g();
        goto L14
    L35:
        Alog.init(new com.ss.android.agilelogger.d());     // Catch: Throwable -> L9
    L9:
        return null;
    }

    public static void d(String r10, String r11) {
        if (checkPrioAndTag(3, r10) == false) goto L37;
        com.ss.android.agilelogger.a r12 = sConfig;
        if (r12 != null) goto L7;
    L12:
        com.ss.android.agilelogger.a r13 = sConfig;
        if (r13 != null) goto L15;
    L20:
        boolean r14 = com.ss.android.agilelogger.f.c();
        if (r14 == true) goto L23;
    L26:
        if (r14 == true) goto L28;
    L31:
        Alog r15 = mainThreadRef;
        if (r15 == null) goto L35;
        if (r14 == false) goto L35;
        r15.d(r10, r11);
        return;
    L35:
        Log.innerDebug(r10, r11);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(3, r10, r11);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(3, r10, r11);
        return;
    L15:
        if (r13.b() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(3, r10, r11);
        return;
    L7:
        if (r12.b() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(3, r10, r11);
        return;
    }

    public static void destroy() {
        Log.close();
        Alog r10 = mainThreadRef;
        if (r10 == null) goto L6;
        r10.close();
    L6:
        if (sAsyncHandler == null) goto L8;
        sAsyncLogThread.quit();
        sAsyncLogThread = null;
        sAsyncHandler = null;
    L8:
        ExecutorService r11 = sSingleThreadExecutor;
        if (r11 == null) goto L12;
        r11.shutdown();
        sSingleThreadExecutor = null;
        return;
    }

    public static void e(String r10, String r11) {
        if (checkPrioAndTag(6, r10) == false) goto L37;
        com.ss.android.agilelogger.a r12 = sConfig;
        if (r12 != null) goto L7;
    L12:
        com.ss.android.agilelogger.a r13 = sConfig;
        if (r13 != null) goto L15;
    L20:
        boolean r14 = com.ss.android.agilelogger.f.c();
        if (r14 == true) goto L23;
    L26:
        if (r14 == true) goto L28;
    L31:
        Alog r15 = mainThreadRef;
        if (r15 == null) goto L35;
        if (r14 == false) goto L35;
        r15.e(r10, r11);
        return;
    L35:
        Log.innerError(r10, r11);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(6, r10, r11);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(6, r10, r11);
        return;
    L15:
        if (r13.b() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(6, r10, r11);
        return;
    L7:
        if (r12.b() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(6, r10, r11);
        return;
    }

    public static void e(String r10, String r11, Throwable r12) {
        if (checkPrioAndTag(6, r10) == false) goto L37;
        com.ss.android.agilelogger.a r13 = sConfig;
        if (r13 != null) goto L7;
    L12:
        com.ss.android.agilelogger.a r14 = sConfig;
        if (r14 != null) goto L15;
    L20:
        boolean r15 = com.ss.android.agilelogger.f.c();
        if (r15 == true) goto L23;
    L26:
        if (r15 == true) goto L28;
    L31:
        String r16 = r11 + "\n" + xa.c.a(r12);
        Alog r17 = mainThreadRef;
        if (r17 == null) goto L35;
        if (r15 == false) goto L35;
        r17.e(r10, r16);
        return;
    L35:
        Log.innerError(r10, r16);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(6, r10, r11, r12, null, null);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(6, r10, r11, r12, null, null);
        return;
    L15:
        if (r14.b() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(6, r10, r11, r12, null, null);
        return;
    L7:
        if (r13.b() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(6, r10, r11, r12, null, null);
        return;
    }

    public static void e(String r10, Throwable r11) {
        if (checkPrioAndTag(6, r10) == false) goto L37;
        com.ss.android.agilelogger.a r12 = sConfig;
        if (r12 != null) goto L7;
    L12:
        com.ss.android.agilelogger.a r13 = sConfig;
        if (r13 != null) goto L15;
    L20:
        boolean r14 = com.ss.android.agilelogger.f.c();
        if (r14 == true) goto L23;
    L26:
        if (r14 == true) goto L28;
    L31:
        String r15 = xa.c.a(r11);
        Alog r16 = mainThreadRef;
        if (r16 == null) goto L35;
        if (r14 == false) goto L35;
        r16.e(r10, r15);
        return;
    L35:
        Log.innerError(r10, r15);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(6, r10, null, r11, null, null);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(6, r10, null, r11, null, null);
        return;
    L15:
        if (r13.b() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(6, r10, null, r11, null, null);
        return;
    L7:
        if (r12.b() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(6, r10, null, r11, null, null);
        return;
    }

    @Deprecated
    public static void flush() {
        ExecutorService r10 = sSingleThreadExecutor;
        if (r10 == null) goto L5;
        r10.execute(new c());
    L5:
        Handler r11 = sAsyncHandler;
        if (r11 == null) goto L8;
        r11.sendEmptyMessage(2);
    L8:
        Log.asyncFlush();
        Alog r12 = mainThreadRef;
        if (r12 == null) goto L12;
        r12.asyncFlush();
        return;
    }

    @Deprecated
    public static void forceLogSharding() {
    }

    public static List<String> getALogFiles(long r10, long r11) {
        ArrayList r12 = new ArrayList();
        File[] r13 = Log.getLogs(null, null, r10 * 1000, r11 * 1000);     // Catch: Exception -> L8
        int r14 = r13.length;     // Catch: Exception -> L8
        int r15 = 0;
    L4:
        if (r15 >= r14) goto L7;
        r12.add(r13[r15].getAbsolutePath());     // Catch: Exception -> L8
        r15 = r15 + 1;
    L7:
        return r12;
    }

    public static List<String> getALogFiles(String r10, String r11, long r12, long r13) {
        ArrayList r14 = new ArrayList();
        File[] r15 = Log.getLogs(r10, r11, r12 * 1000, r13 * 1000);     // Catch: Exception -> L8
        int r16 = r15.length;     // Catch: Exception -> L8
        int r17 = 0;
    L4:
        if (r17 >= r16) goto L7;
        r14.add(r15[r17].getAbsolutePath());     // Catch: Exception -> L8
        r17 = r17 + 1;
    L7:
        return r14;
    }

    public static long getALogSimpleWriteFuncAddr() {
        return Log.getNativeWriteFuncAddr();
    }

    public static long getALogWriteFuncAddr() {
        return Log.getLegacyWriteFuncAddr();
    }

    public static long getAlogNativeFlushV2FuncAddr() {
        return Log.getLegacyFlushFuncAddr();
    }

    public static long getAlogNativeLogStoreDirFuncAddr() {
        return Log.getLegacyGetLogFileDirFuncAddr();
    }

    public static Set<String> getBlockTagSet() {
        return mBlockTagSet;
    }

    public static HashMap<String, String> getLastFetchErrorInfo() {
        return Log.getLastFetchErrorInfo();
    }

    public static List<com.ss.android.agilelogger.c> getNativeFuncAddrCallbackList() {
        return sINativeFuncAddrCallbackList;
    }

    public static String getStatus() {
        return Log.getStatus();
    L4:
        return "getStatus exception";
    }

    private static long getThreadId() {
        return sThreadId.get().longValue();
    }

    private static void handleAsyncLog(o r10) {
        int r11 = level2AlogCoreLevel(r10.f7800a);
        FormatUtils.TYPE r12 = r10.f7804e;
        String r13 = "";
        if (r12 == null) goto L5;
        FormatUtils.TYPE r14 = FormatUtils.TYPE.BORDER;
        if (r12 != r14) goto L16;
    L14:
        String r15 = FormatUtils.c(r14, r10.f7802c);
    L15:
        String r16 = r15;
    L35:
        Log.innerWriteAsyncMsg(r11, r10.f7801b, r16, r10.f7806g, r10.f7807h);
        r10.b();
        return;
    L16:
        r14 = FormatUtils.TYPE.JSON;
        if (r12 == r14) goto L14;
        FormatUtils.TYPE r17 = FormatUtils.TYPE.BUNDLE;
        if (r12 != r17) goto L22;
        r15 = FormatUtils.b(r17, (Bundle) r10.f7805f);
        goto L15
    L22:
        FormatUtils.TYPE r18 = FormatUtils.TYPE.INTENT;
        if (r12 != r18) goto L25;
        r15 = FormatUtils.a(r18, (Intent) r10.f7805f);
        goto L15
    L25:
        FormatUtils.TYPE r19 = FormatUtils.TYPE.THROWABLE;
        if (r12 != r19) goto L28;
        r15 = FormatUtils.e(r19, (Throwable) r10.f7805f);
        goto L15
    L28:
        FormatUtils.TYPE r20 = FormatUtils.TYPE.THREAD;
        if (r12 != r20) goto L31;
        r15 = FormatUtils.d(r20, (Thread) r10.f7805f);
        goto L15
    L31:
        FormatUtils.TYPE r21 = FormatUtils.TYPE.STACKTRACE;
        if (r12 != r21) goto L34;
        r15 = FormatUtils.f(r21, (StackTraceElement[]) r10.f7805f);
        goto L15
    L34:
        r16 = "";
        goto L35
    L5:
        if (r10.f7803d != null) goto L8;
        r15 = r10.f7802c;
        goto L15
    L8:
        if (r10.f7802c == null) goto L11;
        r13 = r10.f7802c + "\n";
    L11:
        r15 = r13 + xa.c.a(r10.f7803d);
        goto L15
    }

    private static void handleItemMsg(com.ss.android.agilelogger.e r10) {
        switch(e.f7789a[r10.f7847d.ordinal()]) {
            case 1: goto L15;
            case 2: goto L12;
            case 3: goto L10;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L4;
        };
    L4:
        String r11 = "";
    L16:
        r10.f7846c = r11;
        return;
    L5:
        r11 = FormatUtils.f(r10.f7847d, (StackTraceElement[]) r10.f7848e);
        goto L16
    L6:
        r11 = FormatUtils.d(r10.f7847d, (Thread) r10.f7848e);
        goto L16
    L7:
        r11 = FormatUtils.e(r10.f7847d, (Throwable) r10.f7848e);
        goto L16
    L8:
        r11 = FormatUtils.a(r10.f7847d, (Intent) r10.f7848e);
        goto L16
    L9:
        r11 = FormatUtils.b(r10.f7847d, (Bundle) r10.f7848e);
        goto L16
    L10:
        r11 = FormatUtils.c(r10.f7847d, (String) r10.f7848e);
        goto L16
    L15:
        r11 = (String) r10.f7848e;
        goto L16
    L12:
        if (r10.f7849f != null) goto L14;
        r11 = xa.c.a((Throwable) r10.f7848e);
        goto L16
    L14:
        r11 = r10.f7849f + xa.c.a((Throwable) r10.f7848e);
        goto L16
    }

    public static void header(int r10, String r11, String r12) {
        if (checkPrioAndTag(r10, r11) == false) goto L37;
        com.ss.android.agilelogger.a r13 = sConfig;
        if (r13 != null) goto L7;
    L12:
        com.ss.android.agilelogger.a r14 = sConfig;
        if (r14 != null) goto L15;
    L20:
        boolean r15 = com.ss.android.agilelogger.f.c();
        if (r15 == true) goto L23;
    L26:
        if (r15 == true) goto L28;
    L31:
        int r16 = level2AlogCoreLevel(r10);
        String r17 = FormatUtils.c(FormatUtils.TYPE.BORDER, r12);
        Alog r18 = mainThreadRef;
        if (r18 == null) goto L35;
        if (r15 == false) goto L35;
        r18.write(r16, r11, r17);
        return;
    L35:
        Log.innerWrite(r16, r11, r17);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(r10, r11, r12, null, FormatUtils.TYPE.BORDER, null);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(r10, r11, r12, null, FormatUtils.TYPE.BORDER, null);
        return;
    L15:
        if (r14.b() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(r10, r11, r12, null, FormatUtils.TYPE.BORDER, null);
        return;
    L7:
        if (r13.b() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(r10, r11, r12, null, FormatUtils.TYPE.BORDER, null);
        return;
    }

    public static void i(String r10, String r11) {
        if (checkPrioAndTag(4, r10) == false) goto L37;
        com.ss.android.agilelogger.a r12 = sConfig;
        if (r12 != null) goto L7;
    L12:
        com.ss.android.agilelogger.a r13 = sConfig;
        if (r13 != null) goto L15;
    L20:
        boolean r14 = com.ss.android.agilelogger.f.c();
        if (r14 == true) goto L23;
    L26:
        if (r14 == true) goto L28;
    L31:
        Alog r15 = mainThreadRef;
        if (r15 == null) goto L35;
        if (r14 == false) goto L35;
        r15.i(r10, r11);
        return;
    L35:
        Log.innerInfo(r10, r11);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(4, r10, r11);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(4, r10, r11);
        return;
    L15:
        if (r13.b() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(4, r10, r11);
        return;
    L7:
        if (r12.b() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(4, r10, r11);
        return;
    }

    public static boolean init(com.ss.android.agilelogger.a r13) {
        boolean r10 = false;
        if (r13 != null) goto L5;
        return false;
    L5:
        sConfig = r13;
        Alog.init(new com.ss.android.agilelogger.d());     // Catch: Throwable -> L95
        Object r11 = sInitLock;
        monitor-enter(r11);
    L92:
        th = move-exception;
        throw th;
    L10:
        if (sInitialized == false) goto L13;
        monitor-exit(r11);     // Catch: Throwable -> L92
        return false;
    L13:
        sInitialized = true;     // Catch: Throwable -> L92
        monitor-exit(r11);     // Catch: Throwable -> L92
        prio = r13.f();
        boolean r12 = com.ss.android.agilelogger.f.b(r13.e());
        boolean r14 = r13.q();
        if (r14 == false) goto L18;
    L21:
        boolean r15 = false;
    L22:
        boolean r16 = r13.a();
        boolean r17 = r13.p();
        if (r12 == true) goto L25;
        r13.C((int) (r13.i() * r13.l()));
    L25:
        Alog.Builder r18 = new Alog.Builder(r13.e()).setInstanceName(DowngradeInfo.SubInfo.FIELD_DEFAULT_RATE).setLevel(level2AlogCoreLevel(r13.f())).setSyslog(sDebug).setLogFileDir(r13.g()).setLogFileSizeEach(r13.j());
        int r19 = r13.i();
        if (r15 == false) goto L28;
        r19 = (r19 / 3) * 2;
    L28:
        Alog.Builder r20 = r18.setLogFileSizeTotal(r19).setLogFileExpDays(r13.h()).setCacheFileDir(r13.c());
        if (r12 == false) goto L31;
        int r21 = r13.d() * 1024;
    L32:
        Alog.Builder r22 = r20.setCacheFileSizeEach(r21);
        if (r12 == false) goto L35;
        int r23 = (r13.d() * 3) * 1024;
    L36:
        Alog.Builder r24 = r22.setCacheFileSizeTotal(r23);
        Alog.Mode r25 = Alog.Mode.SAFE;
        Alog.Builder r26 = r24.setMode(r25);
        Alog.TimeFormat r110 = Alog.TimeFormat.RAW;
        Alog.Builder r27 = r26.setTimeFormat(r110);
        Alog.PrefixFormat r111 = Alog.PrefixFormat.LEGACY;
        Alog.Builder r28 = r27.setPrefixFormat(r111);
        if (r13.m() == false) goto L39;
        Alog.Compress r112 = Alog.Compress.ZSTD;
    L40:
        Alog.Builder r29 = r28.setCompress(r112);
        if (r13.n() == false) goto L43;
        Alog.SymCrypt r113 = Alog.SymCrypt.TEA_16;
    L44:
        Alog.Builder r30 = r29.setSymCrypt(r113);
        if (r13.n() == false) goto L47;
        Alog.AsymCrypt r114 = Alog.AsymCrypt.EC_SECP256K1;
    L48:
        Log.setInstance(r30.setAsymCrypt(r114).setServerPublicKey(r13.k()).build());
        if (r14 == false) goto L55;
        if (r16 == true) goto L52;
        if (r12 == false) goto L55;
    L52:
        if (r17 == false) goto L54;
        sSingleThreadExecutor = Executors.newSingleThreadExecutor(new g());
        goto L55
    L54:
        HandlerThread r31 = new HandlerThread("Alog_main_delegate");
        sAsyncLogThread = r31;
        r31.start();
        sAsyncHandler = new h(sAsyncLogThread.getLooper());
    L55:
        if (r15 == false) goto L69;
        Alog.Builder r32 = new Alog.Builder(r13.e()).setInstanceName("main").setLevel(level2AlogCoreLevel(r13.f())).setSyslog(sDebug).setLogFileDir(r13.g()).setLogFileSizeEach(r13.j() / 2).setLogFileSizeTotal(r13.i() / 3).setLogFileExpDays(r13.h()).setCacheFileDir(r13.c()).setCacheFileSizeEach(32768).setCacheFileSizeTotal(98304).setMode(r25).setTimeFormat(r110).setPrefixFormat(r111);
        if (r13.m() == false) goto L59;
        Alog.Compress r33 = Alog.Compress.ZSTD;
    L60:
        Alog.Builder r34 = r32.setCompress(r33);
        if (r13.n() == false) goto L63;
        Alog.SymCrypt r35 = Alog.SymCrypt.TEA_16;
    L64:
        Alog.Builder r36 = r34.setSymCrypt(r35);
        if (r13.n() == false) goto L67;
        Alog.AsymCrypt r37 = Alog.AsymCrypt.EC_SECP256K1;
    L68:
        mainThreadRef = r36.setAsymCrypt(r37).setServerPublicKey(r13.k()).build();
        goto L69
    L67:
        r37 = Alog.AsymCrypt.NONE;
        goto L68
    L63:
        r35 = Alog.SymCrypt.NONE;
        goto L64
    L59:
        r33 = Alog.Compress.NONE;
    L69:
        String r38 = r13.c();
        String r115 = r13.g();
        Queue<com.ss.android.agilelogger.e> r39 = null;
        if (sILogCacheCallback == null) goto L77;
        Queue<com.ss.android.agilelogger.e> r40 = sILogCacheCallback.b();
        if (r40 != null) goto L74;
    L76:
        r39 = r40;
        goto L77
    L74:
        if (r40.size() != 0) goto L76;
    L77:
        if (r39 == null) goto L79;
    L80:
        i r41 = new i(r39, r38, r115);
        ScheduledExecutorService r42 = sOuterExecutorService;
        if (r42 != null) goto L83;
        new Thread(r41, "_ALOG_OPT_").start();
    L84:
        r10 = true;
    L85:
        if (r10 == true) goto L90;
        ScheduledExecutorService r43 = sOuterExecutorService;
        if (r43 != null) goto L89;
        new Timer("_ALOG_OPT_").schedule(new j(r38, r115), 15000);
        goto L90
    L89:
        r43.schedule(new k(r38, r115), 15, TimeUnit.SECONDS);
    L90:
        sInitSuccess = true;
        return true;
    L83:
        r42.execute(r41);
        goto L84
    L79:
        if (getNativeFuncAddrCallbackList().size() <= 0) goto L85;
    L47:
        r114 = Alog.AsymCrypt.NONE;
        goto L48
    L43:
        r113 = Alog.SymCrypt.NONE;
        goto L44
    L39:
        r112 = Alog.Compress.NONE;
        goto L40
    L35:
        r23 = 65536;
        goto L36
    L31:
        r21 = 32768;
        goto L32
    L18:
        if (r13.o() == false) goto L21;
        if (r12 == false) goto L21;
        r15 = true;
    L95:
        return false;
    }

    public static void intent(int r10, String r11, Intent r12) {
        if (checkPrioAndTag(r10, r11) == false) goto L37;
        com.ss.android.agilelogger.a r13 = sConfig;
        if (r13 != null) goto L7;
    L12:
        com.ss.android.agilelogger.a r14 = sConfig;
        if (r14 != null) goto L15;
    L20:
        boolean r15 = com.ss.android.agilelogger.f.c();
        if (r15 == true) goto L23;
    L26:
        if (r15 == true) goto L28;
    L31:
        int r16 = level2AlogCoreLevel(r10);
        String r17 = FormatUtils.a(FormatUtils.TYPE.INTENT, r12);
        Alog r18 = mainThreadRef;
        if (r18 == null) goto L35;
        if (r15 == false) goto L35;
        r18.write(r16, r11, r17);
        return;
    L35:
        Log.innerWrite(r16, r11, r17);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(r10, r11, null, null, FormatUtils.TYPE.INTENT, r12);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(r10, r11, null, null, FormatUtils.TYPE.INTENT, r12);
        return;
    L15:
        if (r14.b() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(r10, r11, null, null, FormatUtils.TYPE.INTENT, r12);
        return;
    L7:
        if (r13.b() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(r10, r11, null, null, FormatUtils.TYPE.INTENT, r12);
        return;
    }

    public static boolean isInitSuccess() {
        return sInitSuccess;
    }

    public static void json(int r10, String r11, String r12) {
        if (checkPrioAndTag(r10, r11) == false) goto L37;
        com.ss.android.agilelogger.a r13 = sConfig;
        if (r13 != null) goto L7;
    L12:
        com.ss.android.agilelogger.a r14 = sConfig;
        if (r14 != null) goto L15;
    L20:
        boolean r15 = com.ss.android.agilelogger.f.c();
        if (r15 == true) goto L23;
    L26:
        if (r15 == true) goto L28;
    L31:
        int r16 = level2AlogCoreLevel(r10);
        String r17 = FormatUtils.c(FormatUtils.TYPE.JSON, r12);
        Alog r18 = mainThreadRef;
        if (r18 == null) goto L35;
        if (r15 == false) goto L35;
        r18.write(r16, r11, r17);
        return;
    L35:
        Log.innerWrite(r16, r11, r17);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(r10, r11, r12, null, FormatUtils.TYPE.JSON, null);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(r10, r11, r12, null, FormatUtils.TYPE.JSON, null);
        return;
    L15:
        if (r14.b() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(r10, r11, r12, null, FormatUtils.TYPE.JSON, null);
        return;
    L7:
        if (r13.b() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(r10, r11, r12, null, FormatUtils.TYPE.JSON, null);
        return;
    }

    private static int level2AlogCoreLevel(int r10) {
        return r10 - 2;
    }

    private static void postAsyncLog(int r10, String r11, String r12) {
        postAsyncLog(r10, r11, r12, null, null, null);
    }

    private static void postAsyncLog(int r10, String r11, String r12, Throwable r13, FormatUtils.TYPE r14, Object r15) {
        o r16 = o.a();
        r16.f7800a = r10;
        r16.f7801b = r11;
        r16.f7802c = r12;
        r16.f7803d = r13;
        r16.f7804e = r14;
        r16.f7805f = r15;
        r16.f7806g = getThreadId();
        r16.f7807h = System.currentTimeMillis();
        Message r17 = Message.obtain();
        r17.what = 1;
        r17.obj = r16;
        sAsyncHandler.sendMessage(r17);
    }

    private static void postAsyncLogByThreadPool(int r10, String r11, String r12) {
        postAsyncLogByThreadPool(r10, r11, r12, null, null, null);
    }

    private static void postAsyncLogByThreadPool(int r13, String r14, String r15, Throwable r16, FormatUtils.TYPE r17, Object r18) {
        long r10 = getThreadId();
        long r11 = System.currentTimeMillis();
        sSingleThreadExecutor.execute(new d(r13, r17, r16, r15, r18, r14, r10, r11));
    }

    public static void println(int r10, String r11, Object r12, FormatUtils.TYPE r13) {
        if (checkPrioAndTag(r10, r11) == false) goto L50;
        int r14 = level2AlogCoreLevel(r10);
        switch(e.f7789a[r13.ordinal()]) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L6:
        String r15 = "";
    L17:
        com.ss.android.agilelogger.a r16 = sConfig;
        if (r16 != null) goto L20;
    L25:
        com.ss.android.agilelogger.a r17 = sConfig;
        if (r17 != null) goto L28;
    L33:
        boolean r18 = com.ss.android.agilelogger.f.c();
        if (r18 == true) goto L36;
    L39:
        if (r18 == true) goto L41;
    L44:
        Alog r19 = mainThreadRef;
        if (r19 == null) goto L48;
        if (r18 == false) goto L48;
        r19.write(r14, r11, r15);
        return;
    L48:
        Log.innerWrite(r14, r11, r15);
        return;
    L41:
        if (sAsyncHandler == null) goto L44;
        postAsyncLog(r10, r11, r15);
        return;
    L36:
        if (sSingleThreadExecutor == null) goto L39;
        postAsyncLogByThreadPool(r10, r11, r15);
        return;
    L28:
        if (r17.b() == false) goto L33;
        if (sAsyncHandler == null) goto L33;
        postAsyncLog(r10, r11, r15);
        return;
    L20:
        if (r16.b() == false) goto L25;
        if (sSingleThreadExecutor == null) goto L25;
        postAsyncLogByThreadPool(r10, r11, r15);
        return;
    L7:
        r15 = FormatUtils.f(FormatUtils.TYPE.STACKTRACE, (StackTraceElement[]) r12);
        goto L17
    L8:
        r15 = FormatUtils.d(FormatUtils.TYPE.THREAD, (Thread) r12);
        goto L17
    L9:
        r15 = FormatUtils.e(FormatUtils.TYPE.THROWABLE, (Throwable) r12);
        goto L17
    L10:
        r15 = FormatUtils.a(FormatUtils.TYPE.INTENT, (Intent) r12);
        goto L17
    L11:
        r15 = FormatUtils.b(FormatUtils.TYPE.BUNDLE, (Bundle) r12);
        goto L17
    L12:
        FormatUtils.TYPE r20 = FormatUtils.TYPE.JSON;
    L14:
        r15 = FormatUtils.c(r20, (String) r12);
        goto L17
    L13:
        r20 = FormatUtils.TYPE.BORDER;
        goto L14
    L15:
        r15 = xa.c.a((Throwable) r12);
        goto L17
    L16:
        r15 = (String) r12;
        goto L17
    }

    public static void release() {
        Log.close();
        Alog r10 = mainThreadRef;
        if (r10 == null) goto L6;
        r10.close();
    L6:
        if (sAsyncHandler == null) goto L8;
        sAsyncLogThread.quit();
        sAsyncLogThread = null;
        sAsyncHandler = null;
    L8:
        ExecutorService r11 = sSingleThreadExecutor;
        if (r11 == null) goto L12;
        r11.shutdown();
        sSingleThreadExecutor = null;
        return;
    }

    private static void removeLegacyFiles(String r10, String r11) {
        File r12 = new File(r10);
        int r13 = 0;
        if (r12.exists() == false) goto L9;
        File[] r14 = r12.listFiles(new l());
        if (r14 == null) goto L9;
        int r15 = r14.length;
        int r16 = 0;
    L7:
        if (r16 >= r15) goto L9;
        r14[r16].delete();
        r16 = r16 + 1;
    L9:
        File r17 = new File(r11);
        if (r17.exists() == false) goto L16;
        File[] r18 = r17.listFiles(new m());
        if (r18 == null) goto L19;
        int r19 = r18.length;
    L14:
        if (r13 >= r19) goto L20;
        r18[r13].delete();
        r13 = r13 + 1;
        goto L14
    L20:
        return;
    L19:
        return;
    }

    public static void removeMessageInterceptor(IMessageInterceptor r10) {
        Alog.removeMessageInterceptor(r10);
    }

    public static void removeObsoleteInstance(String r10, Context r11, boolean r12) {
        String r13 = com.ss.android.agilelogger.f.a();
        if (r13 != null) goto L6;
        return;
    L6:
        if (r13.contains(":") == false) goto L8;
        return;
    L8:
        if (r12 == true) goto L11;
        r13 = r13 + '-';
    L11:
        com.ss.android.agilelogger.a r14 = sConfig;
        if (r14 == null) goto L14;
        String r15 = r14.g();
        String r16 = sConfig.c();
    L15:
        File r17 = new File(r15);
        if (r17.exists() == true) goto L18;
        return;
    L18:
        if (r17.isDirectory() == false) goto L57;
        String r18 = "__" + r10 + ".alog.hot";
        File[] r19 = r17.listFiles();
        int r20 = r19.length;
        int r21 = 0;
        int r22 = 0;
    L21:
        if (r22 >= r20) goto L30;
        File r23 = r19[r22];
        String r24 = r23.getName();
        if (r24 == null) goto L29;
        if (r24.endsWith(r18) == false) goto L29;
        if (r24.contains(r13) == false) goto L29;
        r23.delete();
    L29:
        r22 = r22 + 1;
        goto L21
    L30:
        File r110 = new File(r16);
        if (r110.exists() == true) goto L33;
        return;
    L33:
        if (r110.isDirectory() == false) goto L58;
        String r111 = "__" + r10;
        File[] r112 = r110.listFiles();
        int r113 = r112.length;
    L36:
        if (r21 >= r113) goto L59;
        File r25 = r112[r21];
        String r26 = r25.getName();
        if (r26 == null) goto L44;
        if (r26.contains(r111) == false) goto L44;
        if (r26.contains(r13) == false) goto L44;
        r25.delete();
    L44:
        r21 = r21 + 1;
        goto L36
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L14:
        String r114 = xa.a.b(r11).getAbsolutePath();
        r16 = xa.a.a(r11);
        r15 = r114;
        goto L15
    }

    public static void setBlockTagSet(Set<String> r10) {
        mBlockTagSet = Collections.unmodifiableSet(r10);
    }

    public static void setDebug(boolean r10) {
        sDebug = r10;
        Log.setSyslog(sDebug);
        Alog r11 = mainThreadRef;
        if (r11 == null) goto L6;
        r11.setSyslog(sDebug);
        return;
    }

    public static void setILogCacheCallback(com.ss.android.agilelogger.b r10) {
        sILogCacheCallback = r10;
    }

    public static void setOuterExecutorService(ScheduledExecutorService r10) {
        sOuterExecutorService = r10;
    }

    @Deprecated
    public static void setPrintStackTrace(boolean r10) {
    }

    @Deprecated
    public static void setsPackageClassName(String r10) {
    }

    public static void stacktrace(int r10, String r11, StackTraceElement[] r12) {
        if (checkPrioAndTag(r10, r11) == false) goto L37;
        com.ss.android.agilelogger.a r13 = sConfig;
        if (r13 != null) goto L7;
    L12:
        com.ss.android.agilelogger.a r14 = sConfig;
        if (r14 != null) goto L15;
    L20:
        boolean r15 = com.ss.android.agilelogger.f.c();
        if (r15 == true) goto L23;
    L26:
        if (r15 == true) goto L28;
    L31:
        int r16 = level2AlogCoreLevel(r10);
        String r17 = FormatUtils.f(FormatUtils.TYPE.STACKTRACE, r12);
        Alog r18 = mainThreadRef;
        if (r18 == null) goto L35;
        if (r15 == false) goto L35;
        r18.write(r16, r11, r17);
        return;
    L35:
        Log.innerWrite(r16, r11, r17);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(r10, r11, null, null, FormatUtils.TYPE.STACKTRACE, r12);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(r10, r11, null, null, FormatUtils.TYPE.STACKTRACE, r12);
        return;
    L15:
        if (r14.b() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(r10, r11, null, null, FormatUtils.TYPE.STACKTRACE, r12);
        return;
    L7:
        if (r13.b() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(r10, r11, null, null, FormatUtils.TYPE.STACKTRACE, r12);
        return;
    }

    public static void statcktrace(int r10, String r11, StackTraceElement[] r12) {
        stacktrace(r10, r11, r12);
    }

    public static void syncFlush() {
        ExecutorService r10 = sSingleThreadExecutor;
        if (r10 == null) goto L5;
        r10.execute(new a());
    L5:
        Handler r11 = sAsyncHandler;
        if (r11 == null) goto L8;
        r11.sendEmptyMessage(2);
    L8:
        Log.syncFlush();
        Alog r12 = mainThreadRef;
        if (r12 == null) goto L11;
        r12.syncFlush();
    L11:
        Iterator<WeakReference<Alog>> r13 = sStandaloneInstances.iterator();
    L13:
        if (r13.hasNext() == false) goto L17;
        Alog r14 = r13.next().get();
        if (r14 == null) goto L13;
        r14.syncFlush();
        goto L13
    }

    public static void thread(int r10, String r11, Thread r12) {
        if (checkPrioAndTag(r10, r11) == false) goto L37;
        com.ss.android.agilelogger.a r13 = sConfig;
        if (r13 != null) goto L7;
    L12:
        com.ss.android.agilelogger.a r14 = sConfig;
        if (r14 != null) goto L15;
    L20:
        boolean r15 = com.ss.android.agilelogger.f.c();
        if (r15 == true) goto L23;
    L26:
        if (r15 == true) goto L28;
    L31:
        int r16 = level2AlogCoreLevel(r10);
        String r17 = FormatUtils.d(FormatUtils.TYPE.THREAD, r12);
        Alog r18 = mainThreadRef;
        if (r18 == null) goto L35;
        if (r15 == false) goto L35;
        r18.write(r16, r11, r17);
        return;
    L35:
        Log.innerWrite(r16, r11, r17);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(r10, r11, null, null, FormatUtils.TYPE.THREAD, r12);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(r10, r11, null, null, FormatUtils.TYPE.THREAD, r12);
        return;
    L15:
        if (r14.b() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(r10, r11, null, null, FormatUtils.TYPE.THREAD, r12);
        return;
    L7:
        if (r13.b() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(r10, r11, null, null, FormatUtils.TYPE.THREAD, r12);
        return;
    }

    public static void throwable(int r10, String r11, Throwable r12) {
        if (checkPrioAndTag(r10, r11) == false) goto L37;
        com.ss.android.agilelogger.a r13 = sConfig;
        if (r13 != null) goto L7;
    L12:
        com.ss.android.agilelogger.a r14 = sConfig;
        if (r14 != null) goto L15;
    L20:
        boolean r15 = com.ss.android.agilelogger.f.c();
        if (r15 == true) goto L23;
    L26:
        if (r15 == true) goto L28;
    L31:
        int r16 = level2AlogCoreLevel(r10);
        String r17 = FormatUtils.e(FormatUtils.TYPE.THROWABLE, r12);
        Alog r18 = mainThreadRef;
        if (r18 == null) goto L35;
        if (r15 == false) goto L35;
        r18.write(r16, r11, r17);
        return;
    L35:
        Log.innerWrite(r16, r11, r17);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(r10, r11, null, null, FormatUtils.TYPE.THROWABLE, r12);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(r10, r11, null, r12, FormatUtils.TYPE.THROWABLE, null);
        return;
    L15:
        if (r14.b() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(r10, r11, null, r12, FormatUtils.TYPE.THROWABLE, null);
        return;
    L7:
        if (r13.b() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(r10, r11, null, r12, FormatUtils.TYPE.THROWABLE, null);
        return;
    }

    public static void timedSyncFlush(int r10) {
        ExecutorService r11 = sSingleThreadExecutor;
        if (r11 == null) goto L5;
        r11.execute(new b());
    L5:
        Handler r12 = sAsyncHandler;
        if (r12 == null) goto L8;
        r12.sendEmptyMessage(2);
    L8:
        Log.timedSyncFlush(r10);
        Alog r13 = mainThreadRef;
        if (r13 == null) goto L11;
        r13.timedSyncFlush(r10);
    L11:
        Iterator<WeakReference<Alog>> r14 = sStandaloneInstances.iterator();
    L13:
        if (r14.hasNext() == false) goto L17;
        Alog r15 = r14.next().get();
        if (r15 == null) goto L13;
        r15.timedSyncFlush(r10);
        goto L13
    }

    public static void v(String r10, String r11) {
        if (checkPrioAndTag(2, r10) == false) goto L37;
        com.ss.android.agilelogger.a r12 = sConfig;
        if (r12 != null) goto L7;
    L12:
        com.ss.android.agilelogger.a r13 = sConfig;
        if (r13 != null) goto L15;
    L20:
        boolean r14 = com.ss.android.agilelogger.f.c();
        if (r14 == true) goto L23;
    L26:
        if (r14 == true) goto L28;
    L31:
        Alog r15 = mainThreadRef;
        if (r15 == null) goto L35;
        if (r14 == false) goto L35;
        r15.v(r10, r11);
        return;
    L35:
        Log.innerVerbose(r10, r11);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(2, r10, r11);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(2, r10, r11);
        return;
    L15:
        if (r13.b() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(2, r10, r11);
        return;
    L7:
        if (r12.b() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(2, r10, r11);
        return;
    }

    public static void w(String r10, String r11) {
        if (checkPrioAndTag(5, r10) == false) goto L37;
        com.ss.android.agilelogger.a r12 = sConfig;
        if (r12 != null) goto L7;
    L12:
        com.ss.android.agilelogger.a r13 = sConfig;
        if (r13 != null) goto L15;
    L20:
        boolean r14 = com.ss.android.agilelogger.f.c();
        if (r14 == true) goto L23;
    L26:
        if (r14 == true) goto L28;
    L31:
        Alog r15 = mainThreadRef;
        if (r15 == null) goto L35;
        if (r14 == false) goto L35;
        r15.w(r10, r11);
        return;
    L35:
        Log.innerWarn(r10, r11);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(5, r10, r11);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(5, r10, r11);
        return;
    L15:
        if (r13.b() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(5, r10, r11);
        return;
    L7:
        if (r12.b() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(5, r10, r11);
        return;
    }

    public static void w(String r10, String r11, Throwable r12) {
        if (checkPrioAndTag(5, r10) == false) goto L37;
        com.ss.android.agilelogger.a r13 = sConfig;
        if (r13 != null) goto L7;
    L12:
        com.ss.android.agilelogger.a r14 = sConfig;
        if (r14 != null) goto L15;
    L20:
        boolean r15 = com.ss.android.agilelogger.f.c();
        if (r15 == true) goto L23;
    L26:
        if (r15 == true) goto L28;
    L31:
        String r16 = r11 + "\n" + xa.c.a(r12);
        Alog r17 = mainThreadRef;
        if (r17 == null) goto L35;
        if (r15 == false) goto L35;
        r17.w(r10, r16);
        return;
    L35:
        Log.innerWarn(r10, r16);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(5, r10, r11, r12, null, null);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(5, r10, r11, r12, null, null);
        return;
    L15:
        if (r14.b() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(5, r10, r11, r12, null, null);
        return;
    L7:
        if (r13.b() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(5, r10, r11, r12, null, null);
        return;
    }

    public static void w(String r10, Throwable r11) {
        if (checkPrioAndTag(5, r10) == false) goto L37;
        com.ss.android.agilelogger.a r12 = sConfig;
        if (r12 != null) goto L7;
    L12:
        com.ss.android.agilelogger.a r13 = sConfig;
        if (r13 != null) goto L15;
    L20:
        boolean r14 = com.ss.android.agilelogger.f.c();
        if (r14 == true) goto L23;
    L26:
        if (r14 == true) goto L28;
    L31:
        String r15 = xa.c.a(r11);
        Alog r16 = mainThreadRef;
        if (r16 == null) goto L35;
        if (r14 == false) goto L35;
        r16.w(r10, r15);
        return;
    L35:
        Log.innerWarn(r10, r15);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(5, r10, null, r11, null, null);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(5, r10, null, r11, null, null);
        return;
    L15:
        if (r13.b() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(5, r10, null, r11, null, null);
        return;
    L7:
        if (r12.b() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(5, r10, null, r11, null, null);
        return;
    }

    public static void writeAsyncLog(int r10, String r11, String r12, long r13, long r14) {
        Log.innerWriteAsyncMsg(level2AlogCoreLevel(r10), r11, r12, r13, r14);
    }

    private static void writeCachedItems(Queue<com.ss.android.agilelogger.e> r10) {
        Iterator<com.ss.android.agilelogger.e> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        com.ss.android.agilelogger.e r12 = r11.next();
        if (checkPrioAndTag(r12.f7844a, r12.f7845b) == false) goto L4;
        handleItemMsg(r12);
        Log.innerWrite(level2AlogCoreLevel(r12.f7844a), r12.f7845b, r12.f7846c);
        goto L4
    }
}
