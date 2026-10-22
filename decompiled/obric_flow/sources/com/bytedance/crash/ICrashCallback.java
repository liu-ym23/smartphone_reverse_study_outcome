package com.bytedance.crash;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface ICrashCallback {
    void onCrash(@NonNull CrashType r5, @Nullable String r10, @Nullable Thread r11);
}
