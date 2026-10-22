package com.bytedance.android.live.saas.middleware.monitor.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/monitor/config/OutContextInfo;", "", "aid", "", "deviceId", "", "appVersion", "channel", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAid", "()I", "setAid", "(I)V", "getAppVersion", "()Ljava/lang/String;", "setAppVersion", "(Ljava/lang/String;)V", "getChannel", "setChannel", "getDeviceId", "setDeviceId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class OutContextInfo {
    private int aid;
    private String appVersion;
    private String channel;
    private String deviceId;

    public static /* synthetic */ OutContextInfo copy$default(OutContextInfo r0, int r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.aid;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.deviceId;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.appVersion;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.channel;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.aid;
    }

    public final String component2() {
        return this.deviceId;
    }

    public final String component3() {
        return this.appVersion;
    }

    public final String component4() {
        return this.channel;
    }

    public final OutContextInfo copy(int r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "deviceId");
        Intrinsics.checkNotNullParameter(r4, "appVersion");
        Intrinsics.checkNotNullParameter(r5, "channel");
        return new OutContextInfo(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof OutContextInfo) == false) goto L14;
        OutContextInfo r4 = (OutContextInfo) r3;
        if (this.aid == r4.aid) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.deviceId, r4.deviceId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.appVersion, r4.appVersion) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.channel, r4.channel) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.aid * 31;
        String r1 = this.deviceId;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.appVersion;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.channel;
        if (r8 == null) goto L14;
        r2 = r8.hashCode();
    L14:
        return r7 + r2;
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public String toString() {
        return "OutContextInfo(aid=" + this.aid + ", deviceId=" + this.deviceId + ", appVersion=" + this.appVersion + ", channel=" + this.channel + ")";
    }

    public final int getAid() {
        return this.aid;
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

    public final void setAid(int r1) {
        this.aid = r1;
    }

    public final void setAppVersion(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.appVersion = r2;
    }

    public final void setChannel(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.channel = r2;
    }

    public final void setDeviceId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.deviceId = r2;
    }

    public OutContextInfo(int r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "deviceId");
        Intrinsics.checkNotNullParameter(r4, "appVersion");
        Intrinsics.checkNotNullParameter(r5, "channel");
        this.aid = r2;
        this.deviceId = r3;
        this.appVersion = r4;
        this.channel = r5;
    }

    public /* synthetic */ OutContextInfo(int r2, String r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = "";
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = "";
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = "";
    L11:
        this(r2, r3, r4, r5);
    }
}
