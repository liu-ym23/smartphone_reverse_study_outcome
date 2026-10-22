package com.bytedance.crash;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface IANRCallback {
    void onCrash(@Nullable String r10, @Nullable Thread r11, @Nullable String r12);
}
