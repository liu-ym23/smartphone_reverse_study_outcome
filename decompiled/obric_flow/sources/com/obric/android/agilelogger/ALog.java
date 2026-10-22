package com.obric.android.agilelogger;

import ai.j0;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import androidx.profileinstaller.ProfileVerifier;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
import androidx.room.solver.CodeGenScope;
import androidx.room.writer.DaoWriter;
import bp.a;
import com.lynx.tasm.behavior.utils.d;
import com.obric.android.agilelogger.utils.FormatUtils$TYPE;
import com.obric.android.alog.Alog;
import com.obric.android.alog.e;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import l9.p;
import mn.h;
import so.b;
import so.c;
import so.f;
import so.g;
import so.i;
import so.j;
import so.k;
import so.l;

/* JADX INFO: loaded from: classes2.dex */
public class ALog {
    private static final int MSG_ASYNC_FLUSH = 2;
    private static final int MSG_ASYNC_LOG = 1;
    private static volatile Set<String> mBlockTagSet = null;
    private static Alog mainThreadRef = null;
    private static int prio = 3;
    private static Handler sAsyncHandler = null;
    private static HandlerThread sAsyncLogThread = null;
    public static i sConfig = null;
    private static volatile boolean sDebug = false;
    private static volatile j sILogCacheCallback = null;
    private static volatile List<k> sINativeFuncAddrCallbackList = null;
    private static Object sInitLock = null;
    private static volatile boolean sInitSuccess = false;
    private static boolean sInitialized;
    private static ScheduledExecutorService sOuterExecutorService;
    private static ExecutorService sSingleThreadExecutor;
    private static ArrayList<WeakReference<Alog>> sStandaloneInstances;
    private static final ThreadLocal<Long> sThreadId = null;

    static {
        sINativeFuncAddrCallbackList = new ArrayList();
        sOuterExecutorService = null;
        mainThreadRef = null;
        sStandaloneInstances = new ArrayList();
        sSingleThreadExecutor = null;
        sInitialized = false;
        sInitLock = new Object();
        sThreadId = new c(0);
    }

    public ALog() {
    }

    public static /* synthetic */ void access$000(f r5) {
        handleAsyncLog(r5);
    }

    public static /* synthetic */ void access$100(Queue r5) {
        writeCachedItems(r5);
    }

    public static /* synthetic */ j access$200() {
        return null;
    }

    public static /* synthetic */ void access$300(String r5, String r10) {
        removeLegacyFiles(r5, r10);
    }

    public static /* synthetic */ int access$400(int r5) {
        return level2AlogCoreLevel(r5);
    }

    public static void addMessageInterceptor(e r5) {
        Alog.addMessageInterceptor(r5);
    }

    public static void addNativeFuncAddrCallback(k r5) {
        sINativeFuncAddrCallbackList.add(r5);
    }

    public static void asyncFlush() {
        ExecutorService r5 = sSingleThreadExecutor;
        if (r5 == null) goto L5;
        r5.execute(new so.e(0));
    L8:
        h.h();
        Alog r10 = mainThreadRef;
        if (r10 == null) goto L11;
        r10.asyncFlush();
    L11:
        Iterator<WeakReference<Alog>> r11 = sStandaloneInstances.iterator();
    L13:
        if (r11.hasNext() == false) goto L20;
        WeakReference<Alog> r12 = r11.next();
        if (r12 == null) goto L13;
        Alog r13 = r12.get();
        if (r13 == null) goto L13;
        r13.asyncFlush();
        goto L13
    L20:
        return;
    L5:
        Handler r14 = sAsyncHandler;
        if (r14 == null) goto L8;
        r14.sendEmptyMessage(2);
        goto L8
    }

    public static void bundle(int r10, String r11, Bundle r12) {
        if (checkPrioAndTag(r10, r11) == false) goto L21;
        boolean r5 = kn.e.g();
        if (r5 == true) goto L7;
    L10:
        if (r5 == true) goto L12;
    L15:
        int r13 = level2AlogCoreLevel(r10);
        String r14 = a.b(FormatUtils$TYPE.BUNDLE, r12);
        Alog r15 = mainThreadRef;
        if (r15 == null) goto L19;
        if (r5 == false) goto L19;
        r15.write(r13, r11, r14);
        return;
    L19:
        h.l(r13, r11, r14);
        return;
    L12:
        if (sAsyncHandler == null) goto L15;
        postAsyncLog(r10, r11, null, null, FormatUtils$TYPE.BUNDLE, r12);
        return;
    L7:
        if (sSingleThreadExecutor == null) goto L10;
        postAsyncLogByThreadPool(r10, r11, null, null, FormatUtils$TYPE.BUNDLE, r12);
        return;
    }

    public static void changeLevel(int r5) {
        prio = r5;
        int r10 = level2AlogCoreLevel(r5);
        Alog r11 = h.f;
        if (r11 == null) goto L5;
        r11.setLevel(r10);
    L5:
        Alog r12 = mainThreadRef;
        if (r12 == null) goto L9;
        r12.setLevel(level2AlogCoreLevel(r5));
        return;
    }

    public static boolean checkPrioAndTag(int r5, String r10) {
        if (r5 >= prio) goto L5;
        return false;
    L5:
        Set<String> r11 = mBlockTagSet;
        if (r11 != null) goto L8;
        return true;
    L8:
        if (TextUtils.isEmpty(r10) == false) goto L10;
        return true;
    L10:
        if (r11.contains(r10) == false) goto L15;
        return false;
    L15:
        return true;
    }

    public static g createInstance(String r5, Context r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return createInstance(r5, new so.h(r10).a());
    }

