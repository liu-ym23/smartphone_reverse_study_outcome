package com.obric.cae.location.zpp.ui;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimPredictionResultActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f5721b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ TextView f5722m;

    public /* synthetic */ b(Activity r8, TextView r10, int r11) {
        this.f5720a = r11;
        this.f5721b = r8;
        this.f5722m = r10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        int r10 = this.f5720a;
        TextView r11 = this.f5722m;
        Activity r12 = this.f5721b;
        switch(r10) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        StarZppModelActivity.d((StarZppModelActivity) r12, r11, r8);
        return;
    L7:
        BdimPredictionResultActivity.e((BdimPredictionResultActivity) r12, (Button) r11, r8);
    }
}
