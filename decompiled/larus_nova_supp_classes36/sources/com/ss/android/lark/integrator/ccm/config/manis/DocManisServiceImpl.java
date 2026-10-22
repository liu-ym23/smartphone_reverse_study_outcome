package com.ss.android.lark.integrator.ccm.config.manis;

import android.content.Context;
import com.ss.android.lark.manis.annotation.RemoteServiceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@RemoteServiceImpl(service = IDocManisService.class)
public class DocManisServiceImpl implements IDocManisService {
    private Context mContext;

    public DocManisServiceImpl(Context r1) {
        this.mContext = r1;
    }

    @Override // com.ss.android.lark.integrator.ccm.config.manis.IDocManisService
    public void onDocInitReady(IDocManisService.a r1) {
        r1.a();
    }
}
