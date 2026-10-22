package com.ss.android.lark.forwardv3;

import androidx.lifecycle.Observer;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class u<T> implements Observer {
    public final /* synthetic */ ForwardNewFragment a;

    public u(ForwardNewFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Integer r3 = (Integer) r2;
        Log.i("NewForward", "select mode change");
        ForwardNewFragment r4 = this.a;
        int r0 = ForwardNewFragment.t;
        r4.ea0(true);
    }
}
