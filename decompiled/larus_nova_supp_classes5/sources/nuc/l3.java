package nuc;

import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import muc.c;
import muc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@ExperimentalSerializationApi
public final class l3 extends l2<UShort, UShortArray, k3> {
    public static final l3 c = null;

    static {
        c = new l3();
    }

    @Override // nuc.l2
    public final UShortArray k() {
        return UShortArray.m334boximpl(UShortArray.m335constructorimpl(0));
    }

    public l3() {
        Intrinsics.checkNotNullParameter(UShort.Companion, "<this>");
        super(m3.a);
    }

    @Override // nuc.a
    public final int e(Object r2) {
        short[] r3 = ((UShortArray) r2).m350unboximpl();
        Intrinsics.checkNotNullParameter(r3, "$this$collectionSize");
        return UShortArray.m342getSizeimpl(r3);
    }

    @Override // nuc.a
    public final Object i(Object r2) {
        short[] r3 = ((UShortArray) r2).m350unboximpl();
        Intrinsics.checkNotNullParameter(r3, "$this$toBuilder");
        return new k3(r3);
    }

    @Override // nuc.l2
    public final void l(d r4, UShortArray r5, int r6) {
        short[] r7 = r5.m350unboximpl();
        Intrinsics.checkNotNullParameter(r4, "encoder");
        Intrinsics.checkNotNullParameter(r7, "content");
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L5;
        r4.encodeInlineElement(this.b, r0).encodeShort(UShortArray.m341getMh2AYeg(r7, r0));
        r0 = r0 + 1;
        goto L3
    }

    @Override // nuc.v, nuc.a
    public final void h(c r2, int r3, Object r4, boolean r5) {
        k3 r6 = (k3) r4;
        Intrinsics.checkNotNullParameter(r2, "decoder");
        Intrinsics.checkNotNullParameter(r6, "builder");
        short r7 = UShort.m283constructorimpl(r2.decodeInlineElement(this.b, r3).decodeShort());
        r6.getClass();
        j2.c(r6);
        short[] r8 = r6.a;
        int r9 = r6.b;
        r6.b = r9 + 1;
        UShortArray.m346set01HTLdE(r8, r9, r7);
    }
}
