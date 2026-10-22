package com.bytedance.android.btm.impl;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.btm.impl.util.BtmFormatUtils;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
final class BtmIdCreator$createBtmIdBeforeEnterPageInner$2 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ com.bytedance.android.btm.api.model.c $btmItem;
    final /* synthetic */ Ref.ObjectRef $lastBtmId;
    final /* synthetic */ Ref.ObjectRef $resumedPageBtm;
    final /* synthetic */ Ref.ObjectRef $resumedPageClassName;

    public BtmIdCreator$createBtmIdBeforeEnterPageInner$2(Ref.ObjectRef r1, Ref.ObjectRef r10, com.bytedance.android.btm.api.model.c r11, Ref.ObjectRef r12) {
        this.$resumedPageClassName = r1;
        this.$resumedPageBtm = r10;
        this.$btmItem = r11;
        this.$lastBtmId = r12;
        super(1);
    }

    public final void invoke(JSONObject r10) {
        r10.put("resumed_page", (String) this.$resumedPageClassName.element);
        r10.put("resumed_btm_page", (String) this.$resumedPageBtm.element);
        Lazy r0 = BtmFormatUtils.a;
        r10.put("btm", BtmFormatUtils.h(this.$btmItem.a));
        r10.put("last_btm", BtmFormatUtils.h((String) this.$lastBtmId.element));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
