package com.larus.common.account.douyin;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/larus/common/account/douyin/DouyinHeartBeatServiceImpl$AuthHeartBeatResult;", "", "accessToken", "", "<init>", "(Ljava/lang/String;)V", "getAccessToken", "()Ljava/lang/String;", "setAccessToken", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "douyinlogin_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DouyinHeartBeatServiceImpl$b {

    @SerializedName("access_token")
    private String accessToken;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof DouyinHeartBeatServiceImpl$b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.accessToken, ((DouyinHeartBeatServiceImpl$b) r4).accessToken) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        String r0 = this.accessToken;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "AuthHeartBeatResult(accessToken=" + this.accessToken + ')';
    }

    public DouyinHeartBeatServiceImpl$b() {
        this.accessToken = null;
    }

    public final String a() {
        return this.accessToken;
    }
}
