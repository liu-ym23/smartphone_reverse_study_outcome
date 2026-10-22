package com.bytedance.android.live.saas.middleware.utils;

import android.content.Context;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.IAppInfo;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import eta.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class AppContextWrapper implements b {
    private final IAppInfo appInfo;
    private Context context;

    public String getAbClient() {
        return "";
    }

    public String getAbFeature() {
        return "";
    }

    public long getAbFlag() {
        return 0;
    }

    public String getAbGroup() {
        return "";
    }

    public String getAbVersion() {
        return "";
    }

    public String getFeedbackAppKey() {
        return "";
    }

    public String getManifestVersion() {
        return "1.0.0";
    }

    public int getManifestVersionCode() {
        return 0;
    }

    public int getAid() {
        return CastIntegerProtector.parseInt(this.appInfo.hostAppId());
    L4:
        return 0;
    }

    public String getAppName() {
        return this.appInfo.appName();
    }

    public String getChannel() {
        return this.appInfo.channel();
    }

    public String getStringAppName() {
        return this.appInfo.appName();
    }

    public String getTweakedChannel() {
        return this.appInfo.channel();
    }

    public int getUpdateVersionCode() {
        return this.appInfo.updateVersionCode();
    }

    public String getVersion() {
        return this.appInfo.versionName();
    }

    public int getVersionCode() {
        return this.appInfo.versionCode();
    }

    public String getDeviceId() {
        return BDLiveSdk.appLog().getDid();
    }

    public Context getContext() {
        return this.context;
    }

    public AppContextWrapper(Context r1, IAppInfo r2) {
        this.context = r1;
        this.appInfo = r2;
    }
}
