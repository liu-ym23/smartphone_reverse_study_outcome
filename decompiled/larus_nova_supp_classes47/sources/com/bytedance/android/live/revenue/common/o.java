package com.bytedance.android.live.revenue.common;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o {
    public static final void a(HSImageView r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$cancelAnimation");
        if (r3.getController() == null) goto L14;
        DraweeController r0 = r3.getController();
        if (r0 == null) goto L7;
        Animatable r1 = r0.getAnimatable();
    L9:
        if ((r1 instanceof AnimatedDrawable2) == true) goto L11;
        r1 = null;
    L11:
        AnimatedDrawable2 r2 = (AnimatedDrawable2) r1;
        if (r2 == null) goto L14;
        r2.setAnimationListener(null);
        r2.stop();
        goto L14
    L7:
        r1 = null;
    L14:
        r3.setController(null);
    }
}
