package com.obric.cae.userAware.ui;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class n implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6002b;

    public /* synthetic */ n(Object r8, int r10) {
        this.f6001a = r10;
        this.f6002b = r8;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        int r10 = this.f6001a;
        Object r11 = this.f6002b;
        switch(r10) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L11;
        };
    L5:
        SubwayStatusActivity.p((SubwayStatusActivity) r11, r8);
        return;
    L7:
        StoreArrivalActivity.b((StoreArrivalActivity) r11, r8);
        return;
    L9:
        DataCollectionEntryFragment.a((DataCollectionEntryFragment) r11, r8);
        return;
    L11:
        UserAwareCurrentActivity.b((UserAwareCurrentActivity) r11, r8);
    }
}
