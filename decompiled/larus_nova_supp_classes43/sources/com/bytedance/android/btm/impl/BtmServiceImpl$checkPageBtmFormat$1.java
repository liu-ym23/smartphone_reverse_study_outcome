package com.bytedance.android.btm.impl;

import com.byted.cast.sink.api.IAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class BtmServiceImpl$checkPageBtmFormat$1 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ String $className;
    final /* synthetic */ boolean $isHybrid;
    final /* synthetic */ String $pageBtm;
    final /* synthetic */ String $sourceBtmToken;
    final /* synthetic */ String $url;

    public BtmServiceImpl$checkPageBtmFormat$1(boolean r1, String r10, String r11, String r12, String r13) {
        this.$isHybrid = r1;
        this.$className = r10;
        this.$url = r11;
        this.$sourceBtmToken = r12;
        this.$pageBtm = r13;
        super(1);
    }

    public final void invoke(JSONObject r10) {
        if (this.$isHybrid == false) goto L5;
        String r0 = "1";
    L6:
        r10.put("is_hybrid", r0);
        String r1 = this.$className;
        if (r1 == null) goto L9;
        r10.put("page_class_name", r1);
    L9:
        String r11 = this.$url;
        if (r11 == null) goto L12;
        r10.put(com.bytedance.android.ec.core.event.a.KEY_URL, r11);
    L12:
        r10.putOpt("source_btm_token", this.$sourceBtmToken);
        r10.putOpt("btm", this.$pageBtm);
        r10.putOpt(com.bytedance.android.ec.core.event.a.KEY_MSG, "注册页面的BTM点位" + this.$pageBtm + "不合法，注册页面失败！");
        return;
    L5:
        r0 = "0";
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
