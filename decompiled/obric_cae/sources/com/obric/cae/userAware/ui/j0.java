package com.obric.cae.userAware.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import com.obric.cae.userAware.datacollection.PoiArrivalFeedbackInfo;
import java.util.Calendar;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class j0 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5977b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ View f5978m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Activity f5979n;

    public /* synthetic */ j0(Activity r8, Object r10, View r11, int r12) {
        this.f5976a = r12;
        this.f5979n = r8;
        this.f5977b = r10;
        this.f5978m = r11;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r8, int r10) {
        int r11 = this.f5976a;
        View r12 = this.f5978m;
        Object r13 = this.f5977b;
        Activity r14 = this.f5979n;
        switch(r11) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L9;
        };
    L5:
        StoreArrivalActivity.m((StoreArrivalActivity) r14, (PoiArrivalFeedbackInfo) r13, (Button) r12, r8, r10);
        return;
    L7:
        PoiArrivalActivity.b((PoiArrivalActivity) r14, (PoiArrivalFeedbackInfo) r13, (Button) r12, r8, r10);
        return;
    L9:
        StoreArrivalActivity.i((StoreArrivalActivity) r14, (Calendar) r13, (DatePicker) r12, r8, r10);
    }
}
