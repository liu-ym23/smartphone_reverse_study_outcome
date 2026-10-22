package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.text.Spannable;
import android.widget.TextView;
import com.bytedance.android.live.profit.privilege.model.touch.PrivilegeEntranceInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v implements yr2.a {
    public final /* synthetic */ PrivilegeEntranceInfo a;
    public final /* synthetic */ GiftMVIDetailTopView b;
    public final /* synthetic */ com.bytedance.android.live.profit.privilege.model.touch.c c;

    public final void a(py.k r2) {
        Intrinsics.checkNotNullParameter(r2, "image");
        Intrinsics.checkNotNullParameter(r2, "image");
    }

    public final void b(Spannable r10, yr2.a.a r11) {
        Intrinsics.checkNotNullParameter(r10, "spannable");
        Intrinsics.checkNotNullParameter(r11, "info");
        TextView r13 = this.b.p;
        if (r13 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDynamicInfo");
    L5:
        r13.setText(r10);
        TextView r14 = this.b.p;
        if (r14 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mDynamicInfo");
    L8:
        r14.setAlpha(0.0f);
        TextView r15 = this.b.p;
        if (r15 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mDynamicInfo");
    L11:
        r15.setVisibility(0);
        this.b.B(this.a.getPanelDetail(), this.a.getBubbleText());
        GiftMVIDetailTopView r16 = this.b;
        com.bytedance.android.live.profit.privilege.model.touch.c r1 = this.c;
        TextView r2 = r16.p;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mDynamicInfo");
    L14:
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r2, "alpha", new float[]{0.0f, 1.0f});
        r3.setDuration(400);
        r3.setInterpolator(r16.v);
        r3.addListener(new s(r16));
        TextView r4 = r16.n;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mDetailBtn");
    L17:
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r4, "alpha", new float[]{1.0f, 0.0f});
        r5.setDuration(400);
        r5.setInterpolator(r16.v);
        AnimatorSet r6 = new AnimatorSet();
        r6.playTogether(new Animator[]{r3, r5});
        TextView r17 = r16.n;
        if (r17 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mDetailBtn");
    L20:
        r17.postDelayed(new t(r6), r1.a);
        TextView r18 = r16.n;
        if (r18 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mDetailBtn");
    L23:
        r18.postDelayed(new u(r16), (r1.a + 400) + r1.c);
    }

    public v(PrivilegeEntranceInfo r1, GiftMVIDetailTopView r2, com.bytedance.android.live.profit.privilege.model.touch.c r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
