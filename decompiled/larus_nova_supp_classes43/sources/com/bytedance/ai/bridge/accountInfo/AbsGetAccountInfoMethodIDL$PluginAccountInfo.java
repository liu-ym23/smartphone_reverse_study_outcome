package com.bytedance.ai.bridge.accountInfo;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/bridge/accountInfo/AbsGetAccountInfoMethodIDL$PluginAccountInfo;", "", BdpAwemeConstant.KEY_APP_ID, "", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getVersion", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AbsGetAccountInfoMethodIDL$PluginAccountInfo {

    @SerializedName(BdpAwemeConstant.KEY_APP_ID)
    private final String appId;

    @SerializedName("version")
    private final String version;

    public static /* synthetic */ AbsGetAccountInfoMethodIDL$PluginAccountInfo copy$default(AbsGetAccountInfoMethodIDL$PluginAccountInfo r0, String r1, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = r0.appId;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r10 = r0.version;
    L9:
        return r0.copy(r1, r10);
    }

    public final String component1() {
        return this.appId;
    }

    public final String component2() {
        return this.version;
    }

    public final AbsGetAccountInfoMethodIDL$PluginAccountInfo copy(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, BdpAwemeConstant.KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r11, "version");
        return new AbsGetAccountInfoMethodIDL$PluginAccountInfo(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AbsGetAccountInfoMethodIDL$PluginAccountInfo) == true) goto L8;
        return false;
    L8:
        AbsGetAccountInfoMethodIDL$PluginAccountInfo r11 = (AbsGetAccountInfoMethodIDL$PluginAccountInfo) r10;
        if (Intrinsics.areEqual(this.appId, r11.appId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.version, r11.version) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.appId.hashCode() * 31) + this.version.hashCode();
    }

    public String toString() {
        return "PluginAccountInfo(appId=" + this.appId + ", version=" + this.version + ')';
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getVersion() {
        return this.version;
    }

    public AbsGetAccountInfoMethodIDL$PluginAccountInfo(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, BdpAwemeConstant.KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r11, "version");
        this.appId = r10;
        this.version = r11;
    }
}
