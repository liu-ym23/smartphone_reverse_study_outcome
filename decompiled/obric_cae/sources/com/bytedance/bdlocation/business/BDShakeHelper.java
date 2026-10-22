package com.bytedance.bdlocation.business;

import com.bytedance.bdlocation.api.IShakeManager;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation_impl.shake.ShakeUploadCallback;
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

    public static void startScanTask(Object r8) {
        getShakeManager().startScanTask(r8);
    }

    public static void startShakeUpload(Object r8, String r10, JSONObject r11, ShakeUploadCallback r12) {
        getShakeManager().startShakeUpload(r8, r10, r11, r12);
    }

    public static void stopScanTask() {
        getShakeManager().stopScanTask();
    }
}
