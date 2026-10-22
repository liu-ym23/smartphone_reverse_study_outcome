package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.bytedance.android.livehostapi.business.shareinter.ILiveIMSharePostscriptComponent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements DialogInterface.OnKeyListener {
    public final /* synthetic */ ILiveIMSharePostscriptComponent a;

    public g(ILiveIMSharePostscriptComponent r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r1, int r2, KeyEvent r3) {
        if (r3.getAction() == 0) goto L5;
        return false;
    L5:
        if (r3.getKeyCode() == 4) goto L7;
        return false;
    L7:
        return this.a.onBackPressed();
    }
}
