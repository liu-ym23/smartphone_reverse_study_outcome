package com.ss.android.lark.chat.message.menu.v2;

import android.animation.ValueAnimator;
import android.view.View;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ View b;

    public j(UDShadowLayout r1, UDShadowLayout r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        Float r4 = (Float) r3.getAnimatedValue();
        if (r4 == null) goto L5;
        float r5 = r4.floatValue();
    L6:
        float r6 = r5 / 1000.0f;
        this.a.setAlpha(1 - r6);
        this.b.setAlpha(r6);
        return;
    L5:
        r5 = 0.0f;
        goto L6
    }
}
