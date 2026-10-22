package lx9;

import com.larus.suggest.impl.wcb.policy.z;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface a {

    /* JADX INFO: renamed from: lx9.a$a, reason: collision with other inner class name */
    public static final class C0066a implements a {
        public final z a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0066a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0066a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Initial(current=" + this.a + ')';
        }

        public C0066a(z r2) {
            Intrinsics.checkNotNullParameter(r2, "current");
            this.a = r2;
        }
    }

    public static final class b implements a {
        public final z a;
        public final z b;

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
            return "Switched(previous=" + this.a + ", current=" + this.b + ')';
        }

        public b(z r2, z r3) {
            Intrinsics.checkNotNullParameter(r2, "previous");
            Intrinsics.checkNotNullParameter(r3, "current");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c implements a {
        public final z a;

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
            return "Unchanged(current=" + this.a + ')';
        }

        public c(z r2) {
            Intrinsics.checkNotNullParameter(r2, "current");
            this.a = r2;
        }
    }

    public static final class d implements a {
        public final lx9.d a;

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
            return "Unsupported(key=" + this.a + ')';
        }

        public d(lx9.d r2) {
            Intrinsics.checkNotNullParameter(r2, "key");
            this.a = r2;
        }
    }
}
