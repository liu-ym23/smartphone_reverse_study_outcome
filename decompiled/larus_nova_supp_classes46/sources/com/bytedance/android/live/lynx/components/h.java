package com.bytedance.android.live.lynx.components;

import android.widget.FrameLayout;
import com.bytedance.android.live.browser.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements com.bytedance.ies.web.jsbridge2.f.b {
    public final /* synthetic */ FrameLayout a;
    public final /* synthetic */ LiveLynxFragment b;
    public final /* synthetic */ com.bytedance.android.live.lynx.api.c c;

    public h(FrameLayout r1, LiveLynxFragment r2, com.bytedance.android.live.lynx.api.c r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        vl0.b r0 = this.b.D;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("serviceHolder");
    L5:
        v r1 = r0.b;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L9:
        return r1.provideClipMethod(this.a);
    }
}
