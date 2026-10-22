package k42;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public final String a;
    public final long b;
    public final long c;
    public final String d;
    public final String e;
    public final Long f;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof e) == false) goto L18;
        e r7 = (e) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.b;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.c;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        String r7 = this.d;
        if (r7 == null) goto L9;
        int r8 = r7.hashCode();
    L10:
        int r9 = (r6 + r8) * 31;
        String r10 = this.e;
        if (r10 == null) goto L13;
        int r11 = r10.hashCode();
    L14:
        int r13 = (r9 + r11) * 31;
        Long r14 = this.f;
        if (r14 == null) goto L18;
        r1 = r14.hashCode();
    L18:
        return r13 + r1;
    L13:
        r11 = 0;
        goto L14
    L9:
        r8 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "VideoPinContent(scene=" + this.a + ", itemId=" + this.b + ", msgId=" + this.c + ", nickname=" + this.d + ", commenterId=" + this.e + ", videoPinId=" + this.f + ")";
    }

    public e(long r3, long r5, String r7, String r8) {
        Intrinsics.checkNotNullParameter("video_highlight", "scene");
        Intrinsics.checkNotNullParameter(r7, "nickname");
        Intrinsics.checkNotNullParameter(r8, "commenterId");
        this.a = "video_highlight";
        this.b = r3;
        this.c = r5;
        this.d = r7;
        this.e = r8;
        this.f = null;
    }
}
