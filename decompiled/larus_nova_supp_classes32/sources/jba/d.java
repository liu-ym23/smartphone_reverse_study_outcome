package jba;

import android.graphics.Rect;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static a a(int r2, Integer r3, f r4) {
        if (r2 != 2) goto L31;
        if (r3 == null) goto L31;
        if (r3.intValue() != 0) goto L31;
        if (r4 == null) goto L29;
        if (r4.e == true) goto L14;
        r4 = null;
    L14:
        if (r4 == null) goto L29;
        if (Intrinsics.areEqual(r4.f, "root") == false) goto L19;
    L22:
        boolean r5 = true;
    L23:
        if (r5 == false) goto L25;
        int r6 = 0;
    L27:
        return new a(RangesKt.coerceAtLeast(r4.c, 0), r6);
    L25:
        r6 = RangesKt.coerceAtLeast(r4.d, 0);
        goto L27
    L19:
        if (Intrinsics.areEqual(r4.f, "metrics") == true) goto L22;
        r5 = false;
    L29:
        return new a(0, 0);
    L31:
        return new a(0, 0);
    }

    public static f e(int r7, Integer r8, f r9, f r10) {
        if (r7 != 2) goto L48;
        if (r8 != null) goto L7;
        return r9;
    L7:
        if (r8.intValue() == 0) goto L10;
        return r9;
    L10:
        if (r9 != null) goto L12;
        return null;
    L12:
        boolean r2 = false;
        if (StringsKt.startsWith$default(r9.f, "listener", false, 2, null) == true) goto L15;
        return r9;
    L15:
        if (r9.e == false) goto L54;
        if (r10 != null) goto L20;
        return r9;
    L20:
        if (StringsKt.startsWith$default(r10.f, "listener", false, 2, null) == true) goto L22;
        return r9;
    L22:
        if (r10.e == false) goto L55;
        int r11 = r9.c;
        if (r11 <= 0) goto L27;
    L30:
        boolean r0 = true;
    L31:
        int r1 = r10.c;
        if (r1 <= 0) goto L34;
    L37:
        boolean r3 = true;
    L38:
        if (r11 == 0) goto L40;
    L43:
        if (r0 == true) goto L45;
        if (r3 == false) goto L45;
    L46:
        String r6 = r9.f + "-stable";
        int r4 = r10.a;
        int r5 = r10.b;
        int r12 = r10.c;
        int r13 = r10.d;
        boolean r14 = r10.e;
        Intrinsics.checkNotNullParameter(r6, "source");
        return new f(r4, r5, r12, r13, r14, r6);
    L45:
        if (r2 == true) goto L46;
        return r9;
    L40:
        if (r9.d <= 0) goto L43;
        if (r1 <= 0) goto L43;
        r2 = true;
        goto L43
    L34:
        if (r10.d > 0) goto L37;
        r3 = false;
        goto L38
    L27:
        if (r9.d > 0) goto L30;
        r0 = false;
        goto L31
    L55:
        return r9;
    L54:
        return r9;
    L48:
        return r9;
    }

    public static c b(float r2, float r3, float r4, float r5, float r6, float r7) {
        float r8 = RangesKt.coerceAtLeast(r2, 0.0f);
        float r9 = RangesKt.coerceAtLeast(r3, 0.0f);
        return new c(Math.max(r8, RangesKt.coerceAtLeast(r4, 0.0f) - r9), Math.max(r8, RangesKt.coerceAtLeast(r5, 0.0f) - r9), Math.max(r8, RangesKt.coerceAtLeast(r6, 0.0f) - r9), Math.max(r8, RangesKt.coerceAtLeast(r7, 0.0f) - r9));
    }

    public static b c(int r2, int r3, int r4, int r5, List r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "boundingRects");
        if (r2 < 28) goto L34;
        if (r3 <= 0) goto L34;
        int r9 = RangesKt.coerceIn(Math.max(r4, r7), 0, r3);
        int r10 = RangesKt.coerceIn(Math.max(r5, r8), 0, r3);
        boolean r11 = true;
        if (r9 != 0) goto L9;
        boolean r12 = true;
    L10:
        if (r10 == 0) goto L13;
        r11 = false;
    L13:
        Iterator r13 = r6.iterator();
    L15:
        if (r13.hasNext() == false) goto L32;
        Rect r14 = (Rect) r13.next();
        if (r14.isEmpty() == true) goto L15;
        if (r12 == true) goto L21;
    L25:
        if (r11 == false) goto L15;
        if (r14.right < r3) goto L15;
        int r15 = r14.left;
        if (r15 >= r3) goto L15;
        r10 = Math.max(r10, RangesKt.coerceIn(r3 - r15, 0, r3));
        goto L15
    L21:
        if (r14.left > 0) goto L25;
        int r0 = r14.right;
        if (r0 <= 0) goto L25;
        r9 = Math.max(r9, RangesKt.coerceIn(r0, 0, r3));
        goto L25
    L32:
        return new b(r9, r10);
    L9:
        r12 = false;
    L34:
        return new b(0, 0);
    }

    public static e d(int r8, int r9, int r10, b r11, int r12, int r13, a r14) {
        Intrinsics.checkNotNullParameter(r11, "cutoutInsets");
        Intrinsics.checkNotNullParameter(r14, "consumedNavigationBarInsets");
        if (r8 != 2) goto L5;
        Integer r2 = Integer.valueOf(Math.min(r9, r10));
        if (r2.intValue() <= 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == true) goto L13;
        r2 = null;
    L13:
        int r4 = -1;
        if (r2 == null) goto L16;
        int r5 = r2.intValue();
    L17:
        if (r9 <= 0) goto L20;
        if (r5 <= 0) goto L20;
        int r6 = RangesKt.coerceAtLeast(r9 - r5, 0);
    L21:
        int r0 = RangesKt.coerceAtMost((RangesKt.coerceAtLeast(r11.b, 0) + RangesKt.coerceAtLeast(r12, 0)) + RangesKt.coerceAtLeast(r14.a, 0), r6);
        if (r10 <= 0) goto L24;
        int r7 = RangesKt.coerceIn(r13, 0, r10 / 2);
    L25:
        if (r10 <= 0) goto L28;
        int r15 = r10 - r7;
        r4 = RangesKt.coerceAtLeast(r15 - (RangesKt.coerceAtLeast(r14.b, 0) + r7), 1);
    L28:
        return new e(r5, r4, 53, r0, r7, true);
    L24:
        r7 = 0;
    L20:
        r6 = 0;
        goto L21
    L16:
        r5 = -1;
        goto L17
    L9:
        r3 = false;
        goto L10
    L5:
        return new e(-1, -1, 8388659, 0, 0, false);
    }
}
