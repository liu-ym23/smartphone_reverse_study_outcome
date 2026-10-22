package com.bytedance.dataplatform;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
final /* synthetic */ class ClientExperimentManager$setExposureManager$1 extends MutablePropertyReference0 {
    ClientExperimentManager$setExposureManager$1(b r1) {
        super(r1);
    }

    @Override // kotlin.reflect.KProperty0
    public Object get() {
        return b.a((b) ZeusTransformUtils.preCheckCast(this.receiver, b.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "exposureManager";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(b.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getExposureManager()Lcom/bytedance/dataplatform/ExposureManager;";
    }

    @Override // kotlin.reflect.KMutableProperty0
    public void set(Object r3) {
        b.a((b) ZeusTransformUtils.preCheckCast(this.receiver, b.class, "com.obric.memorydata.plugin"), (f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.memorydata.plugin"));
    }
}
