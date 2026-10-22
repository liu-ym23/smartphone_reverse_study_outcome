package com.obric.aikernel.model_decrypt.api.decrypt;

import com.bytedance.news.common.service.manager.IService;
import d4.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class IModelCertKt {
    private static final IModelCert ModelCert = null;

    static {
        IService r10 = a.a(Reflection.getOrCreateKotlinClass(IModelCert.class));
        Intrinsics.checkNotNull(r10);
        ModelCert = (IModelCert) r10;
    }

    public static final IModelCert getModelCert() {
        return ModelCert;
    }
}
