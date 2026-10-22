package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.Cdid;
import com.bytedance.bdinstall.InstallOptions;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class CdidLoader extends BaseLoader {
    private final InstallOptions mConfig;
    private final Context mContext;

    CdidLoader(Context r3, InstallOptions r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super(true, true);
        this.mContext = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.mConfig = r4;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject r2) {
        String r1 = Cdid.get(this.mConfig);
        if (TextUtils.isEmpty(r1) == true) goto L6;
        r2.put(Cdid.KEY_CDID, r1);
        return true;
    L6:
        return false;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public void remove(JSONObject r1) {
        super.remove(r1);
        r1.remove(Cdid.KEY_CDID);
    }
}
