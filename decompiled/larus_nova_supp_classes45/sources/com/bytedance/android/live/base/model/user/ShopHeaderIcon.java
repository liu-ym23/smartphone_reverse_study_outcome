package com.bytedance.android.live.base.model.user;

import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class ShopHeaderIcon {

    @SerializedName("type")
    int type;

    @SerializedName(LiveSlardarConstants.EXTRA_KEY_URL)
    py.k url;

    public ShopHeaderIcon() {
    }

    public int getType() {
        return this.type;
    }

    public py.k getUrl() {
        return this.url;
    }
}
