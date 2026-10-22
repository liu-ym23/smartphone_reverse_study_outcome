package com.bytedance.android.live.base.model;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class Extra {

    @IgnoreProtoFieldCheck
    @SerializedName("has_more")
    public boolean hasMore;

    @IgnoreProtoFieldCheck
    @SerializedName("now")
    public long now;

    public Extra() {
    }
}
