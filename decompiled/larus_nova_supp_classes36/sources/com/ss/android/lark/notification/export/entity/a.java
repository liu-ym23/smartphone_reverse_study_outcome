package com.ss.android.lark.notification.export.entity;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final boolean a(Notice r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.extra.d != Notice.Extra.ChatMode.THREAD_V2) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L14;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.extra.k >= 0) goto L14;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (Intrinsics.areEqual(r5.extra.r, Boolean.TRUE) == true) goto L14;
        if (r5.extra.l < 0) goto L14;
        return true;
    L14:
        return false;
    L5:
        r1 = false;
        goto L6
    }
}
