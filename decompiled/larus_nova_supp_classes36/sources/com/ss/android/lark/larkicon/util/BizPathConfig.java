package com.ss.android.lark.larkicon.util;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@AppConfig(key = "ccm_custom_icon_config")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/larkicon/util/BizPathConfig;", "", "<init>", "()V", "bucketPath", "", "getBucketPath", "()Ljava/lang/String;", "setBucketPath", "(Ljava/lang/String;)V", "lark-icon_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class BizPathConfig {

    @SerializedName("bucket_path")
    private String bucketPath;

    public BizPathConfig() {
    }

    public final String a() {
        return this.bucketPath;
    }
}
