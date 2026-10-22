package com.larus.uaigc.lynx.pocket;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/larus/uaigc/lynx/pocket/SupportedOSAndVersion;", "", "osVersion", "", "Lcom/larus/uaigc/lynx/pocket/OSVersion;", "<init>", "(Ljava/util/List;)V", "getOsVersion", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SupportedOSAndVersion {

    @SerializedName("os_version")
    private final List<OSVersion> osVersion;

    public SupportedOSAndVersion() {
        List r0 = null;
        this(r0, 1, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SupportedOSAndVersion copy$default(SupportedOSAndVersion r0, List r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.osVersion;
    L6:
        return r0.copy(r1);
    }

    public final List<OSVersion> component1() {
        return this.osVersion;
    }

    public final SupportedOSAndVersion copy(List<OSVersion> r2) {
        return new SupportedOSAndVersion(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof SupportedOSAndVersion) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.osVersion, ((SupportedOSAndVersion) r4).osVersion) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<OSVersion> r0 = this.osVersion;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "SupportedOSAndVersion(osVersion=" + this.osVersion + ')';
    }

    public final List<OSVersion> getOsVersion() {
        return this.osVersion;
    }

    public SupportedOSAndVersion(List<OSVersion> r1) {
        this.osVersion = r1;
    }

    public /* synthetic */ SupportedOSAndVersion(List r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
