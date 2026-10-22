package com.bytedance.android.live.base.model.media;

import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class b {

    @SerializedName("height")
    private int height;

    @SerializedName(LiveSlardarConstants.EXTRA_KEY_URL)
    private String url;

    @SerializedName("width")
    private int width;

    public b() {
    }
}
