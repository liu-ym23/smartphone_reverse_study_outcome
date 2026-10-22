package com.larus.chat.gallery.impl.preview.toolbar;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j {
    public final ToolbarButtonType a;
    public final int b;
    public final int c;
    public final int d;
    public final String e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final Map<String, Object> i;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r6 = (j) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
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
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31;
        String r1 = this.e;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        int r4 = 1231;
        if (this.f == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.g == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r6 + r7) * 31;
        if (this.h == true) goto L19;
        r4 = 1237;
    L19:
        return ((r8 + r4) * 31) + this.i.hashCode();
    L13:
        r7 = 1237;
        goto L14
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ToolbarButtonItem(type=" + this.a + ", iconRes=" + this.b + ", overflowIconRes=" + this.c + ", textRes=" + this.d + ", textHardcode=" + this.e + ", visible=" + this.f + ", enabled=" + this.g + ", overflow=" + this.h + ", statePayload=" + this.i + ')';
    }

    public final ToolbarButtonType getType() {
        return this.a;
    }

    public /* synthetic */ j(ToolbarButtonType r14, int r15, int r16, int r17, String r18, boolean r19, int r20) {
        if ((r20 & 4) == 0) goto L5;
        int r6 = 0;
    L7:
        if ((r20 & 16) == 0) goto L9;
        String r8 = null;
    L11:
        if ((r20 & 64) == 0) goto L13;
        boolean r10 = true;
    L15:
        if ((r20 & 128) == 0) goto L17;
        boolean r11 = false;
    L19:
        if ((r20 & 256) == 0) goto L21;
        Map r12 = MapsKt.emptyMap();
    L22:
        this(r14, r15, r6, r17, r8, true, r10, r11, r12);
        return;
    L21:
        r12 = null;
        goto L22
    L17:
        r11 = r19;
        goto L19
    L13:
        r10 = false;
        goto L15
    L9:
        r8 = r18;
        goto L11
    L5:
        r6 = r16;
        goto L7
    }

    public static j a(j r14, int r15, int r16, int r17, boolean r18, boolean r19, Map r20, int r21) {
        String r3 = null;
        if ((r21 & 1) == 0) goto L5;
        ToolbarButtonType r5 = r14.a;
    L7:
        if ((r21 & 2) == 0) goto L9;
        int r6 = r14.b;
    L11:
        if ((r21 & 4) == 0) goto L13;
        int r7 = r14.c;
    L15:
        if ((r21 & 8) == 0) goto L17;
        int r8 = r14.d;
    L19:
        if ((r21 & 16) == 0) goto L21;
        r3 = r14.e;
    L21:
        String r9 = r3;
        if ((r21 & 32) == 0) goto L24;
        boolean r10 = r14.f;
    L26:
        if ((r21 & 64) == 0) goto L28;
        boolean r11 = r14.g;
    L30:
        if ((r21 & 128) == 0) goto L32;
        boolean r12 = r14.h;
    L34:
        if ((r21 & 256) == 0) goto L36;
        Map r13 = r14.i;
    L37:
        r14.getClass();
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r13, "statePayload");
        return new j(r5, r6, r7, r8, r9, r10, r11, r12, r13);
    L36:
        r13 = r20;
        goto L37
    L32:
        r12 = r19;
        goto L34
    L28:
        r11 = false;
        goto L30
    L24:
        r10 = r18;
        goto L26
    L17:
        r8 = r17;
        goto L19
    L13:
        r7 = r16;
        goto L15
    L9:
        r6 = r15;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    public j(ToolbarButtonType r2, int r3, int r4, int r5, String r6, boolean r7, boolean r8, boolean r9, Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r10, "statePayload");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
