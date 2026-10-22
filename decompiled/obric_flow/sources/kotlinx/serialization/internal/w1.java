package kotlinx.serialization.internal;

import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class w1 extends d1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final w1 f19366c = null;

    static {
        Intrinsics.checkNotNullParameter(ULong.Companion, "<this>");
        f19366c = new w1(x1.f19370a);
    }

    @Override // kotlinx.serialization.internal.r, kotlinx.serialization.internal.a
    public final void e(eu.a r5, int r10, Object r11, boolean r12) {
        v1 r13 = (v1) r11;
        Intrinsics.checkNotNullParameter(r5, "decoder");
        Intrinsics.checkNotNullParameter(r13, "builder");
        long r14 = ULong.m298constructorimpl(r5.D(this.f19273b, r10).j());
        r13.getClass();
        b1.c(r13);
        long[] r15 = r13.f19358a;
        int r16 = r13.f19359b;
        r13.f19359b = r16 + 1;
        ULongArray.m363setk8EXiF4(r15, r16, r14);
    }

    @Override // kotlinx.serialization.internal.a
    public final Object f(Object r5) {
        long[] r10 = ((ULongArray) r5).m367unboximpl();
        Intrinsics.checkNotNullParameter(r10, "$this$toBuilder");
        Intrinsics.checkNotNullParameter(r10, "bufferWithData");
        v1 r11 = new v1();
        r11.f19358a = r10;
        r11.f19359b = ULongArray.m359getSizeimpl(r10);
        r11.b(10);
        return r11;
    }

    @Override // kotlinx.serialization.internal.d1
    public final Object i() {
        return ULongArray.m351boximpl(ULongArray.m352constructorimpl(0));
    }
}
