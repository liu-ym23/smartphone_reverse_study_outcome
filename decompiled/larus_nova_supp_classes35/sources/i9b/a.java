package i9b;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: i9b.a$a, reason: collision with other inner class name */
    public static final class C0235a extends a {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0235a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0235a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Error(message=" + this.a + ')';
        }

        public C0235a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            this.a = r2;
        }
    }

    public static final class b extends a {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c<T> extends a<T> {
        public final T a;

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
            T r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "Success(data=" + this.a + ')';
        }

        public c(T r1) {
            this.a = r1;
        }
    }

    public a() {
    }
}
