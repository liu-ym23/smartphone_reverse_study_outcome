package aha;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class h implements jha.o {
    public final Map<String, Object> a;

    public static final class a extends h {
        public final String b;
        public final jha.h c;
        public final Map<String, Object> d;

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
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.b.hashCode() * 31) + this.c.hashCode()) * 31;
            Map<String, Object> r1 = this.d;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "End(messageId=" + this.b + ", lifecycleStage=" + this.c + ", ext=" + this.d + ')';
        }

        @Override // jha.a
        public final jha.h a() {
            return this.c;
        }

        public a(String r3, Map r4) {
            jha.h.c r0 = jha.h.c.a;
            Intrinsics.checkNotNullParameter(r3, "messageId");
            Intrinsics.checkNotNullParameter(r0, "lifecycleStage");
            super(r0, r4);
            this.b = r3;
            this.c = r0;
            this.d = r4;
        }
    }

    public static final class b extends h {
        public final String b;
        public final jha.h c;
        public final Map<String, Object> d;

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
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.b.hashCode() * 31) + this.c.hashCode()) * 31;
            Map<String, Object> r1 = this.d;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "Start(messageId=" + this.b + ", lifecycleStage=" + this.c + ", ext=" + this.d + ')';
        }

        @Override // jha.a
        public final jha.h a() {
            return this.c;
        }

        public b(String r3, Map r4) {
            jha.h.a r0 = jha.h.a.a;
            Intrinsics.checkNotNullParameter(r3, "messageId");
            Intrinsics.checkNotNullParameter(r0, "lifecycleStage");
            super(r0, r4);
            this.b = r3;
            this.c = r0;
            this.d = r4;
        }
    }

    public h(jha.h r1, Map r2) {
        this.a = r2;
    }
}
