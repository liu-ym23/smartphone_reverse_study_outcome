package com.bytedance.android.live.broadcast.api.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/AnchorResolutionInfo;", "", "()V", "isDownGrade", "", "()Z", "setDownGrade", "(Z)V", "key", "", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "sdkParams", "getSdkParams", "setSdkParams", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorResolutionInfo {

    @SerializedName("wnable_downgrade")
    private boolean isDownGrade;

    @SerializedName("key")
    private String key;

    @SerializedName("sdk_params")
    private String sdkParams;

    public AnchorResolutionInfo() {
        this.sdkParams = "";
        this.key = "";
    }

    public final String getKey() {
        return this.key;
    }

    public final String getSdkParams() {
        return this.sdkParams;
    }

    public final boolean isDownGrade() {
        return this.isDownGrade;
    }

    public final void setDownGrade(boolean r1) {
        this.isDownGrade = r1;
    }

    public final void setKey(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.key = r2;
    }

    public final void setSdkParams(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.sdkParams = r2;
    }
}
