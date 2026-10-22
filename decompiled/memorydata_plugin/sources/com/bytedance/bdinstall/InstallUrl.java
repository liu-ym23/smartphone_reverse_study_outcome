package com.bytedance.bdinstall;

import android.text.TextUtils;
import com.bytedance.bdinstall.util.Constants;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class InstallUrl implements Cloneable {
    private final String mUriActive;
    private final String mUriRegister;
    private String mUriVerify;

    public InstallUrl(String r2, String r3) {
        this.mUriVerify = "";
        this.mUriRegister = forceHttpsUrl(r2);
        this.mUriActive = forceHttpsUrl(r3);
    }

    public InstallUrl(String r2, String r3, String r4) {
        this.mUriVerify = "";
        this.mUriRegister = forceHttpsUrl(r2);
        this.mUriActive = forceHttpsUrl(r3);
        this.mUriVerify = forceHttpsUrl(r4);
    }

    public static InstallUrl createUriByDomain(String r1) {
        return createUriByDomain(r1, false);
    }

    public static InstallUrl createUriByDomain(String r3, boolean r4) {
        String r0 = r3 + Constants.PATH_REGISTER;
        String r1 = r3 + Constants.PATH_ACTIVATE;
        if (r4 == false) goto L7;
        return new InstallUrl(r0, r1, r3 + Constants.PATH_VERIFY);
    L7:
        return new InstallUrl(r0, r1);
    }

    private String forceHttpsUrl(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L9:
        return r1;
    L5:
        if (r1.startsWith(LocationInfoConst.HTTPS) == true) goto L9;
        throw new IllegalArgumentException("url protocol should be https");
    }

    public boolean equals(Object r7) {
        if (r7 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, InstallUrl.class) == true) goto L8;
        return false;
    L8:
        if (TextUtils.equals(this.mUriActive, ((InstallUrl) ZeusTransformUtils.preCheckCast(r7, InstallUrl.class, "com.obric.memorydata.plugin")).mUriActive) == false) goto L15;
        if (TextUtils.equals(this.mUriRegister, ((InstallUrl) ZeusTransformUtils.preCheckCast(r7, InstallUrl.class, "com.obric.memorydata.plugin")).mUriRegister) == false) goto L15;
        if (TextUtils.equals(this.mUriVerify, ((InstallUrl) ZeusTransformUtils.preCheckCast(r7, InstallUrl.class, "com.obric.memorydata.plugin")).mUriVerify) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public String getActiveUri() {
        return this.mUriActive;
    }

    public String getRegisterUri() {
        return this.mUriRegister;
    }

    public String getVerifyUri() {
        return this.mUriVerify;
    }

    public String toString() {
        return "{r='" + this.mUriRegister + "', a='" + this.mUriActive + "', v='" + this.mUriVerify + "'}";
    }
}
