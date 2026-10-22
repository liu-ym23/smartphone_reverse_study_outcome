package com.obric.cae.userAware.ui;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class r implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HARStatusActivity f6031b;

    public /* synthetic */ r(HARStatusActivity r8, int r10) {
        this.f6030a = r10;
        this.f6031b = r8;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r8, int r10) {
        int r11 = this.f6030a;
        HARStatusActivity r12 = this.f6031b;
        switch(r11) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        HARStatusActivity.g(r12, r8, r10);
        return;
    L7:
        HARStatusActivity.l(r12, r8, r10);
    }
}
