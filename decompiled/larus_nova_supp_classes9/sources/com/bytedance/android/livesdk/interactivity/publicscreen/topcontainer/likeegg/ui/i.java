package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.ui;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i extends BaseAnimationListener {
    public final /* synthetic */ LikeEggView$prepareToActiveController$2.a a;

    public i(LikeEggView$prepareToActiveController$2.a r1) {
        this.a = r1;
    }

    public final void onAnimationStop(AnimatedDrawable2 r3) {
        HSImageView r0 = this.a.a.this$0.c;
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.A(r0, true);
    L5:
        super.onAnimationStop(r3);
    }

    public final void onAnimationFrame(AnimatedDrawable2 r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "drawable");
        ALogger.d("LikeEggView", "on frame count " + r4);
        if (r4 < (r3.getFrameCount() - 1)) goto L11;
        HSImageView r5 = this.a.a.this$0.c;
        if (r5 == null) goto L7;
        r5.setHierarchy(new GenericDraweeHierarchyBuilder(this.a.a.$context.getResources()).setFadeDuration(0).build());
    L7:
        LikeEggView r6 = this.a.a.this$0;
        HSImageView r7 = r6.c;
        if (r7 == null) goto L12;
        r7.setController(LikeEggView.a(r6));
        return;
    L12:
        return;
    }
}
