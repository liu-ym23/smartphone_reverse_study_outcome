package com.lynx.tasm.service;

import android.content.Context;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface IServiceProvider {
    Class<? extends IServiceProvider> getServiceClass();

    default void onInitialize(Context r5) {
    }
}
