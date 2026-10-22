package com.larus.profile.impl.creation;

import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.UserCreation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e1 {
    public static final com.larus.bmhome.bigimg.n1 a(UserCreation r12, boolean r13) {
        ImageInfo r0 = i2.a(r12, r13);
        Long r1 = null;
        if (r0 == null) goto L6;
        Image r2 = r0.c;
        if (r2 == null) goto L6;
    L9:
        if (r0 == null) goto L12;
        Image r3 = r0.a;
        if (r3 == null) goto L12;
    L16:
        if (r0 == null) goto L18;
        Image r4 = r0.c;
    L19:
        String r5 = i2.d(r4);
        if (r5 != null) goto L27;
        if (r0 == null) goto L23;
        Image r6 = r0.a;
    L24:
        r5 = i2.d(r6);
        if (r5 != null) goto L27;
        r5 = r12.j();
        goto L27
    L23:
        r6 = null;
    L27:
        String r7 = r5;
        if (r0 == null) goto L30;
        Image r8 = r0.a;
    L31:
        String r9 = i2.d(r8);
        if (r9 != null) goto L39;
        if (r0 == null) goto L35;
        Image r10 = r0.c;
    L36:
        r9 = i2.d(r10);
        if (r9 != null) goto L39;
        r9 = r12.h();
        goto L39
    L35:
        r10 = null;
    L39:
        String r11 = r9;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        ImageInfo r14 = i2.a(r12, r13);
        if (r14 == null) goto L42;
        Image r15 = r14.i;
    L43:
        String r16 = i2.d(r15);
        if (r0 == null) goto L48;
        Image r17 = r0.d;
        if (r17 == null) goto L48;
        String r18 = r17.a;
    L49:
        if (r3 == null) goto L51;
        long r19 = r3.c;
    L53:
        Long r20 = Long.valueOf(r19);
    L55:
        if (r3 == null) goto L57;
        long r110 = r3.d;
    L59:
        r1 = Long.valueOf(r110);
    L61:
        return new com.larus.bmhome.bigimg.n1(r7, r11, r16, r18, r20, r1);
    L57:
        if (r2 == null) goto L61;
        r110 = r2.d;
        goto L59
    L51:
        if (r2 == null) goto L54;
        r19 = r2.c;
        goto L53
    L54:
        r20 = null;
    L48:
        r18 = null;
        goto L49
    L42:
        r15 = null;
        goto L43
    L30:
        r8 = null;
        goto L31
    L18:
        r4 = null;
    L12:
        if (r0 == null) goto L14;
        r3 = r0.c;
        goto L16
    L14:
        r3 = null;
    L6:
        if (r0 == null) goto L8;
        r2 = r0.a;
        goto L9
    L8:
        r2 = null;
        goto L9
    }
}
