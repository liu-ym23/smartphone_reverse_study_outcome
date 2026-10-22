package com.bytedance.android.live.core.utils;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u2 extends BaseControllerListener<Object> {
    public final /* synthetic */ Ref.ObjectRef a;
    public final /* synthetic */ HSImageView b;
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ Function0 d;
    public final /* synthetic */ Function0 e;
    public final /* synthetic */ Function1 f;

    public static final class a extends BaseAnimationListener {
        public int a;
        public final /* synthetic */ u2 b;
        public final /* synthetic */ Animatable c;

        public final void onAnimationStart(AnimatedDrawable2 r3) {
            u2 r4 = this.b;
            Ref.ObjectRef r0 = r4.a;
            r0.element = AnimationStatus.START;
            r4.d.invoke();
        }

        public final void onAnimationStop(AnimatedDrawable2 r3) {
            u2 r4 = this.b;
            Ref.ObjectRef r0 = r4.a;
            r0.element = AnimationStatus.END;
            HSImageView r5 = r4.b;
            if (r5 == null) goto L5;
            r5.setController(null);
        L5:
            this.b.e.invoke();
        }

        public a(u2 r1, Animatable r2) {
            this.b = r1;
            this.c = r2;
            this.a = -1;
        }

        public final void onAnimationFrame(AnimatedDrawable2 r2, int r3) {
            Ref.ObjectRef r4 = this.b.a;
            r4.element = AnimationStatus.ANIMATION;
            if (r3 >= this.a) goto L5;
            this.c.stop();
        L5:
            Function1 r5 = this.b.f;
            if (r5 == null) goto L8;
            Unit r6 = (Unit) r5.invoke(Integer.valueOf(r3));
        L8:
            this.a = r3;
        }
    }

    public final void onFailure(String r1, Throwable r2) {
        Ref.ObjectRef r3 = this.a;
        r3.element = AnimationStatus.FAIL;
        HSImageView r4 = this.b;
        if (r4 == null) goto L5;
        r4.setController(null);
    L5:
        this.c.invoke();
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        if ((r3 instanceof AnimatedDrawable2) == false) goto L5;
        ((AnimatedDrawable2) r3).setAnimationListener(new a(this, r3));
    L5:
        if (r3 == null) goto L8;
        r3.start();
        return;
    }

    public u2(Ref.ObjectRef r1, HSImageView r2, Function0 r3, Function0 r4, Function0 r5, Function1 r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
