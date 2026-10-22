package com.bumptech.glide.request;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.util.k;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class SingleRequest<R> implements com.bumptech.glide.request.a.d, d, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f951a = false;
    private Drawable A;
    private int B;
    private int C;
    private boolean D;
    private RuntimeException E;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f952b;
    private final String c;
    private final com.bumptech.glide.util.pool.b d;
    private final Object e;
    private final e<R> f;
    private final RequestCoordinator g;
    private final Context h;
    private final com.bumptech.glide.e i;
    private final Object j;
    private final Class<R> k;
    private final a<?> l;
    private final int m;
    private final int n;
    private final Priority o;
    private final com.bumptech.glide.request.a.e<R> p;
    private final List<e<R>> q;
    private final com.bumptech.glide.request.b.c<? super R> r;
    private final Executor s;
    private s<R> t;
    private i.d u;
    private long v;
    private volatile i w;
    private Status x;
    private Drawable y;
    private Drawable z;

    private static final enum Status extends Enum<Status> {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status CLEARED = null;
        public static final Status COMPLETE = null;
        public static final Status FAILED = null;
        public static final Status PENDING = null;
        public static final Status RUNNING = null;
        public static final Status WAITING_FOR_SIZE = null;

        private static /* synthetic */ Status[] $values() {
            return new Status[]{PENDING, RUNNING, WAITING_FOR_SIZE, COMPLETE, FAILED, CLEARED};
        }

        static {
            PENDING = new Status("PENDING", 0);
            RUNNING = new Status("RUNNING", 1);
            WAITING_FOR_SIZE = new Status("WAITING_FOR_SIZE", 2);
            COMPLETE = new Status("COMPLETE", 3);
            FAILED = new Status(RawObservationEntity.STATE_FAILED, 4);
            CLEARED = new Status("CLEARED", 5);
            $VALUES = $values();
        }

        private Status(String r1, int r2) {
            super(r1, r2);
        }

        public static Status valueOf(String r2) {
            return (Status) ZeusTransformUtils.preCheckCast(Enum.valueOf(Status.class, r2), Status.class, "com.obric.memorydata.plugin");
        }

        public static Status[] values() {
            return (Status[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Status[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f951a = Log.isLoggable("GlideRequest", 2);
    }

    private SingleRequest(Context r12, com.bumptech.glide.e r13, Object r14, Object r15, Class<R> r16, a<?> r17, int r18, int r19, Priority r20, com.bumptech.glide.request.a.e<R> r21, e<R> r22, List<e<R>> r23, RequestCoordinator r24, i r25, com.bumptech.glide.request.b.c<? super R> r26, Executor r27) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.e r3 = (com.bumptech.glide.e) ZeusTransformUtils.wrapperContextForParams(r13, com.bumptech.glide.e.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.request.a.e<R> r4 = (com.bumptech.glide.request.a.e) ZeusTransformUtils.wrapperContextForParams(r21, com.bumptech.glide.request.a.e.class, "com.obric.memorydata.plugin");
        e<R> r5 = (e) ZeusTransformUtils.wrapperContextForParams(r22, e.class, "com.obric.memorydata.plugin");
        List<e<R>> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.memorydata.plugin");
        RequestCoordinator r7 = (RequestCoordinator) ZeusTransformUtils.wrapperContextForParams(r24, RequestCoordinator.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.request.b.c<? super R> r8 = (com.bumptech.glide.request.b.c) ZeusTransformUtils.wrapperContextForParams(r26, com.bumptech.glide.request.b.c.class, "com.obric.memorydata.plugin");
        Executor r9 = (Executor) ZeusTransformUtils.wrapperContextForParams(r27, Executor.class, "com.obric.memorydata.plugin");
        if (f951a == false) goto L5;
        String r10 = String.valueOf(super.hashCode());
    L6:
        this.c = r10;
        this.d = com.bumptech.glide.util.pool.b.a();
        this.e = r14;
        this.h = ZeusTransformUtils.wrapperContext(r1, "com.obric.memorydata.plugin");
        this.i = r3;
        this.j = r15;
        this.k = r16;
        this.l = r17;
        this.m = r18;
        this.n = r19;
        this.o = r20;
        this.p = r4;
        this.f = r5;
        this.q = r6;
        this.g = r7;
        this.w = r25;
        this.r = r8;
        this.s = r9;
        this.x = Status.PENDING;
        if (this.E == null) goto L9;
        return;
    L9:
        if (r3.g().a(com.bumptech.glide.d.b.class) == false) goto L13;
        this.E = new RuntimeException("Glide request origin trace");
        return;
    L13:
        return;
    L5:
        r10 = null;
        goto L6
    }

    private static int a(int r1, float r2) {
        if (r1 != Integer.MIN_VALUE) goto L6;
        return r1;
    L6:
        return Math.round(r2 * r1);
    }

    private Drawable a(int r2) {
        if (this.l.r() == null) goto L5;
        Resources.Theme r0 = this.l.r();
    L7:
        return com.bumptech.glide.load.resource.b.b.a(this.h, r2, r0);
    L5:
        r0 = this.h.getTheme();
        goto L7
    }

    public static <R> SingleRequest<R> a(Context r18, com.bumptech.glide.e r19, Object r20, Object r21, Class<R> r22, a<?> r23, int r24, int r25, Priority r26, com.bumptech.glide.request.a.e<R> r27, e<R> r28, List<e<R>> r29, RequestCoordinator r30, i r31, com.bumptech.glide.request.b.c<? super R> r32, Executor r33) {
        return new SingleRequest((Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.memorydata.plugin"), (com.bumptech.glide.e) ZeusTransformUtils.wrapperContextForParams(r19, com.bumptech.glide.e.class, "com.obric.memorydata.plugin"), r20, r21, r22, r23, r24, r25, r26, (com.bumptech.glide.request.a.e) ZeusTransformUtils.wrapperContextForParams(r27, com.bumptech.glide.request.a.e.class, "com.obric.memorydata.plugin"), (e) ZeusTransformUtils.wrapperContextForParams(r28, e.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r29, List.class, "com.obric.memorydata.plugin"), (RequestCoordinator) ZeusTransformUtils.wrapperContextForParams(r30, RequestCoordinator.class, "com.obric.memorydata.plugin"), r31, (com.bumptech.glide.request.b.c) ZeusTransformUtils.wrapperContextForParams(r32, com.bumptech.glide.request.b.c.class, "com.obric.memorydata.plugin"), (Executor) ZeusTransformUtils.wrapperContextForParams(r33, Executor.class, "com.obric.memorydata.plugin"));
    }

    private void a(GlideException r9, int r10) {
        this.d.b();
        Object r0 = this.e;
        monitor-enter(r0);
        r9.setOrigin(this.E);     // Catch: Throwable -> L33
        int r1 = this.i.e();     // Catch: Throwable -> L33
        if (r1 > r10) goto L9;
        Log.w("Glide", "Load failed for [" + this.j + "] with dimensions [" + this.B + "x" + this.C + "]", r9);     // Catch: Throwable -> L33
        if (r1 > 4) goto L9;
        r9.logRootCauses("Glide");     // Catch: Throwable -> L33
    L9:
        this.u = null;     // Catch: Throwable -> L33
        this.x = Status.FAILED;     // Catch: Throwable -> L33
        t();     // Catch: Throwable -> L33
        boolean r11 = true;
        this.D = true;     // Catch: Throwable -> L33
        List<e<R>> r2 = this.q;     // Catch: Throwable -> L30
        if (r2 == null) goto L17;
        Iterator<e<R>> r3 = r2.iterator();     // Catch: Throwable -> L30
        boolean r4 = false;
    L15:
        if (r3.hasNext() == false) goto L18;
        r4 = r4 | ((e) ZeusTransformUtils.preCheckCast(r3.next(), e.class, "com.obric.memorydata.plugin")).a(r9, this.j, this.p, r());     // Catch: Throwable -> L30
    L18:
        e<R> r5 = this.f;     // Catch: Throwable -> L30
        if (r5 != null) goto L21;
    L23:
        r11 = false;
    L25:
        if ((r4 | r11) == true) goto L27;
        n();     // Catch: Throwable -> L30
    L27:
        this.D = false;     // Catch: Throwable -> L33
        com.bumptech.glide.util.pool.a.a("GlideRequest", this.f952b);     // Catch: Throwable -> L33
        monitor-exit(r0);     // Catch: Throwable -> L33
        return;
    L21:
        if (r5.a(r9, this.j, this.p, r()) == false) goto L23;
    L17:
        r4 = false;
    L30:
        th = move-exception;
        this.D = false;     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    }

    private void a(s<R> r17, R r18, DataSource r19, boolean r20) {
        s<R> r2 = (s) ZeusTransformUtils.wrapperContextForParams(r17, s.class, "com.obric.memorydata.plugin");
        boolean r10 = r();
        this.x = Status.COMPLETE;
        this.t = r2;
        if (this.i.e() > 3) goto L5;
        Log.d("Glide", "Finished loading " + r18.getClass().getSimpleName() + " from " + r19 + " for " + this.j + " with size [" + this.B + "x" + this.C + "] in " + com.bumptech.glide.util.f.a(this.v) + " ms");
    L5:
        s();
        boolean r11 = true;
        this.D = true;
        List<e<R>> r3 = this.q;     // Catch: Throwable -> L27
        if (r3 == null) goto L15;
        Iterator<e<R>> r13 = r3.iterator();     // Catch: Throwable -> L27
        boolean r8 = false;
    L10:
        if (r13.hasNext() == false) goto L16;
        e r14 = (e) ZeusTransformUtils.preCheckCast(r13.next(), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        boolean r15 = r8 | r14.a(r18, this.j, this.p, r19, r10);     // Catch: Throwable -> L27
        if (ZeusTransformUtils.instanceOf(r14, c.class) == true) goto L13;
        r8 = r15;
        goto L10
    L13:
        r8 = ((c) ZeusTransformUtils.preCheckCast(r14, c.class, "com.obric.memorydata.plugin")).a(r18, this.j, this.p, r19, r10, r20) | r15;     // Catch: Throwable -> L27
    L16:
        e<R> r4 = this.f;     // Catch: Throwable -> L27
        if (r4 != null) goto L19;
    L21:
        r11 = false;
    L23:
        if ((r8 | r11) == true) goto L25;
        this.p.a(r18, this.r.a(r19, r10));     // Catch: Throwable -> L27
    L25:
        this.D = false;
        com.bumptech.glide.util.pool.a.a("GlideRequest", this.f952b);
        return;
    L19:
        if (r4.a(r18, this.j, this.p, r19, r10) == false) goto L21;
    L15:
        r8 = false;
    L27:
        th = move-exception;
        this.D = false;
        throw th;
    }

    private void a(Object r4) {
        List<e<R>> r3 = this.q;
        if (r3 != null) goto L5;
        return;
    L5:
        Iterator<e<R>> r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r5.next(), e.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L7;
        ((c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.memorydata.plugin")).a(r4);
        goto L7
    }

    private void a(String r2) {
        Log.v("GlideRequest", r2 + " this: " + this.c);
    }

    private void i() {
        j();
        this.d.b();
        this.p.b(this);
        i.d r0 = this.u;
        if (r0 == null) goto L6;
        r0.a();
        this.u = null;
        return;
    }

    private void j() {
        if (this.D == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
    }

    private Drawable k() {
        if (this.y != null) goto L10;
        Drawable r0 = this.l.l();
        this.y = r0;
        if (r0 != null) goto L10;
        if (this.l.m() <= 0) goto L10;
        this.y = a(this.l.m());
    L10:
        return this.y;
    }

    private Drawable l() {
        if (this.z != null) goto L10;
        Drawable r0 = this.l.o();
        this.z = r0;
        if (r0 != null) goto L10;
        if (this.l.n() <= 0) goto L10;
        this.z = a(this.l.n());
    L10:
        return this.z;
    }

    private Drawable m() {
        if (this.A != null) goto L10;
        Drawable r0 = this.l.q();
        this.A = r0;
        if (r0 != null) goto L10;
        if (this.l.p() <= 0) goto L10;
        this.A = a(this.l.p());
    L10:
        return this.A;
    }

    private void n() {
        if (q() == true) goto L5;
        return;
    L5:
        Drawable r0 = null;
        if (this.j != null) goto L8;
        r0 = m();
    L8:
        if (r0 != null) goto L10;
        r0 = k();
    L10:
        if (r0 != null) goto L12;
        r0 = l();
    L12:
        this.p.b(r0);
    }

    private boolean o() {
        RequestCoordinator r0 = this.g;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.b(this) == true) goto L8;
        return false;
    }

    private boolean p() {
        RequestCoordinator r0 = this.g;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.d(this) == true) goto L8;
        return false;
    }

    private boolean q() {
        RequestCoordinator r0 = this.g;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.c(this) == true) goto L8;
        return false;
    }

    private boolean r() {
        RequestCoordinator r0 = this.g;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.h().g() == false) goto L8;
        return false;
    }

    private void s() {
        RequestCoordinator r0 = this.g;
        if (r0 == null) goto L6;
        r0.e(this);
        return;
    }

    private void t() {
        RequestCoordinator r0 = this.g;
        if (r0 == null) goto L6;
        r0.f(this);
        return;
    }

    @Override // com.bumptech.glide.request.d
    public void a() {
        Object r0 = this.e;
        monitor-enter(r0);
        j();     // Catch: Throwable -> L41
        this.d.b();     // Catch: Throwable -> L41
        this.v = com.bumptech.glide.util.f.a();     // Catch: Throwable -> L41
        if (this.j != null) goto L17;
        if (k.a(this.m, this.n) == false) goto L10;
        this.B = this.m;     // Catch: Throwable -> L41
        this.C = this.n;     // Catch: Throwable -> L41
    L10:
        if (m() != null) goto L12;
        int r1 = 5;
    L13:
        a(new GlideException("Received null model"), r1);     // Catch: Throwable -> L41
        monitor-exit(r0);     // Catch: Throwable -> L41
        return;
    L12:
        r1 = 3;
        goto L13
    L17:
        if (this.x == Status.RUNNING) goto L40;
        if (this.x != Status.COMPLETE) goto L23;
        a(this.t, DataSource.MEMORY_CACHE, false);     // Catch: Throwable -> L41
        monitor-exit(r0);     // Catch: Throwable -> L41
        return;
    L23:
        a(this.j);     // Catch: Throwable -> L41
        this.f952b = com.bumptech.glide.util.pool.a.b("GlideRequest");     // Catch: Throwable -> L41
        this.x = Status.WAITING_FOR_SIZE;     // Catch: Throwable -> L41
        if (k.a(this.m, this.n) == false) goto L26;
        a(this.m, this.n);     // Catch: Throwable -> L41
    L28:
        if (this.x == Status.RUNNING) goto L32;
        if (this.x == Status.WAITING_FOR_SIZE) goto L32;
    L35:
        if (f951a == false) goto L37;
        a("finished run method in " + com.bumptech.glide.util.f.a(this.v));     // Catch: Throwable -> L41
    L37:
        monitor-exit(r0);     // Catch: Throwable -> L41
        return;
    L32:
        if (q() == false) goto L35;
        this.p.c(l());     // Catch: Throwable -> L41
        goto L35
    L26:
        this.p.a(this);     // Catch: Throwable -> L41
        goto L28
    L40:
        throw new IllegalArgumentException("Cannot restart a running request");     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.a.d
    public void a(int r24, int r25) {
        this.d.b();
        Object r15 = this.e;
        monitor-enter(r15);
        boolean r21 = f951a;     // Catch: Throwable -> L23
        if (r21 == false) goto L8;
        a("Got onSizeReady in " + com.bumptech.glide.util.f.a(this.v));     // Catch: Throwable -> L23
    L8:
        if (this.x == Status.WAITING_FOR_SIZE) goto L11;
        monitor-exit(r15);     // Catch: Throwable -> L23
        return;
    L11:
        this.x = Status.RUNNING;     // Catch: Throwable -> L23
        float r1 = this.l.z();     // Catch: Throwable -> L23
        this.B = a(r24, r1);     // Catch: Throwable -> L23
        this.C = a(r25, r1);     // Catch: Throwable -> L23
        if (r21 == false) goto L16;
        a("finished setup for calling load in " + com.bumptech.glide.util.f.a(this.v));     // Catch: Throwable -> L23
    L16:
        this.u = this.w.a(this.i, this.j, this.l.t(), this.B, this.C, this.l.j(), this.k, this.o, this.l.k(), this.l.g(), this.l.h(), this.l.A(), this.l.i(), this.l.s(), this.l.B(), this.l.C(), this.l.D(), this, this.s);     // Catch: Throwable -> L27
        if (this.x == Status.RUNNING) goto L19;
        this.u = null;     // Catch: Throwable -> L27
    L19:
        if (r21 == false) goto L21;
        a("finished onSizeReady in " + com.bumptech.glide.util.f.a(this.v));     // Catch: Throwable -> L27
    L21:
        monitor-exit(r15);     // Catch: Throwable -> L27
        return;
    L27:
        th = th;
    L25:
        monitor-exit(r15);     // Catch: Throwable -> L27
        throw th;
    L23:
        th = th;
        goto L25
    }

    @Override // com.bumptech.glide.request.g
    public void a(GlideException r2) {
        a(r2, 5);
    }

    @Override // com.bumptech.glide.request.g
    public void a(s<?> r6, DataSource r7, boolean r8) {
        s<R> r9 = (s) ZeusTransformUtils.wrapperContextForParams(r6, s.class, "com.obric.memorydata.plugin");
        this.d.b();
        s<R> r0 = null;
        Object r1 = this.e;     // Catch: Throwable -> L43
        monitor-enter(r1);     // Catch: Throwable -> L43
        this.u = null;     // Catch: Throwable -> L40
        if (r9 != null) goto L10;
        a(new GlideException("Expected to receive a Resource<R> with an object of " + this.k + " inside, but instead got null."));     // Catch: Throwable -> L40
        monitor-exit(r1);     // Catch: Throwable -> L40
        return;
    L10:
        R r2 = r9.d();     // Catch: Throwable -> L40
        if (r2 != null) goto L13;
    L25:
        this.t = null;     // Catch: Throwable -> L38
        StringBuilder r10 = new StringBuilder().append("Expected to receive an object of ").append(this.k).append(" but instead got ");     // Catch: Throwable -> L38
        if (r2 == null) goto L28;
        Object r3 = r2.getClass();     // Catch: Throwable -> L38
    L29:
        StringBuilder r11 = r10.append(r3).append("{").append(r2).append("} inside Resource{").append(r9).append("}.");     // Catch: Throwable -> L38
        if (r2 == null) goto L32;
        String r4 = "";
    L33:
        a(new GlideException(r11.append(r4).toString()));     // Catch: Throwable -> L38
        monitor-exit(r1);     // Catch: Throwable -> L38
        if (r9 == null) goto L52;
        this.w.a(r9);
        return;
    L52:
        return;
    L32:
        r4 = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
        goto L33
    L28:
        r3 = "";
        goto L29
    L13:
        if (this.k.isAssignableFrom(r2.getClass()) == false) goto L25;
        if (o() == true) goto L22;
        this.t = null;     // Catch: Throwable -> L38
        this.x = Status.COMPLETE;     // Catch: Throwable -> L38
        com.bumptech.glide.util.pool.a.a("GlideRequest", this.f952b);     // Catch: Throwable -> L38
        monitor-exit(r1);     // Catch: Throwable -> L38
        if (r9 == null) goto L51;
        this.w.a(r9);
        return;
    L51:
        return;
    L22:
        a(r9, r2, r7, r8);     // Catch: Throwable -> L40
        monitor-exit(r1);     // Catch: Throwable -> L40
        return;
    L38:
        th = move-exception;
        r0 = r9;
        th = th;
    L41:
        monitor-exit(r1);     // Catch: Throwable -> L40
        throw th;     // Catch: Throwable -> L43
    L40:
        th = th;
    L43:
        th = move-exception;
        if (r0 == null) goto L46;
        this.w.a(r0);
    L46:
        throw th;
    }

    @Override // com.bumptech.glide.request.d
    public boolean a(d r15) {
        d r16 = (d) ZeusTransformUtils.wrapperContextForParams(r15, d.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, SingleRequest.class) == true) goto L5;
        return false;
    L5:
        Object r1 = this.e;
        monitor-enter(r1);
        int r3 = this.m;     // Catch: Throwable -> L34
        int r4 = this.n;     // Catch: Throwable -> L34
        Object r5 = this.j;     // Catch: Throwable -> L34
        Class<R> r6 = this.k;     // Catch: Throwable -> L34
        a<?> r7 = this.l;     // Catch: Throwable -> L34
        Priority r8 = this.o;     // Catch: Throwable -> L34
        List<e<R>> r14 = this.q;     // Catch: Throwable -> L34
        if (r14 == null) goto L10;
        int r17 = r14.size();     // Catch: Throwable -> L34
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L34
        SingleRequest r18 = (SingleRequest) ZeusTransformUtils.preCheckCast(r16, SingleRequest.class, "com.obric.memorydata.plugin");
        Object r0 = r18.e;
        monitor-enter(r0);
        int r2 = r18.m;     // Catch: Throwable -> L31
        int r9 = r18.n;     // Catch: Throwable -> L31
        Object r10 = r18.j;     // Catch: Throwable -> L31
        Class<R> r11 = r18.k;     // Catch: Throwable -> L31
        a<?> r12 = r18.l;     // Catch: Throwable -> L31
        Priority r13 = r18.o;     // Catch: Throwable -> L31
        List<e<R>> r19 = r18.q;     // Catch: Throwable -> L31
        if (r19 == null) goto L17;
        int r110 = r19.size();     // Catch: Throwable -> L31
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L31
        if (r3 != r2) goto L41;
        if (r4 == r9) goto L22;
        return false;
    L22:
        if (k.b(r5, r10) == true) goto L24;
        return false;
    L24:
        if (r6.equals(r11) == true) goto L26;
        return false;
    L26:
        if (k.a(r7, r12) == false) goto L45;
        if (r8 != r13) goto L46;
        if (r17 != r110) goto L47;
        return true;
    L47:
        return false;
    L46:
        return false;
    L45:
        return false;
    L41:
        return false;
    L17:
        r110 = 0;
    L31:
        th = move-exception;
        throw th;
    L10:
        r17 = 0;
    L34:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.d
    public void b() {
        Object r0 = this.e;
        monitor-enter(r0);
        j();     // Catch: Throwable -> L20
        this.d.b();     // Catch: Throwable -> L20
        if (this.x != Status.CLEARED) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L8:
        i();     // Catch: Throwable -> L20
        s<R> r1 = this.t;     // Catch: Throwable -> L20
        if (r1 == null) goto L11;
        this.t = null;     // Catch: Throwable -> L20
    L13:
        if (p() == false) goto L15;
        this.p.a_(l());     // Catch: Throwable -> L20
    L15:
        com.bumptech.glide.util.pool.a.a("GlideRequest", this.f952b);     // Catch: Throwable -> L20
        this.x = Status.CLEARED;     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        if (r1 == null) goto L24;
        this.w.a(r1);
        return;
    L24:
        return;
    L11:
        r1 = null;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.d
    public void c() {
        Object r0 = this.e;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (d() == false) goto L7;
        b();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    @Override // com.bumptech.glide.request.d
    public boolean d() {
        Object r0 = this.e;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.x != Status.RUNNING) goto L7;
    L10:
        boolean r3 = true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r3;
    L7:
        if (this.x == Status.WAITING_FOR_SIZE) goto L10;
        r3 = false;
        goto L11
    }

    @Override // com.bumptech.glide.request.d
    public boolean e() {
        Object r0 = this.e;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.x != Status.COMPLETE) goto L7;
        boolean r2 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.bumptech.glide.request.d
    public boolean f() {
        Object r0 = this.e;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.x != Status.CLEARED) goto L7;
        boolean r2 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.bumptech.glide.request.d
    public boolean g() {
        Object r0 = this.e;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.x != Status.COMPLETE) goto L7;
        boolean r2 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.bumptech.glide.request.g
    public Object h() {
        this.d.b();
        return this.e;
    }

    public String toString() {
        Object r0 = this.e;
        monitor-enter(r0);
        Object r1 = this.j;     // Catch: Throwable -> L8
        Class<R> r2 = this.k;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return super.toString() + "[model=" + r1 + ", transcodeClass=" + r2 + "]";
    L8:
        th = move-exception;
        throw th;
    }
}
