package com.bytedance.bdlocation.api;

import com.bytedance.bdlocation.callback.UploadCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IShakeManager extends IManager {
    void setConfig(JSONObject r8);

    void startScanTask(Object r8);

    void startShakeUpload(Object r8, String r10, JSONObject r11, UploadCallback r12);

    void stopScanTask();
}
