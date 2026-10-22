package com.larus.bmhome.clarification;

import com.larus.bmhome.share.panel.ShareType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class v1 {
    public final String a;
    public final int b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof v1) == true) goto L8;
        return false;
    L8:
        v1 r6 = (v1) r5;
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
        return "ClarificationInputSnapshot(text=" + this.a + ", status=" + this.b + ')';
    }

    public v1(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, ShareType.TEXT);
        this.a = r2;
        this.b = r3;
    }
}
