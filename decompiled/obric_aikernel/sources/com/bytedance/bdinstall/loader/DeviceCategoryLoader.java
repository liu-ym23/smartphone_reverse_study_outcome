package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.InstallOptions;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class DeviceCategoryLoader extends BaseLoader {
    private final InstallOptions mOptions;

    DeviceCategoryLoader(Context r10, InstallOptions r11) {
        super(true, true);
        this.mOptions = r11;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    protected boolean doLoad(JSONObject r10) {
        r10.put(Api.KEY_DEVICE_CATEGORY, this.mOptions.getDeviceCategory());     // Catch: JSONException -> L5
        return true;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
