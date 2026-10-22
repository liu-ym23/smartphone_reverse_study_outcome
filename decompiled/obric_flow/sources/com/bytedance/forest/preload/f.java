package com.bytedance.forest.preload;

import com.bytedance.forest.model.t;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f4575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.forest.utils.a f4576c;
    public final c d;

    public f(String r5, t r10, com.bytedance.forest.utils.a r11, c r12) {
        this.f4574a = r5;
        this.f4575b = r10;
        this.f4576c = r11;
        this.d = r12;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        if (r5 == null) goto L7;
        Class<?> r10 = r5.getClass();
    L9:
        if (Intrinsics.areEqual(f.class, r10) == true) goto L11;
        return false;
    L11:
        if (r5 == null) goto L17;
        if (Intrinsics.areEqual(this.f4576c, ((f) r5).f4576c) == true) goto L15;
        return false;
    L15:
        return true;
    L17:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.forest.preload.PreloadTask");
    L7:
        r10 = null;
        goto L9
    }

    public final int hashCode() {
        return this.f4576c.hashCode();
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("PreloadTask@");
        com.bytedance.forest.utils.a r10 = this.f4576c;
        r5.append(r10.hashCode());
        r5.append("(key=");
        r5.append(r10);
        r5.append(", params=");
        r5.append(this.f4575b);
        r5.append(", delegate=");
        r5.append(this.d);
        r5.append(')');
        return r5.toString();
    }
}
