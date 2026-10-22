package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import android.content.Context;
import android.view.ViewTreeObserver;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.live.core.utils.x1;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ o a;

    public p(o r1) {
        this.a = r1;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Context r0 = this.a.getContext().q.getContext();
        DataCenter r1 = this.a.getContext().b();
        if (r0 != null) goto L5;
        return;
    L5:
        int r2 = x1.j(r0);
        int r3 = ((Number) r1.get("data_link_state", 0)).intValue();
        o r4 = this.a;
        if (r2 == r4.g) goto L12;
        if (r3 != 0) goto L13;
        r4.g = r2;
        LayerEventDispatcher r5 = o70.c.a(Integer.valueOf(r1.hashCode()));
        if (r5 == null) goto L14;
        r5.b(new zg1.a());
        return;
    L14:
        return;
    L13:
        return;
    }
}
