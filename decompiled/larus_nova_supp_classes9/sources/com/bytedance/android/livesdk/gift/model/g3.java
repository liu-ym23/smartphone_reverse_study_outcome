package com.bytedance.android.livesdk.gift.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class g3 {

    @SerializedName("diamond_rushed")
    public int diamondRushed;

    @SerializedName("expired")
    public boolean expired;

    @SerializedName("result")
    public boolean result;

    @SerializedName("rushed_users")
    public List<com.bytedance.android.livesdk.chatroom.model.i3> rushedList;

    public g3() {
    }
}
