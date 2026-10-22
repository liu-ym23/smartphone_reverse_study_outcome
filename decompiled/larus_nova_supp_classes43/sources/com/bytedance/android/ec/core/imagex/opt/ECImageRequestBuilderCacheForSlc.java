package com.bytedance.android.ec.core.imagex.opt;

import android.util.LruCache;
import java.lang.ref.SoftReference;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECImageRequestBuilderCacheForSlc {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(ECImageRequestBuilderCacheForSlc$imageRequestCache$2.INSTANCE);
    }

    public static Triple a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Lazy r0 = a;
        SoftReference r1 = (SoftReference) ((LruCache) r0.getValue()).get(r10);
        if (r1 == null) goto L5;
        Triple r11 = (Triple) r1.get();
    L6:
        if (r11 == null) goto L8;
        List r12 = (List) r11.getSecond();
    L9:
        List r13 = r12;
        if (r13 != null) goto L12;
    L15:
        boolean r14 = true;
    L16:
        if (r14 == false) goto L21;
        if (r1 == null) goto L20;
        if (r11 != null) goto L20;
        ((LruCache) r0.getValue()).remove(r10);
    L20:
        return null;
    L21:
        return r11;
    L12:
        if (r13.isEmpty() == true) goto L15;
        r14 = false;
        goto L16
    L8:
        r12 = null;
        goto L9
    L5:
        r11 = null;
        goto L6
    }
}
