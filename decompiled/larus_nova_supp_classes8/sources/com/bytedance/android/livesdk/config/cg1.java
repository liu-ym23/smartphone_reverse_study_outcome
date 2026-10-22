package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class cg1 {

    @SerializedName("enable")
    public boolean enable;

    @SerializedName("f_close")
    public boolean forceClose;

    @SerializedName("h")
    public float h;

    @SerializedName("w")
    public float w;

    @SerializedName("x")
    public float x;

    @SerializedName("y")
    public float y;

    public cg1() {
        this.enable = false;
        this.forceClose = false;
    }
}
