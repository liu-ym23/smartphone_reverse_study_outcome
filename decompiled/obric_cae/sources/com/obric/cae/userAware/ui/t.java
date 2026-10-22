package com.obric.cae.userAware.ui;

import android.content.DialogInterface;
import android.widget.DatePicker;
import java.util.Calendar;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class t implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DatePicker f6038b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Calendar f6039m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ androidx.appcompat.app.e f6040n;

    public /* synthetic */ t(androidx.appcompat.app.e r8, DatePicker r10, Calendar r11, int r12) {
        this.f6037a = r12;
        this.f6040n = r8;
        this.f6038b = r10;
        this.f6039m = r11;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r8, int r10) {
        int r11 = this.f6037a;
        Calendar r12 = this.f6039m;
        DatePicker r13 = this.f6038b;
        androidx.appcompat.app.e r14 = this.f6040n;
        switch(r11) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        HARStatusActivity.k((HARStatusActivity) r14, r13, r12, r8, r10);
        return;
    L7:
        SubwayStatusActivity.v((SubwayStatusActivity) r14, r13, r12, r8, r10);
    }
}
