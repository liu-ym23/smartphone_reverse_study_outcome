package v1a;

import kotlin.jvm.internal.Intrinsics;
import w1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b<S extends w1a.b> {
    public final S a;
    public a<S> b;

    public static final class a<S extends w1a.b> {
        public final S a;
        public final int b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "StateWrapper(state=" + this.a + ')';
        }

        public a(S r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
            this.a = r2;
            this.b = hashCode();
        }
    }

    public b(S r2) {
        Intrinsics.checkNotNullParameter(r2, "initialState");
        this.a = r2;
        this.b = new a(r2);
    }
}
