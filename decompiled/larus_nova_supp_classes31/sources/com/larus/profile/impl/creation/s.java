package com.larus.profile.impl.creation;

import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.CustomInputInitData;
import com.larus.platform.api.creation.TplDetail;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.model.creation.DoSameQuickMenuType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class s {
    public static CustomInputInitData a(UserCreation r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r0 = r5.b;
        Integer r2 = null;
        if (r0 == 2) goto L7;
        if (r0 == 5) goto L7;
        return null;
    L7:
        if (r5.b() == true) goto L9;
        return null;
    L9:
        if (Intrinsics.areEqual(null, DoSameQuickMenuType.REPLACE_PIC) == false) goto L14;
        TplDetail r1 = is9.a.c(r5);
        if (r1 == null) goto L21;
        String r3 = r1.i;
    L22:
        if (r3 == null) goto L35;
        CreationDynamicInfo r4 = r5.h;
        int r6 = 0;
        if (r4 == null) goto L28;
        Integer r7 = r4.a;
        if (r7 == null) goto L28;
        int r8 = r7.intValue();
    L29:
        CreationDynamicInfo r9 = r5.h;
        if (r9 == null) goto L34;
        Integer r10 = r9.b;
        if (r10 == null) goto L34;
        r6 = r10.intValue();
    L34:
        String r11 = r3.substring(r8, r6);
    L36:
        CreationDynamicInfo r12 = r5.h;
        if (r12 == null) goto L39;
        Integer r13 = r12.a;
    L40:
        if (r12 == null) goto L43;
        r2 = r12.b;
    L43:
        return new CustomInputInitData(r13, r2, r11);
    L39:
        r13 = null;
    L28:
        r8 = 0;
        goto L29
    L35:
        r11 = null;
    L21:
        r3 = null;
        goto L22
    L14:
        if (Intrinsics.areEqual(null, DoSameQuickMenuType.USE_PICTURE) == true) goto L21;
        UserCreationContent r14 = r5.e;
        if (r14 == null) goto L21;
        UserCreationImage r15 = r14.a;
        if (r15 == null) goto L21;
        r3 = r15.c;
        goto L22
    }
}
