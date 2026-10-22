package com.obric.cae.userAware.ui;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class j1 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserAwareLauncherActivity f5981b;

    public /* synthetic */ j1(UserAwareLauncherActivity r8, int r10) {
        this.f5980a = r10;
        this.f5981b = r8;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r8, int r10) {
        int r11 = this.f5980a;
        UserAwareLauncherActivity r12 = this.f5981b;
        switch(r11) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        UserAwareLauncherActivity.a(r12, r8, r10);
        return;
    L7:
        UserAwareLauncherActivity.e(r12, r8, r10);
    }
}
