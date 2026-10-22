package o9b;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class a {

    /* JADX INFO: renamed from: o9b.a$a, reason: collision with other inner class name */
    public static final class C0270a extends a {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0270a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0270a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Empty(query=" + this.a + ')';
        }

        public C0270a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "query");
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

    public static final class c extends a {
        public final List<mtb.d> a;

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
            return "Results(items=" + this.a + ')';
        }

        public c(List<mtb.d> r2) {
            Intrinsics.checkNotNullParameter(r2, "items");
            this.a = r2;
        }
    }

    public static final class d extends a {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }
    }

    public a() {
    }
}
