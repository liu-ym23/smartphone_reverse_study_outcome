package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.r2;

/* JADX INFO: loaded from: classes3.dex */
final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public final CoroutineContext f10569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object[] f10570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final r2<Object>[] f10571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10572d;

    public p0(CoroutineContext r10, int r11) {
        this.f10569a = r10;
        this.f10570b = new Object[r11];
        this.f10571c = new r2[r11];
    }

    public final void a(r2<?> r10, Object r11) {
        Object[] r12 = this.f10570b;
        int r13 = this.f10572d;
        r12[r13] = r11;
        r2<Object>[] r14 = this.f10571c;
        this.f10572d = r13 + 1;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        r14[r13] = r10;
    }

    public final void b(CoroutineContext r10) {
        int r11 = this.f10571c.length - 1;
        if (r11 < 0) goto L8;
    L4:
        int r12 = r11 - 1;
        r2<Object> r13 = this.f10571c[r11];
        Intrinsics.checkNotNull(r13);
        r13.F(r10, this.f10570b[r11]);
        if (r12 < 0) goto L10;
        r11 = r12;
        goto L4
    L10:
        return;
    }
}
