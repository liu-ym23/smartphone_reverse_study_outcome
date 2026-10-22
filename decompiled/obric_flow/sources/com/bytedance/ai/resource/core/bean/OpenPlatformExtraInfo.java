package com.bytedance.ai.resource.core.bean;

import ai.j0;
import androidx.annotation.Keep;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/OpenPlatformExtraInfo;", "", "deviceId", "", "lane", LynxMonitorService.KEY_CHANNEL, "parentAppVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getLane", "getChannel", "getParentAppVersion", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OpenPlatformExtraInfo {
    private final String channel;

    @SerializedName(WsConstants.KEY_DEVICE_ID)
    private final String deviceId;

    @SerializedName("land")
    private final String lane;

    @SerializedName("parent_app_version")
    private final String parentAppVersion;

    public OpenPlatformExtraInfo() {
        String r5 = null;
        String r10 = null;
        String r11 = null;
        String r12 = null;
        this(r5, r10, r11, r12, 15, null);
    }

    public static /* synthetic */ OpenPlatformExtraInfo copy$default(OpenPlatformExtraInfo r5, String r10, String r11, String r12, String r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = r5.deviceId;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = r5.lane;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = r5.channel;
    L12:
        if ((r14 & 8) == 0) goto L15;
        r13 = r5.parentAppVersion;
    L15:
        return r5.copy(r10, r11, r12, r13);
    }

    public final String component1() {
        return this.deviceId;
    }

    public final String component2() {
        return this.lane;
    }

    public final String component3() {
        return this.channel;
    }

    public final String component4() {
        return this.parentAppVersion;
    }

    public final OpenPlatformExtraInfo copy(String r5, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r5, "deviceId");
        return new OpenPlatformExtraInfo(r5, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OpenPlatformExtraInfo) == true) goto L8;
        return false;
    L8:
        OpenPlatformExtraInfo r10 = (OpenPlatformExtraInfo) r5;
        if (Intrinsics.areEqual(this.deviceId, r10.deviceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lane, r10.lane) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.channel, r10.channel) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.parentAppVersion, r10.parentAppVersion) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getLane() {
        return this.lane;
    }

    public final String getParentAppVersion() {
        return this.parentAppVersion;
    }

    public int hashCode() {
        int r5 = this.deviceId.hashCode() * 31;
        String r10 = this.lane;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r5 + r12) * 31;
        String r14 = this.channel;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.parentAppVersion;
        if (r17 == null) goto L15;
        r11 = r17.hashCode();
    L15:
        return r16 + r11;
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("OpenPlatformExtraInfo(deviceId=");
        r5.append(this.deviceId);
        r5.append(", lane=");
        r5.append(this.lane);
        r5.append(", channel=");
        r5.append(this.channel);
        r5.append(", parentAppVersion=");
        return j0.p(r5, this.parentAppVersion, ')');
    }

    public OpenPlatformExtraInfo(String r5, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r5, "deviceId");
        this.deviceId = r5;
        this.lane = r10;
        this.channel = r11;
        this.parentAppVersion = r12;
    }

    public /* synthetic */ OpenPlatformExtraInfo(String r5, String r10, String r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r5 = "";
    L6:
        if ((r13 & 2) == 0) goto L9;
        r10 = null;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r11 = null;
    L12:
        if ((r13 & 8) == 0) goto L14;
        r12 = null;
    L14:
        this(r5, r10, r11, r12);
    }
}
