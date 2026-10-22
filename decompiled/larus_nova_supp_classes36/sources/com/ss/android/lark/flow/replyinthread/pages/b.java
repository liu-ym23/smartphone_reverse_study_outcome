package com.ss.android.lark.flow.replyinthread.pages;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements DialogInterface.OnClickListener {
    public final /* synthetic */ FlowReplyInThreadFragment a;

    public b(FlowReplyInThreadFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        zab.a.a(this.a);
    }
}
