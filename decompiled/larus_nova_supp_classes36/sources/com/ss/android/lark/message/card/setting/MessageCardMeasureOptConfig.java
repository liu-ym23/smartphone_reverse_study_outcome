package com.ss.android.lark.message.card.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@AppConfig(key = "msg_card_measure_opt_device_config")
public class MessageCardMeasureOptConfig {

    @SerializedName("blackList")
    public List<String> blackList;

    public MessageCardMeasureOptConfig() {
    }
}
