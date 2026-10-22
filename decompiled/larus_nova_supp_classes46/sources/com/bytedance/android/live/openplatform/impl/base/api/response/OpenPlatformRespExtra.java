package com.bytedance.android.live.openplatform.impl.base.api.response;

import com.bytedance.android.live.base.model.Extra;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class OpenPlatformRespExtra extends Extra {

    @SerializedName("control_content_msg")
    public String controlContentMsg;

    @SerializedName("errcode")
    public int errorCode;

    @SerializedName("errmsg")
    public String errorMsg;
    public String requestUrl;

    @SerializedName("shark_code")
    public int sharkCode;

    public OpenPlatformRespExtra() {
        this.errorCode = 0;
        this.errorMsg = "";
        this.sharkCode = 0;
    }
}
