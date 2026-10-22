package com.bytedance.android.livesdk.gift.platform.business.toolbar;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j extends BaseControllerListener<Object> {
    public final /* synthetic */ Function0 a;

    public static final class a extends BaseAnimationListener {
        public int a;
        public final /* synthetic */ Animatable b;

        public final void onAnimationStart(AnimatedDrawable2 r1) {
        }

        public final void onAnimationStop(AnimatedDrawable2 r1) {
        }

        public a(Animatable r1) {
            this.b = r1;
            this.a = -1;
        }

        public final void onAnimationFrame(AnimatedDrawable2 r1, int r2) {
            if (r2 >= this.a) goto L7;
            Animatable r3 = this.b;
            if (r3 == null) goto L7;
            r3.stop();
        L7:
            this.a = r2;
        }
    }

    public j(Function0 r1) {
        this.a = r1;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        if (r3 == null) goto L4;
        r3.start();
    L4:
        this.a.invoke();
        if ((r3 instanceof AnimatedDrawable2) == false) goto L8;
        ((AnimatedDrawable2) r3).setAnimationListener(new a(r3));
        return;
    }
}
