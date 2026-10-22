package xb;

import io.reactivex.internal.util.NotificationLite;

/* JADX INFO: loaded from: classes2.dex */
public final class l<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final l<Object> f13579b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object f13580a;

    static {
        f13579b = new l(null);
    }

    private l(Object r10) {
        this.f13580a = r10;
    }

    public static <T> l<T> a() {
        return (l<T>) f13579b;
    }

    public static <T> l<T> b(Throwable r10) {
        io.reactivex.internal.functions.a.d(r10, "error is null");
        return new l(NotificationLite.error(r10));
    }

    public static <T> l<T> c(T r10) {
        io.reactivex.internal.functions.a.d(r10, "value is null");
        return new l(r10);
    }

    public Throwable d() {
        Object r10 = this.f13580a;
        if (NotificationLite.isError(r10) == true) goto L5;
        return null;
    L5:
        return NotificationLite.getError(r10);
    }

    public boolean e() {
        return NotificationLite.isError(this.f13580a);
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof l) == true) goto L5;
        return false;
    L5:
        return io.reactivex.internal.functions.a.c(this.f13580a, ((l) r10).f13580a);
    }

    public int hashCode() {
        Object r10 = this.f13580a;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.hashCode();
    }

    public String toString() {
        Object r10 = this.f13580a;
        if (r10 != null) goto L7;
        return "OnCompleteNotification";
    L7:
        if (NotificationLite.isError(r10) == false) goto L11;
        return "OnErrorNotification[" + NotificationLite.getError(r10) + "]";
    L11:
        return "OnNextNotification[" + this.f13580a + "]";
    }
}
