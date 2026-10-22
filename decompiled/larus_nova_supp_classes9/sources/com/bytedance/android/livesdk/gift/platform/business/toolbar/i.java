package com.bytedance.android.livesdk.gift.platform.business.toolbar;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i extends BaseControllerListener<Object> {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ Function0 b;

    public static final class a extends BaseAnimationListener {
        public int a;
        public final /* synthetic */ i b;
        public final /* synthetic */ Animatable c;

        public final void onAnimationStart(AnimatedDrawable2 r2) {
            this.b.a.invoke(this.c);
        }

        public final void onAnimationStop(AnimatedDrawable2 r1) {
            this.b.b.invoke();
        }

        public a(i r1, Animatable r2) {
            this.b = r1;
            this.c = r2;
            this.a = -1;
        }

        public final void onAnimationFrame(AnimatedDrawable2 r1, int r2) {
            if (r2 >= this.a) goto L5;
            this.c.stop();
        L5:
            this.a = r2;
        }
    }

    public i(Function1 r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        if ((r3 instanceof AnimatedDrawable2) == false) goto L5;
        ((AnimatedDrawable2) r3).setAnimationListener(new a(this, r3));
    L5:
        if (r3 == null) goto L8;
        r3.start();
        return;
    }
}
