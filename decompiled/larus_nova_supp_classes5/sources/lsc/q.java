package lsc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class q<T> {
    public final String a;

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Prop{name='" + this.a + "'}";
    }

    public q(String r1) {
        this.a = r1;
    }

    public final T a(t r1) {
        return (T) ((u) r1).a(this);
    }

    public final T b(t r2) {
        T r3 = a(r2);
        if (r3 == null) goto L6;
        return r3;
    L6:
        throw new NullPointerException(this.a);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (q.class == r3.getClass()) goto L10;
        return false;
    L10:
        return this.a.equals(((q) r3).a);
    }

    public final void c(t r1, T r2) {
        ((u) r1).c(this, r2);
    }
}
