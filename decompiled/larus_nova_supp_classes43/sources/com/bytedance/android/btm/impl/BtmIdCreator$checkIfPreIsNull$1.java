package com.bytedance.android.btm.impl;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.btm.impl.util.BtmFormatUtils;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
final class BtmIdCreator$checkIfPreIsNull$1 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ com.bytedance.android.btm.api.model.c $btmItem;
    final /* synthetic */ String $lastBtmId;
    final /* synthetic */ String $resumedPageBtm;
    final /* synthetic */ String $resumedPageClassName;
    final /* synthetic */ Object $state;

    public BtmIdCreator$checkIfPreIsNull$1(String r1, String r10, String r11, com.bytedance.android.btm.api.model.c r12, Object r13) {
        this.$resumedPageBtm = r1;
        this.$resumedPageClassName = r10;
        this.$lastBtmId = r11;
        this.$btmItem = r12;
        this.$state = r13;
        super(1);
    }

    public final void invoke(JSONObject r10) {
        r10.put("resumed_btm_page", this.$resumedPageBtm);
        r10.put("resumed_page", this.$resumedPageClassName);
        Lazy r0 = BtmFormatUtils.a;
        r10.put("last_btm", BtmFormatUtils.h(this.$lastBtmId));
        int r1 = com.bytedance.android.btm.impl.util.c.a;
        r10.put("finder", com.bytedance.android.btm.impl.util.c.b(this.$btmItem.e));
        r10.put("enter_page", this.$btmItem.a());
        r10.put("page_sate", this.$state);
        r10.put("btm", BtmFormatUtils.h(this.$btmItem.a));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
