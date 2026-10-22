package ua;

import ae.d;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import ce.e;
import ce.h;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.aikernel.sdk.data.ExtraAppInfo;
import ge.p;
import he.i;
import java.util.concurrent.CancellationException;
import pe.a0;
import pe.g;
import pe.g0;
import pe.j0;
import pe.n0;
import pe.x1;
import pe.z;
import xd.j;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AIKernelConfig f12539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ComponentName f12540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile AIKBinder f12541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f12542e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ServiceConnectionC0176c f12543f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g0<? extends AIKBinder> f12544g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile g<? super AIKBinder> f12545h;

    public static final class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f12546a;

        public a(c r8) {
            this.f12546a = r8;
        }

        public final void a(IBinder r8) {
            c r10 = this.f12546a;
            r10.f12541d = AIKBinder.Stub.H2(r8);
            g<? super AIKBinder> r11 = this.f12546a.f12545h;
            if (r11 != null) goto L5;
            return;
        L5:
            if (r11.a() == true) goto L8;
            r11 = null;
        L8:
            if (r11 == null) goto L12;
            defpackage.c.c0(this.f12546a.f12541d, r11);
            return;
        }

        @Override // android.content.ServiceConnection
        public final void onBindingDied(ComponentName r8) {
            AIKLog r10 = AIKLog.INSTANCE;
            StringBuilder r11 = new StringBuilder("Service ");
            if (r8 == null) goto L5;
            String r12 = r8.getClassName();
        L6:
            r11.append(r12);
            r11.append(" onBindingDied.");
            r10.i("ServiceConnector", r11.toString());
            a(null);
            return;
        L5:
            r12 = null;
            goto L6
        }

        @Override // android.content.ServiceConnection
        public final void onNullBinding(ComponentName r8) {
            AIKLog r10 = AIKLog.INSTANCE;
            StringBuilder r11 = new StringBuilder("Service ");
            if (r8 == null) goto L5;
            String r12 = r8.getClassName();
        L6:
            r11.append(r12);
            r11.append(" onNullBinding.");
            r10.i("ServiceConnector", r11.toString());
            a(null);
            return;
        L5:
            r12 = null;
            goto L6
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r8, IBinder r10) {
            AIKLog r11 = AIKLog.INSTANCE;
            StringBuilder r12 = new StringBuilder("Service ");
            if (r8 == null) goto L5;
            String r13 = r8.getClassName();
        L6:
            r12.append(r13);
            r12.append(" connected.");
            r11.i("ServiceConnector", r12.toString());
            a(r10);
            return;
        L5:
            r13 = null;
            goto L6
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r8) {
            AIKLog r10 = AIKLog.INSTANCE;
            StringBuilder r11 = new StringBuilder("Service ");
            if (r8 == null) goto L5;
            String r12 = r8.getClassName();
        L6:
            r11.append(r12);
            r11.append(" disconnected.");
            r10.i("ServiceConnector", r11.toString());
            a(null);
            return;
        L5:
            r12 = null;
            goto L6
        }
    }

    @e(c = "com.obric.aikernel.phx.core.conn.ServiceConnector$getService$2", f = "ServiceConnector.kt", l = {168}, m = "invokeSuspend")
    public static final class b extends h implements p<z, d<? super AIKBinder>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f12548b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ c f12549m;

        @e(c = "com.obric.aikernel.phx.core.conn.ServiceConnector$getService$2$1$1", f = "ServiceConnector.kt", l = {185}, m = "invokeSuspend")
        public static final class a extends h implements p<z, d<? super AIKBinder>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f12550a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f12551b;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final /* synthetic */ c f12552m;

            public a(c r8, d<? super a> r10) {
                this.f12552m = r8;
                super(2, r10);
            }

            @Override // ce.a
            public final d<j> create(Object r8, d<?> r10) {
                a r11 = new a(this.f12552m, r10);
                r11.f12551b = r8;
                return r11;
            }

            @Override // ge.p
            public final Object invoke(z r8, d<? super AIKBinder> r10) {
                return ((a) create(r8, r10)).invokeSuspend(j.f13877a);
            }

            @Override // ce.a
            public final Object invokeSuspend(Object r10) {
                l6.a.M();
                be.a r8 = be.a.f3165a;
                int r11 = this.f12550a;
                boolean r12 = true;
                if (r11 == 0) goto L8;
                if (r11 != 1) goto L7;
                c r13 = (c) this.f12551b;
                defpackage.c.m0(r10);
            L43:
                AIKBinder r14 = (AIKBinder) r10;
            L44:
                c r15 = this.f12552m;
                monitor-enter(r15);
                c.h(r15, null);     // Catch: Throwable -> L49
                c.i(r15, null);     // Catch: Throwable -> L49
                j r16 = j.f13877a;     // Catch: Throwable -> L49
                monitor-exit(r15);
                return r14;
            L49:
                th = move-exception;
                throw th;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                defpackage.c.m0(r10);
                z r17 = (z) this.f12551b;
                Intent r18 = new Intent();
                r18.setComponent(c.b(this.f12552m));
                r18.addFlags(1);
                ExtraAppInfo r19 = c.a(this.f12552m).getExtraBindInfo();
                if (r19 == null) goto L12;
                r18.putExtra(IdlKeys.Args_BindExtraInfo, r19);
            L12:
                if (ra.a.a() == false) goto L28;
                ContentResolver r20 = c.e(this.f12552m).getContentResolver();
                Bundle r21 = new Bundle();
                r21.putParcelable("intent", r18);
                j r22 = j.f13877a;
                Bundle r23 = r20.call("com.obric.aikernel.service.auth", "onBind", null, r21);
                if (r23 == null) goto L27;
                IBinder r24 = r23.getBinder("binder");
                if (r24 == null) goto L27;
                r14 = AIKBinder.Stub.H2(r24);
                if (r14 == null) goto L27;
                c r25 = this.f12552m;
                c.j(r25, r14);
                Context r26 = c.e(r25);     // Catch: Throwable -> L22
                Intent r27 = new Intent();     // Catch: Throwable -> L22
                r27.setComponent(new ComponentName(c.b(r25).getPackageName(), "com.obric.aikernel.LifeCycleService"));     // Catch: Throwable -> L22
                Object r28 = l6.a.p(r26.bindService(r27, c.f(r25), 1));     // Catch: Throwable -> L22
            L24:
                Throwable r29 = xd.e.a(r28);
                if (r29 == null) goto L44;
                AIKLog.INSTANCE.w("ServiceConnector", r29.toString());
            L22:
                th = move-exception;
                r28 = defpackage.c.D(th);
            L27:
                r14 = null;
                goto L44
            L28:
                boolean r30 = c.e(this.f12552m).bindService(r18, c.d(this.f12552m), 1);
                AIKLog.INSTANCE.i("ServiceConnector", "start binding to " + c.b(this.f12552m).getClassName() + ", result = " + r30);
                c r31 = this.f12552m;
                this.f12551b = r31;
                this.f12550a = 1;
                pe.h r32 = new pe.h(1, l6.a.b0(this));
                r32.q();
                c.i(r31, r32);
                AIKBinder r33 = c.g(r31);
                if (r33 == null) goto L35;
                IBinder r34 = r33.asBinder();
                if (r34 == null) goto L35;
                if (r34.isBinderAlive() != true) goto L35;
            L36:
                if (r12 == false) goto L38;
                defpackage.c.c0(c.g(r31), r32);
            L38:
                r10 = r32.p();
                l6.a.M();
                if (r10 != r8) goto L41;
                l6.a.B0(this);
            L41:
                if (r10 != r8) goto L43;
                return r8;
            L35:
                r12 = false;
                goto L36
            }
        }

        /* JADX INFO: renamed from: ua.c$b$b, reason: collision with other inner class name */
        @e(c = "com.obric.aikernel.phx.core.conn.ServiceConnector$getService$2$1$2", f = "ServiceConnector.kt", l = {151}, m = "invokeSuspend")
        public static final class C0175b extends h implements p<z, d<? super j>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public long f12553a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f12554b;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public /* synthetic */ Object f12555m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public final /* synthetic */ g0<AIKBinder> f12556n;

            /* JADX WARN: Multi-variable type inference failed */
            public C0175b(g0<? extends AIKBinder> r8, d<? super C0175b> r10) {
                this.f12556n = r8;
                super(2, r10);
            }

            @Override // ce.a
            public final d<j> create(Object r8, d<?> r10) {
                C0175b r11 = new C0175b(this.f12556n, r10);
                r11.f12555m = r8;
                return r11;
            }

            @Override // ge.p
            public final Object invoke(z r8, d<? super j> r10) {
                return ((C0175b) create(r8, r10)).invokeSuspend(j.f13877a);
            }

            @Override // ce.a
            public final Object invokeSuspend(Object r8) {
                l6.a.M();
                be.a r10 = be.a.f3165a;
                int r11 = this.f12554b;
                boolean r12 = true;
                if (r11 == 0) goto L8;
                if (r11 != 1) goto L7;
                long r13 = this.f12553a;
                z r14 = (z) this.f12555m;
                defpackage.c.m0(r8);
            L12:
                g0<AIKBinder> r15 = this.f12556n;
                if (r15 != null) goto L15;
            L17:
                r12 = false;
            L18:
                if (r12 == false) goto L21;
                if (r15 == null) goto L21;
                r15.H(new CancellationException("connectTask timeout by " + r13));     // Catch: Throwable -> L23
            L23:
                th = move-exception;
                Object r16 = defpackage.c.D(th);
            L25:
                AIKLog.INSTANCE.i("ServiceConnector", "cancel active:" + r12 + ' ' + r15 + " success:" + xd.e.c(r16) + " exception:" + xd.e.a(r16));
                return j.f13877a;
            L21:
                r16 = j.f13877a;     // Catch: Throwable -> L23
                goto L25
            L15:
                if (r15.a() != true) goto L17;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                defpackage.c.m0(r8);
                this.f12555m = (z) this.f12555m;
                this.f12553a = 30000;
                this.f12554b = 1;
                if (j0.a(this) != r10) goto L11;
                return r10;
            L11:
                r13 = 30000;
                goto L12
            }
        }

        public b(c r8, d<? super b> r10) {
            this.f12549m = r8;
            super(2, r10);
        }

        @Override // ce.a
        public final d<j> create(Object r8, d<?> r10) {
            b r11 = new b(this.f12549m, r10);
            r11.f12548b = r8;
            return r11;
        }

        @Override // ge.p
        public final Object invoke(z r8, d<? super AIKBinder> r10) {
            return ((b) create(r8, r10)).invokeSuspend(j.f13877a);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r12) {
            l6.a.M();
            be.a r8 = be.a.f3165a;
            int r10 = this.f12547a;
            IBinder r11 = null;
            if (r10 == 0) goto L11;
            if (r10 != 1) goto L10;
            defpackage.c.m0(r12);     // Catch: Throwable -> L7
        L56:
            Object r13 = (AIKBinder) r12;     // Catch: Throwable -> L7
        L59:
            Throwable r14 = xd.e.a(r13);
            if (r14 == null) goto L63;
            AIKLog.INSTANCE.w("ServiceConnector", "connectTask failed by " + r14);
        L63:
            if (xd.e.b(r13) == false) goto L65;
            r13 = null;
        L65:
            AIKBinder r15 = (AIKBinder) r13;
            if (r15 == null) goto L80;
            c r16 = this.f12549m;
            AIKLog r17 = AIKLog.INSTANCE;
            StringBuilder r18 = new StringBuilder("await finished ");
            AIKBinder r19 = c.g(r16);
            if (r19 == null) goto L70;
            r11 = r19.asBinder();
        L70:
            r18.append(r11);
            r17.v("ServiceConnector", r18.toString());
            return r15;
        L80:
            return null;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            defpackage.c.m0(r12);
            z r110 = (z) this.f12548b;
            c r111 = this.f12549m;
            monitor-enter(r111);
            AIKBinder r20 = c.g(r111);     // Catch: Throwable -> L72
            boolean r21 = false;
            if (r20 == null) goto L20;
            IBinder r22 = r20.asBinder();     // Catch: Throwable -> L72
            if (r22 == null) goto L20;
            if (r22.isBinderAlive() != true) goto L20;
            boolean r23 = true;
        L22:
            if (r23 == true) goto L39;
            AIKLog r24 = AIKLog.INSTANCE;     // Catch: Throwable -> L72
            StringBuilder r112 = new StringBuilder("should rebind ");     // Catch: Throwable -> L72
            AIKBinder r25 = c.g(r111);     // Catch: Throwable -> L72
            if (r25 == null) goto L26;
            IBinder r26 = r25.asBinder();     // Catch: Throwable -> L72
        L27:
            r112.append(r26);     // Catch: Throwable -> L72
            r112.append(' ');     // Catch: Throwable -> L72
            r112.append(c.c(r111));     // Catch: Throwable -> L72
            r112.append(' ');     // Catch: Throwable -> L72
            g0 r27 = c.c(r111);     // Catch: Throwable -> L72
            if (r27 == null) goto L30;
            Boolean r28 = l6.a.p(r27.G());     // Catch: Throwable -> L72
        L31:
            r112.append(r28);     // Catch: Throwable -> L72
            r24.d("ServiceConnector", r112.toString());     // Catch: Throwable -> L72
            g0 r29 = c.c(r111);     // Catch: Throwable -> L72
            if (r29 != null) goto L34;
        L36:
            if (r21 == false) goto L39;
            c.h(r111, null);     // Catch: Throwable -> L72
            goto L39
        L34:
            if (r29.G() != true) goto L36;
            r21 = true;
            goto L36
        L30:
            r28 = null;
            goto L31
        L26:
            r26 = null;
        L39:
            if (c.c(r111) != null) goto L45;
            AIKLog r30 = AIKLog.INSTANCE;     // Catch: Throwable -> L72
            StringBuilder r31 = new StringBuilder("new task ");     // Catch: Throwable -> L72
            AIKBinder r32 = c.g(r111);     // Catch: Throwable -> L72
            if (r32 == null) goto L43;
            IBinder r33 = r32.asBinder();     // Catch: Throwable -> L72
        L44:
            r31.append(r33);     // Catch: Throwable -> L72
            r30.i("ServiceConnector", r31.toString());     // Catch: Throwable -> L72
            c.h(r111, l6.a.n(a0.a(n0.a()), new a(r111, null)));     // Catch: Throwable -> L72
            l6.a.j0(a0.a(n0.a()), new C0175b(c.c(r111), null));     // Catch: Throwable -> L72
        L50:
            g0 r34 = c.c(r111);     // Catch: Throwable -> L72
            monitor-exit(r111);
            if (r34 == null) goto L79;
            this.f12547a = 1;     // Catch: Throwable -> L7
            r12 = r34.c0(this);     // Catch: Throwable -> L7
            if (r12 != r8) goto L56;
            return r8;
        L79:
            return null;
        L43:
            r33 = null;
            goto L44
        L45:
            AIKLog r35 = AIKLog.INSTANCE;     // Catch: Throwable -> L72
            StringBuilder r36 = new StringBuilder("reuse task ");     // Catch: Throwable -> L72
            r36.append(c.c(r111));     // Catch: Throwable -> L72
            r36.append(' ');     // Catch: Throwable -> L72
            g0 r37 = c.c(r111);     // Catch: Throwable -> L72
            if (r37 == null) goto L48;
            Boolean r38 = l6.a.p(r37.G());     // Catch: Throwable -> L72
        L49:
            r36.append(r38);     // Catch: Throwable -> L72
            r35.d("ServiceConnector", r36.toString());     // Catch: Throwable -> L72
            goto L50
        L48:
            r38 = null;
        L20:
            r23 = false;
        L72:
            th = move-exception;
            throw th;
        L7:
            th = move-exception;
            r13 = defpackage.c.D(th);
            goto L59
        }
    }

    /* JADX INFO: renamed from: ua.c$c, reason: collision with other inner class name */
    public static final class ServiceConnectionC0176c implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f12557a;

        public ServiceConnectionC0176c(c r8) {
            this.f12557a = r8;
        }

        @Override // android.content.ServiceConnection
        public final void onBindingDied(ComponentName r8) {
            AIKLog r10 = AIKLog.INSTANCE;
            StringBuilder r11 = new StringBuilder("Service ");
            if (r8 == null) goto L5;
            String r12 = r8.getClassName();
        L6:
            r11.append(r12);
            r11.append(" onBindingDied.");
            r10.i("ServiceConnector", r11.toString());
            this.f12557a.f12541d = null;
            return;
        L5:
            r12 = null;
            goto L6
        }

        @Override // android.content.ServiceConnection
        public final void onNullBinding(ComponentName r8) {
            AIKLog r10 = AIKLog.INSTANCE;
            StringBuilder r11 = new StringBuilder("Service ");
            if (r8 == null) goto L5;
            String r12 = r8.getClassName();
        L6:
            r11.append(r12);
            r11.append(" onNullBinding.");
            r10.i("ServiceConnector", r11.toString());
            return;
        L5:
            r12 = null;
            goto L6
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r8, IBinder r10) {
            AIKLog r11 = AIKLog.INSTANCE;
            StringBuilder r12 = new StringBuilder("Service ");
            if (r8 == null) goto L5;
            String r13 = r8.getClassName();
        L6:
            r12.append(r13);
            r12.append(" connected.");
            r11.i("ServiceConnector", r12.toString());
            return;
        L5:
            r13 = null;
            goto L6
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r8) {
            AIKLog r10 = AIKLog.INSTANCE;
            StringBuilder r11 = new StringBuilder("Service ");
            if (r8 == null) goto L5;
            String r12 = r8.getClassName();
        L6:
            r11.append(r12);
            r11.append(" disconnected.");
            r10.i("ServiceConnector", r11.toString());
            this.f12557a.f12541d = null;
            return;
        L5:
            r12 = null;
            goto L6
        }
    }

    public c(Context r8, AIKernelConfig r10, ComponentName r11) {
        i.f(r8, "context");
        i.f(r10, "aiKernelConfig");
        this.f12538a = r8;
        this.f12539b = r10;
        this.f12540c = r11;
        this.f12542e = new a(this);
        this.f12543f = new ServiceConnectionC0176c(this);
    }

    public static final /* synthetic */ AIKernelConfig a(c r8) {
        return r8.f12539b;
    }

    public static final /* synthetic */ ComponentName b(c r8) {
        return r8.f12540c;
    }

    public static final /* synthetic */ g0 c(c r8) {
        return r8.f12544g;
    }

    public static final /* synthetic */ a d(c r8) {
        return r8.f12542e;
    }

    public static final /* synthetic */ Context e(c r8) {
        return r8.f12538a;
    }

    public static final /* synthetic */ ServiceConnectionC0176c f(c r8) {
        return r8.f12543f;
    }

    public static final /* synthetic */ AIKBinder g(c r8) {
        return r8.f12541d;
    }

    public static final /* synthetic */ void h(c r8, g0 r10) {
        r8.f12544g = r10;
    }

    public static final /* synthetic */ void i(c r8, pe.h r10) {
        r8.f12545h = r10;
    }

    public static final /* synthetic */ void j(c r8, AIKBinder r10) {
        r8.f12541d = r10;
    }

    public final Object k(long r8, d<? super AIKBinder> r10) {
        AIKBinder r11 = this.f12541d;
        boolean r12 = false;
        if (r11 == null) goto L9;
        IBinder r13 = r11.asBinder();
        if (r13 == null) goto L9;
        if (r13.isBinderAlive() != true) goto L9;
        r12 = true;
    L9:
        if (r12 == false) goto L13;
        return this.f12541d;
    L13:
        return x1.b(r8, new b(this, null), r10);
    }
}
