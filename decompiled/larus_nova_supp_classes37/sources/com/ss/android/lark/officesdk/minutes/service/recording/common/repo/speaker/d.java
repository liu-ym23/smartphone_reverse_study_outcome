package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public final String a;
    public final String b;

    public d() {
        this(null, 3);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
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
        return "Image(key='" + this.a + "')";
    }

    public d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "fsUnit");
        this.a = r2;
        this.b = r3;
    }

    public /* synthetic */ d(String r3, int r4) {
        String r1 = "";
        if ((r4 & 1) == 0) goto L6;
        r3 = "";
    L6:
        if ((r4 & 2) != 0) goto L9;
        r1 = null;
    L9:
        this(r3, r1);
    }
}
