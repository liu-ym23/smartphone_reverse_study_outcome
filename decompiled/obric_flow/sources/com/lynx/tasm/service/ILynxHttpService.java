package com.lynx.tasm.service;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.lynx.jsbridge.network.HttpRequest;
import ko.i;
import nm.a;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface ILynxHttpService extends IServiceProvider {
    @Override // com.lynx.tasm.service.IServiceProvider
    @NonNull
    default Class<? extends IServiceProvider> getServiceClass() {
        return ILynxHttpService.class;
    }

    void request(@NonNull HttpRequest r5, @NonNull i r10);

    void requestStreaming(@NonNull HttpRequest r5, @NonNull i r10, @NonNull a r11);
}
