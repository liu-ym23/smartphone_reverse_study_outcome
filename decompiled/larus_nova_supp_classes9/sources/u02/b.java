package u02;

import android.graphics.drawable.Animatable;
import com.bytedance.android.livesdk.gift.platform.business.pkProp.PKBattlePropEffectWidget;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ PKBattlePropEffectWidget a;

    public b(PKBattlePropEffectWidget r1) {
        this.a = r1;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        ImageInfo r4 = (ImageInfo) r2;
        if ((r3 instanceof AnimatedDrawable2) == true) goto L5;
        r3 = null;
    L5:
        AnimatedDrawable2 r5 = (AnimatedDrawable2) r3;
        if (r5 == null) goto L17;
        this.a.d = r5;
        r5.setLoopCount(1);
        AnimatedDrawable2 r6 = this.a.d;
        if (r6 == null) goto L10;
        r6.start();
    L10:
        AnimatedDrawable2 r7 = this.a.d;
        if (r7 == null) goto L13;
        com.bytedance.android.live.core.utils.fresco.c.b(r7);
    L13:
        PKBattlePropEffectWidget r8 = this.a;
        AnimatedDrawable2 r9 = r8.d;
        if (r9 == null) goto L18;
        r9.setAnimationListener(r8.k);
        return;
    L18:
        return;
    }
}
