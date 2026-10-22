package com.bytedance.android.livesdk.event;

import android.text.style.ImageSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n implements l {
    public final int a;
    public final String b;
    public final String c;
    public final int d;
    public final int e;
    public final ImageSpan f;
    public final py.k g;
    public final float h;
    public final float i;

    public final String toString() {
        return "ImageSendInfo(type=" + getType() + ", value=" + this.b + ", text=" + this.c + ", start=" + this.d + ", length=" + this.e + ", imageSpan=" + this.f + ", imageModel=" + this.g + ", selfPublicScreenScale=" + this.h + ", selfDanmakuScale=" + this.i + ")";
    }

    public final int hashCode() {
        int r0 = getType() * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (((((r4 + r6) * 31) + this.d) * 31) + this.e) * 31;
        ImageSpan r8 = this.f;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        py.k r11 = this.g;
        if (r11 == null) goto L18;
        r2 = r11.hashCode();
    L18:
        return ((((r10 + r2) * 31) + Float.floatToIntBits(this.h)) * 31) + Float.floatToIntBits(this.i);
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.event.l
    public final int getLength() {
        return this.e;
    }

    @Override // com.bytedance.android.livesdk.event.l
    public final int getStart() {
        return this.d;
    }

    @Override // com.bytedance.android.livesdk.event.l
    public int getType() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.event.l
    public final String getValue() {
        return this.b;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof n) == false) goto L24;
        n r4 = (n) r3;
        if (getType() == r4.getType()) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Float.compare(this.h, r4.h) == 0) goto L22;
        return false;
    L22:
        if (Float.compare(this.i, r4.i) == 0) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public n(int r2, String r3, String r4, int r5, int r6, com.bytedance.android.livesdk.interactivity.comment.input.b r7, py.k r8, float r9) {
        Intrinsics.checkNotNullParameter(r3, "value");
        Intrinsics.checkNotNullParameter(r4, "text");
        Intrinsics.checkNotNullParameter(r7, "imageSpan");
        Intrinsics.checkNotNullParameter(r8, "imageModel");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = 1.0f;
    }
}
