package com.ss.android.lark.keyboard;

import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import cya.c;
import cya.d;
import cya.h;
import cya.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final d a(b r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        c r3 = r2.L();
        if ((r3 instanceof c) == false) goto L5;
        c r4 = r3;
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        return r4.a();
    L5:
        r4 = null;
        goto L6
    }

    public static final String b(b r4) {
        if (r4 != null) goto L5;
        return "";
    L5:
        d r5 = a(r4);
        if (r5 == null) goto L8;
        h r6 = r5.d();
    L9:
        boolean r1 = false;
        if (r6 != null) goto L12;
    L14:
        if (r1 == false) goto L22;
        i r7 = (i) r6.a.a(i.h);
        if (r7 == null) goto L23;
        String r8 = r7.a;
        if (r8 != null) goto L21;
        return "";
    L21:
        return r8;
    L23:
        return "";
    L22:
        return "";
    L12:
        if (r6.a() != 2) goto L14;
        r1 = true;
        goto L14
    L8:
        r6 = null;
        goto L9
    }

    public static final PartialReplyInfo c(b r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        d r5 = a(r4);
        if (r5 == null) goto L8;
        h r6 = r5.d();
    L9:
        boolean r1 = false;
        if (r6 != null) goto L12;
    L14:
        if (r1 == false) goto L19;
        i r7 = (i) r6.a.a(i.h);
        if (r7 != null) goto L18;
        return null;
    L18:
        return r7.g;
    L19:
        return null;
    L12:
        if (r6.a() != 2) goto L14;
        r1 = true;
        goto L14
    L8:
        r6 = null;
        goto L9
    }

    public static final String d(b r4) {
        if (r4 != null) goto L5;
        return "";
    L5:
        d r5 = a(r4);
        if (r5 == null) goto L8;
        h r6 = r5.d();
    L9:
        boolean r1 = false;
        if (r6 != null) goto L12;
    L14:
        if (r1 == false) goto L22;
        i r7 = (i) r6.a.a(i.h);
        if (r7 == null) goto L23;
        String r8 = r7.b;
        if (r8 != null) goto L21;
        return "";
    L21:
        return r8;
    L23:
        return "";
    L22:
        return "";
    L12:
        if (r6.a() != 2) goto L14;
        r1 = true;
        goto L14
    L8:
        r6 = null;
        goto L9
    }
}
