package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.graphics.drawable.Animatable;
import android.view.View;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v5 extends BaseControllerListener<Object> {
    public final /* synthetic */ t5 a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ Function0 c;

    public static final class a extends BaseAnimationListener {
        public final /* synthetic */ v5 a;

        public final void onAnimationFrame(AnimatedDrawable2 r1, int r2) {
        }

        public a(v5 r1) {
            this.a = r1;
        }

        public final void onAnimationStart(AnimatedDrawable2 r1) {
            this.a.b.invoke();
        }

        public final void onAnimationStop(AnimatedDrawable2 r1) {
            this.a.c.invoke();
        }
    }

    public v5(ToolbarVrModeBehavior r1, Function0 r2, Function0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        t5 r4 = this.a;
        r4.e = true;
        if (r4.f == false) goto L8;
        View r5 = r4.b;
        if (r5 == null) goto L8;
        r5.setVisibility(8);
    L8:
        if ((r3 instanceof AnimatedDrawable2) == false) goto L11;
        ((AnimatedDrawable2) r3).setAnimationListener(new a(this));
        return;
    }
}
