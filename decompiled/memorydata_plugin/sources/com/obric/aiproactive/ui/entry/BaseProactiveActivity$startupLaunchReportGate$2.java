package com.obric.aiproactive.ui.entry;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class BaseProactiveActivity$startupLaunchReportGate$2 extends FunctionReferenceImpl implements Function2<String, String, Unit> {
    BaseProactiveActivity$startupLaunchReportGate$2(Object r8) {
        super(2, r8, BaseProactiveActivity.class, "reportLaunchEvent", "reportLaunchEvent(Ljava/lang/String;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Unit invoke(String r3, String r4) {
        invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r3, String r4) {
        BaseProactiveActivity.access$reportLaunchEvent((BaseProactiveActivity) ZeusTransformUtils.preCheckCast(this.receiver, BaseProactiveActivity.class, "com.obric.memorydata.plugin"), r3, r4);
    }
}
