package com.obric.aikernel.phx.core.conn;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.GuardedBy;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.AIKernelConfig;
import java.io.Closeable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.m1;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class ServiceConnector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AIKernelConfig f4791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ComponentName f4792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile com.obric.aikernel.a f4793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f4794e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f4795f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final l0 f4796g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final d f4797h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final e f4798i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @GuardedBy("this")
    private r0<? extends com.obric.aikernel.a> f4799j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f4800k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f4801l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @GuardedBy("this")
    private int f4802m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @GuardedBy("this")
    private v1 f4803n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private volatile n<? super com.obric.aikernel.a> f4804o;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class b implements Closeable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.obric.aikernel.a f4805c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final c f4806g;

        public b(com.obric.aikernel.a r10, c r11) {
            Intrinsics.checkNotNullParameter(r10, "binder");
            Intrinsics.checkNotNullParameter(r11, "lease");
            this.f4805c = r10;
            this.f4806g = r11;
        }

        public final com.obric.aikernel.a a() {
            return this.f4805c;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f4806g.close();
        }
    }

    public static final class c implements Closeable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ServiceConnector f4807c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final AtomicBoolean f4808g;

        public c(ServiceConnector r10) {
            this.f4807c = r10;
            this.f4808g = new AtomicBoolean(false);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f4808g.compareAndSet(false, true) == false) goto L8;
            ServiceConnector r10 = this.f4807c;
            if (r10 == null) goto L9;
            ServiceConnector.i(r10);
            return;
        L9:
            return;
        }
    }

    public static final class d implements ServiceConnection {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ServiceConnector f4809c;

        d(ServiceConnector r10) {
            this.f4809c = r10;
        }

        private final void a(IBinder r10) {
            com.obric.aikernel.a r11 = com.obric.aikernel.a.AbstractBinderC0095a.U0(r10);
            ServiceConnector r12 = this.f4809c;
            monitor-enter(r12);
            ServiceConnector.o(r12, r11);     // Catch: Throwable -> L22
            if (r11 == null) goto L7;
            boolean r13 = true;
        L8:
            ServiceConnector.n(r12, r13);     // Catch: Throwable -> L22
            if (r11 != null) goto L11;
            ServiceConnector.a(r12);     // Catch: Throwable -> L22
        L12:
            n r14 = ServiceConnector.g(r12);     // Catch: Throwable -> L22
            if (r14 != null) goto L15;
        L20:
            monitor-exit(r12);
            return;
        L15:
            if (r14.isActive() == true) goto L18;
            r14 = null;
        L18:
            if (r14 == null) goto L20;
            com.obric.aikernel.sdk.a.a(r14, ServiceConnector.h(r12));     // Catch: Throwable -> L22
            Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L22
            goto L20
        L11:
            ServiceConnector.j(r12);     // Catch: Throwable -> L22
            goto L12
        L7:
            r13 = false;
        L22:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName r10) {
            AIKLog r11 = AIKLog.INSTANCE;
            StringBuilder r12 = new StringBuilder();
            r12.append("Service ");
            if (r10 == null) goto L5;
            String r13 = r10.getClassName();
        L6:
            r12.append(r13);
            r12.append(" onBindingDied.");
            r11.i("ServiceConnector", r12.toString());
            a(null);
            return;
        L5:
            r13 = null;
            goto L6
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName r10) {
            AIKLog r11 = AIKLog.INSTANCE;
            StringBuilder r12 = new StringBuilder();
            r12.append("Service ");
            if (r10 == null) goto L5;
            String r13 = r10.getClassName();
        L6:
            r12.append(r13);
            r12.append(" onNullBinding.");
            r11.i("ServiceConnector", r12.toString());
            a(null);
            return;
        L5:
            r13 = null;
            goto L6
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r10, IBinder r11) {
            AIKLog r12 = AIKLog.INSTANCE;
            StringBuilder r13 = new StringBuilder();
            r13.append("Service ");
            if (r10 == null) goto L5;
            String r14 = r10.getClassName();
        L6:
            r13.append(r14);
            r13.append(" connected.");
            r12.i("ServiceConnector", r13.toString());
            a(r11);
            return;
        L5:
            r14 = null;
            goto L6
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r10) {
            AIKLog r11 = AIKLog.INSTANCE;
            StringBuilder r12 = new StringBuilder();
            r12.append("Service ");
            if (r10 == null) goto L5;
            String r13 = r10.getClassName();
        L6:
            r12.append(r13);
            r12.append(" disconnected.");
            r11.i("ServiceConnector", r12.toString());
            a(null);
            return;
        L5:
            r13 = null;
            goto L6
        }
    }

    public static final class e implements ServiceConnection {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ServiceConnector f4810c;

        e(ServiceConnector r10) {
            this.f4810c = r10;
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName r10) {
            AIKLog r11 = AIKLog.INSTANCE;
            StringBuilder r12 = new StringBuilder();
            r12.append("Service ");
            if (r10 == null) goto L5;
            String r13 = r10.getClassName();
        L6:
            r12.append(r13);
            r12.append(" onBindingDied.");
            r11.i("ServiceConnector", r12.toString());
            ServiceConnector r14 = this.f4810c;
            monitor-enter(r14);
            ServiceConnector.m(r14, false);     // Catch: Throwable -> L12
            ServiceConnector.o(r14, null);     // Catch: Throwable -> L12
            ServiceConnector.a(r14);     // Catch: Throwable -> L12
            Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(r14);
            return;
        L12:
            th = move-exception;
            throw th;
        L5:
            r13 = null;
            goto L6
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName r10) {
            AIKLog r11 = AIKLog.INSTANCE;
            StringBuilder r12 = new StringBuilder();
            r12.append("Service ");
            if (r10 == null) goto L5;
            String r13 = r10.getClassName();
        L6:
            r12.append(r13);
            r12.append(" onNullBinding.");
            r11.i("ServiceConnector", r12.toString());
            ServiceConnector r14 = this.f4810c;
            monitor-enter(r14);
            ServiceConnector.m(r14, false);     // Catch: Throwable -> L12
            ServiceConnector.o(r14, null);     // Catch: Throwable -> L12
            ServiceConnector.a(r14);     // Catch: Throwable -> L12
            Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(r14);
            return;
        L12:
            th = move-exception;
            throw th;
        L5:
            r13 = null;
            goto L6
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r10, IBinder r11) {
            AIKLog r12 = AIKLog.INSTANCE;
            StringBuilder r13 = new StringBuilder();
            r13.append("Service ");
            if (r10 == null) goto L5;
            String r14 = r10.getClassName();
        L6:
            r13.append(r14);
            r13.append(" connected.");
            r12.i("ServiceConnector", r13.toString());
            ServiceConnector r15 = this.f4810c;
            monitor-enter(r15);
            ServiceConnector.m(r15, true);     // Catch: Throwable -> L12
            Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(r15);
            return;
        L12:
            th = move-exception;
            throw th;
        L5:
            r14 = null;
            goto L6
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r10) {
            AIKLog r11 = AIKLog.INSTANCE;
            StringBuilder r12 = new StringBuilder();
            r12.append("Service ");
            if (r10 == null) goto L5;
            String r13 = r10.getClassName();
        L6:
            r12.append(r13);
            r12.append(" disconnected.");
            r11.i("ServiceConnector", r12.toString());
            ServiceConnector r14 = this.f4810c;
            monitor-enter(r14);
            ServiceConnector.m(r14, false);     // Catch: Throwable -> L12
            ServiceConnector.o(r14, null);     // Catch: Throwable -> L12
            ServiceConnector.a(r14);     // Catch: Throwable -> L12
            Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(r14);
            return;
        L12:
            th = move-exception;
            throw th;
        L5:
            r13 = null;
            goto L6
        }
    }

    static {
        new a(null);
    }

    public ServiceConnector(Context r10, AIKernelConfig r11, ComponentName r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "aiKernelConfig");
        Intrinsics.checkNotNullParameter(r12, "connName");
        this.f4790a = r10;
        this.f4791b = r11;
        this.f4792c = r12;
        this.f4796g = m0.a(z0.b());
        this.f4797h = new d(this);
        this.f4798i = new e(this);
    }

    private final void C(v1 r10) {
        AIKLog r11 = AIKLog.INSTANCE;
        r11.d("ServiceConnector", "[idleRelease] unbindIfIdle invoked, expectedJob=" + r10 + ", isActive=" + r10.isActive());
        monitor-enter(this);
    L67:
        th = move-exception;
        throw th;
    L5:
        if (this.f4803n == r10) goto L10;
        r11.d("ServiceConnector", "[idleRelease] race detected: current idleReleaseJob=" + this.f4803n + " != expectedJob=" + r10 + ", skip unbind");     // Catch: Throwable -> L67
        monitor-exit(this);
        return;
    L10:
        if (r10.isActive() == true) goto L14;
        r11.d("ServiceConnector", "[idleRelease] expectedJob is not active, skip unbind");     // Catch: Throwable -> L67
        monitor-exit(this);
        return;
    L14:
        boolean r12 = true;
        if (w() == true) goto L17;
    L30:
        boolean r13 = false;
    L31:
        if (r13 == true) goto L43;
        StringBuilder r14 = new StringBuilder();     // Catch: Throwable -> L67
        r14.append("[idleRelease] shouldUnbind=false, state: idleEnabled=");     // Catch: Throwable -> L67
        r14.append(this.f4794e);     // Catch: Throwable -> L67
        r14.append(", suppressed=");     // Catch: Throwable -> L67
        r14.append(this.f4795f);     // Catch: Throwable -> L67
        r14.append(", activeRequests=");     // Catch: Throwable -> L67
        r14.append(this.f4802m);     // Catch: Throwable -> L67
        r14.append(", remoteAlive=");     // Catch: Throwable -> L67
        com.obric.aikernel.a r15 = this.f4793d;     // Catch: Throwable -> L67
        if (r15 == null) goto L39;
        IBinder r16 = r15.asBinder();     // Catch: Throwable -> L67
        if (r16 == null) goto L39;
        if (r16.isBinderAlive() != true) goto L39;
    L40:
        r14.append(r12);     // Catch: Throwable -> L67
        r14.append(", connectTask=");     // Catch: Throwable -> L67
        r14.append(this.f4799j);     // Catch: Throwable -> L67
        r11.d("ServiceConnector", r14.toString());     // Catch: Throwable -> L67
        monitor-exit(this);
        return;
    L39:
        r12 = false;
        goto L40
    L43:
        boolean r17 = this.f4800k;     // Catch: Throwable -> L67
        boolean r18 = this.f4801l;     // Catch: Throwable -> L67
        r11.i("ServiceConnector", "[idleRelease] proceeding to unbind: mainBound=" + r17 + ", lifecycleBound=" + r18 + ", activeRequests=" + this.f4802m);     // Catch: Throwable -> L67
        this.f4800k = false;     // Catch: Throwable -> L67
        this.f4801l = false;     // Catch: Throwable -> L67
        this.f4793d = null;     // Catch: Throwable -> L67
        r();     // Catch: Throwable -> L67
        Pair r19 = TuplesKt.to(Boolean.valueOf(r17), Boolean.valueOf(r18));     // Catch: Throwable -> L67
        monitor-exit(this);
        boolean r20 = ((Boolean) r19.component1()).booleanValue();
        boolean r21 = ((Boolean) r19.component2()).booleanValue();
        r11.i("ServiceConnector", "main service idle timeout, unbind " + this.f4792c + ", main=" + r20 + ", lifecycle=" + r21);
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L51
        if (r20 == false) goto L49;
        r11.d("ServiceConnector", "[idleRelease] unbinding main service connection...");     // Catch: Throwable -> L51
        this.f4790a.unbindService(this.f4797h);     // Catch: Throwable -> L51
        r11.d("ServiceConnector", "[idleRelease] main service unbound successfully");     // Catch: Throwable -> L51
    L49:
        Object r23 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L51
    L53:
        Throwable r24 = Result.m35exceptionOrNullimpl(r23);
        if (r24 == null) goto L70;
        AIKLog.INSTANCE.w("ServiceConnector", "[idleRelease] unbind main service failed: " + r24);
    L70:
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L61
        if (r21 == false) goto L59;
        AIKLog r26 = AIKLog.INSTANCE;     // Catch: Throwable -> L61
        r26.d("ServiceConnector", "[idleRelease] unbinding lifecycle service connection...");     // Catch: Throwable -> L61
        this.f4790a.unbindService(this.f4798i);     // Catch: Throwable -> L61
        r26.d("ServiceConnector", "[idleRelease] lifecycle service unbound successfully");     // Catch: Throwable -> L61
    L59:
        Object r27 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L61
    L63:
        Throwable r28 = Result.m35exceptionOrNullimpl(r27);
        if (r28 == null) goto L75;
        AIKLog.INSTANCE.w("ServiceConnector", "[idleRelease] unbind lifecycle service failed: " + r28);
        return;
    L75:
        return;
    L61:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r27 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L51:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r23 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L53
    L17:
        if (this.f4802m != 0) goto L30;
        com.obric.aikernel.a r31 = this.f4793d;     // Catch: Throwable -> L67
        if (r31 == null) goto L25;
        IBinder r32 = r31.asBinder();     // Catch: Throwable -> L67
        if (r32 == null) goto L25;
        if (r32.isBinderAlive() != true) goto L25;
        boolean r33 = true;
    L26:
        if (r33 == false) goto L30;
        if (this.f4799j != null) goto L30;
        r13 = true;
    L25:
        r33 = false;
        goto L26
    }

    public static final /* synthetic */ void a(ServiceConnector r10) {
        r10.r();
    }

    public static final /* synthetic */ Object b(ServiceConnector r10, Intent r11, Continuation r12) {
        return r10.s(r11, r12);
    }

    public static final /* synthetic */ Object c(ServiceConnector r10, Intent r11, Continuation r12) {
        return r10.t(r11, r12);
    }

    public static final /* synthetic */ AIKernelConfig d(ServiceConnector r10) {
        return r10.f4791b;
    }

    public static final /* synthetic */ ComponentName e(ServiceConnector r10) {
        return r10.f4792c;
    }

    public static final /* synthetic */ r0 f(ServiceConnector r10) {
        return r10.f4799j;
    }

    public static final /* synthetic */ n g(ServiceConnector r10) {
        return r10.f4804o;
    }

    public static final /* synthetic */ com.obric.aikernel.a h(ServiceConnector r10) {
        return r10.f4793d;
    }

    public static final /* synthetic */ void i(ServiceConnector r10) {
        r10.x();
    }

    public static final /* synthetic */ void j(ServiceConnector r10) {
        r10.z();
    }

    public static final /* synthetic */ void k(ServiceConnector r10, r0 r11) {
        r10.f4799j = r11;
    }

    public static final /* synthetic */ void l(ServiceConnector r10, n r11) {
        r10.f4804o = r11;
    }

    public static final /* synthetic */ void m(ServiceConnector r10, boolean r11) {
        r10.f4801l = r11;
    }

    public static final /* synthetic */ void n(ServiceConnector r10, boolean r11) {
        r10.f4800k = r11;
    }

    public static final /* synthetic */ void o(ServiceConnector r10, com.obric.aikernel.a r11) {
        r10.f4793d = r11;
    }

    public static final /* synthetic */ void p(ServiceConnector r10, v1 r11) {
        r10.C(r11);
    }

    @GuardedBy("this")
    private final c q() {
        if (w() == false) goto L5;
        this.f4802m++;
        v1 r10 = this.f4803n;
        if (r10 == null) goto L9;
        v1.a.a(r10, null, 1, null);
    L9:
        this.f4803n = null;
        return new c(this);
    L5:
        return new c(null);
    }

    @GuardedBy("this")
    private final void r() {
        v1 r10 = this.f4803n;
        if (r10 == null) goto L5;
        v1.a.a(r10, null, 1, null);
    L5:
        this.f4803n = null;
        n<? super com.obric.aikernel.a> r11 = this.f4804o;
        if (r11 != null) goto L8;
    L13:
        this.f4804o = null;
        this.f4799j = null;
        this.f4802m = 0;
        this.f4800k = false;
        this.f4801l = false;
        this.f4795f = false;
        return;
    L8:
        if (r11.isActive() == true) goto L11;
        r11 = null;
    L11:
        if (r11 == null) goto L13;
        com.obric.aikernel.sdk.a.a(r11, null);
        goto L13
    }

    private final Object s(Intent r10, Continuation<? super com.obric.aikernel.a> r11) {
        ContentResolver r12 = this.f4790a.getContentResolver();
        Bundle r13 = new Bundle();
        r13.putParcelable("intent", r10);
        Unit r14 = Unit.INSTANCE;
        Bundle r15 = r12.call("com.obric.aikernel.service.auth", "onBind", null, r13);
        if (r15 == null) goto L23;
        IBinder r16 = r15.getBinder("binder");
        if (r16 == null) goto L28;
        com.obric.aikernel.a r17 = com.obric.aikernel.a.AbstractBinderC0095a.U0(r16);
        if (r17 == null) goto L29;
        this.f4793d = r17;
        boolean r18 = false;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L11
        Context r20 = this.f4790a;     // Catch: Throwable -> L11
        Intent r21 = new Intent();     // Catch: Throwable -> L11
        r21.setComponent(new ComponentName(this.f4792c.getPackageName(), "com.obric.aikernel.LifeCycleService"));     // Catch: Throwable -> L11
        r18 = com.obric.aikernel.phx.core.conn.c.a(r20, r21, m1.a(z0.b()), this.f4798i);     // Catch: Throwable -> L11
        Object r22 = Result.m32constructorimpl(r14);     // Catch: Throwable -> L11
    L13:
        Throwable r23 = Result.m35exceptionOrNullimpl(r22);
        if (r23 == null) goto L16;
        AIKLog.INSTANCE.w("ServiceConnector", "bind lifecycle service failed: " + r23);
    L16:
        monitor-enter(this);
        this.f4801l = r18;     // Catch: Throwable -> L20
        Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(this);
        AIKLog.INSTANCE.i("ServiceConnector", "auth provider got binder, lifecycleBound=" + r18);
        return r17;
    L20:
        th = move-exception;
        throw th;
    L11:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r22 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L13
    L29:
        return null;
    L28:
        return null;
    L23:
        return null;
    }

    private final Object t(Intent r10, Continuation<? super com.obric.aikernel.a> r11) {
        boolean r12 = com.obric.aikernel.phx.core.conn.c.a(this.f4790a, r10, m1.a(z0.b()), this.f4797h);
        monitor-enter(this);
        this.f4800k = r12;     // Catch: Throwable -> L20
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(this);
        AIKLog.INSTANCE.i("ServiceConnector", "start binding to " + this.f4792c + ", result = " + r12);
        boolean r14 = true;
        o r15 = new o(IntrinsicsKt.intercepted(r11), 1);
        r15.F();
        l(this, r15);
        com.obric.aikernel.a r16 = h(this);
        if (r16 == null) goto L13;
        IBinder r17 = r16.asBinder();
        if (r17 == null) goto L13;
        if (r17.isBinderAlive() != true) goto L13;
    L14:
        if (r14 == false) goto L16;
        com.obric.aikernel.sdk.a.a(r15, h(this));
    L16:
        Object r18 = r15.B();
        if (r18 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L19:
        return r18;
    L13:
        r14 = false;
    L20:
        th = move-exception;
        throw th;
    }

    @GuardedBy("this")
    private final boolean w() {
        if (this.f4794e == true) goto L5;
    L9:
        return false;
    L5:
        if (this.f4795f == true) goto L9;
        if (this.f4791b.getMainServiceIdleUnbindTimeoutMs() < 0) goto L9;
        return true;
    }

    private final void x() {
        monitor-enter(this);
        int r10 = this.f4802m;     // Catch: Throwable -> L10
        if (r10 <= 0) goto L6;
        this.f4802m = r10 - 1;     // Catch: Throwable -> L10
    L7:
        z();     // Catch: Throwable -> L10
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        AIKLog.INSTANCE.w("ServiceConnector", "main process ipc lease released with no active request.");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private final long y(long r10) {
        return Math.max(r10 - System.currentTimeMillis(), 0);
    }

    @GuardedBy("this")
    private final void z() {
        if (w() == true) goto L5;
        return;
    L5:
        com.obric.aikernel.a r10 = this.f4793d;
        boolean r11 = false;
        if (r10 == null) goto L12;
        IBinder r12 = r10.asBinder();
        if (r12 == null) goto L12;
        if (r12.isBinderAlive() != true) goto L12;
        r11 = true;
    L12:
        if (r11 == true) goto L15;
        return;
    L15:
        if (this.f4802m <= 0) goto L17;
        return;
    L17:
        v1 r13 = this.f4803n;
        if (r13 == null) goto L20;
        v1.a.a(r13, null, 1, null);
    L20:
        this.f4803n = h.d(this.f4796g, null, null, new ServiceConnector$scheduleIdleReleaseLocked$job$1(this.f4791b.getMainServiceIdleUnbindTimeoutMs(), this, null), 3, null);
    }

    public final void A(boolean r10) {
        monitor-enter(this);
        this.f4794e = r10;     // Catch: Throwable -> L13
        if (r10 == false) goto L6;
        z();     // Catch: Throwable -> L13
    L10:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L6:
        v1 r12 = this.f4803n;     // Catch: Throwable -> L13
        if (r12 == null) goto L9;
        v1.a.a(r12, null, 1, null);     // Catch: Throwable -> L13
    L9:
        this.f4803n = null;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final void B() {
        monitor-enter(this);
        this.f4795f = true;     // Catch: Throwable -> L10
        v1 r10 = this.f4803n;     // Catch: Throwable -> L10
        if (r10 == null) goto L7;
        v1.a.a(r10, null, 1, null);     // Catch: Throwable -> L10
    L7:
        this.f4803n = null;     // Catch: Throwable -> L10
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final Object u(long r10, Continuation<? super com.obric.aikernel.a> r11) {
        com.obric.aikernel.a r12 = this.f4793d;
        boolean r13 = true;
        if (r12 == null) goto L9;
        IBinder r14 = r12.asBinder();
        if (r14 == null) goto L9;
        if (r14.isBinderAlive() != true) goto L9;
    L10:
        if (r13 == false) goto L14;
        return this.f4793d;
    L14:
        return TimeoutKt.d(r10, new ServiceConnector$getService$2(this, null), r11);
    L9:
        r13 = false;
        goto L10
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0055 -> B:18:0x0058). Please report as a decompilation issue!!! */
    public final Object v(long r10, Continuation<? super b> r12) {
        if ((r12 instanceof ServiceConnector$getServiceWithMainProcessIpcLease$1) == false) goto L7;
        ServiceConnector$getServiceWithMainProcessIpcLease$1 r11 = (ServiceConnector$getServiceWithMainProcessIpcLease$1) r12;
        int r13 = r11.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r11.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r11.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        long r17 = r11.J$0;
        ServiceConnector r18 = (ServiceConnector) r11.L$0;
        ResultKt.throwOnFailure(r14);
        long r19 = r17;
        ServiceConnector this = r18;
    L18:
        com.obric.aikernel.a r110 = (com.obric.aikernel.a) r14;
        if (r110 != null) goto L21;
        return null;
    L21:
        monitor-enter(this);
        com.obric.aikernel.a r111 = this.f4793d;     // Catch: Throwable -> L40
        boolean r20 = false;
        if (r111 == null) goto L29;
        IBinder r21 = r111.asBinder();     // Catch: Throwable -> L40
        if (r21 == null) goto L29;
        if (r21.isBinderAlive() != true) goto L29;
        r20 = true;
    L29:
        if (r20 == true) goto L31;
    L35:
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L40
        monitor-exit(this);
        if (this.y(r19) <= 0) goto L39;
    L15:
        long r113 = this.y(r19);
        r11.L$0 = this;
        r11.J$0 = r19;
        r11.label = 1;
        r14 = this.u(r113, r11);
        if (r14 != r15) goto L18;
        return r15;
    L39:
        return null;
    L31:
        if (Intrinsics.areEqual(r111.asBinder(), r110.asBinder()) == false) goto L35;
        b r114 = new b(r111, this.q());     // Catch: Throwable -> L40
        monitor-exit(this);
        return r114;
    L40:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        r19 = System.currentTimeMillis() + Math.max(r10, 0);
    L7:
        r11 = new ServiceConnector$getServiceWithMainProcessIpcLease$1(this, r12);
        goto L8
    }
}
