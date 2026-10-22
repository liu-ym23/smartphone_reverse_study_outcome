package com.bytedance.ai.bridge.remote.model;

import ai.j0;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kk.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/ExchangeCodeRequest;", "Ljava/io/Serializable;", "", "a", "Ljava/lang/String;", "getAppKey", "()Ljava/lang/String;", Constant.APPKEY, "b", "getCode", "code", "c", "getDeviceId", "deviceId", "d", "getVersionTag", "versionTag", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExchangeCodeRequest implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(WsConstants.KEY_APP_KEY)
    private final String f2071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("code")
    private final String f2072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName(WsConstants.KEY_DEVICE_ID)
    private final String f2073c;

    @SerializedName("version_tag")
    private final String d;

    public ExchangeCodeRequest(String r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, Constant.APPKEY);
        Intrinsics.checkNotNullParameter(r10, "code");
        Intrinsics.checkNotNullParameter(r11, "versionTag");
        this.f2071a = r5;
        this.f2072b = r10;
        this.f2073c = null;
        this.d = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ExchangeCodeRequest) == true) goto L8;
        return false;
    L8:
        ExchangeCodeRequest r10 = (ExchangeCodeRequest) r5;
        if (Intrinsics.areEqual(this.f2071a, r10.f2071a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f2072b, r10.f2072b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f2073c, r10.f2073c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f2071a.hashCode() * 31;
        int r10 = a.b(this.f2072b, r5, 31);
        String r11 = this.f2073c;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = this.d.hashCode();
        return r13 + ((r10 + r12) * 31);
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("ExchangeCodeRequest(appKey=");
        r5.append(this.f2071a);
        r5.append(", code=");
        r5.append(this.f2072b);
        r5.append(", deviceId=");
        r5.append(this.f2073c);
        r5.append(", versionTag=");
        return j0.p(r5, this.d, ')');
    }
}