    public static void d(String r5, String r10) {
        if (checkPrioAndTag(3, r5) == false) goto L21;
        boolean r11 = kn.e.g();
        if (r11 == true) goto L7;
    L10:
        if (r11 == true) goto L12;
    L15:
        Alog r12 = mainThreadRef;
        if (r12 == null) goto L19;
        if (r11 == false) goto L19;
        r12.d(r5, r10);
        return;
    L19:
        h.q(1, r5, r10);
        return;
    L12:
        if (sAsyncHandler == null) goto L15;
        postAsyncLog(3, r5, r10);
        return;
    L7:
        if (sSingleThreadExecutor == null) goto L10;
        postAsyncLogByThreadPool(3, r5, r10);
        return;
    }

    public static void destroy() {
        Alog.nativeSetDefaultInstance(0);
        h.f.close();
        h.f = null;
        Alog r5 = mainThreadRef;
        if (r5 == null) goto L6;
        r5.close();
    L6:
        if (sAsyncHandler == null) goto L8;
        sAsyncLogThread.quit();
        sAsyncLogThread = null;
        sAsyncHandler = null;
    L8:
        ExecutorService r10 = sSingleThreadExecutor;
        if (r10 == null) goto L12;
        r10.shutdown();
        sSingleThreadExecutor = null;
        return;
    }

    public static void e(String r5, String r10) {
        if (checkPrioAndTag(6, r5) == false) goto L21;
        boolean r11 = kn.e.g();
        if (r11 == true) goto L7;
    L10:
        if (r11 == true) goto L12;
    L15:
        Alog r12 = mainThreadRef;
        if (r12 == null) goto L19;
        if (r11 == false) goto L19;
        r12.e(r5, r10);
        return;
    L19:
        h.q(4, r5, r10);
        return;
    L12:
        if (sAsyncHandler == null) goto L15;
        postAsyncLog(6, r5, r10);
        return;
    L7:
        if (sSingleThreadExecutor == null) goto L10;
        postAsyncLogByThreadPool(6, r5, r10);
        return;
    }

    @Deprecated
    public static void flush() {
        ExecutorService r5 = sSingleThreadExecutor;
        if (r5 == null) goto L5;
        r5.execute(new com.bytedance.android.anniex.worker.a(29));
    L5:
        Handler r10 = sAsyncHandler;
        if (r10 == null) goto L8;
        r10.sendEmptyMessage(2);
    L8:
        h.h();
        Alog r11 = mainThreadRef;
        if (r11 == null) goto L12;
        r11.asyncFlush();
        return;
    }

    @Deprecated
    public static void forceLogSharding() {
    }

    public static List<String> getALogFiles(long r10, long r12) {
        ArrayList r5 = new ArrayList();
        long r11 = r10 * 1000;
        long r13 = r12 * 1000;
        Alog r14 = h.f;     // Catch: Exception -> L12
        int r15 = 0;
        if (r14 == null) goto L6;
        File[] r16 = r14.getLogs(null, null, r11, r13);     // Catch: Exception -> L12
    L7:
        int r17 = r16.length;     // Catch: Exception -> L12
    L8:
        if (r15 >= r17) goto L11;
        r5.add(r16[r15].getAbsolutePath());     // Catch: Exception -> L12
        r15 = r15 + 1;
        goto L8
    L6:
        r16 = new File[0];     // Catch: Exception -> L12
    L11:
        return r5;
    }

    public static long getALogSimpleWriteFuncAddr() {
        Alog r5 = h.f;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.getNativeWriteFuncAddr();
    }

    public static long getALogWriteFuncAddr() {
        Alog r5 = h.f;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.getLegacyWriteFuncAddr();
    }

    public static long getAlogNativeFlushV2FuncAddr() {
        Alog r5 = h.f;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.getLegacyFlushFuncAddr();
    }

    public static long getAlogNativeLogStoreDirFuncAddr() {
        Alog r5 = h.f;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.getLegacyGetLogFileDirFuncAddr();
    }

    public static Set<String> getBlockTagSet() {
        return mBlockTagSet;
    }

    public static HashMap<String, String> getLastFetchErrorInfo() {
        Alog r5 = h.f;
        if (r5 != null) goto L7;
        HashMap<String, String> r10 = new HashMap();
        r10.put("reason", "Log.instance does not exist");
        return r10;
    L7:
        return r5.getLastFetchErrorInfo();
    }

    public static List<k> getNativeFuncAddrCallbackList() {
        return sINativeFuncAddrCallbackList;
    }

    public static String getStatus() {
        Alog r5 = h.f;     // Catch: Exception -> L7
        if (r5 == null) goto L5;
        return r5.getStatus();
    L5:
        return "default log instance is null";
    L7:
        return "getStatus exception";
    }

    private static long getThreadId() {
        return sThreadId.get().longValue();
    }

