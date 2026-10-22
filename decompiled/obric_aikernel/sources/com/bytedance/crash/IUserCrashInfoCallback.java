package com.bytedance.crash;

import androidx.annotation.Nullable;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IUserCrashInfoCallback {
    @Nullable
    Map<? extends String, ? extends String> getCrashInfo(CrashType r10, JSONObject r11);
}
