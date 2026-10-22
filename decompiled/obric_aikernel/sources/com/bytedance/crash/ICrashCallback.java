package com.bytedance.crash;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface ICrashCallback {
    void onCrash(@NonNull CrashType r10, @Nullable String r11, @Nullable Thread r12);
}
