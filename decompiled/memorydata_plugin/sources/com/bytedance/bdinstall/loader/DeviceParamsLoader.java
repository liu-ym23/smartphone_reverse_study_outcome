package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.service.ServiceManager;
import com.bytedance.bdinstall.util.SensitiveUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DeviceParamsLoader extends BaseLoader {
    private final Context mApp;
    private final Env mEnv;
    private final InstallOptions mOption;

    DeviceParamsLoader(Context r4, InstallOptions r5, Env r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        super(false, true);
        this.mApp = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        this.mOption = r5;
        this.mEnv = r6;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject r4) {
        Utils.putStringIfNotEmpty(r4, Api.KEY_CARRIER, SensitiveUtils.getNetworkOperatorName(this.mOption));
        Utils.putStringIfNotEmpty(r4, Api.KEY_MCC_MNC, SensitiveUtils.getNetworkOperator(this.mOption));
        IInstallParameters r0 = (IInstallParameters) ZeusTransformUtils.preCheckCast(ServiceManager.getService(IInstallParameters.class, String.valueOf(this.mOption.getAid())), IInstallParameters.class, "com.obric.memorydata.plugin");
        Utils.putStringIfNotEmpty(r4, "clientudid", r0.getClientUDID());
        if (this.mEnv.isChildMode() == true) goto L5;
        Utils.putStringIfNotEmpty(r4, "openudid", r0.getOpenUdid(true));
    L5:
        return true;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public void remove(JSONObject r1) {
        super.remove(r1);
        r1.remove(Api.KEY_CARRIER);
        r1.remove(Api.KEY_MCC_MNC);
        r1.remove("clientudid");
        r1.remove("openudid");
    }
}
