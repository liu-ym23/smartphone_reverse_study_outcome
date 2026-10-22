package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f19021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f19022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function3 f19023c;
    public final Object d;
    public final Throwable e;

    public u(Object r5, i r10, Function3 r11, Object r12, Throwable r13) {
        this.f19021a = r5;
        this.f19022b = r10;
        this.f19023c = r11;
        this.d = r12;
        this.e = r13;
    }

    public static u a(u r10, i r11, CancellationException r12, int r13) {
        Object r5 = r10.f19021a;
        if ((r13 & 2) == 0) goto L5;
        r11 = r10.f19022b;
    L5:
        i r14 = r11;
        Function3 r15 = r10.f19023c;
        Object r16 = r10.d;
        Throwable r17 = r12;
        if ((r13 & 16) == 0) goto L8;
        r17 = r10.e;
    L8:
        r10.getClass();
        return new u(r5, r14, r15, r16, r17);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof u) == true) goto L8;
        return false;
    L8:
        u r10 = (u) r5;
        Object r11 = r10.f19021a;
        if (Intrinsics.areEqual(this.f19021a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f19022b, r10.f19022b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f19023c, r10.f19023c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r5 = 0;
        Object r10 = this.f19021a;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        i r13 = this.f19022b;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        Function3 r16 = this.f19023c;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        Object r19 = this.d;
        if (r19 != null) goto L17;
        int r20 = 0;
    L18:
        int r21 = (r18 + r20) * 31;
        Throwable r22 = this.e;
        if (r22 == null) goto L23;
        r5 = r22.hashCode();
    L23:
        return r21 + r5;
    L17:
        r20 = r19.hashCode();
        goto L18
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f19021a + ", cancelHandler=" + this.f19022b + ", onCancellation=" + this.f19023c + ", idempotentResume=" + this.d + ", cancelCause=" + this.e + ')';
    }

    public /* synthetic */ u(Object r10, i r11, Function3 r12, CancellationException r13, int r14) {
        if ((r14 & 2) == 0) goto L5;
        i r5 = null;
    L7:
        if ((r14 & 4) == 0) goto L9;
        Function3 r15 = null;
    L11:
        if ((r14 & 16) == 0) goto L13;
        CancellationException r16 = null;
    L14:
        this(r10, r5, r15, null, r16);
        return;
    L13:
        r16 = r13;
        goto L14
    L9:
        r15 = r12;
        goto L11
    L5:
        r5 = r11;
        goto L7
    }
}
