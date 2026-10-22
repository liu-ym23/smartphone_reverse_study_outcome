package com.bytedance.bdinstall.loader;

import android.content.SharedPreferences;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.service.ServiceManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class ServerIdLoader extends BaseLoader {
    private final InstallOptions mConfig;
    private final Env mEnv;

    ServerIdLoader(InstallOptions r10, Env r11) {
        super(true, false, false);
        this.mConfig = r10;
        this.mEnv = r11;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    protected boolean doLoad(JSONObject r10) {
        SharedPreferences r11 = this.mEnv.getEnvIsolateSp(this.mConfig);
        String r12 = ((IInstallParameters) ServiceManager.getService(IInstallParameters.class, String.valueOf(this.mConfig.getAid()))).getDeviceId();
        String r13 = r11.getString("bd_did", null);
        String r14 = r11.getString("install_id", null);
        String r15 = r11.getString(Api.KEY_SSID, null);
        if (DrLog.debug() == false) goto L5;
        DrLog.d("load d=" + r12 + " i=" + r14 + " s=" + r15);
    L5:
        Utils.putStringIfNotEmpty(r10, "install_id", r14);
        Utils.putStringIfNotEmpty(r10, "device_id", r12);
        Utils.putStringIfNotEmpty(r10, Api.KEY_SSID, r15);
        Utils.putStringIfNotEmpty(r10, "bd_did", r13);
        return true;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public void remove(JSONObject r10) {
        r10.remove("bd_did");
        r10.remove("install_id");
        r10.remove(Api.KEY_SSID);
        r10.remove("device_id");
    }
}
