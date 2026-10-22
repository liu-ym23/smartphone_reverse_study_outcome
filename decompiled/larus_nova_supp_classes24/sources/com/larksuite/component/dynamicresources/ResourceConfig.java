package com.larksuite.component.dynamicresources;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@AppConfig(key = "npth_optimization")
public class ResourceConfig {

    @SerializedName("enable_dynamic_resource")
    public boolean enableFixResource;

    public ResourceConfig() {
        this.enableFixResource = true;
    }

    public boolean enableFixResource() {
        return this.enableFixResource;
    }
}
