package com.larus.bmhome.share.panel;

import com.larus.bmhome.share.ShareScene;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public final boolean a;
    public final Integer b;
    public final boolean c;
    public final ShareScene d;
    public final h e;
    public final by7.e f;
    public final boolean g;
    public final Function1<Continuation<? super g>, Object> h;

    public e() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        Integer r3 = this.b;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        if (this.c == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (((r6 + r7) * 31) + this.d.hashCode()) * 31;
        h r9 = this.e;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        by7.e r12 = this.f;
        if (r12 == null) goto L22;
        r4 = r12.hashCode();
    L22:
        int r13 = (r11 + r4) * 31;
        if (this.g == true) goto L27;
        r1 = 1237;
    L27:
        return ((r13 + r1) * 31) + this.h.hashCode();
    L17:
        r10 = r9.hashCode();
        goto L18
    L13:
        r7 = 1237;
        goto L14
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "LongImageShareParams(isImmersive=" + this.a + ", immersiveBgColor=" + this.b + ", autoDismiss=" + this.c + ", shareScene=" + this.d + ", eventParam=" + this.e + ", trackNode=" + this.f + ", needChangeShareContent=" + this.g + ", newShareDataGetter=" + this.h + ')';
    }

    public e(boolean r4, Integer r5, h r6, by7.e r7, boolean r8, Function1 r9, int r10) {
        if ((r10 & 2) == 0) goto L6;
        r5 = null;
    L6:
        if ((r10 & 8) == 0) goto L8;
        ShareScene r0 = ShareScene.SHOW_LONG_IMAGE;
    L10:
        if ((r10 & 16) == 0) goto L13;
        r6 = null;
    L13:
        if ((r10 & 32) == 0) goto L16;
        r7 = null;
    L16:
        if ((r10 & 64) == 0) goto L19;
        r8 = false;
    L19:
        if ((r10 & 128) == 0) goto L21;
        r9 = new LongImageShareParams$1(null);
    L21:
        Intrinsics.checkNotNullParameter(r0, "shareScene");
        Intrinsics.checkNotNullParameter(r9, "newShareDataGetter");
        this.a = r4;
        this.b = r5;
        this.c = true;
        this.d = r0;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        return;
    L8:
        r0 = null;
        goto L10
    }
}
