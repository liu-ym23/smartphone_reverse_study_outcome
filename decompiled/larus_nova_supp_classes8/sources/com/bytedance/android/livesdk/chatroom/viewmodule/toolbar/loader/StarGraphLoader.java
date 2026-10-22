package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/StarGraphLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StarGraphLoader extends AbsDynamicLoader {
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        ArrayList r0 = new ArrayList();
        if (((Boolean) this.a.get("cmd_toolbar_star_graph_visible", Boolean.FALSE)).booleanValue() == false) goto L5;
        r0.add(ToolbarButton.STAR_GRAPH);
    L5:
        return r0;
    }

    public StarGraphLoader(e r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        super(r2);
    }
}
