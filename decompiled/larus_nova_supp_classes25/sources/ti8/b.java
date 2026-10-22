package ti8;

import com.larus.bmhome.chat.search.factory.ExpandCardViewMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b {
    public static final /* synthetic */ int m = 0;
    public final int a;
    public final int b;
    public final String c;
    public final String d;
    public final int e;
    public final int f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final String l;

    public static final class a {

        /* JADX INFO: renamed from: ti8.b$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0087a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ExpandCardViewMode.values().length];
                r0[ExpandCardViewMode.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L19:
                r0[ExpandCardViewMode.EXPAND_PIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L27:
                r0[ExpandCardViewMode.NORMAL_PIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
            L21:
                r0[ExpandCardViewMode.EXPAND.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            L23:
                r0[ExpandCardViewMode.NORMAL_SHARE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
            L17:
                r0[ExpandCardViewMode.EXPAND_SHARE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
            L9:
                a = r0;
            }
        }
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((r4 + r6) * 31) + this.e) * 31) + this.f) * 31;
        int r8 = 1231;
        if (this.g == false) goto L13;
        int r9 = 1231;
    L14:
        int r10 = (r7 + r9) * 31;
        if (this.h == false) goto L17;
        int r11 = 1231;
    L18:
        int r12 = (r10 + r11) * 31;
        if (this.i == false) goto L21;
        int r13 = 1231;
    L22:
        int r14 = (r12 + r13) * 31;
        if (this.j == false) goto L25;
        int r15 = 1231;
    L26:
        int r16 = (r14 + r15) * 31;
        if (this.k == true) goto L30;
        r8 = 1237;
    L30:
        int r17 = (r16 + r8) * 31;
        String r18 = this.l;
        if (r18 == null) goto L35;
        r2 = r18.hashCode();
    L35:
        return r17 + r2;
    L25:
        r15 = 1237;
        goto L26
    L21:
        r13 = 1237;
        goto L22
    L17:
        r11 = 1237;
        goto L18
    L13:
        r9 = 1237;
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "SearchImageCardViewData(width=" + this.a + ", height=" + this.b + ", imageUrl=" + this.c + ", imageUri=" + this.d + ", foldCount=" + this.e + ", cornerRadius=" + this.f + ", roundTopLeft=" + this.g + ", roundTopRight=" + this.h + ", roundBottomLeft=" + this.i + ", roundBottomRight=" + this.j + ", needShowSourceIcon=" + this.k + ", mainSiteUrl=" + this.l + ')';
    }

    public b(int r1, int r2, String r3, String r4, int r5, int r6, boolean r7, boolean r8, boolean r9, boolean r10, boolean r11, String r12) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
    }
}
