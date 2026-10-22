package com.obric.cae.userAware.ui;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class j implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CompanySceneCollectActivity f5975b;

    public /* synthetic */ j(CompanySceneCollectActivity r8, int r10) {
        this.f5974a = r10;
        this.f5975b = r8;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r8, int r10) {
        int r11 = this.f5974a;
        CompanySceneCollectActivity r12 = this.f5975b;
        switch(r11) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        CompanySceneCollectActivity.q(r12, r8, r10);
        return;
    L7:
        CompanySceneCollectActivity.r(r12, r8, r10);
    }
}
