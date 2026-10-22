package com.ss.android.lark.chat.utils;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static /* synthetic */ float[] b(v5b.c r2) {
        return a(r2, 10.0f, 2.0f);
    }

    @JvmStatic
    public static final boolean c(v5b.c<?> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof y6b.c) == true) goto L5;
    L7:
        return false;
    L5:
        if (((y6b.c) r1).k1 == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final float[] a(v5b.c<?> r7, float r8, float r9) {
        Intrinsics.checkNotNullParameter(r7, "messageVO");
        int r0 = r7.getGroupType();
        if (r0 == 1) goto L6;
        if (r0 == 2) goto L6;
        float r3 = r8;
    L7:
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L10;
    L11:
        float[] r4 = new float[4];
        int r6 = 0;
    L12:
        if (r6 >= 4) goto L15;
        r4[r6] = r8;
        r6 = r6 + 1;
        goto L12
    L15:
        if (c(r7) == false) goto L17;
        r4[2] = r9;
        r4[3] = r3;
    L18:
        return r4;
    L17:
        r4[0] = r9;
        r4[1] = r3;
    L10:
        r9 = r8;
    L6:
        r3 = r9;
        goto L7
    }
}
