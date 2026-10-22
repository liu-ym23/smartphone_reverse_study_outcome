package com.bytedance.ai.bridge.remote.model;

import ai.j0;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/PrivacyCheckRequest;", "Ljava/io/Serializable;", "", "a", "Ljava/lang/String;", "getAppKey", "()Ljava/lang/String;", Constant.APPKEY, "b", "getVersionTag", "versionTag", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PrivacyCheckRequest implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(WsConstants.KEY_APP_KEY)
    private final String f2077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("version_tag")
    private final String f2078b;

    public PrivacyCheckRequest(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, Constant.APPKEY);
        this.f2077a = r5;
        this.f2078b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PrivacyCheckRequest) == true) goto L8;
        return false;
    L8:
        PrivacyCheckRequest r10 = (PrivacyCheckRequest) r5;
        if (Intrinsics.areEqual(this.f2077a, r10.f2077a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f2078b, r10.f2078b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f2077a.hashCode() * 31;
        String r10 = this.f2078b;
        if (r10 != null) goto L5;
        int r11 = 0;
    L7:
        return r5 + r11;
    L5:
        r11 = r10.hashCode();
        goto L7
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("PrivacyCheckRequest(appKey=");
        r5.append(this.f2077a);
        r5.append(", versionTag=");
        return j0.p(r5, this.f2078b, ')');
    }
}
