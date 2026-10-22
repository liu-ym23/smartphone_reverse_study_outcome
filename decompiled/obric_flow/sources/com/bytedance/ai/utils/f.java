package com.bytedance.ai.utils;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f2849a;

    public f(byte[] r5) {
        this.f2849a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        if (r5 == null) goto L7;
        Class<?> r10 = r5.getClass();
    L9:
        if (Intrinsics.areEqual(f.class, r10) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ai.utils.ResponseData.BinaryResponse");
        return Arrays.equals(this.f2849a, ((f) r5).f2849a);
    L7:
        r10 = null;
        goto L9
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f2849a);
    }

    public final String toString() {
        return "BinaryResponse(data=" + Arrays.toString(this.f2849a) + ')';
    }
}
