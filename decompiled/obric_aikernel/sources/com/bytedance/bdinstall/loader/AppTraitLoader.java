package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.intf.IAppTraitCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class AppTraitLoader extends BaseLoader {
    private final Context mContext;
    private final InstallOptions mOptions;

    AppTraitLoader(Context r10, InstallOptions r11) {
        super(true, false);
        this.mContext = r10;
        this.mOptions = r11;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    protected boolean doLoad(JSONObject r10) {
        IAppTraitCallback r11 = this.mOptions.getAppTraitCallback();
        DrLog.d("IAppTraitCallback = " + r11);
        if (r11 == null) goto L7;
        String r12 = r11.get(this.mContext);
        DrLog.d("IAppTraitCallback.get = " + r12);
        r10.put("app_trait", r12);
        return true;
    L7:
        return true;
    }
}
