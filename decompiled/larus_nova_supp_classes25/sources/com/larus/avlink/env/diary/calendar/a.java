package com.larus.avlink.env.diary.calendar;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.larus.avlink.env.diary.calendar.a$a, reason: collision with other inner class name */
    public static final class C0005a extends a {
        public final int a;
        public final int b;
        public final int c;
        public final boolean d;
        public final String e;
        public final boolean f;
        public final String g;
        public final boolean h;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0005a) == true) goto L8;
            return false;
        L8:
            C0005a r6 = (C0005a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a * 31) + this.b) * 31) + this.c) * 31;
            int r2 = 1231;
            if (this.d == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (r0 + r1) * 31;
            String r4 = this.e;
            int r5 = 0;
            if (r4 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r3 + r6) * 31;
            if (this.f == false) goto L13;
            int r8 = 1231;
        L14:
            int r9 = (r7 + r8) * 31;
            String r10 = this.g;
            if (r10 == null) goto L18;
            r5 = r10.hashCode();
        L18:
            int r11 = (r9 + r5) * 31;
            if (this.h == true) goto L23;
            r2 = 1237;
        L23:
            return r11 + r2;
        L13:
            r8 = 1237;
            goto L14
        L9:
            r6 = r4.hashCode();
            goto L10
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "DayItem(year=" + this.a + ", month=" + this.b + ", day=" + this.c + ", hasDiary=" + this.d + ", emojiUrl=" + this.e + ", isToday=" + this.f + ", diaryId=" + this.g + ", isSelected=" + this.h + ')';
        }

        public static C0005a a(C0005a r9, boolean r10) {
            int r1 = r9.a;
            int r2 = r9.b;
            int r3 = r9.c;
            boolean r4 = r9.d;
            String r5 = r9.e;
            boolean r6 = r9.f;
            String r7 = r9.g;
            r9.getClass();
            return new C0005a(r1, r2, r3, r4, r5, r6, r7, r10);
        }

        public /* synthetic */ C0005a(int r10, int r11, int r12, boolean r13, String r14, boolean r15, String r16) {
            this(r10, r11, r12, r13, r14, r15, r16, false);
        }

        public C0005a(int r1, int r2, int r3, boolean r4, String r5, boolean r6, String r7, boolean r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }
    }

    public a() {
    }
}
