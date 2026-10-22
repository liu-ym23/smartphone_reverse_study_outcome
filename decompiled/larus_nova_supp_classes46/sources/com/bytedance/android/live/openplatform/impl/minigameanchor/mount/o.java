package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o implements DialogInterface.OnDismissListener {
    public final /* synthetic */ LiveMgMountContextService$showStarAtlasAgreementDialog$1 a;

    public o(LiveMgMountContextService$showStarAtlasAgreementDialog$1 r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        this.a.invoke("close");
    }
}
