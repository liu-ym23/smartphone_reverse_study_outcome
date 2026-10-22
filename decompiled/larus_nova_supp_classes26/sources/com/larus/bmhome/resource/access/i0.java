package com.larus.bmhome.resource.access;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i0 {
    public static final i0 h = null;
    public final j0 a;
    public final mr9.c b;
    public final Long c;
    public final mr9.h d;
    public final String e;
    public final f0 f;
    public final Map<String, String> g;

    public static final class a {
    }

    public i0() {
        this(null, null, null, null, null, null, null, 127);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r6 = (i0) r5;
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
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        j0 r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        mr9.c r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        mr9.h r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        f0 r16 = this.f;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return ((r15 + r1) * 31) + this.g.hashCode();
    L21:
        r14 = r13.hashCode();
        goto L22
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
        return "ResourceContextUpdate(resourceInput=" + this.a + ", instantUploadPolicy=" + this.b + ", uploadFileSize=" + this.c + ", resourceCenterUploadParam=" + this.d + ", fileExtension=" + this.e + ", artifact=" + this.f + ", attributes=" + this.g + ')';
    }

    static {
        h = new i0(null, null, null, null, null, null, null, 127);
    }

    public i0(j0 r2, mr9.c r3, Long r4, mr9.h r5, String r6, f0 r7, Map<String, String> r8) {
        Intrinsics.checkNotNullParameter(r8, "attributes");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }

    public /* synthetic */ i0(j0 r7, mr9.c r8, Long r9, mr9.h r10, String r11, f0 r12, Map r13, int r14) {
        f0 r1 = null;
        if ((r14 & 1) == 0) goto L5;
        j0 r0 = null;
    L7:
        if ((r14 & 2) == 0) goto L9;
        mr9.c r2 = null;
    L11:
        if ((r14 & 4) == 0) goto L13;
        Long r3 = null;
    L15:
        if ((r14 & 8) == 0) goto L17;
        mr9.h r4 = null;
    L19:
        if ((r14 & 16) == 0) goto L21;
        String r5 = null;
    L23:
        if ((r14 & 32) != 0) goto L27;
        r1 = r12;
    L27:
        if ((r14 & 64) == 0) goto L29;
        r13 = MapsKt.emptyMap();
    L29:
        this(r0, r2, r3, r4, r5, r1, r13);
        return;
    L21:
        r5 = r11;
        goto L23
    L17:
        r4 = r10;
        goto L19
    L13:
        r3 = r9;
        goto L15
    L9:
        r2 = r8;
        goto L11
    L5:
        r0 = r7;
        goto L7
    }
}
