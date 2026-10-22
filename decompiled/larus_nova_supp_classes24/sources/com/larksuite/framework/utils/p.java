package com.larksuite.framework.utils;

import android.os.Build;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class p {
    public static final <T> List<T> a(Iterable<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (Build.VERSION.SDK_INT < 35) goto L7;
        return CollectionsKt.reversed(r2);
    L7:
        if ((r2 instanceof Collection) == true) goto L9;
    L12:
        List<T> r3 = CollectionsKt.toMutableList(r2);
        CollectionsKt.reverse(r3);
        return r3;
    L9:
        if (((Collection) r2).size() > 1) goto L12;
        return CollectionsKt.toList(r2);
    }
}
