package com.bytedance.android.live.browser;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m {
    public final boolean a;
    public final boolean b;
    public final List<String> c;
    public final List<String> d;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof m) == false) goto L14;
        m r4 = (m) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
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
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        if (r4 == true) goto L9;
        r1 = r4;
    L9:
        int r5 = (r3 + r1) * 31;
        List<String> r6 = this.c;
        int r7 = 0;
        if (r6 == null) goto L12;
        int r8 = r6.hashCode();
    L13:
        int r9 = (r5 + r8) * 31;
        List<String> r11 = this.d;
        if (r11 == null) goto L17;
        r7 = r11.hashCode();
    L17:
        return r9 + r7;
    L12:
        r8 = 0;
        goto L13
    }

    public final String toString() {
        return "CacheConfigItem(disablePrefetchInject=" + this.a + ", disableStorageInject=" + this.b + ", apiStorageKeys=" + this.c + ", localStorageKeys=" + this.d + ")";
    }

    public m(boolean r2, boolean r3, List<String> r4, List<String> r5) {
        Intrinsics.checkNotNullParameter(r4, "apiStorageKeys");
        Intrinsics.checkNotNullParameter(r5, "localStorageKeys");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
