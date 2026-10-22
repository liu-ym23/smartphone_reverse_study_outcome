package com.obric.oui.indicator;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f13476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DecelerateInterpolator f13477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final sg.a f13478c;
    public h d;
    public c e;
    public int f;
    public float g;

    public f(LinearLayout r5, DecelerateInterpolator r10, sg.a r11) {
        Intrinsics.checkNotNullParameter(r5, "trackView");
        Intrinsics.checkNotNullParameter(r10, "interpolator");
        Intrinsics.checkNotNullParameter(r11, "host");
        this.f13476a = r5;
        this.f13477b = r10;
        this.f13478c = r11;
    }

    public final void a(IndicatorAnimator$RenderReason r17, h r18) {
        Intrinsics.checkNotNullParameter(r17, "reason");
        Intrinsics.checkNotNullParameter(r18, "nextViewportState");
        if (this.e == null) goto L5;
        return;
    L5:
        h r10 = this.d;
        if (r10 != null) goto L8;
        IntRange r5 = null;
    L9:
        IntRange r11 = r18.f13481c;
        boolean r12 = Intrinsics.areEqual(r5, r11);
        sg.a r13 = this.f13478c;
        OCarouselIndicator r14 = (OCarouselIndicator) r13.f21902a;
        if (r12 == false) goto L36;
        Intrinsics.checkNotNullParameter(r11, "targetRange");
        int r15 = OCarouselIndicator.J;
        List r16 = OCarouselIndicator.w(r14.g(), r11);
        ArrayList r19 = r14.f13463z;
        if (r19.size() != r16.size()) goto L36;
        Iterator r20 = r16.iterator();
        int r110 = 0;
    L16:
        if (r20.hasNext() == false) goto L35;
        Object r111 = r20.next();
        int r112 = r110 + 1;
        if (r110 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        s r113 = (s) r111;
        p r114 = (p) CollectionsKt.getOrNull(r19, r110);
        if (r114 == null) goto L36;
        IndicatorImageDotView r115 = r14.x(r113);
        if (Intrinsics.areEqual(r114.f13502a, r113) == false) goto L36;
        View r21 = r114.f13503b;
        if (r115 == null) goto L30;
        if (r21 != r115) goto L36;
    L30:
        if (r115 != null) goto L34;
        if ((r21 instanceof IndicatorDotView) == false) goto L36;
    L34:
        r110 = r112;
        goto L16
    L35:
        boolean r116 = false;
    L38:
        if (r17 != IndicatorAnimator$RenderReason.SCROLL) goto L65;
        if (r12 == true) goto L65;
        if (r10 == null) goto L65;
        if (r14.g() <= r14.getMaxVisibleDots()) goto L65;
        IntRange r22 = r10.f13481c;
        Intrinsics.checkNotNullParameter(r22, "currentRange");
        Intrinsics.checkNotNullParameter(r11, "nextRange");
        int r23 = r11.getFirst() - r22.getFirst();
        if (r23 == (-1)) goto L52;
        if (r23 == 1) goto L50;
        IndicatorViewportShiftDirection r24 = null;
    L54:
        if (r24 != null) goto L56;
        ps.a.g("OCarouselIndicator", "Abort viewport transition because range shift is not adjacent, source=" + r22 + " target=" + r11);
        r13.g(r17, r18);
        this.d = r18;
        r13.f(r18);
        return;
    L56:
        int r25 = OCarouselIndicator.J;
        float r117 = (r14.getDotsSpacing() * 2.0f) + r14.getDotsWidth();
        if (r117 > 0.0f) goto L59;
        ps.a.g("OCarouselIndicator", Intrinsics.stringPlus("Abort viewport transition because step distance is invalid, distance=", Float.valueOf(r117)));
        r13.g(r17, r18);
        this.d = r18;
        r13.f(r18);
        return;
    L59:
        LinearLayout r118 = this.f13476a;
        r118.setTranslationX(0.0f);
        h r26 = this.d;
        if (r26 == null) goto L63;
        r13.f(r26);
    L63:
        int r27 = this.f + 1;
        this.f = r27;
        final c r119 = new c(r27, r10, r18, r24, r17);
        this.e = r119;
        Intrinsics.checkNotNullParameter(r10, "sourceState");
        Intrinsics.checkNotNullParameter(r18, "targetState");
        r14.s(r10, r18, 0.0f);
        float r28 = r24.resolveExitTranslation(r117);
        Function0<Unit> r29 = new IndicatorAnimator$startViewportTransition$1(this, r119);
        r118.animate().setUpdateListener(null).setListener(null).cancel();
        final float r30 = Math.abs(r28);
        r118.animate().translationX(r28).setDuration(300).setInterpolator(this.f13477b).setUpdateListener(new b(this, r119, r30)).setListener(new e(this, r119, r29)).start();
        return;
    L50:
        IndicatorViewportShiftDirection r31 = IndicatorViewportShiftDirection.FORWARD;
    L51:
        r24 = r31;
        goto L54
    L52:
        r31 = IndicatorViewportShiftDirection.BACKWARD;
    L65:
        if (r116 == false) goto L67;
        r13.g(r17, r18);
    L67:
        this.d = r18;
        r13.f(r18);
        return;
    L36:
        r116 = true;
        goto L38
    L8:
        r5 = r10.f13481c;
        goto L9
    }
}
