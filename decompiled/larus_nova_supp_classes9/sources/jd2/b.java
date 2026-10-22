package jd2;

import android.content.Context;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public final Context a;
    public final ViewGroup b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L18;
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
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        Context r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ViewGroup r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r13 = (r9 + r11) * 31;
        String r14 = this.e;
        if (r14 == null) goto L21;
        r1 = r14.hashCode();
    L21:
        int r15 = (r13 + r1) * 31;
        boolean r16 = this.f;
        ?? r17 = r16;
        if (r16 == false) goto L25;
        r17 = 1;
    L25:
        return r15 + r17;
    L17:
        r11 = 0;
        goto L18
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
        return "ConcertStageLynxLoadParams(context=" + this.a + ", lynxContainer=" + this.b + ", roomId=" + this.c + ", anchorId=" + this.d + ", userId=" + this.e + ", isFeed=" + this.f + ")";
    }

    public final Context getContext() {
        return this.a;
    }

    public b(Context r2, ViewGroup r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "lynxContainer");
        Intrinsics.checkNotNullParameter(r4, "roomId");
        Intrinsics.checkNotNullParameter(r5, "anchorId");
        Intrinsics.checkNotNullParameter(r6, "userId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = false;
    }
}
