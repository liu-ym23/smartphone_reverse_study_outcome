package com.larus.bmhome.chat.trace.appreciable;

import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g {
    public final String a;
    public final String b;
    public final long c;
    public final String d;

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
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        long r1 = this.c;
        return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "AudioParam(taskId=" + this.a + ", path=" + this.b + ", audioDuration=" + this.c + ", vid=" + this.d + ')';
    }

    public g(String r2, String r3, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, MusicAppletPage.KEY_PATH);
        Intrinsics.checkNotNullParameter(r6, "vid");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
    }
}
