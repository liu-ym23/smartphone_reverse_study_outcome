package com.bytedance.android.livesdk.gamecp;

import com.bytedance.android.livehostapi.business.depend.IPluginInstallCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h implements IPluginInstallCallback {
    public final /* synthetic */ dw.l a;

    public h(dw.l r1) {
        this.a = r1;
    }

    public final void onResult(boolean r2) {
        this.a.onResult(r2);
    }
}
