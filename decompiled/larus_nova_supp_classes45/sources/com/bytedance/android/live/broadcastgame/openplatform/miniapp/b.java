package com.bytedance.android.live.broadcastgame.openplatform.miniapp;

import android.content.Context;
import com.bytedance.ies.web.jsbridge2.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements io0.b {
    public final t10.a a;

    public b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = new t10.a(r2);
    }

    public final void f(String r3) {
        Intrinsics.checkNotNullParameter(r3, "name");
        t10.a r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "name");
        if (r1.b.f == true) goto L6;
        r1.b.g(r3);
        return;
    }

    public final void registerMethod(String r4, f.b r5) {
        Intrinsics.checkNotNullParameter(r4, "name");
        Intrinsics.checkNotNullParameter(r5, "provider");
        t10.a r2 = this.a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "name");
        Intrinsics.checkNotNullParameter(r5, "provider");
        if (r2.b.f == true) goto L6;
        r2.b.c(r4, r5);
        return;
    }
}
