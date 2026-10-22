package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class t1 {

    @SerializedName("enable_remain_priority")
    public boolean enablePriority;

    @SerializedName("remain_priority_map")
    public Map<String, Integer> remainPriorityMap;

    public t1() {
        this.enablePriority = true;
    }
}
