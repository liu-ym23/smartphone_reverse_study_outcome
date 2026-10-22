package ua;

import ae.d;
import android.os.IBinder;
import ce.h;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.core.log.AIKLog;
import ge.p;
import ha.t;
import he.i;
import he.o;
import java.util.concurrent.ConcurrentHashMap;
import pe.a0;
import pe.e1;
import pe.z;
import se.f;
import se.j;
import se.k;
import te.e;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12525a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, a> f12526b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IBinder f12527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f<Boolean> f12528b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final IBinder.DeathRecipient f12529c;

        public a() {
            throw null;
        }

        public a(IBinder r8) {
            Object r10 = Boolean.TRUE;
            b9.a r11 = k.f12128a;
            if (r10 != null) goto L5;
            r10 = e.f12392a;
        L5:
            j r12 = new j(r10);
            ua.a r13 = new ua.a(r8, r12);
            this.f12527a = r8;
            this.f12528b = r12;
            this.f12529c = r13;
        }

        public final IBinder a() {
            return this.f12527a;
        }

        public final IBinder.DeathRecipient b() {
            return this.f12529c;
        }

        public final f<Boolean> c() {
            return this.f12528b;
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r10 = (a) r8;
            IBinder r11 = r10.f12527a;
            if (i.a(this.f12527a, r11) == true) goto L12;
            return false;
        L12:
            if (i.a(this.f12528b, r10.f12528b) == true) goto L15;
            return false;
        L15:
            if (i.a(this.f12529c, r10.f12529c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r8 = this.f12527a.hashCode() * 31;
            int r10 = (this.f12528b.hashCode() + r8) * 31;
            return this.f12529c.hashCode() + r10;
        }

        public final String toString() {
            return "BinderInfo(binder=" + this.f12527a + ", stateFlow=" + this.f12528b + ", recipient=" + this.f12529c + ')';
        }
    }

    /* JADX INFO: renamed from: ua.b$b, reason: collision with other inner class name */
    @ce.e(c = "com.obric.aikernel.phx.core.conn.BinderMonitor$monitorTransact$job$1", f = "BinderMonitor.kt", l = {39}, m = "invokeSuspend")
    public static final class C0174b extends h implements p<z, d<? super xd.j>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f12531b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ o<a> f12532m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ ae.f f12533n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ ge.a<xd.j> f12534o;

        /* JADX INFO: renamed from: ua.b$b$a */
        public static final class a<T> implements se.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ z f12535a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ae.f f12536b;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final /* synthetic */ ge.a<xd.j> f12537m;

            public a(z r8, ae.f r10, ge.a<xd.j> r11) {
                this.f12535a = r8;
                this.f12536b = r10;
                this.f12537m = r11;
            }

            @Override // se.d
            public final Object e(Object r8, d r10) {
                if (((Boolean) r8).booleanValue() == true) goto L13;
                ae.f r11 = this.f12536b;
                ge.a<xd.j> r12 = this.f12537m;
                AIKLog.INSTANCE.i("BinderMonitor", "monitorTransact: callback onDied: " + r11);     // Catch: Throwable -> L7
                r12.f();     // Catch: Throwable -> L7
                Object r13 = xd.j.f13877a;     // Catch: Throwable -> L7
            L9:
                Throwable r14 = xd.e.a(r13);
                if (r14 == null) goto L13;
                AIKLog.INSTANCE.e("BinderMonitor", "monitorTransact: callback onDied error, " + r14);
            L7:
                th = move-exception;
                r13 = defpackage.c.D(th);
            L13:
                return xd.j.f13877a;
            }
        }

        public C0174b(o<a> r8, ae.f r10, ge.a<xd.j> r11, d<? super C0174b> r12) {
            this.f12532m = r8;
            this.f12533n = r10;
            this.f12534o = r11;
            super(2, r12);
        }

        @Override // ce.a
        public final d<xd.j> create(Object r8, d<?> r10) {
            ae.f r11 = this.f12533n;
            ge.a<xd.j> r12 = this.f12534o;
            C0174b r13 = new C0174b(this.f12532m, r11, r12, r10);
            r13.f12531b = r8;
            return r13;
        }

        @Override // ge.p
        public final Object invoke(z r8, d<? super xd.j> r10) {
            return ((C0174b) create(r8, r10)).invokeSuspend(xd.j.f13877a);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            l6.a.M();
            be.a r10 = be.a.f3165a;
            int r11 = this.f12530a;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L6;
            defpackage.c.m0(r8);
        L16:
            throw new t();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            defpackage.c.m0(r8);
            z r12 = (z) this.f12531b;
            a r13 = this.f12532m.f8064a;
            if (r13 == null) goto L18;
            f<Boolean> r14 = r13.c();
            if (r14 == null) goto L18;
            AIKLog r15 = AIKLog.INSTANCE;
            StringBuilder r16 = new StringBuilder("monitorTransact: register onDied stateFlow: ");
            ae.f r17 = this.f12533n;
            r16.append(r17);
            r15.d("BinderMonitor", r16.toString());
            a r18 = new a(r12, r17, this.f12534o);
            this.f12530a = 1;
            if (r14.a(r18, this) != r10) goto L16;
            return r10;
        L18:
            return xd.j.f13877a;
        }
    }

    static {
        f12525a = new b();
        f12526b = new ConcurrentHashMap();
    }

    public static final /* synthetic */ ConcurrentHashMap a() {
        return f12526b;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6, types: [T, java.lang.Object, ua.b$a] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final e1 b(ae.f r8, AIKBinder r10, ge.a<xd.j> r11) {
        i.f(r8, "ctx");
        i.f(r10, "binder");
        IBinder r12 = r10.asBinder();
        int r13 = r12.hashCode();
        o r14 = new o();
        ConcurrentHashMap<Integer, a> r15 = f12526b;
        ?? r16 = r15.get(Integer.valueOf(r13));
        r14.f8064a = r16;
        if (r16 != 0) goto L17;
        monitor-enter(this);
        r14.f8064a = r15.get(Integer.valueOf(r13));     // Catch: Throwable -> L13
        if (r12.isBinderAlive() == true) goto L8;
    L10:
        xd.j r17 = xd.j.f13877a;     // Catch: Throwable -> L13
        monitor-exit(this);
        goto L17
    L8:
        if (r14.f8064a != 0) goto L10;
        ?? r18 = new a(r12);     // Catch: Throwable -> L13
        r15.put(Integer.valueOf(r13), (a) r18);     // Catch: Throwable -> L13
        r12.linkToDeath(r18.b(), 0);     // Catch: Throwable -> L13
        r14.f8064a = r18;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L17:
        return l6.a.j0(a0.a(r8), new C0174b(r14, r8, r11, null));
    }
}
