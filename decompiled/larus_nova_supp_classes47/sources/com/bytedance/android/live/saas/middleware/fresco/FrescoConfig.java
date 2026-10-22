package com.bytedance.android.live.saas.middleware.fresco;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/fresco/FrescoConfig;", "", "standalone", "", "isToBVersion", "nativeDir", "", "(ZZLjava/lang/String;)V", "()Z", "getNativeDir", "()Ljava/lang/String;", "getStandalone", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class FrescoConfig {
    private final boolean isToBVersion;
    private final String nativeDir;
    private final boolean standalone;

    public FrescoConfig() {
        this(false, false, null, 7, null);
    }

    public FrescoConfig(boolean r7) {
        this(r7, false, null, 6, null);
    }

    public FrescoConfig(boolean r7, boolean r8) {
        this(r7, r8, null, 4, null);
    }

    public static /* synthetic */ FrescoConfig copy$default(FrescoConfig r0, boolean r1, boolean r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.standalone;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.isToBVersion;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.nativeDir;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.standalone;
    }

    public final boolean component2() {
        return this.isToBVersion;
    }

    public final String component3() {
        return this.nativeDir;
    }

    public final FrescoConfig copy(boolean r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "nativeDir");
        return new FrescoConfig(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof FrescoConfig) == false) goto L12;
        FrescoConfig r4 = (FrescoConfig) r3;
        if (this.standalone == r4.standalone) goto L8;
        return false;
    L8:
        if (this.isToBVersion == r4.isToBVersion) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.nativeDir, r4.nativeDir) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        boolean r0 = this.standalone;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.isToBVersion;
        if (r4 == true) goto L9;
        r1 = r4;
    L9:
        int r5 = (r3 + r1) * 31;
        String r6 = this.nativeDir;
        if (r6 == null) goto L12;
        int r7 = r6.hashCode();
    L14:
        return r5 + r7;
    L12:
        r7 = 0;
        goto L14
    }

    public String toString() {
        return "FrescoConfig(standalone=" + this.standalone + ", isToBVersion=" + this.isToBVersion + ", nativeDir=" + this.nativeDir + ")";
    }

    public final String getNativeDir() {
        return this.nativeDir;
    }

    public final boolean getStandalone() {
        return this.standalone;
    }

    public final boolean isToBVersion() {
        return this.isToBVersion;
    }

    public FrescoConfig(boolean r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "nativeDir");
        this.standalone = r2;
        this.isToBVersion = r3;
        this.nativeDir = r4;
    }

    public /* synthetic */ FrescoConfig(boolean r1, boolean r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = true;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = false;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = "";
    L11:
        this(r1, r2, r3);
    }
}
