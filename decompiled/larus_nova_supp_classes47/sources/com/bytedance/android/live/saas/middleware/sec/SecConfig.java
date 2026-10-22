package com.bytedance.android.live.saas.middleware.sec;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ry.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\"\u0010#J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0004HÆ\u0003J\t\u0010\b\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J?\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u0011\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\r\u0010\u001bR\u0017\u0010\u000e\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/sec/SecConfig;", "", "Lcom/bytedance/android/live/saas/middleware/sec/ISecSdk;", "component1", "", "component2", "component3", "", "component4", "Lry/e;", "component5", "impl", "standalone", "isToBVersion", "id", "hostPermission", "copy", "toString", "", "hashCode", "other", "equals", "Lcom/bytedance/android/live/saas/middleware/sec/ISecSdk;", "getImpl", "()Lcom/bytedance/android/live/saas/middleware/sec/ISecSdk;", "Z", "getStandalone", "()Z", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Lry/e;", "getHostPermission", "()Lry/e;", "<init>", "(Lcom/bytedance/android/live/saas/middleware/sec/ISecSdk;ZZLjava/lang/String;Lry/e;)V", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class SecConfig {
    private final e hostPermission;
    private final String id;
    private final ISecSdk impl;
    private final boolean isToBVersion;
    private final boolean standalone;

    public SecConfig() {
        this(null, false, false, null, null, 31, null);
    }

    public static /* synthetic */ SecConfig copy$default(SecConfig r3, ISecSdk r4, boolean r5, boolean r6, String r7, e r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.impl;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.standalone;
    L8:
        boolean r12 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.isToBVersion;
    L11:
        boolean r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.id;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.hostPermission;
    L17:
        ISecSdk r13 = r4;
        return r3.copy(r13, r12, r0, r1, r8);
    }

    public final ISecSdk component1() {
        return this.impl;
    }

    public final boolean component2() {
        return this.standalone;
    }

    public final boolean component3() {
        return this.isToBVersion;
    }

    public final String component4() {
        return this.id;
    }

    public final e component5() {
        return this.hostPermission;
    }

    public final SecConfig copy(ISecSdk r8, boolean r9, boolean r10, String r12, e r13) {
        Intrinsics.checkNotNullParameter(r12, "id");
        return new SecConfig(r8, r9, r10, r12, r13);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof SecConfig) == false) goto L16;
        SecConfig r4 = (SecConfig) r3;
        if (Intrinsics.areEqual(this.impl, r4.impl) == true) goto L8;
        return false;
    L8:
        if (this.standalone == r4.standalone) goto L10;
        return false;
    L10:
        if (this.isToBVersion == r4.isToBVersion) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.id, r4.id) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.hostPermission, r4.hostPermission) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        ISecSdk r0 = this.impl;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        boolean r4 = this.standalone;
        ?? r5 = 1;
        ?? r6 = r4;
        if (r4 == false) goto L9;
        r6 = 1;
    L9:
        int r7 = (r3 + r6) * 31;
        boolean r8 = this.isToBVersion;
        if (r8 == true) goto L13;
        r5 = r8;
    L13:
        int r9 = (r7 + r5) * 31;
        String r10 = this.id;
        if (r10 == null) goto L16;
        int r12 = r10.hashCode();
    L17:
        int r13 = (r9 + r12) * 31;
        e r14 = this.hostPermission;
        if (r14 == null) goto L21;
        r1 = r14.hashCode();
    L21:
        return r13 + r1;
    L16:
        r12 = 0;
        goto L17
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "SecConfig(impl=" + this.impl + ", standalone=" + this.standalone + ", isToBVersion=" + this.isToBVersion + ", id=" + this.id + ", hostPermission=" + this.hostPermission + ")";
    }

    public final e getHostPermission() {
        return this.hostPermission;
    }

    public final String getId() {
        return this.id;
    }

    public final ISecSdk getImpl() {
        return this.impl;
    }

    public final boolean getStandalone() {
        return this.standalone;
    }

    public final boolean isToBVersion() {
        return this.isToBVersion;
    }

    public SecConfig(ISecSdk r2, boolean r3, boolean r4, String r5, e r6) {
        Intrinsics.checkNotNullParameter(r5, "id");
        this.impl = r2;
        this.standalone = r3;
        this.isToBVersion = r4;
        this.id = r5;
        this.hostPermission = r6;
    }

    public /* synthetic */ SecConfig(ISecSdk r5, boolean r6, boolean r7, String r8, e r9, int r10, DefaultConstructorMarker r12) {
        if ((r10 & 1) == 0) goto L5;
        ISecSdk r13 = null;
    L6:
        boolean r1 = false;
        if ((r10 & 2) == 0) goto L9;
        boolean r2 = false;
    L11:
        if ((r10 & 4) != 0) goto L15;
        r1 = r7;
    L15:
        if ((r10 & 8) == 0) goto L17;
        r8 = "";
    L17:
        String r3 = r8;
        if ((r10 & 16) == 0) goto L20;
        e r14 = null;
    L21:
        this(r13, r2, r1, r3, r14);
        return;
    L20:
        r14 = r9;
        goto L21
    L9:
        r2 = r6;
        goto L11
    L5:
        r13 = r5;
        goto L6
    }
}
