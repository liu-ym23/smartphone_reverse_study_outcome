package com.bytedance.android.bcm.impl;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class BcmServiceImpl$checkBcmBizAndKey$3 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ String $api;
    final /* synthetic */ List $invalidKeys;

    public BcmServiceImpl$checkBcmBizAndKey$3(List r1, String r10) {
        this.$invalidKeys = r1;
        this.$api = r10;
        super(1);
    }

    public final void invoke(JSONObject r11) {
        r11.put("keys", CollectionsKt.joinToString$default(this.$invalidKeys, ",", null, null, 0, null, null, 62, null));
        r11.put("api", this.$api);
        String r0 = this.$api;
        String r10 = AIStateLogRequest.SOURCE_PAGE;
        if (StringsKt.contains$default(r0, AIStateLogRequest.SOURCE_PAGE, false, 2, null) == true) goto L6;
        r10 = "unit";
    L6:
        r11.put("type", r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
