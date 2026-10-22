package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class l {

    @IgnoreProtoFieldCheck
    @SerializedName("bottom_text")
    public String bottomText;

    @SerializedName("has_permission")
    public boolean hasPermission;

    @IgnoreProtoFieldCheck
    @SerializedName("schema")
    public String schemaJumpUrl;

    @SerializedName("toast_without_permission")
    public String toastWithoutPermission;

    public l() {
    }
}
