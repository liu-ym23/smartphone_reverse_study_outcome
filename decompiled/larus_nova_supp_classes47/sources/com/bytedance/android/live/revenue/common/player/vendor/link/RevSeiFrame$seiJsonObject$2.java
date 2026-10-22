package com.bytedance.android.live.revenue.common.player.vendor.link;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", "Lcom/bytedance/revenue/platform/api/core/JSONObject;", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RevSeiFrame$seiJsonObject$2 extends FunctionReferenceImpl implements Function0<JSONObject> {
    public RevSeiFrame$seiJsonObject$2(RevSeiFrame r8) {
        super(0, r8, RevSeiFrame.class, "convertSeiToJson", "convertSeiToJson()Lorg/json/JSONObject;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final JSONObject m388invoke() {
        return ((RevSeiFrame) ((CallableReference) this).receiver).a();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m388invoke();
    }
}
