package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e {
    public final Function1<SceneType, j70.h<? extends h70.b>> a;

    /* JADX WARN: Multi-variable type inference failed */
    public e(Function1<? super SceneType, ? extends j70.h<? extends h70.b>> r2, FunctionType r3) {
        Intrinsics.checkNotNullParameter(r2, "creator");
        Intrinsics.checkNotNullParameter(r3, "functionType");
        this.a = r2;
    }
}
