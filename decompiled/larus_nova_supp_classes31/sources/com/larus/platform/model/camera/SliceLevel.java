package com.larus.platform.model.camera;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/larus/platform/model/camera/SliceLevel;", "", "type", "", "sliceThresholdBytes", "", "sliceSizeBytes", "socketNum", "", "sliceRetryCount", "<init>", "(Ljava/lang/String;JJII)V", "getType", "()Ljava/lang/String;", "getSliceThresholdBytes", "()J", "getSliceSizeBytes", "getSocketNum", "()I", "getSliceRetryCount", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SliceLevel {

    @SerializedName("sliceRetryCount")
    private final int sliceRetryCount;

    @SerializedName("sliceSizeBytes")
    private final long sliceSizeBytes;

    @SerializedName("sliceThresholdBytes")
    private final long sliceThresholdBytes;

    @SerializedName("socketNum")
    private final int socketNum;

    @SerializedName("type")
    private final String type;

    public SliceLevel() {
        this(null, 0, 0, 0, 0, 31, null);
    }

    public static /* synthetic */ SliceLevel copy$default(SliceLevel r5, String r6, long r7, long r9, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.type;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.sliceThresholdBytes;
    L8:
        long r0 = r7;
        if ((r13 & 4) == 0) goto L11;
        r9 = r5.sliceSizeBytes;
    L11:
        long r2 = r9;
        if ((r13 & 8) == 0) goto L14;
        r11 = r5.socketNum;
    L14:
        int r15 = r11;
        if ((r13 & 16) == 0) goto L17;
        r12 = r5.sliceRetryCount;
    L17:
        String r8 = r6;
        return r5.copy(r8, r0, r2, r15, r12);
    }

    public final String component1() {
        return this.type;
    }

    public final long component2() {
        return this.sliceThresholdBytes;
    }

    public final long component3() {
        return this.sliceSizeBytes;
    }

    public final int component4() {
        return this.socketNum;
    }

    public final int component5() {
        return this.sliceRetryCount;
    }

    public final SliceLevel copy(String r10, long r11, long r13, int r15, int r16) {
        return new SliceLevel(r10, r11, r13, r15, r16);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof SliceLevel) == true) goto L8;
        return false;
    L8:
        SliceLevel r9 = (SliceLevel) r8;
        if (Intrinsics.areEqual(this.type, r9.type) == true) goto L12;
        return false;
    L12:
        if (this.sliceThresholdBytes == r9.sliceThresholdBytes) goto L15;
        return false;
    L15:
        if (this.sliceSizeBytes == r9.sliceSizeBytes) goto L18;
        return false;
    L18:
        if (this.socketNum == r9.socketNum) goto L21;
        return false;
    L21:
        if (this.sliceRetryCount == r9.sliceRetryCount) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.type;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        long r2 = this.sliceThresholdBytes;
        int r3 = ((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31;
        long r4 = this.sliceSizeBytes;
        return ((((r3 + ((int) (r4 ^ (r4 >>> 32)))) * 31) + this.socketNum) * 31) + this.sliceRetryCount;
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SliceLevel(type=" + this.type + ", sliceThresholdBytes=" + this.sliceThresholdBytes + ", sliceSizeBytes=" + this.sliceSizeBytes + ", socketNum=" + this.socketNum + ", sliceRetryCount=" + this.sliceRetryCount + ')';
    }

    public final int getSliceRetryCount() {
        return this.sliceRetryCount;
    }

    public final long getSliceSizeBytes() {
        return this.sliceSizeBytes;
    }

    public final long getSliceThresholdBytes() {
        return this.sliceThresholdBytes;
    }

    public final int getSocketNum() {
        return this.socketNum;
    }

    public final String getType() {
        return this.type;
    }

    public SliceLevel(String r1, long r2, long r4, int r6, int r7) {
        this.type = r1;
        this.sliceThresholdBytes = r2;
        this.sliceSizeBytes = r4;
        this.socketNum = r6;
        this.sliceRetryCount = r7;
    }

    public /* synthetic */ SliceLevel(String r6, long r7, long r9, int r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = "normal";
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = 5242880;
    L8:
        long r0 = r7;
        if ((r13 & 4) == 0) goto L11;
        r9 = 524288;
    L11:
        long r2 = r9;
        if ((r13 & 8) == 0) goto L14;
        int r15 = 4;
    L16:
        if ((r13 & 16) == 0) goto L18;
        int r4 = 3;
    L19:
        this(r6, r0, r2, r15, r4);
        return;
    L18:
        r4 = r12;
        goto L19
    L14:
        r15 = r11;
        goto L16
    }
}
