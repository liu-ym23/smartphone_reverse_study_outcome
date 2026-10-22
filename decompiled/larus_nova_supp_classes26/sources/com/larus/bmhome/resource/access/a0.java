package com.larus.bmhome.resource.access;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class a0 {

    public static final class a extends a0 {
        public final ResourceCancelReason a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.a == ((a) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Cancelled(reason=" + this.a + ')';
        }

        public a(ResourceCancelReason r2) {
            Intrinsics.checkNotNullParameter(r2, "reason");
            this.a = r2;
        }
    }

    public static final class b extends a0 {
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
            return -486198261;
        }

        public final String toString() {
            return "Created";
        }

        public b() {
        }
    }

    public static final class c extends a0 {
        public final r a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Failed(error=" + this.a + ')';
        }

        public c(r r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            this.a = r2;
        }
    }

    public static final class d extends a0 {
        public final f0 a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Ready(artifact=" + this.a + ')';
        }

        public d(f0 r2) {
            Intrinsics.checkNotNullParameter(r2, "artifact");
            this.a = r2;
        }
    }

    public static final class e extends a0 {
        public final ResourcePhase a;
        public final String b;
        public final j0 c;
        public final Map<String, String> d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof e) == true) goto L8;
            return false;
        L8:
            e r6 = (e) r5;
            if (this.a == r6.a) goto L12;
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
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            j0 r1 = this.c;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + this.d.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "Running(stage=" + this.a + ", nodeKey=" + this.b + ", resourceInput=" + this.c + ", attributes=" + this.d + ')';
        }

        public e(ResourcePhase r2, String r3, j0 r4, Map<String, String> r5) {
            Intrinsics.checkNotNullParameter(r2, "stage");
            Intrinsics.checkNotNullParameter(r3, "nodeKey");
            Intrinsics.checkNotNullParameter(r5, "attributes");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class f extends a0 {
        public final long a;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof f) == true) goto L9;
            return false;
        L9:
            if (this.a == ((f) r8).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (int) (r0 ^ (r0 >>> 32));
        }

        public final String toString() {
            return "Uploading(progress=" + this.a + ')';
        }

        public f(long r1) {
            this.a = r1;
        }
    }

    public a0() {
    }
}
