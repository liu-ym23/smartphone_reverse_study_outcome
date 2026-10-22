package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.util.SensitiveUtils;
import java.util.Calendar;
import java.util.TimeZone;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class LocaleLoader extends BaseLoader {
    private final Context mApp;
    private final InstallOptions mOptions;

    LocaleLoader(Context r10, InstallOptions r11) {
        super(true, true);
        this.mApp = r10;
        this.mOptions = r11;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    protected boolean doLoad(JSONObject r10) {
        Utils.putStringIfNotEmpty(r10, Api.KEY_LANGUAGE, this.mApp.getResources().getConfiguration().locale.getLanguage());
        int r11 = TimeZone.getDefault().getRawOffset() / 3600000;
        if (r11 >= (-12)) goto L6;
        r11 = -12;
    L6:
        if (r11 <= 12) goto L8;
        r11 = 12;
    L8:
        r10.put(Api.KEY_TIMEZONE, r11);
        Utils.putStringIfNotEmpty(r10, Api.KEY_REGION, SensitiveUtils.getCountry(this.mOptions));
        TimeZone r12 = Calendar.getInstance().getTimeZone();
        Utils.putStringIfNotEmpty(r10, Api.KEY_TZ_NAME, r12.getID());
        r10.put(Api.KEY_TZ_OFFSET, r12.getOffset(System.currentTimeMillis()) / 1000);
        return true;
    }
}
