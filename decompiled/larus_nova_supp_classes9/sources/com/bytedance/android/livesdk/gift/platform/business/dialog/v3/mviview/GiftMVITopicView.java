package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopicState;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVITopicView extends BaseGiftMVIViewChildNode<GiftPanelState, GiftTopicState, GiftAction> {
    public zy0.b m;
    public final ViewGroup n;

    public final void g() {
    }

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        return 2131565254;
    }

    public final void i() {
        zy0.b r0 = this.m;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.l.removeAllViews();
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftPanelState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVITopicView$bindToParent$1 r0 = GiftMVITopicView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public GiftMVITopicView(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "currentContext");
        Intrinsics.checkNotNullParameter(r3, "parentView");
        super(r2, r3);
        this.n = r3;
    }

    public final void b(com.bytedance.android.anya.k r4, MVIState r5) {
        GiftTopicState r6 = (GiftTopicState) r5;
        Intrinsics.checkNotNullParameter(r4, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r6, "state");
        com.bytedance.android.anya.r0<GiftTopicState, Map<String, Object>> r7 = r6.getTopicListInfo();
        Object r0 = r4.c.a(r7);
        if (r0 == null) goto L18;
        r4.b.a.invoke(r7);
        Map r1 = (Map) r0;
        if ((!r1.isEmpty()) == true) goto L7;
        return;
    L7:
        if (this.m != null) goto L20;
        String r8 = ((com.bytedance.android.livesdk.gift.configmodel.z0) com.bytedance.android.livesdk.gift.platform.business.b.M.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[37])).b();
        if (com.bytedance.android.live.revenue.common.b0.a().k() == false) goto L11;
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r9 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).q8(getContext(), UriProtector.parse(r8), null);
    L12:
        this.m = r9;
        if (r9 == null) goto L21;
        this.l.addView(r9.c());
        xy0.a r10 = r9.g();
        if (r10 == null) goto L22;
        r10.load(null, r1);
        return;
    L22:
        return;
    L21:
        return;
    L11:
        r9 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).J8(getContext(), UriProtector.parse(r8), null);
        goto L12
    L20:
        return;
    }
}
