package com.ss.android.lark.feed.molten.serializer;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Object a(Class r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "enumClass");
        Object r6 = r4.getMethod("fromValue", new Class[]{Integer.TYPE}).invoke(null, new Object[]{Integer.valueOf(r5)});
        if (r6 != null) goto L6;
        return null;
    L6:
        return r6;
    }
}
