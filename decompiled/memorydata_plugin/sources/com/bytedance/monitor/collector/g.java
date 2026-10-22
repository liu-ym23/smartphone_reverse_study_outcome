package com.bytedance.monitor.collector;

import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g extends com.bytedance.monitor.collector.b {
    private static int A;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f2839b;
    public static boolean c;
    public static boolean d;
    private static int e;
    private static int f;
    private static volatile com.bytedance.monitor.collector.f t;
    private static int[] y;
    private static int[] z;
    private Runnable B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    c f2840a;
    private int g;
    private volatile int h;
    private int i;
    private int j;
    private f k;
    private b l;
    private long m;
    private long n;
    private int o;
    private long p;
    private String q;
    private String r;
    private com.bytedance.monitor.collector.a s;
    private volatile boolean u;
    private boolean v;
    private final com.bytedance.apm.l.e w;
    private volatile boolean x;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f2847a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f2848b;
        long c;
        boolean d;
        int e;
        String f;

        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        public JSONObject a() {
            JSONObject r0 = new JSONObject();
            r0.put("startTime", this.f2847a);     // Catch: JSONException -> L5
            r0.put("cost", this.f2848b);     // Catch: JSONException -> L5
            r0.put("delay", this.c);     // Catch: JSONException -> L5
            r0.put("isMessage", String.valueOf(this.d));     // Catch: JSONException -> L5
            r0.put("seqNum", this.e);     // Catch: JSONException -> L5
            r0.put("stack", this.f);     // Catch: JSONException -> L5
        L7:
            return r0;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }

        void b() {
            this.f2847a = -1;
            this.f2848b = -1;
            this.c = -1;
            this.e = -1;
            this.f = null;
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f2849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        a f2850b;
        final List<a> c;
        private int d;

        public b(int r2) {
            this.d = 0;
            this.f2849a = r2;
            this.c = new ArrayList(r2);
        }

        a a() {
            a r0 = this.f2850b;
            AnonymousClass1 r1 = null;
            if (r0 == null) goto L6;
            this.f2850b = null;
            return r0;
        L6:
            return new a(r1);
        }

        void a(a r3) {
            int r0 = this.c.size();
            int r1 = this.f2849a;
            if (r0 >= r1) goto L5;
            this.c.add(r3);
            int r4 = this.c.size();
        L6:
            this.d = r4;
            return;
        L5:
            int r2 = this.d % r1;
            this.d = r2;
            a r5 = (a) ZeusTransformUtils.preCheckCast(this.c.set(r2, r3), a.class, "com.obric.memorydata.plugin");
            r5.b();
            this.f2850b = r5;
            r4 = this.d + 1;
            goto L6
        }

        JSONArray b() {
            JSONArray r0 = new JSONArray();
            int r3 = 0;
            if (this.c.size() != this.f2849a) goto L12;
            int r1 = this.d - 1;
        L6:
            if (r1 >= this.c.size()) goto L9;
            r0.put(((a) ZeusTransformUtils.preCheckCast(this.c.get(r1), a.class, "com.obric.memorydata.plugin")).a());
            r1 = r1 + 1;
        L9:
            if (r3 >= (this.d - 1)) goto L14;
            r0.put(((a) ZeusTransformUtils.preCheckCast(this.c.get(r3), a.class, "com.obric.memorydata.plugin")).a());
            r3 = r3 + 1;
        L14:
            return r0;
        L12:
            if (r3 >= this.c.size()) goto L14;
            r0.put(((a) ZeusTransformUtils.preCheckCast(this.c.get(r3), a.class, "com.obric.memorydata.plugin")).a());
            r3 = r3 + 1;
            goto L12
        }
    }

    public interface c {
        void a(long[] r1);
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f2851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f2852b;
        long c;
        long d;
        long e;

        public d() {
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f2853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f2854b;
        long c;
        int d;
        int e;
        long f;
        long g;
        com.bytedance.monitor.collector.a.c h;
        String i;
        public String j;
        StackTraceElement[] k;
        StackTraceElement[] l;
        String m;
        String n;
        d o;

        public e() {
        }

        private void a(JSONObject r8) {
            StackTraceElement[] r0 = this.k;
            if (r0 == null) goto L5;
            r8.put("block_stack", o.a(r0));
        L5:
            r8.put("block_uuid", this.n);
            StackTraceElement[] r1 = this.l;
            if (r1 == null) goto L8;
            r8.put("sblock_stack", o.a(r1));
        L8:
            r8.put("sblock_uuid", this.n);
            if (TextUtils.isEmpty(this.m) == false) goto L12;
            r8.put("evil_msg", this.m);
        L12:
            if (this.o == null) goto L14;
            boolean r2 = true;
        L15:
            r8.put("belong_frame", r2);
            d r3 = this.o;
            if (r3 == null) goto L18;
            r8.put("vsyncDelayTime", this.c - (r3.f2851a / TimeUtils.NANOSECONDS_PER_MILLISECOND));
            r8.put("doFrameTime", (this.o.f2852b / TimeUtils.NANOSECONDS_PER_MILLISECOND) - this.c);
            r8.put("inputHandlingTime", (this.o.c / TimeUtils.NANOSECONDS_PER_MILLISECOND) - (this.o.f2852b / TimeUtils.NANOSECONDS_PER_MILLISECOND));
            r8.put("animationsTime", (this.o.d / TimeUtils.NANOSECONDS_PER_MILLISECOND) - (this.o.c / TimeUtils.NANOSECONDS_PER_MILLISECOND));
            r8.put("performTraversalsTime", (this.o.e / TimeUtils.NANOSECONDS_PER_MILLISECOND) - (this.o.d / TimeUtils.NANOSECONDS_PER_MILLISECOND));
            r8.put("drawTime", this.f2854b - (this.o.e / TimeUtils.NANOSECONDS_PER_MILLISECOND));
        L18:
            com.bytedance.monitor.collector.a.c r4 = this.h;
            if (r4 == null) goto L22;
            r8.put("service_name", r4.f2833a);
            r8.put("service_what", this.h.f2834b);
            r8.put("service_time", this.h.c);
            r8.put("service_thread", this.h.e);
            r8.put("service_token", this.h.d);
            return;
        L22:
            return;
        L14:
            r2 = false;
            goto L15
        }

        public JSONObject a() {
            JSONObject r0 = new JSONObject();
            r0.put(NotificationCompat.CATEGORY_MESSAGE, o.a(this.i));     // Catch: JSONException -> L5
            r0.put("cpuDuration", this.g);     // Catch: JSONException -> L5
            r0.put("duration", this.f);     // Catch: JSONException -> L5
            r0.put("type", this.d);     // Catch: JSONException -> L5
            r0.put("messageCount", this.e);     // Catch: JSONException -> L5
            r0.put("lastDuration", this.f2854b - this.c);     // Catch: JSONException -> L5
            r0.put(CommonConsts.APM_INNER_EVENT_COST_START, this.f2853a);     // Catch: JSONException -> L5
            r0.put("end", this.f2854b);     // Catch: JSONException -> L5
            a(r0);     // Catch: JSONException -> L5
        L7:
            return r0;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }

        public void a(String r2, StackTraceElement[] r3, StackTraceElement[] r4, String r5) {
            if (TextUtils.isEmpty(r2) == true) goto L5;
            this.n = r2;
        L5:
            if (r3 == null) goto L7;
            this.k = r3;
        L7:
            if (r4 == null) goto L10;
            this.l = r4;
        L10:
            if (TextUtils.isEmpty(r5) == true) goto L13;
            this.m = r5;
            return;
        }

        public String b() {
            return "msg:" + o.a(this.i) + ",cpuDuration:" + this.g + ",duration:" + this.f + ",type:" + this.d + ",messageCount:" + this.e + ",lastDuration:" + (this.f2854b - this.c) + ",start:" + this.f2853a + ",end:" + this.f2854b;
        }

        boolean c() {
            if ((this.f2854b - this.c) <= 17) goto L5;
            return true;
        L5:
            if (this.f > 400) goto L22;
            int r0 = this.e;
            if (r0 <= 300) goto L10;
            return true;
        L10:
            if (r0 >= 20) goto L13;
            return true;
        L13:
            if (this.d != 1) goto L16;
            return true;
        L16:
            if (this.g < 20) goto L24;
            return false;
        L24:
            return true;
        L22:
            return true;
        }

        void d() {
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.i = null;
            this.k = null;
            this.l = null;
            this.m = null;
            this.n = null;
            this.o = null;
            this.h = null;
            this.j = null;
        }
    }

    private static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2856b;
        e c;
        List<e> d;

        f(int r2) {
            this.d = new ArrayList();
            this.f2855a = r2;
        }

        e a() {
            int r0 = this.f2856b;
            if (r0 > 0) goto L7;
            return null;
        L7:
            return (e) ZeusTransformUtils.preCheckCast(this.d.get(r0 - 1), e.class, "com.obric.memorydata.plugin");
        }

        e a(int r2) {
            e r0 = this.c;
            if (r0 == null) goto L5;
            r0.d = r2;
            e r3 = this.c;
            this.c = null;
            return r3;
        L5:
            e r1 = new e();
            r1.d = r2;
            return r1;
        }

        void a(e r4) {
            int r0 = this.d.size();
            int r1 = this.f2855a;
            if (r0 >= r1) goto L5;
            this.d.add(r4);
            int r2 = this.d.size();
        L6:
            this.f2856b = r2;
            if (com.bytedance.apm.e.a.a() == true) goto L9;
            return;
        L9:
            if (r4.c() == false) goto L13;
            final String r5 = r4.b();
            com.bytedance.apm.l.b.a().a(new AnonymousClass1(this, r5));
            return;
        L13:
            return;
        L5:
            int r3 = this.f2856b % r1;
            this.f2856b = r3;
            e r6 = (e) ZeusTransformUtils.preCheckCast(this.d.set(r3, r4), e.class, "com.obric.memorydata.plugin");
            r6.d();
            this.c = r6;
            r2 = this.f2856b + 1;
            goto L6
        }

        List<e> b() {
            ArrayList r0 = new ArrayList();
            int r3 = 0;
            if (this.d.size() != this.f2855a) goto L12;
            int r1 = this.f2856b - 1;
        L6:
            if (r1 >= this.d.size()) goto L9;
            r0.add((e) ZeusTransformUtils.preCheckCast(this.d.get(r1), e.class, "com.obric.memorydata.plugin"));
            r1 = r1 + 1;
        L9:
            if (r3 >= (this.f2856b - 1)) goto L14;
            r0.add((e) ZeusTransformUtils.preCheckCast(this.d.get(r3), e.class, "com.obric.memorydata.plugin"));
            r3 = r3 + 1;
        L14:
            return r0;
        L12:
            if (r3 >= this.d.size()) goto L14;
            r0.add(this.d.get(r3));
            r3 = r3 + 1;
            goto L12
        }
    }

    static {
        y = new int[]{600, 300};
        z = new int[]{200, 100};
        f2839b = false;
        c = false;
        d = false;
    }

    public g(int r4, boolean r5) {
        super(r4, "block_looper_info");
        this.g = 0;
        this.h = 0;
        this.i = 100;
        this.j = 200;
        this.m = -1;
        this.n = -1;
        this.o = -1;
        this.p = -1;
        this.u = false;
        this.v = false;
        this.x = false;
        this.B = new AnonymousClass2(this);
        com.bytedance.monitor.collector.a.d.a().b();
        this.f2840a = new AnonymousClass1(this);
        if (r5 == false) goto L5;
    L8:
        com.bytedance.apm.l.e r6 = new com.bytedance.apm.l.e("looper_monitor__");
        this.w = r6;
        r6.a();
        k();
        this.l = new b(300);
        r6.a(this.B, e);
        return;
    L5:
        if (f2839b == true) goto L8;
        this.w = null;
    }

    static /* synthetic */ String a(g r0, String r1) {
        r0.r = r1;
        return r1;
    }

    private JSONArray a(int r7, long r8) {
        MessageQueue r6 = i.a();
        JSONArray r0 = new JSONArray();
        if (r6 != null) goto L24;
        return r0;
    L24:
        monitor-enter(r6);     // Catch: Throwable -> L21
        Message r1 = i.a(r6);     // Catch: Throwable -> L18
        if (r1 != null) goto L10;
        monitor-exit(r6);     // Catch: Throwable -> L18
        return r0;
    L10:
        int r2 = 0;
        int r3 = 0;
    L11:
        if (r1 == null) goto L16;
        if (r2 >= r7) goto L16;
        r2 = r2 + 1;     // Catch: Throwable -> L18
        r3 = r3 + 1;     // Catch: Throwable -> L18
        JSONObject r4 = a(r1, r8);     // Catch: Throwable -> L18
        r4.put(OaidModel.KEY_ID, r3);     // Catch: JSONException -> L22 Throwable -> L18
    L15:
        r0.put(r4);     // Catch: Throwable -> L18
        r1 = i.a(r1);     // Catch: Throwable -> L18
    L16:
        monitor-exit(r6);     // Catch: Throwable -> L18
        return r0;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        return r0;
    }

    private JSONObject a(long r7) {
        JSONObject r0 = new JSONObject();
        r0.put("message", this.r);     // Catch: Throwable -> L5
        r0.put("currentMessageCost", r7 - this.n);     // Catch: Throwable -> L5
        r0.put("currentMessageCpu", l.a(this.o) - this.p);     // Catch: Throwable -> L5
        r0.put("messageCount", this.g);     // Catch: Throwable -> L5
        r0.put(CommonConsts.APM_INNER_EVENT_COST_START, this.n);     // Catch: Throwable -> L5
        r0.put("end", r7);     // Catch: Throwable -> L5
    L4:
        return r0;
    }

    private static JSONObject a(Message r3, long r4) {
        JSONObject r0 = new JSONObject();
        if (r3 != null) goto L20;
        return r0;
    L20:
        r0.put("when", r3.getWhen() - r4);     // Catch: JSONException -> L17
        if (r3.getCallback() == null) goto L8;
        r0.put("callback", String.valueOf(r3.getCallback()));     // Catch: JSONException -> L17
    L8:
        r0.put("what", r3.what);     // Catch: JSONException -> L17
        if (r3.getTarget() == null) goto L11;
        r0.put(TypedValues.AttributesType.S_TARGET, String.valueOf(r3.getTarget()));     // Catch: JSONException -> L17
    L12:
        r0.put("arg1", r3.arg1);     // Catch: JSONException -> L17
        r0.put("arg2", r3.arg2);     // Catch: JSONException -> L17
        if (r3.obj == null) goto L15;
        r0.put("obj", String.valueOf(r3.obj));     // Catch: JSONException -> L17
    L15:
        r0.put(CommonConsts.APM_INNER_EVENT_COST_START, r3.getWhen());     // Catch: JSONException -> L17
        r0.put("end", -1);     // Catch: JSONException -> L17
    L19:
        return r0;
    L11:
        r0.put("barrier", r3.arg1);     // Catch: JSONException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    private void a(int r8, long r9, String r11) {
        a(r8, r9, r11, true, null);
    }

    private void a(int r5, long r6, String r8, boolean r9, com.bytedance.monitor.collector.a.c r10) {
        this.v = true;
        e r7 = this.k.a(r5);
        r7.f = r6 - this.m;
        if (r9 == false) goto L5;
        long r0 = SystemClock.currentThreadTimeMillis();
        r7.g = r0 - this.p;
        this.p = r0;
    L6:
        r7.e = this.g;
        r7.i = r8;
        r7.j = this.q;
        r7.f2853a = this.m;
        r7.f2854b = r6;
        r7.c = this.n;
        if (r10 == null) goto L9;
        r7.h = r10;
    L9:
        this.k.a(r7);
        this.g = 0;
        this.m = r6;
        return;
    L5:
        r7.g = -1;
        goto L6
    }

    static /* synthetic */ void a(g r0, boolean r1, long r2) {
        r0.a(r1, r2);
    }

    private void a(final boolean r14, final long r15) {
        int r0 = this.h + 1;
        this.h = r0;
        this.h = r0 & 65535;
        this.v = false;
        if (this.m >= 0) goto L6;
        this.m = r15;
    L6:
        if (this.n >= 0) goto L9;
        this.n = r15;
    L9:
        if (this.o >= 0) goto L11;
        this.o = Process.myTid();
        this.p = SystemClock.currentThreadTimeMillis();
    L11:
        com.bytedance.monitor.collector.a.c r10 = com.bytedance.monitor.collector.a.d.c();
        com.bytedance.monitor.collector.a.d.d();
        long r2 = r15 - this.m;
        int r1 = this.j;
        if (r2 > r1) goto L14;
        if (r10 != null) goto L14;
    L29:
        this.n = r15;
        final String r11 = this.r;
        if (this.isHyperMode == false) goto L33;
        final long r5 = SystemClock.currentThreadTimeMillis();
        k.a().f2868b.b(new AnonymousClass4(this, r14, r15, r5, r11));
        return;
    L33:
        return;
    L14:
        long r3 = this.n;
        if ((r15 - r3) > r1) goto L19;
        if (r10 != null) goto L19;
        a(9, r15, this.r);
    L19:
        int r4 = this.g;
        if (r14 == false) goto L24;
        if (r4 != 0) goto L23;
        a(1, r15, "no message running");
        goto L29
    L23:
        a(9, r3, this.q);
        int r6 = 1;
        boolean r7 = false;
        com.bytedance.monitor.collector.a.c r8 = null;
        String r9 = "no message running";
        g r12 = this;
    L28:
        r12.a(r6, r15, r9, r7, r8);
        goto L29
    L24:
        if (r4 != 0) goto L26;
        r6 = 8;
        r9 = this.r;
        r7 = true;
        r12 = this;
    L27:
        r8 = r10;
        goto L28
    L26:
        r12 = this;
        r12.a(9, r3, this.q, false, null);
        r6 = 8;
        r9 = this.r;
        r7 = true;
        goto L27
    }

    static /* synthetic */ boolean a(g r0) {
        return r0.v;
    }

    static /* synthetic */ boolean a(g r0, boolean r1) {
        r0.x = r1;
        return r1;
    }

    static /* synthetic */ f b(g r0) {
        return r0.k;
    }

    static /* synthetic */ String b(g r0, String r1) {
        r0.q = r1;
        return r1;
    }

    static /* synthetic */ b c(g r0) {
        return r0.l;
    }

    static /* synthetic */ int d(g r0) {
        return r0.h;
    }

    static /* synthetic */ boolean e(g r0) {
        return r0.x;
    }

    static /* synthetic */ int f() {
        return A;
    }

    static /* synthetic */ com.bytedance.monitor.collector.f f(g r0) {
        return r0.j();
    }

    static /* synthetic */ int g() {
        return f;
    }

    static /* synthetic */ Runnable g(g r0) {
        return r0.B;
    }

    static /* synthetic */ com.bytedance.apm.l.e h(g r0) {
        return r0.w;
    }

    static /* synthetic */ com.bytedance.monitor.collector.f h() {
        return t;
    }

    static /* synthetic */ int i() {
        return e;
    }

    static /* synthetic */ int i(g r2) {
        int r0 = r2.g;
        r2.g = r0 + 1;
        return r0;
    }

    private com.bytedance.monitor.collector.f j() {
        return t;
    }

    static /* synthetic */ String j(g r0) {
        return r0.r;
    }

    private void k() {
        boolean r3 = d;
        if (r3 == false) goto L5;
    L8:
        if (r3 == false) goto L10;
    L12:
        if (r3 == true) goto L14;
    L16:
        if (r3 == true) goto L18;
        return;
    L18:
        if (c == true) goto L22;
        int r4 = z[0];
        e = r4;
        int r0 = y[1];
    L7:
        f = r0;
        A = r0 / r4;
        return;
    L22:
        return;
    L14:
        if (c == false) goto L16;
        r4 = z[1];
        e = r4;
        r0 = y[1];
        goto L7
    L10:
        if (c == true) goto L12;
        r4 = z[0];
        e = r4;
        r0 = y[0];
        goto L7
    L5:
        if (c == false) goto L8;
        r4 = z[1];
        e = r4;
        r0 = y[0];
        goto L7
    }

    private void l() {
        int r0 = this.mRunMode;
        if (r0 != 0) goto L5;
    L12:
        this.i = 100;
        this.j = 300;
        return;
    L5:
        if (r0 == 1) goto L12;
        if (r0 != 2) goto L9;
    L11:
        this.i = 300;
        this.j = 200;
        return;
    L9:
        if (r0 == 3) goto L11;
    }

    public void a() {
        if (this.u == false) goto L5;
        return;
    L5:
        this.u = true;
        l();
        this.k = new f(this.i);
        com.bytedance.monitor.collector.a r0 = new AnonymousClass3(this);
        this.s = r0;
        h.b(r0);
        i.a(i.a());
    }

    public e b() {
        f r0 = this.k;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (this.v == true) goto L9;
        return null;
    L9:
        if (r0.a().d == 8) goto L12;
        return null;
    L12:
        return this.k.a();
    }

    public JSONObject c() {
        long r0 = SystemClock.uptimeMillis();
        JSONObject r2 = new JSONObject();
        JSONArray r3 = e();
        JSONObject r4 = a(r0);
        JSONArray r1 = a(100, r0);
        r2.put("history_message", r3);     // Catch: JSONException -> L5
        r2.put("current_message", r4);     // Catch: JSONException -> L5
        r2.put("pending_messages", r1);     // Catch: JSONException -> L5
        r2.put("check_time_info", d());     // Catch: JSONException -> L5
    L4:
        return r2;
    }

    public JSONArray d() {
        b r0 = this.l;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.b();
    }

    @Override // com.bytedance.monitor.collector.b
    Pair<String, ?> dumpInfo() {
        return new Pair(this.mCollectorType, c());
    }

    @Override // com.bytedance.monitor.collector.b
    Pair<String, ?> dumpInfosRange(long r1, long r3) {
        return new Pair(this.mCollectorType, c());
    L4:
        return null;
    }

    public JSONArray e() {
        JSONArray r0 = new JSONArray();
        List<e> r5 = this.k.b();     // Catch: Throwable -> L15
        if (r5 != null) goto L6;
        return r0;
    L6:
        int r1 = 0;
        Iterator<e> r6 = r5.iterator();     // Catch: Throwable -> L15
    L8:
        if (r6.hasNext() == false) goto L14;
        e r2 = (e) ZeusTransformUtils.preCheckCast(r6.next(), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r2 == null) goto L8;
        r1 = r1 + 1;     // Catch: Throwable -> L15
        r0.put(r2.a().put(OaidModel.KEY_ID, r1));     // Catch: Throwable -> L15
    L14:
        return r0;
    }

    @Override // com.bytedance.monitor.collector.b
    void start() {
        super.start();
        a();
    }

    @Override // com.bytedance.monitor.collector.b
    void startHyperMode() {
        super.startHyperMode();
    }

    @Override // com.bytedance.monitor.collector.b
    void stopHyperMode() {
        super.stopHyperMode();
    }

    @Override // com.bytedance.monitor.collector.b
    public void updateConfig(int r1) {
    }
}
