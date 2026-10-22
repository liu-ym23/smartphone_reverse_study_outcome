package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r implements Function1<ExtendedToolbarButton, c0.b> {
    public final Class<? extends c0.b> a;

    public r(Class<? extends c0.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        this.a = r2;
    }

    public final Object invoke(Object r2) {
        Intrinsics.checkNotNullParameter((ExtendedToolbarButton) r2, "p1");
        return this.a.newInstance();
    }
}
