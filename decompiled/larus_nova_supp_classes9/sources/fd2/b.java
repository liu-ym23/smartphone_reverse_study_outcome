package fd2;

import android.content.Context;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public final Context a;
    public final String b;
    public final String c;
    public final boolean d;
    public final boolean e;
    public final String f;
    public final ViewGroup g;
    public final ViewGroup h;
    public final ViewGroup i;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L24;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        Context r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        boolean r10 = this.d;
        ?? r11 = 1;
        ?? r13 = r10;
        if (r10 == false) goto L17;
        r13 = 1;
    L17:
        int r14 = (r9 + r13) * 31;
        boolean r15 = this.e;
        if (r15 == true) goto L21;
        r11 = r15;
    L21:
        int r16 = (r14 + r11) * 31;
        String r17 = this.f;
        if (r17 == null) goto L24;
        int r18 = r17.hashCode();
    L25:
        int r19 = (r16 + r18) * 31;
        ViewGroup r20 = this.g;
        if (r20 == null) goto L28;
        int r21 = r20.hashCode();
    L29:
        int r23 = (r19 + r21) * 31;
        ViewGroup r24 = this.h;
        if (r24 == null) goto L32;
        int r25 = r24.hashCode();
    L33:
        int r26 = (r23 + r25) * 31;
        ViewGroup r27 = this.i;
        if (r27 == null) goto L37;
        r1 = r27.hashCode();
    L37:
        return r26 + r1;
    L32:
        r25 = 0;
        goto L33
    L28:
        r21 = 0;
        goto L29
    L24:
        r18 = 0;
        goto L25
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ChorusStageLynxViewLoadParams(context=" + this.a + ", roomId=" + this.b + ", anchorId=" + this.c + ", isFeed=" + this.d + ", isVideoChorus=" + this.e + ", enterFrom=" + this.f + ", rootContainer=" + this.g + ", lyricContainer=" + this.h + ", lynxContainer=" + this.i + ")";
    }

    public final Context getContext() {
        return this.a;
    }

    public b(Context r2, String r3, String r4, boolean r5, boolean r6, String r7, ViewGroup r8, ViewGroup r9, ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "roomId");
        Intrinsics.checkNotNullParameter(r4, "anchorId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
