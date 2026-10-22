package com.larus.avlink.plugins;

import com.larus.audio.call.plugins.CommonCallTimingPlugin;
import com.larus.avlink.api.model.DoraEvent;
import com.larus.common.apphost.AppHost;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class y3 extends CommonCallTimingPlugin<n4> {
    public final String u;

    public final void j3() {
        if (AppHost.a.isDebug() == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException("DoraTimingPlugin finishCall not implemented");
    }

    public final void onComplete() {
        if (v88.a.f(Integer.valueOf(((n4) getContext()).q())) == false) goto L13;
        n3 r0 = (n3) getContext().c(Reflection.getOrCreateKotlinClass(n3.class), null);
        if (r0 == null) goto L9;
        boolean r1 = true;
        if (r0.K() != true) goto L9;
    L10:
        if (r1 == true) goto L12;
        super.onComplete();
        return;
    L12:
        Lazy r2 = ia8.m.a;
        ia8.m.b(DoraEvent.Cancel_Radio_Data_End);
        return;
    L9:
        r1 = false;
        goto L10
    L13:
        super.onComplete();
    }

    public final String T2() {
        return this.u;
    }

    public y3(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.u = "DoraTimingPlugin";
    }

    public final void k3(long r1) {
        if (AppHost.a.isDebug() == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException("DoraTimingPlugin onFinishCallCountDown not implemented");
    }
}
