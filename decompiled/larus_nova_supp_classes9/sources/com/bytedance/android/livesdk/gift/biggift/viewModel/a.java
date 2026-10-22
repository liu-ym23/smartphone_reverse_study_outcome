package com.bytedance.android.livesdk.gift.biggift.viewModel;

import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public final CurrentState a;
    public final int b;
    public final int c;
    public final e d;
    public final l1 e;
    public final n f;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L18;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
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

    public final int hashCode() {
        CurrentState r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((((r2 * 31) + this.b) * 31) + this.c) * 31;
        e r4 = this.d;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        l1 r7 = this.e;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        n r10 = this.f;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
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
        return "BigGiftSendInfo(state=" + this.a + ", clickCount=" + this.b + ", sendSuccessCount=" + this.c + ", subscribeGiftInfo=" + this.d + ", buffInfo=" + this.e + ", diyInfo=" + this.f + ")";
    }

    public a(CurrentState r2, int r3, int r4, e r5, l1 r6, n r7) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }

    public static a a(a r7, CurrentState r8, int r9, int r10, e r11, int r13) {
        if ((r13 & 1) == 0) goto L5;
        r8 = r7.a;
    L5:
        CurrentState r1 = r8;
        if ((r13 & 2) == 0) goto L8;
        r9 = r7.b;
    L8:
        int r2 = r9;
        if ((r13 & 4) == 0) goto L11;
        r10 = r7.c;
    L11:
        int r3 = r10;
        if ((r13 & 8) == 0) goto L14;
        r11 = r7.d;
    L14:
        e r4 = r11;
        if ((r13 & 16) == 0) goto L17;
        l1 r5 = r7.e;
    L19:
        if ((r13 & 32) == 0) goto L21;
        n r6 = r7.f;
    L22:
        Intrinsics.checkNotNullParameter(r1, "state");
        return new a(r1, r2, r3, r4, r5, r6);
    L21:
        r6 = null;
        goto L22
    L17:
        r5 = null;
        goto L19
    }
}
