package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class f {

    @SerializedName("monitor_carnival_model")
    public boolean monitorCarnivalModel;

    @SerializedName("monitor_open_contour")
    public boolean monitorOpenContour;

    @SerializedName("monitor_privilege_show")
    public boolean monitorPrivilegeShow;

    @SerializedName("monitor_sei")
    public boolean monitorSei;

    public f() {
        this.monitorPrivilegeShow = true;
        this.monitorCarnivalModel = true;
        this.monitorOpenContour = true;
        this.monitorSei = true;
    }
}
