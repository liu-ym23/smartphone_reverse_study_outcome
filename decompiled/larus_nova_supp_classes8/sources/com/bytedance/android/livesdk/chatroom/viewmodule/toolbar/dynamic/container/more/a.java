package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.more;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.ListActionEnum;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import zo1.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends zo1.a {
    public a() {
        i r0 = new i(new ArrayList(), new ArrayList());
        Intrinsics.checkNotNullParameter("showing", "key");
        Intrinsics.checkNotNullParameter(r0, "list");
        this.a.put("showing", r0);
    }

    @Override // zo1.f
    public final boolean f(s r3) {
        s r4 = r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        i r0 = n();
        if (r0 != null) goto L5;
        return false;
    L5:
        r0.b(r4, ListActionEnum.ADD);
        o("add " + r4);
        return true;
    }

    @Override // zo1.f
    public final boolean i(s r4) {
        s r5 = r4;
        Intrinsics.checkNotNullParameter(r5, "data");
        i r0 = n();
        if (r0 != null) goto L5;
        return false;
    L5:
        o("remove " + r5);
        return r0.b(r5, ListActionEnum.REMOVE);
    }

    @Override // zo1.f
    public final boolean m(s r4) {
        s r5 = r4;
        Intrinsics.checkNotNullParameter(r5, "data");
        i r0 = n();
        if (r0 != null) goto L5;
        return false;
    L5:
        o("update " + r5);
        return r0.b(r5, ListActionEnum.UPDATE);
    }

    public final void o(String r4) {
        ALogger.i(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.a(), "data " + r4);
    }
}
