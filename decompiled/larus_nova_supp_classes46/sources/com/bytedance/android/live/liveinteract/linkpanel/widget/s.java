package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s implements View.OnClickListener {
    public final /* synthetic */ LinkPanelTopBarWidget a;

    public s(LinkPanelTopBarWidget r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        LinkPanelTopBarWidget.wq(this.a);
    }
}
