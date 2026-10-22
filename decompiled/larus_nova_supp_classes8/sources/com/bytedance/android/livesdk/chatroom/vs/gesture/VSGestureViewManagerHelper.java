package com.bytedance.android.livesdk.chatroom.vs.gesture;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import vr1.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class VSGestureViewManagerHelper {
    public static ko1.c a;
    public static g b;
    public static Function0<Integer> c;

    public static void b() {
        b = null;
        a = null;
        VSGestureViewManagerHelper$release$1 r0 = VSGestureViewManagerHelper$release$1.INSTANCE;
        VSGestureViewManagerHelper$release$2 r1 = VSGestureViewManagerHelper$release$2.INSTANCE;
    }

    static {
        VSGestureViewManagerHelper$resetButtonRightFunc$1 r0 = VSGestureViewManagerHelper$resetButtonRightFunc$1.INSTANCE;
        VSGestureViewManagerHelper$toolbarLeftFunc$1 r1 = VSGestureViewManagerHelper$toolbarLeftFunc$1.INSTANCE;
    }

    public static void c(Function0 r0) {
        if (r0 != null) goto L4;
        VSGestureViewManagerHelper$setResetButtonRightFun$1 r1 = VSGestureViewManagerHelper$setResetButtonRightFun$1.INSTANCE;
        return;
    L4:
        c = r0;
    }

    public static ko1.c a(DataCenter r6, Context r7, View r8, ViewGroup r9, m r10) {
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "targetView");
        Intrinsics.checkNotNullParameter(r9, "viewGroup");
        if (a != null) goto L11;
        b = new g(r6, r8, r10);
        if (r.d().isSaas() == false) goto L7;
        ko1.c r11 = new VSGestureViewManagerHelper$createSaasGestureManager$1(r8, r9, r7, r8, r9);
    L8:
        a = r11;
        if (r11 == null) goto L11;
        r11.a();
        goto L11
    L7:
        s r12 = r.p();
        g r13 = b;
        Intrinsics.checkNotNull(r13);
        r11 = r12.g(r7, r8, r9, r13);
    L11:
        g r14 = b;
        if (r14 == null) goto L15;
        r14.d = 0L;
    L15:
        return a;
    }
}
