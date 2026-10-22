package com.bytedance.crash.service;

import androidx.annotation.NonNull;
import com.bytedance.crash.CrashType;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface ICrashBodyExtensionDumper {
    void dump(@NonNull File r10);

    JSONObject load(CrashType r10);

    void load(@NonNull JSONObject r10, @NonNull JSONObject r11, @NonNull File r12);
}
