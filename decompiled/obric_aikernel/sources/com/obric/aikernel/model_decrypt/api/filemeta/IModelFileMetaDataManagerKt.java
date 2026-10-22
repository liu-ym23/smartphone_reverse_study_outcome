package com.obric.aikernel.model_decrypt.api.filemeta;

import com.bytedance.news.common.service.manager.IService;
import d4.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class IModelFileMetaDataManagerKt {
    private static final IModelFileMetaDataManager ModelFileMetaDataManager = null;

    static {
        IService r10 = a.a(Reflection.getOrCreateKotlinClass(IModelFileMetaDataManager.class));
        Intrinsics.checkNotNull(r10);
        ModelFileMetaDataManager = (IModelFileMetaDataManager) r10;
    }

    public static final IModelFileMetaDataManager getModelFileMetaDataManager() {
        return ModelFileMetaDataManager;
    }
}
