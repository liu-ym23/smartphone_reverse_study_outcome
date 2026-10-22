package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.util.SensitiveUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class SimCountryLoader extends BaseLoader {
    private final Context mApp;
    private final InstallOptions mOptions;

    SimCountryLoader(Context r4, InstallOptions r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        super(true, false);
        this.mApp = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.mOptions = r5;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject r2) {
        Utils.putStringIfNotEmpty(r2, Api.KEY_SIM_REGION, SensitiveUtils.getSimCountryIso(this.mOptions));
        return true;
    }
}
