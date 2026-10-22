package com.bytedance.bdinstall.loader;

import android.content.SharedPreferences;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.service.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class ServerIdLoader extends BaseLoader {
    private final InstallOptions mConfig;
    private final Env mEnv;

    ServerIdLoader(InstallOptions r3, Env r4) {
        super(true, false, false);
        this.mConfig = r3;
        this.mEnv = r4;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject r15) {
        SharedPreferences r0 = this.mEnv.getEnvIsolateSp(this.mConfig);
        String r14 = ((IInstallParameters) ZeusTransformUtils.preCheckCast(ServiceManager.getService(IInstallParameters.class, String.valueOf(this.mConfig.getAid())), IInstallParameters.class, "com.obric.memorydata.plugin")).getDeviceId();
        String r3 = r0.getString("bd_did", null);
        String r5 = r0.getString("install_id", null);
        String r7 = r0.getString(Api.KEY_SSID, null);
        String r9 = r0.getString(Api.KEY_ENCRYPT_DID, null);
        String r11 = r0.getString(Api.KEY_ENCRYPT_IID, null);
        String r1 = r0.getString(Api.KEY_KLINK_EGDI, null);
        if (DrLog.debug() == false) goto L5;
        DrLog.d("load d=" + r14 + " i=" + r5 + " s=" + r7 + " eDid=" + r9 + " eIid=" + r11);
    L5:
        Utils.putStringIfNotEmpty(r15, "install_id", r5);
        Utils.putStringIfNotEmpty(r15, "device_id", r14);
        Utils.putStringIfNotEmpty(r15, Api.KEY_SSID, r7);
        Utils.putStringIfNotEmpty(r15, "bd_did", r3);
        Utils.putStringIfNotEmpty(r15, Api.KEY_ENCRYPT_DID, r9);
        Utils.putStringIfNotEmpty(r15, Api.KEY_ENCRYPT_IID, r11);
        Utils.putStringIfNotEmpty(r15, Api.KEY_KLINK_EGDI, r1);
        return true;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public void remove(JSONObject r1) {
        r1.remove("bd_did");
        r1.remove("install_id");
        r1.remove(Api.KEY_SSID);
        r1.remove("device_id");
        r1.remove(Api.KEY_ENCRYPT_DID);
        r1.remove(Api.KEY_ENCRYPT_IID);
    }
}
