package com.bytedance.bdlocation_impl.shake;

import android.content.Context;
import com.bytedance.bdlocation.api.IShakeManager;
import com.bytedance.bdlocation.callback.UploadCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ShakeManager implements IShakeManager {
    public ShakeManager(Context r8) {
    }

    @Override // com.bytedance.bdlocation.api.IShakeManager
    public void setConfig(JSONObject r8) {
        BDShakeConfig.setShakeParams(r8);
    }

    @Override // com.bytedance.bdlocation.api.IShakeManager
    public void startScanTask(Object r8) {
        BDShakeConfig.startScanTask(r8);
    }

    @Override // com.bytedance.bdlocation.api.IShakeManager
    public void startShakeUpload(Object r8, String r10, JSONObject r11, UploadCallback r12) {
        BDShakeConfig.startShakeUpload(r8, r10, r11, (ShakeUploadCallback) r12);
    }

    @Override // com.bytedance.bdlocation.api.IShakeManager
    public void stopScanTask() {
        BDShakeConfig.stopScanTask();
    }
}
