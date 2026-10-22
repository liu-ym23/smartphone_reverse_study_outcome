package com.obric.cae.userAware.ui;

import android.app.Activity;
import android.content.DialogInterface;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class h implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f5962b;

    public /* synthetic */ h(Activity r8, int r10) {
        this.f5961a = r10;
        this.f5962b = r8;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r8, int r10) {
        int r11 = this.f5961a;
        Activity r12 = this.f5962b;
        switch(r11) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L9;
        };
    L5:
        CompanySceneCollectActivity.u((CompanySceneCollectActivity) r12, r8, r10);
        return;
    L7:
        CompanySceneCollectActivity.e((CompanySceneCollectActivity) r12, r8, r10);
        return;
    L9:
        UserAwareLauncherActivity.f((UserAwareLauncherActivity) r12, r8, r10);
    }
}
