package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopMarketingViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SendGiftSuccess;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIMarketingTopView extends BaseGiftMVIViewChildNode<GiftTopViewState, GiftTopMarketingViewState, GiftAction> {
    public ViewGroup m;
    public zy0.b n;

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        return 2131567544;
    }

    public final void i() {
        zy0.b r0 = this.n;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        ViewGroup r1 = this.m;
        if (r1 == null) goto L8;
        r1.removeAllViews();
    L8:
        this.n = null;
    }

    public final void g() {
        this.m = (ViewGroup) r().findViewById(2131373760);
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftTopViewState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIMarketingTopView$bindToParent$1 r0 = GiftMVIMarketingTopView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public final boolean d(com.bytedance.android.anya.a0 r5) {
        Intrinsics.checkNotNullParameter(r5, "e");
        if ((r5 instanceof SendGiftSuccess) == false) goto L11;
        JSONObject r0 = new JSONObject();
        SendGiftSuccess r6 = (SendGiftSuccess) r5;
        r0.put("gift_id", r6.getGiftId());
        r0.put("send_count", r6.getSendCount());
        zy0.b r7 = this.n;
        if (r7 == null) goto L12;
        xy0.a r8 = r7.g();
        if (r8 == null) goto L13;
        r8.sendJsEvent("H5_sendGiftSucceed", r0);
        return false;
    L13:
        return false;
    L12:
        return false;
    L11:
        return false;
    }

    public GiftMVIMarketingTopView(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        super(r2, r3);
    }

    public final void b(com.bytedance.android.anya.k r4, MVIState r5) {
        GiftTopMarketingViewState r6 = (GiftTopMarketingViewState) r5;
        Intrinsics.checkNotNullParameter(r4, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r6, "state");
        r0<GiftTopMarketingViewState, Pair<Map<String, Object>, Boolean>> r7 = r6.getGiftMarketingInfo();
        Object r0 = r4.c.a(r7);
        if (r0 == null) goto L34;
        r4.b.a.invoke(r7);
        Pair r1 = (Pair) r0;
        Map r8 = (Map) r1.getFirst();
        boolean r9 = ((Boolean) r1.getSecond()).booleanValue();
        if (r8.isEmpty() == false) goto L15;
        if (r9 == true) goto L35;
        zy0.b r10 = this.n;
        if (r10 == null) goto L10;
        r10.dispose();
    L10:
        ViewGroup r11 = this.m;
        if (r11 == null) goto L13;
        r11.removeAllViews();
    L13:
        this.n = null;
        return;
    L35:
        return;
    L15:
        if (this.n == null) goto L22;
        HashMap r13 = new HashMap();
        r13.put("eventName", "gift_marketing_data_update");
        r13.put("eventParams", r8);
        zy0.b r14 = this.n;
        if (r14 == null) goto L37;
        xy0.a r15 = r14.g();
        if (r15 == null) goto L38;
        r15.sendJsEvent("H5_webcastNotification", r13);
        return;
    L38:
        return;
    L37:
        return;
    L22:
        if (com.bytedance.android.live.revenue.common.b0.a().h() == false) goto L24;
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r16 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).q8(getContext(), UriProtector.parse(nz1.a.l().c()), null);
    L25:
        this.n = r16;
        if (r16 == null) goto L40;
        ViewGroup r2 = this.m;
        if (r2 == null) goto L30;
        r2.addView(r16.c());
    L30:
        xy0.a r17 = r16.g();
        if (r17 == null) goto L41;
        r17.load(null, r8);
        return;
    L41:
        return;
    L40:
        return;
    L24:
        r16 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).J8(getContext(), UriProtector.parse(nz1.a.l().c()), null);
        goto L25
    }
}
