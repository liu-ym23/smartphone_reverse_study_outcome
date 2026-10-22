package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Animatable;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g extends BaseControllerListener<Object> {
    public final /* synthetic */ LinkSucAnimationView a;

    public static final class a extends BaseAnimationListener {
        public int a;
        public final /* synthetic */ g b;
        public final /* synthetic */ Animatable c;

        /* JADX WARN: Type inference failed for: r13v2, types: [android.widget.ImageView, com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.LinkSucAnimationView, java.lang.Object] */
        public final void onAnimationStop(AnimatedDrawable2 r13) {
            Intrinsics.checkNotNullParameter(r13, "drawable");
            ?? r14 = this.b.a;
            int r0 = LinkSucAnimationView.j;
            r14.getClass();
            ALogger.i("LinkSucAnimationView", "startMatchFinishAnimation, viewDetached=" + r14.h + ", guestAvatar=" + r14.a);
            if (r14.h == false) goto L5;
        L20:
            Function0<Unit> r1 = r14.g;
            if (r1 == null) goto L23;
            r1.invoke();
        L23:
            LinkSucAnimationView.a r15 = r14.f;
            if (r15 == null) goto L26;
            r15.h();
        L26:
            LinkSucAnimationView r16 = this.b.a;
            r16.getClass();
            ALogger.i("LinkSucAnimationView", "startGuestNameAnimation, guestName=" + r16.b);
            TextView r2 = r16.b;
            if (r2 == null) goto L31;
            Intrinsics.checkNotNull(r2);
            ObjectAnimator r3 = ObjectAnimator.ofFloat(r2, "alpha", new float[]{1.0f, 0.1f});
            TextView r4 = r16.b;
            Intrinsics.checkNotNull(r4);
            ObjectAnimator r5 = ObjectAnimator.ofFloat(r4, "translationY", new float[]{0.0f, 20.0f});
            AnimatorSet r6 = new AnimatorSet();
            r6.playTogether(new Animator[]{r3, r5});
            r6.setDuration(150);
            r6.start();
            r6.addListener(new e(r16));
            return;
        L31:
            return;
        L5:
            if (r14.a == null) goto L20;
            r14.setVisibility(8);
            ImageView r7 = r14.a;
            if (r7 == null) goto L10;
            r7.setVisibility(0);
        L10:
            py.k r8 = r14.e;
            if (r8 == null) goto L13;
            ImageUtil.loadRoundImage(r14.a, r8);
        L13:
            ImageView r9 = r14.a;
            if (r9 == null) goto L16;
            Intrinsics.checkNotNull(r9);
            r9.setPivotX(r9.getWidth() >> 1);
        L16:
            ImageView r10 = r14.a;
            if (r10 == null) goto L19;
            Intrinsics.checkNotNull(r10);
            r10.setPivotY(r10.getHeight() >> 1);
        L19:
            ImageView r11 = r14.a;
            Intrinsics.checkNotNull(r11);
            ObjectAnimator r12 = ObjectAnimator.ofFloat(r11, "scaleX", new float[]{0.0f, 0.36f, 0.72f, 1.1f, 1.05f, 1.0f});
            ImageView r17 = r14.a;
            Intrinsics.checkNotNull(r17);
            ObjectAnimator r18 = ObjectAnimator.ofFloat(r17, "scaleY", new float[]{0.0f, 0.36f, 0.72f, 1.1f, 1.05f, 1.0f});
            ImageView r19 = r14.a;
            Intrinsics.checkNotNull(r19);
            ObjectAnimator r20 = ObjectAnimator.ofFloat(r19, "alpha", new float[]{0.2f, 0.5f, 1.0f});
            AnimatorSet r21 = new AnimatorSet();
            r21.setDuration(500);
            r21.setInterpolator(new DecelerateInterpolator());
            r21.playTogether(new Animator[]{r12, r18, r20});
            r21.start();
            r21.addListener(new f(r14));
            goto L26
        }

        public a(g r1, Animatable r2) {
            this.b = r1;
            this.c = r2;
            this.a = -1;
        }

        public final void onAnimationFrame(AnimatedDrawable2 r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "drawable");
            if (r3 >= this.a) goto L5;
            this.c.stop();
        L5:
            this.a = r3;
        }
    }

    public g(LinkSucAnimationView r1) {
        this.a = r1;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        Intrinsics.checkNotNullParameter(r1, "id");
        if ((r3 instanceof AnimatedDrawable2) == false) goto L6;
        ((AnimatedDrawable2) r3).setAnimationListener(new a(this, r3));
        return;
    }
}
