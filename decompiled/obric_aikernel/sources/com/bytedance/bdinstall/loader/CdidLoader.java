package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.Cdid;
import com.bytedance.bdinstall.InstallOptions;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class CdidLoader extends BaseLoader {
    private final InstallOptions mConfig;
    private final Context mContext;

    CdidLoader(Context r10, InstallOptions r11) {
        super(true, true);
        this.mContext = r10;
        this.mConfig = r11;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    protected boolean doLoad(JSONObject r10) {
        String r11 = Cdid.get(this.mConfig);
        if (TextUtils.isEmpty(r11) == true) goto L6;
        r10.put(Cdid.KEY_CDID, r11);
        return true;
    L6:
        return false;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public void remove(JSONObject r10) {
        super.remove(r10);
        r10.remove(Cdid.KEY_CDID);
    }
}
