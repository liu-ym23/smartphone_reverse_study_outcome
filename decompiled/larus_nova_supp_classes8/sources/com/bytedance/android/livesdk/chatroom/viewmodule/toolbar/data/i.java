package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data;

import com.bytedance.android.live.core.setting.m;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i implements g.b<a2> {
    public i() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2
    public final String debugName() {
        return "PlayTogetherFilter";
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.b
    public final boolean a(a2 r4) {
        Intrinsics.checkNotNullParameter(r4, "button");
        List r0 = (List) m.a.getValue();
        ArrayList r1 = new ArrayList();
        if ((!r0.isEmpty()) == false) goto L11;
        Iterator r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L11;
        ToolbarButton r3 = ToolbarButton.fromName((String) r2.next());
        if (r3 == null) goto L6;
        r1.add(r3);
    L11:
        return !CollectionsKt.contains(r1, r4);
    }
}
