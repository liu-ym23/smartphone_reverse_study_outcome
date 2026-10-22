package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r0 implements View.OnClickListener {
    public final /* synthetic */ RecordCompositeWidget a;

    public r0(RecordCompositeWidget r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        RecordCompositeWidget.wq(this.a);
    }
}
