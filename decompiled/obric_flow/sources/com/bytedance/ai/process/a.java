package com.bytedance.ai.process;

import android.os.IBinder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements IBinder.DeathRecipient {
    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        StringBuilder r5 = new StringBuilder("remote service process died. binderAlive=");
        IBinder r10 = d.f2420j;
        if (r10 == null) goto L7;
        boolean r11 = true;
        if (r10.isBinderAlive() != true) goto L7;
    L8:
        r5.append(r11);
        String r12 = r5.toString();
        Intrinsics.checkNotNullParameter("AISDKRemoteServiceProxy", "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L11;
        r13.e("AISDKRemoteServiceProxy", r12);
    L11:
        d.d.set(false);
        d.d(new AISDKRemoteServiceProxy$ServiceDeadException());
        return;
    L7:
        r11 = false;
        goto L8
    }
}
