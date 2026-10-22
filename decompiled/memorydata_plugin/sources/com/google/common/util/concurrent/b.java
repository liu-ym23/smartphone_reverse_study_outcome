package com.google.common.util.concurrent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final o.a<Service.a> f4846a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final o.a<Service.a> f4847b = null;
    private static final o.a<Service.a> c = null;
    private static final o.a<Service.a> d = null;
    private static final o.a<Service.a> e = null;
    private static final o.a<Service.a> f = null;
    private static final o.a<Service.a> g = null;
    private static final o.a<Service.a> h = null;
    private final r i;
    private final r.a j;
    private final r.a k;
    private final r.a l;
    private final r.a m;
    private final o<Service.a> n;
    private volatile e o;

    private final class a extends r.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f4850a;

        a(b r1) {
            this.f4850a = r1;
            super(b.a(r1));
        }
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.b$b, reason: collision with other inner class name */
    private final class C0206b extends r.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f4851a;

        C0206b(b r1) {
            this.f4851a = r1;
            super(b.a(r1));
        }
    }

    private final class c extends r.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f4852a;

        c(b r1) {
            this.f4852a = r1;
            super(b.a(r1));
        }
    }

    private final class d extends r.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f4853a;

        d(b r1) {
            this.f4853a = r1;
            super(b.a(r1));
        }
    }

    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Service.State f4854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f4855b;
        final Throwable c;

        e(Service.State r3) {
            this(r3, false, null);
        }

        e(Service.State r5, boolean r6, Throwable r7) {
            boolean r0 = false;
            if (r6 == true) goto L5;
        L8:
            boolean r2 = true;
        L9:
            com.google.common.base.n.a(r2, "shutdownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", r5);
            if (r7 == null) goto L12;
            boolean r3 = true;
        L14:
            if (r5 != Service.State.FAILED) goto L16;
            boolean r4 = true;
        L17:
            if (r3 != r4) goto L19;
            r0 = true;
        L19:
            com.google.common.base.n.a(r0, "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", r5, r7);
            this.f4854a = r5;
            this.f4855b = r6;
            this.c = r7;
            return;
        L16:
            r4 = false;
            goto L17
        L12:
            r3 = false;
            goto L14
        L5:
            if (r5 == Service.State.STARTING) goto L8;
            r2 = false;
            goto L9
        }

        Service.State a() {
            if (this.f4855b == false) goto L9;
            if (this.f4854a != Service.State.STARTING) goto L9;
            return Service.State.STOPPING;
        L9:
            return this.f4854a;
        }

        Throwable b() {
            if (this.f4854a != Service.State.FAILED) goto L5;
            boolean r0 = true;
        L6:
            com.google.common.base.n.b(r0, "failureCause() is only valid if the service has failed, service is %s", this.f4854a);
            return (Throwable) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.c), Throwable.class, "com.obric.memorydata.plugin");
        L5:
            r0 = false;
            goto L6
        }
    }

    static {
        f4846a = new AnonymousClass1();
        f4847b = new AnonymousClass2();
        c = b(Service.State.STARTING);
        d = b(Service.State.RUNNING);
        e = a(Service.State.NEW);
        f = a(Service.State.STARTING);
        g = a(Service.State.RUNNING);
        h = a(Service.State.STOPPING);
    }

    public b() {
        this.i = new r();
        this.j = new C0206b(this);
        this.k = new c(this);
        this.l = new a(this);
        this.m = new d(this);
        this.n = new o();
        this.o = new e(Service.State.NEW);
    }

    private static o.a<Service.a> a(final Service.State r1) {
        return new AnonymousClass3(r1);
    }

    static /* synthetic */ r a(b r0) {
        return r0.i;
    }

    private static o.a<Service.a> b(final Service.State r1) {
        return new AnonymousClass4(r1);
    }

    public final Service.State a() {
        return this.o.a();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable b() {
        return this.o.b();
    }

    public String toString() {
        return getClass().getSimpleName() + " [" + a() + "]";
    }
}
