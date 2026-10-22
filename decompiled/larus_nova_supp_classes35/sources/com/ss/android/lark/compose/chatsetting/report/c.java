package com.ss.android.lark.compose.chatsetting.report;

import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements View.OnKeyListener {
    public final /* synthetic */ FlowChatFunctionAbandonBottomSheet a;

    public c(FlowChatFunctionAbandonBottomSheet r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View r1, int r2, KeyEvent r3) {
        if (r2 == 4) goto L5;
    L7:
        return false;
    L5:
        if (r3.getAction() != 1) goto L7;
        this.a.a();
        return true;
    }
}
