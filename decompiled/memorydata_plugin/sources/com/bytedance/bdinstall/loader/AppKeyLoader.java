package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.DrLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AppKeyLoader extends BaseLoader {
    private Context mContext;

    AppKeyLoader(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        super(true, false);
        this.mContext = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject r3) {
        String r0 = this.mContext.getPackageName();
        Bundle r2 = this.mContext.getPackageManager().getApplicationInfo(r0, 128).metaData;     // Catch: Exception -> L7
        if (r2 == null) goto L13;
        r3.put(Api.KEY_APPKEY, r2.getString("UMENG_APPKEY"));     // Catch: Exception -> L7
        return true;
    L13:
        return true;
    L7:
        e = move-exception;
        DrLog.e("getApplicationInfo error", e);
        return true;
    }
}
