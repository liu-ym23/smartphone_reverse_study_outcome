package com.bytedance.android.live.recharge.widget;

import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/recharge/widget/RechargeNoticeLynxWidget;", "Lcom/bytedance/android/live/recharge/widget/AbsRechargeWidget;", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RechargeNoticeLynxWidget extends AbsRechargeWidget {
    public zy0.b i;
    public final com.bytedance.android.live.revenue.model.extension.main.b j;

    public final int getLayoutId() {
        return 2131567266;
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void xq(com.bytedance.android.live.recharge.deal.i r2) {
        Intrinsics.checkNotNullParameter(r2, "dealSet");
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void yq(long r1) {
    }

    public final void onUnload() {
        ((Widget) this).containerView.removeAllViews();
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void onLoad(Object[] r6) {
        com.bytedance.android.live.revenue.model.extension.main.b r7 = this.j;
        if (r7 == null) goto L25;
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.e r1 = null;
        if ((!StringsKt.isBlank(r7.getPanelSchema())) == true) goto L8;
        r7 = null;
    L8:
        if (r7 == null) goto L26;
        JsonElement r0 = GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r7);
        if ((r0 instanceof JsonObject) == true) goto L12;
        r0 = null;
    L12:
        JsonObject r2 = (JsonObject) r0;
        if (r2 == null) goto L16;
        Map<String, ? extends Object> r3 = MapsKt.toMutableMap(UtilsKt.i(r2));
        if (r3 == null) goto L16;
    L17:
        r3.put("event_page", "recharge");
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.e r8 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).J8(((Widget) this).context, x6.a.d(r7.getPanelSchema()), RechargeNoticeLynxWidget$onLoad$2$1.INSTANCE);
        if (r8 == null) goto L23;
        ((Widget) this).containerView.addView(r8.d);
        xy0.a<?> r4 = r8.g();
        if (r4 == null) goto L22;
        ((com.bytedance.android.live.revenue.platform.hybrid.impl.component.b) r4).load(null, r3);
    L22:
        Unit r5 = Unit.INSTANCE;
        r1 = r8;
    L23:
        this.i = r1;
        return;
    L16:
        r3 = new LinkedHashMap();
        goto L17
    L26:
        return;
    }

    public RechargeNoticeLynxWidget(RechargeDialogContext r2, com.bytedance.android.live.revenue.model.extension.main.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.j = r3;
    }
}
