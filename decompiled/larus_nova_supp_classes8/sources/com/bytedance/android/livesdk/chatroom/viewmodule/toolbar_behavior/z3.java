package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z3 extends BaseControllerListener<Object> {
    public final /* synthetic */ ToolbarMultiCameraBehavior a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ Function0 c;

    public static final class a extends BaseAnimationListener {
        public final /* synthetic */ z3 a;

        public final void onAnimationFrame(AnimatedDrawable2 r1, int r2) {
        }

        public a(z3 r1) {
            this.a = r1;
        }

        public final void onAnimationStart(AnimatedDrawable2 r1) {
            this.a.b.invoke();
        }

        public final void onAnimationStop(AnimatedDrawable2 r1) {
            this.a.c.invoke();
        }
    }

    public z3(ToolbarMultiCameraBehavior r1, Function0 r2, Function0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        ToolbarMultiCameraBehavior r4 = this.a;
        r4.h = true;
        if (r4.i == false) goto L8;
        HSImageView r5 = r4.c;
        if (r5 == null) goto L8;
        r5.setVisibility(8);
    L8:
        if ((r3 instanceof AnimatedDrawable2) == false) goto L11;
        ((AnimatedDrawable2) r3).setAnimationListener(new a(this));
        return;
    }
}
