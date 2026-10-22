package com.bytedance.android.live.core.tetris.layer.view;

import j70.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ElementConstraintDSLMarker
public final class ElementConstraint {
    public static final ElementConstraint n = null;
    public int a;
    public int b;
    public float c;
    public float d;
    public float e;
    public float f;
    public boolean g;
    public boolean h;
    public int i;
    public final List<c> j;
    public float k;
    public float l;
    public float m;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/view/ElementConstraint$Side;", "", "", "value", "I", "getValue", "()I", "LEFT", "RIGHT", "TOP", "BOTTOM", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Side extends Enum<Side> {
        public static final Side BOTTOM = null;
        public static final Side LEFT = null;
        public static final Side RIGHT = null;
        public static final Side TOP = null;
        public static final /* synthetic */ Side[] a = null;
        private final int value;

        static {
            Side r2 = new Side("LEFT", 0, 1);
            LEFT = r2;
            Side r3 = new Side("RIGHT", 1, 2);
            RIGHT = r3;
            Side r4 = new Side("TOP", 2, 3);
            TOP = r4;
            Side r5 = new Side("BOTTOM", 3, 4);
            BOTTOM = r5;
            a = new Side[]{r2, r3, r4, r5};
        }

        public static Side valueOf(String r1) {
            return (Side) r27.a.a(Side.class, r1);
        }

        public static Side[] values() {
            return (Side[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public Side(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
        public final boolean a;
        public final boolean b;
        public final f c;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.c, ((a) r2).c) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            f r0 = this.c;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "Anchor(anchorType=" + this.c + ")";
        }

        public a(f r2) {
            Intrinsics.checkNotNullParameter(r2, "anchorType");
            this.c = r2;
            f r0 = f.c;
            this.a = Intrinsics.areEqual(r2, f.d);
            this.b = Intrinsics.areEqual(r2, f.e);
        }
    }

    public static final class b {
        public static ElementConstraint a() {
            return new ElementConstraint(-1.0f, -1.0f);
        }
    }

    @ElementConstraintDSLMarker
    public static final class c {
        public final int a;
        public final a b;
        public final int c;
        public float d;
        public final int e;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof c) == false) goto L16;
            c r4 = (c) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L12;
            return false;
        L12:
            if (Float.compare(this.d, r4.d) == 0) goto L14;
            return false;
        L14:
            if (this.e == r4.e) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            a r1 = this.b;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return ((((((r0 + r2) * 31) + this.c) * 31) + Float.floatToIntBits(this.d)) * 31) + this.e;
        L5:
            r2 = 0;
            goto L7
        }

        public final String toString() {
            return "Rule(startSide=" + this.a + ", anchor=" + this.b + ", endSide=" + this.c + ", marginDp=" + this.d + ", marginPx=" + this.e + ")";
        }

        public c(int r2, a r3, int r4, float r5, int r6, int r7) {
            if ((r7 & 8) == 0) goto L6;
            r5 = 0.0f;
        L6:
            if ((r7 & 16) == 0) goto L8;
            r6 = 0;
        L8:
            Intrinsics.checkNotNullParameter(r3, "anchor");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    @ElementConstraintDSLMarker
    public static final class d {
        public float a;
        public float b;
        public int c;
        public int d;

        public static final class a {
        }

        static {
        }

        public d() {
            this.a = -2.0f;
            this.b = -2.0f;
        }
    }

    public ElementConstraint() {
        float r1 = 0.0f;
        this(r1, 3);
    }

    static {
        n = new ElementConstraint(-2.0f, -2.0f);
    }

    public final void j(Function1 r2) {
        Intrinsics.checkNotNullParameter(r2, "init");
        d r0 = new d();
        r2.invoke(r0);
        this.l = r0.a;
        this.a = r0.c;
        this.m = r0.b;
        this.b = r0.d;
    }

    public ElementConstraint(float r1, float r2) {
        this.l = r1;
        this.m = r2;
        this.i = -1;
        this.j = new ArrayList();
    }

    public final void a(f r2, Function1 r3) {
        Intrinsics.checkNotNullParameter(r2, "anchor");
        Side r0 = Side.BOTTOM;
        c(r0, r2, r0, r3);
    }

    public final void f(f r2, Function1 r3) {
        Intrinsics.checkNotNullParameter(r2, "anchor");
        Side r0 = Side.LEFT;
        c(r0, r2, r0, r3);
    }

    public final void g(f r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r3, "anchor");
        c(Side.LEFT, r3, Side.RIGHT, r4);
    }

    public final void h(f r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r3, "anchor");
        c(Side.RIGHT, r3, Side.LEFT, r4);
    }

    public final void i(f r2, Function1 r3) {
        Intrinsics.checkNotNullParameter(r2, "anchor");
        Side r0 = Side.RIGHT;
        c(r0, r2, r0, r3);
    }

    public final void k(f r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r3, "anchor");
        c(Side.TOP, r3, Side.BOTTOM, r4);
    }

    public final void l(f r2, Function1 r3) {
        Intrinsics.checkNotNullParameter(r2, "anchor");
        Side r0 = Side.TOP;
        c(r0, r2, r0, r3);
    }

    public /* synthetic */ ElementConstraint(float r3, int r4) {
        float r1 = -2.0f;
        if ((r4 & 1) == 0) goto L6;
        r3 = -2.0f;
    L6:
        if ((r4 & 2) != 0) goto L9;
        r1 = 0.0f;
    L9:
        this(r3, r1);
    }

    public ElementConstraint(int r2, int r3) {
        this(0.0f, 0.0f);
        this.a = r2;
        this.b = r3;
    }

    public final void d(Side r2, Side r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "startSide");
        Intrinsics.checkNotNullParameter(r3, "parentSide");
        b(r2, f.d, r3, r4);
    }

    @Deprecated(message = "建议使用诸如 leftToLeft 之类的调用", replaceWith = @ReplaceWith(expression = "leftToLeft,leftToRight...", imports = {}))
    public final void e(Side r9, Side r11, int r12) {
        Intrinsics.checkNotNullParameter(r9, "startSide");
        Intrinsics.checkNotNullParameter(r11, "parentSide");
        a r3 = new a(f.d);
        c r0 = new c(r9.getValue(), r3, r11.getValue(), 0.0f, r12, 8);
        ((ArrayList) this.j).add(r0);
    }

    public final void b(Side r9, f r11, Side r12, float r13) {
        Intrinsics.checkNotNullParameter(r9, "startSide");
        Intrinsics.checkNotNullParameter(r11, "anchorType");
        Intrinsics.checkNotNullParameter(r12, "endSide");
        a r3 = new a(r11);
        c r14 = new c(r9.getValue(), r3, r12.getValue(), r13, 0, 16);
        ((ArrayList) this.j).add(r14);
    }

    public final void c(Side r8, f r9, Side r11, Function1 r12) {
        a r2 = new a(r9);
        c r13 = new c(r8.getValue(), r2, r11.getValue(), 0.0f, 0, 24);
        if (r12 == null) goto L5;
        r12.invoke(r13);
    L5:
        ((ArrayList) this.j).add(r13);
    }
}
