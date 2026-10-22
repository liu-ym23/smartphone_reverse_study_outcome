package com.lynx.animax.service;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import gm.b;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface IAutoRegisterAnimaXService extends IAnimaXService {
    @NonNull
    default b getAutoRegisterServiceScope() {
        return b.f17107b;
    }

    @NonNull
    Class<? extends IAnimaXService> getServiceClass();
}
