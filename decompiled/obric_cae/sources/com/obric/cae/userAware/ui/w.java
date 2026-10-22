package com.obric.cae.userAware.ui;

import android.content.DialogInterface;
import com.obric.cae.userAware.datacollection.HARFeedbackInfo;
import com.obric.cae.userAware.datacollection.SubwayFeedbackInfo;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class w implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ androidx.appcompat.app.e f6047b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f6048m;

    public /* synthetic */ w(androidx.appcompat.app.e r8, Object r10, int r11) {
        this.f6046a = r11;
        this.f6047b = r8;
        this.f6048m = r10;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r8, int r10) {
        int r11 = this.f6046a;
        Object r12 = this.f6048m;
        androidx.appcompat.app.e r13 = this.f6047b;
        switch(r11) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        HARStatusActivity.i((HARStatusActivity) r13, (HARFeedbackInfo) r12, r8, r10);
        return;
    L7:
        SubwayStatusActivity.o((SubwayStatusActivity) r13, (SubwayFeedbackInfo) r12, r8, r10);
    }
}