    private static void handleAsyncLog(f r10) {
        int r5 = level2AlogCoreLevel(r10.f21972a);
        String r11 = "";
        FormatUtils$TYPE r12 = r10.e;
        if (r12 == null) goto L5;
        FormatUtils$TYPE r13 = FormatUtils$TYPE.BORDER;
        if (r12 != r13) goto L16;
        r11 = a.c(r13, r10.f21974c);
    L7:
        String r14 = r11;
        String r15 = r10.f21973b;
        long r16 = r10.g;
        long r17 = r10.f21975h;
        Alog r18 = h.f;
        if (r18 == null) goto L37;
        r18.writeAsyncMsg(r5, r15, r14, r16, r17);
    L37:
        r10.f21973b = null;
        r10.f21974c = null;
        r10.d = null;
        r10.e = null;
        r10.f = null;
        r10.g = -1;
        r10.f21975h = 0;
        r10.f21976i = null;
        Object r19 = f.f21969j;
        monitor-enter(r19);
        int r20 = f.f21971l;     // Catch: Throwable -> L42
        if (r20 >= 50) goto L44;
        r10.f21976i = f.f21970k;     // Catch: Throwable -> L42
        f.f21970k = r10;     // Catch: Throwable -> L42
        f.f21971l = r20 + 1;     // Catch: Throwable -> L42
    L44:
        monitor-exit(r19);     // Catch: Throwable -> L42
        return;
    L42:
        th = move-exception;
        throw th;
    L16:
        FormatUtils$TYPE r21 = FormatUtils$TYPE.JSON;
        if (r12 != r21) goto L19;
        r11 = a.c(r21, r10.f21974c);
        goto L7
    L19:
        FormatUtils$TYPE r22 = FormatUtils$TYPE.BUNDLE;
        if (r12 != r22) goto L22;
        r11 = a.b(r22, (Bundle) r10.f);
        goto L7
    L22:
        FormatUtils$TYPE r23 = FormatUtils$TYPE.INTENT;
        if (r12 != r23) goto L25;
        r11 = a.a(r23, (Intent) r10.f);
        goto L7
    L25:
        FormatUtils$TYPE r24 = FormatUtils$TYPE.THROWABLE;
        if (r12 != r24) goto L28;
        Throwable r25 = (Throwable) r10.f;
        r11 = ((to.a) a.f966a.get(r24)).a(r25);
        goto L7
    L28:
        FormatUtils$TYPE r26 = FormatUtils$TYPE.THREAD;
        if (r12 != r26) goto L31;
        Thread r27 = (Thread) r10.f;
        r11 = ((to.a) a.f966a.get(r26)).a(r27);
        goto L7
    L31:
        FormatUtils$TYPE r28 = FormatUtils$TYPE.STACKTRACE;
        if (r12 != r28) goto L7;
        StackTraceElement[] r29 = (StackTraceElement[]) r10.f;
        r11 = ((to.a) a.f966a.get(r28)).a(r29);
        goto L7
    L5:
        if (r10.d != null) goto L9;
        r11 = r10.f21974c;
        goto L7
    L9:
        if (r10.f21974c != null) goto L11;
        String r30 = "";
    L12:
        StringBuilder r31 = j0.u(r30);
        r31.append(d.l(r10.d));
        r11 = r31.toString();
        goto L7
    L11:
        r30 = j0.q(new StringBuilder(), r10.f21974c, "\n");
        goto L12
    }

    private static void handleItemMsg(l r5) {
        int[] r10 = b.f21964a;
        throw null;
    }

    public static void header(int r10, String r11, String r12) {
        if (checkPrioAndTag(r10, r11) == false) goto L21;
        boolean r5 = kn.e.g();
        if (r5 == true) goto L7;
    L10:
        if (r5 == true) goto L12;
    L15:
        int r13 = level2AlogCoreLevel(r10);
        String r14 = a.c(FormatUtils$TYPE.BORDER, r12);
        Alog r15 = mainThreadRef;
        if (r15 == null) goto L19;
        if (r5 == false) goto L19;
        r15.write(r13, r11, r14);
        return;
    L19:
        h.l(r13, r11, r14);
        return;
    L12:
        if (sAsyncHandler == null) goto L15;
        postAsyncLog(r10, r11, r12, null, FormatUtils$TYPE.BORDER, null);
        return;
    L7:
        if (sSingleThreadExecutor == null) goto L10;
        postAsyncLogByThreadPool(r10, r11, r12, null, FormatUtils$TYPE.BORDER, null);
        return;
    }

    public static void i(String r5, String r10) {
        if (checkPrioAndTag(4, r5) == false) goto L21;
        boolean r11 = kn.e.g();
        if (r11 == true) goto L7;
    L10:
        if (r11 == true) goto L12;
    L15:
        Alog r12 = mainThreadRef;
        if (r12 == null) goto L19;
        if (r11 == false) goto L19;
        r12.i(r5, r10);
        return;
    L19:
        h.q(2, r5, r10);
        return;
    L12:
        if (sAsyncHandler == null) goto L15;
        postAsyncLog(4, r5, r10);
        return;
    L7:
        if (sSingleThreadExecutor == null) goto L10;
        postAsyncLogByThreadPool(4, r5, r10);
        return;
    }

