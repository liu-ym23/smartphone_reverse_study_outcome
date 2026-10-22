package com.bytedance.android.live.profit.lottery;

import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p0 {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final JsonObject d;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof p0) == false) goto L14;
        p0 r4 = (p0) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.c;
        if (r7 == true) goto L12;
        r1 = r7;
    L12:
        int r8 = (r6 + r1) * 31;
        JsonObject r9 = this.d;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L17:
        return r8 + r10;
    L15:
        r10 = 0;
        goto L17
    }

    public final String toString() {
        return "LotteryFinishInfo(isParticipated=" + this.a + ", isLucky=" + this.b + ')';
    }

    public p0(boolean r2, boolean r3, boolean r4, JsonObject r5) {
        Intrinsics.checkNotNullParameter(r5, "rawResponse");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
