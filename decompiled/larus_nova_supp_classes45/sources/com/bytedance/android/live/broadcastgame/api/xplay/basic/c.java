package com.bytedance.android.live.broadcastgame.api.xplay.basic;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public final Context a;
    public final String b;
    public final boolean c;
    public final String d;
    public final boolean e;
    public final e f;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L18;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
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
        boolean r7 = this.c;
        ?? r8 = 1;
        ?? r9 = r7;
        if (r7 == false) goto L13;
        r9 = 1;
    L13:
        int r11 = (r6 + r9) * 31;
        String r12 = this.d;
        if (r12 == null) goto L16;
        int r13 = r12.hashCode();
    L17:
        int r14 = (r11 + r13) * 31;
        boolean r15 = this.e;
        if (r15 == true) goto L21;
        r8 = r15;
    L21:
        int r16 = (r14 + r8) * 31;
        e r17 = this.f;
        if (r17 == null) goto L25;
        r1 = r17.hashCode();
    L25:
        return r16 + r1;
    L16:
        r13 = 0;
        goto L17
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "XplayBasicEnv(context=" + this.a + ", roomOwnerUserId=" + this.b + ", isAnchor=" + this.c + ", userId=" + this.d + ", isSilent=" + this.e + ", startParams=" + this.f + ")";
    }

    public final Context getContext() {
        return this.a;
    }

    public c(Context r2, String r3, boolean r4, String r5, e r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "roomOwnerUserId");
        Intrinsics.checkNotNullParameter(r5, "userId");
        Intrinsics.checkNotNullParameter(r6, "startParams");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = true;
        this.f = r6;
    }
}
