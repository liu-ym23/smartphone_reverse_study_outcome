package com.obric.memorydata.awareness.impl.gate;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class SystemSettingsFeatureSwitchValueProvider$2 extends FunctionReferenceImpl implements Function2<String, Function0<? extends Unit>, g.b> {
    SystemSettingsFeatureSwitchValueProvider$2(Object r8) {
        super(2, r8, g.a.class, "observeSystemSetting", "observeSystemSetting(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Lcom/obric/memorydata/awareness/impl/gate/SystemSettingsFeatureSwitchValueProvider$FeatureSwitchObservation;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final g.b invoke2(String r3, Function0<Unit> r4) {
        Function0<Unit> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "p0");
        Intrinsics.checkNotNullParameter(r5, "p1");
        return ((g.a) ZeusTransformUtils.preCheckCast(this.receiver, g.a.class, "com.obric.memorydata.plugin")).a(r3, r5);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ g.b invoke(String r3, Function0<? extends Unit> r4) {
        return invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(r4, Function0.class, "com.obric.memorydata.plugin"));
    }
}
