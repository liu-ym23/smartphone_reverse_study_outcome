package com.larus.audio.call.util;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class n {
    public static final <T> T a(List<? extends T> r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 >= 0) goto L5;
        return null;
    L5:
        if (r2 < r1.size()) goto L8;
        return null;
    L8:
        return (T) ListProtector.get(r1, r2);
    }
}
