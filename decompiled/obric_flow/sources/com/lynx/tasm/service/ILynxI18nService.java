package com.lynx.tasm.service;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.lynx.tasm.h;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface ILynxI18nService extends IServiceProvider {
    @Override // com.lynx.tasm.service.IServiceProvider
    @NonNull
    default Class<? extends IServiceProvider> getServiceClass() {
        return ILynxI18nService.class;
    }

    boolean loadLibrary(h r5);

    boolean registerNapiEnv(long r5);
}
