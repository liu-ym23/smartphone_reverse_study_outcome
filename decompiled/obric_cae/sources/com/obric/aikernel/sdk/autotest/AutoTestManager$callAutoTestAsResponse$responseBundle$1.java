package com.obric.aikernel.sdk.autotest;

import ae.d;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import ce.e;
import ce.h;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropConstant;
import defpackage.c;
import ge.p;
import he.j;
import java.util.concurrent.CancellationException;
import pe.g;
import pe.z;

/* JADX INFO: loaded from: classes.dex */
@e(c = "com.obric.aikernel.sdk.autotest.AutoTestManager$callAutoTestAsResponse$responseBundle$1", f = "AutoTestManager.kt", l = {98}, m = "invokeSuspend")
public final class AutoTestManager$callAutoTestAsResponse$responseBundle$1 extends h implements p<z, d<? super Bundle>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AIKBinder f5341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5342b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Bundle f5343m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ long f5344n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ AIKBinder f5345o;

    public static final class a extends j implements ge.a<xd.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g<Bundle> f5347a;

        public a(pe.h r8) {
            this.f5347a = r8;
            super(0);
        }

        @Override // ge.a
        public final xd.j f() {
            AIKLog.INSTANCE.v("AutoTestManager", "callAutoTestlAsResponse connection lost");
            g<Bundle> r8 = this.f5347a;
            if (r8.a() == false) goto L6;
            Bundle r10 = new Bundle();
            wa.a.l(r10, 102, BwdlDropConstant.REASON_CONNECTION_LOST, 4);
            r8.resumeWith(r10);
        L6:
            return xd.j.f13877a;
        }
    }

    public AutoTestManager$callAutoTestAsResponse$responseBundle$1(Bundle r8, long r10, AIKBinder r11, d<? super AutoTestManager$callAutoTestAsResponse$responseBundle$1> r12) {
        this.f5343m = r8;
        this.f5344n = r10;
        this.f5345o = r11;
        super(2, r12);
    }

    @Override // ce.a
    public final d<xd.j> create(Object r8, d<?> r10) {
        return new AutoTestManager$callAutoTestAsResponse$responseBundle$1(this.f5343m, this.f5344n, this.f5345o, r10);
    }

    @Override // ge.p
    public final Object invoke(z r8, d<? super Bundle> r10) {
        return ((AutoTestManager$callAutoTestAsResponse$responseBundle$1) create(r8, r10)).invokeSuspend(xd.j.f13877a);
    }

    @Override // ce.a
    public final Object invokeSuspend(Object r10) {
        l6.a.M();
        be.a r8 = be.a.f3165a;
        int r11 = this.f5342b;
        if (r11 == 0) goto L9;
        if (r11 != 1) goto L8;
        c.m0(r10);     // Catch: CancellationException -> L29
    L35:
        return (Bundle) r10;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        c.m0(r10);
        AIKLog r12 = AIKLog.INSTANCE;
        StringBuilder r13 = new StringBuilder("start callAutoTestlAsResponse ");
        Bundle r14 = this.f5343m;
        r13.append(r14.getString(IdlKeys.MethodName));
        r13.append(", timeoutMs = ");
        r13.append(this.f5344n);
        r13.append(", traceid=");
        r13.append(r14.getString(IdlKeys.Args_TraceId));
        r12.v("AutoTestManager", r13.toString());
        AIKBinder r15 = this.f5345o;     // Catch: CancellationException -> L29
        this.f5341a = r15;     // Catch: CancellationException -> L29
        this.f5342b = 1;     // Catch: CancellationException -> L29
        final pe.h r16 = new pe.h(1, l6.a.b0(this));     // Catch: CancellationException -> L29
        r16.q();     // Catch: CancellationException -> L29
        a r17 = new a(r16);     // Catch: CancellationException -> L29
        r15.asBinder().linkToDeath(new AutoTestManager.d(r17), 0);     // Catch: CancellationException -> L29
        r15.h2(r14, new AutoTestManager$callAutoTestAsResponse$responseBundle$1$1$1(r16));     // Catch: Throwable -> L14 RemoteException -> L16
        IBinder r18 = r15.asBinder();     // Catch: CancellationException -> L29
        AutoTestManager.d r19 = new AutoTestManager.d(r17);     // Catch: CancellationException -> L29
    L21:
        r18.unlinkToDeath(r19, 0);     // Catch: CancellationException -> L29
        r10 = r16.p();     // Catch: CancellationException -> L29
        l6.a.M();     // Catch: CancellationException -> L29
        if (r10 != be.a.f3165a) goto L24;
        l6.a.B0(this);     // Catch: CancellationException -> L29
    L24:
        if (r10 != r8) goto L35;
        return r8;
    L14:
        th = move-exception;
        r15.asBinder().unlinkToDeath(new AutoTestManager.d(r17), 0);     // Catch: CancellationException -> L29
        throw th;     // Catch: CancellationException -> L29
    L16:
        e = move-exception;
        if (r16.a() == false) goto L20;
        Bundle r20 = new Bundle();     // Catch: Throwable -> L14
        wa.a.k(e.getMessage(), r20);     // Catch: Throwable -> L14
        r16.resumeWith(r20);     // Catch: Throwable -> L14
    L20:
        r18 = r15.asBinder();     // Catch: CancellationException -> L29
        r19 = new AutoTestManager.d(r17);     // Catch: CancellationException -> L29
    L29:
        e = move-exception;
        AIKLog.INSTANCE.d("AutoTestManager", "callAutoTestlAsResponse error: " + e.getMessage());
        return null;
    }
}
