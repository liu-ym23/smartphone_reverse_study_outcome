package com.bytedance.crash;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface CrashUploadCallback {
    void beforeUpload(CrashType r1, JSONObject r2);
}
