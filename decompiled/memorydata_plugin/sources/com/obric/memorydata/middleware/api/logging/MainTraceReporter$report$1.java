package com.obric.memorydata.middleware.api.logging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class MainTraceReporter$report$1 extends AdaptedFunctionReference implements Function2<String, Object, Unit> {
    MainTraceReporter$report$1(Object r8) {
        super(2, r8, JSONObject.class, "put", "put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;", 8);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Unit invoke(String r3, Object r4) {
        invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), r4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r3, Object r4) {
        ((JSONObject) ZeusTransformUtils.preCheckCast(this.receiver, JSONObject.class, "com.obric.memorydata.plugin")).put(r3, r4);
    }
}
