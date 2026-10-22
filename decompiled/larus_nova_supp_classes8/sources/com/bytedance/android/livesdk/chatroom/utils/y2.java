package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdkapi.room.handler.toolbar.ResKeyEnum;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y2 {
    public static final x2 b(ResKeyEnum r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$none");
        return new x2(r2, null);
    }

    public static final x2 a(ResKeyEnum r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$defaultV");
        if (r3 == null) goto L7;
        return new x2(r2, new v2(r3));
    L7:
        return new x2(r2, null);
    }
}
