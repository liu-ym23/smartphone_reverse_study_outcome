package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.intf.IAppTraitCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class AppTraitLoader extends BaseLoader {
    private final Context mContext;
    private final InstallOptions mOptions;

    AppTraitLoader(Context r4, InstallOptions r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        super(true, false);
        this.mContext = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.mOptions = r5;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject r4) {
        IAppTraitCallback r0 = this.mOptions.getAppTraitCallback();
        DrLog.d("IAppTraitCallback = " + r0);
        if (r0 == null) goto L7;
        String r3 = r0.get(this.mContext);
        DrLog.d("IAppTraitCallback.get = " + r3);
        r4.put("app_trait", r3);
        return true;
    L7:
        return true;
    }
}
