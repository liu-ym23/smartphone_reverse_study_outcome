package io.reactivex.internal.subscriptions;

import dc.a;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.util.b;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import tc.d;

/* JADX INFO: loaded from: classes2.dex */
public final enum SubscriptionHelper extends Enum<SubscriptionHelper> implements d {
    private static final /* synthetic */ SubscriptionHelper[] $VALUES = null;
    public static final SubscriptionHelper CANCELLED = null;

    static {
        SubscriptionHelper r10 = new SubscriptionHelper("CANCELLED", 0);
        CANCELLED = r10;
        $VALUES = new SubscriptionHelper[]{r10};
    }

    private SubscriptionHelper(String r10, int r11) {
        super(r10, r11);
    }

    public static boolean cancel(AtomicReference<d> r10) {
        d r11 = r10.get();
        SubscriptionHelper r12 = CANCELLED;
        if (r11 == r12) goto L10;
        d r13 = r10.getAndSet(r12);
        if (r13 == r12) goto L13;
        if (r13 == null) goto L12;
        r13.cancel();
        return true;
    L12:
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public static void deferredRequest(AtomicReference<d> r10, AtomicLong r11, long r12) {
        d r13 = r10.get();
        if (r13 == null) goto L6;
        r13.request(r12);
        return;
    L6:
        if (validate(r12) == false) goto L14;
        b.a(r11, r12);
        d r14 = r10.get();
        if (r14 == null) goto L15;
        long r15 = r11.getAndSet(0);
        if (r15 == 0) goto L16;
        r14.request(r15);
        return;
    L16:
        return;
    L15:
        return;
    }

    public static boolean deferredSetOnce(AtomicReference<d> r10, AtomicLong r11, d r12) {
        if (setOnce(r10, r12) == false) goto L9;
        long r13 = r11.getAndSet(0);
        if (r13 == 0) goto L11;
        r12.request(r13);
        return true;
    L11:
        return true;
    L9:
        return false;
    }

    public static boolean replace(AtomicReference<d> r10, d r11) {
    L2:
        d r12 = r10.get();
        if (r12 == CANCELLED) goto L4;
        if (r10.compareAndSet(r12, r11) == false) goto L2;
        return true;
    L4:
        if (r11 == null) goto L15;
        r11.cancel();
        return false;
    L15:
        return false;
    }

    public static void reportMoreProduced(long r10) {
        a.n(new ProtocolViolationException("More produced than requested: " + r10));
    }

    public static void reportSubscriptionSet() {
        a.n(new ProtocolViolationException("Subscription already set!"));
    }

    public static boolean set(AtomicReference<d> r10, d r11) {
    L2:
        d r12 = r10.get();
        if (r12 == CANCELLED) goto L4;
        if (r10.compareAndSet(r12, r11) == false) goto L2;
        if (r12 == null) goto L18;
        r12.cancel();
        return true;
    L18:
        return true;
    L4:
        if (r11 == null) goto L17;
        r11.cancel();
        return false;
    L17:
        return false;
    }

    public static boolean setOnce(AtomicReference<d> r10, d r11) {
        io.reactivex.internal.functions.a.d(r11, "s is null");
        if (r10.compareAndSet(null, r11) == true) goto L9;
        r11.cancel();
        if (r10.get() == CANCELLED) goto L11;
        reportSubscriptionSet();
        return false;
    L11:
        return false;
    L9:
        return true;
    }

    public static boolean setOnce(AtomicReference<d> r10, d r11, long r12) {
        if (setOnce(r10, r11) == false) goto L6;
        r11.request(r12);
        return true;
    L6:
        return false;
    }

    public static boolean validate(long r10) {
        if (r10 > 0) goto L6;
        a.n(new IllegalArgumentException("n > 0 required but it was " + r10));
        return false;
    L6:
        return true;
    }

    public static boolean validate(d r10, d r11) {
        if (r11 != null) goto L6;
        a.n(new NullPointerException("next is null"));
        return false;
    L6:
        if (r10 == null) goto L9;
        r11.cancel();
        reportSubscriptionSet();
        return false;
    L9:
        return true;
    }

    public static SubscriptionHelper valueOf(String r10) {
        return (SubscriptionHelper) Enum.valueOf(SubscriptionHelper.class, r10);
    }

    public static SubscriptionHelper[] values() {
        return (SubscriptionHelper[]) $VALUES.clone();
    }

    @Override // tc.d
    public void cancel() {
    }

    @Override // tc.d
    public void request(long r10) {
    }
}
