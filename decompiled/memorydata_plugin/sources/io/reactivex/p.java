package io.reactivex;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.util.NotificationLite;

/* JADX INFO: loaded from: classes6.dex */
public final class p<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final p<Object> f17159b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object f17160a;

    static {
        f17159b = new p(null);
    }

    private p(Object r1) {
        this.f17160a = r1;
    }

    public static <T> p<T> a(T r1) {
        io.reactivex.internal.functions.a.a(r1, "value is null");
        return new p(r1);
    }

    public static <T> p<T> a(Throwable r1) {
        io.reactivex.internal.functions.a.a(r1, "error is null");
        return new p(NotificationLite.error(r1));
    }

    public static <T> p<T> c() {
        return (p<T>) f17159b;
    }

    public boolean a() {
        return NotificationLite.isError(this.f17160a);
    }

    public Throwable b() {
        Object r1 = this.f17160a;
        if (NotificationLite.isError(r1) == true) goto L5;
        return null;
    L5:
        return NotificationLite.getError(r1);
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, p.class) == false) goto L6;
        p r4 = (p) ZeusTransformUtils.preCheckCast(r3, p.class, "com.obric.memorydata.plugin");
        return io.reactivex.internal.functions.a.a(this.f17160a, r4.f17160a);
    L6:
        return false;
    }

    public int hashCode() {
        Object r0 = this.f17160a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        Object r0 = this.f17160a;
        if (r0 != null) goto L7;
        return "OnCompleteNotification";
    L7:
        if (NotificationLite.isError(r0) == false) goto L11;
        StringBuilder r3 = new StringBuilder().append("OnErrorNotification[").append(NotificationLite.getError(r0));
    L10:
        return r3.append("]").toString();
    L11:
        r3 = new StringBuilder().append("OnNextNotification[").append(this.f17160a);
        goto L10
    }
}
