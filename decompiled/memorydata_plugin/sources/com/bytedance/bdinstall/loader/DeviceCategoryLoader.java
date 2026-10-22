package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.InstallOptions;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class DeviceCategoryLoader extends BaseLoader {
    private final InstallOptions mOptions;

    DeviceCategoryLoader(Context r3, InstallOptions r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super(true, true);
        this.mOptions = r4;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject r2) {
        r2.put(Api.KEY_DEVICE_CATEGORY, this.mOptions.getDeviceCategory());     // Catch: JSONException -> L5
        return true;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
