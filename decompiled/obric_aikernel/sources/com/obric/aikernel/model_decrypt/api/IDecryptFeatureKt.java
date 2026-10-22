package com.obric.aikernel.model_decrypt.api;

import com.bytedance.news.common.service.manager.IService;
import d4.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class IDecryptFeatureKt {
    private static final IDecryptFeature DecryptFeature = null;

    static {
        IService r10 = a.a(Reflection.getOrCreateKotlinClass(IDecryptFeature.class));
        Intrinsics.checkNotNull(r10);
        DecryptFeature = (IDecryptFeature) r10;
    }

    public static final IDecryptFeature getDecryptFeature() {
        return DecryptFeature;
    }
}
