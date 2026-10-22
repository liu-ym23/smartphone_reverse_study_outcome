package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarShakeMatchBehavior;
import com.bytedance.android.livesdk.config.a60;
import java.util.ArrayList;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/ShakeMatchLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShakeMatchLoader extends AbsDynamicLoader {
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        ArrayList r0 = new ArrayList();
        ExtendedToolbarButton.b r2 = null;
        if (this.c == false) goto L5;
    L30:
        if (r2 == null) goto L32;
        r0.add(r2);
    L32:
        return r0;
    L5:
        if (this.d == false) goto L30;
        if (a60.a.getValue().booleanValue() == false) goto L30;
        if (k.f(IInteractService.class) == null) goto L23;
        int r1 = k.n(IInteractService.class).getCurrentScene();
        if (r1 != 8) goto L15;
    L24:
        boolean r3 = true;
    L25:
        if (r3 == false) goto L30;
        if (o.o(null) == true) goto L30;
        ExtendedToolbarButton.a r4 = ExtendedToolbarButton.h;
        ToolbarButton r5 = ToolbarButton.SHAKE_MATCH_SETTING;
        r4.getClass();
        r2 = ExtendedToolbarButton.a.a(r5);
        goto L30
    L15:
        if (r1 == 12) goto L24;
        if (r1 == 16) goto L24;
        if (r1 == 9) goto L24;
        if (r1 == 5) goto L24;
    L23:
        r3 = false;
        goto L25
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
        y3.f(this.a).k(ToolbarButton.SHAKE_MATCH_SETTING, new ToolbarShakeMatchBehavior());
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onUnLoad() {
        super.onUnLoad();
    }

    public ShakeMatchLoader(e r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        super(r2);
    }
}
