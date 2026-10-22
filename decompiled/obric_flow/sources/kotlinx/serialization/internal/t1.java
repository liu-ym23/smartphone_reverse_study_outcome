package kotlinx.serialization.internal;

import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class t1 extends d1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t1 f19347c = null;

    static {
        Intrinsics.checkNotNullParameter(UInt.Companion, "<this>");
        f19347c = new t1(u1.f19352a);
    }

    @Override // kotlinx.serialization.internal.r, kotlinx.serialization.internal.a
    public final void e(eu.a r5, int r10, Object r11, boolean r12) {
        s1 r13 = (s1) r11;
        Intrinsics.checkNotNullParameter(r5, "decoder");
        Intrinsics.checkNotNullParameter(r13, "builder");
        int r14 = UInt.m219constructorimpl(r5.D(this.f19273b, r10).g());
        r13.getClass();
        b1.c(r13);
        int[] r15 = r13.f19343a;
        int r16 = r13.f19344b;
        r13.f19344b = r16 + 1;
        UIntArray.m284setVXSXFK8(r15, r16, r14);
    }

    @Override // kotlinx.serialization.internal.a
    public final Object f(Object r5) {
        int[] r10 = ((UIntArray) r5).m288unboximpl();
        Intrinsics.checkNotNullParameter(r10, "$this$toBuilder");
        Intrinsics.checkNotNullParameter(r10, "bufferWithData");
        s1 r11 = new s1();
        r11.f19343a = r10;
        r11.f19344b = UIntArray.m280getSizeimpl(r10);
        r11.b(10);
        return r11;
    }

    @Override // kotlinx.serialization.internal.d1
    public final Object i() {
        return UIntArray.m272boximpl(UIntArray.m273constructorimpl(0));
    }
}
