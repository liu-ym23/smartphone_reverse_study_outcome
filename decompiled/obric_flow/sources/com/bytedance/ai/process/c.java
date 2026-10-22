package com.bytedance.ai.process;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements ServiceConnection {
    @Override // android.content.ServiceConnection
    public final void onNullBinding(ComponentName r5) {
        super.onNullBinding(r5);
        Intrinsics.checkNotNullParameter("AISDKRemoteServiceProxy", "tag");
        t0.d r10 = com.bytedance.ai.utils.c.f2846a;
        if (r10 == null) goto L5;
        r10.e("AISDKRemoteServiceProxy", "exception in onNullBinding. remoteService is NULL");
    L5:
        d r11 = d.f2415a;
        d.d(new AISDKRemoteServiceProxy$ServiceBindException());
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r10, IBinder r11) {
        d.f2420j = r11;
        Unit r12 = null;
        if (r11 == null) goto L10;
        int r5 = f.f2426a;
        IInterface r13 = r11.queryLocalInterface("com.bytedance.ai.process.IAISDKRemoteBinder");
        if (r13 != null) goto L7;
    L9:
        g r14 = new e(r11);
    L11:
        d.f2416b = r14;
        if (r11 != null) goto L14;
    L16:
        boolean r15 = false;
    L17:
        String r16 = "onServiceConnected. binderAlive=" + r15 + " service=" + d.f2416b;
        Intrinsics.checkNotNullParameter("AISDKRemoteServiceProxy", "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L21;
        r17.i("AISDKRemoteServiceProxy", r16);
    L21:
        if (d.f2416b == null) goto L59;
        if (r15 == false) goto L59;
        if (d.f2421k != null) goto L64;
        d.f2421k = new a();
    L64:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L32
        a r19 = d.f2421k;     // Catch: Throwable -> L32
        if (r19 == null) goto L34;
        if (r11 == null) goto L34;
        r11.linkToDeath(r19, 0);     // Catch: Throwable -> L32
        r12 = Unit.INSTANCE;     // Catch: Throwable -> L32
    L34:
        Object r20 = Result.m124constructorimpl(r12);     // Catch: Throwable -> L32
    L37:
        Throwable r21 = Result.m127exceptionOrNullimpl(r20);
        if (r21 == null) goto L66;
        String r22 = "linkToDeath failed: " + r21;
        Intrinsics.checkNotNullParameter("AISDKRemoteServiceProxy", "tag");
        t0.d r23 = com.bytedance.ai.utils.c.f2846a;
        if (r23 == null) goto L66;
        r23.e("AISDKRemoteServiceProxy", r22);
    L66:
        g r24 = d.f2416b;     // Catch: Throwable -> L46 RemoteException -> L48
        if (r24 == null) goto L68;
        e r25 = (e) r24;     // Catch: Throwable -> L46 RemoteException -> L48
        r25.d(d.f2418h, d.f2422l);     // Catch: Throwable -> L46 RemoteException -> L48
        b r26 = new b(1);     // Catch: Throwable -> L46 RemoteException -> L48
        r26.attachInterface(r26, "com.bytedance.ai.process.IAISDKInitializeCallback");     // Catch: Throwable -> L46 RemoteException -> L48
        r25.g(r26);     // Catch: Throwable -> L46 RemoteException -> L48
    L70:
        return;
    L68:
        return;
    L48:
        e = move-exception;
        String r27 = "remote transact failed in onServiceConnected: " + e;
        Intrinsics.checkNotNullParameter("AISDKRemoteServiceProxy", "tag");
        t0.d r28 = com.bytedance.ai.utils.c.f2846a;
        if (r28 == null) goto L57;
        r28.e("AISDKRemoteServiceProxy", r27);
    L57:
        d r29 = d.f2415a;
        d.d(new AISDKRemoteServiceProxy$ServiceDeadException(e));
        return;
    L46:
        th = move-exception;
        String r30 = "unexpected error in onServiceConnected: " + th;
        Intrinsics.checkNotNullParameter("AISDKRemoteServiceProxy", "tag");
        t0.d r31 = com.bytedance.ai.utils.c.f2846a;
        if (r31 == null) goto L53;
        r31.e("AISDKRemoteServiceProxy", r30);
    L53:
        d.d(th);
        return;
    L32:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r20 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L59:
        String r33 = "onServiceConnected invalid binder. binderAlive=" + r15 + " service=" + d.f2416b;
        Intrinsics.checkNotNullParameter("AISDKRemoteServiceProxy", "tag");
        t0.d r34 = com.bytedance.ai.utils.c.f2846a;
        if (r34 == null) goto L62;
        r34.e("AISDKRemoteServiceProxy", r33);
    L62:
        d.d(new AISDKRemoteServiceProxy$ServiceDeadException());
        return;
    L14:
        if (r11.isBinderAlive() != true) goto L16;
        r15 = true;
        goto L17
    L7:
        if ((r13 instanceof g) == false) goto L9;
        r14 = (g) r13;
        goto L11
    L10:
        r14 = null;
        goto L11
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r5) {
        Intrinsics.checkNotNullParameter("AISDKRemoteServiceProxy", "tag");
        t0.d r10 = com.bytedance.ai.utils.c.f2846a;
        if (r10 == null) goto L5;
        r10.d("AISDKRemoteServiceProxy", "onServiceDisconnected");
    L5:
        d.f2416b = null;
        d.f2420j = null;
        d.d.set(false);
    }
}
