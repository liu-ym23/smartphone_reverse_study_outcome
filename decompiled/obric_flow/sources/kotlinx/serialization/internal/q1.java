package kotlinx.serialization.internal;

import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class q1 extends d1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q1 f19336c = null;

    static {
        Intrinsics.checkNotNullParameter(UByte.Companion, "<this>");
        f19336c = new q1(r1.f19339a);
    }

    @Override // kotlinx.serialization.internal.r, kotlinx.serialization.internal.a
    public final void e(eu.a r5, int r10, Object r11, boolean r12) {
        p1 r13 = (p1) r11;
        Intrinsics.checkNotNullParameter(r5, "decoder");
        Intrinsics.checkNotNullParameter(r13, "builder");
        byte r14 = UByte.m142constructorimpl(r5.D(this.f19273b, r10).E());
        r13.getClass();
        b1.c(r13);
        byte[] r15 = r13.f19330a;
        int r16 = r13.f19331b;
        r13.f19331b = r16 + 1;
        UByteArray.m205setVurrAj0(r15, r16, r14);
    }

    @Override // kotlinx.serialization.internal.a
    public final Object f(Object r5) {
        byte[] r10 = ((UByteArray) r5).m209unboximpl();
        Intrinsics.checkNotNullParameter(r10, "$this$toBuilder");
        Intrinsics.checkNotNullParameter(r10, "bufferWithData");
        p1 r11 = new p1();
        r11.f19330a = r10;
        r11.f19331b = UByteArray.m201getSizeimpl(r10);
        r11.b(10);
        return r11;
    }

    @Override // kotlinx.serialization.internal.d1
    public final Object i() {
        return UByteArray.m193boximpl(UByteArray.m194constructorimpl(0));
    }
}
