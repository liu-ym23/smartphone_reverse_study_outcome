package com.obric.aiproactive.impl.bridge;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class AiProactiveAgentBridgeImpl$artifactResourceStore$2$1 extends FunctionReferenceImpl implements Function1<String, Set<? extends String>> {
    AiProactiveAgentBridgeImpl$artifactResourceStore$2$1(Object r8) {
        super(1, r8, AiProactiveAgentBridgeImpl.class, "loadReferencedArtifactLocators", "loadReferencedArtifactLocators(Ljava/lang/String;)Ljava/util/Set;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Set<? extends String> invoke(String r3) {
        return invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Set<String> invoke2(String r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        return AiProactiveAgentBridgeImpl.access$loadReferencedArtifactLocators((AiProactiveAgentBridgeImpl) ZeusTransformUtils.preCheckCast(this.receiver, AiProactiveAgentBridgeImpl.class, "com.obric.memorydata.plugin"), r3);
    }
}
