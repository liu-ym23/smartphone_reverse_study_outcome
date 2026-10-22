package com.ss.android.lark.flow.chat.creategroup.page;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ FlowGroupCreateActivity a;

    public a(FlowGroupCreateActivity r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        FlowGroupCreateActivity.z1(this.a);
        this.a.finish();
    }
}
