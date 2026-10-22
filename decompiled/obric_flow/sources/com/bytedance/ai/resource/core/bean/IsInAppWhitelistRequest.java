package com.bytedance.ai.resource.core.bean;

import ai.j0;
import androidx.annotation.Keep;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import kk.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/IsInAppWhitelistRequest;", "", "source", "", Constant.NUBIA_ACCOUNT_FIELD_USER_ID, "", "deviceId", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getSource", "()I", "getUserId", "()Ljava/lang/String;", "getDeviceId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IsInAppWhitelistRequest {

    @SerializedName(WsConstants.KEY_DEVICE_ID)
    private final String deviceId;
    private final int source;

    @SerializedName("doubao_user_id")
    private final String userId;

    public IsInAppWhitelistRequest() {
        int r5 = 0;
        String r10 = null;
        String r11 = null;
        this(r5, r10, r11, 7, null);
    }

    public static /* synthetic */ IsInAppWhitelistRequest copy$default(IsInAppWhitelistRequest r5, int r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.source;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.userId;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = r5.deviceId;
    L12:
        return r5.copy(r10, r11, r12);
    }

    public final int component1() {
        return this.source;
    }

    public final String component2() {
        return this.userId;
    }

    public final String component3() {
        return this.deviceId;
    }

    public final IsInAppWhitelistRequest copy(int r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, Constant.NUBIA_ACCOUNT_FIELD_USER_ID);
        Intrinsics.checkNotNullParameter(r11, "deviceId");
        return new IsInAppWhitelistRequest(r5, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IsInAppWhitelistRequest) == true) goto L8;
        return false;
    L8:
        IsInAppWhitelistRequest r10 = (IsInAppWhitelistRequest) r5;
        if (this.source == r10.source) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.userId, r10.userId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.deviceId, r10.deviceId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final int getSource() {
        return this.source;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int r5 = Integer.hashCode(this.source) * 31;
        int r10 = a.b(this.userId, r5, 31);
        return this.deviceId.hashCode() + r10;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("IsInAppWhitelistRequest(source=");
        r5.append(this.source);
        r5.append(", userId=");
        r5.append(this.userId);
        r5.append(", deviceId=");
        return j0.p(r5, this.deviceId, ')');
    }

    public IsInAppWhitelistRequest(int r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, Constant.NUBIA_ACCOUNT_FIELD_USER_ID);
        Intrinsics.checkNotNullParameter(r11, "deviceId");
        this.source = r5;
        this.userId = r10;
        this.deviceId = r11;
    }

    public /* synthetic */ IsInAppWhitelistRequest(int r5, String r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r5 = 0;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = "";
    L9:
        if ((r12 & 4) == 0) goto L11;
        r11 = "";
    L11:
        this(r5, r10, r11);
    }
}
