package com.bytedance.android.live.liveinteract.voicechat.match.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.model.b1;
import com.bytedance.common.utility.UIUtils;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends AnimatorListenerAdapter {
    public final /* synthetic */ ChatMatchDialog a;
    public final /* synthetic */ b1 b;
    public final /* synthetic */ int c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ Function0 e;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        if (this.b == null) goto L10;
        ConstraintLayout r3 = this.a.z;
        if (r3 == null) goto L7;
        UtilityKotlinExtentionsKt.t(r3);
    L7:
        LinearLayout r4 = this.a.u;
        if (r4 == null) goto L13;
        UtilityKotlinExtentionsKt.t(r4);
    L13:
        this.e.invoke();
        return;
    L10:
        FrameLayout r5 = (FrameLayout) this.a.S90(2131364335);
        if (r5 == null) goto L13;
        UtilityKotlinExtentionsKt.t(r5);
        goto L13
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        if (this.b == null) goto L17;
        FrameLayout r4 = (FrameLayout) this.a.S90(2131364335);
        if (r4 == null) goto L7;
        UtilityKotlinExtentionsKt.w(r4);
    L7:
        FrameLayout r5 = (FrameLayout) this.a.S90(2131364335);
        if (r5 == null) goto L10;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
    L11:
        if (r6 == null) goto L13;
        r6.height = this.c;
    L13:
        FrameLayout r0 = (FrameLayout) this.a.S90(2131364335);
        if (r0 == null) goto L16;
        r0.setLayoutParams(r6);
    L16:
        ImageUtil.loadRoundResource(this.a.I, 2131250965, -1, -1);
        return;
    L10:
        r6 = null;
        goto L11
    L17:
        ConstraintLayout r7 = this.a.z;
        Handler r1 = UtilityKotlinExtentionsKt.a;
        UIUtils.setViewVisibility(r7, 0);
        if (this.d == true) goto L24;
        LinearLayout r8 = this.a.u;
        if (r8 == null) goto L25;
        UtilityKotlinExtentionsKt.w(r8);
        return;
    L25:
        return;
    }

    public b(ChatMatchDialog r1, b1 r2, int r3, boolean r4, Function0 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
