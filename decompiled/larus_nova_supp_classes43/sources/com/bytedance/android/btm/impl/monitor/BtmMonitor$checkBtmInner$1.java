package com.bytedance.android.btm.impl.monitor;

import com.byted.cast.sink.api.IAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class BtmMonitor$checkBtmInner$1 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ boolean $enterPage;
    final /* synthetic */ Boolean $isJsb;
    final /* synthetic */ String $type;

    public BtmMonitor$checkBtmInner$1(String r1, boolean r10, Boolean r11) {
        this.$type = r1;
        this.$enterPage = r10;
        this.$isJsb = r11;
        super(1);
    }

    public final void invoke(JSONObject r10) {
        r10.put("type", this.$type);
        r10.put("enter_page", this.$enterPage);
        r10.putOpt("is_jsb", this.$isJsb);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
