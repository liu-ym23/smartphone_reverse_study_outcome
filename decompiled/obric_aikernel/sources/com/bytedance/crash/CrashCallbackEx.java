package com.bytedance.crash;

import androidx.annotation.NonNull;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class CrashCallbackEx {
    public CrashCallbackEx() {
    }

    public abstract void onCrash(@NonNull int r10, @NonNull String r11, @NonNull CrashType r12, @NonNull long r13, @NonNull long r14, @NonNull String r15, @NonNull String r16, JSONObject r17, List<String> r18);
}
