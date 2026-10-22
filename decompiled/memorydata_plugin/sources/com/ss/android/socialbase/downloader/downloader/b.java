package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.ss.android.socialbase.downloader.constants.DownloadCacheSyncStatus;
import com.ss.android.socialbase.downloader.depend.ab;
import com.ss.android.socialbase.downloader.depend.ac;
import com.ss.android.socialbase.downloader.depend.ad;
import com.ss.android.socialbase.downloader.depend.ae;
import com.ss.android.socialbase.downloader.depend.ah;
import com.ss.android.socialbase.downloader.depend.ak;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class b {
    private static volatile com.ss.android.socialbase.downloader.f.b A;
    private static volatile ab B;
    private static volatile List<ak> C;
    private static volatile boolean D;
    private static volatile OkHttpClient E;
    private static volatile com.ss.android.socialbase.downloader.network.f F;
    private static volatile com.ss.android.socialbase.downloader.network.f G;
    private static volatile t H;
    private static volatile y I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static volatile k f15401J;
    private static volatile com.ss.android.socialbase.downloader.depend.m K;
    private static volatile ac L;
    private static final List<com.ss.android.socialbase.downloader.depend.l> M = null;
    private static volatile ae N;
    private static boolean O;
    private static volatile boolean P;
    private static final int Q = 0;
    private static final int R = 0;
    private static final int S = 0;
    private static final int T = 0;
    private static int U;
    private static boolean V;
    private static final List<com.ss.android.socialbase.downloader.depend.i> W = null;
    private static final List<ad> X = null;
    private static boolean Y;
    private static q Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Context f15402a;
    private static com.ss.android.socialbase.downloader.f.c aa;
    private static volatile boolean ab;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile h f15403b;
    private static volatile ah c;
    private static volatile com.ss.android.socialbase.downloader.impls.a d;
    private static volatile n e;
    private static volatile n f;
    private static volatile a g;
    private static volatile com.ss.android.socialbase.downloader.network.i h;
    private static volatile com.ss.android.socialbase.downloader.network.i i;
    private static volatile j j;
    private static volatile ExecutorService k;
    private static volatile ExecutorService l;
    private static volatile ExecutorService m;
    private static volatile ExecutorService n;
    private static volatile ExecutorService o;
    private static volatile ExecutorService p;
    private static volatile ExecutorService q;
    private static volatile ExecutorService r;
    private static volatile ExecutorService s;
    private static volatile ExecutorService t;
    private static volatile ScheduledExecutorService u;
    private static volatile ExecutorService v;
    private static volatile ExecutorService w;
    private static volatile ExecutorService x;
    private static volatile d y;
    private static volatile p z;

    public interface a {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.downloader.b$a$a, reason: collision with other inner class name */
        public interface InterfaceC0826a {
            void a();
        }

        n a();

        s a(InterfaceC0826a r1);

        l b();
    }

    static {
        C = new CopyOnWriteArrayList();
        D = false;
        E = null;
        M = new ArrayList();
        O = false;
        P = false;
        int r1 = Runtime.getRuntime().availableProcessors() + 1;
        Q = r1;
        R = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        S = r1;
        T = r1;
        U = com.ss.android.socialbase.downloader.constants.b.e;
        W = new ArrayList();
        X = new ArrayList();
        Y = true;
        ab = false;
        com.ss.android.socialbase.downloader.service.p r0 = (com.ss.android.socialbase.downloader.service.p) ZeusTransformUtils.preCheckCast(com.ss.android.socialbase.downloader.service.k.a(com.ss.android.socialbase.downloader.service.p.class), com.ss.android.socialbase.downloader.service.p.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    private b() {
    }

    public static com.ss.android.socialbase.downloader.network.f A() {
        if (G != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (G != null) goto L9;
        G = new AnonymousClass3();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return G;
    }

    public static synchronized j B() {
        monitor-enter(b.class);
        j r1 = j;     // Catch: Throwable -> L7
        monitor-exit(b.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static h C() {
        if (f15403b != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f15403b != null) goto L9;
        f15403b = new com.ss.android.socialbase.downloader.impls.b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f15403b;
    }

    public static n D() {
        if (e != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (e != null) goto L9;
        e = new com.ss.android.socialbase.downloader.impls.e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return e;
    }

    public static n E() {
        if (f != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f != null) goto L9;
        f = g.a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f;
    }

    public static com.ss.android.socialbase.downloader.impls.a F() {
        if (d != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L9;
        d = new com.ss.android.socialbase.downloader.impls.c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return d;
    }

    public static JSONObject G() {
        if (B == null) goto L5;
        JSONObject r0 = B.a();
    L6:
        if (r0 == null) goto L8;
        return r0;
    L8:
        return com.ss.android.socialbase.downloader.constants.b.g;
    L5:
        r0 = null;
        goto L6
    }

    public static void H() {
        if (TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.b.c) == false) goto L6;
        com.ss.android.socialbase.downloader.constants.b.c = "oppo";
        com.ss.android.socialbase.downloader.constants.b.f15353b = com.ss.android.socialbase.downloader.constants.b.c.toUpperCase();
        return;
    }

    public static boolean I() {
        return Y;
    }

    public static k J() {
        return f15401J;
    }

    public static com.ss.android.socialbase.downloader.depend.m K() {
        return K;
    }

    public static ac L() {
        return L;
    }

    public static void M() {
        C().g();
    }

    public static int N() {
        return U;
    }

    public static ah O() {
        return c;
    }

    public static t P() {
        if (H != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (H != null) goto L9;
        H = new t.a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return H;
    }

    public static y Q() {
        return I;
    }

    public static ae R() {
        return N;
    }

    public static synchronized Context S() {
        monitor-enter(b.class);
        Context r1 = f15402a;     // Catch: Throwable -> L7
        monitor-exit(b.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean T() {
        monitor-enter(b.class);
        boolean r1 = V;     // Catch: Throwable -> L7
        monitor-exit(b.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static com.ss.android.socialbase.downloader.f.c U() {
        if (aa != null) goto L6;
        aa = new AnonymousClass4();
    L6:
        return aa;
    }

    public static q V() {
        return Z;
    }

    public static boolean W() {
        return ab;
    }

    public static boolean X() {
        if (g == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static a Y() {
        return g;
    }

    public static void Z() {
        P = true;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a("DownloadComponentManager", "enableLruCache", "Run");
        return;
    }

    public static int a(DownloadInfo r3) {
        return ((com.ss.android.socialbase.downloader.service.n) ZeusTransformUtils.preCheckCast(com.ss.android.socialbase.downloader.service.k.a(com.ss.android.socialbase.downloader.service.n.class), com.ss.android.socialbase.downloader.service.n.class, "com.obric.memorydata.plugin")).a(r3);
    }

    public static int a(String r3, String r4) {
        return ((com.ss.android.socialbase.downloader.service.n) ZeusTransformUtils.preCheckCast(com.ss.android.socialbase.downloader.service.k.a(com.ss.android.socialbase.downloader.service.n.class), com.ss.android.socialbase.downloader.service.n.class, "com.obric.memorydata.plugin")).a(r3, r4);
    }

    public static long a(boolean r12) {
        long r2 = 0;
        h r4 = C();     // Catch: Throwable -> L29
        boolean r5 = r4.d();     // Catch: Throwable -> L29
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a("DownloadComponentManager", "clearAllDownloadCache", "DownloadCache sync:" + r5);     // Catch: Throwable -> L29
    L6:
        List<DownloadInfo> r6 = r4.a();     // Catch: Throwable -> L29
        if (r6 == null) goto L9;
        com.ss.android.socialbase.downloader.impls.a r7 = F();     // Catch: Throwable -> L29
        Iterator<DownloadInfo> r8 = r6.iterator();     // Catch: Throwable -> L29
        long r9 = 0;
    L38:
        if (r8.hasNext() == false) goto L35;
        DownloadInfo r10 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r8.next(), DownloadInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        if (r7.a(r10.getId()) == true) goto L38;
        if (com.ss.android.socialbase.downloader.utils.a.a(r10.getSavePath()) == false) goto L38;
        if (r10.getCurBytes() <= 0) goto L24;
        r9 = r9 + r10.getCurBytes();     // Catch: Throwable -> L27
    L24:
        if (r12 == false) goto L38;
        r4.d(r10.getId());     // Catch: Throwable -> L27
        com.ss.android.socialbase.downloader.utils.g.c(r10.getSavePath(), r10.getTempPath(), r10.getName());     // Catch: Throwable -> L27
    L35:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L37;
        com.ss.android.socialbase.downloader.e.a.a("DownloadComponentManager", "clearAllDownloadCache", "ClearSize:" + r9 + " clear:" + r12);
    L37:
        return r9;
    L27:
        th = th;
        r2 = r9;
    L30:
        th.printStackTrace();
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L33;
        com.ss.android.socialbase.downloader.e.a.a("DownloadComponentManager", "clearAllDownloadCache", "Error:" + th);
    L33:
        r9 = r2;
        goto L35
    L9:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L11;
        com.ss.android.socialbase.downloader.e.a.a("DownloadComponentManager", "clearAllDownloadCache", "DownloadInfos is null");     // Catch: Throwable -> L29
    L11:
        return 0;
    L29:
        th = th;
        goto L30
    }

    public static com.ss.android.socialbase.downloader.network.h a(boolean r11, int r12, String r13, String r14, List<HttpHeader> r15, int r16, boolean r17, DownloadInfo r18) {
        List<HttpHeader> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        return ((com.ss.android.socialbase.downloader.service.r) ZeusTransformUtils.preCheckCast(com.ss.android.socialbase.downloader.service.k.a(com.ss.android.socialbase.downloader.service.r.class), com.ss.android.socialbase.downloader.service.r.class, "com.obric.memorydata.plugin")).a(r11, r12, r13, r14, r7, r16, r17, r18);
    }

    public static Future a(Runnable r2, long r3, TimeUnit r5) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        return null;
    L7:
        return w().schedule(r4, r3, r5);
    }

    public static synchronized void a() {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            java.lang.Class<com.ss.android.socialbase.downloader.downloader.b> r0 = com.ss.android.socialbase.downloader.downloader.b.class
            monitor-enter(r0)
            boolean r1 = com.ss.android.socialbase.downloader.downloader.b.O     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            if (r1 == 0) goto L22
            com.ss.android.socialbase.downloader.downloader.d r1 = com.ss.android.socialbase.downloader.downloader.b.y     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            if (r1 == 0) goto L22
            android.content.Context r1 = com.ss.android.socialbase.downloader.downloader.b.f15402a     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            if (r1 == 0) goto L22
            android.content.Context r1 = com.ss.android.socialbase.downloader.downloader.b.f15402a     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            com.ss.android.socialbase.downloader.downloader.d r2 = com.ss.android.socialbase.downloader.downloader.b.y     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            java.lang.String r3 = "com.obric.memorydata.plugin"
            com.volcengine.zeus.transform.ZeusTransformUtils.unregisterReceiver(r1, r2, r3)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            r1 = 0
            com.ss.android.socialbase.downloader.downloader.b.O = r1     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            goto L22
        L1c:
            r1 = move-exception
            goto L24
        L1e:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L1c
        L22:
            monitor-exit(r0)
            return
        L24:
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.b.a():void");
    }

    public static synchronized void a(Context r5) {
        monitor-enter(b.class);
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (r6 != null) goto L7;
    L11:
        monitor-exit(b.class);
        return;
    L7:
        if (f15402a != null) goto L11;
        f15402a = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        com.ss.android.socialbase.downloader.a.a.a().a(f15402a);     // Catch: Throwable -> L13
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L11;
        com.ss.android.socialbase.downloader.e.a.a("DownloadComponentManager", "setAppContext", "Context:" + r6);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public static void a(DownloadCacheSyncStatus r5) {
        List<com.ss.android.socialbase.downloader.depend.i> r0 = W;
        monitor-enter(r0);
        Iterator<com.ss.android.socialbase.downloader.depend.i> r1 = r0.iterator();     // Catch: Throwable -> L20
    L6:
        if (r1.hasNext() == false) goto L16;
        com.ss.android.socialbase.downloader.depend.i r2 = (com.ss.android.socialbase.downloader.depend.i) ZeusTransformUtils.preCheckCast(r1.next(), com.ss.android.socialbase.downloader.depend.i.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (r2 == null) goto L6;
        if (r5 == DownloadCacheSyncStatus.SYNC_START) goto L11;
        if (r5 != DownloadCacheSyncStatus.SYNC_SUCCESS) goto L6;
        r2.b();     // Catch: Throwable -> L20
        goto L6
    L11:
        r2.a();     // Catch: Throwable -> L20
        goto L6
    L16:
        if (r5 != DownloadCacheSyncStatus.SYNC_SUCCESS) goto L18;
        W.clear();     // Catch: Throwable -> L20
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public static void a(ab r2) {
        B = (ab) ZeusTransformUtils.wrapperContextForParams(r2, ab.class, "com.obric.memorydata.plugin");
        com.ss.android.socialbase.downloader.g.a.a();
    }

    public static void a(ac r2) {
        L = (ac) ZeusTransformUtils.wrapperContextForParams(r2, ac.class, "com.obric.memorydata.plugin");
    }

    public static void a(ae r2) {
        ae r3 = (ae) ZeusTransformUtils.wrapperContextForParams(r2, ae.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        N = r3;
        return;
    }

    public static void a(ah r2) {
        ah r3 = (ah) ZeusTransformUtils.wrapperContextForParams(r2, ah.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        c = r3;
        return;
    }

    public static void a(ak r2) {
        ak r3 = (ak) ZeusTransformUtils.wrapperContextForParams(r2, ak.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        C.add(r3);
    }

    public static void a(com.ss.android.socialbase.downloader.depend.i r2) {
        com.ss.android.socialbase.downloader.depend.i r3 = (com.ss.android.socialbase.downloader.depend.i) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.socialbase.downloader.depend.i.class, "com.obric.memorydata.plugin");
        List<com.ss.android.socialbase.downloader.depend.i> r0 = W;
        monitor-enter(r0);
        if (r3 != null) goto L16;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L16:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (r0.contains(r3) == true) goto L11;
        r0.add(r3);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    public static void a(com.ss.android.socialbase.downloader.depend.m r2) {
        K = (com.ss.android.socialbase.downloader.depend.m) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.socialbase.downloader.depend.m.class, "com.obric.memorydata.plugin");
    }

    public static void a(y r2) {
        y r3 = (y) ZeusTransformUtils.wrapperContextForParams(r2, y.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        I = r3;
        return;
    }

    public static void a(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("DownloadComponentManager", "setIndependentServiceCreator", "Creator: " + r4);
    L5:
        g = r4;
    }

    public static synchronized void a(f r3) {
        monitor-enter(b.class);
    L33:
        th = move-exception;
        throw th;
    L5:
        if (ab == false) goto L9;
        com.ss.android.socialbase.downloader.e.a.b("DownloadComponentManager", "initComponent", "Component has init");     // Catch: Throwable -> L33
        monitor-exit(b.class);
        return;
    L9:
        boolean r1 = D;     // Catch: Throwable -> L33
        c(r3);     // Catch: Throwable -> L33
        ac();     // Catch: Throwable -> L33
        if (f15403b != null) goto L13;
        f15403b = new com.ss.android.socialbase.downloader.impls.b();     // Catch: Throwable -> L33
    L13:
        if (e != null) goto L16;
        e = new com.ss.android.socialbase.downloader.impls.e();     // Catch: Throwable -> L33
    L16:
        if (f != null) goto L21;
        if (g == null) goto L21;
        f = g.a();     // Catch: Throwable -> L33
    L21:
        if (d != null) goto L24;
        d = new com.ss.android.socialbase.downloader.impls.c();     // Catch: Throwable -> L33
    L24:
        if (D == false) goto L29;
        if (r1 == true) goto L29;
        if (com.ss.android.socialbase.downloader.utils.c.c() == true) goto L29;
        boolean r4 = true;
    L30:
        c(r4);     // Catch: Throwable -> L33
        H();     // Catch: Throwable -> L33
        ab = true;     // Catch: Throwable -> L33
        monitor-exit(b.class);
        return;
    L29:
        r4 = false;
        goto L30
    }

    private static void a(i r3) {
        i r4 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        ((com.ss.android.socialbase.downloader.service.n) ZeusTransformUtils.preCheckCast(com.ss.android.socialbase.downloader.service.k.a(com.ss.android.socialbase.downloader.service.n.class), com.ss.android.socialbase.downloader.service.n.class, "com.obric.memorydata.plugin")).a(r4);
        return;
    }

    public static synchronized void a(j r3) {
        monitor-enter(b.class);
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r4 == null) goto L9;
        j = r4;     // Catch: Throwable -> L11
        if (ZeusTransformUtils.instanceOf(f15403b, com.ss.android.socialbase.downloader.impls.b.class) == false) goto L9;
        ((com.ss.android.socialbase.downloader.impls.b) ZeusTransformUtils.preCheckCast(f15403b, com.ss.android.socialbase.downloader.impls.b.class, "com.obric.memorydata.plugin")).h();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static void a(k r2) {
        f15401J = (k) ZeusTransformUtils.wrapperContextForParams(r2, k.class, "com.obric.memorydata.plugin");
    }

    public static void a(q r2) {
        Z = (q) ZeusTransformUtils.wrapperContextForParams(r2, q.class, "com.obric.memorydata.plugin");
    }

    public static void a(com.ss.android.socialbase.downloader.f.b r2) {
        com.ss.android.socialbase.downloader.f.b r3 = (com.ss.android.socialbase.downloader.f.b) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.socialbase.downloader.f.b.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        A = r3;
        return;
    }

    public static void a(DownloadTask r5, int r6) {
        List<ad> r0 = X;
        monitor-enter(r0);
        Iterator<ad> r1 = r0.iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L10;
        ad r2 = (ad) ZeusTransformUtils.preCheckCast(r1.next(), ad.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r2 == null) goto L6;
        r2.a(r5, r6);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static void a(DownloadTask r1, boolean r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.getDownloadInfo().isFastDownload() == true) goto L16;
        com.ss.android.socialbase.downloader.model.d r3 = r1.getThreadInfo();
        if (r2 == false) goto L9;
        Map<String, com.ss.android.socialbase.downloader.model.d.a> r4 = r3.f15567a;
    L11:
        if (r4.isEmpty() == true) goto L13;
        return;
    L13:
        r4.put("cpu", com.ss.android.socialbase.downloader.model.d.a(k));
        r4.put("io", com.ss.android.socialbase.downloader.model.d.a(l));
        r4.put("mixDefault", com.ss.android.socialbase.downloader.model.d.a(m));
        r4.put("mixApk", com.ss.android.socialbase.downloader.model.d.a(p));
        r4.put("db", com.ss.android.socialbase.downloader.model.d.a(q));
        r4.put("chunk", com.ss.android.socialbase.downloader.model.d.a(r));
        r4.put("segment", com.ss.android.socialbase.downloader.model.d.a(s));
        r4.put("okHttp", com.ss.android.socialbase.downloader.model.d.a(t));
        r4.put("schedule", com.ss.android.socialbase.downloader.model.d.a(u));
        r4.put(LocationInfoConst.SINGLE, com.ss.android.socialbase.downloader.model.d.a(v));
        r4.put("custom", com.ss.android.socialbase.downloader.model.d.a(w));
        return;
    L9:
        r4 = r3.f15568b;
        goto L11
    }

    public static void a(com.ss.android.socialbase.downloader.network.i r2) {
        com.ss.android.socialbase.downloader.network.i r3 = (com.ss.android.socialbase.downloader.network.i) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.socialbase.downloader.network.i.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        h = r3;
    L6:
        if (h == null) goto L8;
        boolean r4 = true;
    L9:
        V = r4;
        return;
    L8:
        r4 = false;
        goto L9
    }

    public static void a(Runnable r2) {
        a((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), false);
    }

    public static void a(Runnable r2, boolean r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3 == true) goto L7;
    L9:
        i().execute(r4);
        return;
    L7:
        if (com.ss.android.socialbase.downloader.utils.g.a() == true) goto L9;
        r4.run();
    }

    private static void a(List<com.ss.android.socialbase.downloader.depend.l> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        List<com.ss.android.socialbase.downloader.depend.l> r0 = M;
        if (r0.isEmpty() == false) goto L11;
        monitor-enter(r0);
        r0.addAll(r3);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void a(ExecutorService r2) {
        ExecutorService r3 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r2, ExecutorService.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        r = r3;
        return;
    }

    public static boolean aa() {
        return P;
    }

    static /* synthetic */ void ab() {
        ad();
    }

    private static void ac() {
        JSONObject r2 = G();     // Catch: Throwable -> L37
        int r3 = r2.optInt("downloader_alog_level");     // Catch: Throwable -> L37
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a("DownloadComponentManager", "setLoggerReport", "ALogLevel:" + r3);     // Catch: Throwable -> L37
    L6:
        if (r3 > 0) goto L8;
        return;
    L8:
        ArrayList r4 = new ArrayList();     // Catch: Throwable -> L37
        JSONArray r5 = r2.optJSONArray("downloader_alog_task_scene_list");     // Catch: Throwable -> L37
        int r6 = 0;
        if (r5 != null) goto L11;
    L19:
        ArrayList r7 = new ArrayList();     // Catch: Throwable -> L37
        if (r2.optInt("downloader_logger_global_report") <= 0) goto L22;
        boolean r8 = true;
    L23:
        JSONArray r9 = r2.optJSONArray("downloader_logger_task_report_scene_list");     // Catch: Throwable -> L37
        if (r9 != null) goto L26;
    L33:
        com.ss.android.socialbase.downloader.e.a.a(r3, r8, r7, r4);     // Catch: Throwable -> L37
        if (com.ss.android.socialbase.downloader.e.a.b() == false) goto L48;
        com.ss.android.socialbase.downloader.e.a.a("DownloadComponentManager", "setLoggerReport", "Setting: " + G());     // Catch: Throwable -> L37
        return;
    L48:
        return;
    L26:
        if (r9.length() <= 0) goto L33;
    L28:
        if (r6 >= r9.length()) goto L33;
        String r10 = r9.optString(r6);     // Catch: Throwable -> L37
        if (TextUtils.isEmpty(r10) == true) goto L32;
        r7.add(r10);     // Catch: Throwable -> L37
    L32:
        r6 = r6 + 1;     // Catch: Throwable -> L37
        goto L28
    L22:
        r8 = false;
        goto L23
    L11:
        if (r5.length() <= 0) goto L19;
        int r11 = 0;
    L14:
        if (r11 >= r5.length()) goto L19;
        String r12 = r5.optString(r11);     // Catch: Throwable -> L37
        if (TextUtils.isEmpty(r12) == true) goto L18;
        r4.add(r12);     // Catch: Throwable -> L37
    L18:
        r11 = r11 + 1;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        com.ss.android.socialbase.downloader.e.a.b("DownloadComponentManager", "setLoggerReport", "Error:" + th);
    }

    private static synchronized void ad() {
        monitor-enter(b.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (y != null) goto L8;
        y = new d();     // Catch: Throwable -> L17
    L8:
        if (O == false) goto L20;
        monitor-exit(b.class);
        return;
    L20:
        IntentFilter r1 = new IntentFilter();     // Catch: Throwable -> L13
        r1.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Throwable -> L13
        r1.addAction("android.intent.action.MEDIA_MOUNTED");     // Catch: Throwable -> L13
        r1.addAction("android.intent.action.MEDIA_UNMOUNTED");     // Catch: Throwable -> L13
        r1.addAction("android.intent.action.MEDIA_REMOVED");     // Catch: Throwable -> L13
        r1.addAction("android.intent.action.MEDIA_BAD_REMOVAL");     // Catch: Throwable -> L13
        r1.addAction("android.intent.action.MEDIA_EJECT");     // Catch: Throwable -> L13
        ZeusTransformUtils.registerReceiver(f15402a, y, r1, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        O = true;     // Catch: Throwable -> L13
    L15:
        monitor-exit(b.class);
        return;
    L13:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L17
        goto L15
    }

    public static synchronized void b() {
        monitor-enter(b.class);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (D == false) goto L7;
    L18:
        monitor-exit(b.class);
        return;
    L7:
        if (X() == false) goto L18;
        Intent r1 = new Intent((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), DownloadHandleService.class);     // Catch: Throwable -> L14
        r1.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");     // Catch: Throwable -> L14
        ZeusTransformUtils.startService((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r1, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (com.ss.android.socialbase.downloader.utils.c.c() == true) goto L12;
        b(new AnonymousClass2());     // Catch: Throwable -> L14
    L12:
        D = true;     // Catch: Throwable -> L14
    L16:
        monitor-exit(b.class);
        return;
    L14:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L16
    }

    public static void b(com.ss.android.socialbase.downloader.depend.i r2) {
        com.ss.android.socialbase.downloader.depend.i r3 = (com.ss.android.socialbase.downloader.depend.i) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.socialbase.downloader.depend.i.class, "com.obric.memorydata.plugin");
        List<com.ss.android.socialbase.downloader.depend.i> r0 = W;
        monitor-enter(r0);
        if (r3 != null) goto L16;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L16:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (r0.contains(r3) == false) goto L11;
        r0.remove(r3);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    public static synchronized void b(f r1) {
        monitor-enter(b.class);
        c(r1);     // Catch: Throwable -> L7
        monitor-exit(b.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void b(DownloadTask r5, int r6) {
        List<ad> r0 = X;
        monitor-enter(r0);
        Iterator<ad> r1 = r0.iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L10;
        ad r2 = (ad) ZeusTransformUtils.preCheckCast(r1.next(), ad.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r2 == null) goto L6;
        r2.b(r5, r6);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static void b(Runnable r2) {
        b((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), false);
    }

    public static void b(Runnable r2, boolean r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3 == true) goto L7;
    L9:
        j().execute(r4);
        return;
    L7:
        if (com.ss.android.socialbase.downloader.utils.g.a() == true) goto L9;
        r4.run();
    }

    public static void b(ExecutorService r2) {
        ExecutorService r3 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r2, ExecutorService.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        t = r3;
        return;
    }

    static /* synthetic */ void b(boolean r0) {
        d(r0);
    }

    private static void c(f r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == null) goto L7;
        a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    L7:
        if (r3.a() == null) goto L10;
        a(r3.a());
    L10:
        if (r3.t() == null) goto L13;
        a(r3.t());
    L13:
        if (r3.b() == null) goto L16;
        a(r3.b());
    L16:
        if (r3.c() == null) goto L19;
        a(r3.c());
    L19:
        if (r3.d() == null) goto L22;
        d(r3.d());
    L22:
        if (r3.e() == null) goto L25;
        e(r3.e());
    L25:
        if (r3.f() == null) goto L28;
        f(r3.f());
    L28:
        if (r3.g() == null) goto L31;
        g(r3.g());
    L31:
        if (r3.h() == null) goto L34;
        h(r3.h());
    L34:
        if (r3.i() == null) goto L37;
        i(r3.i());
    L37:
        if (r3.j() == null) goto L40;
        a(r3.j());
    L40:
        if (r3.k() == null) goto L43;
        b(r3.k());
    L43:
        if (r3.l() == null) goto L46;
        c(r3.l());
    L46:
        if (r3.m().isEmpty() == true) goto L49;
        a(r3.m());
    L49:
        if (r3.p() == null) goto L52;
        z = r3.p();
    L52:
        if (r3.n() <= 1024) goto L55;
        U = r3.n();
    L55:
        if (r3.o() == false) goto L58;
        D = true;
    L58:
        if (r3.q() == null) goto L65;
        H = r3.q();
        if (H.a() == false) goto L62;
        com.ss.android.socialbase.downloader.network.i r0 = H.b();
    L63:
        a(r0);
        goto L65
    L62:
        r0 = g();
    L65:
        if (r3.u() == null) goto L68;
        a(r3.u());
    L68:
        if (r3.w() == null) goto L71;
        F = r3.w();
    L71:
        if (r3.r() == null) goto L73;
        a(r3.r());
    L73:
        e(r3.s());
        if (r3.v() == null) goto L78;
        a(r3.v());
        return;
    }

    public static void c(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        return;
    L6:
        if (com.ss.android.socialbase.downloader.utils.g.a() == true) goto L8;
        r3.run();
        return;
    L8:
        s().execute(r3);
    }

    public static void c(ExecutorService r2) {
        ExecutorService r3 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r2, ExecutorService.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        w = r3;
        return;
    }

    private static void c(final boolean r1) {
        b(new AnonymousClass1(r1));
    }

    public static synchronized boolean c() {
        monitor-enter(b.class);
        boolean r1 = D;     // Catch: Throwable -> L7
        monitor-exit(b.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static com.ss.android.socialbase.downloader.network.i d() {
        return h;
    }

    public static void d(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        t().execute(r3);
    }

    private static void d(ExecutorService r2) {
        ExecutorService r3 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r2, ExecutorService.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        k = r3;
        return;
    }

    private static void d(boolean r0) {
        if (r0 == false) goto L5;
        com.ss.android.socialbase.downloader.impls.g.a(true).startService();
        return;
    }

    public static List<ak> e() {
        return C;
    }

    private static void e(ExecutorService r2) {
        ExecutorService r3 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r2, ExecutorService.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        l = r3;
        return;
    }

    private static void e(boolean r0) {
        Y = r0;
    }

    public static com.ss.android.socialbase.downloader.f.b f() {
        return A;
    }

    private static void f(ExecutorService r2) {
        ExecutorService r3 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r2, ExecutorService.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        m = r3;
        return;
    }

    public static com.ss.android.socialbase.downloader.network.i g() {
        if (i != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (i != null) goto L9;
        i = new com.ss.android.socialbase.downloader.impls.d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return i;
    }

    private static void g(ExecutorService r2) {
        ExecutorService r3 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r2, ExecutorService.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        o = r3;
        return;
    }

    public static synchronized p h() {
        monitor-enter(b.class);
        p r1 = z;     // Catch: Throwable -> L7
        monitor-exit(b.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private static void h(ExecutorService r2) {
        ExecutorService r3 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r2, ExecutorService.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        p = r3;
        return;
    }

    public static ExecutorService i() {
        if (k != null) goto L24;
        monitor-enter(b.class);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (k != null) goto L18;
        int r4 = Q;     // Catch: Throwable -> L20
        if (q() == false) goto L11;
        long r5 = 8;
        int r3 = r4 / 2;     // Catch: Throwable -> L20
    L12:
        ThreadPoolExecutor r1 = new ThreadPoolExecutor(r3, r4, r5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-cpu-fixed", true));     // Catch: Throwable -> L20
        r1.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L15
    L17:
        k = r1;     // Catch: Throwable -> L20
        goto L18
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L17
    L11:
        r5 = 15;
        r3 = r4;
    L18:
        monitor-exit(b.class);     // Catch: Throwable -> L20
    L24:
        return k;
    }

    private static void i(ExecutorService r2) {
        ExecutorService r3 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r2, ExecutorService.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        q = r3;
        return;
    }

    public static ExecutorService j() {
        if (l == null) goto L6;
        return l;
    L6:
        return i();
    }

    public static ExecutorService k() {
        if (o == null) goto L6;
        return o;
    L6:
        return m();
    }

    public static ExecutorService l() {
        if (p == null) goto L6;
        return p;
    L6:
        return m();
    }

    public static ExecutorService m() {
        if (m != null) goto L24;
        monitor-enter(b.class);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (m != null) goto L18;
        int r4 = S;     // Catch: Throwable -> L20
        if (q() == false) goto L11;
        long r5 = 8;
        int r3 = r4 / 2;     // Catch: Throwable -> L20
    L12:
        ThreadPoolExecutor r1 = new ThreadPoolExecutor(r3, r4, r5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-mix-fixed", true));     // Catch: Throwable -> L20
        r1.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L15
    L17:
        m = r1;     // Catch: Throwable -> L20
        goto L18
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L17
    L11:
        r5 = 15;
        r3 = r4;
    L18:
        monitor-exit(b.class);     // Catch: Throwable -> L20
    L24:
        return m;
    }

    public static ExecutorService n() {
        if (n != null) goto L25;
        monitor-enter(b.class);
    L21:
        th = move-exception;
        throw th;
    L7:
        if (n != null) goto L19;
        int r1 = S;     // Catch: Throwable -> L21
        int r2 = r1 * 2;     // Catch: Throwable -> L21
        long r3 = 15;
        if (r() == false) goto L11;
        r3 = 8;
        int r6 = r1;
    L12:
        int r7 = r1 * 2;     // Catch: Throwable -> L21
        ThreadPoolExecutor r4 = new ThreadPoolExecutor(r6, r7, r3, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-global-throttle", true));     // Catch: Throwable -> L21
        if (r() == true) goto L28;
    L18:
        n = r4;     // Catch: Throwable -> L21
        goto L19
    L28:
        r4.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        goto L18
    L11:
        r6 = r2;
    L19:
        monitor-exit(b.class);     // Catch: Throwable -> L21
    L25:
        return n;
    }

    public static ExecutorService o() {
        if (r != null) goto L24;
        monitor-enter(b.class);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (r != null) goto L18;
        int r4 = R;     // Catch: Throwable -> L20
        if (q() == false) goto L11;
        long r5 = 8;
        int r3 = r4 / 2;     // Catch: Throwable -> L20
    L12:
        ThreadPoolExecutor r1 = new ThreadPoolExecutor(r3, r4, r5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-chunk-fixed", true));     // Catch: Throwable -> L20
        r1.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L15
    L17:
        r = r1;     // Catch: Throwable -> L20
        goto L18
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L17
    L11:
        r5 = 15;
        r3 = r4;
    L18:
        monitor-exit(b.class);     // Catch: Throwable -> L20
    L24:
        return r;
    }

    public static ExecutorService p() {
        if (s != null) goto L20;
        monitor-enter(b.class);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (s != null) goto L14;
        ThreadPoolExecutor r1 = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-segment-fixed", true));     // Catch: Throwable -> L16
        r1.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L11
    L13:
        s = r1;     // Catch: Throwable -> L16
        goto L14
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L16
    L14:
        monitor-exit(b.class);     // Catch: Throwable -> L16
    L20:
        return s;
    }

    static boolean q() {
        if (com.ss.android.socialbase.downloader.g.a.b().optInt("global_thread_pool_opt", 0) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    static boolean r() {
        if (com.ss.android.socialbase.downloader.g.a.b().optInt("throttle_thread_pool_opt", 0) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static ExecutorService s() {
        if (q != null) goto L24;
        monitor-enter(b.class);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (q != null) goto L18;
        int r4 = T;     // Catch: Throwable -> L20
        if (q() == false) goto L11;
        long r5 = 8;
        int r3 = r4 / 2;     // Catch: Throwable -> L20
    L12:
        ThreadPoolExecutor r1 = new ThreadPoolExecutor(r3, r4, r5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-db-fixed", true));     // Catch: Throwable -> L20
        r1.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L15
    L17:
        q = r1;     // Catch: Throwable -> L20
        goto L18
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L17
    L11:
        r5 = 15;
        r3 = r4;
    L18:
        monitor-exit(b.class);     // Catch: Throwable -> L20
    L24:
        return q;
    }

    public static ExecutorService t() {
        if (v != null) goto L25;
        monitor-enter(b.class);
    L21:
        th = move-exception;
        throw th;
    L7:
        if (v == null) goto L9;
    L19:
        monitor-exit(b.class);     // Catch: Throwable -> L21
        goto L25
    L9:
        if (q() == false) goto L11;
        long r5 = 30;
    L12:
        ThreadPoolExecutor r1 = new ThreadPoolExecutor(1, 1, r5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-Single", true));     // Catch: Throwable -> L21
        if (q() == true) goto L26;
    L18:
        v = r1;     // Catch: Throwable -> L21
        goto L19
    L26:
        r1.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        goto L18
    L11:
        r5 = 60;
    L25:
        return v;
    }

    public static ExecutorService u() {
        return w;
    }

    public static OkHttpClient v() {
        if (E != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (E != null) goto L9;
        E = x().build();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return E;
    }

    public static ScheduledExecutorService w() {
        if (u != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (u != null) goto L9;
        u = new ScheduledThreadPoolExecutor(4, new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-Schedule", true));     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return u;
    }

    public static OkHttpClient.Builder x() {
        OkHttpClient.Builder r0 = new OkHttpClient.Builder();
        int r1 = com.ss.android.socialbase.downloader.g.a.b().optInt("connect_timeout", LocationInfoConst.HALF_MINUTES);
        long r2 = com.ss.android.socialbase.downloader.g.a.b().optInt("io_timeout", LocationInfoConst.HALF_MINUTES);
        r0.connectTimeout(r1, TimeUnit.MILLISECONDS).readTimeout(r2, TimeUnit.MILLISECONDS).writeTimeout(r2, TimeUnit.MILLISECONDS).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
        if (t == null) goto L5;
        r0.dispatcher(new Dispatcher(t));
    L5:
        return r0;
    }

    public static ExecutorService y() {
        if (x != null) goto L22;
        monitor-enter(b.class);
    L18:
        th = move-exception;
        throw th;
    L7:
        if (x != null) goto L16;
        int r1 = com.ss.android.socialbase.downloader.g.a.b().optInt("fast_download_thread_pool_size_limit");     // Catch: Throwable -> L18
        if (r1 > 0) goto L11;
        r1 = 20;
    L11:
        int r4 = r1;
        if (q() == false) goto L14;
        long r5 = 15;
    L15:
        x = new ThreadPoolExecutor(0, r4, r5, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-Fast", true));     // Catch: Throwable -> L18
        goto L16
    L14:
        r5 = 60;
    L16:
        monitor-exit(b.class);     // Catch: Throwable -> L18
    L22:
        return x;
    }

    public static com.ss.android.socialbase.downloader.network.f z() {
        return F;
    }
}
