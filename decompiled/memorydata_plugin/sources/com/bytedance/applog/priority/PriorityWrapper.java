package com.bytedance.applog.priority;

import android.content.Context;
import android.net.Uri;
import com.bytedance.applog.log.NativeLogWrapper;
import com.bytedance.applog.log.q;
import com.bytedance.applog.priority.original.o;
import com.bytedance.applog.priority.original.u;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PriorityWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f1777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.applog.log.b<Boolean> f1778b = null;
    private static final List<String> c = null;
    private static volatile boolean e;
    private static int f;
    private static int g;
    private static int h;
    private static int i;
    private static int j;
    private static int n;
    private static int o;
    private final AtomicBoolean d;
    private final g k;
    private final String l;
    private com.bytedance.applog.priority.original.i m;
    private volatile boolean p;

    public static final enum NativeThreadType extends Enum<NativeThreadType> {
        private static final /* synthetic */ NativeThreadType[] $VALUES = null;
        public static final NativeThreadType Android = null;
        public static final NativeThreadType Native = null;
        private final int value;

        static {
            NativeThreadType r0 = new NativeThreadType("Native", 0, 0);
            Native = r0;
            NativeThreadType r1 = new NativeThreadType(LocationInfoConst.SYSTEM, 1, 1);
            Android = r1;
            $VALUES = new NativeThreadType[]{r0, r1};
        }

        private NativeThreadType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        static /* synthetic */ int access$000(NativeThreadType r0) {
            return r0.value;
        }

        public static NativeThreadType valueOf(String r2) {
            return (NativeThreadType) ZeusTransformUtils.preCheckCast(Enum.valueOf(NativeThreadType.class, r2), NativeThreadType.class, "com.obric.memorydata.plugin");
        }

        public static NativeThreadType[] values() {
            return (NativeThreadType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NativeThreadType[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        c = Collections.singletonList("Priority3");
        e = true;
        f1777a = 0;
        f = 1;
        g = 2;
        h = 3;
        i = 4;
        j = 9;
        n = 0;
        o = 0;
        f1778b = new AnonymousClass1();
    }

    public PriorityWrapper(Context r10, e r11) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        this.d = new AtomicBoolean(false);
        this.m = null;
        this.p = false;
        q.a().a(c, "create priority wrapper with native: {} with config: {}", new Object[]{Boolean.valueOf(e), r11});
        this.l = r11.a();
        if (r11.c() == false) goto L5;
        com.bytedance.applog.log.a r12 = new d(r11.f());
    L6:
        com.bytedance.applog.log.a r3 = r12;
        String[] r13 = a(r3, r11.b());
        if (r13 == null) goto L9;
        String r0 = r13[0];
        String r6 = r13[1];
        String r5 = r0;
    L10:
        g r14 = new g(r1, r11, r3, a(r1.getFilesDir().getAbsolutePath()), r5, r6);
        this.k = r14;
        if (e == true) goto L13;
        this.m = com.bytedance.applog.priority.original.i.f1836a.a(r14);
        return;
    L13:
        f1778b.c(new Object[0]);
        c();
        if (r11.c() == false) goto L18;
        NativeLogWrapper.a(true);
        return;
    L18:
        return;
    L9:
        r5 = "";
        r6 = r5;
        goto L10
    L5:
        r12 = new com.bytedance.applog.log.f();
        goto L6
    }

    private String a(String r2) {
        File r1 = new File(r2 + "/applog_priority_db");
        if (r1.exists() == true) goto L6;
        r1.mkdirs();
    L6:
        return r1.getAbsolutePath();
    }

    private static /* synthetic */ String a(boolean r2, int r3, String r4) {
        return "match: " + r2 + " eventType: " + r3 + " eventName: " + r4;
    }

    private static /* synthetic */ void a(Pair r4) {
        onHttpPostResponse(((Long) ZeusTransformUtils.preCheckCast(r4.getFirst(), Long.class, "com.obric.memorydata.plugin")).longValue(), (PriorityHttpResponse) ZeusTransformUtils.preCheckCast(r4.getSecond(), PriorityHttpResponse.class, "com.obric.memorydata.plugin"));
    }

    private String[] a(com.bytedance.applog.log.a r4, String r5) {
        com.bytedance.applog.log.a r3 = (com.bytedance.applog.log.a) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.applog.log.a.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
    L11:
        return null;
    L5:
        if (r5.isEmpty() == true) goto L11;
        Uri r6 = Uri.parse(r5);     // Catch: Throwable -> L9
        return new String[]{r6.getScheme() + "://" + r6.getHost(), r6.getPath()};
    L9:
        th = move-exception;
        r3.a("nativeInit", th, $$Lambda$PriorityWrapper$h9RQgGuY6IEQT_F9r9Kav_if91g.INSTANCE);
        goto L11
    }

    private static /* synthetic */ String b(int r2) {
        return "native invoke init failed: " + r2;
    }

    private static /* synthetic */ String c(int r2) {
        return "add session duration to native failed: " + r2;
    }

    private static /* synthetic */ String c(JSONObject r2) {
        return "sart update priority config by default response: " + r2;
    }

    private void c() {
        this.k.b().a("nativeInit", $$Lambda$PriorityWrapper$GjyVSlxAE7Dh7TVG5uIb2FJ3G_I.INSTANCE);
        if (this.k.a().c() == false) goto L5;
        NativeLogWrapper.a(true);
    L5:
        setDefaultThreadNum(n);
        setThreadType(o);
        final int r0 = nativeInitPriority(this.l, this.k.c(), this.k.d(), this.k.e(), new NativePriorityCallbackImpl(this.k.a().f(), this.k.b(), $$Lambda$PriorityWrapper$mQYkAaWQS6UtxQx2fe81F6x63ho.INSTANCE), new NativePriorityEventMetaFactoryImpl(this.k.a().g()), this.k.a().d(), this.k.a().e());
        if (r0 != f1777a) goto L8;
        this.p = nativeIsPriorityEmpty(this.l);
        this.k.b().a("PriorityWrapper:nativeInit", $$Lambda$PriorityWrapper$P6DjT3n4Q2tr2jTaiRWsU1ZK9J8.INSTANCE);
        return;
    L8:
        this.k.b().a("PriorityWrapper:onPriorityEvent", null, new $$Lambda$PriorityWrapper$yuUHkABN4j44VbjXMW8jgGHWaCA(r0));
    }

    private static /* synthetic */ String d() {
        return "parseDefaultReportUrl error: ";
    }

    private static /* synthetic */ String d(int r2) {
        return "new session to native failed: " + r2;
    }

    private static /* synthetic */ String e() {
        return "init native priority success!";
    }

    private static /* synthetic */ String e(int r2) {
        return "native invoke onEvent failed: " + r2;
    }

    private static /* synthetic */ String f() {
        return "start init native priority...";
    }

    private static /* synthetic */ String g() {
        return "start flush priority...";
    }

    private static /* synthetic */ String h() {
        return "add version config error!";
    }

    private static /* synthetic */ String i() {
        return "native config is empty, skip event!";
    }

    private static native int initHooks();

    private static /* synthetic */ String j() {
        return "init failed";
    }

    private static /* synthetic */ String k() {
        return "start to init priority...";
    }

    /* JADX INFO: renamed from: lambda$0A3ZZs3Hu0c_KaSG5Ay1c-qw940, reason: not valid java name */
    public static /* synthetic */ String m77lambda$0A3ZZs3Hu0c_KaSG5Ay1cqw940(int r0) {
        return e(r0);
    }

    public static /* synthetic */ String lambda$3MuOSB9wKVZfloxFfAqf5NJ5kxg(int r0) {
        return d(r0);
    }

    public static /* synthetic */ String lambda$GjyVSlxAE7Dh7TVG5uIb2FJ3G_I() {
        return f();
    }

    public static /* synthetic */ String lambda$ISzDPFZT_bpfDNNd95TdLLnZteQ(boolean r0, int r1, String r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ String lambda$P6DjT3n4Q2tr2jTaiRWsU1ZK9J8() {
        return e();
    }

    /* JADX INFO: renamed from: lambda$Pywj7-bErHUjfArus0JLtETqR5Y, reason: not valid java name */
    public static /* synthetic */ String m78lambda$Pywj7bErHUjfArus0JLtETqR5Y() {
        return h();
    }

    public static /* synthetic */ String lambda$ZhvJxx8AYnXoEgVrgbyI2qVE1WY() {
        return i();
    }

    public static /* synthetic */ String lambda$aeTWmiFW3aIZmIGnrvWzOPHSBF4() {
        return j();
    }

    public static /* synthetic */ String lambda$h9RQgGuY6IEQT_F9r9Kav_if91g() {
        return d();
    }

    public static /* synthetic */ String lambda$hDamU2qYZJLkYXr9yM5OpA56_Nw() {
        return k();
    }

    public static /* synthetic */ void lambda$mQYkAaWQS6UtxQx2fe81F6x63ho(Pair r0) {
        a(r0);
    }

    public static /* synthetic */ String lambda$mzWpERzeLgNrdnE4nefhzNikY70(JSONObject r0) {
        return c(r0);
    }

    public static /* synthetic */ String lambda$odNkdcWgvtbRyPE6oDBiQIAaF4w() {
        return g();
    }

    public static /* synthetic */ String lambda$omKItjYThT6U_08mxcJYTcB7UEY(int r0) {
        return c(r0);
    }

    public static /* synthetic */ String lambda$yuUHkABN4j44VbjXMW8jgGHWaCA(int r0) {
        return b(r0);
    }

    private static native int nativeAddSessionDuration(String r0, String r1, String r2, long r3, String r5);

    private static native int nativeInitPriority(String r0, String r1, String r2, String r3, PriorityCallback r4, PriorityEventMetaFactory r5, boolean r6, boolean r7);

    private static native boolean nativeIsPriorityEmpty(String r0);

    private static native boolean nativeIsPriorityMatchEventType(String r0, int r1);

    private static native int nativeNewSession(String r0, String r1, boolean r2, long r3, String r5);

    private static native int nativePriorityFlush(String r0);

    private static native String nativePriorityGetVersionConfig(String r0);

    private static native int nativePriorityOnEvent(String r0, int r1, String r2, NativeLazyString r3);

    private static native int nativePrioritySetConfig(String r0, String r1);

    private static native int nativeStartPriority(String r0);

    private static native void onHttpPostResponse(long r0, PriorityHttpResponse r2);

    private static native void setDefaultThreadNum(int r0);

    private static native void setThreadType(int r0);

    public synchronized void a() {
        monitor-enter(this);
        this.k.b().a("initPriority", $$Lambda$PriorityWrapper$hDamU2qYZJLkYXr9yM5OpA56_Nw.INSTANCE);     // Catch: Throwable -> L19
        if (this.d.get() == false) goto L22;
        monitor-exit(this);
        return;
    L22:
    L15:
        th = move-exception;
        this.k.b().a("initPriority", th, $$Lambda$PriorityWrapper$aeTWmiFW3aIZmIGnrvWzOPHSBF4.INSTANCE);     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);
        return;
    L8:
        if (e == true) goto L12;
        com.bytedance.applog.priority.original.i r0 = this.m;     // Catch: Throwable -> L15
        if (r0 == null) goto L13;
        r0.a();     // Catch: Throwable -> L15
    L13:
        this.d.set(true);     // Catch: Throwable -> L15
    L12:
        nativeStartPriority(this.l);     // Catch: Throwable -> L15
    L19:
        th = move-exception;
        throw th;
    }

    public void a(String r8, String r9, long r10, String r12) {
        if (e == false) goto L7;
        final int r11 = nativeAddSessionDuration(this.l, r8, r9, r10, r12);
        if (f1777a == r11) goto L9;
        this.k.b().a("PriorityWrapper:addSessionDuration", null, new $$Lambda$PriorityWrapper$omKItjYThT6U_08mxcJYTcB7UEY(r11));
        return;
    L9:
        return;
    L7:
        this.m.a(r8, r9, r10, r12);
    }

    public void a(String r8, boolean r9, long r10, String r12) {
        if (e == false) goto L7;
        final int r11 = nativeNewSession(this.l, r8, r9, r10, r12);
        if (f1777a == r11) goto L9;
        this.k.b().a("PriorityWrapper:newSession", null, new $$Lambda$PriorityWrapper$3MuOSB9wKVZfloxFfAqf5NJ5kxg(r11));
        return;
    L9:
        return;
    L7:
        this.m.a(r8, r9, r10, r12);
    }

    public void a(JSONObject r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (this.d.get() == false) goto L46;
        JSONObject r0 = null;
    L32:
        th = move-exception;
        this.k.b().a("addDefaultPriorityOptions", th, $$Lambda$PriorityWrapper$Pywj7bErHUjfArus0JLtETqR5Y.INSTANCE);
        if (this.k.a().f().isMonitorEnabled() == false) goto L45;
        this.k.a().f().monitorError("priority addDefaultPriorityOptions error", th.toString());
        return;
    L45:
        return;
    L8:
        if (e == false) goto L14;
        String r1 = nativePriorityGetVersionConfig(this.l);     // Catch: Throwable -> L32
        if (r1 == null) goto L18;
        if (r1.isEmpty() == true) goto L18;
        r0 = new JSONObject(r1);     // Catch: Throwable -> L32
    L18:
        if (r0 != null) goto L20;
    L27:
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L32
        r2.put("version", 0);     // Catch: Throwable -> L32
        Iterator<String> r3 = f.f1787a.a().iterator();     // Catch: Throwable -> L32
    L29:
        if (r3.hasNext() == false) goto L48;
        r6.put((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin"), r2);     // Catch: Throwable -> L32
        goto L29
    L48:
        return;
    L20:
        if (r0.length() <= 0) goto L27;
        Iterator<String> r4 = f.f1787a.a().iterator();     // Catch: Throwable -> L32
    L23:
        if (r4.hasNext() == false) goto L47;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        Object r7 = r0.optJSONObject(r5);     // Catch: Throwable -> L32
        if (r7 == null) goto L23;
        r6.put(r5, r7);     // Catch: Throwable -> L32
        goto L23
    L47:
        return;
    L14:
        com.bytedance.applog.priority.original.i r8 = this.m;     // Catch: Throwable -> L32
        if (r8 == null) goto L18;
        r0 = r8.d();     // Catch: Throwable -> L32
        goto L18
    }

    public boolean a(int r2) {
        if (e == false) goto L7;
        return nativeIsPriorityMatchEventType(this.l, r2);
    L7:
        return this.m.a(r2);
    }

    public boolean a(final int r6, final String r7, u<JSONObject> r8) {
        u r9 = (u) ZeusTransformUtils.wrapperContextForParams(r8, u.class, "com.obric.memorydata.plugin");
        final boolean r2 = false;
        if (e == true) goto L11;
        com.bytedance.applog.priority.original.i r0 = this.m;
        if (r0 != null) goto L7;
    L26:
        this.k.b().a("PriorityWrapper:onPriorityEvent", new $$Lambda$PriorityWrapper$ISzDPFZT_bpfDNNd95TdLLnZteQ(r2, r6, r7));
        return r2;
    L7:
        if (r0.b() == false) goto L9;
        return false;
    L9:
        o r1 = new o(r9);
        r2 = this.m.a(r7, r6, r1);
        goto L26
    L11:
        if (this.p == false) goto L15;
        this.k.b().a("onPriorityEvent", $$Lambda$PriorityWrapper$ZhvJxx8AYnXoEgVrgbyI2qVE1WY.INSTANCE);
        return false;
    L15:
        if (nativeIsPriorityMatchEventType(this.l, r6) == true) goto L17;
        return false;
    L17:
        final int r10 = nativePriorityOnEvent(this.l, r6, r7, new NativeLazyString(r9));
        int r3 = h;
        if (r10 != r3) goto L21;
        r2 = true;
    L21:
        if (r10 == f1777a) goto L26;
        if (r10 == r3) goto L26;
        if (r10 == i) goto L26;
        this.k.b().a("PriorityWrapper:onPriorityEvent", null, new $$Lambda$PriorityWrapper$0A3ZZs3Hu0c_KaSG5Ay1cqw940(r10));
        goto L26
    }

    public void b() {
        this.k.b().a(ObricMemoryConstants.VALUE_IN_APP_SIGNAL_ACTION_FLUSH, $$Lambda$PriorityWrapper$odNkdcWgvtbRyPE6oDBiQIAaF4w.INSTANCE);
        if (e == true) goto L7;
        com.bytedance.applog.priority.original.i r3 = this.m;
        if (r3 == null) goto L9;
        r3.c();
        return;
    L9:
        return;
    L7:
        nativePriorityFlush(this.l);
    }

    public void b(final JSONObject r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (this.d.get() == false) goto L30;
        boolean r0 = false;
        Iterator<String> r1 = f.f1787a.b().iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        if (r6.has((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L8;
        r0 = true;
    L12:
        if (r0 == false) goto L26;
        this.k.b().a("parsePriorityConfigFromServerResponse", new $$Lambda$PriorityWrapper$mzWpERzeLgNrdnE4nefhzNikY70(r6));
        if (e == true) goto L19;
        com.bytedance.applog.priority.original.i r5 = this.m;
        if (r5 == null) goto L27;
        r5.b(r6);
        return;
    L27:
        return;
    L19:
        if (nativePrioritySetConfig(this.l, r6.toString()) != f1777a) goto L29;
        this.p = nativeIsPriorityEmpty(this.l);
        return;
    L29:
        return;
    L26:
        return;
    }
}
