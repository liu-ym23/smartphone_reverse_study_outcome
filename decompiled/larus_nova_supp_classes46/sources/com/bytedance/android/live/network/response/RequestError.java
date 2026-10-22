package com.bytedance.android.live.network.response;

import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class RequestError {

    @SerializedName("alert")
    public String alert;
    private transient boolean blockNotice;

    @SerializedName(MultiLinkOpenSource.MESSAGE)
    public String message;

    @SerializedName("prompts")
    public String prompts;
    public transient String url;

    public RequestError() {
        this.prompts = "操作失败, 请稍后重试";
    }

    public boolean isBlockNotice() {
        return this.blockNotice;
    }

    public void setBlockNotice(boolean r1) {
        this.blockNotice = r1;
    }
}
