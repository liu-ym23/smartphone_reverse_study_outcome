package com.bytedance.crash;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface IOOMCallback {
    void onCrash(@NonNull CrashType r10, @Nullable Throwable r11, @Nullable Thread r12, long r13);
}
