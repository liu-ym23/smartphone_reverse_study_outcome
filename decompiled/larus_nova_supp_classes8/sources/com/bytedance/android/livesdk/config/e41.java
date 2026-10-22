package com.bytedance.android.livesdk.config;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e41 {
    public final boolean a;
    public final boolean b;
    public final String c;
    public final Map<String, Integer> d;
    public final boolean e;

    public static final class a {
    }

    static {
    }

    public e41() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e41) == false) goto L16;
        e41 r4 = (e41) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
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
        String r7 = this.c;
        int r8 = 0;
        if (r7 == null) goto L11;
        int r9 = r7.hashCode();
    L12:
        int r10 = (r6 + r9) * 31;
        Map<String, Integer> r11 = this.d;
        if (r11 == null) goto L15;
        r8 = r11.hashCode();
    L15:
        int r12 = (r10 + r8) * 31;
        boolean r13 = this.e;
        if (r13 == true) goto L20;
        r1 = r13;
    L20:
        return r12 + r1;
    L11:
        r9 = 0;
        goto L12
    }

    public final String toString() {
        return "LiveIndependentGuideConfig(isShownGuide=" + this.a + ", isShownClose=" + this.b + ", currentDate=" + this.c + ", dateCountMap=" + this.d + ", isFirstBackGround=" + this.e + ")";
    }

    @JvmStatic
    public static final e41 b() {
        return new e41(0);
    }

    public /* synthetic */ e41(int r7) {
        this(false, false, "", new LinkedHashMap(), false);
    }

    public e41(boolean r2, boolean r3, String r4, Map<String, Integer> r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "dateCountMap");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public static e41 a(e41 r6, boolean r7, boolean r8, String r9, Map r10, int r11) {
        if ((r11 & 1) == 0) goto L5;
        r7 = r6.a;
    L5:
        boolean r1 = r7;
        if ((r11 & 2) == 0) goto L8;
        r8 = r6.b;
    L8:
        boolean r2 = r8;
        if ((r11 & 4) == 0) goto L11;
        r9 = r6.c;
    L11:
        String r3 = r9;
        if ((r11 & 8) == 0) goto L14;
        r10 = r6.d;
    L14:
        Map r4 = r10;
        if ((r11 & 16) == 0) goto L17;
        boolean r5 = r6.e;
    L18:
        r6.getClass();
        Intrinsics.checkNotNullParameter(r4, "dateCountMap");
        return new e41(r1, r2, r3, r4, r5);
    L17:
        r5 = false;
        goto L18
    }
}
