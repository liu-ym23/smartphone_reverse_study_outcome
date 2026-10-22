package com.obric.miniapp.alarm;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class l {
    public static final Regex a = null;

    public static final class a {
        public final String a;
        public final String b;
        public final boolean c;
        public final int d;
        public final List<String> e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = (r0 + r2) * 31;
            if (this.c == false) goto L9;
            int r4 = 1231;
        L11:
            return ((((r3 + r4) * 31) + this.d) * 31) + this.e.hashCode();
        L9:
            r4 = 1237;
            goto L11
        L5:
            r2 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "CombinedResult(ttsContent=" + this.a + ", eventName=" + this.b + ", shouldReport=" + this.c + ", alarmCount=" + this.d + ", alarmIds=" + this.e + ')';
        }

        public a(String r2, String r3, boolean r4, int r5, List<String> r6) {
            Intrinsics.checkNotNullParameter(r2, "ttsContent");
            Intrinsics.checkNotNullParameter(r6, "alarmIds");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class b {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "ParsedContent(timePart=" + this.a + ", taskPart=" + this.b + ')';
        }

        public b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "timePart");
            Intrinsics.checkNotNullParameter(r3, "taskPart");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
        a = new Regex("<([^>]+)>");
    }
}
