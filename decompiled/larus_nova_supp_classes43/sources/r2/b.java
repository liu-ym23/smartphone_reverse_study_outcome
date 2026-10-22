package r2;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class b {

    public static final class a extends b {
        public final List<d> a;
        public final int b;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L14;
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

        public a(List<d> r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "items");
            this.a = r10;
            this.b = r11;
        }
    }

    /* JADX INFO: renamed from: r2.b$b, reason: collision with other inner class name */
    public static final class C0188b extends b {
        public final r2.a a;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof C0188b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0188b) r10).a) == true) goto L11;
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

        public C0188b(r2.a r10) {
            Intrinsics.checkNotNullParameter(r10, "action");
            this.a = r10;
        }
    }

    public b() {
    }
}
