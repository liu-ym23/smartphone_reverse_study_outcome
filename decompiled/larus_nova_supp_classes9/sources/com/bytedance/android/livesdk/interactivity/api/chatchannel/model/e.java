package com.bytedance.android.livesdk.interactivity.api.chatchannel.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public final String a;
    public final boolean b;
    public final boolean c;
    public final int d;
    public final String e;
    public final String f;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L18;
        e r4 = (e) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
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
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        ?? r5 = 1;
        ?? r6 = r4;
        if (r4 == false) goto L9;
        r6 = 1;
    L9:
        int r7 = (r3 + r6) * 31;
        boolean r8 = this.c;
        if (r8 == true) goto L13;
        r5 = r8;
    L13:
        int r9 = (((r7 + r5) * 31) + this.d) * 31;
        String r10 = this.e;
        if (r10 == null) goto L16;
        int r11 = r10.hashCode();
    L17:
        int r13 = (r9 + r11) * 31;
        String r14 = this.f;
        if (r14 == null) goto L21;
        r1 = r14.hashCode();
    L21:
        return r13 + r1;
    L16:
        r11 = 0;
        goto L17
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "CreateChannelLogInfo(enterFrom=" + this.a + ", isGroup=" + this.b + ", isRepeat=" + this.c + ", number=" + this.d + ", friendList=" + this.e + ", groupList=" + this.f + ")";
    }

    public /* synthetic */ e(String r8) {
        this(r8, false, false, 0, null, null);
    }

    public e(String r1, boolean r2, boolean r3, int r4, String r5, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
