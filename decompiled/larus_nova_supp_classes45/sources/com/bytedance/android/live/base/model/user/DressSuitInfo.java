package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class DressSuitInfo {
    public static final long DefaultScene = 0;
    public static final long IsPlaceholderImage = 1;

    @SerializedName("badge")
    py.k badge;

    @SerializedName("extra")
    String extra;

    @SerializedName("name")
    String name;

    @SerializedName("scene")
    long scene;

    @SerializedName("schema")
    String schema;

    @SerializedName("suit_id")
    String suitId;

    @SerializedName("user_suit_id")
    String userSuitId;

    public DressSuitInfo() {
    }

    public py.k getBadge() {
        return this.badge;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getName() {
        return this.name;
    }

    public long getScene() {
        return this.scene;
    }

    public String getSchema() {
        return this.schema;
    }

    public String getSuitId() {
        return this.suitId;
    }

    public String getUserSuitId() {
        return this.userSuitId;
    }
}
