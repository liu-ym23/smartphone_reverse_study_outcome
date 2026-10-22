package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.annie.param.GsonMap;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.profit.privilege.model.paygrade.PayGrade;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftUserInfoViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SelectGiftHonorData;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIUserInfoView extends BaseGiftMVIViewChildNode<GiftPanelState, GiftUserInfoViewState, GiftAction> {
    public zy0.b m;
    public final Lazy n;

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        return 2131566132;
    }

    public final void g() {
        GiftPanelBizBoostUtils.E.getClass();
        UtilityKotlinExtentionsKt.s(0, false, ((Boolean) GiftPanelBizBoostUtils.B.getValue()).booleanValue(), new GiftMVIUserInfoView$onAttach$1(this), 3);
    }

    public final void i() {
        ((ViewGroup) this.n.getValue()).removeAllViews();
        zy0.b r0 = this.m;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftPanelState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIUserInfoView$bindToParent$1 r0 = GiftMVIUserInfoView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public GiftMVIUserInfoView(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        super(r2, r3);
        this.n = LazyKt.lazy(new GiftMVIUserInfoView$rootView$2(this));
    }

    public final void b(com.bytedance.android.anya.k r7, MVIState r8) {
        GiftUserInfoViewState r9 = (GiftUserInfoViewState) r8;
        Intrinsics.checkNotNullParameter(r7, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r9, "state");
        com.bytedance.android.anya.r0<GiftUserInfoViewState, PayGrade> r0 = r9.getPayGrade();
        Object r1 = r7.c.a(r0);
        if (r1 == null) goto L19;
        r7.b.a.invoke(r0);
        PayGrade r2 = (PayGrade) r1;
        if (r2.getScore() <= 0) goto L19;
        if (this.m == null) goto L19;
        Pair[] r3 = new Pair[1];
        JsonElement r4 = GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r2);
        GsonMap r5 = null;
        if ((r4 instanceof JsonObject) == true) goto L11;
        r4 = null;
    L11:
        JsonObject r6 = (JsonObject) r4;
        if (r6 == null) goto L14;
        r5 = UtilsKt.i(r6);
    L14:
        r3[0] = TuplesKt.to("payGrade", r5);
        Map r10 = MapsKt.mutableMapOf(r3);
        zy0.b r11 = this.m;
        if (r11 == null) goto L19;
        xy0.a r13 = r11.g();
        if (r13 == null) goto L19;
        r13.sendJsEvent("H5_updateUserHonor", r10);
    L19:
        com.bytedance.android.anya.r0<GiftUserInfoViewState, SelectGiftHonorData> r14 = r9.getGiftSelectData();
        Object r15 = r7.c.a(r14);
        if (r15 == null) goto L29;
        r7.b.a.invoke(r14);
        SelectGiftHonorData r16 = (SelectGiftHonorData) r15;
        JSONObject r17 = new JSONObject();
        if (r16.getShowScore() <= 0) goto L30;
        r17.put("diamond", r16.getShowScore());
        zy0.b r18 = this.m;
        if (r18 == null) goto L31;
        xy0.a r19 = r18.g();
        if (r19 == null) goto L32;
        r19.sendJsEvent("H5_onGiftSelected", r17);
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    }
}
