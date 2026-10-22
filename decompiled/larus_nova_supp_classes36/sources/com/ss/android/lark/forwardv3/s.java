package com.ss.android.lark.forwardv3;

import android.view.View;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class s implements View.OnClickListener {
    public final /* synthetic */ ForwardNewFragment a;

    public s(ForwardNewFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        Log.i("NewForward", "start handle click left view inner");
        ForwardNewFragment r3 = this.a;
        int r0 = ForwardNewFragment.t;
        r3.aa0();
    }
}
