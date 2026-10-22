package lq8;

import com.larus.bmhome.interactionpanel.o;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class a {

    /* JADX INFO: renamed from: lq8.a$a, reason: collision with other inner class name */
    public static final class C0117a extends a {
        public final List<o> a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0117a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0117a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Hide(keys=" + this.a + ')';
        }

        public C0117a(List<o> r2) {
            Intrinsics.checkNotNullParameter(r2, "keys");
            this.a = r2;
        }
    }

    public static final class b extends a {
        public final List<d> a;

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
            return "Upsert(inputs=" + this.a + ')';
        }

        public b(List<d> r2) {
            Intrinsics.checkNotNullParameter(r2, "inputs");
            this.a = r2;
        }
    }

    public a() {
    }
}
