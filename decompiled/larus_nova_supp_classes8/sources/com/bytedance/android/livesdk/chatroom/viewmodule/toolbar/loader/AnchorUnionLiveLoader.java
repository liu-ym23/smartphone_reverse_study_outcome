package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.q5;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AnchorUnionLiveLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorUnionLiveLoader extends AbsDynamicLoader {
    public final q5 h;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        ArrayList r0 = new ArrayList();
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r1 == null) goto L11;
        com.bytedance.live.datacontext.j r2 = r1.getAnchorUnionLiveDataContext();
        if (r2 == null) goto L11;
        com.bytedance.android.live.room.c r3 = (com.bytedance.android.live.room.c) r2.getValue();
        if (r3 == null) goto L11;
        com.bytedance.live.datacontext.j r4 = r3.getEnable();
        if (r4 == null) goto L11;
        Boolean r5 = (Boolean) r4.getValue();
    L13:
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L15;
        r0.add(ToolbarButton.UNION_LIVE);
    L15:
        return r0;
    L11:
        r5 = null;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
        y3.f(this.a).k(ToolbarButton.UNION_LIVE, this.h);
    }

    public AnchorUnionLiveLoader(e r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        super(r2);
        this.h = new q5();
    }
}
