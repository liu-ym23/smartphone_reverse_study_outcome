package h0c;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class b<T> {
    public static final /* synthetic */ int b = 0;
    public final T a;

    public static final class a {
    }

    /* JADX INFO: renamed from: h0c.b$b, reason: collision with other inner class name */
    public static final class C0143b<T> extends b<T> {
        public C0143b(T r1) {
            super(r1);
        }
    }

    public static final class c<T> extends b<T> {
        public c(T r1) {
            super(r1);
        }
    }

    static {
    }

    public b() {
        throw null;
    }

    public final int hashCode() {
        T r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Object r1) {
        this.a = r1;
    }

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
}
