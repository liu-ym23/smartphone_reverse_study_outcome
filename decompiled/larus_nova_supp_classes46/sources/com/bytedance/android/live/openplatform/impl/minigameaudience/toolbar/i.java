package com.bytedance.android.live.openplatform.impl.minigameaudience.toolbar;

import android.view.View;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.livesdk.config.setting.NewBroadcastSharedConfig;
import com.bytedance.android.scope.m;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ ToolbarOpenPlatformMiniGameBehavior a;
    public final /* synthetic */ View b;

    public i(ToolbarOpenPlatformMiniGameBehavior r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Long r5 = (Long) r4;
        if (NewBroadcastSharedConfig.a().booleanValue() == false) goto L9;
        f00.a.a r6 = f00.a.b;
        g00.c r7 = (g00.c) m.e.d(r6, g00.c.class);
        if (r7 == null) goto L11;
        nz.h r8 = r7.getBroadcastBubbleManager();
        if (r8 == null) goto L12;
        r8.b(this.a.getContext(), this.b, String.valueOf(9));
        return;
    L12:
        return;
    L11:
        return;
    L9:
        LivePluginSPIManager.e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new h(this)).callbackOnMainThread();
    }
}
