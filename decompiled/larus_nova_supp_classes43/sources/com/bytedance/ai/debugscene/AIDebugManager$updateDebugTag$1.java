package com.bytedance.ai.debugscene;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class AIDebugManager$updateDebugTag$1 extends FunctionReferenceImpl implements Function1<String, v4.a> {
    public AIDebugManager$updateDebugTag$1(Object r10) {
        super(1, r10, AIDebugManager.class, "getDebugTag", "getDebugTag(Ljava/lang/String;)Lcom/bytedance/ai/debugscene/tag/DebugTag;", 0);
    }

    public final v4.a invoke(String r10) {
        Intrinsics.checkNotNullParameter(r10, "p0");
        AIDebugManager r0 = (AIDebugManager) ((CallableReference) this).receiver;
        AIDebugManager r1 = AIDebugManager.a;
        r0.getClass();
        return AIDebugManager.e(r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((String) r1);
    }
}
