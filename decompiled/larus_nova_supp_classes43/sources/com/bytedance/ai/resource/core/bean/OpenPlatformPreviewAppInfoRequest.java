package com.bytedance.ai.resource.core.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003JC\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\nHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewAppInfoRequest;", "", "deviceId", "", "mode", "scanTargets", "", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformScanTarget;", "cursor", "limit", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;I)V", "getDeviceId", "()Ljava/lang/String;", "getMode", "getScanTargets", "()Ljava/util/List;", "getCursor", "getLimit", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenPlatformPreviewAppInfoRequest {
    private final String cursor;

    @SerializedName("device_id")
    private final String deviceId;
    private final int limit;
    private final String mode;

    @SerializedName("scan_targets")
    private final List<OpenPlatformScanTarget> scanTargets;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenPlatformPreviewAppInfoRequest copy$default(OpenPlatformPreviewAppInfoRequest r10, String r11, String r12, List r13, String r14, int r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.deviceId;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.mode;
    L8:
        String r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.scanTargets;
    L11:
        List r0 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.cursor;
    L14:
        String r1 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.limit;
    L17:
        String r19 = r11;
        return r10.copy(r19, r18, r0, r1, r15);
    }

    public final String component1() {
        return this.deviceId;
    }

    public final String component2() {
        return this.mode;
    }

    public final List<OpenPlatformScanTarget> component3() {
        return this.scanTargets;
    }

    public final String component4() {
        return this.cursor;
    }

    public final int component5() {
        return this.limit;
    }

    public final OpenPlatformPreviewAppInfoRequest copy(String r10, String r11, List<OpenPlatformScanTarget> r12, String r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "deviceId");
        Intrinsics.checkNotNullParameter(r11, "mode");
        Intrinsics.checkNotNullParameter(r12, "scanTargets");
        return new OpenPlatformPreviewAppInfoRequest(r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof OpenPlatformPreviewAppInfoRequest) == true) goto L8;
        return false;
    L8:
        OpenPlatformPreviewAppInfoRequest r11 = (OpenPlatformPreviewAppInfoRequest) r10;
        if (Intrinsics.areEqual(this.deviceId, r11.deviceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.mode, r11.mode) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.scanTargets, r11.scanTargets) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.cursor, r11.cursor) == true) goto L21;
        return false;
    L21:
        if (this.limit == r11.limit) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.deviceId.hashCode() * 31) + this.mode.hashCode()) * 31) + this.scanTargets.hashCode()) * 31;
        String r1 = this.cursor;
        if (r1 != null) goto L5;
        int r10 = 0;
    L7:
        return ((r0 + r10) * 31) + this.limit;
    L5:
        r10 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "OpenPlatformPreviewAppInfoRequest(deviceId=" + this.deviceId + ", mode=" + this.mode + ", scanTargets=" + this.scanTargets + ", cursor=" + this.cursor + ", limit=" + this.limit + ')';
    }

    public final String getCursor() {
        return this.cursor;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final String getMode() {
        return this.mode;
    }

    public final List<OpenPlatformScanTarget> getScanTargets() {
        return this.scanTargets;
    }

    public OpenPlatformPreviewAppInfoRequest(String r10, String r11, List<OpenPlatformScanTarget> r12, String r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "deviceId");
        Intrinsics.checkNotNullParameter(r11, "mode");
        Intrinsics.checkNotNullParameter(r12, "scanTargets");
        this.deviceId = r10;
        this.mode = r11;
        this.scanTargets = r12;
        this.cursor = r13;
        this.limit = r14;
    }

    public /* synthetic */ OpenPlatformPreviewAppInfoRequest(String r10, String r11, List r12, String r13, int r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 4) == 0) goto L5;
        r12 = CollectionsKt.emptyList();
    L5:
        List r17 = r12;
        if ((r15 & 8) == 0) goto L8;
        r13 = null;
    L8:
        String r18 = r13;
        if ((r15 & 16) == 0) goto L11;
        int r19 = 20;
    L12:
        this(r10, r11, r17, r18, r19);
        return;
    L11:
        r19 = r14;
        goto L12
    }
}
