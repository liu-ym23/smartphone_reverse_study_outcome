package com.bytedance.android.live.gson;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements ExclusionStrategy {
    public a() {
    }

    public final boolean shouldSkipClass(Class<?> r1) {
        return false;
    }

    public final boolean shouldSkipField(FieldAttributes r5) {
        Intrinsics.checkNotNullParameter(r5, "f");
        SerializedName r0 = r5.getAnnotation(SerializedName.class);
        Class r6 = r5.getDeclaredClass();
        if (r6.isArray() == false) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == false) goto L15;
        if (r0 != null) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual("user_ids", r0.value()) == false) goto L17;
        return true;
    L17:
        return false;
    L15:
        return false;
    L5:
        if (Iterable.class.isAssignableFrom(r6) == true) goto L8;
        r7 = false;
        goto L9
    }
}
