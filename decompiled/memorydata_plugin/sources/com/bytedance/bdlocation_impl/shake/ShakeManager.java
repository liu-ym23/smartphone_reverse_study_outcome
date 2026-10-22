package com.bytedance.bdlocation_impl.shake;

import android.content.Context;
import com.bytedance.bdlocation.api.IShakeManager;
import com.bytedance.bdlocation.callback.UploadCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ShakeManager implements IShakeManager {
    public ShakeManager(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.bdlocation.api.IShakeManager
    public void setConfig(JSONObject r1) {
        BDShakeConfig.setShakeParams(r1);
    }

    @Override // com.bytedance.bdlocation.api.IShakeManager
    public void startScanTask(Object r1) {
        BDShakeConfig.startScanTask(r1);
    }

    @Override // com.bytedance.bdlocation.api.IShakeManager
    public void startShakeUpload(Object r2, String r3, JSONObject r4, UploadCallback r5) {
        BDShakeConfig.startShakeUpload(r2, r3, r4, (ShakeUploadCallback) ZeusTransformUtils.preCheckCast((UploadCallback) ZeusTransformUtils.wrapperContextForParams(r5, UploadCallback.class, "com.obric.memorydata.plugin"), ShakeUploadCallback.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bytedance.bdlocation.api.IShakeManager
    public void stopScanTask() {
        BDShakeConfig.stopScanTask();
    }
}
