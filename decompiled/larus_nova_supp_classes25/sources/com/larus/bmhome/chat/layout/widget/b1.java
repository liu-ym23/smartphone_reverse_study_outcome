package com.larus.bmhome.chat.layout.widget;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b1 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final Fragment f;
    public final int g;
    public final boolean h;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b1) == true) goto L8;
        return false;
    L8:
        b1 r6 = (b1) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
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
        if (this.h == r6.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.e;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        Fragment r14 = this.f;
        if (r14 == null) goto L22;
        r2 = r14.hashCode();
    L22:
        int r15 = (((r13 + r2) * 31) + this.g) * 31;
        if (this.h == false) goto L25;
        int r16 = 1231;
    L27:
        return r15 + r16;
    L25:
        r16 = 1237;
        goto L27
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "RecycleData(msgId=" + this.a + ", senderId=" + this.b + ", convId=" + this.c + ", sectionId=" + this.d + ", replyId=" + this.e + ", hostFragment=" + this.f + ", layoutPosition=" + this.g + ", enableRecycle=" + this.h + ')';
    }

    public b1(String r2, String r3, String r4, String r5, String r6, Fragment r7, int r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
