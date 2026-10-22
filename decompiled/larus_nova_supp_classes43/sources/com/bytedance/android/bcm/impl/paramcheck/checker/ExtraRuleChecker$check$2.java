package com.bytedance.android.bcm.impl.paramcheck.checker;

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
public final class ExtraRuleChecker$check$2 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ com.bytedance.android.bcm.impl.paramcheck.c $target;

    public ExtraRuleChecker$check$2(com.bytedance.android.bcm.impl.paramcheck.c r1) {
        this.$target = r1;
        super(1);
    }

    public final void invoke(JSONObject r10) {
        JSONObject r11 = r10.putOpt("btm", this.$target.getBtm());
        Lazy r0 = BtmFormatUtils.a;
        r11.putOpt("btm_page", BtmFormatUtils.b(this.$target.getBtm()));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
