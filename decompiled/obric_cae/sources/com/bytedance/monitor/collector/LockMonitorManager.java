package com.bytedance.monitor.collector;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import c2.k;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class LockMonitorManager {
    private static final int DEFAULT_SIZE = 100;
    private static final String DELIMITER = "&#&";
    private static final String KEY_IS_ALL_THREAD = "is_all_thread";
    private static final String KEY_IS_LOCK = "is_lock";
    private static final String KEY_RAW_DUMP_INFO = "raw_dump_info";
    private static final String LOCK_THREAD_NAME = "lock_handler_time";
    private static final String STACK_THREAD_NAME = "lock_stack_fetch";
    private static final String TAG = "LockMonitorManager";
    private static final int bufferSize = 100;
    private static boolean isAllThread = false;
    private static volatile boolean isLockMonitoring = false;
    private static volatile String lastJavaStack = null;
    private static volatile String lastOwnerJavaStack = null;
    private static i[] lockInfoQueue = null;
    private static volatile boolean openFetchStack = false;
    private static int position;

    @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
    private static ExecutorService sLockHandler;
    private static final BlockingQueue<String> sOwnerStackBlockingQueue = null;
    private static final BlockingQueue<String> sStackBlockingQueue = null;

    @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
    private static ExecutorService sStackFetcher;

    public static class a implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r8) {
            Thread r10 = new Thread(r8);
            r10.setName(LockMonitorManager.LOCK_THREAD_NAME);
            return r10;
        }
    }

    public static class b implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r8) {
            Thread r10 = new Thread(r8);
            Process.setThreadPriority(-20);
            r10.setName(LockMonitorManager.STACK_THREAD_NAME);
            return r10;
        }
    }

    public static class c implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f3951a;

        public c(JSONObject r8) {
            this.f3951a = r8;
        }
    }

    public static class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f3952a;

        public d(j r8) {
            this.f3952a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j r10 = this.f3952a;
            if (r10 == null) goto L24;
            List<i> r8 = LockMonitorManager.dumpLockInfo();     // Catch: Throwable -> L26
            c r11 = (c) r10;     // Catch: Throwable -> L26
            if (r8 != null) goto L8;
            return;
        L8:
            if (k.d() == false) goto L10;
            Log.d(LockMonitorManager.TAG, "dumpLockInfo size -> " + r8.size());     // Catch: Throwable -> L26
        L10:
            Iterator<i> r12 = r8.iterator();     // Catch: Throwable -> L26
        L12:
            if (r12.hasNext() == false) goto L41;
            i r13 = r12.next();     // Catch: Throwable -> L26
            JSONObject r14 = LockMonitorManager.access$000(r13, r11.f3951a);     // Catch: Throwable -> L22
        L15:
            if (r14 == null) goto L12;
            if (k.d() == false) goto L20;
            Log.d(LockMonitorManager.TAG, "lock report LockInfo: " + r13);     // Catch: Throwable -> L22
        L20:
            o2.d r15 = new o2.d(r13.f3958a, "block_monitor", r14);     // Catch: Throwable -> L22
            r15.f9635c = true;     // Catch: Throwable -> L22
            n2.a.i().d(r15);     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            Log.e(LockMonitorManager.TAG, "onData: parse lock info failed: " + th.getLocalizedMessage());     // Catch: Throwable -> L26
            goto L12
        L41:
            return;
        L24:
            r10.getClass();     // Catch: Throwable -> L26
            return;
        L26:
            r10.getClass();
        }
    }

    public static class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f3953a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ i f3954a;

            public a(i r8) {
                this.f3954a = r8;
            }

            @Override // java.lang.Runnable
            public final void run() {
                LockMonitorManager.access$800(this.f3954a);
            }
        }

        public e(String r8) {
            this.f3953a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            i r8 = i.a(this.f3953a);     // Catch: Throwable -> L6
            if (r8 == null) goto L9;
            b3.b.C0032b.f3038a.c(new a(r8));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }
    }

    public static class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Thread f3955a;

        public f(Thread r8) {
            this.f3955a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String r8 = t2.b.Y(this.f3955a.getStackTrace());     // Catch: Throwable -> L14
            BlockingQueue r10 = LockMonitorManager.access$600();     // Catch: Throwable -> L14
            monitor-enter(r10);     // Catch: Throwable -> L14
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L14
            goto L19
        L5:
            if (LockMonitorManager.access$600().size() == 0) goto L7;
            LockMonitorManager.access$600().clear();     // Catch: Throwable -> L10
        L7:
            LockMonitorManager.access$600().put(r8);     // Catch: Throwable -> L10
            monitor-exit(r10);     // Catch: Throwable -> L10
            goto L19
        L13:
            return;
        }
    }

    public static class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Thread f3956a;

        public g(Thread r8) {
            this.f3956a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String r8 = t2.b.Y(this.f3956a.getStackTrace());     // Catch: Throwable -> L14
            BlockingQueue r10 = LockMonitorManager.access$400();     // Catch: Throwable -> L14
            monitor-enter(r10);     // Catch: Throwable -> L14
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L14
            goto L19
        L5:
            if (LockMonitorManager.access$400().size() == 0) goto L7;
            LockMonitorManager.access$400().clear();     // Catch: Throwable -> L10
        L7:
            LockMonitorManager.access$400().put(r8);     // Catch: Throwable -> L10
            monitor-exit(r10);     // Catch: Throwable -> L10
            goto L19
        L13:
            return;
        }
    }

    public static class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f3957a;

        public h(String r8) {
            this.f3957a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (LockMonitorManager.access$900() == false) goto L5;
            LockMonitorManager.access$1000(this.f3957a);     // Catch: Throwable -> L17
            return;
        L5:
            String r8 = t2.b.Y(Looper.getMainLooper().getThread().getStackTrace());     // Catch: Throwable -> L17
            BlockingQueue r10 = LockMonitorManager.access$400();     // Catch: Throwable -> L17
            monitor-enter(r10);     // Catch: Throwable -> L17
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L17
        L8:
            if (LockMonitorManager.access$400().size() == 0) goto L10;
            LockMonitorManager.access$400().clear();     // Catch: Throwable -> L13
        L10:
            LockMonitorManager.access$400().put(r8);     // Catch: Throwable -> L13
            monitor-exit(r10);     // Catch: Throwable -> L13
            goto L22
        L21:
            return;
        }
    }

    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f3958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f3959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f3960c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f3961d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f3962e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f3963f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f3964g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f3965h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f3966i;

        public i(long r8, String r10, long r11, String r12) {
            this.f3961d = "unknown";
            this.f3958a = r8;
            this.f3959b = r11;
            this.f3960c = r10;
            this.f3966i = r12;
            String r13 = r10.substring(r10.indexOf("monitor contention with owner"));
            this.f3965h = r13.substring(30, r13.indexOf("(") - 1);
            int r14 = r13.indexOf(" at ");
            if (r14 == (-1)) goto L5;
            String r15 = r13.substring(r14 + 5, r13.indexOf("waiters=", r14));
            String r16 = r15.substring(r15.indexOf(" "));
            this.f3964g = r16.substring(1, r16.indexOf("(")) + r16.substring(r16.indexOf(")") + 1, r16.lastIndexOf(")") + 1);
        L5:
            String r17 = r13.substring(r13.indexOf("blocking from") + 14);
            String r18 = r17.substring(r17.indexOf(" ") + 1);
            this.f3962e = r18.substring(0, r18.indexOf("(")) + r18.substring(r18.indexOf(")") + 1, r18.lastIndexOf(")") + 1);
            n3.a r19 = (n3.a) m3.c.a(n3.a.class);
            if (r19 == null) goto L11;
            String r20 = r19.b();
            if (TextUtils.isEmpty(r20) == true) goto L12;
            this.f3961d = r20;
            return;
        L12:
            return;
        }

        public static i a(String r10) {
            String r8 = null;
            if (r10 != null) goto L5;
        L63:
            return null;
        L5:
            if (r10.isEmpty() == true) goto L63;
            Log.d("lockDetect", r10);
            String[] r11 = r10.split(LockMonitorManager.DELIMITER);
            if (r11.length == 4) goto L11;
            Log.d("lockDetect", "spiltData != 4".concat(r10));
            return null;
        L11:
            long r12 = Long.parseLong(r11[0]);
            long r13 = Long.parseLong(r11[1]);
            String r14 = r11[2];
            i r15 = new i(r12, r14, r13, r11[3]);
            if (LockMonitorManager.access$300() == false) goto L53;
            BlockingQueue r16 = LockMonitorManager.access$400();
            monitor-enter(r16);
            String r17 = (String) LockMonitorManager.access$400().poll(200, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L18 InterruptedException -> L20
        L22:
            if (r17 == null) goto L24;
        L26:
            LockMonitorManager.access$502(r17);     // Catch: Throwable -> L18
        L28:
            if (LockMonitorManager.access$400().isEmpty() == true) goto L30;
            LockMonitorManager.access$400().clear();     // Catch: Throwable -> L18
        L30:
            monitor-exit(r16);     // Catch: Throwable -> L18
            BlockingQueue r18 = LockMonitorManager.access$600();
            monitor-enter(r18);
            r8 = (String) LockMonitorManager.access$600().poll(200, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L35 InterruptedException -> L37
        L39:
            if (r8 == null) goto L41;
        L43:
            LockMonitorManager.access$702(r17);     // Catch: Throwable -> L35
        L45:
            if (LockMonitorManager.access$600().isEmpty() == true) goto L47;
            LockMonitorManager.access$600().clear();     // Catch: Throwable -> L35
        L47:
            monitor-exit(r18);     // Catch: Throwable -> L35
            String r19 = r8;
            r8 = r17;
        L54:
            if (r8 != null) goto L56;
        L58:
            if (r19 != null) goto L60;
        L62:
            return r15;
        L60:
            if (r19.isEmpty() == true) goto L62;
            r15.f3964g = r19;
            goto L62
        L56:
            if (r14.contains(t2.b.D(r8)) == false) goto L58;
            r15.f3963f = r8;
            goto L58
        L41:
            if (LockMonitorManager.access$700() == null) goto L43;
            r8 = LockMonitorManager.access$700();     // Catch: Throwable -> L35
            goto L45
        L37:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L35
        L35:
            th = move-exception;
            throw th;
        L24:
            if (LockMonitorManager.access$500() == null) goto L26;
            r17 = LockMonitorManager.access$500();     // Catch: Throwable -> L18
            goto L28
        L20:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L18
            r17 = null;
        L18:
            th = move-exception;
            throw th;
        L53:
            r19 = null;
            goto L54
        }

        public final String toString() {
            StringBuilder r8 = new StringBuilder("LockInfo{timestamp=");
            r8.append(this.f3958a);
            r8.append(", duration=");
            r8.append(this.f3959b);
            r8.append(", rawAtrace='");
            r8.append(this.f3960c);
            r8.append("', topActivityName='");
            r8.append(this.f3961d);
            r8.append("', blockStackInfo='");
            r8.append(this.f3962e);
            r8.append("', completeBlockStackInfo='");
            r8.append(this.f3963f);
            r8.append("', ownerStackInfo='");
            r8.append(this.f3964g);
            r8.append("', lockThreadName='");
            r8.append(this.f3966i);
            r8.append("', ownerThreadName='");
            return android.aimedia.a.i(r8, this.f3965h, "'}");
        }
    }

    public interface j {
    }

    static {
        lockInfoQueue = new i[100];
        sStackBlockingQueue = new LinkedBlockingQueue();
        sOwnerStackBlockingQueue = new LinkedBlockingQueue();
        sLockHandler = Executors.newSingleThreadExecutor(new a());
        sStackFetcher = Executors.newSingleThreadExecutor(new b());
        isLockMonitoring = false;
    }

    public LockMonitorManager() {
    }

    public static /* synthetic */ JSONObject access$000(i r8, JSONObject r10) {
        return packJsonData(r8, r10);
    }

    public static /* synthetic */ void access$1000(String r8) {
        getThreadStack(r8);
    }

    public static /* synthetic */ boolean access$300() {
        return openFetchStack;
    }

    public static /* synthetic */ BlockingQueue access$400() {
        return sStackBlockingQueue;
    }

    public static /* synthetic */ String access$500() {
        return lastJavaStack;
    }

    public static /* synthetic */ String access$502(String r8) {
        lastJavaStack = r8;
        return r8;
    }

    public static /* synthetic */ BlockingQueue access$600() {
        return sOwnerStackBlockingQueue;
    }

    public static /* synthetic */ String access$700() {
        return lastOwnerJavaStack;
    }

    public static /* synthetic */ String access$702(String r8) {
        lastOwnerJavaStack = r8;
        return r8;
    }

    public static /* synthetic */ void access$800(i r8) {
        enqueue(r8);
    }

    public static /* synthetic */ boolean access$900() {
        return isAllThread;
    }

    public static String dumpLockInfo(long r12, long r14) {
        i[] r8 = new i[100];
        int r10 = 0;
        System.arraycopy(lockInfoQueue, 0, r8, 0, 100);
        ArrayList r11 = new ArrayList();
    L3:
        if (r10 >= 100) goto L17;
        i r13 = r8[((position + r10) + 1) % 100];
        if (r13 == null) goto L15;
        long r15 = r13.f3958a;
        long r16 = r13.f3959b;
        if (r15 >= r14) goto L10;
    L11:
        r11.add(r13);
    L13:
        if ((r15 + r16) >= r12) goto L15;
    L10:
        if ((r15 + r16) <= r12) goto L13;
    L15:
        r10 = r10 + 1;
    L17:
        return r11.toString();
    }

    public static void endLockDetect(JSONObject r8) {
        if (isLockMonitoring == true) goto L5;
        return;
    L5:
        isLockMonitoring = false;
        r8.put(KEY_IS_LOCK, true);     // Catch: JSONException -> L8
        r8.put(KEY_IS_ALL_THREAD, isAllThread);     // Catch: JSONException -> L8
    L11:
        if (k.f() == false) goto L22;
        reportLockInfo(r8);
        com.bytedance.monitor.collector.a r10 = com.bytedance.monitor.collector.a.b();
        monitor-enter(r10);
        setOpenFetchStack(false);     // Catch: Throwable -> L19
        if (com.bytedance.monitor.collector.a.f3967b == true) goto L24;
    L17:
        monitor-exit(r10);
        return;
    L24:
        MonitorJni.disableLock();     // Catch: Throwable -> L23
    L19:
        th = move-exception;
        throw th;
    L22:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    private static void enqueue(i r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        i[] r10 = lockInfoQueue;
        int r11 = position;
        r10[r11] = r8;
        position = (r11 + 1) % 100;
    }

    private static void getOwnerStack(String r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.isEmpty() == true) goto L27;
        ThreadGroup r10 = Looper.getMainLooper().getThread().getThreadGroup();
        int r11 = r10.activeCount();
        int r12 = (r11 / 2) + r11;
        Thread[] r13 = new Thread[r12];
        r10.enumerate(r13);
        int r14 = 0;
    L7:
        if (r14 >= r12) goto L28;
        Thread r15 = r13[r14];
        if (r15 == null) goto L29;
        if (r15 == Thread.currentThread()) goto L19;
        if (r15.getName().contains(r8) == false) goto L19;
        if (openFetchStack == false) goto L19;
        sStackFetcher.execute(new f(r15));
    L19:
        r14 = r14 + 1;
        goto L7
    L29:
        return;
    L28:
        return;
    }

    private static void getThreadStack(String r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.isEmpty() == true) goto L23;
        ThreadGroup r10 = Looper.getMainLooper().getThread().getThreadGroup();
        int r11 = r10.activeCount();
        int r12 = (r11 / 2) + r11;
        Thread[] r13 = new Thread[r12];
        r10.enumerate(r13);
        int r14 = 0;
    L7:
        if (r14 >= r12) goto L24;
        Thread r15 = r13[r14];
        if (r15 == null) goto L25;
        if (r15.getName().contains(r8) == false) goto L16;
        if (openFetchStack == false) goto L16;
        sStackFetcher.execute(new g(r15));
    L16:
        r14 = r14 + 1;
        goto L7
    L25:
        return;
    L24:
        return;
    }

    @Keep
    private static void nativeGetJavaStack(String r8, String r10) {
        if (openFetchStack == false) goto L22;
        sStackFetcher.execute(new h(r10));
        if (r8 != null) goto L7;
        return;
    L7:
        if (r8.isEmpty() == true) goto L30;
        int r11 = r8.indexOf("monitor contention with owner");
        if (r11 > 0) goto L12;
        return;
    L12:
        if (r11 >= r8.length()) goto L25;
        String r12 = r8.substring(r11);
        int r13 = r12.indexOf("(") - 1;
        if (r13 > 0) goto L16;
        return;
    L16:
        if (30 < r12.length()) goto L18;
        return;
    L18:
        if (r13 >= r12.length()) goto L28;
        if (30 >= r13) goto L29;
        getOwnerStack(r12.substring(30, r13));
        return;
    L29:
        return;
    L28:
        return;
    L25:
        return;
    L30:
        return;
    }

    @Keep
    private static void nativePut(String r8) {
        sLockHandler.execute(new e(r8));
    }

    private static JSONObject packJsonData(i r8, JSONObject r10) {
        JSONObject r11 = new JSONObject();
        long r12 = r8.f3958a;     // Catch: JSONException -> L19
        String r13 = r8.f3960c;
        r11.put("timestamp", r12);     // Catch: JSONException -> L19
        r11.put("crash_time", r8.f3958a);     // Catch: JSONException -> L19
        r11.put(LocationMonitorConst.IS_MAIN_PROCESS, k.e());     // Catch: JSONException -> L19
        r11.put("process_name", k.a());     // Catch: JSONException -> L19
        r11.put("block_duration", r8.f3959b);     // Catch: JSONException -> L19
        r11.put(KEY_RAW_DUMP_INFO, r13);     // Catch: JSONException -> L19
        StringBuilder r14 = new StringBuilder();     // Catch: JSONException -> L19
        if (TextUtils.isEmpty(r8.f3963f) == true) goto L9;
        r14.append(r8.f3963f.replace("\t", ""));     // Catch: JSONException -> L19
        r14.append("\n");     // Catch: JSONException -> L19
    L9:
        r14.append("-OwnerThread: ");     // Catch: JSONException -> L19
        r14.append(r8.f3965h);     // Catch: JSONException -> L19
        r14.append("\n");     // Catch: JSONException -> L19
        r14.append("-OwnerStack: ");     // Catch: JSONException -> L19
        r14.append(r8.f3964g);     // Catch: JSONException -> L19
        r14.append("\n");     // Catch: JSONException -> L19
        r14.append("-WaiterStack: ");     // Catch: JSONException -> L19
        r14.append(r8.f3962e);     // Catch: JSONException -> L19
        r14.append("\n");     // Catch: JSONException -> L19
        r14.append("-RawAtrace: ");     // Catch: JSONException -> L19
        r14.append(r13);     // Catch: JSONException -> L19
        r14.append("\n");     // Catch: JSONException -> L19
        r14.append("-LockThread: ");     // Catch: JSONException -> L19
        r14.append(r8.f3966i);     // Catch: JSONException -> L19
        r14.append("\n");     // Catch: JSONException -> L19
        String r15 = r8.f3961d;
        if (r15 == null) goto L13;
        r14.append("-Activity: ");     // Catch: JSONException -> L19
        r14.append(r15);     // Catch: JSONException -> L19
        r14.append("\n");     // Catch: JSONException -> L19
    L13:
        JSONObject r16 = l3.a.a().b();     // Catch: JSONException -> L19
        r16.put("block_stack_type", "stack");     // Catch: JSONException -> L19
        Iterator<String> r17 = r10.keys();     // Catch: JSONException -> L19
    L15:
        if (r17.hasNext() == false) goto L17;
        String r18 = r17.next();     // Catch: JSONException -> L19
        r16.put(r18, r10.get(r18));     // Catch: JSONException -> L19
        goto L15
    L17:
        r11.put("filters", r16);     // Catch: JSONException -> L19
        r11.put("stack", r14.toString());     // Catch: JSONException -> L19
        r11.put("event_type", "lag");     // Catch: JSONException -> L19
        return r11;
    L19:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static void reportLockInfo(JSONObject r8) {
        dumpLockInfo(new c(r8));
    }

    public static void setOpenFetchStack(boolean r8) {
        openFetchStack = r8;
        if (r8 == true) goto L6;
        lastJavaStack = null;
        lastOwnerJavaStack = null;
        return;
    }

    public static void startLockDetect() {
        startLockDetect(30);
    }

    public static List<i> dumpLockInfo() {
        LinkedList r8 = new LinkedList();
        int r10 = 0;
    L4:
        if (r10 >= 100) goto L9;
        int r11 = (((position + 100) - r10) - 1) % 100;
        i[] r12 = lockInfoQueue;
        i r13 = r12[r11];
        r12[r11] = null;
        if (r13 == null) goto L8;
        r8.add(r13);
    L8:
        r10 = r10 + 1;
        goto L4
    L9:
        return r8;
    }

    public static void startLockDetect(long r8) {
        if (isLockMonitoring == false) goto L5;
        return;
    L5:
        isLockMonitoring = true;
        if (k.f() == false) goto L18;
        com.bytedance.monitor.collector.a r10 = com.bytedance.monitor.collector.a.b();
        monitor-enter(r10);
        setOpenFetchStack(true);     // Catch: Throwable -> L15
        if (com.bytedance.monitor.collector.a.f3967b == true) goto L22;
    L13:
        monitor-exit(r10);
        return;
    L22:
        MonitorJni.enableLockAll(r8, false);     // Catch: Throwable -> L19
    L15:
        th = move-exception;
        throw th;
    }

    public static void dumpLockInfo(j r8) {
        b3.b.C0032b.f3038a.c(new d(r8));
    }

    public static void startLockDetect(long r8, boolean r10) {
        if (isLockMonitoring == false) goto L5;
        return;
    L5:
        isLockMonitoring = true;
        isAllThread = r10;
        if (k.f() == false) goto L17;
        com.bytedance.monitor.collector.a r11 = com.bytedance.monitor.collector.a.b();
        monitor-enter(r11);
        setOpenFetchStack(true);     // Catch: Throwable -> L14
        if (com.bytedance.monitor.collector.a.f3967b == true) goto L21;
    L12:
        monitor-exit(r11);
        return;
    L21:
        MonitorJni.enableLockAll(r8, r10);     // Catch: Throwable -> L18
    L14:
        th = move-exception;
        throw th;
    }
}
