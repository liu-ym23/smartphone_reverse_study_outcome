package com.larus.bmhome.music.protocol;

import com.larus.im.bean.message.ImageObj;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.UserCreationMusic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h {
    public static final f a(UserCreationMusic r30, String r31) {
        Intrinsics.checkNotNullParameter(r30, "<this>");
        String r3 = r30.a;
        String r4 = r30.b;
        String r5 = r30.c;
        ImageInfo r2 = r30.d;
        if (r2 == null) goto L5;
        String r14 = r2.e;
    L7:
        if (r2 == null) goto L11;
        Image r6 = r2.b;
        if (r6 == null) goto L11;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        ImageObj r16 = new ImageObj(r6.a, (int) r6.c, (int) r6.d, null, null, 24, null);
    L12:
        ImageInfo r7 = r30.d;
        if (r7 == null) goto L17;
        Image r8 = r7.a;
        if (r8 == null) goto L17;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        ImageObj r17 = new ImageObj(r8.a, (int) r8.c, (int) r8.d, null, null, 24, null);
    L18:
        com.larus.im.bean.message.Image r9 = new com.larus.im.bean.message.Image(r14, null, r16, r17, null, null, null, null, null, null, null, null, null, null, 16370, null);
        String r10 = r30.e;
        String r11 = r30.f;
        String r12 = r30.h;
        String r13 = r30.g;
        if (r31 != null) goto L21;
        String r15 = "";
    L23:
        return new f(r3, r4, r5, r9, r10, r11, r12, r13, r15);
    L21:
        r15 = r31;
    L17:
        r17 = null;
    L11:
        r16 = null;
        goto L12
    L5:
        r14 = null;
        goto L7
    }
}
