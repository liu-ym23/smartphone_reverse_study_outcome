package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.bytedance.bdinstall.Api;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AppKeyLoader extends BaseLoader {
    private Context mContext;

    AppKeyLoader(Context r10) {
        super(true, false);
        this.mContext = r10;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    protected boolean doLoad(JSONObject r10) {
        String r11 = this.mContext.getPackageName();
        Bundle r12 = this.mContext.getPackageManager().getApplicationInfo(r11, 128).metaData;     // Catch: PackageManager.NameNotFoundException -> L7
        if (r12 == null) goto L13;
        r10.put(Api.KEY_APPKEY, r12.getString("UMENG_APPKEY"));     // Catch: PackageManager.NameNotFoundException -> L7
        return true;
    L13:
        return true;
    L7:
        e = move-exception;
        e.printStackTrace();
        return true;
    }
}
