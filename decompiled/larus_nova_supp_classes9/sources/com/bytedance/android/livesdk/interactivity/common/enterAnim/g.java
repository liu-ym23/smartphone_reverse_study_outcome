package com.bytedance.android.livesdk.interactivity.common.enterAnim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextPaint;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.message.h3;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v2;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.z;
import com.bytedance.android.livesdk.message.model.pg;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements a3.b {
    public final /* synthetic */ WindScreenRebirthAnimTrayView a;
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.enteranim.utils.i b;

    public final void onFail() {
        ((z) this.b).a();
    }

    public final void a(NinePatchDrawable r17) {
        Intrinsics.checkNotNullParameter(r17, "ninePatchDrawable");
        final WindScreenRebirthAnimTrayView r1 = this.a;
        r1.c.measure(0, 0);
        float r2 = r1.c.getMeasuredWidth();
        TextPaint r4 = r1.f.getPaint();
        if (r4 == null) goto L5;
        int r5 = (int) r4.measureText(r1.f.getText().toString());
    L6:
        float r6 = ((r5 + r2) + s1.f(4.0f)) + s1.f(4.0f);
        a1.p(r1.b, (int) r6);
        ObjectAnimator r7 = ObjectAnimator.ofFloat(r1.c, ViewGroup.ALPHA, new float[]{0.0f, 1.0f});
        r7.setDuration(500);
        r7.setInterpolator(new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f));
        r7.addListener(new h(r1));
        ObjectAnimator r8 = ObjectAnimator.ofFloat(r1.d, ViewGroup.ROTATION_X, new float[]{0.0f, 180.0f, 260.0f});
        r8.setDuration(600);
        r8.setStartDelay(500);
        r8.setInterpolator(new PathInterpolator(0.26f, 0.0f, 0.6f, 0.2f));
        ObjectAnimator r9 = ObjectAnimator.ofFloat(r1.e, ViewGroup.ROTATION_X, new float[]{-80.0f, 0.0f});
        r9.setDuration(350);
        r9.setStartDelay(1100);
        r9.setInterpolator(new PathInterpolator(0.26f, 0.0f, 0.6f, 0.2f));
        r9.addListener(new i(r1));
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{r2, r6});
        r10.setDuration(600);
        r10.setStartDelay(1450);
        r10.setInterpolator(new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f));
        r10.addUpdateListener(new j(r1));
        ObjectAnimator r11 = ObjectAnimator.ofFloat(r1.f, ViewGroup.ALPHA, new float[]{0.0f, 1.0f});
        r11.setDuration(300);
        r11.setStartDelay(1700);
        r11.setInterpolator(new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f));
        r11.addListener(new k(r1));
        ObjectAnimator r13 = ObjectAnimator.ofFloat(r1.c, ViewGroup.ALPHA, new float[]{1.0f, 0.0f});
        r13.setDuration(500);
        r13.setStartDelay(3000);
        r13.setInterpolator(new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f));
        AnimatorSet r14 = new AnimatorSet();
        r14.playTogether(new Animator[]{r7, r8, r9, r10, r11, r13});
        Unit r15 = Unit.INSTANCE;
        r1.h = r14;
        r14.addListener(new l(r1));
        h3 r16 = r1.i;
        if (r16 == null) goto L15;
        pg.a r18 = r16.getBackground();
        if (r18 == null) goto L15;
        ImageModel r19 = r18.c();
        if (r19 == null) goto L15;
        if ((!r19.getUrls().isEmpty()) == false) goto L15;
        r1.g.setRadius(WindScreenRebirthAnimTrayView.l);
        r1.g.setController(Fresco.newDraweeControllerBuilder().setUri((String) ListProtector.get(r19.getUrls(), 0)).setControllerListener(v2.a(WindScreenRebirthAnimTrayView$playAnimationInternal$7$1.INSTANCE, new WindScreenRebirthAnimTrayView$playAnimationInternal$$inlined$let$lambda$1(r1), WindScreenRebirthAnimTrayView$playAnimationInternal$7$3.INSTANCE)).setAutoPlayAnimations(true).build());
    L15:
        AnimatorSet r3 = r1.h;
        if (r3 == null) goto L19;
        r3.start();
        return;
    L19:
        return;
    L5:
        r5 = 0;
        goto L6
    }

    public g(WindScreenRebirthAnimTrayView r1, z r2) {
        this.a = r1;
        this.b = r2;
    }
}
