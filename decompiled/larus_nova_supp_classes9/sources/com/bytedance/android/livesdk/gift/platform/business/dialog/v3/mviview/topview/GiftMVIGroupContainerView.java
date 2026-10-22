package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopGroupContainerViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowGroupData;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIGroupContainerView extends BaseGiftMVIViewChildNode<GiftTopViewState, GiftTopGroupContainerViewState, GiftAction> {
    public zy0.b m;
    public final Lazy n;

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        return 2131567542;
    }

    public final void i() {
        ((ViewGroup) this.n.getValue()).removeAllViews();
        zy0.b r0 = this.m;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftTopViewState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIGroupContainerView$bindToParent$1 r0 = GiftMVIGroupContainerView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public GiftMVIGroupContainerView(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        super(r2, r3);
        this.n = LazyKt.lazy(new GiftMVIGroupContainerView$rootView$2(this));
    }

    public final void b(com.bytedance.android.anya.k r5, MVIState r6) {
        GiftTopGroupContainerViewState r7 = (GiftTopGroupContainerViewState) r6;
        Intrinsics.checkNotNullParameter(r5, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r7, "state");
        r0<GiftTopGroupContainerViewState, ShowGroupData> r8 = r7.getShowData();
        Object r0 = r5.c.a(r8);
        if (r0 == null) goto L21;
        r5.b.a.invoke(r8);
        ShowGroupData r1 = (ShowGroupData) r0;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == true) goto L8;
        return;
    L8:
        if (r1.getCanShow() == true) goto L10;
        return;
    L10:
        if (this.m == null) goto L12;
        return;
    L12:
        if (com.bytedance.android.live.revenue.common.b0.a().g() == false) goto L14;
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r9 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).q8(getContext(), UriProtector.parse(com.bytedance.android.livesdk.gift.platform.core.h.m().e()), null);
    L15:
        this.m = r9;
        if (r9 == null) goto L24;
        ((ViewGroup) this.n.getValue()).addView(r9.c());
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("gift_group_list", GsonProtectorUtils.toJson(GsonHelper.get(), r1.getGiftGroupList()).toString());
        r2.put("gift_id", String.valueOf(r1.getGiftId()));
        xy0.a r10 = r9.g();
        if (r10 == null) goto L25;
        r10.load(null, r2);
        return;
    L25:
        return;
    L24:
        return;
    L14:
        r9 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).J8(getContext(), UriProtector.parse(com.bytedance.android.livesdk.gift.platform.core.h.m().e()), null);
        goto L15
    }
}
