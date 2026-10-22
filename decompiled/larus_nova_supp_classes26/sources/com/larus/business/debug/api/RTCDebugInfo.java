package com.larus.business.debug.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JL\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r¨\u0006$"}, d2 = {"Lcom/larus/business/debug/api/RTCDebugInfo;", "", "rtcAppId", "", "roomID", "botID", "rtcCallId", "", "tutorId", "sdkVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/String;)V", "getRtcAppId", "()Ljava/lang/String;", "getRoomID", "getBotID", "getRtcCallId", "()J", "getTutorId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSdkVersion", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/String;)Lcom/larus/business/debug/api/RTCDebugInfo;", "equals", "", "other", "hashCode", "", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RTCDebugInfo {
    private final String botID;
    private final String roomID;
    private final String rtcAppId;
    private final long rtcCallId;
    private final String sdkVersion;
    private final Long tutorId;

    public static /* synthetic */ RTCDebugInfo copy$default(RTCDebugInfo r5, String r6, String r7, String r8, long r9, Long r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.rtcAppId;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.roomID;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.botID;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.rtcCallId;
    L14:
        long r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r11 = r5.tutorId;
    L17:
        Long r3 = r11;
        if ((r13 & 32) == 0) goto L20;
        r12 = r5.sdkVersion;
    L20:
        String r10 = r6;
        return r5.copy(r10, r15, r0, r1, r3, r12);
    }

    public final String component1() {
        return this.rtcAppId;
    }

    public final String component2() {
        return this.roomID;
    }

    public final String component3() {
        return this.botID;
    }

    public final long component4() {
        return this.rtcCallId;
    }

    public final Long component5() {
        return this.tutorId;
    }

    public final String component6() {
        return this.sdkVersion;
    }

    public final RTCDebugInfo copy(String r10, String r11, String r12, long r13, Long r15, String r16) {
        Intrinsics.checkNotNullParameter(r10, "rtcAppId");
        Intrinsics.checkNotNullParameter(r11, "roomID");
        Intrinsics.checkNotNullParameter(r12, "botID");
        Intrinsics.checkNotNullParameter(r16, "sdkVersion");
        return new RTCDebugInfo(r10, r11, r12, r13, r15, r16);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof RTCDebugInfo) == true) goto L8;
        return false;
    L8:
        RTCDebugInfo r9 = (RTCDebugInfo) r8;
        if (Intrinsics.areEqual(this.rtcAppId, r9.rtcAppId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.roomID, r9.roomID) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.botID, r9.botID) == true) goto L18;
        return false;
    L18:
        if (this.rtcCallId == r9.rtcCallId) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.tutorId, r9.tutorId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sdkVersion, r9.sdkVersion) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.rtcAppId.hashCode() * 31) + this.roomID.hashCode()) * 31) + this.botID.hashCode()) * 31;
        long r1 = this.rtcCallId;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        Long r3 = this.tutorId;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return ((r2 + r4) * 31) + this.sdkVersion.hashCode();
    L5:
        r4 = r3.hashCode();
        goto L7
    }

    public String toString() {
        return "RTCDebugInfo(rtcAppId=" + this.rtcAppId + ", roomID=" + this.roomID + ", botID=" + this.botID + ", rtcCallId=" + this.rtcCallId + ", tutorId=" + this.tutorId + ", sdkVersion=" + this.sdkVersion + ')';
    }

    public final String getBotID() {
        return this.botID;
    }

    public final String getRoomID() {
        return this.roomID;
    }

    public final String getRtcAppId() {
        return this.rtcAppId;
    }

    public final long getRtcCallId() {
        return this.rtcCallId;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final Long getTutorId() {
        return this.tutorId;
    }

    public RTCDebugInfo(String r2, String r3, String r4, long r5, Long r7, String r8) {
        Intrinsics.checkNotNullParameter(r2, "rtcAppId");
        Intrinsics.checkNotNullParameter(r3, "roomID");
        Intrinsics.checkNotNullParameter(r4, "botID");
        Intrinsics.checkNotNullParameter(r8, "sdkVersion");
        this.rtcAppId = r2;
        this.roomID = r3;
        this.botID = r4;
        this.rtcCallId = r5;
        this.tutorId = r7;
        this.sdkVersion = r8;
    }
}
