package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.livesdk.gift.configmodel.x0;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopSeriesViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVISeriesTopView extends BaseGiftMVIViewChildNode<GiftTopViewState, GiftTopSeriesViewState, GiftAction> {
    public ViewGroup m;
    public zy0.b n;
    public final x0 o;

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        return 2131567545;
    }

    public final void i() {
        ViewGroup r0 = this.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        r0.removeAllViews();
        zy0.b r1 = this.n;
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    }

    public final void g() {
        this.m = (ViewGroup) r().findViewById(2131373765);
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftTopViewState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVISeriesTopView$bindToParent$1 r0 = GiftMVISeriesTopView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public GiftMVISeriesTopView(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        super(r2, r3);
        this.o = (x0) nz1.a.w.getValue(null, nz1.a.a[21]);
    }

    public final void b(com.bytedance.android.anya.k r6, MVIState r7) {
        GiftTopSeriesViewState r8 = (GiftTopSeriesViewState) r7;
        Intrinsics.checkNotNullParameter(r6, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r8, "state");
        r0<GiftTopSeriesViewState, Map<String, Object>> r9 = r8.getSeriesGiftMap();
        Object r0 = r6.c.a(r9);
        if (r0 == null) goto L25;
        r6.b.a.invoke(r9);
        Map r1 = (Map) r0;
        if (r1.isEmpty() == true) goto L30;
        zy0.b r10 = this.n;
        if (r10 == null) goto L13;
        xy0.a r11 = r10.g();
        if (r11 == null) goto L26;
        r11.updateData(r1);
        return;
    L26:
        return;
    L13:
        if (com.bytedance.android.live.revenue.common.b0.a().e() == false) goto L15;
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r13 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).q8(getContext(), UriProtector.parse(this.o.b() + "&enable_canvas=1&enable_canvas_optmize=1"), null);
    L16:
        this.n = r13;
        if (r13 == null) goto L28;
        ViewGroup r2 = this.m;
        if (r2 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L21:
        r2.addView(r13.c());
        Map r3 = MapsKt.toMutableMap(r1);
        r3.put("panel_new_architecture", Integer.valueOf(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() ? 1 : 0));
        xy0.a r14 = r13.g();
        if (r14 == null) goto L29;
        r14.load(null, r3);
        return;
    L29:
        return;
    L28:
        return;
    L15:
        r13 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).J8(getContext(), UriProtector.parse(this.o.b() + "&enable_canvas=1&enable_canvas_optmize=1"), null);
        goto L16
    L30:
        return;
    }
}
