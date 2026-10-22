package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nCancellableContinuationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CompletedContinuation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,662:1\n1#2:663\n*E\n"})
final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public final Object f10228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public final l f10229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public final Function1<Throwable, Unit> f10230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public final Object f10231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @JvmField
    public final Throwable f10232e;

    /* JADX WARN: Multi-variable type inference failed */
    public a0(Object r10, l r11, Function1<? super Throwable, Unit> r12, Object r13, Throwable r14) {
        this.f10228a = r10;
        this.f10229b = r11;
        this.f10230c = r12;
        this.f10231d = r13;
        this.f10232e = r14;
    }

    public /* synthetic */ a0(Object r10, l r11, Function1 r12, Object r13, Throwable r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 2) == 0) goto L5;
        l r17 = null;
    L7:
        if ((r15 & 4) == 0) goto L9;
        Function1 r18 = null;
    L11:
        if ((r15 & 8) == 0) goto L13;
        Object r19 = null;
    L15:
        if ((r15 & 16) == 0) goto L17;
        Throwable r20 = null;
    L18:
        this(r10, r17, r18, r19, r20);
        return;
    L17:
        r20 = r14;
        goto L18
    L13:
        r19 = r13;
        goto L15
    L9:
        r18 = r12;
        goto L11
    L5:
        r17 = r11;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ a0 b(a0 r10, Object r11, l r12, Function1 r13, Object r14, Throwable r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.f10228a;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.f10229b;
    L8:
        l r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.f10230c;
    L11:
        Function1 r19 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.f10231d;
    L14:
        Object r20 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.f10232e;
    L17:
        Object r21 = r11;
        return r10.a(r21, r18, r19, r20, r15);
    }

    public final a0 a(Object r10, l r11, Function1<? super Throwable, Unit> r12, Object r13, Throwable r14) {
        return new a0(r10, r11, r12, r13, r14);
    }

    public final boolean c() {
        if (this.f10232e == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void d(o<?> r10, Throwable r11) {
        l r12 = this.f10229b;
        if (r12 == null) goto L5;
        r10.n(r12, r11);
    L5:
        Function1<Throwable, Unit> r13 = this.f10230c;
        if (r13 == null) goto L9;
        r10.o(r13, r11);
        return;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r11 = (a0) r10;
        if (Intrinsics.areEqual(this.f10228a, r11.f10228a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f10229b, r11.f10229b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f10230c, r11.f10230c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f10231d, r11.f10231d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f10232e, r11.f10232e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Object r10 = this.f10228a;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        l r14 = this.f10229b;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        Function1<Throwable, Unit> r17 = this.f10230c;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        Object r20 = this.f10231d;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        Throwable r23 = this.f10232e;
        if (r23 == null) goto L23;
        r11 = r23.hashCode();
    L23:
        return r22 + r11;
    L17:
        r21 = r20.hashCode();
        goto L18
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f10228a + ", cancelHandler=" + this.f10229b + ", onCancellation=" + this.f10230c + ", idempotentResume=" + this.f10231d + ", cancelCause=" + this.f10232e + ')';
    }
}
