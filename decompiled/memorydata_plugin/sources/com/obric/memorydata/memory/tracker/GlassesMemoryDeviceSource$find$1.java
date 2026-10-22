package com.obric.memorydata.memory.tracker;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class GlassesMemoryDeviceSource$find$1 extends FunctionReferenceImpl implements Function0<Integer> {
    GlassesMemoryDeviceSource$find$1(Object r8) {
        super(0, r8, a.class, "connectedProductId", "connectedProductId()Ljava/lang/Integer;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Integer invoke() {
        return a.a((a) ZeusTransformUtils.preCheckCast(this.receiver, a.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return invoke();
    }
}
