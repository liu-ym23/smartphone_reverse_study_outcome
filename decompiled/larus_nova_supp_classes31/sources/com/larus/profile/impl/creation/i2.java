package com.larus.profile.impl.creation;

import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.AiBeautifyUserContent;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.api.creation.UserCreationUserAvatar;
import com.larus.platform.api.creation.VideoInfo;
import com.larus.platform.api.creation.VideoUserContent;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i2 {
    public static final ImageInfo c(UserCreation r3) {
        int r0 = r3.b;
        if (r0 != 3) goto L5;
        UserCreationContent r4 = r3.e;
        if (r4 == null) goto L28;
        UserCreationUserAvatar r5 = r4.c;
        if (r5 != null) goto L21;
        return null;
    L21:
        return r5.a;
    L28:
        return null;
    L5:
        if (r0 == 4) goto L11;
        UserCreationContent r6 = r3.e;
        if (r6 == null) goto L22;
        UserCreationImage r7 = r6.a;
        if (r7 != null) goto L24;
        return null;
    L24:
        return r7.a;
    L22:
        return null;
    L11:
        UserCreationContent r8 = r3.e;
        if (r8 == null) goto L25;
        AiBeautifyUserContent r9 = r8.d;
        if (r9 != null) goto L27;
        return null;
    L27:
        return r9.a;
    L25:
        return null;
    }

    public static final String d(Image r3) {
        if (r3 == null) goto L13;
        String r1 = r3.a;
        if (r1 == null) goto L13;
        if ((!StringsKt.isBlank(r1)) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L13;
        return r1;
    L13:
        if (r3 == null) goto L21;
        String r4 = r3.b;
        if (r4 != null) goto L17;
        return null;
    L17:
        if ((!StringsKt.isBlank(r4)) == true) goto L19;
        return null;
    L19:
        return r4;
    L21:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final ImageInfo a(UserCreation r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ImageInfo r4 = c(r2);
        if (r3 == false) goto L12;
        CreationNoWatermarkManager r5 = CreationNoWatermarkManager.a;
        if (r5.D() == false) goto L13;
        ImageInfo r6 = (ImageInfo) r5.U(CreationNoWatermarkManager.t0(r4), r4, true).a;
        if (r6 != null) goto L11;
        return r4;
    L11:
        return r6;
    L13:
        return r4;
    L12:
        return r4;
    }

    public static final nr9.g b(UserCreation r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        UserCreationContent r5 = r3.e;
        String r0 = null;
        if (r5 == null) goto L20;
        VideoUserContent r6 = r5.e;
        if (r6 == null) goto L20;
        nr9.g r1 = os8.c.d(r6);
        if (r4 == false) goto L21;
        CreationNoWatermarkManager r7 = CreationNoWatermarkManager.a;
        if (r7.D() == false) goto L22;
        nr9.g r2 = os8.c.c(r6);
        VideoInfo r8 = r6.a;
        if (r8 == null) goto L15;
        r0 = r8.a;
    L15:
        nr9.g r9 = r7.c0(r0, r2, CreationNoWatermarkManager.u0(r6.b));
        if (r9 != null) goto L19;
        return r2;
    L19:
        return r9;
    L22:
        return r1;
    L21:
        return r1;
    L20:
        return null;
    }
}
