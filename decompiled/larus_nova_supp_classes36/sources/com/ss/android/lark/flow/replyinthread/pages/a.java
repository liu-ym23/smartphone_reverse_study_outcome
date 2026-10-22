package com.ss.android.lark.flow.replyinthread.pages;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements DialogInterface.OnKeyListener {
    public final /* synthetic */ FlowReplyInThreadFragment a;

    public a(FlowReplyInThreadFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r1, int r2, KeyEvent r3) {
        if (r2 != 4) goto L7;
        zab.a.a(this.a);
        return true;
    L7:
        return true;
    }
}
