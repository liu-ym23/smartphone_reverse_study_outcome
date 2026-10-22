package nuc;

import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import muc.c;
import muc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@ExperimentalSerializationApi
public final class c3 extends l2<UByte, UByteArray, b3> {
    public static final c3 c = null;

    static {
        c = new c3();
    }

    @Override // nuc.l2
    public final UByteArray k() {
        return UByteArray.m105boximpl(UByteArray.m106constructorimpl(0));
    }

    public c3() {
        Intrinsics.checkNotNullParameter(UByte.Companion, "<this>");
        super(d3.a);
    }

    @Override // nuc.a
    public final int e(Object r2) {
        byte[] r3 = ((UByteArray) r2).m121unboximpl();
        Intrinsics.checkNotNullParameter(r3, "$this$collectionSize");
        return UByteArray.m113getSizeimpl(r3);
    }

    @Override // nuc.a
    public final Object i(Object r2) {
        byte[] r3 = ((UByteArray) r2).m121unboximpl();
        Intrinsics.checkNotNullParameter(r3, "$this$toBuilder");
        return new b3(r3);
    }

    @Override // nuc.l2
    public final void l(d r4, UByteArray r5, int r6) {
        byte[] r7 = r5.m121unboximpl();
        Intrinsics.checkNotNullParameter(r4, "encoder");
        Intrinsics.checkNotNullParameter(r7, "content");
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L5;
        r4.encodeInlineElement(this.b, r0).encodeByte(UByteArray.m112getw2LRezQ(r7, r0));
        r0 = r0 + 1;
        goto L3
    }

    @Override // nuc.v, nuc.a
    public final void h(c r2, int r3, Object r4, boolean r5) {
        b3 r6 = (b3) r4;
        Intrinsics.checkNotNullParameter(r2, "decoder");
        Intrinsics.checkNotNullParameter(r6, "builder");
        byte r7 = UByte.m54constructorimpl(r2.decodeInlineElement(this.b, r3).decodeByte());
        r6.getClass();
        j2.c(r6);
        byte[] r8 = r6.a;
        int r9 = r6.b;
        r6.b = r9 + 1;
        UByteArray.m117setVurrAj0(r8, r9, r7);
    }
}
