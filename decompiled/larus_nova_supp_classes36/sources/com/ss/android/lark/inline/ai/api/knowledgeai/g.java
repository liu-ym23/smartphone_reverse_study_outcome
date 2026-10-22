package com.ss.android.lark.inline.ai.api.knowledgeai;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g {
    public final String a;
    public final long b;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof g) == true) goto L8;
        return false;
    L8:
        g r9 = (g) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "RecentAITopicConfig(spKey=" + this.a + ", expireTimeMs=" + this.b + ')';
    }

    public g(String r3) {
        Intrinsics.checkNotNullParameter(r3, "spKey");
        this.a = r3;
        this.b = 1800000;
    }
}
