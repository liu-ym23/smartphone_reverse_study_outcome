package com.ss.android.lark.flow.chat.page.flow.plugin;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ FlowRelationshipBanner a;

    public j(FlowRelationshipBanner r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        wya.d r2 = ((wya.a) this.a).e;
        if (r2 == null) goto L6;
        r2.hide();
        return;
    }
}
