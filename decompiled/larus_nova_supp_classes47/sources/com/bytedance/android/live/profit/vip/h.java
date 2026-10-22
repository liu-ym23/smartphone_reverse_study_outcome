package com.bytedance.android.live.profit.vip;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h {
    public final List<l> a;
    public final int b;
    public final boolean c;
    public final int d;
    public final boolean e;
    public final boolean f;
    public final m g;
    public final boolean h;
    public final int i;
    public final long j;
    public final int k;

    public static final class a {
    }

    static {
    }

    public h() {
        this(2047);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof h) == false) goto L28;
        h r7 = (h) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (this.e == r7.e) goto L16;
        return false;
    L16:
        if (this.f == r7.f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L20;
        return false;
    L20:
        if (this.h == r7.h) goto L22;
        return false;
    L22:
        if (this.i == r7.i) goto L24;
        return false;
    L24:
        if (this.j == r7.j) goto L26;
        return false;
    L26:
        if (this.k == r7.k) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    public final int hashCode() {
        List<l> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + this.b) * 31;
        boolean r4 = this.c;
        ?? r5 = 1;
        ?? r6 = r4;
        if (r4 == false) goto L9;
        r6 = 1;
    L9:
        int r7 = (((r3 + r6) * 31) + this.d) * 31;
        boolean r8 = this.e;
        ?? r9 = r8;
        if (r8 == false) goto L12;
        r9 = 1;
    L12:
        int r10 = (r7 + r9) * 31;
        boolean r12 = this.f;
        ?? r13 = r12;
        if (r12 == false) goto L15;
        r13 = 1;
    L15:
        int r14 = (r10 + r13) * 31;
        m r15 = this.g;
        if (r15 == null) goto L18;
        r1 = r15.hashCode();
    L18:
        int r16 = (r14 + r1) * 31;
        boolean r17 = this.h;
        if (r17 == true) goto L22;
        r5 = r17;
    L22:
        int r18 = (((r16 + r5) * 31) + this.i) * 31;
        long r19 = this.j;
        return ((r18 + ((int) (r19 ^ (r19 >>> 32)))) * 31) + this.k;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "SubscribeInfo(emojiList=" + this.a + ", status=" + this.b + ", isMember=" + this.c + ", memberType=" + this.d + ", entrance=" + this.e + ", entranceTab=" + this.f + ", emojiTabInfo=" + this.g + ", isVsRoom=" + this.h + ", level=" + this.i + ", expiredTime=" + this.j + ", initStatus=" + this.k + ")";
    }

    public /* synthetic */ h(int r17) {
        if ((r17 & 1) == 0) goto L5;
        List r1 = com.bytedance.revenue.platform.api.core.c.a(new l[0]);
    L6:
        List r4 = r1;
        if ((r17 & 8) == 0) goto L9;
        int r7 = -1;
    L11:
        if ((r17 & 1024) == 0) goto L13;
        int r15 = -1;
    L14:
        this(r4, 0, false, r7, false, false, null, false, 0, 0, r15);
        return;
    L13:
        r15 = 0;
        goto L14
    L9:
        r7 = 0;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    public h(List<l> r2, int r3, boolean r4, int r5, boolean r6, boolean r7, m r8, boolean r9, int r10, long r12, int r13) {
        Intrinsics.checkNotNullParameter(r2, "emojiList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r12;
        this.k = r13;
    }
}
