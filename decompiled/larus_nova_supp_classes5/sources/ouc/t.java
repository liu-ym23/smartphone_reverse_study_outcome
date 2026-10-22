package ouc;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class t {
    public static final h a(muc.e r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if ((r3 instanceof h) == false) goto L5;
        h r0 = (h) r3;
    L6:
        if (r0 == null) goto L9;
        return r0;
    L9:
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got " + Reflection.getOrCreateKotlinClass(r3.getClass()));
    L5:
        r0 = null;
        goto L6
    }

    public static final u b(muc.f r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if ((r3 instanceof u) == false) goto L5;
        u r0 = (u) r3;
    L6:
        if (r0 == null) goto L9;
        return r0;
    L9:
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Encoder to be JsonEncoder, got " + Reflection.getOrCreateKotlinClass(r3.getClass()));
    L5:
        r0 = null;
        goto L6
    }
}
