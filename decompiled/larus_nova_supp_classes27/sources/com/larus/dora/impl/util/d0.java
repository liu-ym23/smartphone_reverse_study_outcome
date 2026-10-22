package com.larus.dora.impl.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d0 {
    public static final String a(DoraVideoType r2, DoraSKU r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "doraSku");
        boolean r0 = v19.h.a;
        boolean r1 = v19.h.a(null);
        DoraResourceUtil r4 = DoraResourceUtil.a;
        return DoraResourceUtil.i(r2.fileName(r3, r1));
    }
}
