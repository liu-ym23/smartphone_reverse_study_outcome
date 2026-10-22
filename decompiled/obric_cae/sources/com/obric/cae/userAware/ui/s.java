package com.obric.cae.userAware.ui;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class s implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6034a;

    public /* synthetic */ s(int r8) {
        this.f6034a = r8;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r8, int r10) {
        switch(this.f6034a) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L9;
        };
    L5:
        SubwayStatusActivity.e(r8, r10);
        return;
    L7:
        HARStatusActivity.o(r8, r10);
        return;
    L9:
        UserAwareLauncherActivity.b(r8, r10);
    }
}
