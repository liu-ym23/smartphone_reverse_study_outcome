package com.bytedance.android.livesdk.chatroom.vs_base.player;

import com.bytedance.android.live.core.log.ALogger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements InvocationHandler {
    public f a;

    public g() {
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r5, Method r6, Object[] r7) {
        Intrinsics.checkNotNullParameter(r7, "args");
        f r8 = this.a;
        if (r8 == null) goto L21;
        Object r9 = r7[1];
        if (r9 == null) goto L20;
        vic.a r10 = (vic.a) r9;
        Object r0 = r7[2];
        if (r0 == null) goto L18;
        int r1 = ((Integer) r0).intValue();
        Object r2 = r7[3];
        if (r2 == null) goto L16;
        int r3 = ((Integer) r2).intValue();
        Object r11 = r7[4];
        if (r11 == null) goto L14;
        boolean r12 = ((Boolean) r11).booleanValue();
        ALogger.i("ScreenOrientationChangeListenerProxy", "FullScreenOperator: " + r10 + ", targetOrientation: " + r1 + ", currentOrientation: " + r3 + ", systemAutoRotateEnabled: " + r12);
        r8.a(r1, r3, r12);
        return null;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L18:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.android.videoshop.fullscreen.FullScreenOperator");
    L21:
        return null;
    }
}
