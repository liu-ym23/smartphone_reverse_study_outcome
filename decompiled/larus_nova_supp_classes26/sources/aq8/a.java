package aq8;

import com.larus.bmhome.actionbar.model.x0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class a {

    /* JADX INFO: renamed from: aq8.a$a, reason: collision with other inner class name */
    public static final class C0001a extends a {
        public final Throwable a;

        public C0001a() {
            this(null);
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0001a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0001a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Throwable r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "Error(throwable=" + this.a + ')';
        }

        public C0001a(Throwable r1) {
            this.a = r1;
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

    public static final class c extends a {
        public final x0 a;

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
            return "Success(result=" + this.a + ')';
        }

        public c(x0 r2) {
            Intrinsics.checkNotNullParameter(r2, "result");
            this.a = r2;
        }
    }

    public a() {
    }
}
