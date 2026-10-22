package com.bytedance.android.livesdk.chatroom.vs_base.player;

import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.IReplayInnerProgressService;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Lazy;
import mq1.p;
import mq1.r;
import mq1.s;
import mq1.t;
import mq1.u;
import mq1.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ReplayPlayerServiceImpl implements t, o {
    public final Lazy a;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public ReplayPlayerServiceImpl() {
        this.a = com.bytedance.android.livesdk.chatroom.vs_base.base.a.a(ReplayPlayerServiceImpl$playerControlBrickService$2.INSTANCE);
        this.b = com.bytedance.android.livesdk.chatroom.vs_base.base.a.a(ReplayPlayerServiceImpl$playerBrickService$2.INSTANCE);
    }

    @Override // mq1.t
    public final p a(DataCenter r2) {
        s r0 = (s) this.a.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(r2);
    }

    @Override // mq1.t
    public final u provideVSPlayerTipService(DataCenter r2) {
        s r0 = (s) this.a.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.provideVSPlayerTipService(r2);
    }

    @Override // mq1.t
    public final v provideVSPlayerViewControlService(DataCenter r2) {
        s r0 = (s) this.a.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.provideVSPlayerViewControlService(r2);
    }

    @Override // mq1.t
    public final IReplayInnerProgressService provideVSProgressService(DataCenter r2) {
        r r0 = (r) this.b.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(r2);
    }

    @Override // mq1.t
    public final void releaseService(DataCenter r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        r r0 = (r) this.b.getValue();
        if (r0 == null) goto L7;
        r0.releaseService(r2);
    L7:
        s r1 = (s) this.a.getValue();
        if (r1 == null) goto L11;
        r1.releaseService(r2);
        return;
    }
}
