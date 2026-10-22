package com.bytedance.android.live.liveinteract.animation;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d0 extends BaseAnimationListener {
    public final /* synthetic */ e0 a;

    public d0(e0 r1) {
        this.a = r1;
    }

    public final void onAnimationStop(AnimatedDrawable2 r2) {
        ALogger.i("interact_emoji", "receiver animation stop");
        HSImageView r3 = this.a.a.i;
        if (r3 == null) goto L6;
        UtilityKotlinExtentionsKt.t(r3);
        return;
    }

    public final void onAnimationFrame(AnimatedDrawable2 r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        if (r3 < (r2.getFrameCount() - 1)) goto L6;
        r2.stop();
        return;
    }
}
