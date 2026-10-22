package com.ss.android.lark.message.lynxcard.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@AppConfig(key = "messagecard_support_machine_type_config")
public class MessageCardMachineTypeConfig {

    @SerializedName("blackList")
    public List<String> blackList;

    @SerializedName("minOverallScore")
    public int minOverallScore;

    @SerializedName("whiteList")
    public List<String> whiteList;

    public MessageCardMachineTypeConfig() {
    }
}
