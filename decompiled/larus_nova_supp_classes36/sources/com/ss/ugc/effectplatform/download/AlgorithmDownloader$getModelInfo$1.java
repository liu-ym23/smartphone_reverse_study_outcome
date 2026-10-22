package com.ss.ugc.effectplatform.download;

import com.ss.ugc.effectplatform.model.algorithm.ModelInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
final /* synthetic */ class AlgorithmDownloader$getModelInfo$1 extends MutablePropertyReference0 {
    public AlgorithmDownloader$getModelInfo$1(a r1) {
        super(r1);
    }

    public String getName() {
        return "modelInfo";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(a.class);
    }

    public String getSignature() {
        return "getModelInfo()Lcom/ss/ugc/effectplatform/model/algorithm/ModelInfo;";
    }

    public Object get() {
        ModelInfo r0 = ((a) ((CallableReference) this).receiver).a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("modelInfo");
    L5:
        return r0;
    }

    public void set(Object r2) {
        ModelInfo r3 = (ModelInfo) r2;
        ((a) ((CallableReference) this).receiver).a = r3;
    }
}
