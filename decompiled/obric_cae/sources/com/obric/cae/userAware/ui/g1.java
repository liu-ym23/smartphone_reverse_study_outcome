package com.obric.cae.userAware.ui;

import android.app.Activity;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g1 implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f5960b;

    public /* synthetic */ g1(Activity r8, int r10) {
        this.f5959a = r10;
        this.f5960b = r8;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r8, boolean r10) {
        int r11 = this.f5959a;
        Activity r12 = this.f5960b;
        switch(r11) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L9;
        };
    L5:
        UserAwareLauncherActivity.k((UserAwareLauncherActivity) r12, r8, r10);
        return;
    L7:
        UserAwareLauncherActivity.k((UserAwareLauncherActivity) r12, r8, r10);
        return;
    L9:
        SubwayStatusActivity.s((SubwayStatusActivity) r12, r8, r10);
    }
}
