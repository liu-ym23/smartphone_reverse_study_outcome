package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.LinkmicOnlineFloatWindowManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i0 implements ii6.a {
    public final /* synthetic */ RtcManager a;
    public final /* synthetic */ ii6.a b;

    public i0(RtcManager r1, LinkmicOnlineFloatWindowManager r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void H(ei6.a r8, int r9, long r10, Exception r12) {
        this.b.H(r8, r9, r10, r12);
        this.a.H(r8, r9, r10, r12);
    }

    public final void M(ei6.a r8, int r9, long r10, Object... r12) {
        Intrinsics.checkNotNullParameter(r12, "params");
        this.b.M(r8, r9, r10, new Object[]{r12});
    }
}
