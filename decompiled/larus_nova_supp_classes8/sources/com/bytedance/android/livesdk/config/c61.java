package com.bytedance.android.livesdk.config;

import com.bytedance.bpea.entry.common.DataType;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class c61 {

    @SerializedName(DataType.AUDIO)
    public String audio;

    @SerializedName(DataType.VIDEO)
    public String video;

    public c61() {
        this.video = "表演中";
        this.audio = "演唱中";
    }
}
