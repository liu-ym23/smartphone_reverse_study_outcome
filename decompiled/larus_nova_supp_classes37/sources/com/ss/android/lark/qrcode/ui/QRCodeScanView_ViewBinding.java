package com.ss.android.lark.qrcode.ui;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ss.android.lark.ui.CommonTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class QRCodeScanView_ViewBinding implements Unbinder {
    public QRCodeScanView a;

    public final void unbind() {
        QRCodeScanView r0 = this.a;
        if (r0 == null) goto L7;
        this.a = null;
        r0.mMyTitleBar = null;
        r0.mCustomViewContainer = null;
        r0.mFlashLight = null;
        r0.mFlashLightTips = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public QRCodeScanView_ViewBinding(QRCodeScanView r4, View r5) {
        this.a = r4;
        r4.mMyTitleBar = (CommonTitleBar) Utils.findRequiredViewAsType(r5, 2131388928, "field 'mMyTitleBar'", CommonTitleBar.class);
        r4.mCustomViewContainer = (FrameLayout) Utils.findRequiredViewAsType(r5, 2131368479, "field 'mCustomViewContainer'", FrameLayout.class);
        r4.mFlashLight = (ImageView) Utils.findRequiredViewAsType(r5, 2131372907, "field 'mFlashLight'", ImageView.class);
        r4.mFlashLightTips = (TextView) Utils.findRequiredViewAsType(r5, 2131372909, "field 'mFlashLightTips'", TextView.class);
    }
}
