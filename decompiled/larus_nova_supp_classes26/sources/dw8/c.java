package dw8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class c {

    public static final class a extends c {
        public final List<e> a;
        public final int b;

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
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b;
        }

        public final String toString() {
            return "ActionGroup(items=" + this.a + ", rowCount=" + this.b + ')';
        }

        public a(List<e> r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "items");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b extends c {
        public final dw8.b a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Execute(action=" + this.a + ')';
        }

        public b(dw8.b r2) {
            Intrinsics.checkNotNullParameter(r2, "action");
            this.a = r2;
        }
    }

    public c() {
    }
}
