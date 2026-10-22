package com.obric.flow.cardlistpage.ui.component.overlayanimator;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import com.obric.flow.cardlistpage.ui.CardFeedLayout;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements kotlinx.coroutines.flow.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f11677b;

    public /* synthetic */ l(p r5, int r10) {
        this.f11676a = r10;
        this.f11677b = r5;
    }

    @Override // kotlinx.coroutines.flow.h
    public final Object emit(Object r17, Continuation r18) {
        final p r5 = this.f11677b;
        boolean r10 = true;
        switch(this.f11676a) {
            case 0: goto L13;
            default: goto L4;
        };
    L4:
        boolean r11 = ((Boolean) r17).booleanValue();
        CardFeedLayout r12 = (CardFeedLayout) r5.e.get();
        if (r12 == null) goto L12;
        if (r11 == false) goto L9;
        int r13 = 0;
    L10:
        r12.setVisibility(r13);
        goto L12
    L9:
        r13 = 8;
    L12:
        return Unit.INSTANCE;
    L13:
        i0 r14 = (i0) ((Pair) r17).component2();
        ControllerState r15 = r5.f11694n;
        ControllerState r16 = r14.e;
        if (r15 == r16) goto L29;
        r5.f11694n = r16;
        Function1 r19 = r5.f;
        if (r19 == null) goto L18;
        r19.invoke(r16);
    L18:
        int r20 = k.f11674a[r14.e.ordinal()];
        if (r20 == 1) goto L26;
        if (r20 == 2) goto L23;
        if (r20 != 3) goto L29;
    L23:
        Function1 r21 = r5.g;
        if (r21 == null) goto L29;
        r21.invoke(q.f11702a);
        goto L29
    L26:
        Function1 r22 = r5.g;
        if (r22 == null) goto L29;
        r22.invoke(r.f11703a);
    L29:
        int r23 = k.f11675b[r14.f.ordinal()];
        final boolean r24 = r14.d;
        float r25 = r14.f11668c;
        float r110 = r14.f11666a;
        if (r23 == 1) goto L68;
        if (r23 == 2) goto L65;
        if (r23 != 3) goto L72;
        Function0 r26 = r5.f11701v;
        r5.f11701v = null;
        float r27 = r5.f11690j;
        CardFeedLayout r28 = (CardFeedLayout) r5.e.get();
        if (r28 == null) goto L37;
        float r29 = r28.getAlpha();
    L39:
        if (r27 != r110) goto L41;
        boolean r111 = true;
    L43:
        if (r29 != r25) goto L45;
        boolean r112 = true;
    L46:
        if (r111 == false) goto L55;
        if (r112 == false) goto L55;
        r5.l(r110, r25, r24);
        if (r110 > 0.0f) goto L52;
        r10 = false;
    L52:
        b0 r30 = new b0(r10);
        Intrinsics.checkNotNullParameter(r30, "intent");
        r5.d(r30);
        if (r26 == null) goto L72;
        r26.invoke();
    L55:
        r5.n();
        ArrayList r113 = new ArrayList();
        if (r111 == true) goto L62;
        float r114 = Math.abs(r110 - r27);
        if (r110 <= r27) goto L60;
        long r31 = RangesKt.coerceAtLeast((long) (350 * r114), 260);
    L61:
        ValueAnimator r32 = ValueAnimator.ofFloat(new float[]{r27, r110});
        r32.setDuration(r31);
        r32.setInterpolator(p.f11687w);
        r32.addUpdateListener(new j(r5, r24));
        Intrinsics.checkNotNull(r32);
        r32.addListener(new n(r5, r110, r25, r24));
        r113.add(r32);
        goto L62
    L60:
        r31 = RangesKt.coerceAtLeast((long) (400 * r114), 250);
    L62:
        if (r112 == true) goto L64;
        ValueAnimator r33 = ValueAnimator.ofFloat(new float[]{r29, r25});
        r33.setDuration(10);
        r33.setInterpolator(r5.f11689i);
        r33.addUpdateListener(new com.google.android.material.motion.b(r5, 2));
        Intrinsics.checkNotNull(r33);
        r33.addListener(new jq.a(r5, r14.f11667b, 2));
        r113.add(r33);
    L64:
        Ref.BooleanRef r34 = new Ref.BooleanRef();
        AnimatorSet r35 = new AnimatorSet();
        r35.playTogether(r113);
        r35.addListener(new m(r34, r5, r110, r26));
        r35.start();
        r5.f11691k = r35;
        goto L72
    L45:
        r112 = false;
        goto L46
    L41:
        r111 = false;
        goto L43
    L37:
        r29 = 1.0f;
    L72:
        return Unit.INSTANCE;
    L65:
        r5.n();
        r5.l(r110, r25, r24);
        Function0 r36 = r5.f11701v;
        r5.f11701v = null;
        if (r36 == null) goto L72;
        r36.invoke();
        goto L72
    L68:
        r5.n();
        r5.l(r110, r25, r24);
        Function0 r37 = r5.f11701v;
        r5.f11701v = null;
        if (r37 == null) goto L72;
        r37.invoke();
        goto L72
    }
}
