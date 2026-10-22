package com.ss.android.lark.forwardv3;

import android.view.View;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.ui.IActionTitlebar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class t extends IActionTitlebar.TextAction {
    public final /* synthetic */ ForwardNewFragment a;

    public final void performAction(View r2) {
        super/*com.ss.android.lark.ui.IActionTitlebar.BaseAction*/.performAction(r2);
        Log.i("NewForward", "start handle click right view inner");
        ForwardNewFragment r3 = this.a;
        int r0 = ForwardNewFragment.t;
        r3.ba0();
    }

    public t(ForwardNewFragment r1, String r2) {
        this.a = r1;
        super(r2);
    }
}
