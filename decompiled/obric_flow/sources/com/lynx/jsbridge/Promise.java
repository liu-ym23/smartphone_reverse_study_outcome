package com.lynx.jsbridge;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface Promise {
    @Keep
    @Deprecated
    void reject(String r5);

    @Keep
    void reject(String r5, String r10);

    @Keep
    void resolve(@Nullable Object r5);
}
