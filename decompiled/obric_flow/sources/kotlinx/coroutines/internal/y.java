package kotlinx.coroutines.internal;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.y0;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes3.dex */
public class y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f18960b = null;
    private volatile /* synthetic */ int _size$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y0[] f18961a;

    static {
        f18960b = AtomicIntegerFieldUpdater.newUpdater(y.class, "_size$volatile");
    }

    public final void a(y0 r5) {
        r5.c((z0) this);
        y0[] r10 = this.f18961a;
        AtomicIntegerFieldUpdater r11 = f18960b;
        if (r10 != null) goto L6;
        r10 = new y0[4];
        this.f18961a = r10;
    L8:
        int r12 = r11.get(this);
        r11.set(this, r12 + 1);
        r10[r12] = r5;
        r5.f19031b = r12;
        c(r12);
        return;
    L6:
        if (r11.get(this) < r10.length) goto L8;
        r10 = (y0[]) Arrays.copyOf(r10, r11.get(this) * 2);
        this.f18961a = r10;
        goto L8
    }

    public final y0 b(int r10) {
        Object[] r5 = this.f18961a;
        Intrinsics.checkNotNull(r5);
        AtomicIntegerFieldUpdater r11 = f18960b;
        r11.set(this, r11.get(this) - 1);
        if (r10 >= r11.get(this)) goto L22;
        d(r10, r11.get(this));
        int r12 = (r10 - 1) / 2;
        if (r10 <= 0) goto L9;
        y0 r13 = r5[r10];
        Intrinsics.checkNotNull(r13);
        Object r14 = r5[r12];
        Intrinsics.checkNotNull(r14);
        if (r13.compareTo(r14) >= 0) goto L9;
        d(r10, r12);
        c(r12);
    L9:
        int r15 = r10 * 2;
        int r16 = r15 + 1;
        if (r16 >= r11.get(this)) goto L22;
        Object[] r17 = this.f18961a;
        Intrinsics.checkNotNull(r17);
        int r18 = r15 + 2;
        if (r18 >= r11.get(this)) goto L17;
        Comparable r19 = r17[r18];
        Intrinsics.checkNotNull(r19);
        Object r20 = r17[r16];
        Intrinsics.checkNotNull(r20);
        if (r19.compareTo(r20) >= 0) goto L17;
    L18:
        Comparable r21 = r17[r10];
        Intrinsics.checkNotNull(r21);
        Comparable r22 = r17[r18];
        Intrinsics.checkNotNull(r22);
        if (r21.compareTo(r22) <= 0) goto L22;
        d(r10, r18);
        r10 = r18;
    L17:
        r18 = r16;
    L22:
        y0 r23 = r5[r11.get(this)];
        Intrinsics.checkNotNull(r23);
        r23.c(null);
        r23.f19031b = -1;
        r5[r11.get(this)] = null;
        return r23;
    }

    public final void c(int r5) {
    L2:
        if (r5 <= 0) goto L3;
        y0[] r10 = this.f18961a;
        Intrinsics.checkNotNull(r10);
        int r11 = (r5 - 1) / 2;
        y0 r12 = r10[r11];
        Intrinsics.checkNotNull(r12);
        y0 r13 = r10[r5];
        Intrinsics.checkNotNull(r13);
        if (r12.compareTo(r13) <= 0) goto L6;
        d(r5, r11);
        r5 = r11;
        goto L2
    L6:
        return;
    }

    public final void d(int r5, int r10) {
        y0[] r11 = this.f18961a;
        Intrinsics.checkNotNull(r11);
        y0 r12 = r11[r10];
        Intrinsics.checkNotNull(r12);
        y0 r13 = r11[r5];
        Intrinsics.checkNotNull(r13);
        r11[r5] = r12;
        r11[r10] = r13;
        r12.f19031b = r5;
        r13.f19031b = r10;
    }
}
