package h80;

import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c<T> {
    public static final c<?> b = null;
    public final T a;

    static {
        b = new c();
    }

    public final T a() {
        T r0 = this.a;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NoSuchElementException("No value present");
    }

    public final boolean b() {
        if (this.a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final int hashCode() {
        T r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        T r0 = this.a;
        if (r0 != null) goto L7;
        return "Optional.empty";
    L7:
        return String.format("Optional[%s]", new Object[]{r0});
    }

    public c() {
        this.a = null;
    }

    public c(T r1) {
        Objects.requireNonNull(r1);
        this.a = r1;
    }

    public static <T> c<T> c(T r1) {
        if (r1 != null) goto L5;
        return (c<T>) b;
    L5:
        return new c(r1);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof c) == true) goto L8;
        return false;
    L8:
        T r1 = this.a;
        T r5 = ((c) r4).a;
        if (r1 == r5) goto L16;
        if (r1 != null) goto L12;
    L14:
        return false;
    L12:
        if (r1.equals(r5) == false) goto L14;
        return true;
    L16:
        return true;
    }
}
