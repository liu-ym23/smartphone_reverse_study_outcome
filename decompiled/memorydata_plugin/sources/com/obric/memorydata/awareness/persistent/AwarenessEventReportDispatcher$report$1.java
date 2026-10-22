package com.obric.memorydata.awareness.persistent;

import com.obric.memorydata.awareness.api.AwarenessManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class AwarenessEventReportDispatcher$report$1 extends FunctionReferenceImpl implements Function2<String, Map<String, ? extends Object>, Unit> {
    AwarenessEventReportDispatcher$report$1(Object r8) {
        super(2, r8, AwarenessManager.class, "dispatchAwarenessEvent", "dispatchAwarenessEvent(Ljava/lang/String;Ljava/util/Map;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Unit invoke(String r3, Map<String, ? extends Object> r4) {
        invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r3, Map<String, ? extends Object> r4) {
        Map<String, ? extends Object> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "p0");
        ((AwarenessManager) ZeusTransformUtils.preCheckCast(this.receiver, AwarenessManager.class, "com.obric.memorydata.plugin")).dispatchAwarenessEvent(r3, r5);
    }
}
