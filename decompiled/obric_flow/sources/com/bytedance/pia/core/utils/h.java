package com.bytedance.pia.core.utils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements ExclusionStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f7150a = null;

    static {
        f7150a = new h();
    }

    @Override // com.google.gson.ExclusionStrategy
    public final boolean shouldSkipClass(Class r5) {
        return false;
    }

    @Override // com.google.gson.ExclusionStrategy
    public final boolean shouldSkipField(FieldAttributes r5) {
        Intrinsics.checkNotNullParameter(r5, "field");
        if (r5.getAnnotation(g.class) == null) goto L6;
        return true;
    L6:
        return false;
    }
}
