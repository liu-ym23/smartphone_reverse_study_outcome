package com.larus.bmhome.chat.component.bottom.core.speaker;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public final boolean a;
    public final Map<String, String> b;

    public a() {
        boolean r1 = false;
        this(r1, 3);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L7:
        return (r0 * 31) + this.b.hashCode();
    L5:
        r0 = 1237;
        goto L7
    }

    public final String toString() {
        return "ASRWithExtResult(intercept=" + this.a + ", messageExt=" + this.b + ')';
    }

    public /* synthetic */ a(boolean r2, int r3) {
        if ((r3 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r3 & 2) == 0) goto L8;
        Map r4 = MapsKt.emptyMap();
    L9:
        this(r2, r4);
        return;
    L8:
        r4 = null;
        goto L9
    }

    public a(boolean r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "messageExt");
        this.a = r2;
        this.b = r3;
    }
}
