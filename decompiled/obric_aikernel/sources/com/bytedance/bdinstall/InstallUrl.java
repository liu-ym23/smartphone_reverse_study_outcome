package com.bytedance.bdinstall;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class InstallUrl implements Cloneable {
    private final String mUriActive;
    private final String mUriRegister;

    public InstallUrl(String r10, String r11) {
        this.mUriRegister = forceHttpsUrl(r10);
        this.mUriActive = forceHttpsUrl(r11);
    }

    public static InstallUrl createUriByDomain(String r10) {
        return new InstallUrl(r10 + "/service/2/device_register/", r10 + "/service/2/app_alert_check/");
    }

    private String forceHttpsUrl(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L9:
        return r10;
    L5:
        if (r10.startsWith("https") == true) goto L9;
        throw new IllegalArgumentException("url protocol should be https");
    }

    public boolean equals(@Nullable Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof InstallUrl) == false) goto L14;
        InstallUrl r11 = (InstallUrl) r10;
        if (TextUtils.equals(this.mUriActive, r11.mUriActive) == false) goto L13;
        if (TextUtils.equals(this.mUriRegister, r11.mUriRegister) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public String getActiveUri() {
        return this.mUriActive;
    }

    public String getRegisterUri() {
        return this.mUriRegister;
    }

    public String toString() {
        return "{r='" + this.mUriRegister + "', a='" + this.mUriActive + "'}";
    }
}
