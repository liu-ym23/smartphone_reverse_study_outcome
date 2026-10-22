package io.reactivex.internal.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.t;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public final enum NotificationLite extends Enum<NotificationLite> {
    private static final /* synthetic */ NotificationLite[] $VALUES = null;
    public static final NotificationLite COMPLETE = null;

    static final class DisposableNotification implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;
        final io.reactivex.disposables.b upstream;

        DisposableNotification(io.reactivex.disposables.b r3) {
            this.upstream = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.upstream + "]";
        }
    }

    static final class ErrorNotification implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;
        final Throwable e;

        ErrorNotification(Throwable r1) {
            this.e = r1;
        }

        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, ErrorNotification.class) == false) goto L6;
            ErrorNotification r4 = (ErrorNotification) ZeusTransformUtils.preCheckCast(r3, ErrorNotification.class, "com.obric.memorydata.plugin");
            return io.reactivex.internal.functions.a.a(this.e, r4.e);
        L6:
            return false;
        }

        public int hashCode() {
            return this.e.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.e + "]";
        }
    }

    static final class SubscriptionNotification implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;
        final org.a.d upstream;

        SubscriptionNotification(org.a.d r3) {
            this.upstream = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.upstream + "]";
        }
    }

    static {
        NotificationLite r0 = new NotificationLite("COMPLETE", 0);
        COMPLETE = r0;
        $VALUES = new NotificationLite[]{r0};
    }

    private NotificationLite(String r1, int r2) {
        super(r1, r2);
    }

    public static <T> boolean accept(Object r3, t<? super T> r4) {
        t r5 = (t) ZeusTransformUtils.wrapperContextForParams(r4, t.class, "com.obric.memorydata.plugin");
        if (r3 != COMPLETE) goto L7;
        r5.onComplete();
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, ErrorNotification.class) == false) goto L10;
        r5.onError(((ErrorNotification) ZeusTransformUtils.preCheckCast(r3, ErrorNotification.class, "com.obric.memorydata.plugin")).e);
        return true;
    L10:
        r5.onNext(r3);
        return false;
    }

    public static <T> boolean accept(Object r3, org.a.c<? super T> r4) {
        org.a.c r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r4, org.a.c.class, "com.obric.memorydata.plugin");
        if (r3 != COMPLETE) goto L7;
        r5.onComplete();
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, ErrorNotification.class) == false) goto L10;
        r5.onError(((ErrorNotification) ZeusTransformUtils.preCheckCast(r3, ErrorNotification.class, "com.obric.memorydata.plugin")).e);
        return true;
    L10:
        r5.onNext(r3);
        return false;
    }

    public static <T> boolean acceptFull(Object r3, t<? super T> r4) {
        t r5 = (t) ZeusTransformUtils.wrapperContextForParams(r4, t.class, "com.obric.memorydata.plugin");
        if (r3 != COMPLETE) goto L7;
        r5.onComplete();
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, ErrorNotification.class) == false) goto L11;
        r5.onError(((ErrorNotification) ZeusTransformUtils.preCheckCast(r3, ErrorNotification.class, "com.obric.memorydata.plugin")).e);
        return true;
    L11:
        if (ZeusTransformUtils.instanceOf(r3, DisposableNotification.class) == false) goto L14;
        r5.onSubscribe(((DisposableNotification) ZeusTransformUtils.preCheckCast(r3, DisposableNotification.class, "com.obric.memorydata.plugin")).upstream);
        return false;
    L14:
        r5.onNext(r3);
        return false;
    }

    public static <T> boolean acceptFull(Object r3, org.a.c<? super T> r4) {
        org.a.c r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r4, org.a.c.class, "com.obric.memorydata.plugin");
        if (r3 != COMPLETE) goto L7;
        r5.onComplete();
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, ErrorNotification.class) == false) goto L11;
        r5.onError(((ErrorNotification) ZeusTransformUtils.preCheckCast(r3, ErrorNotification.class, "com.obric.memorydata.plugin")).e);
        return true;
    L11:
        if (ZeusTransformUtils.instanceOf(r3, SubscriptionNotification.class) == false) goto L14;
        r5.onSubscribe(((SubscriptionNotification) ZeusTransformUtils.preCheckCast(r3, SubscriptionNotification.class, "com.obric.memorydata.plugin")).upstream);
        return false;
    L14:
        r5.onNext(r3);
        return false;
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object disposable(io.reactivex.disposables.b r2) {
        return new DisposableNotification((io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r2, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
    }

    public static Object error(Throwable r1) {
        return new ErrorNotification(r1);
    }

    public static io.reactivex.disposables.b getDisposable(Object r2) {
        return ((DisposableNotification) ZeusTransformUtils.preCheckCast(r2, DisposableNotification.class, "com.obric.memorydata.plugin")).upstream;
    }

    public static Throwable getError(Object r2) {
        return ((ErrorNotification) ZeusTransformUtils.preCheckCast(r2, ErrorNotification.class, "com.obric.memorydata.plugin")).e;
    }

    public static org.a.d getSubscription(Object r2) {
        return ((SubscriptionNotification) ZeusTransformUtils.preCheckCast(r2, SubscriptionNotification.class, "com.obric.memorydata.plugin")).upstream;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object r0) {
        return r0;
    }

    public static boolean isComplete(Object r1) {
        if (r1 != COMPLETE) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isDisposable(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, DisposableNotification.class);
    }

    public static boolean isError(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, ErrorNotification.class);
    }

    public static boolean isSubscription(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, SubscriptionNotification.class);
    }

    public static <T> Object next(T r0) {
        return r0;
    }

    public static Object subscription(org.a.d r2) {
        return new SubscriptionNotification((org.a.d) ZeusTransformUtils.wrapperContextForParams(r2, org.a.d.class, "com.obric.memorydata.plugin"));
    }

    public static NotificationLite valueOf(String r2) {
        return (NotificationLite) ZeusTransformUtils.preCheckCast(Enum.valueOf(NotificationLite.class, r2), NotificationLite.class, "com.obric.memorydata.plugin");
    }

    public static NotificationLite[] values() {
        return (NotificationLite[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NotificationLite[].class, "com.obric.memorydata.plugin");
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }
}
