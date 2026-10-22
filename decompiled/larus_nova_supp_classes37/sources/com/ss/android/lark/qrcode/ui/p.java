package com.ss.android.lark.qrcode.ui;

import android.content.Intent;
import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.qrcode.utils.QRScanUtils;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class p extends BasePresenter<b, c, c.a> {
    public final QRCodeScanView a;
    public final FragmentActivity b;
    public final AtomicLong c;
    public String d;

    public final IView.IViewDelegate createViewDelegate() {
        return new o(this);
    }

    public final void J8(final QRScanUtils.ProcessSuffix r3) {
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new m(this, r3));
    }

    public static void I8(p r2, String r3) {
        ((c) r2.getView()).showToast(y9c.d.i(r2.b, 2131892110));
        Log.i("QRCodeScanPresenter", "handle selected photo failed, path: " + r3);
    }

    public p(FragmentActivity r4, QRCodeScanFragment.b r5, Intent r6) {
        this.c = new AtomicLong(0);
        QRCodeScanView r0 = new QRCodeScanView(r5, r4);
        this.a = r0;
        r0.c = new o(this);
        setView(r0);
        setModel(new j(r6));
        this.b = r4;
        n r7 = new n(this);
        a0b.h r8 = a0b.h.a;
        Log.i("MediaResourceController", "injectInterruptCallback");
        a0b.h.d = r7;
    }

    public static void H8(final p r2, final String r3, final int r4) {
        r2.getClass();
        if (r3 != null) goto L5;
        Log.e("QRCodeScanPresenter", "preHandleParseResult input result is null");
        ((c) r2.getView()).showToast(y9c.d.i(r2.b, 2131892110));
        r2.b.finish();
        return;
    L5:
        a2c.a r0 = z1c.a.a;
        if (r0 != null) goto L8;
    L22:
        new Handler().post(new k(r2, r3, r4));
        return;
    L8:
        if (r0.canOpenAppLink(r3, r2.b, r4) == false) goto L13;
        int r1 = QRScanUtils.a;
        QRScanUtils.ProcessSuffix r5 = QRScanUtils.ProcessSuffix.SUFFIX_P0;
        if (QRScanUtils.a(r5) == true) goto L22;
        r2.J8(r5);
        goto L22
    L13:
        if (r0.canOpenAppBrand(r3) == false) goto L18;
        int r6 = QRScanUtils.a;
        QRScanUtils.ProcessSuffix r7 = QRScanUtils.ProcessSuffix.SUFFIX_MINI_APP;
        if (QRScanUtils.a(r7) == true) goto L22;
        r2.J8(r7);
        goto L22
    L18:
        if (r0.isMatchUrl(r3) == false) goto L22;
        int r8 = QRScanUtils.a;
        QRScanUtils.ProcessSuffix r9 = QRScanUtils.ProcessSuffix.SUFFIX_P0;
        if (QRScanUtils.a(r9) == true) goto L22;
        r2.J8(r9);
        goto L22
    }

    public p(FragmentActivity r4, QRCodeScanFragment.b r5, Intent r6, int[] r7) {
        this.c = new AtomicLong(0);
        QRCodeScanView r0 = new QRCodeScanView(r5, r4, r7);
        this.a = r0;
        r0.c = new o(this);
        setView(r0);
        setModel(new j(r6));
        this.b = r4;
        n r8 = new n(this);
        a0b.h r9 = a0b.h.a;
        Log.i("MediaResourceController", "injectInterruptCallback");
        a0b.h.d = r8;
    }
}
