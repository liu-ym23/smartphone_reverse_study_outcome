package com.ss.android.lark.coremd.base.parse;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e {
    public final List<g> a;
    public final j b;
    public final List<f> c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        List<f> r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "MarkdownParseConfig(plugins=" + this.a + ", theme=" + this.b + ", parseListeners=" + this.c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(List<? extends g> r2, j r3, List<? extends f> r4) {
        Intrinsics.checkNotNullParameter(r2, "plugins");
        Intrinsics.checkNotNullParameter(r3, "theme");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
