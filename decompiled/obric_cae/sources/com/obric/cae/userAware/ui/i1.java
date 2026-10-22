package com.obric.cae.userAware.ui;

import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class i1 implements ge.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserAwareLauncherActivity f5973b;

    public /* synthetic */ i1(UserAwareLauncherActivity r8, int r10) {
        this.f5972a = r10;
        this.f5973b = r8;
    }

    @Override // ge.l
    public final Object invoke(Object r8) {
        int r10 = this.f5972a;
        UserAwareLauncherActivity r11 = this.f5973b;
        switch(r10) {
            case 0: goto L6;
            default: goto L8;
        };
    L6:
        return UserAwareLauncherActivity.j(r11, (FrameLayout) r8);
    L8:
        return UserAwareLauncherActivity.l(r11, (FrameLayout) r8);
    }
}
