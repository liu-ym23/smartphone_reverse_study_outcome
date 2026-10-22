package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.animation.ValueAnimator;
import android.view.View;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ List b;
    public final /* synthetic */ View c;

    public v(View r1, List r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        Object r3 = r2.getAnimatedValue();
        if ((r3 instanceof Float) == true) goto L5;
        r3 = null;
    L5:
        Float r4 = (Float) r3;
        if (r4 == null) goto L9;
        float r5 = r4.floatValue();
        this.a.setAlpha(r5);
        return;
    }
}
