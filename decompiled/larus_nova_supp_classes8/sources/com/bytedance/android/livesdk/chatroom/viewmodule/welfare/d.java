package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d extends BaseControllerListener<Object> {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ Function2 b;

    public static final class a extends BaseAnimationListener {
        public int a;
        public int b;
        public final /* synthetic */ d c;
        public final /* synthetic */ Animatable d;

        public final void onAnimationStart(AnimatedDrawable2 r1) {
        }

        public final void onAnimationStop(AnimatedDrawable2 r1) {
            this.c.a.invoke();
        }

        public a(d r1, Animatable r2) {
            this.c = r1;
            this.d = r2;
            this.a = -1;
            this.b = -1;
        }

        public final void onAnimationFrame(AnimatedDrawable2 r3, int r4) {
            int r0 = this.b;
            if (r0 >= 0) goto L8;
            if (r3 == null) goto L6;
            r0 = r3.getFrameCount();
        L6:
            this.b = r0;
        L8:
            if (this.b <= 0) goto L11;
            this.c.b.invoke(Integer.valueOf(r4), Integer.valueOf(this.b));
        L11:
            if (r4 >= this.a) goto L15;
            this.d.stop();
            if (this.b >= 0) goto L15;
            this.c.b.invoke(Integer.valueOf(r4), Integer.valueOf(r4));
        L15:
            this.a = r4;
        }
    }

    public d(Function0 r1, Function2 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        if (r3 == null) goto L5;
        r3.start();
    L5:
        if ((r3 instanceof AnimatedDrawable2) == false) goto L8;
        ((AnimatedDrawable2) r3).setAnimationListener(new a(this, r3));
        return;
    }
}
