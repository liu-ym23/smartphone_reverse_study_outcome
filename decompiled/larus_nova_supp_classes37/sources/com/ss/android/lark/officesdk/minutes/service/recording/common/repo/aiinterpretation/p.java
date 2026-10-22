package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class p {
    public final String a;
    public final int b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p) == true) goto L8;
        return false;
    L8:
        p r6 = (p) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    public final String toString() {
        return "MmAIInterpretationUpdateResult(channel=" + this.a + ", status=" + this.b + ')';
    }

    public final boolean a() {
        if (this.b == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public p(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        this.a = r2;
        this.b = r3;
    }
}
