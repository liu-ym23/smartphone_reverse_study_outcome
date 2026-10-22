package com.obric.cae;

import android.content.Context;
import com.obric.cae.location.StarLocationService;
import com.obric.cae.runtime.ServiceReadyListener;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements ServiceReadyListener {
    @Override // com.obric.cae.runtime.ServiceReadyListener
    public final void onServiceReady(Context r8, Object r10) {
        CaeApplication.d(r8, (StarLocationService) r10);
    }
}
