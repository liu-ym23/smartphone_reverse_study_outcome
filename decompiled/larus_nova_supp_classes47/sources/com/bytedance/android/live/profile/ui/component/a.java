package com.bytedance.android.live.profile.ui.component;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.live.profile.ui.component.view.button.ProfileFansGroupButtonView;
import com.bytedance.android.live.profile.ui.component.view.button.ProfileFollowButtonView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ProfileButtonAreaComponent a;

    public a(ProfileButtonAreaComponent r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        ProfileFansGroupButtonView r0 = this.a.l;
        LinearLayout.LayoutParams r1 = null;
        if (r0 == null) goto L5;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
    L7:
        if ((r2 instanceof LinearLayout.LayoutParams) == true) goto L9;
        r2 = null;
    L9:
        LinearLayout.LayoutParams r3 = (LinearLayout.LayoutParams) r2;
        if (r3 != null) goto L12;
    L23:
        Object r6 = r5.getAnimatedValue();
        if (r6 == null) goto L34;
        int r7 = ((Integer) r6).intValue();
        ProfileFollowButtonView r4 = this.a.h;
        if (r4 == null) goto L35;
        if (r4 == null) goto L31;
        ViewGroup.LayoutParams r8 = r4.getLayoutParams();
        if (r8 == null) goto L31;
        r1 = (LinearLayout.LayoutParams) r8;
        r1.weight = 0.0f;
        r8.width = r7;
    L31:
        r4.setLayoutParams(r1);
        return;
    L35:
        return;
    L34:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L12:
        if (r3.weight != 0.0f) goto L23;
        ProfileFansGroupButtonView r9 = this.a.l;
        if (r9 == null) goto L16;
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
    L18:
        if ((r10 instanceof LinearLayout.LayoutParams) == true) goto L20;
        r10 = null;
    L20:
        LinearLayout.LayoutParams r12 = (LinearLayout.LayoutParams) r10;
        if (r12 == null) goto L23;
        r12.weight = 1.0f;
        goto L23
    L16:
        r10 = null;
        goto L18
    L5:
        r2 = null;
        goto L7
    }
}
