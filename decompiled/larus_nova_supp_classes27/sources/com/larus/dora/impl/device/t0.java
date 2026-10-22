package com.larus.dora.impl.device;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class t0 {
    public static final Integer a(Bundle r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (r1 == null) goto L5;
        Object r3 = r1.get(r2);
    L7:
        if ((r3 instanceof Integer) == false) goto L10;
        return (Integer) r3;
    L10:
        if ((r3 instanceof String) == true) goto L12;
        return null;
    L12:
        return StringsKt.toIntOrNull((String) r3);
    L5:
        r3 = null;
        goto L7
    }
}
