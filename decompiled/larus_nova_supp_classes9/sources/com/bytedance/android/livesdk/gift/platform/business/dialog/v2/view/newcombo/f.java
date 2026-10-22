package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public HSImageView a;
    public final AnimatorSet b;
    public final String c;
    public final String d;
    public final PointF e;
    public final PointF f;
    public final ViewGroup g;
    public final Context h;

    public final void b(boolean r3) {
        if (r3 == false) goto L4;
        this.b.end();
        this.b.removeAllListeners();
    L5:
        Iterator<T> r4 = this.b.getChildAnimations().iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        Animator r0 = (Animator) r4.next();
        r0.removeAllListeners();
        r0.cancel();
        if ((r0 instanceof ValueAnimator) == false) goto L7;
        ((ValueAnimator) r0).removeAllUpdateListeners();
        goto L7
    L11:
        return;
    L4:
        this.b.removeAllListeners();
        this.b.end();
        goto L5
    }

    public final void a(final boolean r17, boolean r18) {
        ViewGroup.LayoutParams r2 = null;
        this.a = null;
        View r3 = new HSImageView(this.h);
        this.a = r3;
        this.g.addView(r3, 0);
        HSImageView r4 = this.a;
        if (r4 == null) goto L6;
        r2 = r4.getLayoutParams();
    L6:
        if (r2 == null) goto L8;
        r2.width = s1.f(17.0f);
    L8:
        if (r2 == null) goto L10;
        r2.height = s1.f(17.0f);
    L10:
        HSImageView r5 = this.a;
        if (r5 == null) goto L13;
        r5.setLayoutParams(r2);
    L13:
        HSImageView r6 = this.a;
        if (r6 == null) goto L16;
        UtilityKotlinExtentionsKt.w(r6);
    L16:
        Drawable r7 = s1.m(2131248736);
        HSImageView r8 = this.a;
        if (r8 == null) goto L19;
        r8.setBackground(r7);
    L19:
        HSImageView r9 = this.a;
        if (r9 == null) goto L24;
        Drawable r10 = r9.getBackground();
        if (r10 == null) goto L24;
        r10.setTint(ColorProtector.parseColor(this.c));
    L24:
        PointF r11 = this.f;
        PointF r13 = this.e;
        int[] r14 = new int[2];
        this.g.getLocationOnScreen(r14);
        if (r18 == false) goto L27;
    L29:
        float r15 = r13.x;
        float r16 = r14[0];
        r13.x = r15 - r16;
        float r19 = r13.y;
        float r20 = r14[1];
        r13.y = r19 - r20;
        r11.x -= r16;
        r11.y -= r20;
    L30:
        final HSImageView r21 = this.a;
        if (r21 == null) goto L33;
        UtilityKotlinExtentionsKt.w(r21);
    L33:
        if (r21 == null) goto L41;
        PointF r23 = this.e;
        PointF r24 = this.f;
        float r25 = r23.y - r24.y;
        ValueAnimator r26 = ValueAnimator.ofObject(new g(new PointF(r23.x, r24.y + (0.64f * r25)), new PointF(r24.x + ((r23.x - r24.x) * 0.6666667f), r24.y + (r25 * 0.26f))), new Object[]{r23, r24});
        r26.setDuration(950);
        r26.setInterpolator(PathInterpolatorCompat.create(0.26f, 1.0f, 0.48f, 1.0f));
        r26.addUpdateListener(new e(r21));
        ObjectAnimator r110 = ObjectAnimator.ofFloat(r21, "rotation", new float[]{0.0f, -25.0f});
        r110.setInterpolator(PathInterpolatorCompat.create(0.26f, 1.0f, 0.48f, 1.0f));
        r110.setDuration(950);
        ObjectAnimator r27 = ObjectAnimator.ofFloat(r21, "scaleX", new float[]{0.3f, 1.0f}).setDuration(200);
        ObjectAnimator r111 = ObjectAnimator.ofFloat(r21, "scaleY", new float[]{0.3f, 1.0f}).setDuration(200);
        ObjectAnimator r28 = ObjectAnimator.ofFloat(r21, "scaleX", new float[]{0.1f, 0.3f});
        r28.setDuration(300);
        r28.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f));
        r28.setStartDelay(650);
        ObjectAnimator r29 = ObjectAnimator.ofFloat(r21, "scaleY", new float[]{0.1f, 0.3f});
        r29.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f));
        r29.setDuration(300);
        r29.setStartDelay(650);
        List r30 = CollectionsKt.listOf(new ObjectAnimator[]{r27, r111, r28, r29});
        ObjectAnimator r31 = ObjectAnimator.ofFloat(r21, "alpha", new float[]{0.0f, 1.0f}).setDuration(200);
        ObjectAnimator r33 = ObjectAnimator.ofFloat(r21, "alpha", new float[]{1.0f, 0.0f}).setDuration(750);
        r33.setStartDelay(200);
        List r34 = CollectionsKt.listOf(new ObjectAnimator[]{r31, r33});
        ValueAnimator r35 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(ColorProtector.parseColor(this.c)), Integer.valueOf(ColorProtector.parseColor(this.d))});
        r35.addUpdateListener(new d(r21));
        ArrayList r36 = new ArrayList();
        r36.add(r26);
        r36.addAll(r30);
        r36.addAll(r34);
        if (this.e.x == this.f.x) goto L37;
        r36.add(r110);
    L37:
        if (r17 == false) goto L39;
        r36.add(r35);
    L39:
        this.b.playTogether(r36);
        c.c(this.b, new ArrowMoveAnimator$startAnimation$$inlined$let$lambda$1(this, r21, r17));
        this.b.start();
        return;
    L41:
        return;
    L27:
        if (com.bytedance.android.livesdk.gift.util.c.c() == false) goto L29;
        float r37 = nz1.a.q().c();
        float r38 = r13.x;
        float r112 = r14[0] / r37;
        r13.x = r38 - r112;
        float r39 = r13.y;
        float r40 = r14[1] / r37;
        r13.y = r39 - r40;
        r11.x -= r112;
        r11.y -= r40;
        goto L30
    }

    public /* synthetic */ f(PointF r7, PointF r8, ViewGroup r9, Context r10) {
        this(r7, r8, r9, r10, 0);
    }

    public f(PointF r2, PointF r3, ViewGroup r4, Context r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "startPoint");
        Intrinsics.checkNotNullParameter(r3, "endPoint");
        Intrinsics.checkNotNullParameter(r4, "viewContainer");
        Intrinsics.checkNotNullParameter(r5, "context");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.b = new AnimatorSet();
        if (r6 != 1) goto L5;
        String r7 = "#5677FF";
    L6:
        this.c = r7;
        if (r6 != 1) goto L9;
        String r8 = "#6AD2FF";
    L10:
        this.d = r8;
        return;
    L9:
        r8 = "#FFB665";
        goto L10
    L5:
        r7 = "#FF1F65";
        goto L6
    }
}
