package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.larus.bmhome.chat.component.bottom.core.inputtext.t1;
import com.larus.bmhome.taskskill.b2;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class y {

    public static final class a extends y {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
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

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "title");
            this.a = r2;
        }
    }

    public static final class b extends y {
        public static final b a = null;

        static {
            a = new b();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof b) == true) goto L9;
            return false;
        L9:
            b r4 = (b) r3;
            return true;
        }

        public final int hashCode() {
            return 1817810821;
        }

        public final String toString() {
            return "Loading";
        }

        public b() {
        }
    }

    public static final class c extends y {
        public final h0 a;
        public final String b;
        public final Function0<Unit> c;
        public final Function0<Unit> d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Function0<Unit> r5 = this.c;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return ((r4 + r2) * 31) + this.d.hashCode();
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "More(trace=" + this.a + ", exposeId=" + this.b + ", onShow=" + this.c + ", action=" + this.d + ')';
        }

        public c(h0 r2, String r3, Function0<Unit> r4, Function0<Unit> r5) {
            Intrinsics.checkNotNullParameter(r2, "trace");
            Intrinsics.checkNotNullParameter(r5, "action");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class d extends y {
        public final String a;
        public final h0 b;
        public final g0 c;
        public final List<String> d;
        public final String e;
        public final t1 f;
        public final Integer g;
        public final b2.b h;
        public final String i;
        public final String j;
        public final com.larus.bmhome.chat.component.bottom.core.inputtext.i0 k;
        public final com.larus.bmhome.chat.referenceicon.b l;
        public final String m;
        public final String n;
        public final String o;
        public final String p;
        public final Function0<Unit> q;
        public final Function0<Unit> r;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
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
            if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
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
            if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.p, r6.p) == true) goto L57;
            return false;
        L57:
            if (Intrinsics.areEqual(this.q, r6.q) == true) goto L60;
            return false;
        L60:
            if (Intrinsics.areEqual(this.r, r6.r) == true) goto L62;
            return false;
        L62:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            g0 r1 = this.c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            List<String> r5 = this.d;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (((r4 + r6) * 31) + this.e.hashCode()) * 31;
            t1 r8 = this.f;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            Integer r11 = this.g;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            b2.b r14 = this.h;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            String r17 = this.i;
            if (r17 != null) goto L25;
            int r18 = 0;
        L26:
            int r19 = (r16 + r18) * 31;
            String r20 = this.j;
            if (r20 != null) goto L29;
            int r21 = 0;
        L30:
            int r22 = (r19 + r21) * 31;
            com.larus.bmhome.chat.component.bottom.core.inputtext.i0 r23 = this.k;
            if (r23 != null) goto L33;
            int r24 = 0;
        L34:
            int r25 = (r22 + r24) * 31;
            com.larus.bmhome.chat.referenceicon.b r26 = this.l;
            if (r26 != null) goto L37;
            int r27 = 0;
        L38:
            int r28 = (r25 + r27) * 31;
            String r29 = this.m;
            if (r29 != null) goto L41;
            int r30 = 0;
        L42:
            int r31 = (r28 + r30) * 31;
            String r32 = this.n;
            if (r32 != null) goto L45;
            int r33 = 0;
        L46:
            int r34 = (r31 + r33) * 31;
            String r35 = this.o;
            if (r35 != null) goto L49;
            int r36 = 0;
        L50:
            int r37 = (r34 + r36) * 31;
            String r38 = this.p;
            if (r38 != null) goto L53;
            int r39 = 0;
        L54:
            int r40 = (r37 + r39) * 31;
            Function0<Unit> r41 = this.q;
            if (r41 == null) goto L59;
            r2 = r41.hashCode();
        L59:
            return ((r40 + r2) * 31) + this.r.hashCode();
        L53:
            r39 = r38.hashCode();
            goto L54
        L49:
            r36 = r35.hashCode();
            goto L50
        L45:
            r33 = r32.hashCode();
            goto L46
        L41:
            r30 = r29.hashCode();
            goto L42
        L37:
            r27 = r26.hashCode();
            goto L38
        L33:
            r24 = r23.hashCode();
            goto L34
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
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Row(title=" + this.a + ", trace=" + this.b + ", anchorKey=" + this.c + ", titleHighlights=" + this.d + ", secondaryText=" + this.e + ", skillMatch=" + this.f + ", iconRes=" + this.g + ", skillIconColors=" + this.h + ", iconText=" + this.i + ", iconUrl=" + this.j + ", documentIcon=" + this.k + ", attachmentVisual=" + this.l + ", conversationId=" + this.m + ", avatarKey=" + this.n + ", avatarEntityId=" + this.o + ", exposeId=" + this.p + ", onShow=" + this.q + ", action=" + this.r + ')';
        }

        public /* synthetic */ d(String r23, h0 r24, g0 r25, List r26, String r27, t1 r28, Integer r29, b2.b r30, String r31, String r32, com.larus.bmhome.chat.component.bottom.core.inputtext.i0 r33, com.larus.bmhome.chat.referenceicon.b r34, String r35, String r36, String r37, Function0 r38, int r39) {
            if ((r39 & 4) == 0) goto L5;
            g0 r6 = null;
        L7:
            if ((r39 & 8) == 0) goto L9;
            List r7 = null;
        L11:
            if ((r39 & 16) == 0) goto L13;
            String r8 = "";
        L15:
            if ((r39 & 32) == 0) goto L17;
            t1 r9 = null;
        L19:
            if ((r39 & 128) == 0) goto L21;
            b2.b r11 = null;
        L23:
            if ((r39 & 256) == 0) goto L25;
            String r12 = null;
        L27:
            if ((r39 & 512) == 0) goto L29;
            String r13 = null;
        L31:
            if ((r39 & 1024) == 0) goto L33;
            com.larus.bmhome.chat.component.bottom.core.inputtext.i0 r14 = null;
        L35:
            if ((r39 & 2048) == 0) goto L37;
            com.larus.bmhome.chat.referenceicon.b r15 = null;
        L39:
            if ((r39 & 4096) == 0) goto L41;
            String r16 = null;
        L43:
            if ((r39 & 8192) == 0) goto L45;
            String r17 = null;
        L47:
            if ((r39 & 16384) == 0) goto L49;
            String r18 = null;
        L50:
            this(r23, r24, r6, r7, r8, r9, r29, r11, r12, r13, r14, r15, r16, r17, r18, null, null, r38);
            return;
        L49:
            r18 = r37;
            goto L50
        L45:
            r17 = r36;
            goto L47
        L41:
            r16 = r35;
            goto L43
        L37:
            r15 = r34;
            goto L39
        L33:
            r14 = r33;
            goto L35
        L29:
            r13 = r32;
            goto L31
        L25:
            r12 = r31;
            goto L27
        L21:
            r11 = r30;
            goto L23
        L17:
            r9 = r28;
            goto L19
        L13:
            r8 = r27;
            goto L15
        L9:
            r7 = r26;
            goto L11
        L5:
            r6 = r25;
            goto L7
        }

        public d(String r7, h0 r8, g0 r9, List<String> r10, String r11, t1 r12, Integer r13, b2.b r14, String r15, String r16, com.larus.bmhome.chat.component.bottom.core.inputtext.i0 r17, com.larus.bmhome.chat.referenceicon.b r18, String r19, String r20, String r21, String r22, Function0<Unit> r23, Function0<Unit> r24) {
            Intrinsics.checkNotNullParameter(r7, "title");
            Intrinsics.checkNotNullParameter(r8, "trace");
            Intrinsics.checkNotNullParameter(r11, "secondaryText");
            Intrinsics.checkNotNullParameter(r24, "action");
            this.a = r7;
            this.b = r8;
            this.c = r9;
            this.d = r10;
            this.e = r11;
            this.f = r12;
            this.g = r13;
            this.h = r14;
            this.i = r15;
            this.j = r16;
            this.k = r17;
            this.l = r18;
            this.m = r19;
            this.n = r20;
            this.o = r21;
            this.p = r22;
            this.q = r23;
            this.r = r24;
        }
    }

    public y() {
    }
}
