package com.obric.assistant.settings.autogui;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class s0 {
    public final String a;
    public final List<v0> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof s0) == true) goto L8;
        return false;
    L8:
        s0 r6 = (s0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "ObricRiskPreferenceUiState(pageName=" + this.a + ", rows=" + this.b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s0(String r2, List<? extends v0> r3) {
        Intrinsics.checkNotNullParameter(r2, "pageName");
        Intrinsics.checkNotNullParameter(r3, "rows");
        this.a = r2;
        this.b = r3;
    }

    public static s0 a(s0 r1, List r2) {
        String r0 = r1.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "pageName");
        Intrinsics.checkNotNullParameter(r2, "rows");
        return new s0(r0, r2);
    }
}
