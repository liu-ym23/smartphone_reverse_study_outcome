package com.obric.cae;

import android.content.Context;
import com.obric.cae.runtime.ServiceReadyListener;
import com.obric.cae.userAware.UserAwareService;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements ServiceReadyListener {
    @Override // com.obric.cae.runtime.ServiceReadyListener
    public final void onServiceReady(Context r8, Object r10) {
        CaeApplication.b(r8, (UserAwareService) r10);
    }
}
