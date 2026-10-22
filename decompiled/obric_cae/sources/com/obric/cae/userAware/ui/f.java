package com.obric.cae.userAware.ui;

import android.app.Activity;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f5949b;

    public /* synthetic */ f(Activity r8, int r10) {
        this.f5948a = r10;
        this.f5949b = r8;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r8, boolean r10) {
        int r11 = this.f5948a;
        Activity r12 = this.f5949b;
        switch(r11) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        CompanySceneCollectActivity.o((CompanySceneCollectActivity) r12, r8, r10);
        return;
    L7:
        UserAwareCurrentActivity.a((UserAwareCurrentActivity) r12, r8, r10);
    }
}
