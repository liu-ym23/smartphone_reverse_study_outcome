package com.google.android.material.search;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.textfield.f;
import com.obric.cae.location.zpp.ui.StarZppUiActivity;
import com.obric.cae.smartBluetooth.dcf.DcfScanTestActivity;
import com.obric.cae.userAware.ui.CompanySceneCollectActivity;
import com.obric.cae.userAware.ui.DataCollectionHomeActivity;
import com.obric.cae.userAware.ui.UserAwareCurrentActivity;
import com.obric.cae.userAware.ui.UserAwareLauncherActivity;
import com.obric.oui.window.permission.WebViewActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4915b;

    public /* synthetic */ a(Object r8, int r10) {
        this.f4914a = r10;
        this.f4915b = r8;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        int r10 = this.f4914a;
        Object r11 = this.f4915b;
        switch(r10) {
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L25;
        };
    L5:
        UserAwareLauncherActivity.c((UserAwareLauncherActivity) r11, r8);
        return;
    L7:
        UserAwareCurrentActivity.c((UserAwareCurrentActivity) r11, r8);
        return;
    L9:
        DataCollectionHomeActivity.d((DataCollectionHomeActivity) r11, r8);
        return;
    L11:
        CompanySceneCollectActivity.n((CompanySceneCollectActivity) r11, r8);
        return;
    L13:
        DcfScanTestActivity.b((DcfScanTestActivity) r11, r8);
        return;
    L15:
        StarZppUiActivity.a((StarZppUiActivity) r11, r8);
        return;
    L17:
        f r12 = (f) r11;
        EditText r13 = r12.f5026i;
        if (r13 == null) goto L27;
        Editable r14 = r13.getText();
        if (r14 == null) goto L23;
        r14.clear();
    L23:
        r12.q();
        return;
    L27:
        return;
    L25:
        int r15 = WebViewActivity.f6705m;
        ((WebViewActivity) r11).finish();
    }
}
