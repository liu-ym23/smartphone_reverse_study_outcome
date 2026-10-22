package com.bytedance.android.livesdk.gift.framework.base;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements ExclusionStrategy {
    public c() {
    }

    public final boolean shouldSkipClass(Class<?> r1) {
        return false;
    }

    public final boolean shouldSkipField(FieldAttributes r2) {
        Intrinsics.checkNotNullParameter(r2, "field");
        if (r2.getAnnotation(TraceExclude.class) == null) goto L5;
    L8:
        return true;
    L5:
        if ((FieldAttributes.class instanceof k) == true) goto L8;
        return false;
    }
}
