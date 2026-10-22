package com.obric.aikernel.model_decrypt.api.decrypt;

import com.bytedance.news.common.service.manager.IService;
import d4.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class IModelDecryptKt {
    private static final IModelDecrypt ModelDecrypt = null;

    static {
        IService r10 = a.a(Reflection.getOrCreateKotlinClass(IModelDecrypt.class));
        Intrinsics.checkNotNull(r10);
        ModelDecrypt = (IModelDecrypt) r10;
    }

    public static final IModelDecrypt getModelDecrypt() {
        return ModelDecrypt;
    }
}
