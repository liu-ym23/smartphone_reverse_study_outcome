package com.bytedance.android.livesdk.gift.platform.business.effect.service.feed;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public final int a;
    public final int b;
    public final boolean c;
    public final String d;
    public final boolean e;
    public final String f;
    public final String g;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L20;
        a r4 = (a) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
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
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        boolean r1 = this.c;
        ?? r2 = 1;
        ?? r3 = r1;
        if (r1 == false) goto L5;
        r3 = 1;
    L5:
        int r4 = (r0 + r3) * 31;
        String r5 = this.d;
        int r6 = 0;
        if (r5 == null) goto L8;
        int r7 = r5.hashCode();
    L9:
        int r8 = (r4 + r7) * 31;
        boolean r9 = this.e;
        if (r9 == true) goto L13;
        r2 = r9;
    L13:
        int r10 = (r8 + r2) * 31;
        String r11 = this.f;
        if (r11 == null) goto L16;
        int r13 = r11.hashCode();
    L17:
        int r14 = (r10 + r13) * 31;
        String r15 = this.g;
        if (r15 == null) goto L21;
        r6 = r15.hashCode();
    L21:
        return r14 + r6;
    L16:
        r13 = 0;
        goto L17
    L8:
        r7 = 0;
        goto L9
    }

    public final String toString() {
        return "EffectRequestParam(action=" + this.a + ", type=" + this.b + ", draggable=" + this.c + ", schema=" + this.d + ", touchable=" + this.e + ", channel=" + this.f + ", superViewIdentifier=" + this.g + ")";
    }

    public final int getType() {
        return this.b;
    }

    public a(int r2, int r3, boolean r4, String r5, boolean r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
