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
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/PrivacyAcceptRequest;", "Ljava/io/Serializable;", "", "a", "Ljava/lang/String;", "getAppKey", "()Ljava/lang/String;", Constant.APPKEY, "b", "getRequestId", Constant.REQUEST_ID, "c", "getDeviceId", "deviceId", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PrivacyAcceptRequest implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(WsConstants.KEY_APP_KEY)
    private final String f2074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("request_id")
    private final String f2075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName(WsConstants.KEY_DEVICE_ID)
    private final String f2076c;

    public PrivacyAcceptRequest(String r5) {
        Intrinsics.checkNotNullParameter(r5, Constant.APPKEY);
        Intrinsics.checkNotNullParameter(Constant.REQUEST_ID, Constant.REQUEST_ID);
        this.f2074a = r5;
        this.f2075b = Constant.REQUEST_ID;
        this.f2076c = null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PrivacyAcceptRequest) == true) goto L8;
        return false;
    L8:
        PrivacyAcceptRequest r10 = (PrivacyAcceptRequest) r5;
        if (Intrinsics.areEqual(this.f2074a, r10.f2074a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f2075b, r10.f2075b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f2076c, r10.f2076c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f2074a.hashCode() * 31;
        int r10 = a.b(this.f2075b, r5, 31);
        String r11 = this.f2076c;
        if (r11 != null) goto L5;
        int r12 = 0;
    L7:
        return r10 + r12;
    L5:
        r12 = r11.hashCode();
        goto L7
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("PrivacyAcceptRequest(appKey=");
        r5.append(this.f2074a);
        r5.append(", requestId=");
        r5.append(this.f2075b);
        r5.append(", deviceId=");
        return j0.p(r5, this.f2076c, ')');
    }
}
