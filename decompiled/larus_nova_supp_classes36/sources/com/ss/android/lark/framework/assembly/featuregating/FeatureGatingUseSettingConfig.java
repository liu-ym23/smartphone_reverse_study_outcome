package com.ss.android.lark.framework.assembly.featuregating;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@AppConfig(key = "fg_use_config")
public class FeatureGatingUseSettingConfig implements Serializable {

    @SerializedName("fg_keys_capacity")
    public int fgKeyCapacity;

    @SerializedName("fg_memory_limit")
    public int fgMemoryLimit;

    public FeatureGatingUseSettingConfig() {
        this.fgKeyCapacity = 10;
        this.fgMemoryLimit = 50;
    }
}
