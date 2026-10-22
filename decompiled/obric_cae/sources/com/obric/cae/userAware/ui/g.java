package com.obric.cae.userAware.ui;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CompanySceneCollectActivity f5956b;

    public /* synthetic */ g(CompanySceneCollectActivity r8, int r10) {
        this.f5955a = r10;
        this.f5956b = r8;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        int r10 = this.f5955a;
        CompanySceneCollectActivity r11 = this.f5956b;
        switch(r10) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        CompanySceneCollectActivity.m(r11, r8);
        return;
    L7:
        CompanySceneCollectActivity.p(r11, r8);
    }
}
