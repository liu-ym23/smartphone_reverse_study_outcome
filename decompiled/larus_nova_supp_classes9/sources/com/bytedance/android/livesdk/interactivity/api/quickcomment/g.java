package com.bytedance.android.livesdk.interactivity.api.quickcomment;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class g {

    @SerializedName("color")
    public String backgroundColor;

    @SerializedName("hint")
    public String commentTips;

    @SerializedName("chat_support_type")
    public int commentType;

    @SerializedName("fast_chat_switch")
    public boolean fastChatSwitch;

    @SerializedName("toast")
    public String fixCommentToast;

    @SerializedName("fast_chat")
    public List<String> supportComments;

    public g() {
    }
}
