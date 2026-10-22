package com.obric.memorydata.awareness.impl.collector;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class AssistantWakeupFeatureCollector$stopCollect$1 extends FunctionReferenceImpl implements Function2<Boolean, String, Unit> {
    AssistantWakeupFeatureCollector$stopCollect$1(Object r8) {
        super(2, r8, b.class, "onChange", "onChange(ZLjava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Unit invoke(Boolean r3, String r4) {
        invoke(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    public final void invoke(boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        b.a((b) ZeusTransformUtils.preCheckCast(this.receiver, b.class, "com.obric.memorydata.plugin"), r3, r4);
    }
}
