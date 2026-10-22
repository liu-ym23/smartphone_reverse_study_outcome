package com.obric.aiproactive.ui.progress;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class ProactiveAgentRunActivity$adapter$1 extends FunctionReferenceImpl implements Function1<z, Unit> {
    ProactiveAgentRunActivity$adapter$1(Object r8) {
        super(1, r8, ProactiveAgentRunActivity.class, "openMobileUsePlayer", "openMobileUsePlayer(Lcom/obric/aiproactive/ui/progress/MobileUseRowBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(z r3) {
        invoke2((z) ZeusTransformUtils.preCheckCast(r3, z.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(z r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        ProactiveAgentRunActivity.access$openMobileUsePlayer((ProactiveAgentRunActivity) ZeusTransformUtils.preCheckCast(this.receiver, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin"), r3);
    }
}