    public static boolean init(i r11) {
        boolean r5 = false;
        if (r11 != null) goto L5;
        return false;
    L5:
        sConfig = r11;
        Alog.init(new com.lynx.tasm.utils.c(16));     // Catch: Throwable -> L97
        Object r10 = sInitLock;
        monitor-enter(r10);
    L13:
        th = move-exception;
        throw th;
    L10:
        if (sInitialized == false) goto L15;
        monitor-exit(r10);     // Catch: Throwable -> L13
        return false;
    L15:
        sInitialized = true;     // Catch: Throwable -> L13
        monitor-exit(r10);     // Catch: Throwable -> L13
        prio = r11.f21985i;
        Context r12 = r11.f21981a;
        String r13 = Application.getProcessName();
        if (r13 != null) goto L21;
    L19:
        boolean r14 = false;
    L29:
        boolean r15 = r11.f21988l;
        if (r15 == false) goto L32;
    L35:
        if (r14 == true) goto L37;
        r11.f21983c = (int) (r11.f21983c * r11.f21990n);
    L37:
        com.obric.android.alog.b r16 = new com.obric.android.alog.b(r11.f21981a);
        r16.b("default");
        r16.f11230b = level2AlogCoreLevel(r11.f21985i);
        r16.f11231c = sDebug;
        r16.e = r11.f;
        r16.f = r11.d;
        if (r5 == false) goto L40;
        int r17 = (r11.f21983c / 3) * 2;
    L41:
        r16.g = r17;
        r16.f11232h = r11.f21982b;
        r16.f11233i = r11.e;
        if (r14 == false) goto L44;
        int r18 = r11.f21989m * 1024;
    L45:
        r16.f11234j = r18;
        if (r14 == false) goto L48;
        int r19 = r11.f21989m * 3072;
    L49:
        r16.f11235k = r19;
        Alog.Mode r20 = Alog.Mode.SAFE;
        r16.f11237m = r20.getValue();
        Alog.TimeFormat r21 = Alog.TimeFormat.RAW;
        r16.f11238n = r21.getValue();
        Alog.PrefixFormat r22 = Alog.PrefixFormat.LEGACY;
        r16.f11239o = r22.getValue();
        if (r11.g == false) goto L52;
        Alog.Compress r23 = Alog.Compress.ZSTD;
    L53:
        r16.f11240p = r23.getValue();
        if (r11.f21984h == false) goto L56;
        Alog.SymCrypt r24 = Alog.SymCrypt.TEA_16;
    L57:
        r16.f11241q = r24.getValue();
        if (r11.f21984h == false) goto L60;
        Alog.AsymCrypt r25 = Alog.AsymCrypt.EC_SECP256K1;
    L61:
        r16.f11242r = r25.getValue();
        r16.s = r11.f21986j;
        Alog r26 = r16.a();
        h.f = r26;
        if (r26 != null) goto L64;
        long r27 = 0;
    L65:
        Alog.nativeSetDefaultInstance(r27);
        if (r15 == false) goto L69;
        if (r14 == false) goto L69;
        HandlerThread r28 = new HandlerThread("Alog_main_delegate");
        sAsyncLogThread = r28;
        r28.start();
        sAsyncHandler = new am.b(sAsyncLogThread.getLooper(), 2);
    L69:
        if (r5 == false) goto L83;
        com.obric.android.alog.b r29 = new com.obric.android.alog.b(r11.f21981a);
        r29.b(JvmProtoBufUtil.DEFAULT_MODULE_NAME);
        r29.f11230b = level2AlogCoreLevel(r11.f21985i);
        r29.f11231c = sDebug;
        r29.e = r11.f;
        r29.f = r11.d / 2;
        r29.g = r11.f21983c / 3;
        r29.f11232h = r11.f21982b;
        r29.f11233i = r11.e;
        r29.f11234j = 32768;
        r29.f11235k = 98304;
        r29.f11237m = r20.getValue();
        r29.f11238n = r21.getValue();
        r29.f11239o = r22.getValue();
        if (r11.g == false) goto L73;
        Alog.Compress r30 = Alog.Compress.ZSTD;
    L74:
        r29.f11240p = r30.getValue();
        if (r11.f21984h == false) goto L77;
        Alog.SymCrypt r31 = Alog.SymCrypt.TEA_16;
    L78:
        r29.f11241q = r31.getValue();
        if (r11.f21984h == false) goto L81;
        Alog.AsymCrypt r32 = Alog.AsymCrypt.EC_SECP256K1;
    L82:
        r29.f11242r = r32.getValue();
        r29.s = r11.f21986j;
        mainThreadRef = r29.a();
        goto L83
    L81:
        r32 = Alog.AsymCrypt.NONE;
        goto L82
    L77:
        r31 = Alog.SymCrypt.NONE;
        goto L78
    L73:
        r30 = Alog.Compress.NONE;
    L83:
        String r33 = r11.e;
        String r110 = r11.f;
        if (getNativeFuncAddrCallbackList().size() <= 0) goto L89;
        hf.d r34 = new hf.d(r33, r110, 1);
        ScheduledExecutorService r111 = sOuterExecutorService;
        if (r111 != null) goto L88;
        new Thread(r34, "_ALOG_OPT_").start();
    L93:
        sInitSuccess = true;
        return true;
    L88:
        r111.execute(r34);
        goto L93
    L89:
        ScheduledExecutorService r35 = sOuterExecutorService;
        if (r35 != null) goto L92;
        new Timer("_ALOG_OPT_").schedule(new so.d(r33, r110), 15000);
        goto L93
    L92:
        r35.schedule(new hf.d(r33, r110, 2), 15, TimeUnit.SECONDS);
        goto L93
    L64:
        r27 = r26.getNativeRef();
        goto L65
    L60:
        r25 = Alog.AsymCrypt.NONE;
        goto L61
    L56:
        r24 = Alog.SymCrypt.NONE;
        goto L57
    L52:
        r23 = Alog.Compress.NONE;
        goto L53
    L48:
        r19 = 65536;
        goto L49
    L44:
        r18 = 32768;
        goto L45
    L40:
        r17 = r11.f21983c;
        goto L41
    L32:
        if (r11.f21987k == false) goto L35;
        if (r14 == false) goto L35;
        r5 = true;
        goto L35
    L21:
        if (r13.contains(":") == true) goto L19;
        if (r13.equals(r12.getPackageName()) == false) goto L27;
    L25:
        r14 = true;
        goto L29
    L27:
        if (r13.equals(r12.getApplicationInfo().processName) == false) goto L19;
    L97:
        return false;
    }

    public static void intent(int r10, String r11, Intent r12) {
        if (checkPrioAndTag(r10, r11) == false) goto L21;
        boolean r5 = kn.e.g();
        if (r5 == true) goto L7;
    L10:
        if (r5 == true) goto L12;
    L15:
        int r13 = level2AlogCoreLevel(r10);
        String r14 = a.a(FormatUtils$TYPE.INTENT, r12);
        Alog r15 = mainThreadRef;
        if (r15 == null) goto L19;
        if (r5 == false) goto L19;
        r15.write(r13, r11, r14);
        return;
    L19:
        h.l(r13, r11, r14);
        return;
    L12:
        if (sAsyncHandler == null) goto L15;
        postAsyncLog(r10, r11, null, null, FormatUtils$TYPE.INTENT, r12);
        return;
    L7:
        if (sSingleThreadExecutor == null) goto L10;
        postAsyncLogByThreadPool(r10, r11, null, null, FormatUtils$TYPE.INTENT, r12);
        return;
    }

    public static boolean isInitSuccess() {
        return sInitSuccess;
    }

