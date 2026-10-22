package com.bytedance.android.livesdk.chatroom.utils;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b4 {
    public static final void a(Object r1, Function0 r2) {
        Intrinsics.checkNotNullParameter(r2, "actionWhenNull");
        if (r1 != null) goto L6;
        r2.invoke();
        return;
    }
}
