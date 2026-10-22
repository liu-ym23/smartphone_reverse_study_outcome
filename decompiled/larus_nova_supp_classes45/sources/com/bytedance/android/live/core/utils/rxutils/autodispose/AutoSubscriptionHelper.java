package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
final enum AutoSubscriptionHelper extends Enum<AutoSubscriptionHelper> implements wwc.c {
    public static final AutoSubscriptionHelper CANCELLED = null;
    public static final /* synthetic */ AutoSubscriptionHelper[] a = null;

    public void cancel() {
    }

    public void request(long r1) {
    }

    static {
        AutoSubscriptionHelper r0 = new AutoSubscriptionHelper();
        CANCELLED = r0;
        a = new AutoSubscriptionHelper[]{r0};
    }

    public AutoSubscriptionHelper() {
        super("CANCELLED", 0);
    }

    public static void reportSubscriptionSet() {
        RxJavaPlugins.onError(new IllegalStateException("Subscription already set!"));
    }

    public static AutoSubscriptionHelper[] values() {
        return (AutoSubscriptionHelper[]) a.clone();
    }

    public static boolean cancel(AtomicReference<wwc.c> r2) {
        wwc.c r0 = r2.get();
        AutoSubscriptionHelper r1 = CANCELLED;
        if (r0 == r1) goto L10;
        wwc.c r3 = r2.getAndSet(r1);
        if (r3 == r1) goto L13;
        if (r3 == null) goto L12;
        r3.cancel();
        return true;
    L12:
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public static boolean validate(long r3) {
        if (r3 > 0) goto L6;
        RxJavaPlugins.onError(new IllegalArgumentException("n > 0 required but it was " + r3));
        return false;
    L6:
        return true;
    }

    public static AutoSubscriptionHelper valueOf(String r1) {
        return (AutoSubscriptionHelper) r27.a.a(AutoSubscriptionHelper.class, r1);
    }

    public static boolean setOnce(AtomicReference<wwc.c> r3, wwc.c r4) {
        q.a(r4, "s is null");
    L4:
        if (r3.compareAndSet(null, r4) == true) goto L5;
        if (r3.get() == null) goto L4;
        boolean r0 = false;
    L9:
        if (r0 == true) goto L14;
        r4.cancel();
        if (r3.get() == CANCELLED) goto L13;
        reportSubscriptionSet();
    L13:
        return false;
    L14:
        return true;
    L5:
        r0 = true;
        goto L9
    }

    public static void deferredRequest(AtomicReference<wwc.c> r9, AtomicLong r11, long r12) {
        wwc.c r0 = r9.get();
        if (r0 == null) goto L6;
        r0.request(r12);
        return;
    L6:
        if (validate(r12) == false) goto L26;
    L7:
        long r1 = r11.get();
        long r4 = Long.MAX_VALUE;
        if (r1 == Long.MAX_VALUE) goto L16;
        long r6 = r1 + r12;
        if (r6 < 0) goto L15;
        r4 = r6;
    L15:
        if (r11.compareAndSet(r1, r4) == false) goto L7;
    L16:
        wwc.c r13 = r9.get();
        if (r13 == null) goto L27;
        long r14 = r11.getAndSet(0);
        if (r14 == 0) goto L28;
        r13.request(r14);
        return;
    L28:
        return;
    L27:
        return;
    }

    public static boolean deferredSetOnce(AtomicReference<wwc.c> r3, AtomicLong r4, wwc.c r5) {
        if (setOnce(r3, r5) == false) goto L9;
        long r6 = r4.getAndSet(0);
        if (r6 == 0) goto L11;
        r5.request(r6);
        return true;
    L11:
        return true;
    L9:
        return false;
    }
}
