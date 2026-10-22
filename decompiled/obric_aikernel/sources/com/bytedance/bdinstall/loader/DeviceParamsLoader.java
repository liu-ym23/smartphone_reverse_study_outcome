package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.service.ServiceManager;
import com.bytedance.bdinstall.util.SensitiveUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DeviceParamsLoader extends BaseLoader {
    private final Context mApp;
    private final Env mEnv;
    private final InstallOptions mOption;

    DeviceParamsLoader(Context r10, InstallOptions r11, Env r12) {
        super(false, true);
        this.mApp = r10;
        this.mOption = r11;
        this.mEnv = r12;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    protected boolean doLoad(JSONObject r10) {
        Utils.putStringIfNotEmpty(r10, Api.KEY_CARRIER, SensitiveUtils.getNetworkOperatorName(this.mOption));
        Utils.putStringIfNotEmpty(r10, Api.KEY_MCC_MNC, SensitiveUtils.getNetworkOperator(this.mOption));
        IInstallParameters r11 = (IInstallParameters) ServiceManager.getService(IInstallParameters.class, String.valueOf(this.mOption.getAid()));
        Utils.putStringIfNotEmpty(r10, "clientudid", r11.getClientUDID());
        if (this.mEnv.isChildMode() == true) goto L5;
        Utils.putStringIfNotEmpty(r10, "openudid", r11.getOpenUdid(true));
    L5:
        return true;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public void remove(JSONObject r10) {
        super.remove(r10);
        r10.remove(Api.KEY_CARRIER);
        r10.remove(Api.KEY_MCC_MNC);
        r10.remove("clientudid");
        r10.remove("openudid");
    }
}
