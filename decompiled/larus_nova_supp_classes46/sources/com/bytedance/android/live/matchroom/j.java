package com.bytedance.android.live.matchroom;

import android.animation.ValueAnimator;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {
    public static final j a = null;

    static {
        a = new j();
    }

    public j() {
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r2, "animator");
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L13;
        float r4 = ((Float) r3).floatValue();
        if (Float.isNaN(r4) == true) goto L14;
        boolean r0 = MatchRoomLandScapeAnimUtil.a;
        WeakReference<d> r1 = MatchRoomLandScapeAnimUtil.l;
        if (r1 == null) goto L15;
        d r5 = r1.get();
        if (r5 == null) goto L16;
        r5.b(r4);
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
