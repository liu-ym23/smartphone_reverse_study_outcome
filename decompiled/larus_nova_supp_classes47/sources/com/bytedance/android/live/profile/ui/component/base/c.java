package com.bytedance.android.live.profile.ui.component.base;

import com.bytedance.android.live.profile.model.CompareOperation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> {
    public final int a;
    public final int b;
    public final T c;
    public e<T> d;
    public CompareOperation e;

    public c() {
        throw null;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L16;
        c r4 = (c) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        T r1 = this.c;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        e<T> r5 = this.d;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        CompareOperation r8 = this.e;
        if (r8 == null) goto L14;
        r2 = r8.hashCode();
    L14:
        return r7 + r2;
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "LoadedViewInfo(type=" + this.a + ", index=" + this.b + ", data=" + this.c + ", view=" + this.d + ", operation=" + this.e + ")";
    }

    public final int getType() {
        return this.a;
    }

    public final void a(CompareOperation r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(int r3, int r4, b r5, e r6) {
        CompareOperation r0 = CompareOperation.Nothing;
        Intrinsics.checkNotNullParameter(r0, "operation");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r0;
    }
}
