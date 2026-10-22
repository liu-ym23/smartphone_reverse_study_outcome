package com.bytedance.android.live.base.model.media;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class MediaRecommendReason {
    public static final int TYPE_FRIENDSHIP = 2;
    public static final int TYPE_LOCATION = 1;

    @SerializedName("city")
    private String city;

    @SerializedName("friend_name")
    private String friendName;

    @SerializedName("reason")
    private String reason;

    @SerializedName("type")
    private int type;

    public MediaRecommendReason() {
    }

    public String getCity() {
        return this.city;
    }

    public String getFriendName() {
        return this.friendName;
    }

    public String getReason() {
        return this.reason;
    }

    public int getType() {
        return this.type;
    }

    public void setCity(String r1) {
        this.city = r1;
    }

    public void setFriendName(String r1) {
        this.friendName = r1;
    }

    public void setReason(String r1) {
        this.reason = r1;
    }

    public void setType(int r1) {
        this.type = r1;
    }
}
