package com.bytedance.privacy.pcc;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class AppInfo {

    @SerializedName("app_id")
    public final String appId;

    @SerializedName("app_svc_id")
    public final String appSvcId;
    public final String rpdid;
    public final String rpuid;

    public AppInfo(String r1, String r2, String r3, String r4) {
        this.rpdid = r1;
        this.rpuid = r2;
        this.appId = r3;
        this.appSvcId = r4;
    }

    public String toJsonString() {
        return new Gson().toJson(this);
    }

    public String toString() {
        return toJsonString();
    }
}
