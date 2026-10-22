package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.core.data.LoadingStatus;
import com.bytedance.android.ec.core.widget.StatusView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p2<T> implements Observer {
    public final /* synthetic */ t2 a;

    public p2(t2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        StatusView r0 = (StatusView) this.a.Z().b(2131387797).f();
        LoadingStatus r11 = ((rg.b) r10).a;
        int r12 = n2.a[r11.ordinal()];
        if (r12 != 1) goto L5;
        this.a.Z().b(2131378873).f().setVisibility(4);
        r0.showLoading();
        return;
    L5:
        if (r12 != 2) goto L7;
        this.a.Z().b(2131378873).f().setVisibility(0);
        r0.reset();
        return;
    L7:
        if (r12 != 3) goto L15;
        r0.setVisibility(0);
        r0.setECStatus(2);
        return;
    }
}
