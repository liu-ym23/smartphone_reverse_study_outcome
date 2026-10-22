package kotlinx.coroutines.channels;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@JvmInline
public final class g<T> {
    public static final c b = null;
    public final Object a;

    public static final class b {
    }

    public static class c {
        public c() {
        }

        public String toString() {
            return "Failed";
        }
    }

    static {
        b = new c();
    }

    public final int hashCode() {
        Object r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        Object r0 = this.a;
        if ((r0 instanceof a) == false) goto L6;
        return ((a) r0).toString();
    L6:
        return "Value(" + r0 + ')';
    }

    public /* synthetic */ g(Object r1) {
        this.a = r1;
    }

    public static final Throwable a(Object r2) {
        if ((r2 instanceof a) == false) goto L5;
        a r3 = (a) r2;
    L6:
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3.a;
    L5:
        r3 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final T b(Object r1) {
        if ((r1 instanceof c) == false) goto L7;
        return null;
    L7:
        return r1;
    }

    public static final void c(Object r3) {
        if ((r3 instanceof c) == true) goto L6;
        return;
    L6:
        if ((r3 instanceof a) == false) goto L11;
        Throwable r0 = ((a) r3).a;
        if (r0 == null) goto L11;
        throw r0;
    L11:
        throw new IllegalStateException(("Trying to call 'getOrThrow' on a failed channel result: " + r3).toString());
    }

    public final boolean equals(Object r4) {
        Object r0 = this.a;
        if ((r4 instanceof g) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r0, ((g) r4).a) == false) goto L11;
        return true;
    L11:
        return false;
    }
}
