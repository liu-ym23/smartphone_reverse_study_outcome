package com.ss.android.lark.integrator.ccm.config.manis;

import com.ss.android.lark.manis.annotation.RemoteCallback;
import com.ss.android.lark.manis.annotation.RemoteService;
import ee.android.framework.manis.interfaces.IHookInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@RemoteService
public interface IDocManisService extends IHookInterface {

    @RemoteCallback
    public interface a {
        void a();
    }

    void onDocInitReady(a r1);
}