    public static void json(int r10, String r11, String r12) {
        if (checkPrioAndTag(r10, r11) == false) goto L21;
        boolean r5 = kn.e.g();
        if (r5 == true) goto L7;
    L10:
        if (r5 == true) goto L12;
    L15:
        int r13 = level2AlogCoreLevel(r10);
        String r14 = a.c(FormatUtils$TYPE.JSON, r12);
        Alog r15 = mainThreadRef;
        if (r15 == null) goto L19;
        if (r5 == false) goto L19;
        r15.write(r13, r11, r14);
        return;
    L19:
        h.l(r13, r11, r14);
        return;
    L12:
        if (sAsyncHandler == null) goto L15;
        postAsyncLog(r10, r11, r12, null, FormatUtils$TYPE.JSON, null);
        return;
    L7:
        if (sSingleThreadExecutor == null) goto L10;
        postAsyncLogByThreadPool(r10, r11, r12, null, FormatUtils$TYPE.JSON, null);
        return;
    }

    private static int level2AlogCoreLevel(int r5) {
        return r5 - 2;
    }

    private static void postAsyncLog(int r10, String r11, String r12) {
        postAsyncLog(r10, r11, r12, null, null, null);
    }

    private static void postAsyncLogByThreadPool(int r10, String r11, String r12) {
        postAsyncLogByThreadPool(r10, r11, r12, null, null, null);
    }

