package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n implements f70.a {
    public final com.bytedance.android.livesdk.chatroom.ui.framework.d a;

    public n(InteractionComponentManager r1) {
        this.a = ho1.a.i(r1.getContext().d);
    }

    public final ViewGroup a(f70.b r2) {
        Intrinsics.checkNotNullParameter(r2, "layerType");
        com.bytedance.android.livesdk.chatroom.ui.framework.d r0 = this.a;
        if (r0 == null) goto L8;
        ViewGroup r3 = r0.zb(r2);
        if (r3 == null) goto L8;
        return r3;
    L8:
        throw new RuntimeException("masterView is null!!!");
    }
}
