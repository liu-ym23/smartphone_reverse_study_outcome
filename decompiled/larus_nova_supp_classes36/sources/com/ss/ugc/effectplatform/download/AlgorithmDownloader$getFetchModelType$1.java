package com.ss.ugc.effectplatform.download;

import com.ss.ugc.effectplatform.model.algorithm.FetchModelType;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
final /* synthetic */ class AlgorithmDownloader$getFetchModelType$1 extends MutablePropertyReference0 {
    public AlgorithmDownloader$getFetchModelType$1(a r1) {
        super(r1);
    }

    public String getName() {
        return "fetchModelType";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(a.class);
    }

    public String getSignature() {
        return "getFetchModelType()Lcom/ss/ugc/effectplatform/model/algorithm/FetchModelType;";
    }

    public Object get() {
        FetchModelType r0 = ((a) ((CallableReference) this).receiver).b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("fetchModelType");
    L5:
        return r0;
    }

    public void set(Object r2) {
        FetchModelType r3 = (FetchModelType) r2;
        ((a) ((CallableReference) this).receiver).b = r3;
    }
}
