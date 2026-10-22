package com.bytedance.android.livesdk.gamesticker.t01.anim;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gamesticker.t01.T01GameLiveView;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class d extends b {
    public AnimatorSet d;

    @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.b
    public final void a() {
        AnimatorSet r0 = this.d;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.d = null;
    }

    public d() {
    }

    public static boolean g(View... r5) {
        Intrinsics.checkNotNullParameter(r5, "views");
        if (r5.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return false;
    L8:
        int r1 = r5.length;
        int r3 = 0;
    L9:
        if (r3 >= r1) goto L14;
        if (r5[r3].getVisibility() == 0) goto L12;
        r3 = r3 + 1;
        goto L9
    L12:
        return true;
    L14:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    public final ValueAnimator h(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        i r0 = this.c;
        if (r0 == null) goto L5;
        float r1 = r0.getHeight();
    L7:
        return ObjectAnimator.ofFloat(r4, "translationY", new float[]{r1, 0.0f});
    L5:
        r1 = s1.f(28.0f);
        goto L7
    }

    public final ValueAnimator i(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        i r0 = this.c;
        if (r0 == null) goto L5;
        float r1 = r0.getHeight();
    L7:
        return ObjectAnimator.ofFloat(r5, "translationY", new float[]{0.0f, -r1});
    L5:
        r1 = s1.f(28.0f);
        goto L7
    }

    public static Object f(Object[] r4, Object r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "views");
        int r1 = 0;
        if (r4.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return r5;
    L8:
        int r2 = r4.length;
    L9:
        if (r1 >= r2) goto L16;
        Object r3 = r4[r1];
        if ((r3 instanceof View) == false) goto L15;
        if (((View) r3).getVisibility() != r6) goto L15;
        return r3;
    L15:
        r1 = r1 + 1;
        goto L9
    L16:
        return r5;
    L5:
        r0 = false;
        goto L6
    }

    public final void k(View r9, View r10, Function0<Unit> r11, Function0<Unit> r12) {
        Intrinsics.checkNotNullParameter(r9, "inView");
        Intrinsics.checkNotNullParameter(r10, "outView");
        Intrinsics.checkNotNullParameter(r11, "onStart");
        Intrinsics.checkNotNullParameter(r12, "onEnd");
        j(r9, r10, null, null, r11, r12);
    }

    public final void j(View r4, View r5, T01GameLiveView r6, T01GameLiveView r7, Function0 r8, Function0 r9) {
        Intrinsics.checkNotNullParameter(r4, "inView");
        Intrinsics.checkNotNullParameter(r5, "outView");
        Intrinsics.checkNotNullParameter(r8, "onStart");
        Intrinsics.checkNotNullParameter(r9, "onEnd");
        List r0 = CollectionsKt.mutableListOf(new ValueAnimator[]{h(r4), i(r5)});
        if (r6 == null) goto L6;
        if (r7 == null) goto L6;
        r0.add(h(r6));
        r0.add(i(r7));
        r4.toString();
        r5.toString();
        r6.toString();
        r7.toString();
    L6:
        AnimatorSet r10 = new AnimatorSet();
        this.d = r10;
        r10.playTogether(CollectionsKt.toList(r0));
        AnimatorSet r11 = this.d;
        if (r11 == null) goto L9;
        r11.setDuration(500);
    L9:
        AnimatorSet r12 = this.d;
        if (r12 == null) goto L12;
        r12.addListener(new c(r8, r9));
    L12:
        AnimatorSet r13 = this.d;
        if (r13 == null) goto L16;
        r13.start();
        return;
    }
}
