package mt;

import io.reactivex.internal.util.NotificationLite;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f20169b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f20170a;

    static {
        f20169b = new l(null);
    }

    public l(Object r5) {
        this.f20170a = r5;
    }

    public static l a(Throwable r5) {
        io.reactivex.internal.functions.e.d(r5, "error is null");
        return new l(NotificationLite.error(r5));
    }

    public final Throwable b() {
        Object r5 = this.f20170a;
        if (NotificationLite.isError(r5) == true) goto L5;
        return null;
    L5:
        return NotificationLite.getError(r5);
    }

    public final boolean c() {
        Object r5 = this.f20170a;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (NotificationLite.isError(r5) == true) goto L7;
        return true;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof l) == true) goto L5;
        return false;
    L5:
        return io.reactivex.internal.functions.e.b(this.f20170a, ((l) r5).f20170a);
    }

    public final int hashCode() {
        Object r5 = this.f20170a;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.hashCode();
    }

    public final String toString() {
        Object r5 = this.f20170a;
        if (r5 != null) goto L7;
        return "OnCompleteNotification";
    L7:
        if (NotificationLite.isError(r5) == false) goto L11;
        return "OnErrorNotification[" + NotificationLite.getError(r5) + "]";
    L11:
        return "OnNextNotification[" + r5 + "]";
    }
}
