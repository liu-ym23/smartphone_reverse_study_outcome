package com.bytedance.android.livesdk.interactivity.api.comment.data;

import kotlin.jvm.internal.Intrinsics;
import u22.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public CharSequence a;
    public m.a b;
    public final InputDraftType c;
    public final long d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof e) == false) goto L14;
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r6.d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        CharSequence r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        m.a r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        InputDraftType r7 = this.c;
        if (r7 == null) goto L13;
        r1 = r7.hashCode();
    L13:
        int r8 = (r6 + r1) * 31;
        long r9 = this.d;
        return r8 + ((int) (r9 ^ (r9 >>> 32)));
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "InputDraftItem(content=" + this.a + ", atParams=" + this.b + ", type=" + this.c + ", sceneId=" + this.d + ")";
    }

    public final InputDraftType getType() {
        return this.c;
    }

    public e(CharSequence r2, InputDraftType r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "type");
        this.a = r2;
        this.b = null;
        this.c = r3;
        this.d = r4;
    }
}
