package xd;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class e<T> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f13869a;

    public static final class a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f13870a;

        public a(Throwable r8) {
            he.i.f(r8, "exception");
            this.f13870a = r8;
        }

        public final boolean equals(Object r8) {
            if ((r8 instanceof a) == false) goto L7;
            Throwable r10 = ((a) r8).f13870a;
            if (he.i.a(this.f13870a, r10) == false) goto L7;
            return true;
        L7:
            return false;
        }

        public final int hashCode() {
            return this.f13870a.hashCode();
        }

        public final String toString() {
            return "Failure(" + this.f13870a + ')';
        }
    }

    public /* synthetic */ e(Object r8) {
        this.f13869a = r8;
    }

    public static final Throwable a(Object r8) {
        if ((r8 instanceof a) == true) goto L7;
        return null;
    L7:
        return ((a) r8).f13870a;
    }

    public static final boolean b(Object r8) {
        return r8 instanceof a;
    }

    public static final boolean c(Object r8) {
        return !(r8 instanceof a);
    }

    public final boolean equals(Object r8) {
        if ((r8 instanceof e) == false) goto L10;
        Object r10 = ((e) r8).f13869a;
        if (he.i.a(this.f13869a, r10) == false) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }

    public final int hashCode() {
        Object r8 = this.f13869a;
        if (r8 != null) goto L6;
        return 0;
    L6:
        return r8.hashCode();
    }

    public final String toString() {
        Object r8 = this.f13869a;
        if ((r8 instanceof a) == false) goto L6;
        return ((a) r8).toString();
    L6:
        return "Success(" + r8 + ')';
    }
}
