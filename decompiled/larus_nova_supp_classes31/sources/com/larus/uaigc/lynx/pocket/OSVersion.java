package com.larus.uaigc.lynx.pocket;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0004\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/larus/uaigc/lynx/pocket/OSVersion;", "", "systemType", "", "isSupport", "", "lowestVersionCode", "", "highestVersionCode", "<init>", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getSystemType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLowestVersionCode", "()Ljava/lang/String;", "getHighestVersionCode", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/uaigc/lynx/pocket/OSVersion;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class OSVersion {

    @SerializedName("highest_version_code")
    private final String highestVersionCode;

    @SerializedName("is_support")
    private final Boolean isSupport;

    @SerializedName("lowest_version_code")
    private final String lowestVersionCode;

    @SerializedName("sys_type")
    private final Integer systemType;

    public OSVersion() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ OSVersion copy$default(OSVersion r0, Integer r1, Boolean r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.systemType;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.isSupport;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.lowestVersionCode;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.highestVersionCode;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Integer component1() {
        return this.systemType;
    }

    public final Boolean component2() {
        return this.isSupport;
    }

    public final String component3() {
        return this.lowestVersionCode;
    }

    public final String component4() {
        return this.highestVersionCode;
    }

    public final OSVersion copy(Integer r2, Boolean r3, String r4, String r5) {
        return new OSVersion(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OSVersion) == true) goto L8;
        return false;
    L8:
        OSVersion r6 = (OSVersion) r5;
        if (Intrinsics.areEqual(this.systemType, r6.systemType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isSupport, r6.isSupport) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lowestVersionCode, r6.lowestVersionCode) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.highestVersionCode, r6.highestVersionCode) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.systemType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.isSupport;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.lowestVersionCode;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.highestVersionCode;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "OSVersion(systemType=" + this.systemType + ", isSupport=" + this.isSupport + ", lowestVersionCode=" + this.lowestVersionCode + ", highestVersionCode=" + this.highestVersionCode + ')';
    }

    public final String getHighestVersionCode() {
        return this.highestVersionCode;
    }

    public final String getLowestVersionCode() {
        return this.lowestVersionCode;
    }

    public final Integer getSystemType() {
        return this.systemType;
    }

    public final Boolean isSupport() {
        return this.isSupport;
    }

    public OSVersion(Integer r1, Boolean r2, String r3, String r4) {
        this.systemType = r1;
        this.isSupport = r2;
        this.lowestVersionCode = r3;
        this.highestVersionCode = r4;
    }

    public /* synthetic */ OSVersion(Integer r2, Boolean r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
