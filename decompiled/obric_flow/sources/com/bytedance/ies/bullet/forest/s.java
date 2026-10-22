package com.bytedance.ies.bullet.forest;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f5418b;

    public s(int r5, byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "body");
        this.f5417a = r5;
        this.f5418b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        if (r5 == null) goto L7;
        Class<?> r10 = r5.getClass();
    L9:
        if (Intrinsics.areEqual(s.class, r10) == true) goto L11;
        return false;
    L11:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ies.bullet.forest.ReactLynxSSRChunk");
        s r11 = (s) r5;
        int r12 = r11.f5417a;
        if (this.f5417a == r12) goto L15;
        return false;
    L15:
        if (Arrays.equals(this.f5418b, r11.f5418b) == true) goto L17;
        return false;
    L17:
        return true;
    L7:
        r10 = null;
        goto L9
    }

    public final int hashCode() {
        int r5 = this.f5417a * 31;
        return Arrays.hashCode(this.f5418b) + r5;
    }

    public final String toString() {
        return "ReactLynxSSRChunk(type=" + this.f5417a + ", body=" + Arrays.toString(this.f5418b) + ')';
    }
}
