package com.obric.cae.location.zpp.ui;

import android.app.Activity;
import android.view.View;
import com.obric.cae.smartBluetooth.dcf.DcfScanTestActivity;
import com.obric.oui.window.permission.WebViewActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f5719b;

    public /* synthetic */ a(Activity r8, int r10) {
        this.f5718a = r10;
        this.f5719b = r8;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        int r10 = this.f5718a;
        Activity r11 = this.f5719b;
        switch(r10) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L11;
        };
    L5:
        DcfScanTestActivity.a((DcfScanTestActivity) r11, r8);
        return;
    L7:
        StarZppUiActivity.b((StarZppUiActivity) r11, r8);
        return;
    L9:
        StarZppModelActivity.e((StarZppModelActivity) r11, r8);
        return;
    L11:
        WebViewActivity r12 = (WebViewActivity) r11;
        int r13 = WebViewActivity.f6705m;
        r12.getClass();
        if (y0.d.d(r12) == false) goto L15;
        r12.f6707b.setVisibility(8);
        r12.f6706a.setVisibility(0);
        r12.f6706a.reload();
        return;
    }
}
