package com.larksuite.component.card.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@AppConfig(key = "msgcard_img_memory_opt_device_config")
public class MsgCardImgMemoryOptConfig {

    @SerializedName("blackList")
    public List<String> blackList;

    @SerializedName("maxScreenWidthForThumb")
    public int maxScreenWidthForThumb;

    @SerializedName("minOverallScore")
    public int minOverallScore;

    @SerializedName("whiteList")
    public List<String> whiteList;

    public MsgCardImgMemoryOptConfig() {
    }
}
