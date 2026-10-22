package q1c;

import com.larksuite.framework.callback.Entity.ErrorResult;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class b<T> {

    public static final class a extends b {
        public final ErrorResult a;

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
            return "Error(error=" + this.a + ')';
        }

        public a(ErrorResult r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            this.a = r2;
        }
    }

    /* JADX INFO: renamed from: q1c.b$b, reason: collision with other inner class name */
    public static final class C0179b<T> extends b<T> {
        public final T a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0179b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0179b) r4).a) == true) goto L11;
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

        public C0179b(T r1) {
            this.a = r1;
        }
    }

    public b() {
    }

    public final T a() {
        if ((this instanceof C0179b) == false) goto L6;
        return ((C0179b) this).a;
    L6:
        if ((this instanceof a) == false) goto L10;
        return null;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
