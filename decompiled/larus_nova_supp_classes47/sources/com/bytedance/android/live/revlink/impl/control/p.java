package com.bytedance.android.live.revlink.impl.control;

import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.revlink.impl.behavior.ToolbarPkBehavior;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p<T> implements Observer {
    public final /* synthetic */ LinkRevControlWidget a;

    public p(LinkRevControlWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        q11.b r6 = (q11.b) r5;
        if (r6 == null) goto L29;
        LinkRevControlWidget r0 = this.a;
        if (r0.E == false) goto L35;
        View r1 = r0.i.j;
        boolean r2 = false;
        if (r1 == null) goto L10;
        Intrinsics.checkNotNull(r1);
        r1.setVisibility(0);
    L10:
        w31.c r3 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r3 != null) goto L13;
        return;
    L13:
        if (r3.o() == true) goto L15;
        return;
    L15:
        if ((r6 instanceof q11.b.a) == false) goto L17;
        r0.i.I();
        return;
    L17:
        if ((r6 instanceof q11.b.C0295b) == false) goto L19;
        r0.i.A();
        return;
    L19:
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r7 = com.bytedance.android.live.revlink.impl.global.b.m();
        if (r7 != null) goto L22;
    L24:
        if (r2 == false) goto L26;
        r0.i.A();
        return;
    L26:
        ToolbarPkBehavior r8 = r0.i;
        LottieAnimationView r4 = r8.k;
        Intrinsics.checkNotNull(r4);
        r4.clearAnimation();
        r8.E(2131251182);
        return;
    L22:
        if (r7.i() != true) goto L24;
        r2 = true;
        goto L24
    L35:
        return;
    }
}
