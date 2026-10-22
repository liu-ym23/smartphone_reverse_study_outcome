package com.bytedance.crash;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface IOOMCallback {
    void onCrash(@NonNull CrashType r5, @Nullable Throwable r10, @Nullable Thread r11, long r12);
}
