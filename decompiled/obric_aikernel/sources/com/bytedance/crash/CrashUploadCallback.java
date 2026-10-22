package com.bytedance.crash;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface CrashUploadCallback {
    void beforeUpload(CrashType r10, JSONObject r11);
}
