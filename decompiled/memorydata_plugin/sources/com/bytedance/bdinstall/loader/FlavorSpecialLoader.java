package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.InstallOptions;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class FlavorSpecialLoader extends BaseLoader {
    FlavorSpecialLoader(Context r2, InstallOptions r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        super(false, false);
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject r1) {
        return true;
    }
}
