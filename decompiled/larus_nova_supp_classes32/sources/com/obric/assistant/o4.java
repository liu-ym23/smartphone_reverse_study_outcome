package com.obric.assistant;

import android.os.Bundle;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o4 {
    public final String a;
    public final String b;
    public final Bundle c;

    /* JADX WARN: Multi-variable type inference failed */
    public o4() {
        Object[] r0 = 0 == true ? 1 : 0;
        Object[] r1 = 0 == true ? 1 : 0;
        this(null, r0, r1, 7);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o4) == true) goto L8;
        return false;
    L8:
        o4 r6 = (o4) r5;
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
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Bundle r7 = this.c;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "RequestAuthenticationParams(title=" + this.a + ", description=" + this.b + ", reportParams=" + this.c + ')';
    }

    public o4(String r1, String r2, Bundle r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public /* synthetic */ o4(String r3, String r4, Bundle r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = NameKeys.UnloadStrategy_No_Strategy;
    L9:
        if ((r6 & 4) == 0) goto L11;
        r5 = null;
    L11:
        this(r3, r4, r5);
    }
}
