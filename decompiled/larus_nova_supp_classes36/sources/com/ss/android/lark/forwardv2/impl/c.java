package com.ss.android.lark.forwardv2.impl;

import com.larksuite.framework.callback.IGetDataCallback;
import iib.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements e {
    public final /* synthetic */ ForwardPresenter a;

    public c(ForwardPresenter r1) {
        this.a = r1;
    }

    public final void a(final IGetDataCallback<rib.b> r3) {
        final ForwardPresenter r0 = this.a;
        r0.getClass();
        IGetDataCallback<rib.b> r1 = new ForwardPresenter.AnonymousClass7(r0, r3);
        r0.I8(r1, true);
        r0.I8(r1, false);
    }
}
