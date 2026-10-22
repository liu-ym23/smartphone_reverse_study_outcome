package com.ss.android.lark.mention.base.impl.atselector.bean;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final String a(BaseAtBean r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof WantAtMemBean) == false) goto L6;
        String r2 = ((WantAtMemBean) r1).chatterInfo.l;
    L8:
        Intrinsics.checkNotNull(r2);
        Character r3 = StringsKt.firstOrNull(r2);
        if (r3 == null) goto L12;
        String r4 = r3.toString();
        if (r4 == null) goto L12;
        return r4;
    L12:
        return "";
    L6:
        if ((r1 instanceof SearchBean) == false) goto L12;
        r2 = ((SearchBean) r1).chatterInfo.l;
        goto L8
    }
}
