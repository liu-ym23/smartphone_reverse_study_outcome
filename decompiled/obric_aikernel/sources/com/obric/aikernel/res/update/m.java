package com.obric.aikernel.res.update;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, UpdateResult> f5215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f5216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f5217c;

    public m(Map<String, UpdateResult> r10, d r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "results");
        this.f5215a = r10;
        this.f5216b = r11;
        this.f5217c = r12;
    }

    public final int a() {
        return this.f5217c;
    }

    public final d b() {
        return this.f5216b;
    }

    public final Map<String, UpdateResult> c() {
        return this.f5215a;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof m) == true) goto L8;
        return false;
    L8:
        m r11 = (m) r10;
        if (Intrinsics.areEqual(this.f5215a, r11.f5215a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f5216b, r11.f5216b) == true) goto L15;
        return false;
    L15:
        if (this.f5217c == r11.f5217c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r10 = this.f5215a.hashCode() * 31;
        d r11 = this.f5216b;
        if (r11 != null) goto L5;
        int r12 = 0;
    L7:
        return ((r10 + r12) * 31) + Integer.hashCode(this.f5217c);
    L5:
        r12 = r11.hashCode();
        goto L7
    }

    public String toString() {
        return "UpdateExecutionResult(results=" + this.f5215a + ", metadataOutcome=" + this.f5216b + ", cachedPackageCount=" + this.f5217c + ')';
    }
}
