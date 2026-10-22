package u02;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.platform.business.pkProp.PKBattlePropEffectWidget;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements p0 {
    public final /* synthetic */ PKBattlePropEffectWidget a;
    public final /* synthetic */ Pair b;

    public d(PKBattlePropEffectWidget r1, Pair r2) {
        this.a = r1;
        this.b = r2;
    }

    public final /* synthetic */ void a(ImageInfo r1, Animatable r2) {
    }

    public final /* synthetic */ void b(k r1, Exception r2) {
    }

    public final /* synthetic */ void d(ImageInfo r1) {
    }

    public final /* synthetic */ void e(k r1) {
    }

    public final void c(k r17, int r18, int r19, boolean r20) {
        PKBattlePropEffectWidget r1 = this.a;
        Pair r2 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "targetLocation");
        HSImageView r3 = r1.h;
        if (r3 == null) goto L35;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if (r4 == null) goto L33;
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        r5.leftMargin = ((Number) r2.getFirst()).intValue();
        r5.topMargin = ((Number) r2.getSecond()).intValue() - s1.A();
        HSImageView r6 = r1.h;
        if (r6 == null) goto L10;
        r6.setLayoutParams(r5);
    L10:
        HSImageView r7 = r1.h;
        if (r7 == null) goto L13;
        r7.setVisibility(0);
    L13:
        HSImageView r8 = r1.h;
        if (r8 == null) goto L16;
        r8.setTranslationX(0.0f);
    L16:
        HSImageView r9 = r1.h;
        if (r9 == null) goto L19;
        r9.setTranslationY(0.0f);
    L19:
        HSImageView r10 = r1.h;
        if (r10 == null) goto L22;
        r10.setAlpha(1.0f);
    L22:
        HSImageView r11 = r1.h;
        if (r11 == null) goto L25;
        r11.setScaleX(1.0f);
    L25:
        HSImageView r13 = r1.h;
        if (r13 == null) goto L28;
        r13.setScaleY(1.0f);
    L28:
        HSImageView r14 = r1.h;
        Intrinsics.checkNotNull(r14);
        Intrinsics.checkNotNullParameter(r14, "animationView");
        AnimatorSet r15 = new AnimatorSet();
        ObjectAnimator r16 = ObjectAnimator.ofFloat(r14, "translationX", new float[]{-30.0f, 0.0f});
        ObjectAnimator r21 = ObjectAnimator.ofFloat(r14, "translationY", new float[]{35.0f, 0.0f});
        r16.setDuration(500);
        r21.setDuration(500);
        ObjectAnimator r110 = ObjectAnimator.ofFloat(r14, "scaleX", new float[]{1.2f, 0.9f});
        ObjectAnimator r111 = ObjectAnimator.ofFloat(r14, "scaleY", new float[]{1.2f, 0.9f});
        r110.setDuration(500);
        r111.setDuration(500);
        ObjectAnimator r112 = ObjectAnimator.ofFloat(r14, "scaleX", new float[]{0.9f, 1.04f});
        ObjectAnimator r113 = ObjectAnimator.ofFloat(r14, "scaleY", new float[]{0.9f, 1.04f});
        r112.setDuration(250);
        r113.setDuration(250);
        r112.setStartDelay(500);
        r113.setStartDelay(500);
        ObjectAnimator r23 = ObjectAnimator.ofFloat(r14, "scaleX", new float[]{1.04f, 1.0f});
        ObjectAnimator r24 = ObjectAnimator.ofFloat(r14, "scaleY", new float[]{1.04f, 1.0f});
        r23.setDuration(250);
        r24.setDuration(250);
        r23.setStartDelay(750);
        r24.setStartDelay(750);
        ObjectAnimator.ofFloat(r14, "alpha", new float[]{0.0f, 1.0f}).setDuration(150);
        r15.playTogether(new Animator[]{r16, r21, r110, r111, r112, r113, r23, r24});
        r1.i = r15;
        r15.addListener(r1.l);
        AnimatorSet r25 = r1.i;
        if (r25 == null) goto L34;
        r25.start();
        return;
    L34:
        return;
    L33:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
}
