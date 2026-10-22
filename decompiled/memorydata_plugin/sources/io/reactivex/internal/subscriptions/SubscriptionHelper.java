package io.reactivex.internal.subscriptions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.d.a;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.util.b;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final enum SubscriptionHelper extends Enum<SubscriptionHelper> implements d {
    private static final /* synthetic */ SubscriptionHelper[] $VALUES = null;
    public static final SubscriptionHelper CANCELLED = null;

    static {
        SubscriptionHelper r0 = new SubscriptionHelper("CANCELLED", 0);
        CANCELLED = r0;
        $VALUES = new SubscriptionHelper[]{r0};
    }

    private SubscriptionHelper(String r1, int r2) {
        super(r1, r2);
    }

    public static boolean cancel(AtomicReference<d> r3) {
        d r0 = (d) ZeusTransformUtils.preCheckCast(r3.get(), d.class, "com.obric.memorydata.plugin");
        SubscriptionHelper r1 = CANCELLED;
        if (r0 == r1) goto L10;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r3.getAndSet(r1), d.class, "com.obric.memorydata.plugin");
        if (r4 == r1) goto L13;
        if (r4 == null) goto L12;
        r4.cancel();
        return true;
    L12:
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public static void deferredRequest(AtomicReference<d> r3, AtomicLong r4, long r5) {
        d r0 = (d) ZeusTransformUtils.preCheckCast(r3.get(), d.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        r0.request(r5);
        return;
    L6:
        if (validate(r5) == false) goto L14;
        b.a(r4, r5);
        d r6 = (d) ZeusTransformUtils.preCheckCast(r3.get(), d.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L15;
        long r1 = r4.getAndSet(0);
        if (r1 == 0) goto L16;
        r6.request(r1);
        return;
    L16:
        return;
    L15:
        return;
    }

    public static boolean deferredSetOnce(AtomicReference<d> r2, AtomicLong r3, d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
        if (setOnce(r2, r5) == false) goto L9;
        long r6 = r3.getAndSet(0);
        if (r6 == 0) goto L11;
        r5.request(r6);
        return true;
    L11:
        return true;
    L9:
        return false;
    }

    public static boolean replace(AtomicReference<d> r3, d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
    L3:
        d r0 = (d) ZeusTransformUtils.preCheckCast(r3.get(), d.class, "com.obric.memorydata.plugin");
        if (r0 == CANCELLED) goto L5;
        if (r3.compareAndSet(r0, r5) == false) goto L3;
        return true;
    L5:
        if (r5 == null) goto L16;
        r5.cancel();
        return false;
    L16:
        return false;
    }

    public static void reportMoreProduced(long r3) {
        a.a(new ProtocolViolationException("More produced than requested: " + r3));
    }

    public static void reportSubscriptionSet() {
        a.a(new ProtocolViolationException("Subscription already set!"));
    }

    public static boolean set(AtomicReference<d> r3, d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
    L3:
        d r0 = (d) ZeusTransformUtils.preCheckCast(r3.get(), d.class, "com.obric.memorydata.plugin");
        if (r0 == CANCELLED) goto L5;
        if (r3.compareAndSet(r0, r5) == false) goto L3;
        if (r0 == null) goto L19;
        r0.cancel();
        return true;
    L19:
        return true;
    L5:
        if (r5 == null) goto L18;
        r5.cancel();
        return false;
    L18:
        return false;
    }

    public static boolean setOnce(AtomicReference<d> r2, d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        io.reactivex.internal.functions.a.a(r4, "s is null");
        if (r2.compareAndSet(null, r4) == true) goto L9;
        r4.cancel();
        if (r2.get() == CANCELLED) goto L11;
        reportSubscriptionSet();
        return false;
    L11:
        return false;
    L9:
        return true;
    }

    public static boolean setOnce(AtomicReference<d> r2, d r3, long r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        if (setOnce(r2, r5) == false) goto L6;
        r5.request(r4);
        return true;
    L6:
        return false;
    }

    public static boolean validate(long r3) {
        if (r3 > 0) goto L6;
        a.a(new IllegalArgumentException("n > 0 required but it was " + r3));
        return false;
    L6:
        return true;
    }

    public static boolean validate(d r2, d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin");
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L6;
        a.a(new NullPointerException("next is null"));
        return false;
    L6:
        if (r4 == null) goto L9;
        r5.cancel();
        reportSubscriptionSet();
        return false;
    L9:
        return true;
    }

    public static SubscriptionHelper valueOf(String r2) {
        return (SubscriptionHelper) ZeusTransformUtils.preCheckCast(Enum.valueOf(SubscriptionHelper.class, r2), SubscriptionHelper.class, "com.obric.memorydata.plugin");
    }

    public static SubscriptionHelper[] values() {
        return (SubscriptionHelper[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SubscriptionHelper[].class, "com.obric.memorydata.plugin");
    }

    @Override // org.a.d
    public void cancel() {
    }

    @Override // org.a.d
    public void request(long r1) {
    }
}
