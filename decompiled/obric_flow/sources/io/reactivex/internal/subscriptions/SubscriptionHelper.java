package io.reactivex.internal.subscriptions;

import androidx.constraintlayout.motion.widget.a;
import com.lynx.tasm.behavior.v0;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.functions.e;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import wn.f;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
public final enum SubscriptionHelper extends Enum<SubscriptionHelper> implements d {
    public static final SubscriptionHelper CANCELLED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SubscriptionHelper[] f18162a = null;

    static {
        SubscriptionHelper r5 = new SubscriptionHelper("CANCELLED", 0);
        CANCELLED = r5;
        f18162a = new SubscriptionHelper[]{r5};
    }

    public static void deferredRequest(AtomicReference<d> r5, AtomicLong r10, long r11) {
        d r12 = r5.get();
        if (r12 == null) goto L6;
        r12.request(r11);
        return;
    L6:
        if (validate(r11) == false) goto L14;
        v0.r(r10, r11);
        d r13 = r5.get();
        if (r13 == null) goto L15;
        long r14 = r10.getAndSet(0);
        if (r14 == 0) goto L16;
        r13.request(r14);
        return;
    L16:
        return;
    L15:
        return;
    }

    public static boolean deferredSetOnce(AtomicReference<d> r5, AtomicLong r10, d r11) {
        if (setOnce(r5, r11) == false) goto L9;
        long r12 = r10.getAndSet(0);
        if (r12 == 0) goto L11;
        r11.request(r12);
        return true;
    L11:
        return true;
    L9:
        return false;
    }

    public static boolean replace(AtomicReference<d> r5, d r10) {
    L2:
        d r11 = r5.get();
        if (r11 == CANCELLED) goto L4;
    L9:
        if (r5.compareAndSet(r11, r10) == true) goto L10;
        if (r5.get() == r11) goto L9;
    L10:
        return true;
    L4:
        if (r10 == null) goto L19;
        r10.cancel();
        return false;
    L19:
        return false;
    }

    public static void reportMoreProduced(long r5) {
        f.k(new ProtocolViolationException(a.j(r5, "More produced than requested: ")));
    }

    public static void reportSubscriptionSet() {
        f.k(new ProtocolViolationException("Subscription already set!"));
    }

    public static boolean set(AtomicReference<d> r5, d r10) {
    L2:
        d r11 = r5.get();
        if (r11 == CANCELLED) goto L4;
    L9:
        if (r5.compareAndSet(r11, r10) == true) goto L10;
        if (r5.get() == r11) goto L9;
    L10:
        if (r11 == null) goto L22;
        r11.cancel();
        return true;
    L22:
        return true;
    L4:
        if (r10 == null) goto L21;
        r10.cancel();
        return false;
    L21:
        return false;
    }

    public static boolean setOnce(AtomicReference<d> r5, d r10) {
        e.d(r10, "s is null");
    L4:
        if (r5.compareAndSet(null, r10) == true) goto L5;
        if (r5.get() == null) goto L4;
        r10.cancel();
        if (r5.get() == CANCELLED) goto L17;
        reportSubscriptionSet();
        return false;
    L17:
        return false;
    L5:
        return true;
    }

    public static boolean validate(d r5, d r10) {
        if (r10 != null) goto L6;
        f.k(new NullPointerException("next is null"));
        return false;
    L6:
        if (r5 == null) goto L9;
        r10.cancel();
        reportSubscriptionSet();
        return false;
    L9:
        return true;
    }

    public static SubscriptionHelper valueOf(String r5) {
        return (SubscriptionHelper) Enum.valueOf(SubscriptionHelper.class, r5);
    }

    public static SubscriptionHelper[] values() {
        return (SubscriptionHelper[]) f18162a.clone();
    }

    @Override // zu.d
    public void cancel() {
    }

    @Override // zu.d
    public void request(long r5) {
    }

    public static boolean cancel(AtomicReference<d> r5) {
        d r10 = r5.get();
        SubscriptionHelper r11 = CANCELLED;
        if (r10 == r11) goto L10;
        d r12 = r5.getAndSet(r11);
        if (r12 == r11) goto L13;
        if (r12 == null) goto L12;
        r12.cancel();
        return true;
    L12:
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public static boolean validate(long r5) {
        if (r5 > 0) goto L6;
        f.k(new IllegalArgumentException(a.j(r5, "n > 0 required but it was ")));
        return false;
    L6:
        return true;
    }

    public static boolean setOnce(AtomicReference<d> r5, d r10, long r11) {
        if (setOnce(r5, r10) == false) goto L6;
        r10.request(r11);
        return true;
    L6:
        return false;
    }
}
