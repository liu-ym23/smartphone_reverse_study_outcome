package com.ss.ugc.live.sdk.msg.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final boolean b(tlc.d r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isWRDS");
        if ((r1 instanceof xlc.b) == true) goto L5;
    L7:
        return false;
    L5:
        if (((xlc.b) r1).isWRDSMessage() == false) goto L7;
        return true;
    }

    public static final void a(vlc.c r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$debug");
        Intrinsics.checkNotNullParameter(r2, "msg");
        if (r1.a() == false) goto L6;
        r1.log("MessageManagerV2", r2);
        return;
    }

    public static final void c(vlc.c r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$trace");
        Intrinsics.checkNotNullParameter(r2, "msg");
        r1.log("MessageManagerV2", r2);
    }
}
