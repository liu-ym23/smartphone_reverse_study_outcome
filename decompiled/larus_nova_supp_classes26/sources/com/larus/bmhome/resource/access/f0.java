package com.larus.bmhome.resource.access;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f0 {
    public final ResourceMediaType a;
    public final j0 b;
    public final String c;
    public final String d;
    public final mr9.l e;
    public final Map<String, String> f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r6 = (f0) r5;
        if (this.a == r6.a) goto L12;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        mr9.l r8 = this.e;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return ((r7 + r2) * 31) + this.f.hashCode();
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ResourceArtifact(mediaType=" + this.a + ", resourceInput=" + this.b + ", tosKey=" + this.c + ", resourceId=" + this.d + ", uploadResult=" + this.e + ", metadata=" + this.f + ')';
    }

    public static f0 a(f0 r7, Map r8) {
        ResourceMediaType r1 = r7.a;
        j0 r2 = r7.b;
        String r3 = r7.c;
        String r4 = r7.d;
        mr9.l r5 = r7.e;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r1, "mediaType");
        Intrinsics.checkNotNullParameter(r2, "resourceInput");
        Intrinsics.checkNotNullParameter(r8, "metadata");
        return new f0(r1, r2, r3, r4, r5, r8);
    }

    public f0(ResourceMediaType r2, j0 r3, String r4, String r5, mr9.l r6, Map<String, String> r7) {
        Intrinsics.checkNotNullParameter(r2, "mediaType");
        Intrinsics.checkNotNullParameter(r3, "resourceInput");
        Intrinsics.checkNotNullParameter(r7, "metadata");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }

    public /* synthetic */ f0(ResourceMediaType r10, j0 r11, String r12, String r13, mr9.l r14, Map r15, int r16) {
        if ((r16 & 4) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r16 & 8) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r16 & 16) == 0) goto L13;
        mr9.l r7 = null;
    L15:
        if ((r16 & 32) == 0) goto L17;
        Map r8 = MapsKt.emptyMap();
    L18:
        this(r10, r11, r5, r6, r7, r8);
        return;
    L17:
        r8 = r15;
        goto L18
    L13:
        r7 = r14;
        goto L15
    L9:
        r6 = r13;
        goto L11
    L5:
        r5 = r12;
        goto L7
    }
}
