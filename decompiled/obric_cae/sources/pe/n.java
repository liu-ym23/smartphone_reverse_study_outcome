package pe;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f10043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f10044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ge.l<Throwable, xd.j> f10045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f10046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Throwable f10047e;

    /* JADX WARN: Multi-variable type inference failed */
    public n(Object r8, e r10, ge.l<? super Throwable, xd.j> r11, Object r12, Throwable r13) {
        this.f10043a = r8;
        this.f10044b = r10;
        this.f10045c = r11;
        this.f10046d = r12;
        this.f10047e = r13;
    }

    public static n a(n r8, e r10, CancellationException r11, int r12) {
        Object r13 = null;
        if ((r12 & 1) == 0) goto L5;
        Object r14 = r8.f10043a;
    L7:
        if ((r12 & 2) == 0) goto L9;
        r10 = r8.f10044b;
    L9:
        e r15 = r10;
        if ((r12 & 4) == 0) goto L12;
        ge.l<Throwable, xd.j> r16 = r8.f10045c;
    L14:
        if ((r12 & 8) == 0) goto L16;
        r13 = r8.f10046d;
    L16:
        Object r17 = r13;
        Throwable r18 = r11;
        if ((r12 & 16) == 0) goto L19;
        r18 = r8.f10047e;
    L19:
        r8.getClass();
        return new n(r14, r15, r16, r17, r18);
    L12:
        r16 = null;
        goto L14
    L5:
        r14 = null;
        goto L7
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof n) == true) goto L8;
        return false;
    L8:
        n r10 = (n) r8;
        Object r11 = r10.f10043a;
        if (he.i.a(this.f10043a, r11) == true) goto L12;
        return false;
    L12:
        if (he.i.a(this.f10044b, r10.f10044b) == true) goto L15;
        return false;
    L15:
        if (he.i.a(this.f10045c, r10.f10045c) == true) goto L18;
        return false;
    L18:
        if (he.i.a(this.f10046d, r10.f10046d) == true) goto L21;
        return false;
    L21:
        if (he.i.a(this.f10047e, r10.f10047e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r8 = 0;
        Object r10 = this.f10043a;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        e r13 = this.f10044b;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        ge.l<Throwable, xd.j> r16 = this.f10045c;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        Object r19 = this.f10046d;
        if (r19 != null) goto L17;
        int r20 = 0;
    L18:
        int r21 = (r18 + r20) * 31;
        Throwable r22 = this.f10047e;
        if (r22 == null) goto L23;
        r8 = r22.hashCode();
    L23:
        return r21 + r8;
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
        return "CompletedContinuation(result=" + this.f10043a + ", cancelHandler=" + this.f10044b + ", onCancellation=" + this.f10045c + ", idempotentResume=" + this.f10046d + ", cancelCause=" + this.f10047e + ')';
    }

    public /* synthetic */ n(Object r10, e r11, ge.l r12, CancellationException r13, int r14) {
        if ((r14 & 2) == 0) goto L5;
        e r8 = null;
    L7:
        if ((r14 & 4) == 0) goto L9;
        ge.l r15 = null;
    L11:
        if ((r14 & 16) == 0) goto L13;
        CancellationException r16 = null;
    L14:
        this(r10, r8, r15, null, r16);
        return;
    L13:
        r16 = r13;
        goto L14
    L9:
        r15 = r12;
        goto L11
    L5:
        r8 = r11;
        goto L7
    }
}
