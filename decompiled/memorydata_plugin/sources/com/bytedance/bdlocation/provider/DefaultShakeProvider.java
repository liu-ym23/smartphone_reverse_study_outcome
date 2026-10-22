package com.bytedance.bdlocation.provider;

import com.bytedance.bdlocation.api.IShakeManager;
import com.bytedance.bdlocation.callback.UploadCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DefaultShakeProvider implements IShakeManager {
    public DefaultShakeProvider() {
    }

    @Override // com.bytedance.bdlocation.api.IShakeManager
    public void setConfig(JSONObject r1) {
    }

    @Override // com.bytedance.bdlocation.api.IShakeManager
    public void startScanTask(Object r1) {
    }

    @Override // com.bytedance.bdlocation.api.IShakeManager
    public void startShakeUpload(Object r1, String r2, JSONObject r3, UploadCallback r4) {
        UploadCallback r0 = (UploadCallback) ZeusTransformUtils.wrapperContextForParams(r4, UploadCallback.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.bdlocation.api.IShakeManager
    public void stopScanTask() {
    }
}
