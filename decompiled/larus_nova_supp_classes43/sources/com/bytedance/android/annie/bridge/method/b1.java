package com.bytedance.android.annie.bridge.method;

import android.content.Context;
import android.content.DialogInterface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b1 {
    public final Context a;
    public final String b;
    public final String c;
    public final String d;
    public final DialogInterface.OnClickListener e;
    public final String f;
    public final DialogInterface.OnClickListener g;
    public final DialogInterface.OnCancelListener h;
    public final Boolean i;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b1) == true) goto L8;
        return false;
    L8:
        b1 r11 = (b1) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r11.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r11.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (r0 + r11) * 31;
        String r13 = this.c;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        String r16 = this.d;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        DialogInterface.OnClickListener r19 = this.e;
        if (r19 != null) goto L17;
        int r20 = 0;
    L18:
        int r21 = (r18 + r20) * 31;
        String r22 = this.f;
        if (r22 != null) goto L21;
        int r23 = 0;
    L22:
        int r24 = (r21 + r23) * 31;
        DialogInterface.OnClickListener r25 = this.g;
        if (r25 != null) goto L25;
        int r26 = 0;
    L26:
        int r27 = (r24 + r26) * 31;
        DialogInterface.OnCancelListener r28 = this.h;
        if (r28 != null) goto L29;
        int r29 = 0;
    L30:
        int r30 = (r27 + r29) * 31;
        Boolean r31 = this.i;
        if (r31 == null) goto L35;
        r10 = r31.hashCode();
    L35:
        return r30 + r10;
    L29:
        r29 = r28.hashCode();
        goto L30
    L25:
        r26 = r25.hashCode();
        goto L26
    L21:
        r23 = r22.hashCode();
        goto L22
    L17:
        r20 = r19.hashCode();
        goto L18
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ModalBuilder(context=" + this.a + ", title=" + this.b + ", message=" + this.c + ", positiveBtnText=" + this.d + ", positiveClickListener=" + this.e + ", negativeBtnText=" + this.f + ", negativeClickListener=" + this.g + ", cancelListener=" + this.h + ", cancelOnTouchOutside=" + this.i + ')';
    }

    public final Context getContext() {
        return this.a;
    }

    public b1(Context r10, String r11, String r12, String r13, l2 r14, String r15, j2 r16, k2 r17, Boolean r18) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        this.i = r18;
    }
}
