package com.bytedance.bdlocation.provider;

import com.bytedance.bdlocation.api.IShakeManager;
import com.bytedance.bdlocation.callback.UploadCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DefaultShakeProvider implements IShakeManager {
    public DefaultShakeProvider() {
    }

    @Override // com.bytedance.bdlocation.api.IShakeManager
    public void setConfig(JSONObject r8) {
    }

    @Override // com.bytedance.bdlocation.api.IShakeManager
    public void startScanTask(Object r8) {
    }

    @Override // com.bytedance.bdlocation.api.IShakeManager
    public void startShakeUpload(Object r8, String r10, JSONObject r11, UploadCallback r12) {
    }

    @Override // com.bytedance.bdlocation.api.IShakeManager
    public void stopScanTask() {
    }
}
