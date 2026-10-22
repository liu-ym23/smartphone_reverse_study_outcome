package com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.uc1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public final long a;
    public final int b;
    public final String c;
    public final String d;
    public final ImageModel e;
    public final String f;
    public final String g;
    public final String h;
    public final int i;

    public b() {
        this(null, null, null, null, null, 511);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof b) == false) goto L24;
        b r7 = (b) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r7.h) == true) goto L22;
        return false;
    L22:
        if (this.i == r7.i) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31;
        String r2 = this.c;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (r1 + r4) * 31;
        String r6 = this.d;
        if (r6 == null) goto L9;
        int r7 = r6.hashCode();
    L10:
        int r8 = (r5 + r7) * 31;
        ImageModel r9 = this.e;
        if (r9 == null) goto L13;
        int r10 = r9.hashCode();
    L14:
        int r11 = (r8 + r10) * 31;
        String r12 = this.f;
        if (r12 == null) goto L17;
        int r13 = r12.hashCode();
    L18:
        int r14 = (r11 + r13) * 31;
        String r15 = this.g;
        if (r15 == null) goto L21;
        int r16 = r15.hashCode();
    L22:
        int r17 = (r14 + r16) * 31;
        String r18 = this.h;
        if (r18 == null) goto L26;
        r3 = r18.hashCode();
    L26:
        return ((r17 + r3) * 31) + this.i;
    L21:
        r16 = 0;
        goto L22
    L17:
        r13 = 0;
        goto L18
    L13:
        r10 = 0;
        goto L14
    L9:
        r7 = 0;
        goto L10
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "ExplainCardInfo(cardId=" + this.a + ", titleType=" + this.b + ", title=" + this.c + ", cover=" + this.d + ", icon=" + this.e + ", appName=" + this.f + ", btnText=" + this.g + ", topIcon=" + this.h + ", showDuration=" + this.i + ")";
    }

    public static b a(b r15, String r16, String r17, int r18) {
        if ((r18 & 1) == 0) goto L5;
        long r2 = r15.a;
    L6:
        long r5 = r2;
        if ((r18 & 2) == 0) goto L9;
        int r7 = r15.b;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r8 = r15.c;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r9 = r15.d;
    L19:
        if ((r18 & 16) == 0) goto L21;
        ImageModel r10 = r15.e;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r11 = r15.f;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r12 = r15.g;
    L31:
        if ((r18 & 128) == 0) goto L33;
        String r13 = r15.h;
    L35:
        if ((r18 & 256) == 0) goto L37;
        int r14 = r15.i;
    L39:
        return new b(r5, r7, r8, r9, r10, r11, r12, r13, r14);
    L37:
        r14 = 0;
        goto L39
    L33:
        r13 = null;
        goto L35
    L29:
        r12 = null;
        goto L31
    L25:
        r11 = null;
        goto L27
    L21:
        r10 = null;
        goto L23
    L17:
        r9 = r17;
        goto L19
    L13:
        r8 = r16;
        goto L15
    L9:
        r7 = 0;
        goto L11
    L5:
        r2 = 0;
        goto L6
    }

    public /* synthetic */ b(String r13, String r14, ImageModel r15, String r16, String r17, int r18) {
        if ((r18 & 4) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r18 & 8) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r18 & 16) == 0) goto L13;
        ImageModel r7 = null;
    L15:
        if ((r18 & 32) == 0) goto L17;
        String r8 = null;
    L19:
        if ((r18 & 64) == 0) goto L21;
        String r9 = null;
    L23:
        if ((r18 & 128) == 0) goto L27;
        uc1 r0 = (uc1) ee0.a.getValue();
        if (r0 == null) goto L27;
        String r10 = r0.n();
    L28:
        this(0, 0, r4, r6, r7, r8, r9, r10, 0);
        return;
    L27:
        r10 = null;
        goto L28
    L21:
        r9 = r17;
        goto L23
    L17:
        r8 = r16;
        goto L19
    L13:
        r7 = r15;
        goto L15
    L9:
        r6 = r14;
        goto L11
    L5:
        r4 = r13;
        goto L7
    }

    public b(long r1, int r3, String r4, String r5, ImageModel r6, String r7, String r8, String r9, int r10) {
        this.a = r1;
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
