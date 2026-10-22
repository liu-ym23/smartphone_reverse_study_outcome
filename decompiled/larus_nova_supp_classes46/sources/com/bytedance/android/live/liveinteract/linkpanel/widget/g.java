package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ GuestApplyContentWidget a;
    public final /* synthetic */ List b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        RecyclerView r0 = this.a.c;
        if (r0 == null) goto L7;
        ViewTreeObserver r1 = r0.getViewTreeObserver();
        if (r1 == null) goto L7;
        r1.removeOnGlobalLayoutListener(this);
    L7:
        Map<String, cm2.a> r2 = com.bytedance.android.live.liveinteract.linkpanel.util.p.a;
        com.bytedance.android.live.liveinteract.linkpanel.util.p.e("apply_panel");
    }

    public g(GuestApplyContentWidget r1, List r2) {
        this.a = r1;
        this.b = r2;
    }
}
