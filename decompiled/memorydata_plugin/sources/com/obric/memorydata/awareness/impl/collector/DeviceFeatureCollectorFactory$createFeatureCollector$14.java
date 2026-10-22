package com.obric.memorydata.awareness.impl.collector;

import com.obric.memorydata.ability.data.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class DeviceFeatureCollectorFactory$createFeatureCollector$14 extends FunctionReferenceImpl implements Function2<h, String, Pair<? extends Object, ? extends Map<String, ? extends Object>>> {
    DeviceFeatureCollectorFactory$createFeatureCollector$14(Object r8) {
        super(2, r8, d.class, "volumeQueryProcess", "volumeQueryProcess(Lcom/obric/memorydata/ability/data/IStandardData;Ljava/lang/String;)Lkotlin/Pair;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Pair<? extends Object, ? extends Map<String, ? extends Object>> invoke(h r3, String r4) {
        return invoke2((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Pair<Object, Map<String, Object>> invoke2(h r3, String r4) {
        h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "p1");
        return d.g((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.memorydata.plugin"), r5, r4);
    }
}
