package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.tool;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.ContainerContextEnv;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.ListActionEnum;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.ComponentConfigManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements zo1.g<s> {
    public final ContainerContextEnv a;

    public c(ContainerContextEnv r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        this.a = r2;
    }

    public final void a(s r3, boolean r4) {
        if (g.a.contains(Integer.valueOf(r3.a)) == true) goto L5;
        return;
    L5:
        ComponentConfigManager r0 = this.a.a;
        if (r0 == null) goto L11;
        a0 r5 = r0.getToolbarConfig(r3.a);
        if (r5 == null) goto L12;
        r5.n(r4);
        return;
    L12:
        return;
    }

    @Override // zo1.g
    public final void e(s r2, ListActionEnum r3) {
        s r4 = r2;
        Intrinsics.checkNotNullParameter(r4, "data");
        Intrinsics.checkNotNullParameter(r3, "action");
        int r5 = b.a[r3.ordinal()];
        if (r5 != 1) goto L5;
        a(r4, true);
        return;
    L5:
        if (r5 != 2) goto L11;
        a(r4, false);
        return;
    }
}
