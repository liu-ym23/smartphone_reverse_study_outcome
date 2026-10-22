package com.larus.dora.impl.resource;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DoraResourcePackageSynchronizer$stageTransaction$hasAllDeviceSpecificResources$1$1 extends FunctionReferenceImpl implements Function1<String, o> {
    public DoraResourcePackageSynchronizer$stageTransaction$hasAllDeviceSpecificResources$1$1(Object r8) {
        super(1, r8, Map.class, "get", "get(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    public final o invoke(String r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        return (o) ((Map) ((CallableReference) this).receiver).get(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((String) r1);
    }
}
