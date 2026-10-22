package com.larus.uaigc.chat.block.correction;

import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.ImagePlaceHolder;
import com.larus.im.bean.message.ImageStatus;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class m {
    public final Message a;
    public final String b;
    public final int c;
    public final ImageObj d;
    public final ImageObj e;
    public final ImagePlaceHolder f;
    public final int g;

    public m() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
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
        if (this.g == r6.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        Message r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r3 + r5) * 31) + this.c) * 31;
        ImageObj r7 = this.d;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        ImageObj r10 = this.e;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        ImagePlaceHolder r13 = this.f;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return ((r12 + r1) * 31) + this.g;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "CorrectionImageViewInput(message=" + this.a + ", id=" + this.b + ", status=" + this.c + ", imageThumbInfo=" + this.d + ", imageOriInfo=" + this.e + ", placeholder=" + this.f + ", maxContentWidth=" + this.g + ')';
    }

    public /* synthetic */ m(int r9) {
        this(null, null, 0, null, null, null, 0);
    }

    public m(Message r1, String r2, @ImageStatus int r3, ImageObj r4, ImageObj r5, ImagePlaceHolder r6, int r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
