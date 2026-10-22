package com.obric.aikernel.model_preset.api;

import com.bytedance.news.common.service.manager.IService;
import d4.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class IModelPresetResKt {
    private static final IModelPresetRes ModelPresetRes = null;

    static {
        IService r10 = a.a(Reflection.getOrCreateKotlinClass(IModelPresetRes.class));
        Intrinsics.checkNotNull(r10);
        ModelPresetRes = (IModelPresetRes) r10;
    }

    public static final IModelPresetRes getModelPresetRes() {
        return ModelPresetRes;
    }
}
