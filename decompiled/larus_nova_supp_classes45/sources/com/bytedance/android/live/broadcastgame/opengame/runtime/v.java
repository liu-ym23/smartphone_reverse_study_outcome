package com.bytedance.android.live.broadcastgame.opengame.runtime;

import androidx.collection.LruCache;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformMiniAppDebugger;
import com.bytedance.android.live.broadcastgame.opengame.panel.PanelType;
import com.bytedance.bdp.live.livecontainer.base.schema.LiveSchemaInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class v implements k, s<p> {
    public final LaunchMode a;
    public com.bytedance.android.live.broadcastgame.opengame.openapi.y b;
    public final boolean c;
    public boolean d;
    public long e;
    public long f;
    public final PluginContext g;
    public final /* synthetic */ i20.a h;
    public final /* synthetic */ t<p> i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.s
    public final List<p> getListeners() {
        return this.i.a;
    }

    public final p k() {
        return this.i.b;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.k
    public void onHide() {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("LiveBasePlugin", new Object[]{"on lifecycle: onHide"});
        this.e += System.currentTimeMillis() - this.f;
        p r1 = k();
        if (r1 == null) goto L6;
        r1.hide();
        return;
    }

    public v(PluginContext r4) {
        Intrinsics.checkNotNullParameter(r4, "pluginContext");
        this.h = new i20.a();
        t<p> r0 = new t();
        this.i = r0;
        this.g = r4;
        com.bytedance.android.live.broadcastgame.opengame.t r1 = r4.m;
        if (com.bytedance.android.live.broadcastgame.api.openplatform.k.a(r1.n) == true) goto L15;
        int r2 = OpenPlatformMiniAppDebugger.h;
        if (OpenPlatformMiniAppDebugger.Companion.b(r1.n) == true) goto L15;
        String r3 = r1.n;
        Intrinsics.checkNotNullParameter(r3, "$this$isPreviewVersion");
        LruCache r5 = LiveSchemaInfo.r;
        LiveSchemaInfo r6 = LiveSchemaInfo.c.a(r3);
        if (r6 == null) goto L10;
        String r7 = (String) r6.d.getValue();
    L12:
        if (Intrinsics.areEqual(r7, "preview") == false) goto L14;
        LaunchMode r8 = LaunchMode.FROM_PREVIEW;
    L16:
        this.a = r8;
        this.c = r4.o;
        PanelType r9 = PanelType.PANEL_TYPE_X_SCREEN_LOW;
        u.a(this, p.class);
        Intrinsics.checkNotNullParameter(r4, "listener");
        r0.registerListener(r4);
        Intrinsics.checkNotNullParameter(this, "plugin");
        r4.a = this;
        return;
    L14:
        r8 = LaunchMode.FROM_PANEL;
        goto L16
    L10:
        r7 = null;
    L15:
        r8 = LaunchMode.FROM_DEBUG;
        goto L16
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, com.bytedance.android.live.broadcastgame.opengame.runtime.p, java.lang.Object] */
    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.s
    public final void C(p r2) {
        p r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "delegate");
        this.i.b = r3;
    }

    public final void l(String r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        this.g.k.j(r2);
    }
}
