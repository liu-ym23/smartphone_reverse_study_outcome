package io.reactivex.internal.util;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.e;
import java.io.Serializable;
import mt.u;

/* JADX INFO: loaded from: classes3.dex */
public final enum NotificationLite extends Enum<NotificationLite> {
    public static final NotificationLite COMPLETE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NotificationLite[] f18168a = null;

    public static final class DisposableNotification implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;
        final Disposable upstream;

        public DisposableNotification(Disposable r5) {
            this.upstream = r5;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.upstream + "]";
        }
    }

    public static final class ErrorNotification implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;
        final Throwable e;

        public ErrorNotification(Throwable r5) {
            this.e = r5;
        }

        public boolean equals(Object r5) {
            if ((r5 instanceof ErrorNotification) == true) goto L5;
            return false;
        L5:
            return e.b(this.e, ((ErrorNotification) r5).e);
        }

        public int hashCode() {
            return this.e.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.e + "]";
        }
    }

    public static final class SubscriptionNotification implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;
        final zu.d upstream;

        public SubscriptionNotification(zu.d r5) {
            this.upstream = r5;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.upstream + "]";
        }
    }

    static {
        NotificationLite r5 = new NotificationLite("COMPLETE", 0);
        COMPLETE = r5;
        f18168a = new NotificationLite[]{r5};
    }

    public static <T> boolean accept(Object r5, zu.c r10) {
        if (r5 != COMPLETE) goto L7;
        r10.onComplete();
        return true;
    L7:
        if ((r5 instanceof ErrorNotification) == false) goto L10;
        r10.onError(((ErrorNotification) r5).e);
        return true;
    L10:
        r10.onNext(r5);
        return false;
    }

    public static <T> boolean acceptFull(Object r5, zu.c r10) {
        if (r5 != COMPLETE) goto L7;
        r10.onComplete();
        return true;
    L7:
        if ((r5 instanceof ErrorNotification) == false) goto L11;
        r10.onError(((ErrorNotification) r5).e);
        return true;
    L11:
        if ((r5 instanceof SubscriptionNotification) == false) goto L14;
        r10.onSubscribe(((SubscriptionNotification) r5).upstream);
        return false;
    L14:
        r10.onNext(r5);
        return false;
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object disposable(Disposable r5) {
        return new DisposableNotification(r5);
    }

    public static Object error(Throwable r5) {
        return new ErrorNotification(r5);
    }

    public static Disposable getDisposable(Object r5) {
        return ((DisposableNotification) r5).upstream;
    }

    public static Throwable getError(Object r5) {
        return ((ErrorNotification) r5).e;
    }

    public static zu.d getSubscription(Object r5) {
        return ((SubscriptionNotification) r5).upstream;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object r5) {
        return r5;
    }

    public static boolean isComplete(Object r5) {
        if (r5 != COMPLETE) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isDisposable(Object r5) {
        return r5 instanceof DisposableNotification;
    }

    public static boolean isError(Object r5) {
        return r5 instanceof ErrorNotification;
    }

    public static boolean isSubscription(Object r5) {
        return r5 instanceof SubscriptionNotification;
    }

    public static <T> Object next(T r5) {
        return r5;
    }

    public static Object subscription(zu.d r5) {
        return new SubscriptionNotification(r5);
    }

    public static NotificationLite valueOf(String r5) {
        return (NotificationLite) Enum.valueOf(NotificationLite.class, r5);
    }

    public static NotificationLite[] values() {
        return (NotificationLite[]) f18168a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    public static <T> boolean accept(Object r5, u r10) {
        if (r5 != COMPLETE) goto L7;
        r10.onComplete();
        return true;
    L7:
        if ((r5 instanceof ErrorNotification) == false) goto L10;
        r10.onError(((ErrorNotification) r5).e);
        return true;
    L10:
        r10.onNext(r5);
        return false;
    }

    public static <T> boolean acceptFull(Object r5, u r10) {
        if (r5 != COMPLETE) goto L7;
        r10.onComplete();
        return true;
    L7:
        if ((r5 instanceof ErrorNotification) == false) goto L11;
        r10.onError(((ErrorNotification) r5).e);
        return true;
    L11:
        if ((r5 instanceof DisposableNotification) == false) goto L14;
        r10.onSubscribe(((DisposableNotification) r5).upstream);
        return false;
    L14:
        r10.onNext(r5);
        return false;
    }
}
