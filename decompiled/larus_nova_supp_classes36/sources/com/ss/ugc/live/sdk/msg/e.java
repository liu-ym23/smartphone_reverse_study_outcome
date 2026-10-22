package com.ss.ugc.live.sdk.msg;

import com.ss.ugc.live.sdk.msg.dispatch.Dispatcher;
import hm2.h;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e extends d implements vlc.a {
    @Override // vlc.a
    public final void b(boolean r4) {
        if (r4 == true) goto L5;
        Dispatcher r5 = this.l;
        com.ss.ugc.live.sdk.msg.utils.a.c(r5.z, "start dispatch");
        r5.t.obtainMessage(204).sendToTarget();
        return;
    L5:
        if (isRunning() == false) goto L7;
        Dispatcher r6 = this.l;
        com.ss.ugc.live.sdk.msg.utils.a.c(r6.z, "start dispatch");
        r6.t.obtainMessage(204).sendToTarget();
        return;
    L7:
        this.l.v = true;
    }

    @Override // vlc.a
    public final void f(boolean r4) {
        if (r4 == true) goto L5;
        Dispatcher r5 = this.l;
        com.ss.ugc.live.sdk.msg.utils.a.c(r5.z, "stop dispatch");
        r5.t.obtainMessage(205).sendToTarget();
        return;
    L5:
        if (isRunning() == false) goto L7;
        Dispatcher r6 = this.l;
        com.ss.ugc.live.sdk.msg.utils.a.c(r6.z, "stop dispatch");
        r6.t.obtainMessage(205).sendToTarget();
        return;
    L7:
        this.l.v = false;
    }

    @Override // vlc.a
    public final void x(int r2) {
        this.l.w = r2;
    }

    public e(h r2, List r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "plugins");
        super(r2, r3);
        this.l.v = false;
    }
}
