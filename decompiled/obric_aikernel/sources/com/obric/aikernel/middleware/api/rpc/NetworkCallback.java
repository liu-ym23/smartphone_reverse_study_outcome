package com.obric.aikernel.middleware.api.rpc;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface NetworkCallback {
    void onFailed(int r10, int r11, String r12);

    void onSuccess(String r10);
}
