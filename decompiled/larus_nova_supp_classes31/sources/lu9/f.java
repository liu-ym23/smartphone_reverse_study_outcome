package lu9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J5\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/larus/settings/provider/disk/AppOnlineCleanConfig;", "", "enableOnlineClean", "", "onlineCleanVersion", "", "internalCleanPath", "Lcom/larus/settings/provider/disk/PathConfig;", "externalCleanPath", "<init>", "(ZJLcom/larus/settings/provider/disk/PathConfig;Lcom/larus/settings/provider/disk/PathConfig;)V", "getEnableOnlineClean", "()Z", "getOnlineCleanVersion", "()J", "getInternalCleanPath", "()Lcom/larus/settings/provider/disk/PathConfig;", "getExternalCleanPath", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class f {

    @SerializedName("enable_online_clean")
    private final boolean enableOnlineClean;

    @SerializedName("external_clean_path")
    private final h externalCleanPath;

    @SerializedName("internal_clean_path")
    private final h internalCleanPath;

    @SerializedName("online_clean_version")
    private final long onlineCleanVersion;

    public f() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof f) == true) goto L8;
        return false;
    L8:
        f r9 = (f) r8;
        if (this.enableOnlineClean == r9.enableOnlineClean) goto L12;
        return false;
    L12:
        if (this.onlineCleanVersion == r9.onlineCleanVersion) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.internalCleanPath, r9.internalCleanPath) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.externalCleanPath, r9.externalCleanPath) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.enableOnlineClean == false) goto L5;
        int r0 = 1231;
    L6:
        long r1 = this.onlineCleanVersion;
        int r2 = ((r0 * 31) + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        h r3 = this.internalCleanPath;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        h r7 = this.externalCleanPath;
        if (r7 == null) goto L15;
        r4 = r7.hashCode();
    L15:
        return r6 + r4;
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "AppOnlineCleanConfig(enableOnlineClean=" + this.enableOnlineClean + ", onlineCleanVersion=" + this.onlineCleanVersion + ", internalCleanPath=" + this.internalCleanPath + ", externalCleanPath=" + this.externalCleanPath + ')';
    }

    public final boolean a() {
        return this.enableOnlineClean;
    }

    public final h b() {
        return this.externalCleanPath;
    }

    public final h c() {
        return this.internalCleanPath;
    }

    public final long d() {
        return this.onlineCleanVersion;
    }

    public f(int r3) {
        this.enableOnlineClean = false;
        this.onlineCleanVersion = 0;
        this.internalCleanPath = null;
        this.externalCleanPath = null;
    }
}
