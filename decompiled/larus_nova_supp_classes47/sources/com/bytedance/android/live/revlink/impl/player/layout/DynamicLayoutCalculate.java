package com.bytedance.android.live.revlink.impl.player.layout;

import android.graphics.RectF;
import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import com.bytedance.android.live.revenue.common.player.vendor.link.RevenueLayoutClient;
import com.bytedance.android.live.revlink.impl.dynamiclayout.RevenueDynamicLayout;
import com.bytedance.android.live.revlink.impl.player.i;
import com.bytedance.android.live.revlink.link.core.service.s;
import com.bytedance.android.live.revlink.link.dynamiclayout.model.AudienceHeightFixMode;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.live.layout.AdjustBase;
import com.bytedance.live.layout.LayoutAlign;
import com.bytedance.live.layout.LayoutContext;
import com.bytedance.live.layout.LayoutScale;
import com.bytedance.live.layout.LayoutStrategy;
import com.bytedance.live.layout.c;
import com.bytedance.live.layout.e;
import io.reactivex.disposables.Disposable;
import k31.a;
import k31.k;
import k31.l;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import o51.f;
import rc0.b;
import t51.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class DynamicLayoutCalculate {
    public final s a;
    public Disposable b;
    public final e c;
    public final RevenueLayoutClient d;

    public DynamicLayoutCalculate() {
        this.a = (s) RevenueDynamicLayout.a.getValue();
        this.c = new e();
        this.d = new RevenueLayoutClient();
    }

    public final void a(RevSeiFrame r22, final i r23) {
        Intrinsics.checkNotNullParameter(r22, "seiFrame");
        Intrinsics.checkNotNullParameter(r23, "context");
        Disposable r4 = this.b;
        if (r4 == null) goto L6;
        r4.dispose();
    L6:
        if (r23.o != LiveMode.SCREEN_RECORD) goto L8;
        boolean r5 = true;
    L9:
        f r6 = r22.t(r5, r23.h);
        s r7 = this.a;
        Function1<g, Unit> r8 = new DynamicLayoutCalculate$doLayout$1(r23);
        r7.getClass();
        Intrinsics.checkNotNullParameter(r6, "routerKey");
        Intrinsics.checkNotNullParameter(r8, "onGeckoUpdate");
        Pair r9 = r7.a.b(r6, r8);
        g r10 = (g) r9.component1();
        Disposable r12 = (Disposable) r9.component2();
        Disposable r13 = this.b;
        if (r13 == null) goto L12;
        r13.dispose();
    L12:
        this.b = r12;
        if (r10 == null) goto L92;
        RevenueLayoutClient r14 = this.d;
        DeviceType r15 = b.a();
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "deviceType");
        r14.f = r15;
        RevenueLayoutClient r16 = this.d;
        int r17 = r23.j;
        r16.b = r23.l;
        r16.a = r17;
        int r18 = r23.m;
        int r19 = r23.n;
        r16.c = r18;
        r16.d = r19;
        r16.g = r23.h;
        Intrinsics.checkNotNullParameter(r22, "seiFrame");
        r16.k = r22;
        RevenueLayoutClient r3 = this.d;
        r3.i = r23.c;
        r3.j = r23.d;
        r3.h = r23.e;
        a r20 = r23.q;
        if (r20 == null) goto L17;
        int r24 = k31.b.a(r20);
    L18:
        k r25 = r23.r;
        if (r25 == null) goto L21;
        int r26 = l.a(r25, true);
    L22:
        int r27 = r24 + r26;
        RevenueLayoutClient r28 = this.d;
        r28.m = r27;
        r28.c();
        Object r29 = this.d.a();
        if ((r29 instanceof sx0.a.e) == false) goto L26;
        sx0.a.e r30 = (sx0.a.e) r29;
        return;
    L26:
        if ((r29 instanceof sx0.b) == false) goto L94;
        sx0.b r32 = (sx0.b) r29;
        Intrinsics.checkNotNullParameter(r23, "$this$deviceType");
        if (r23.g == false) goto L30;
        DeviceType r33 = DeviceType.FOLD_FULL;
    L43:
        t51.a r1 = r10.a(r33, ((Number) r22.A.getValue()).intValue());
        if (r1 == null) goto L95;
        this.d.b();
        int r34 = r1.f();
        if (r34 != AudienceHeightFixMode.OriginContainerHeight.ordinal()) goto L50;
        Pair r35 = TuplesKt.to(Integer.valueOf(r23.j), Integer.valueOf(r23.l));
    L53:
        int r110 = ((Number) r35.component1()).intValue();
        int r111 = ((Number) r35.component2()).intValue();
        AdjustBase r36 = (AdjustBase) UtilsKt.b(ArraysKt.toList(AdjustBase.values()), r1.a());
        if (r36 != null) goto L56;
        r36 = AdjustBase.CONTENT;
    L56:
        AdjustBase r37 = r36;
        LayoutScale r38 = (LayoutScale) UtilsKt.b(ArraysKt.toList(LayoutScale.values()), r1.j());
        if (r38 != null) goto L59;
        r38 = LayoutScale.ASPECT_FIT;
    L59:
        LayoutScale r112 = r38;
        LayoutAlign r39 = (LayoutAlign) UtilsKt.b(ArraysKt.toList(LayoutAlign.values()), r1.b());
        if (r39 != null) goto L62;
        r39 = LayoutAlign.CENTER;
    L62:
        LayoutAlign r113 = r39;
        float r114 = r32.a();
        RectF r115 = this.d.b();
        LayoutStrategy r116 = LayoutStrategy.NORMAL;
        t51.i r40 = r1.l();
        float r42 = r110;
        float r43 = r111;
        Intrinsics.checkNotNullParameter(r40, "$this$toRectF");
        if (r40.d() != 0.0f) goto L65;
        float r44 = com.bytedance.android.live.revenue.common.i.b(r40.c()) / r42;
    L67:
        if (r40.h() != 0.0f) goto L69;
        float r0 = com.bytedance.android.live.revenue.common.i.b(r40.g()) / r43;
    L71:
        if (r40.f() != 0.0f) goto L73;
        float r117 = com.bytedance.android.live.revenue.common.i.b(r40.e()) / r42;
    L75:
        if (r40.b() != 0.0f) goto L77;
        float r45 = com.bytedance.android.live.revenue.common.i.b(r40.a()) / r43;
    L78:
        RectF r46 = new RectF(r44, r0, r117, r45);
        boolean r118 = r1.h();
        boolean r119 = r1.g();
        int r2 = com.bytedance.android.live.revenue.common.i.b(r1.k());
        k r47 = r23.r;
        if (r47 == null) goto L81;
        int r120 = l.a(r47, true);
    L82:
        c r48 = new c(r37, r112, r113, r110, r111, r114, r115, r116, r46, r118, r119, r2 + r120);
        e r49 = this.c;
        r49.getClass();
        Intrinsics.checkNotNullParameter(r48, "params");
        com.bytedance.live.layout.b r50 = r49.a;
        LayoutContext r52 = new LayoutContext(r48);
        r50.getClass();
        Intrinsics.checkNotNullParameter(r52, "layoutContext");
        int r53 = com.bytedance.live.layout.b.a.a[r52.h.ordinal()];
        if (r53 != 1) goto L85;
        di6.c r54 = new di6.b();
    L90:
        r49.b = r54.a(r52);
        return;
    L85:
        if (r53 != 2) goto L88;
        r54 = new di6.c();
        goto L90
    L88:
        throw new NoWhenBranchMatchedException();
    L81:
        r120 = 0;
        goto L82
    L77:
        r45 = r40.b();
        goto L78
    L73:
        r117 = r40.f();
        goto L75
    L69:
        r0 = r40.h();
        goto L71
    L65:
        r44 = r40.d();
        goto L67
    L50:
        if (r34 != AudienceHeightFixMode.RationTransformHeight.ordinal()) goto L52;
        r35 = TuplesKt.to(Integer.valueOf(r23.j), Integer.valueOf((int) ((r23.j / 9.0f) * 16.0f)));
        goto L53
    L52:
        r35 = TuplesKt.to(Integer.valueOf(r23.j), Integer.valueOf(r23.l));
        goto L53
    L95:
        return;
    L30:
        boolean r55 = r23.f;
        if (r55 == true) goto L33;
    L35:
        if (r55 == false) goto L40;
        if (r23.h == true) goto L40;
        r33 = DeviceType.PAD_H;
    L40:
        if (r23.h == true) goto L42;
        r33 = DeviceType.NORMAL_MOBILE_H;
        goto L43
    L42:
        r33 = DeviceType.NORMAL_MOBILE;
        goto L43
    L33:
        if (r23.h == false) goto L35;
        r33 = DeviceType.PAD_V;
        goto L43
    L94:
        return;
    L21:
        r26 = 0;
        goto L22
    L17:
        r24 = 0;
        goto L18
    L92:
        return;
    L8:
        r5 = false;
        goto L9
    }
}
