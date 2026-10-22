package com.obric.cae.userAware.ui;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class i implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5967a;

    public /* synthetic */ i(int r8) {
        this.f5967a = r8;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r8, int r10) {
        switch(this.f5967a) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        CompanySceneCollectActivity.f(r8, r10);
        return;
    L7:
        CompanySceneCollectActivity.y(r8, r10);
    }
}
