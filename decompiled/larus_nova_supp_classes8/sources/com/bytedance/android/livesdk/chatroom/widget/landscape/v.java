package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v extends BaseAnimationListener {
    public final int a;
    public final /* synthetic */ NewLandscapeLockTetris.b b;
    public final /* synthetic */ Animatable c;

    public final void onAnimationStop(AnimatedDrawable2 r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable2");
    }

    public final void onAnimationStart(AnimatedDrawable2 r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable2");
        HSImageView r3 = this.b.a.o;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lockView");
    L5:
        UtilityKotlinExtentionsKt.w(r3);
    }

    public v(NewLandscapeLockTetris.b r1, Animatable r2) {
        this.b = r1;
        this.c = r2;
        this.a = ((AnimatedDrawable2) r2).getFrameCount() - 1;
    }

    public final void onAnimationFrame(AnimatedDrawable2 r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "drawable2");
        if (r3 < this.a) goto L6;
        this.c.stop();
        return;
    }
}
