package oy;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public final Triple<Integer, Integer, String> a;
    public final LayoutConfigModel b;
    public final LayoutConfigModel.g c;
    public final LayoutConfigModel.b d;
    public final LayoutConfigModel.d e;
    public final mn0.a f;

    public static final class a {
    }

    /* JADX INFO: renamed from: oy.b$b, reason: collision with other inner class name */
    public static final class C0256b {
        public final int a;
        public final int b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof C0256b) == false) goto L10;
            C0256b r4 = (C0256b) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "Position[" + this.a + ", " + this.b + ']';
        }

        public C0256b(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c {
        public final C0256b a;
        public final d b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof c) == false) goto L10;
            c r4 = (c) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            C0256b r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            d r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return this.b + ", " + this.a;
        }

        public c(C0256b r2, d r3) {
            Intrinsics.checkNotNullParameter(r2, "position");
            Intrinsics.checkNotNullParameter(r3, "size");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class d {
        public final int a;
        public final int b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof d) == false) goto L10;
            d r4 = (d) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "Size[" + this.a + ", " + this.b + ']';
        }

        public d(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public final c c(Pair r5) {
        int r0 = ((Number) r5.getFirst()).intValue();
        int r6 = ((Number) r5.getSecond()).intValue();
        this.f.getClass();
        return new c(new C0256b(0, 0), new d(r0, r6));
    }

    public static d a(c r2, float r3) {
        boolean r0 = true;
        if (r3 > 1) goto L6;
        r0 = false;
    L6:
        if (r0 == false) goto L10;
        d r4 = r2.b;
        int r1 = r4.b;
        int r5 = (int) (r1 * r3);
        int r6 = r4.a;
        if (r5 >= r6) goto L14;
        r1 = (int) (r6 / r3);
        r5 = r6;
    L14:
        return new d(r5, r1);
    L10:
        d r7 = r2.b;
        r5 = r7.a;
        r1 = (int) (r5 / r3);
        int r8 = r7.b;
        if (r1 >= r8) goto L14;
        r5 = (int) (r8 * r3);
        r1 = r8;
        goto L14
    }

    public static d b(c r2, float r3) {
        boolean r0 = true;
        if (r3 > 1) goto L6;
        r0 = false;
    L6:
        if (r0 == false) goto L10;
        d r4 = r2.b;
        int r1 = r4.a;
        int r5 = (int) (r1 / r3);
        int r6 = r4.b;
        if (r5 <= r6) goto L14;
        r1 = (int) (r6 * r3);
        r5 = r6;
    L14:
        return new d(r1, r5);
    L10:
        d r7 = r2.b;
        r5 = r7.b;
        r1 = (int) (r5 * r3);
        int r8 = r7.a;
        if (r1 <= r8) goto L14;
        r5 = (int) (r8 / r3);
        r1 = r8;
        goto L14
    }

    public final C0256b d(d r14, c r15) {
        C0256b r0 = r15.a;
        int r1 = r0.a;
        int r2 = r0.b;
        int r3 = this.b.d();
        int r4 = this.b.j();
        if (r3 == 5) goto L9;
        if (r3 == 2) goto L9;
        if (r3 == 8) goto L9;
        if (r3 == 4) goto L9;
        if (r3 == 6) goto L9;
    L36:
        if (r3 == 1) goto L39;
        if (r3 == 3) goto L39;
        if (r3 == 2) goto L39;
    L41:
        if (r3 == 9) goto L44;
        if (r3 == 3) goto L44;
        if (r3 == 6) goto L44;
    L46:
        return new C0256b(r1, r2);
    L44:
        r1 = r1 + (r15.b.a - r14.a);
    L39:
        r2 = r2 + (r15.b.b - r14.b);
    L9:
        if (r4 != 1) goto L22;
        int r5 = r14.a;
        d r11 = r15.b;
        int r12 = r11.a;
        if (r5 >= r12) goto L16;
        if (r3 == 5) goto L15;
        if (r3 == 2) goto L15;
        if (r3 != 8) goto L16;
    L15:
        r1 = r1 + ((int) ((r12 - r5) / 2.0f));
    L16:
        int r6 = r14.b;
        int r7 = r11.b;
        if (r6 >= r7) goto L36;
        if (r3 == 5) goto L34;
        if (r3 == 4) goto L34;
        if (r3 != 6) goto L36;
    L34:
        r2 = r2 + ((int) ((r7 - r6) / 2.0f));
        goto L36
    L22:
        if (r4 != 2) goto L36;
        int r8 = r14.a;
        d r13 = r15.b;
        int r16 = r13.a;
        if (r8 <= r16) goto L29;
        if (r3 == 5) goto L28;
        if (r3 == 2) goto L28;
        if (r3 != 8) goto L29;
    L28:
        r1 = r1 + ((int) ((r16 - r8) / 2.0f));
    L29:
        r6 = r14.b;
        r7 = r13.b;
        if (r6 <= r7) goto L36;
        if (r3 == 5) goto L34;
        if (r3 == 4) goto L34;
        if (r3 != 6) goto L36;
        goto L34
    }

    public final c e(c r7, LayoutConfigModel.g r8) {
        C0256b r0 = r7.a;
        int r1 = r0.a;
        int r2 = r0.b;
        d r9 = r7.b;
        int r3 = r9.a;
        int r11 = r9.b;
        float r4 = ((Number) this.a.getSecond()).intValue() / Math.max(s1.w(), ((Number) this.a.getSecond()).intValue());
        if (r8.e() <= 0) goto L6;
        int r5 = (int) (s1.f(r8.e()) * r4);
        r11 = r11 - r5;
        r2 = r2 + r5;
    L6:
        if (r8.b() <= 0) goto L9;
        r11 = r11 - ((int) (s1.f(r8.b()) * r4));
    L9:
        if (r8.c() <= 0) goto L12;
        int r6 = (int) (s1.f(r8.c()) * r4);
        r3 = r3 - r6;
        r1 = r1 + r6;
    L12:
        if (r8.d() <= 0) goto L15;
        r3 = r3 - ((int) (s1.f(r8.d()) * r4));
    L15:
        return new c(new C0256b(r1, r2), new d(r3, r11));
    }

    public b(Triple<Integer, Integer, String> r2, LayoutConfigModel r3, LayoutConfigModel.g r4, LayoutConfigModel.b r5, LayoutConfigModel.d r6, mn0.a r7) {
        Intrinsics.checkNotNullParameter(r2, "absContainerWHAndReason");
        Intrinsics.checkNotNullParameter(r3, "layoutConfig");
        Intrinsics.checkNotNullParameter(r4, "uiMarginParams");
        Intrinsics.checkNotNullParameter(r5, "canvasParams");
        Intrinsics.checkNotNullParameter(r6, "contentParams");
        Intrinsics.checkNotNullParameter(r7, "configParams");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
