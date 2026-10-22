package com.bytedance.bdinstall.util;

import android.text.TextUtils;
import com.bytedance.bdinstall.AppContext;
import com.bytedance.bdinstall.InstallOptions;

/* JADX INFO: loaded from: classes.dex */
public class OptionsForCommonParamProxy {
    private AppContext mAppContext;
    private InstallOptions mOptions;

    public OptionsForCommonParamProxy(AppContext r10) {
        this.mAppContext = r10;
    }

    public OptionsForCommonParamProxy(InstallOptions r10) {
        this.mOptions = r10;
    }

    public long getAid() {
        InstallOptions r10 = this.mOptions;
        if (r10 == null) goto L7;
        int r11 = r10.getAid();
    L6:
        return r11;
    L7:
        AppContext r12 = this.mAppContext;
        if (r12 == null) goto L10;
        r11 = r12.getAid();
        goto L6
    L10:
        return 0;
    }

    public String getAppName() {
        InstallOptions r10 = this.mOptions;
        if (r10 != null) goto L5;
        AppContext r11 = this.mAppContext;
        if (r11 != null) goto L9;
        return null;
    L9:
        return r11.getAppName();
    L5:
        return r10.getAppName();
    }

    public String getChannel() {
        InstallOptions r10 = this.mOptions;
        if (r10 == null) goto L7;
        String r11 = r10.getTweakedChannel();
        if (TextUtils.isEmpty(r11) == true) goto L15;
        return r11;
    L15:
        return this.mOptions.getChannel();
    L7:
        AppContext r12 = this.mAppContext;
        if (r12 == null) goto L12;
        String r13 = r12.getTweakedChannel();
        if (TextUtils.isEmpty(r13) == true) goto L17;
        return r13;
    L17:
        return this.mAppContext.getChannel();
    L12:
        return null;
    }

    public long getManifestVersionCode() {
        InstallOptions r10 = this.mOptions;
        if (r10 != null) goto L5;
        AppContext r11 = this.mAppContext;
        if (r11 != null) goto L9;
        return 0;
    L9:
        return r11.getManifestVersionCode();
    L5:
        return r10.getManifestVersionCode();
    }

    public long getUpdateVersionCode() {
        InstallOptions r10 = this.mOptions;
        if (r10 != null) goto L5;
        AppContext r11 = this.mAppContext;
        if (r11 != null) goto L9;
        return 0;
    L9:
        return r11.getUpdateVersionCode();
    L5:
        return r10.getUpdateVersionCode();
    }

    public String getVersion() {
        InstallOptions r10 = this.mOptions;
        if (r10 != null) goto L5;
        AppContext r11 = this.mAppContext;
        if (r11 != null) goto L9;
        return null;
    L9:
        return r11.getVersion();
    L5:
        return r10.getVersion();
    }

    public long getVersionCode() {
        InstallOptions r10 = this.mOptions;
        if (r10 != null) goto L5;
        AppContext r11 = this.mAppContext;
        if (r11 != null) goto L9;
        return 0;
    L9:
        return r11.getVersionCode();
    L5:
        return r10.getVersionCode();
    }
}
