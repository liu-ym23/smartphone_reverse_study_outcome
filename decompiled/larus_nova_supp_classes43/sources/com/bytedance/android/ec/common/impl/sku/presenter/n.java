package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.common.impl.sku.utils.ActivityCountDownTimer;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n<T> implements Observer {
    public final /* synthetic */ ButtonPresenter a;

    public n(ButtonPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        Boolean r11 = (Boolean) r10;
        if (r11 == null) goto L10;
        r11.booleanValue();
        if (r11.booleanValue() == false) goto L11;
        Lazy r12 = ActivityCountDownTimer.c;
        ActivityCountDownTimer.a.a().b();
        cf.t r13 = ButtonPresenter.e0(this.a).getSkuLiveService();
        if (r13 == null) goto L12;
        r13.a(this.a.m0());
        return;
    L12:
        return;
    L11:
        return;
    }
}
