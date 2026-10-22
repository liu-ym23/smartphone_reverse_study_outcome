package com.bytedance.ai.applet.moa;

import android.content.Context;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o {
    public final u2.e a;
    public final m b;
    public final String c;
    public final WeakReference<Context> d;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof o) == true) goto L8;
        return false;
    L8:
        o r11 = (o) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        WeakReference<Context> r1 = this.d;
        if (r1 != null) goto L5;
        int r10 = 0;
    L7:
        return r0 + r10;
    L5:
        r10 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "MoaGrantingStepContext(grantingData=" + this.a + ", request=" + this.b + ", attemptID=" + this.c + ", uiContextWk=" + this.d + ')';
    }

    public o(u2.e r10, m r11, String r12, WeakReference<Context> r13) {
        Intrinsics.checkNotNullParameter(r10, "grantingData");
        Intrinsics.checkNotNullParameter(r11, "request");
        Intrinsics.checkNotNullParameter(r12, "attemptID");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
    }
}
