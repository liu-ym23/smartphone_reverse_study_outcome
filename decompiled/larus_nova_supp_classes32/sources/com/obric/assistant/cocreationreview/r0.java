package com.obric.assistant.cocreationreview;

import com.lynx.jsbridge.LynxAccessibilityModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class r0 {
    public final ModuleKey a;
    public final String b;
    public final String c;
    public final long d;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof r0) == true) goto L8;
        return false;
    L8:
        r0 r9 = (r0) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        long r1 = this.d;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "CocreationReport(module=" + this.a + ", issue=" + this.b + ", content=" + this.c + ", createdAt=" + this.d + ')';
    }

    public r0(ModuleKey r4, String r5, String r6) {
        long r0 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r4, "module");
        Intrinsics.checkNotNullParameter(r5, "issue");
        Intrinsics.checkNotNullParameter(r6, LynxAccessibilityModule.MSG_CONTENT);
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r0;
    }
}
