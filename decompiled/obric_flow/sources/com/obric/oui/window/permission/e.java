package com.obric.oui.window.permission;

import android.util.Log;
import android.view.View;
import com.bytedance.common.wschannel.WsConstants;
import ym.h;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WebViewActivity f14924b;

    public /* synthetic */ e(WebViewActivity r5, int r10) {
        this.f14923a = r10;
        this.f14924b = r5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        WebViewActivity r10 = this.f14924b;
        switch(this.f14923a) {
            case 0: goto L11;
            default: goto L4;
        };
    L4:
        int r11 = WebViewActivity.f14915x;
        r10.getClass();
        if (h.k(r10) == false) goto L13;
        r10.f14916t.setVisibility(8);
        r10.s.setVisibility(0);
        Log.d("WebViewActivity", "onClick, reload");
        r10.s.reload();
        r10.f14919w = true;
        if (r10.f14918v != null) goto L9;
        r10.f14918v = new com.obric.oui.lisitem.a(r10, 5);
    L9:
        r10.s.removeCallbacks(r10.f14918v);
        r10.s.postDelayed(r10.f14918v, WsConstants.EXIT_DELAY_TIME);
        return;
    L13:
        return;
    L11:
        int r12 = WebViewActivity.f14915x;
        r10.onBackPressed();
    }
}
