package com.obric.cae.userAware.ui;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class x0 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SubwayStatusActivity f6055b;

    public /* synthetic */ x0(SubwayStatusActivity r8, int r10) {
        this.f6054a = r10;
        this.f6055b = r8;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r8, int r10) {
        int r11 = this.f6054a;
        SubwayStatusActivity r12 = this.f6055b;
        switch(r11) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        SubwayStatusActivity.w(r12, r8, r10);
        return;
    L7:
        SubwayStatusActivity.t(r12, r8, r10);
    }
}
