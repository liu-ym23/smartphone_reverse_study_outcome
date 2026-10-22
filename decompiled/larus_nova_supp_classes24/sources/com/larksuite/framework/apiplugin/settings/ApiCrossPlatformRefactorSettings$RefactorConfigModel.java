package com.larksuite.framework.apiplugin.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@AppConfig(key = "api_crossplatform_refactor")
public class ApiCrossPlatformRefactorSettings$RefactorConfigModel {

    @SerializedName("enable_features")
    public Set<String> enableFeatures;

    public ApiCrossPlatformRefactorSettings$RefactorConfigModel() {
    }

    public final String toString() {
        return "RefactorConfigModel{enableFeatures=" + this.enableFeatures + '}';
    }
}
