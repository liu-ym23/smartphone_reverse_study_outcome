package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import com.google.android.material.internal.ExpandCollapseAnimationHelper;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.obric.oui.texteffects.ODimPointEffectTextView;
import com.obric.oui.texteffects.ODimPointGenerateEffectView;
import com.obric.oui.texteffects.OProtocolTextEffectTextView;
import com.obric.oui.texteffects.runtime.c;
import com.obric.oui.texteffects.runtime.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import js.s;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8517c;

    public /* synthetic */ b(int r5, Object r10, Object r11) {
        this.f8515a = r5;
        this.f8516b = r10;
        this.f8517c = r11;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r11) {
        Object r5 = this.f8517c;
        Object r10 = this.f8516b;
        switch(this.f8515a) {
            case 0: goto L78;
            case 1: goto L76;
            case 2: goto L8;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        LinkedHashSet r12 = (LinkedHashSet) r10;
        Intrinsics.checkNotNullParameter(r12, "$progressSet");
        jq.b r13 = (jq.b) r5;
        Intrinsics.checkNotNullParameter(r13, "this$0");
        Object r14 = r11.getAnimatedValue();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlin.Float");
        Float r15 = (Float) r14;
        float r16 = r15.floatValue();
        r12.add(r15);
        r13.f18420a.setAlpha(r16 * 0.2f);
        return;
    L6:
        int r17 = OProtocolTextEffectTextView.f14713q;
        ODimPointEffectTextView r18 = (ODimPointEffectTextView) r10;
        Intrinsics.checkNotNullParameter(r18, "this$0");
        s r19 = (s) r5;
        Intrinsics.checkNotNullParameter(r19, "$spec");
        Intrinsics.checkNotNullParameter(r11, "valueAnimator");
        r18.e = (long) (r11.getAnimatedFraction() * r19.f18480c);
        r18.getLogTag();
        Intrinsics.checkNotNullParameter(r18.f14721l, "effectName");
        Intrinsics.checkNotNullParameter(r19, "spec");
        r18.w();
        r18.invalidate();
        return;
    L8:
        int r110 = ODimPointGenerateEffectView.f14707j;
        s r20 = (s) r10;
        Intrinsics.checkNotNullParameter(r20, "$spec");
        ODimPointGenerateEffectView r21 = (ODimPointGenerateEffectView) r5;
        Intrinsics.checkNotNullParameter(r21, "this$0");
        Intrinsics.checkNotNullParameter(r11, "animator");
        long r111 = (long) (r11.getAnimatedFraction() * r20.f18480c);
        r21.getClass();
        c r112 = e.d(r20, r111);
        ArrayList r113 = r21.d;
        int r22 = r21.getWidth();
        Integer r23 = Integer.valueOf(r22);
        if (r22 > 0) goto L13;
        r23 = null;
    L13:
        if (r23 != null) goto L32;
        int r24 = r21.getMeasuredWidth();
        Integer r25 = Integer.valueOf(r24);
        if (r24 > 0) goto L18;
        r25 = null;
    L18:
        if (r25 != null) goto L31;
        ODimPointEffectTextView r26 = r21.f14708a;
        int r27 = r26.getWidth();
        r25 = Integer.valueOf(r27);
        if (r27 > 0) goto L23;
        r25 = null;
    L23:
        if (r25 != null) goto L31;
        int r28 = r26.getMeasuredWidth();
        Integer r29 = Integer.valueOf(r28);
        if (r28 > 0) goto L28;
        r29 = null;
    L28:
        if (r29 != null) goto L30;
        int r30 = 0;
    L33:
        float r31 = r30;
        Intrinsics.checkNotNullParameter(r112, "frame");
        Intrinsics.checkNotNullParameter(r113, "bindings");
        Iterator r32 = r113.iterator();
    L35:
        if (r32.hasNext() == false) goto L37;
        com.obric.oui.texteffects.runtime.a r33 = (com.obric.oui.texteffects.runtime.a) r32.next();
        int r34 = r33.d;
        View r35 = r33.f14739b;
        r35.setVisibility(r34);
        r35.setTranslationX(-r35.getMeasuredWidth());
        goto L35
    L37:
        Iterator r114 = r112.f14753c.iterator();
    L39:
        if (r114.hasNext() == false) goto L75;
        com.obric.oui.texteffects.runtime.b r36 = (com.obric.oui.texteffects.runtime.b) r114.next();
        String r37 = r36.f14743c;
        if (r37 == null) goto L39;
        Iterator r38 = r113.iterator();
    L45:
        if (r38.hasNext() == false) goto L49;
        Object r39 = r38.next();
        if (Intrinsics.areEqual(((com.obric.oui.texteffects.runtime.a) r39).f14738a, r37) == false) goto L45;
    L50:
        com.obric.oui.texteffects.runtime.a r40 = (com.obric.oui.texteffects.runtime.a) r39;
        if (r40 == null) goto L39;
        Intrinsics.checkNotNullParameter(r36, "frame");
        f8.b r41 = r36.f14748l;
        View r42 = r40.f14739b;
        if (r41 == null) goto L57;
        r42.setTranslationX(r40.a(r41, r31));
    L57:
        f8.b r43 = r36.f14749m;
        if (r43 == null) goto L61;
        r42.setTranslationY(r40.a(r43, r31));
    L61:
        float r44 = r36.e;
        if (Float.isNaN(r44) == true) goto L64;
        r42.setAlpha(RangesKt.coerceIn(r44, 0.0f, 1.0f));
    L64:
        float r45 = r36.f14746j;
        if (Float.isNaN(r45) == false) goto L67;
        Float r46 = null;
    L68:
        if (r46 != null) goto L71;
    L69:
        int r47 = 0;
    L74:
        r42.setVisibility(r47);
        goto L39
    L71:
        if (r46.floatValue() > 0.001f) goto L69;
        r47 = r40.d;
        goto L74
    L67:
        r46 = Float.valueOf(r45);
        goto L68
    L49:
        r39 = null;
        goto L50
    L75:
        return;
    L30:
        r30 = r29.intValue();
    L31:
        r30 = r25.intValue();
        goto L33
    L32:
        r30 = r23.intValue();
        goto L33
    L76:
        ExpandCollapseAnimationHelper.a((ExpandCollapseAnimationHelper) r10, (Rect) r5, r11);
        return;
    L78:
        AppBarLayout.a((AppBarLayout) r10, (MaterialShapeDrawable) r5, r11);
    }
}
