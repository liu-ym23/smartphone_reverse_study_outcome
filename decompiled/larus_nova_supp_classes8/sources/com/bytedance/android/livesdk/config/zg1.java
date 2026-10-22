package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class zg1 {

    @SerializedName("allow_send_gift_to_linker")
    public boolean allowSendGiftToLinker;

    @SerializedName("audio_chat_switch")
    public boolean audioChatSwitch;

    @SerializedName("big_party_switch")
    public boolean bigPartySwitch;

    @SerializedName("intimate_chat_switch")
    public boolean intimateChatSwitch;

    public zg1() {
        this.allowSendGiftToLinker = true;
        this.intimateChatSwitch = true;
        this.bigPartySwitch = true;
        this.audioChatSwitch = true;
    }
}
