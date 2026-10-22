package com.bytedance.bdlocation.business;

import com.bytedance.bdlocation.api.IShakeManager;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation_impl.shake.ShakeUploadCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BDShakeHelper {
    private static IShakeManager mShakeManager;

    public BDShakeHelper() {
    }

    private static IShakeManager getShakeManager() {
        if (mShakeManager != null) goto L8;
        mShakeManager = BDLocationExtrasService.getShakeManager();
        if (BDLocationConfig.getShakeConfig() == null) goto L8;
        mShakeManager.setConfig(BDLocationConfig.getShakeConfig());
    L8:
        return mShakeManager;
    }

    public static void startScanTask(Object r1) {
        getShakeManager().startScanTask(r1);
    }

    public static void startShakeUpload(Object r2, String r3, JSONObject r4, ShakeUploadCallback r5) {
        ShakeUploadCallback r6 = (ShakeUploadCallback) ZeusTransformUtils.wrapperContextForParams(r5, ShakeUploadCallback.class, "com.obric.memorydata.plugin");
        getShakeManager().startShakeUpload(r2, r3, r4, r6);
    }

    public static void stopScanTask() {
        getShakeManager().stopScanTask();
    }
}
