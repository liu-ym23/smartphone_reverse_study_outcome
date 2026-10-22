package com.bytedance.android.live.browser;

import com.lynx.tasm.LynxViewBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements d8.f {
    public final /* synthetic */ w a;

    public g(w r1) {
        this.a = r1;
    }

    public final void b(LynxViewBuilder r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        this.a.setEnableJSRuntime(r3, false);
    }

    public final void a(LynxViewBuilder r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        this.a.setEnableUserCodeCache(r3, true, r4);
    }
}