    public static void println(int r5, String r10, Object r11, FormatUtils$TYPE r12) {
        if (checkPrioAndTag(r5, r10) == false) goto L33;
        int r13 = level2AlogCoreLevel(r5);
        switch(b.f21964a[r12.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
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
        String r14 = "";
    L16:
        boolean r15 = kn.e.g();
        if (r15 == true) goto L19;
    L22:
        if (r15 == true) goto L24;
    L27:
        Alog r16 = mainThreadRef;
        if (r16 == null) goto L31;
        if (r15 == false) goto L31;
        r16.write(r13, r10, r14);
        return;
    L31:
        h.l(r13, r10, r14);
        return;
    L24:
        if (sAsyncHandler == null) goto L27;
        postAsyncLog(r5, r10, r14);
        return;
    L19:
        if (sSingleThreadExecutor == null) goto L22;
        postAsyncLogByThreadPool(r5, r10, r14);
        return;
    L7:
        FormatUtils$TYPE r17 = FormatUtils$TYPE.STACKTRACE;
        to.a r18 = (to.a) a.f966a.get(r17);
        r14 = r18.a((StackTraceElement[]) r11);
        goto L16
    L8:
        FormatUtils$TYPE r19 = FormatUtils$TYPE.THREAD;
        to.a r20 = (to.a) a.f966a.get(r19);
        r14 = r20.a((Thread) r11);
        goto L16
    L9:
        FormatUtils$TYPE r21 = FormatUtils$TYPE.THROWABLE;
        to.a r22 = (to.a) a.f966a.get(r21);
        r14 = r22.a((Throwable) r11);
        goto L16
    L10:
        r14 = a.a(FormatUtils$TYPE.INTENT, (Intent) r11);
        goto L16
    L11:
        r14 = a.b(FormatUtils$TYPE.BUNDLE, (Bundle) r11);
        goto L16
    L12:
        r14 = a.c(FormatUtils$TYPE.JSON, (String) r11);
        goto L16
    L13:
        r14 = a.c(FormatUtils$TYPE.BORDER, (String) r11);
        goto L16
    L14:
        r14 = d.l((Throwable) r11);
        goto L16
    L15:
        r14 = (String) r11;
        goto L16
    }

    public static void release() {
        Alog.nativeSetDefaultInstance(0);
        h.f.close();
        h.f = null;
        Alog r5 = mainThreadRef;
        if (r5 == null) goto L6;
        r5.close();
    L6:
        if (sAsyncHandler == null) goto L8;
        sAsyncLogThread.quit();
        sAsyncLogThread = null;
        sAsyncHandler = null;
    L8:
        ExecutorService r10 = sSingleThreadExecutor;
        if (r10 == null) goto L12;
        r10.shutdown();
        sSingleThreadExecutor = null;
        return;
    }

    private static void removeLegacyFiles(String r5, String r10) {
        File r11 = new File(r5);
        int r12 = 0;
        if (r11.exists() == false) goto L9;
        File[] r13 = r11.listFiles(new p(2));
        if (r13 == null) goto L9;
        int r14 = r13.length;
        int r15 = 0;
    L7:
        if (r15 >= r14) goto L9;
        r13[r15].delete();
        r15 = r15 + 1;
    L9:
        File r16 = new File(r10);
        if (r16.exists() == false) goto L16;
        File[] r17 = r16.listFiles(new p(3));
        if (r17 == null) goto L19;
        int r18 = r17.length;
    L14:
        if (r12 >= r18) goto L20;
        r17[r12].delete();
        r12 = r12 + 1;
        goto L14
    L20:
        return;
    L19:
        return;
    }

    public static void removeMessageInterceptor(e r5) {
        Alog.removeMessageInterceptor(r5);
    }

    public static void removeObsoleteInstance(String r10, Context r11, boolean r12) {
        String r5 = Application.getProcessName();
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.contains(":") == false) goto L8;
        return;
    L8:
        if (r12 == true) goto L11;
        r5 = r5.concat(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
    L11:
        i r13 = sConfig;
        if (r13 == null) goto L14;
        String r14 = r13.f;
        String r15 = r13.e;
    L18:
        File r16 = new File(r14);
        if (r16.exists() == true) goto L21;
        return;
    L21:
        if (r16.isDirectory() == false) goto L60;
        String r17 = j0.k(CodeGenScope.CLASS_PROPERTY_PREFIX, r10, ".olog");
        File[] r18 = r16.listFiles();
        int r19 = r18.length;
        int r20 = 0;
        int r21 = 0;
    L24:
        if (r21 >= r19) goto L33;
        File r22 = r18[r21];
        String r23 = r22.getName();
        if (r23 == null) goto L32;
        if (r23.endsWith(r17) == false) goto L32;
        if (r23.contains(r5) == false) goto L32;
        r22.delete();
    L32:
        r21 = r21 + 1;
        goto L24
    L33:
        File r24 = new File(r15);
        if (r24.exists() == true) goto L36;
        return;
    L36:
        if (r24.isDirectory() == false) goto L61;
        String r110 = j0.C(CodeGenScope.CLASS_PROPERTY_PREFIX, r10);
        File[] r111 = r24.listFiles();
        int r112 = r111.length;
    L39:
        if (r20 >= r112) goto L62;
        File r25 = r111[r20];
        String r26 = r25.getName();
        if (r26 == null) goto L47;
        if (r26.contains(r110) == false) goto L47;
        if (r26.contains(r5) == false) goto L47;
        r25.delete();
    L47:
        r20 = r20 + 1;
        goto L39
    L62:
        return;
    L61:
        return;
    L60:
        return;
    L14:
        File r113 = new File(r11.getFilesDir(), "ologs");
        if (r113.exists() == true) goto L17;
        r113.mkdir();
    L17:
        String r114 = r113.getAbsolutePath();
        r15 = com.lynx.tasm.behavior.ui.utils.e.n(r11);
        r14 = r114;
        goto L18
    }

    public static void setBlockTagSet(Set<String> r5) {
        mBlockTagSet = Collections.unmodifiableSet(r5);
    }

    public static void setDebug(boolean r5) {
        sDebug = r5;
        boolean r10 = sDebug;
        Alog r11 = h.f;
        if (r11 == null) goto L5;
        r11.setSyslog(r10);
    L5:
        Alog r12 = mainThreadRef;
        if (r12 == null) goto L9;
        r12.setSyslog(sDebug);
        return;
    }

    public static void setILogCacheCallback(j r5) {
    }

    public static void setOuterExecutorService(ScheduledExecutorService r5) {
        sOuterExecutorService = r5;
    }

    @Deprecated
    public static void setPrintStackTrace(boolean r5) {
    }

    @Deprecated
    public static void setsPackageClassName(String r5) {
    }

    public static void stacktrace(int r10, String r11, StackTraceElement[] r12) {
        if (checkPrioAndTag(r10, r11) == false) goto L21;
        boolean r5 = kn.e.g();
        if (r5 == true) goto L7;
    L10:
        if (r5 == true) goto L12;
    L15:
        int r13 = level2AlogCoreLevel(r10);
        FormatUtils$TYPE r14 = FormatUtils$TYPE.STACKTRACE;
        String r15 = ((to.a) a.f966a.get(r14)).a(r12);
        Alog r16 = mainThreadRef;
        if (r16 == null) goto L19;
        if (r5 == false) goto L19;
        r16.write(r13, r11, r15);
        return;
    L19:
        h.l(r13, r11, r15);
        return;
    L12:
        if (sAsyncHandler == null) goto L15;
        postAsyncLog(r10, r11, null, null, FormatUtils$TYPE.STACKTRACE, r12);
        return;
    L7:
        if (sSingleThreadExecutor == null) goto L10;
        postAsyncLogByThreadPool(r10, r11, null, null, FormatUtils$TYPE.STACKTRACE, r12);
        return;
    }

    public static void statcktrace(int r5, String r10, StackTraceElement[] r11) {
        stacktrace(r5, r10, r11);
    }

    public static void syncFlush() {
        ExecutorService r5 = sSingleThreadExecutor;
        if (r5 == null) goto L5;
        r5.execute(new com.bytedance.android.anniex.worker.a(27));
    L5:
        Handler r10 = sAsyncHandler;
        if (r10 == null) goto L8;
        r10.sendEmptyMessage(2);
    L8:
        Alog r11 = h.f;
        if (r11 == null) goto L11;
        r11.syncFlush();
    L11:
        Alog r12 = mainThreadRef;
        if (r12 == null) goto L14;
        r12.syncFlush();
    L14:
        Iterator<WeakReference<Alog>> r13 = sStandaloneInstances.iterator();
    L16:
        if (r13.hasNext() == false) goto L20;
        Alog r14 = r13.next().get();
        if (r14 == null) goto L16;
        r14.syncFlush();
        goto L16
    }

    public static void thread(int r10, String r11, Thread r12) {
        if (checkPrioAndTag(r10, r11) == false) goto L21;
        boolean r5 = kn.e.g();
        if (r5 == true) goto L7;
    L10:
        if (r5 == true) goto L12;
    L15:
        int r13 = level2AlogCoreLevel(r10);
        FormatUtils$TYPE r14 = FormatUtils$TYPE.THREAD;
        String r15 = ((to.a) a.f966a.get(r14)).a(r12);
        Alog r16 = mainThreadRef;
        if (r16 == null) goto L19;
        if (r5 == false) goto L19;
        r16.write(r13, r11, r15);
        return;
    L19:
        h.l(r13, r11, r15);
        return;
    L12:
        if (sAsyncHandler == null) goto L15;
        postAsyncLog(r10, r11, null, null, FormatUtils$TYPE.THREAD, r12);
        return;
    L7:
        if (sSingleThreadExecutor == null) goto L10;
        postAsyncLogByThreadPool(r10, r11, null, null, FormatUtils$TYPE.THREAD, r12);
        return;
    }

    public static void throwable(int r10, String r11, Throwable r12) {
        if (checkPrioAndTag(r10, r11) == false) goto L21;
        boolean r5 = kn.e.g();
        if (r5 == true) goto L7;
    L10:
        if (r5 == true) goto L12;
    L15:
        int r13 = level2AlogCoreLevel(r10);
        FormatUtils$TYPE r14 = FormatUtils$TYPE.THROWABLE;
        String r15 = ((to.a) a.f966a.get(r14)).a(r12);
        Alog r16 = mainThreadRef;
        if (r16 == null) goto L19;
        if (r5 == false) goto L19;
        r16.write(r13, r11, r15);
        return;
    L19:
        h.l(r13, r11, r15);
        return;
    L12:
        if (sAsyncHandler == null) goto L15;
        postAsyncLog(r10, r11, null, null, FormatUtils$TYPE.THROWABLE, r12);
        return;
    L7:
        if (sSingleThreadExecutor == null) goto L10;
        postAsyncLogByThreadPool(r10, r11, null, r12, FormatUtils$TYPE.THROWABLE, null);
        return;
    }

    public static void timedSyncFlush(int r5) {
        ExecutorService r10 = sSingleThreadExecutor;
        if (r10 == null) goto L5;
        r10.execute(new com.bytedance.android.anniex.worker.a(28));
    L5:
        Handler r11 = sAsyncHandler;
        if (r11 == null) goto L8;
        r11.sendEmptyMessage(2);
    L8:
        Alog r12 = h.f;
        if (r12 == null) goto L11;
        r12.timedSyncFlush(r5);
    L11:
        Alog r13 = mainThreadRef;
        if (r13 == null) goto L14;
        r13.timedSyncFlush(r5);
    L14:
        Iterator<WeakReference<Alog>> r14 = sStandaloneInstances.iterator();
    L16:
        if (r14.hasNext() == false) goto L20;
        Alog r15 = r14.next().get();
        if (r15 == null) goto L16;
        r15.timedSyncFlush(r5);
        goto L16
    }

    public static void v(String r5, String r10) {
        if (checkPrioAndTag(2, r5) == false) goto L21;
        boolean r11 = kn.e.g();
        if (r11 == true) goto L7;
    L10:
        if (r11 == true) goto L12;
    L15:
        Alog r12 = mainThreadRef;
        if (r12 == null) goto L19;
        if (r11 == false) goto L19;
        r12.v(r5, r10);
        return;
    L19:
        h.q(0, r5, r10);
        return;
    L12:
        if (sAsyncHandler == null) goto L15;
        postAsyncLog(2, r5, r10);
        return;
    L7:
        if (sSingleThreadExecutor == null) goto L10;
        postAsyncLogByThreadPool(2, r5, r10);
        return;
    }

    public static void w(String r5, String r10) {
        if (checkPrioAndTag(5, r5) == false) goto L21;
        boolean r11 = kn.e.g();
        if (r11 == true) goto L7;
    L10:
        if (r11 == true) goto L12;
    L15:
        Alog r12 = mainThreadRef;
        if (r12 == null) goto L19;
        if (r11 == false) goto L19;
        r12.w(r5, r10);
        return;
    L19:
        h.q(3, r5, r10);
        return;
    L12:
        if (sAsyncHandler == null) goto L15;
        postAsyncLog(5, r5, r10);
        return;
    L7:
        if (sSingleThreadExecutor == null) goto L10;
        postAsyncLogByThreadPool(5, r5, r10);
        return;
    }

    public static void writeAsyncLog(int r10, String r11, String r12, long r13, long r14) {
        int r5 = level2AlogCoreLevel(r10);
        Alog r15 = h.f;
        if (r15 == null) goto L6;
        r15.writeAsyncMsg(r5, r11, r12, r13, r14);
        return;
    }

    private static void writeCachedItems(Queue<l> r5) {
        Iterator<l> r10 = r5.iterator();
        if (r10.hasNext() == true) goto L5;
        return;
    L5:
        j0.A(r10.next());
        throw null;
    }

    public static g createInstance(String r5, i r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (sInitSuccess == false) goto L35;
    L10:
        com.obric.android.alog.b r11 = new com.obric.android.alog.b(r10.f21981a);
        r11.b(r5);
        r11.f11230b = level2AlogCoreLevel(r10.f21985i);
        r11.f11231c = sDebug;
        i r12 = sConfig;
        if (r12 == null) goto L13;
        String r13 = r12.f;
    L14:
        r11.e = r13;
        r11.f = r10.d;
        r11.g = r10.f21983c;
        r11.f11232h = r10.f21982b;
        if (r12 == null) goto L17;
        String r14 = r12.e;
    L18:
        r11.f11233i = r14;
        r11.f11234j = 65536;
        r11.f11235k = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        r11.f11237m = Alog.Mode.SAFE.getValue();
        r11.f11238n = Alog.TimeFormat.RAW.getValue();
        r11.f11239o = Alog.PrefixFormat.LEGACY.getValue();
        if (r10.g == false) goto L21;
        Alog.Compress r15 = Alog.Compress.ZSTD;
    L22:
        r11.f11240p = r15.getValue();
        if (r10.f21984h == false) goto L25;
        Alog.SymCrypt r16 = Alog.SymCrypt.TEA_16;
    L26:
        r11.f11241q = r16.getValue();
        if (r10.f21984h == false) goto L29;
        Alog.AsymCrypt r17 = Alog.AsymCrypt.EC_SECP256K1;
    L30:
        r11.f11242r = r17.getValue();
        r11.s = r10.f21986j;
        Alog r18 = r11.a();
        if (r18 != null) goto L33;
        return null;
    L33:
        sStandaloneInstances.add(new WeakReference(r18));
        return new g(r18);
    L29:
        r17 = Alog.AsymCrypt.NONE;
        goto L30
    L25:
        r16 = Alog.SymCrypt.NONE;
        goto L26
    L21:
        r15 = Alog.Compress.NONE;
        goto L22
    L17:
        r14 = r10.e;
        goto L18
    L13:
        r13 = r10.f;
        goto L14
    L35:
        Alog.init(new com.lynx.tasm.utils.c(16));     // Catch: Throwable -> L9
    L9:
        return null;
    }

    private static void postAsyncLog(int r5, String r10, String r11, Throwable r12, FormatUtils$TYPE r13, Object r14) {
        Object r15 = f.f21969j;
        monitor-enter(r15);
        f r16 = f.f21970k;     // Catch: Throwable -> L9
        if (r16 == null) goto L11;
        f.f21970k = r16.f21976i;     // Catch: Throwable -> L9
        r16.f21976i = null;     // Catch: Throwable -> L9
        f.f21971l--;     // Catch: Throwable -> L9
        monitor-exit(r15);     // Catch: Throwable -> L9
    L13:
        r16.f21972a = r5;
        r16.f21973b = r10;
        r16.f21974c = r11;
        r16.d = r12;
        r16.e = r13;
        r16.f = r14;
        r16.g = getThreadId();
        r16.f21975h = System.currentTimeMillis();
        Message r17 = Message.obtain();
        r17.what = 1;
        r17.obj = r16;
        sAsyncHandler.sendMessage(r17);
        return;
    L11:
        monitor-exit(r15);     // Catch: Throwable -> L9
        r16 = new f();
        r16.e = null;
    L9:
        th = move-exception;
        throw th;
    }

    private static void postAsyncLogByThreadPool(int r13, String r14, String r15, Throwable r16, FormatUtils$TYPE r17, Object r18) {
        long r10 = getThreadId();
        long r11 = System.currentTimeMillis();
        sSingleThreadExecutor.execute(new so.a(r13, r17, r16, r15, r18, r14, r10, r11));
    }

    public static List<String> getALogFiles(String r10, String r11, long r12, long r14) {
        ArrayList r5 = new ArrayList();
        long r13 = r12 * 1000;
        long r15 = r14 * 1000;
        Alog r16 = h.f;     // Catch: Exception -> L12
        int r17 = 0;
        if (r16 == null) goto L6;
        File[] r18 = r16.getLogs(r10, r11, r13, r15);     // Catch: Exception -> L12
    L7:
        int r19 = r18.length;     // Catch: Exception -> L12
    L8:
        if (r17 >= r19) goto L11;
        r5.add(r18[r17].getAbsolutePath());     // Catch: Exception -> L12
        r17 = r17 + 1;
        goto L8
    L6:
        r18 = new File[0];     // Catch: Exception -> L12
    L11:
        return r5;
    }

    public static void e(String r10, String r11, Throwable r12) {
        if (checkPrioAndTag(6, r10) == false) goto L21;
        boolean r5 = kn.e.g();
        if (r5 == true) goto L7;
    L10:
        if (r5 == true) goto L12;
    L15:
        StringBuilder r13 = j0.w(r11, "\n");
        r13.append(d.l(r12));
        String r14 = r13.toString();
        Alog r15 = mainThreadRef;
        if (r15 == null) goto L19;
        if (r5 == false) goto L19;
        r15.e(r10, r14);
        return;
    L19:
        h.q(4, r10, r14);
        return;
    L12:
        if (sAsyncHandler == null) goto L15;
        postAsyncLog(6, r10, r11, r12, null, null);
        return;
    L7:
        if (sSingleThreadExecutor == null) goto L10;
        postAsyncLogByThreadPool(6, r10, r11, r12, null, null);
        return;
    }

    public static void w(String r10, String r11, Throwable r12) {
        if (checkPrioAndTag(5, r10) == false) goto L21;
        boolean r5 = kn.e.g();
        if (r5 == true) goto L7;
    L10:
        if (r5 == true) goto L12;
    L15:
        StringBuilder r13 = j0.w(r11, "\n");
        r13.append(d.l(r12));
        String r14 = r13.toString();
        Alog r15 = mainThreadRef;
        if (r15 == null) goto L19;
        if (r5 == false) goto L19;
        r15.w(r10, r14);
        return;
    L19:
        h.q(3, r10, r14);
        return;
    L12:
        if (sAsyncHandler == null) goto L15;
        postAsyncLog(5, r10, r11, r12, null, null);
        return;
    L7:
        if (sSingleThreadExecutor == null) goto L10;
        postAsyncLogByThreadPool(5, r10, r11, r12, null, null);
        return;
    }

    public static void e(String r10, Throwable r11) {
        if (checkPrioAndTag(6, r10) == false) goto L21;
        boolean r5 = kn.e.g();
        if (r5 == true) goto L7;
    L10:
        if (r5 == true) goto L12;
    L15:
        String r12 = d.l(r11);
        Alog r13 = mainThreadRef;
        if (r13 == null) goto L19;
        if (r5 == false) goto L19;
        r13.e(r10, r12);
        return;
    L19:
        h.q(4, r10, r12);
        return;
    L12:
        if (sAsyncHandler == null) goto L15;
        postAsyncLog(6, r10, null, r11, null, null);
        return;
    L7:
        if (sSingleThreadExecutor == null) goto L10;
        postAsyncLogByThreadPool(6, r10, null, r11, null, null);
        return;
    }

    public static void w(String r10, Throwable r11) {
        if (checkPrioAndTag(5, r10) == false) goto L21;
        boolean r5 = kn.e.g();
        if (r5 == true) goto L7;
    L10:
        if (r5 == true) goto L12;
    L15:
        String r12 = d.l(r11);
        Alog r13 = mainThreadRef;
        if (r13 == null) goto L19;
        if (r5 == false) goto L19;
        r13.w(r10, r12);
        return;
    L19:
        h.q(3, r10, r12);
        return;
    L12:
        if (sAsyncHandler == null) goto L15;
        postAsyncLog(5, r10, null, r11, null, null);
        return;
    L7:
        if (sSingleThreadExecutor == null) goto L10;
        postAsyncLogByThreadPool(5, r10, null, r11, null, null);
        return;
    }
}
