package com.bytedance.ai.applet.base.log;

import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h {
    public static final String a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Map r0 = f.a();
        if (r0.isEmpty() == false) goto L6;
        return r10;
    L6:
        return "[" + CollectionsKt.joinToString$default(r0.entrySet(), " ", null, null, 0, null, new g(), 30, null) + "] " + r10;
    }
}
