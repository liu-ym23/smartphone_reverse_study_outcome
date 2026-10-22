package com.obric.cae.userAware.ui;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5983b;

    public /* synthetic */ k(Object r8, int r10) {
        this.f5982a = r10;
        this.f5983b = r8;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        int r10 = this.f5982a;
        Object r11 = this.f5983b;
        switch(r10) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L11;
        };
    L5:
        HARStatusActivity.p((HARStatusActivity) r11, r8);
        return;
    L7:
        DataCollectionEntryFragment.b((DataCollectionEntryFragment) r11, r8);
        return;
    L9:
        CompanySceneCollectActivity.d((CompanySceneCollectActivity) r11, r8);
        return;
    L11:
        StoreArrivalActivity.h((StoreArrivalActivity) r11, r8);
    }
}
