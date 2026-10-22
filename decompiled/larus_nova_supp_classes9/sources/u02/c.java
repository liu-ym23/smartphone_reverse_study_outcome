package u02;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.platform.business.pkProp.PKBattlePropEffectWidget;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements p0 {
    public final /* synthetic */ PKBattlePropEffectWidget a;
    public final /* synthetic */ View b;

    public c(PKBattlePropEffectWidget r1, View r2) {
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

    public final void c(k r18, int r19, int r20, boolean r21) {
        PKBattlePropEffectWidget r1 = this.a;
        View r2 = this.b;
        if (r2 != null) goto L5;
        r1.getClass();
        return;
    L5:
        HSImageView r3 = r1.h;
        if (r3 == null) goto L39;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if (r4 == null) goto L36;
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        int[] r6 = {0, 0};
        r2.getLocationOnScreen(r6);
        r5.leftMargin = r6[0];
        r5.topMargin = r6[1] - s1.A();
        HSImageView r7 = r1.h;
        if (r7 == null) goto L13;
        r7.setLayoutParams(r5);
    L13:
        HSImageView r8 = r1.h;
        if (r8 == null) goto L16;
        r8.setVisibility(0);
    L16:
        HSImageView r9 = r1.h;
        if (r9 == null) goto L19;
        r9.setTranslationX(0.0f);
    L19:
        HSImageView r10 = r1.h;
        if (r10 == null) goto L22;
        r10.setTranslationY(0.0f);
    L22:
        HSImageView r11 = r1.h;
        if (r11 == null) goto L25;
        r11.setAlpha(1.0f);
    L25:
        HSImageView r13 = r1.h;
        if (r13 == null) goto L28;
        r13.setScaleX(1.0f);
    L28:
        HSImageView r14 = r1.h;
        if (r14 == null) goto L31;
        r14.setScaleY(1.0f);
    L31:
        HSImageView r15 = r1.h;
        Intrinsics.checkNotNull(r15);
        Intrinsics.checkNotNullParameter(r15, "flyIcon");
        Intrinsics.checkNotNullParameter(r2, "leftCount");
        AnimatorSet r16 = new AnimatorSet();
        ObjectAnimator r17 = ObjectAnimator.ofFloat(r15, "translationX", new float[]{80.0f, 0.0f});
        ObjectAnimator r23 = ObjectAnimator.ofFloat(r15, "translationY", new float[]{62.0f, 0.0f});
        r17.setDuration(500);
        r23.setDuration(500);
        ObjectAnimator r110 = ObjectAnimator.ofFloat(r15, "scaleX", new float[]{1.2f, 0.3f});
        ObjectAnimator r111 = ObjectAnimator.ofFloat(r15, "scaleY", new float[]{1.2f, 0.3f});
        r110.setDuration(500);
        r111.setDuration(500);
        ObjectAnimator.ofFloat(r15, "alpha", new float[]{0.0f, 1.0f}).setDuration(150);
        ObjectAnimator r24 = ObjectAnimator.ofFloat(r15, "alpha", new float[]{1.0f, 0.0f});
        r24.setDuration(150);
        r24.setStartDelay(350);
        ObjectAnimator r25 = ObjectAnimator.ofFloat(r2, "scaleX", new float[]{1.0f, 0.5f});
        ObjectAnimator r26 = ObjectAnimator.ofFloat(r2, "scaleY", new float[]{1.0f, 0.5f});
        r25.setDuration(500);
        r26.setDuration(500);
        r25.setStartDelay(350);
        r26.setStartDelay(350);
        ObjectAnimator r27 = ObjectAnimator.ofFloat(r2, "scaleX", new float[]{0.5f, 1.05f});
        ObjectAnimator r112 = ObjectAnimator.ofFloat(r2, "scaleY", new float[]{0.5f, 1.05f});
        r27.setDuration(250);
        r112.setDuration(250);
        r27.setStartDelay(500);
        r112.setStartDelay(500);
        ObjectAnimator r0 = ObjectAnimator.ofFloat(r2, "scaleX", new float[]{1.05f, 0.98f});
        ObjectAnimator r28 = ObjectAnimator.ofFloat(r2, "scaleY", new float[]{1.05f, 0.98f});
        r0.setDuration(250);
        r28.setDuration(250);
        r0.setStartDelay(750);
        r28.setStartDelay(750);
        ObjectAnimator r29 = ObjectAnimator.ofFloat(r2, "scaleX", new float[]{0.98f, 1.0f});
        ObjectAnimator r113 = ObjectAnimator.ofFloat(r2, "scaleY", new float[]{0.98f, 1.0f});
        r29.setDuration(250);
        r113.setDuration(250);
        r29.setStartDelay(1000);
        r113.setStartDelay(1000);
        ObjectAnimator r30 = ObjectAnimator.ofFloat(r2, "alpha", new float[]{0.0f, 1.0f});
        r30.setDuration(150);
        r30.setStartDelay(350);
        r16.playTogether(new Animator[]{r17, r23, r110, r111, r25, r26, r27, r112, r0, r28, r113, r29, r30});
        r1.i = r16;
        r16.addListener(r1.l);
        AnimatorSet r31 = r1.i;
        if (r31 == null) goto L38;
        r31.start();
        return;
    L38:
        return;
    L36:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
}
