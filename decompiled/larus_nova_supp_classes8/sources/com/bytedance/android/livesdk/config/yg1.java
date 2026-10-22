package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class yg1 {

    @SerializedName("intro_scheme")
    public String introScheme;

    @SerializedName("ranklist_scheme")
    public String rangListScheme;

    @SerializedName("record_scheme")
    public String recordScheme;

    @SerializedName("record_url")
    public String recordUrl;

    @SerializedName("record_url_v2")
    public String recordUrlV2;

    public yg1() {
        this.introScheme = "";
        this.recordScheme = "";
        this.recordUrlV2 = "";
        this.recordUrl = "";
        this.rangListScheme = "";
    }
}
