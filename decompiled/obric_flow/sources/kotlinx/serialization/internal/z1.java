package kotlinx.serialization.internal;

import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class z1 extends d1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final z1 f19381c = null;

    static {
        Intrinsics.checkNotNullParameter(UShort.Companion, "<this>");
        f19381c = new z1(a2.f19259a);
    }

    @Override // kotlinx.serialization.internal.r, kotlinx.serialization.internal.a
    public final void e(eu.a r5, int r10, Object r11, boolean r12) {
        y1 r13 = (y1) r11;
        Intrinsics.checkNotNullParameter(r5, "decoder");
        Intrinsics.checkNotNullParameter(r13, "builder");
        short r14 = UShort.m405constructorimpl(r5.D(this.f19273b, r10).o());
        r13.getClass();
        b1.c(r13);
        short[] r15 = r13.f19374a;
        int r16 = r13.f19375b;
        r13.f19375b = r16 + 1;
        UShortArray.m468set01HTLdE(r15, r16, r14);
    }

    @Override // kotlinx.serialization.internal.a
    public final Object f(Object r5) {
        short[] r10 = ((UShortArray) r5).m472unboximpl();
        Intrinsics.checkNotNullParameter(r10, "$this$toBuilder");
        Intrinsics.checkNotNullParameter(r10, "bufferWithData");
        y1 r11 = new y1();
        r11.f19374a = r10;
        r11.f19375b = UShortArray.m464getSizeimpl(r10);
        r11.b(10);
        return r11;
    }

    @Override // kotlinx.serialization.internal.d1
    public final Object i() {
        return UShortArray.m456boximpl(UShortArray.m457constructorimpl(0));
    }
}
