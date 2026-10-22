package nuc;

import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import muc.c;
import muc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@ExperimentalSerializationApi
public final class f3 extends l2<UInt, UIntArray, e3> {
    public static final f3 c = null;

    static {
        c = new f3();
    }

    @Override // nuc.l2
    public final UIntArray k() {
        return UIntArray.m182boximpl(UIntArray.m183constructorimpl(0));
    }

    public f3() {
        Intrinsics.checkNotNullParameter(UInt.Companion, "<this>");
        super(g3.a);
    }

    @Override // nuc.a
    public final int e(Object r2) {
        int[] r3 = ((UIntArray) r2).m198unboximpl();
        Intrinsics.checkNotNullParameter(r3, "$this$collectionSize");
        return UIntArray.m190getSizeimpl(r3);
    }

    @Override // nuc.a
    public final Object i(Object r2) {
        int[] r3 = ((UIntArray) r2).m198unboximpl();
        Intrinsics.checkNotNullParameter(r3, "$this$toBuilder");
        return new e3(r3);
    }

    @Override // nuc.l2
    public final void l(d r4, UIntArray r5, int r6) {
        int[] r7 = r5.m198unboximpl();
        Intrinsics.checkNotNullParameter(r4, "encoder");
        Intrinsics.checkNotNullParameter(r7, "content");
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L5;
        r4.encodeInlineElement(this.b, r0).encodeInt(UIntArray.m189getpVg5ArA(r7, r0));
        r0 = r0 + 1;
        goto L3
    }

    @Override // nuc.v, nuc.a
    public final void h(c r2, int r3, Object r4, boolean r5) {
        e3 r6 = (e3) r4;
        Intrinsics.checkNotNullParameter(r2, "decoder");
        Intrinsics.checkNotNullParameter(r6, "builder");
        int r7 = UInt.m129constructorimpl(r2.decodeInlineElement(this.b, r3).decodeInt());
        r6.getClass();
        j2.c(r6);
        int[] r8 = r6.a;
        int r9 = r6.b;
        r6.b = r9 + 1;
        UIntArray.m194setVXSXFK8(r8, r9, r7);
    }
}
