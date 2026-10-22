package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.util.SensitiveUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Calendar;
import java.util.TimeZone;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class LocaleLoader extends BaseLoader {
    private final Context mApp;
    private final InstallOptions mOptions;

    LocaleLoader(Context r3, InstallOptions r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super(true, true);
        this.mApp = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.mOptions = r4;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject r3) {
        Utils.putStringIfNotEmpty(r3, Api.KEY_LANGUAGE, ZeusTransformUtils.getResources(this.mApp, "com.obric.memorydata.plugin").getConfiguration().locale.getLanguage());
        int r0 = TimeZone.getDefault().getRawOffset() / 3600000;
        if (r0 >= (-12)) goto L6;
        r0 = -12;
    L6:
        if (r0 <= 12) goto L8;
        r0 = 12;
    L8:
        r3.put(Api.KEY_TIMEZONE, r0);
        Utils.putStringIfNotEmpty(r3, Api.KEY_REGION, SensitiveUtils.getCountry(this.mOptions));
        TimeZone r2 = Calendar.getInstance().getTimeZone();
        Utils.putStringIfNotEmpty(r3, Api.KEY_TZ_NAME, r2.getID());
        r3.put(Api.KEY_TZ_OFFSET, r2.getOffset(System.currentTimeMillis()) / 1000);
        return true;
    }
}
