package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.d2;
import com.bytedance.android.livesdk.interactivity.api.settings.config.v0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AnchorChannelLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorChannelLoader extends AbsDynamicLoader {
    public final d2 h;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        ArrayList r0 = new ArrayList();
        MiddlewareRoomContext r1 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, this.a, 0, 2);
        if (r1 == null) goto L7;
        v0 r2 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.c.a;
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.c.a(this.a, r1) == false) goto L7;
        r0.add(ToolbarButton.ANCHOR_CHAT_CHANNEL);
    L7:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
        if (MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, this.a, 0, 2) == null) goto L6;
        y3.f(this.a).k(ToolbarButton.ANCHOR_CHAT_CHANNEL, this.h);
        return;
    }

    public AnchorChannelLoader(e r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        super(r2);
        this.h = new d2();
    }
}
