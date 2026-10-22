package com.bytedance.ies.argus.util;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ExclusionStrategy {
    @Override // com.google.gson.ExclusionStrategy
    public final boolean shouldSkipClass(Class r5) {
        return false;
    }

    @Override // com.google.gson.ExclusionStrategy
    public final boolean shouldSkipField(FieldAttributes r5) {
        Intrinsics.checkNotNullParameter(r5, "fieldAttributes");
        if (r5.getAnnotation(SerializedName.class) != null) goto L6;
        return true;
    L6:
        return false;
    }
}
