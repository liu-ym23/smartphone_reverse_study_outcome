package au9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eBC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJJ\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/larus/settings/provider/bot/UgcCacheConfig;", "", "discovery", "", "profile", "noRecreateImmerse", "disableImmerseBoxUpdate", "preloadDiscovery", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getDiscovery", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getProfile", "getNoRecreateImmerse", "getDisableImmerseBoxUpdate", "getPreloadDiscovery", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/larus/settings/provider/bot/UgcCacheConfig;", "equals", "other", "hashCode", "", "toString", "", "Companion", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class s {
    public static final s a = null;
    public static final s b = null;

    @SerializedName("disable_box_refresh_immerse")
    private final Boolean disableImmerseBoxUpdate;

    @SerializedName("discovery")
    private final Boolean discovery;

    @SerializedName("no_recreate_immerse")
    private final Boolean noRecreateImmerse;

    @SerializedName("preload_discovery")
    private final Boolean preloadDiscovery;

    @SerializedName("profile")
    private final Boolean profile;

    public static final class a {
    }

    public s() {
        this(null, null, 31);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof s) == true) goto L8;
        return false;
    L8:
        s r6 = (s) r5;
        if (Intrinsics.areEqual(this.discovery, r6.discovery) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.profile, r6.profile) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.noRecreateImmerse, r6.noRecreateImmerse) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.disableImmerseBoxUpdate, r6.disableImmerseBoxUpdate) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.preloadDiscovery, r6.preloadDiscovery) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Boolean r0 = this.discovery;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.profile;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.noRecreateImmerse;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.disableImmerseBoxUpdate;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.preloadDiscovery;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
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

    public final String toString() {
        return "UgcCacheConfig(discovery=" + this.discovery + ", profile=" + this.profile + ", noRecreateImmerse=" + this.noRecreateImmerse + ", disableImmerseBoxUpdate=" + this.disableImmerseBoxUpdate + ", preloadDiscovery=" + this.preloadDiscovery + ')';
    }

    static {
        Boolean r1 = Boolean.TRUE;
        a = new s(r1, r1, 28);
        b = new s(null, null, 31);
    }

    public final Boolean a() {
        return this.disableImmerseBoxUpdate;
    }

    public final Boolean b() {
        return this.discovery;
    }

    public final Boolean c() {
        return this.noRecreateImmerse;
    }

    public final Boolean d() {
        return this.preloadDiscovery;
    }

    public final Boolean e() {
        return this.profile;
    }

    public s(Boolean r4, Boolean r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r4 = Boolean.FALSE;
    L6:
        if ((r6 & 2) == 0) goto L8;
        r5 = Boolean.FALSE;
    L8:
        Boolean r1 = null;
        if ((r6 & 4) == 0) goto L11;
        Boolean r0 = Boolean.FALSE;
    L13:
        if ((r6 & 8) == 0) goto L15;
        Boolean r2 = Boolean.FALSE;
    L17:
        if ((r6 & 16) == 0) goto L19;
        r1 = Boolean.FALSE;
    L19:
        this.discovery = r4;
        this.profile = r5;
        this.noRecreateImmerse = r0;
        this.disableImmerseBoxUpdate = r2;
        this.preloadDiscovery = r1;
        return;
    L15:
        r2 = null;
        goto L17
    L11:
        r0 = null;
        goto L13
    }
}
