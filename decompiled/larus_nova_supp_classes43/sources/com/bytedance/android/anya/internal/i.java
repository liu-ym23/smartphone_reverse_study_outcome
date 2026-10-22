package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.MVIState;
import java.util.Iterator;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i {
    public static final void a(MVIState r10, MVIState r11) {
        Iterator<Map.Entry<String, c<?, ?>>> r12 = r11.properties.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L15;
        Map.Entry<String, c<?, ?>> r0 = r12.next();
        String r1 = r0.getKey();
        c<?, ?> r13 = r0.getValue();
        c<?, ?> r14 = r10.properties.get(r1);
        if (r14 == null) goto L14;
        c<?, ?> r15 = r14;
        if ((r15 instanceof SubStatePropertyImpl) == true) goto L9;
        if ((!Intrinsics.areEqual(r15.c(), r13.c())) == false) goto L4;
        r15.a(r13.c());
        goto L4
    L9:
        r15.a(r13.c());
        goto L4
    L14:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.internal.BasePropertyImpl<STATE, kotlin.Any>");
    }
}
