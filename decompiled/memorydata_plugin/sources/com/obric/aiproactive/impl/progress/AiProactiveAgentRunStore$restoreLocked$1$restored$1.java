package com.obric.aiproactive.impl.progress;

import com.obric.aiproactive.api.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class AiProactiveAgentRunStore$restoreLocked$1$restored$1 extends FunctionReferenceImpl implements Function1<JSONObject, g> {
    AiProactiveAgentRunStore$restoreLocked$1$restored$1(Object r8) {
        super(1, r8, c.class, "parseRun", "parseRun$ai_proactive_impl_obricRelease(Lorg/json/JSONObject;)Lcom/obric/aiproactive/api/AiProactiveAgentRunDto;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final g invoke2(JSONObject r3) {
        return ((c) ZeusTransformUtils.preCheckCast(this.receiver, c.class, "com.obric.memorydata.plugin")).b(r3);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ g invoke(JSONObject r3) {
        return invoke2((JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.memorydata.plugin"));
    }
}
