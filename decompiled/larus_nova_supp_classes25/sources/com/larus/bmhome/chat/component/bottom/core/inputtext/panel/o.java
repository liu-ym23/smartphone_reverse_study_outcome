package com.larus.bmhome.chat.component.bottom.core.inputtext.panel;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.larus.bmhome.chat.component.bottom.core.inputtext.t1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class o {

    public static final class a {
    }

    public static final class b extends o {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Header(title=" + this.a + ')';
        }

        public b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "title");
            this.a = r2;
        }
    }

    public static final class c extends o {
        public static final c a = null;

        static {
            a = new c();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof c) == true) goto L9;
            return false;
        L9:
            c r4 = (c) r3;
            return true;
        }

        public final int hashCode() {
            return 1636342859;
        }

        public final String toString() {
            return "Loading";
        }

        public c() {
        }
    }

    public static final class d extends o {
        public final String a;
        public final boolean b;
        public final String c;
        public final float d;
        public final t1 e;
        public final Integer f;
        public final Drawable g;
        public final Integer h;
        public final Integer i;
        public final Integer j;
        public final boolean k;
        public final String l;
        public final Function0<Unit> m;
        public final Function1<View, Unit> n;
        public final Function0<Unit> o;

        public d() {
            throw null;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Float.compare(this.d, r6.d) == 0) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
            return false;
        L39:
            if (this.k == r6.k) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.o, r6.o) == true) goto L53;
            return false;
        L53:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            int r2 = 1231;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (((((r0 + r1) * 31) + this.c.hashCode()) * 31) + Float.floatToIntBits(this.d)) * 31;
            t1 r4 = this.e;
            int r5 = 0;
            if (r4 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r3 + r6) * 31;
            Integer r8 = this.f;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            Drawable r11 = this.g;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            Integer r14 = this.h;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            Integer r17 = this.i;
            if (r17 != null) goto L25;
            int r18 = 0;
        L26:
            int r19 = (r16 + r18) * 31;
            Integer r20 = this.j;
            if (r20 != null) goto L29;
            int r21 = 0;
        L30:
            int r22 = (r19 + r21) * 31;
            if (this.k == true) goto L34;
            r2 = 1237;
        L34:
            int r23 = (r22 + r2) * 31;
            String r24 = this.l;
            if (r24 != null) goto L37;
            int r25 = 0;
        L38:
            int r26 = (r23 + r25) * 31;
            Function0<Unit> r27 = this.m;
            if (r27 != null) goto L41;
            int r28 = 0;
        L42:
            int r29 = (r26 + r28) * 31;
            Function1<View, Unit> r30 = this.n;
            if (r30 == null) goto L47;
            r5 = r30.hashCode();
        L47:
            return ((r29 + r5) * 31) + this.o.hashCode();
        L41:
            r28 = r27.hashCode();
            goto L42
        L37:
            r25 = r24.hashCode();
            goto L38
        L29:
            r21 = r20.hashCode();
            goto L30
        L25:
            r18 = r17.hashCode();
            goto L26
        L21:
            r15 = r14.hashCode();
            goto L22
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r4.hashCode();
            goto L10
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "Row(title=" + this.a + ", fadeTitleEnd=" + this.b + ", description=" + this.c + ", descriptionAlpha=" + this.d + ", skillMatch=" + this.e + ", iconRes=" + this.f + ", iconDrawable=" + this.g + ", iconTintColor=" + this.h + ", trailingIconRes=" + this.i + ", trailingIconTintColor=" + this.j + ", enabled=" + this.k + ", exposeId=" + this.l + ", onShow=" + this.m + ", onLongClick=" + this.n + ", action=" + this.o + ')';
        }

        public d(String r17, boolean r18, String r19, float r20, t1 r21, Integer r22, Drawable r23, Integer r24, Integer r25, Integer r26, String r27, Function0 r28, com.larus.bmhome.chat.component.bottom.core.inputtext.slash.m r29, Function0 r30, int r31) {
            boolean r5 = false;
            if ((r31 & 2) == 0) goto L5;
            boolean r4 = false;
        L7:
            if ((r31 & 4) == 0) goto L9;
            String r6 = "";
        L11:
            if ((r31 & 8) == 0) goto L13;
            float r7 = 0.55f;
        L14:
            com.larus.bmhome.chat.component.bottom.core.inputtext.slash.m r9 = null;
            if ((r31 & 16) == 0) goto L17;
            t1 r8 = null;
        L19:
            if ((r31 & 64) == 0) goto L21;
            Drawable r10 = null;
        L23:
            if ((r31 & 128) == 0) goto L25;
            Integer r11 = null;
        L27:
            if ((r31 & 256) == 0) goto L29;
            Integer r12 = null;
        L31:
            if ((r31 & 512) == 0) goto L33;
            Integer r13 = null;
        L35:
            if ((r31 & 1024) == 0) goto L38;
            r5 = true;
        L38:
            if ((r31 & 2048) == 0) goto L40;
            String r14 = null;
        L42:
            if ((r31 & 4096) == 0) goto L44;
            Function0 r15 = null;
        L46:
            if ((r31 & 8192) != 0) goto L49;
            r9 = r29;
        L49:
            Intrinsics.checkNotNullParameter(r17, "title");
            Intrinsics.checkNotNullParameter(r6, "description");
            Intrinsics.checkNotNullParameter(r30, "action");
            this.a = r17;
            this.b = r4;
            this.c = r6;
            this.d = r7;
            this.e = r8;
            this.f = r22;
            this.g = r10;
            this.h = r11;
            this.i = r12;
            this.j = r13;
            this.k = r5;
            this.l = r14;
            this.m = r15;
            this.n = r9;
            this.o = r30;
            return;
        L44:
            r15 = r28;
            goto L46
        L40:
            r14 = r27;
            goto L42
        L33:
            r13 = r26;
            goto L35
        L29:
            r12 = r25;
            goto L31
        L25:
            r11 = r24;
            goto L27
        L21:
            r10 = r23;
            goto L23
        L17:
            r8 = r21;
            goto L19
        L13:
            r7 = r20;
            goto L14
        L9:
            r6 = r19;
            goto L11
        L5:
            r4 = r18;
            goto L7
        }
    }

    static {
    }

    public o() {
    }
}
