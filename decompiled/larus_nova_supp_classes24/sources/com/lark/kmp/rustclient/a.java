package com.lark.kmp.rustclient;

import com.lark.kmp.logger.LarkLogger;
import com.lark.kmp.rustclient.api.model.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static void a(c r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "message");
        Intrinsics.checkNotNullParameter("RustClient", "tag");
        StringBuilder r0 = new StringBuilder("[rust_client]");
        if (r5.d == null) goto L5;
        r0.append("[server_command:" + r5.d.getValue() + ']');
    L6:
        r0.append("[context_id:" + r5.b + ']');
        r0.append(r6);
        LarkLogger r7 = LarkLogger.a;
        LarkLogger.c("RustClient", r0.toString());
        return;
    L5:
        r0.append("[command:" + r5.a().getValue() + ']');
        goto L6
    }
}
