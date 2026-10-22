package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.Utils;
import com.bytedance.common.utility.NetworkUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class NetLoader extends BaseLoader {
    private final Context mApp;

    NetLoader(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super(true, true);
        this.mApp = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject r2) {
        Utils.putStringIfNotEmpty(r2, Api.KEY_ACCESS, NetworkUtils.f(this.mApp));
        return true;
    }
}
