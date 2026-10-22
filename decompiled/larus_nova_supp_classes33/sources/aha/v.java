package aha;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class v implements jha.o {
    public final Map<String, Object> a;

    public static final class a extends v {
        public final String b;
        public final String c;
        public final jha.h d;
        public final Map<String, Object> e;

        public a() {
            throw null;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = this.b.hashCode() * 31;
            String r1 = this.c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((r0 + r3) * 31) + this.d.hashCode()) * 31;
            Map<String, Object> r5 = this.e;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "End(wakeupId=" + this.b + ", wakeupSource=" + this.c + ", lifecycleStage=" + this.d + ", ext=" + this.e + ')';
        }

        @Override // jha.a
        public final jha.h a() {
            return this.d;
        }

        public a(String r3, String r4, Map r5) {
            jha.h.c r0 = jha.h.c.a;
            Intrinsics.checkNotNullParameter(r3, "wakeupId");
            Intrinsics.checkNotNullParameter(r0, "lifecycleStage");
            super(r0, r5);
            this.b = r3;
            this.c = r4;
            this.d = r0;
            this.e = r5;
        }
    }

    public static final class b extends v {
        public final String b;
        public final String c;
        public final jha.h d;
        public final Map<String, Object> e;

        public b() {
            throw null;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = this.b.hashCode() * 31;
            String r1 = this.c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((r0 + r3) * 31) + this.d.hashCode()) * 31;
            Map<String, Object> r5 = this.e;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Start(wakeupId=" + this.b + ", wakeupSource=" + this.c + ", lifecycleStage=" + this.d + ", ext=" + this.e + ')';
        }

        @Override // jha.a
        public final jha.h a() {
            return this.d;
        }

        public b(String r3, String r4, Map r5) {
            jha.h.a r0 = jha.h.a.a;
            Intrinsics.checkNotNullParameter(r3, "wakeupId");
            Intrinsics.checkNotNullParameter(r0, "lifecycleStage");
            super(r0, r5);
            this.b = r3;
            this.c = r4;
            this.d = r0;
            this.e = r5;
        }
    }

    public v(jha.h r1, Map r2) {
        this.a = r2;
    }
}
