package com.bytedance.android.ec.common.impl.sku.presenter;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class s<T> implements Observer {
    public final /* synthetic */ ButtonPresenter a;

    public s(ButtonPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        com.bytedance.android.ec.model.response.p r11 = (com.bytedance.android.ec.model.response.p) r10;
        if (r11 == null) goto L28;
        int r0 = r11.e;
        if (r0 <= 0) goto L10;
        this.a.q0(false);
        LinearLayout r12 = (LinearLayout) this.a.Z().b(2131378867).f();
        r12.setBackgroundResource(2131247920);
        r12.setClickable(true);
        ((TextView) this.a.Z().b(2131378863).f()).setEnabled(true);
        cf.t r13 = ButtonPresenter.e0(this.a).getSkuLiveService();
        if (r13 == null) goto L26;
        r13.a(this.a.m0());
        return;
    L26:
        return;
    L10:
        if (r0 == 0) goto L12;
    L16:
        boolean r1 = false;
    L17:
        if (r1 == false) goto L21;
        this.a.q0(false);
        cf.t r14 = ButtonPresenter.e0(this.a).getSkuLiveService();
        if (r14 == null) goto L24;
        r14.a(this.a.m0());
    L24:
        LinearLayout r15 = (LinearLayout) this.a.Z().b(2131378867).f();
        r15.setBackgroundResource(2131247887);
        r15.setClickable(false);
        ((TextView) this.a.Z().b(2131378863).f()).setEnabled(false);
        return;
    L21:
        this.a.q0(true);
        ButtonPresenter.h0(this.a, r11);
        cf.t r16 = ButtonPresenter.e0(this.a).getSkuLiveService();
        if (r16 == null) goto L24;
        r16.b(this.a.m0());
        goto L24
    L12:
        if (r11.c != 0) goto L16;
        if (r11.d != 0) goto L16;
        r1 = true;
        goto L17
    }
}
