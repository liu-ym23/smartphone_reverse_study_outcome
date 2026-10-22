package com.larus.drive.biz.api;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/larus/drive/biz/api/DriveEnterContext;", "Ljava/io/Serializable;", "enterFrom", "", "enterTraceId", "clickStartMs", "", "preloadRequestKeyHash", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getEnterFrom", "()Ljava/lang/String;", "getEnterTraceId", "getClickStartMs", "()J", "getPreloadRequestKeyHash", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveEnterContext implements Serializable {
    private final long clickStartMs;
    private final String enterFrom;
    private final String enterTraceId;
    private final String preloadRequestKeyHash;

    public static /* synthetic */ DriveEnterContext copy$default(DriveEnterContext r3, String r4, String r5, long r6, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.enterFrom;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.enterTraceId;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.clickStartMs;
    L11:
        long r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r8 = r3.preloadRequestKeyHash;
    L14:
        String r7 = r4;
        return r3.copy(r7, r11, r0, r8);
    }

    public final String component1() {
        return this.enterFrom;
    }

    public final String component2() {
        return this.enterTraceId;
    }

    public final long component3() {
        return this.clickStartMs;
    }

    public final String component4() {
        return this.preloadRequestKeyHash;
    }

    public final DriveEnterContext copy(String r8, String r9, long r10, String r12) {
        Intrinsics.checkNotNullParameter(r8, "enterFrom");
        Intrinsics.checkNotNullParameter(r9, "enterTraceId");
        return new DriveEnterContext(r8, r9, r10, r12);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof DriveEnterContext) == true) goto L8;
        return false;
    L8:
        DriveEnterContext r9 = (DriveEnterContext) r8;
        if (Intrinsics.areEqual(this.enterFrom, r9.enterFrom) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enterTraceId, r9.enterTraceId) == true) goto L15;
        return false;
    L15:
        if (this.clickStartMs == r9.clickStartMs) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.preloadRequestKeyHash, r9.preloadRequestKeyHash) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.enterFrom.hashCode() * 31) + this.enterTraceId.hashCode()) * 31;
        long r1 = this.clickStartMs;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        String r3 = this.preloadRequestKeyHash;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return r2 + r4;
    L5:
        r4 = r3.hashCode();
        goto L7
    }

    public String toString() {
        return "DriveEnterContext(enterFrom=" + this.enterFrom + ", enterTraceId=" + this.enterTraceId + ", clickStartMs=" + this.clickStartMs + ", preloadRequestKeyHash=" + this.preloadRequestKeyHash + ')';
    }

    public final long getClickStartMs() {
        return this.clickStartMs;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterTraceId() {
        return this.enterTraceId;
    }

    public final String getPreloadRequestKeyHash() {
        return this.preloadRequestKeyHash;
    }

    public DriveEnterContext(String r2, String r3, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r2, "enterFrom");
        Intrinsics.checkNotNullParameter(r3, "enterTraceId");
        this.enterFrom = r2;
        this.enterTraceId = r3;
        this.clickStartMs = r4;
        this.preloadRequestKeyHash = r6;
    }

    public /* synthetic */ DriveEnterContext(String r7, String r8, long r9, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 8) == 0) goto L5;
        r11 = null;
    L5:
        this(r7, r8, r9, r11);
    }
}
