package nu;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f20355a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f20356b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference[] f20357c = null;

    static {
        int r10 = 0;
        f20355a = new y(new byte[0], 0, 0, false, false);
        int r5 = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f20356b = r5;
        AtomicReference[] r11 = new AtomicReference[r5];
    L3:
        if (r10 >= r5) goto L5;
        r11[r10] = new AtomicReference();
        r10 = r10 + 1;
        goto L3
    L5:
        f20357c = r11;
    }

    public static final void a(y r10) {
        Intrinsics.checkNotNullParameter(r10, "segment");
        if (r10.f != null) goto L28;
        if (r10.g != null) goto L28;
        if (r10.d == false) goto L9;
        return;
    L9:
        AtomicReference r5 = f20357c[(int) (Thread.currentThread().getId() & (((long) f20356b) - 1))];
        y r11 = (y) r5.get();
        if (r11 != f20355a) goto L13;
        return;
    L13:
        if (r11 == null) goto L15;
        int r12 = r11.f20354c;
    L17:
        if (r12 < 65536) goto L19;
        return;
    L19:
        r10.f = r11;
        r10.f20353b = 0;
        r10.f20354c = r12 + 8192;
    L21:
        if (r5.compareAndSet(r11, r10) == true) goto L32;
        if (r5.get() == r11) goto L21;
        r10.f = null;
        return;
    L32:
        return;
    L15:
        r12 = 0;
    L28:
        throw new IllegalArgumentException("Failed requirement.");
    }

    public static final y b() {
        int r5 = (int) (Thread.currentThread().getId() & (((long) f20356b) - 1));
        AtomicReference r10 = f20357c[r5];
        y r11 = f20355a;
        y r12 = (y) r10.getAndSet(r11);
        if (r12 != r11) goto L7;
        return new y();
    L7:
        if (r12 != null) goto L10;
        r10.set(null);
        return new y();
    L10:
        r10.set(r12.f);
        r12.f = null;
        r12.f20354c = 0;
        return r12;
    }
}
