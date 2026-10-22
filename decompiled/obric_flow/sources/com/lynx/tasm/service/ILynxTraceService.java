package com.lynx.tasm.service;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface ILynxTraceService extends IServiceProvider {
    long getDefaultTraceFunction();

    @Override // com.lynx.tasm.service.IServiceProvider
    @NonNull
    default Class<? extends IServiceProvider> getServiceClass() {
        return ILynxTraceService.class;
    }
}
