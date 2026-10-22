package com.ss.android.lark.integrator.ccm.spacekit;

import com.larksuite.framework.callback.IGetDataCallback;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l implements Action {
    public final /* synthetic */ IGetDataCallback a;
    public final /* synthetic */ long[] b;

    public final void run() throws Exception {
        this.a.onSuccess(Long.valueOf(this.b[0]));
    }

    public l(IGetDataCallback r1, long[] r2) {
        this.a = r1;
        this.b = r2;
    }
}
