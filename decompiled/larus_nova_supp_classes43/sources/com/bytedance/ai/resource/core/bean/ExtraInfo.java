package com.bytedance.ai.resource.core.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/ExtraInfo;", "", "deviceId", "", "lane", "channel", "appVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getLane", "getChannel", "getAppVersion", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExtraInfo {
    private final String appVersion;
    private final String channel;
    private final String deviceId;
    private final String lane;

    public ExtraInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ExtraInfo copy$default(ExtraInfo r0, String r1, String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r1 = r0.deviceId;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r10 = r0.lane;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r11 = r0.channel;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r12 = r0.appVersion;
    L15:
        return r0.copy(r1, r10, r11, r12);
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
        return this.appVersion;
    }

    public final ExtraInfo copy(String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "deviceId");
        return new ExtraInfo(r10, r11, r12, r13);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ExtraInfo) == true) goto L8;
        return false;
    L8:
        ExtraInfo r11 = (ExtraInfo) r10;
        if (Intrinsics.areEqual(this.deviceId, r11.deviceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lane, r11.lane) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.channel, r11.channel) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.appVersion, r11.appVersion) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = this.deviceId.hashCode() * 31;
        String r1 = this.lane;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (r0 + r11) * 31;
        String r13 = this.channel;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        String r16 = this.appVersion;
        if (r16 == null) goto L15;
        r10 = r16.hashCode();
    L15:
        return r15 + r10;
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ExtraInfo(deviceId=" + this.deviceId + ", lane=" + this.lane + ", channel=" + this.channel + ", appVersion=" + this.appVersion + ')';
    }

    public final String getAppVersion() {
        return this.appVersion;
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

    public ExtraInfo(String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "deviceId");
        this.deviceId = r10;
        this.lane = r11;
        this.channel = r12;
        this.appVersion = r13;
    }

    public /* synthetic */ ExtraInfo(String r10, String r11, String r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = "";
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r14 & 8) == 0) goto L14;
        r13 = null;
    L14:
        this(r10, r11, r12, r13);
    }
}
