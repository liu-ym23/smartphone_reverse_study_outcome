package com.bytedance.android.ec.common.impl.sku.presenter;

import android.widget.TextView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h0<T> implements Observer {
    public final /* synthetic */ i0 a;

    public h0(i0 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        String r11 = (String) r10;
        TextView r0 = (TextView) this.a.Z().b(2131391474).f();
        if (jg.g.a(r11) == false) goto L5;
        r0.setVisibility(0);
        r0.setText(r11);
        return;
    L5:
        r0.setVisibility(8);
    }
}
