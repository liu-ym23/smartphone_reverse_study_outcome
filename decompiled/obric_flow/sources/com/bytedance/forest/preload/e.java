package com.bytedance.forest.preload;

import ai.j0;
import com.bytedance.forest.model.w;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f4572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f4573b;

    public e(w r5, boolean r10) {
        this.f4572a = r5;
        this.f4573b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof e) == false) goto L10;
        e r10 = (e) r5;
        w r11 = r10.f4572a;
        if (Intrinsics.areEqual(this.f4572a, r11) == true) goto L8;
        return false;
    L8:
        if (this.f4573b == r10.f4573b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public final int hashCode() {
        w r5 = this.f4572a;
        if (r5 == null) goto L5;
        int r10 = r5.hashCode();
    L6:
        int r11 = r10 * 31;
        boolean r12 = this.f4573b;
        ?? r13 = r12;
        if (r12 == false) goto L10;
        r13 = 1;
    L10:
        return r11 + r13;
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("PreloadResult(response=");
        r5.append(this.f4572a);
        r5.append(", isWait=");
        return j0.r(r5, this.f4573b, ")");
    }
}
