package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.util.SensitiveUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class SimCountryLoader extends BaseLoader {
    private final Context mApp;
    private final InstallOptions mOptions;

    SimCountryLoader(Context r10, InstallOptions r11) {
        super(true, false);
        this.mApp = r10;
        this.mOptions = r11;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    protected boolean doLoad(JSONObject r10) {
        Utils.putStringIfNotEmpty(r10, Api.KEY_SIM_REGION, SensitiveUtils.getSimCountryIso(this.mOptions));
        return true;
    }
}
