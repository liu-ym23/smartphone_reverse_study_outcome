package ys8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class b {

    public static final class a extends b {
        public final long a;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.a == ((a) r8).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (int) (r0 ^ (r0 >>> 32));
        }

        public final String toString() {
            return "Apply(modelId=" + this.a + ')';
        }

        public a(long r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: ys8.b$b, reason: collision with other inner class name */
    public static final class C0143b extends b {
        public static final C0143b a = null;

        static {
            a = new C0143b();
        }

        public C0143b() {
        }
    }

    public static final class c extends b {
        public final String a;

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
            String r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "Reject(displayText=" + this.a + ')';
        }

        public c(String r1) {
            this.a = r1;
        }
    }

    public b() {
    }
}
