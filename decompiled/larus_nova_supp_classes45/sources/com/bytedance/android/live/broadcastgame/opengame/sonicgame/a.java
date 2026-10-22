package com.bytedance.android.live.broadcastgame.opengame.sonicgame;

import android.graphics.Bitmap;
import android.os.Handler;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.broadcastgame.opengame.panel.PanelType;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.service.SimplePanelStateDispatchService;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.bdp.serviceapi.hostimpl.hostmethod.BdpInteractHostMethodService;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements f, SimplePanelStateDispatchService.b {
    public final Handler a;
    public final b b;
    public final PluginContext c;
    public final na4.c<?, ?> d;

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.sonicgame.a$a, reason: collision with other inner class name */
    public static final class C0086a {
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.service.SimplePanelStateDispatchService.b
    public final void r0() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.service.SimplePanelStateDispatchService.b
    public final void t0() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.service.SimplePanelStateDispatchService.b
    public final void v() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.service.SimplePanelStateDispatchService.b
    public final void s0() {
        this.c.m.getClass();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.sonicgame.f
    public final void b(boolean r4) {
        int r0 = q.a;
        q.f("GameCastAbility", new Object[]{"start to stop single game cast"});
        if (r4 == false) goto L5;
        ((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).stopCastWithDialog(this.c.getContext(), "more_panel");
        return;
    L5:
        IMiddlewareBroadcastService.b.b((IMiddlewareBroadcastService) va1.b.a.a.a(IBroadcastService.class));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.sonicgame.f
    public final void g(final boolean r6) {
        int r0 = q.a;
        q.f("GameCastAbility", new Object[]{"start single game cast"});
        this.c.m.getClass();
        PluginContext r1 = this.c;
        if (r1.m.f == true) goto L5;
    L7:
        boolean r4 = false;
    L9:
        if (r1.h(r4) == GameCastStrategy.VIDEO_SINGLE) goto L12;
        q.k("GameCastAbility", new Object[]{"game cast is not supported"});
        return;
    L12:
        final long r2 = System.currentTimeMillis();
        final PanelType r3 = this.c.j();
        if (r3 != null) goto L15;
        r3 = PanelType.PANEL_TYPE_X_SCREEN;
    L15:
        BdpInteractHostMethodService r5 = com.bytedance.bdp.live.livecontainer.sonicgame.f.a;
        String r7 = this.c.m.i;
        r3.getWidth();
        r3.getHeight();
        new GameCastAbility$doStartSingleGameCast$1(this, r2, r6);
        Function1<Throwable, Unit> r8 = new GameCastAbility$doStartSingleGameCast$2(this, r3, r6);
        BdpInteractHostMethodService r9 = com.bytedance.bdp.live.livecontainer.sonicgame.f.a;
        if (r9 != null) goto L18;
        r8.invoke(new IllegalStateException("BdpInteractHostMethodService is null"));
        return;
    L18:
        r9.p();
        return;
    L5:
        if (r1.s() == false) goto L7;
        r4 = true;
        goto L9
    }

    public a(PluginContext r2, na4.c r3, SonicGamePlugin.c r4) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.c = r2;
        this.d = r3;
        this.a = i0.c();
        this.b = new b(this);
        SimplePanelStateDispatchService r5 = (SimplePanelStateDispatchService) r2.o(SimplePanelStateDispatchService.class);
        Intrinsics.checkNotNullParameter(this, "listener");
        ((ArrayList) r5.a).add(this);
    }

    public static final void a(a r2, boolean r3, Bitmap r4) {
        r2.getClass();
        System.currentTimeMillis();
        PanelType r5 = r2.c.j();
        if (r5 != null) goto L5;
        r5 = PanelType.PANEL_TYPE_X_SCREEN;
    L5:
        r2.a.post(new c(r2, r4, r5));
    }
}
