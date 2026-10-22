package nuc;

import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import muc.c;
import muc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@ExperimentalSerializationApi
public final class i3 extends l2<ULong, ULongArray, h3> {
    public static final i3 c = null;

    static {
        c = new i3();
    }

    @Override // nuc.l2
    public final ULongArray k() {
        return ULongArray.m259boximpl(ULongArray.m260constructorimpl(0));
    }

    public i3() {
        Intrinsics.checkNotNullParameter(ULong.Companion, "<this>");
        super(j3.a);
    }

    @Override // nuc.a
    public final int e(Object r2) {
        long[] r3 = ((ULongArray) r2).m275unboximpl();
        Intrinsics.checkNotNullParameter(r3, "$this$collectionSize");
        return ULongArray.m267getSizeimpl(r3);
    }

    @Override // nuc.a
    public final Object i(Object r2) {
        long[] r3 = ((ULongArray) r2).m275unboximpl();
        Intrinsics.checkNotNullParameter(r3, "$this$toBuilder");
        return new h3(r3);
    }

    @Override // nuc.l2
    public final void l(d r5, ULongArray r6, int r7) {
        long[] r8 = r6.m275unboximpl();
        Intrinsics.checkNotNullParameter(r5, "encoder");
        Intrinsics.checkNotNullParameter(r8, "content");
        int r0 = 0;
    L3:
        if (r0 >= r7) goto L5;
        r5.encodeInlineElement(this.b, r0).encodeLong(ULongArray.m266getsVKNKU(r8, r0));
        r0 = r0 + 1;
        goto L3
    }

    @Override // nuc.v, nuc.a
    public final void h(c r3, int r4, Object r5, boolean r6) {
        h3 r7 = (h3) r5;
        Intrinsics.checkNotNullParameter(r3, "decoder");
        Intrinsics.checkNotNullParameter(r7, "builder");
        long r8 = ULong.m206constructorimpl(r3.decodeInlineElement(this.b, r4).decodeLong());
        r7.getClass();
        j2.c(r7);
        long[] r9 = r7.a;
        int r0 = r7.b;
        r7.b = r0 + 1;
        ULongArray.m271setk8EXiF4(r9, r0, r8);
    }
}
