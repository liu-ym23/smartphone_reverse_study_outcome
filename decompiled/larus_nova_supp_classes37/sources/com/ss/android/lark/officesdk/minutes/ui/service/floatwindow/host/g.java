package com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.host;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g implements ComponentCallbacks {
    public final /* synthetic */ e a;
    public final /* synthetic */ hwb.c b;

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r6) {
        Intrinsics.checkNotNullParameter(r6, "newConfig");
        int r0 = r6.uiMode & 48;
        e r1 = this.a;
        if (r0 != r1.m) goto L5;
        return;
    L5:
        r1.m = r0;
        int r2 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FLOAT, "onConfigurationChanged", "nightModeMask=" + r0 + ", recordingId=" + this.b.a, null, 8);
        this.a.g(this.b, r6);
    }

    public g(e r1, hwb.c r2) {
        this.a = r1;
        this.b = r2;
    }
}
