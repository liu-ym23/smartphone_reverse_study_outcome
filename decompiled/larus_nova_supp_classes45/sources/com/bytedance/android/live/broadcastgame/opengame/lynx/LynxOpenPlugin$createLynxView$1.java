package com.bytedance.android.live.broadcastgame.opengame.lynx;

import android.view.View;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.browser.d0;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.lynx.tasm.LynxView;
import kotlin.jvm.internal.Intrinsics;
import x7a.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LynxOpenPlugin$createLynxView$1 extends d0 {
    public final /* synthetic */ LynxOpenPlugin a;
    public final /* synthetic */ j b;
    public final /* synthetic */ com.bytedance.android.live.lynx.api.d c;

    @Override // com.bytedance.android.live.browser.d0
    public final void b(LynxView r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        int r3 = q.a;
        q.g("子 lynxview on first screen", "");
        com.bytedance.android.live.broadcastgame.opengame.panel.h r4 = this.a.z;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isShowing() != true) goto L9;
        this.a.B();
        return;
    }

    @Override // com.bytedance.android.live.browser.d0
    public final void d(final View r8) {
        Intrinsics.checkNotNullParameter(r8, "lynxView");
        Intrinsics.checkNotNullParameter(r8, "lynxView");
        UtilityKotlinExtentionsKt.s(0, false, false, new LynxOpenPlugin$createLynxView$1$onLoadSuccess$1(this, r8), 7);
    }

    @Override // com.bytedance.android.live.browser.d0
    public final void c(LynxView r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "lynxView");
        Intrinsics.checkNotNullParameter(r7, "lynxView");
        f2.c("跳转失败：资源加载失败！", 0);
        UtilityKotlinExtentionsKt.s(0, false, false, new LynxOpenPlugin$createLynxView$1$onLoadFailed$1(this), 7);
    }

    public LynxOpenPlugin$createLynxView$1(LynxOpenPlugin r1, x7a.c r2, com.bytedance.android.live.lynx.api.d r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
