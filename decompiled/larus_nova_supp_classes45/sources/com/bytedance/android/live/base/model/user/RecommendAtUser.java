package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class RecommendAtUser implements Serializable {

    @SerializedName("cursor")
    public long cursor;

    @SerializedName("has_more")
    public boolean hasMore;

    @SerializedName("recently_at_user_list")
    public List<User> recentlyAtUsers;

    @SerializedName("user_list")
    public List<User> users;

    public RecommendAtUser() {
    }
}
