package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class r {
    public final String a;
    public final Set<Long> b;
    public final String c;
    public final String d;
    public final long e;
    public final long f;
    public final boolean g;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof r) == true) goto L8;
        return false;
    L8:
        r r9 = (r) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        long r1 = this.e;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.f;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        if (this.g == false) goto L5;
        int r5 = 1231;
    L7:
        return r4 + r5;
    L5:
        r5 = 1237;
        goto L7
    }

    public final String toString() {
        return "MmSubtitleMarkGroup(markId=" + this.a + ", segIds=" + this.b + ", copyText=" + this.c + ", contentMarkdown=" + this.d + ", relativeAudioTimeMs=" + this.e + ", audioLocationTimeMs=" + this.f + ", allFinal=" + this.g + ')';
    }

    public r(String r2, Set<Long> r3, String r4, String r5, long r6, long r8, boolean r10) {
        Intrinsics.checkNotNullParameter(r2, "markId");
        Intrinsics.checkNotNullParameter(r3, "segIds");
        Intrinsics.checkNotNullParameter(r4, "copyText");
        Intrinsics.checkNotNullParameter(r5, "contentMarkdown");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        this.g = r10;
    }
}
