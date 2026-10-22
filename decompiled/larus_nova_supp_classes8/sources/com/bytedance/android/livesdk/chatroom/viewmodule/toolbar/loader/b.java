package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static final void a(Boolean r1, Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "function");
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L6;
        r2.invoke();
        return;
    }
}
