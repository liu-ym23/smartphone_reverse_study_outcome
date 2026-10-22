package com.obric.assistant.network.restrict;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final /* synthetic */ class a implements Function1 {
    public /* synthetic */ a() {
    }

    public final Object invoke(Object r9) {
        JSONObject r10 = (JSONObject) r9;
        FLogger.a.i("ObricAIagentNetworkConfigManager", "onSettingUpdate");
        BuildersKt.launch$default(c.b, null, null, new ObricAIagentNetworkConfigManager$updateRules$1(null), 3, null);
        return Unit.INSTANCE;
    }
}
