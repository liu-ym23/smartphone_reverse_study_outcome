package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ BottomSelfDiggOptimizeView.c a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;

    public d(BottomSelfDiggOptimizeView.c r1, long r2, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r19) {
        Intrinsics.checkNotNullParameter(r19, "it");
        BottomSelfDiggOptimizeView.c r2 = this.a;
        ImageView r3 = r2.e;
        if (r3 != null) goto L5;
        return;
    L5:
        ImageView r4 = r2.d;
        if (r4 != null) goto L8;
        return;
    L8:
        long r5 = r19.getCurrentPlayTime();
        Object r8 = null;
        if (0 <= r5) goto L12;
    L21:
        long r6 = r19.getCurrentPlayTime();
        if (100 <= r6) goto L25;
    L34:
        long r7 = this.b;
        BottomSelfDiggOptimizeView r9 = this.a.g;
        int r10 = BottomSelfDiggOptimizeView.h;
        r9.getClass();
        long r11 = 50;
        long r13 = r7 + r11;
        long r14 = this.b;
        long r15 = r19.getCurrentPlayTime();
        if (r14 <= r15) goto L38;
    L47:
        long r16 = this.b;
        long r17 = r19.getCurrentPlayTime();
        if (r16 <= r17) goto L51;
    L60:
        long r18 = this.b;
        this.a.g.getClass();
        long r20 = r18 + ((long) 200);
        long r21 = this.b;
        long r110 = r19.getCurrentPlayTime();
        if (r21 <= r110) goto L64;
    L73:
        long r23 = this.b;
        this.a.g.getClass();
        long r24 = r23 + r11;
        long r25 = this.b;
        this.a.g.getClass();
        long r26 = r25 + ((long) 100);
        long r27 = r19.getCurrentPlayTime();
        if (r24 <= r27) goto L77;
    L86:
        long r28 = this.c;
        long r29 = r19.getCurrentPlayTime();
        if (r28 <= r29) goto L90;
    L100:
        Object r1 = r19.getAnimatedValue();
        if (r1 == null) goto L105;
        PointF r30 = (PointF) r1;
        r4.setTranslationX(r30.x - (this.a.f.a * 0.5f));
        r4.setTranslationY(r30.y - (this.a.f.b * 0.5f));
        r4.setScaleX(this.a.a);
        r4.setScaleY(this.a.a);
        r3.setTranslationX(r30.x - (this.a.f.a * 0.5f));
        r3.setTranslationY(r30.y - (this.a.f.b * 0.5f));
        r3.setScaleX(this.a.b);
        r3.setScaleY(this.a.b);
        return;
    L105:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.PointF");
    L90:
        if (1000 < r29) goto L100;
        Object r31 = r19.getAnimatedValue("iconAlpha2");
        if ((r31 instanceof Integer) == false) goto L95;
        r8 = r31;
    L95:
        Integer r33 = (Integer) r8;
        if (r33 == null) goto L98;
        int r34 = r33.intValue();
    L99:
        r3.setAlpha(r34 / 255.0f);
        goto L100
    L98:
        r34 = (int) (r3.getAlpha() * 255);
        goto L99
    L77:
        if (r26 < r27) goto L86;
        Object r35 = r19.getAnimatedValue("iconAlpha");
        if ((r35 instanceof Integer) == true) goto L81;
        r35 = null;
    L81:
        Integer r36 = (Integer) r35;
        if (r36 == null) goto L84;
        int r37 = r36.intValue();
    L85:
        r3.setAlpha(r37 / 255.0f);
        goto L86
    L84:
        r37 = (int) (r3.getAlpha() * 255);
        goto L85
    L64:
        if (r20 < r110) goto L73;
        BottomSelfDiggOptimizeView.c r38 = this.a;
        Object r39 = r19.getAnimatedValue("iconScale");
        if ((r39 instanceof Float) == true) goto L68;
        r39 = null;
    L68:
        Float r40 = (Float) r39;
        if (r40 == null) goto L71;
        float r41 = r40.floatValue();
    L72:
        r38.b = r41;
        goto L73
    L71:
        r41 = this.a.b;
        goto L72
    L51:
        if (1000 < r17) goto L60;
        Object r43 = r19.getAnimatedValue("selfAlpha");
        if ((r43 instanceof Integer) == true) goto L55;
        r43 = null;
    L55:
        Integer r44 = (Integer) r43;
        if (r44 == null) goto L58;
        int r45 = r44.intValue();
    L59:
        r4.setAlpha(r45 / 255.0f);
        goto L60
    L58:
        r45 = (int) (r4.getAlpha() * 255);
        goto L59
    L38:
        if (r13 < r15) goto L47;
        BottomSelfDiggOptimizeView.c r46 = this.a;
        Object r47 = r19.getAnimatedValue("selfScale");
        if ((r47 instanceof Float) == true) goto L42;
        r47 = null;
    L42:
        Float r48 = (Float) r47;
        if (r48 == null) goto L45;
        float r49 = r48.floatValue();
    L46:
        r46.a = r49;
        goto L47
    L45:
        r49 = this.a.a;
        goto L46
    L25:
        if (150 < r6) goto L34;
        BottomSelfDiggOptimizeView.c r50 = this.a;
        Object r51 = r19.getAnimatedValue("self2");
        if ((r51 instanceof Float) == true) goto L29;
        r51 = null;
    L29:
        Float r53 = (Float) r51;
        if (r53 == null) goto L32;
        float r54 = r53.floatValue();
    L33:
        r50.a = r54;
        goto L34
    L32:
        r54 = this.a.a;
        goto L33
    L12:
        if (100 < r5) goto L21;
        BottomSelfDiggOptimizeView.c r55 = this.a;
        Object r56 = r19.getAnimatedValue("self1");
        if ((r56 instanceof Float) == true) goto L16;
        r56 = null;
    L16:
        Float r57 = (Float) r56;
        if (r57 == null) goto L19;
        float r58 = r57.floatValue();
    L20:
        r55.a = r58;
        goto L21
    L19:
        r58 = this.a.a;
        goto L20
    }
}
