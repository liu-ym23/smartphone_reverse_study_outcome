package kotlinx.coroutines;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c[] f18820a;

    public d(c[] r5) {
        this.f18820a = r5;
    }

    public final void a() {
        c[] r5 = this.f18820a;
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        t0 r12 = r5[r11].f;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("handle");
        r12 = null;
    L8:
        r12.dispose();
        r11 = r11 + 1;
        goto L3
    }

    @Override // kotlinx.coroutines.i
    public final void b(Throwable r5) {
        a();
    }

    public final String toString() {
        return "DisposeHandlersOnCancel[" + this.f18820a + ']';
    }
}
