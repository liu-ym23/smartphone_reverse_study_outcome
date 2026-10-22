package com.obric.cae.userAware.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.widget.Button;
import com.obric.cae.userAware.datacollection.PoiArrivalFeedbackInfo;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class i0 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PoiArrivalFeedbackInfo f5969b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Button f5970m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Activity f5971n;

    public /* synthetic */ i0(Activity r8, PoiArrivalFeedbackInfo r10, Button r11, int r12) {
        this.f5968a = r12;
        this.f5971n = r8;
        this.f5969b = r10;
        this.f5970m = r11;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r8, int r10) {
        int r11 = this.f5968a;
        Button r12 = this.f5970m;
        PoiArrivalFeedbackInfo r13 = this.f5969b;
        Activity r14 = this.f5971n;
        switch(r11) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        PoiArrivalActivity.a((PoiArrivalActivity) r14, r13, r12, r8, r10);
        return;
    L7:
        StoreArrivalActivity.f((StoreArrivalActivity) r14, r13, r12, r8, r10);
    }
}
