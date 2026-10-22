package com.ss.android.lark.integrator.ccm.spacekit;

import com.larksuite.framework.callback.IGetDataCallback;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class o implements Action {
    public final /* synthetic */ IGetDataCallback a;
    public final /* synthetic */ boolean[] b;

    public final void run() throws Exception {
        IGetDataCallback r0 = this.a;
        if (r0 == null) goto L6;
        r0.onSuccess(Boolean.valueOf(this.b[0]));
        return;
    }

    public o(IGetDataCallback r1, boolean[] r2) {
        this.a = r1;
        this.b = r2;
    }
}
