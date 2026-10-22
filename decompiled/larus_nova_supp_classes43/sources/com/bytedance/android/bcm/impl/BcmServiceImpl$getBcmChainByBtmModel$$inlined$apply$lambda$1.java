package com.bytedance.android.bcm.impl;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.btm.api.model.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;", "invoke", "com/bytedance/android/bcm/impl/BcmServiceImpl$getBcmChainByBtmModel$1$1"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class BcmServiceImpl$getBcmChainByBtmModel$$inlined$apply$lambda$1 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ String $ab1;
    final /* synthetic */ String $ab2;
    final /* synthetic */ d $btmModel$inlined;

    public BcmServiceImpl$getBcmChainByBtmModel$$inlined$apply$lambda$1(String r1, String r10, d r11) {
        this.$ab1 = r1;
        this.$ab2 = r10;
        this.$btmModel$inlined = r11;
        super(1);
    }

    public final void invoke(JSONObject r10) {
        r10.put("ab1", this.$ab1);
        r10.put("ab2", this.$ab2);
        r10.put("btm", this.$btmModel$inlined.a);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
