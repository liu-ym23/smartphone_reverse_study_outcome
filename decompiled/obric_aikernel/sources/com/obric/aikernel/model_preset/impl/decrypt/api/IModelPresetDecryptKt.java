package com.obric.aikernel.model_preset.impl.decrypt.api;

import com.bytedance.news.common.service.manager.IService;
import d4.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class IModelPresetDecryptKt {
    private static final IModelPresetDecrypt ModelPresetDecrypt = null;

    static {
        IService r10 = a.a(Reflection.getOrCreateKotlinClass(IModelPresetDecrypt.class));
        Intrinsics.checkNotNull(r10);
        ModelPresetDecrypt = (IModelPresetDecrypt) r10;
    }

    public static final IModelPresetDecrypt getModelPresetDecrypt() {
        return ModelPresetDecrypt;
    }
}
