package com.bytedance.android.livesdk.interactivity.api.chatchannel.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class ChannelInviteMessageItem {
    public static final int TYPE_GROUP = 2;
    public static final int TYPE_USER = 1;

    @SerializedName("id")
    public long id;

    @SerializedName("name")
    public String name;

    @SerializedName("type")
    public int type;

    public ChannelInviteMessageItem() {
    }
}
