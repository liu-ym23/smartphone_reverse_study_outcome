package com.lynx.tasm.service;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface ILynxTrailService extends IServiceProvider {
    Map<String, Object> getAllValues();

    @Override // com.lynx.tasm.service.IServiceProvider
    @NonNull
    default Class<? extends IServiceProvider> getServiceClass() {
        return ILynxTrailService.class;
    }

    Object objectValueForTrailKey(@NonNull String r5);

    String stringValueForTrailKey(@NonNull String r5);
}
