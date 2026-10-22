package com.obric.aiproactive.ui.progress;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class ProactiveAgentRunActivity$adapter$2 extends FunctionReferenceImpl implements Function2<String, Boolean, Unit> {
    ProactiveAgentRunActivity$adapter$2(Object r8) {
        super(2, r8, ProactiveAgentRunActivity.class, "onUserExpansionChanged", "onUserExpansionChanged(Ljava/lang/String;Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Unit invoke(String r3, Boolean r4) {
        invoke((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        ProactiveAgentRunActivity.access$onUserExpansionChanged((ProactiveAgentRunActivity) ZeusTransformUtils.preCheckCast(this.receiver, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin"), r3, r4);
    }
}
