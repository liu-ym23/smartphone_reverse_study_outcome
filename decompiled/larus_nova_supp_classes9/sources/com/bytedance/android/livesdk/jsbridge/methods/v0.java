package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.base.GetBatchClientSettingsResultModel;
import com.bytedance.android.livesdk.config.bc1;
import com.bytedance.android.livesdk.config.d00;
import com.bytedance.android.livesdk.config.dp;
import com.bytedance.android.livesdk.config.ep;
import com.bytedance.android.livesdk.config.jp;
import com.bytedance.android.livesdk.config.mp;
import com.bytedance.android.livesdk.config.uj;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.l9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "getBatchClientSettings")
public final class v0 extends w20.e1<l9, GetBatchClientSettingsResultModel> {
    public v0() {
    }

    public final void invoke(Object r4, CallContext r5) {
        Intrinsics.checkNotNullParameter((l9) r4, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        GetBatchClientSettingsResultModel r6 = new GetBatchClientSettingsResultModel();
        GetBatchClientSettingsResultModel.a r7 = new GetBatchClientSettingsResultModel.a();
        JsonObject r0 = new JsonObject();
        r0.addProperty("new_dynamic_drawer_title_style", (Number) com.bytedance.android.livesdk.config.q2.a.getValue());
        r0.add("live_history_pop_config", GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), d00.a.getValue()));
        r0.addProperty("live_feed_drawer_concern_list_guide_continued_seconds", (Number) com.bytedance.android.livesdk.config.m2.a.getValue());
        r0.add("live_follow_moment_schema", GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), com.bytedance.android.livesdk.config.e5.a.getValue()));
        r0.add("live_enable_open_topic", GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), uj.a.getValue()));
        r0.add("live_drawer_entrance_key", GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), ep.a.getValue()));
        r0.add("live_drawer_need_replace_feed", GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), jp.a.getValue()));
        r0.add("feed_drawer_urls", GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), mp.a.getValue()));
        r0.add("live_drawer_multi_tab_config", GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), dp.a.getValue()));
        r0.add("nearby_tv_drawer_info", GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), bc1.a.getValue()));
        Unit r1 = Unit.INSTANCE;
        r7.a(r0);
        r6.b(r7);
        r6.a(GetBatchClientSettingsResultModel.Code.Success);
        finishWithResult(r6);
    }
}
