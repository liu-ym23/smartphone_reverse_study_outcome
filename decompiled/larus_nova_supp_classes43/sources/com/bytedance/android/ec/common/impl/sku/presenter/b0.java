package com.bytedance.android.ec.common.impl.sku.presenter;

import android.widget.TextView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b0<T> implements Observer {
    public final /* synthetic */ d0 a;

    public b0(d0 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        String r11 = (String) r10;
        TextView r0 = (TextView) this.a.Z().b(2131391474).f();
        if (jg.g.a(r11) == false) goto L10;
        r0.setVisibility(0);
        r0.setText(r11);
        if (this.a.Z().b(2131391466).f().getVisibility() != 0) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == false) goto L12;
        this.a.Z().b(2131391449).f().setVisibility(0);
        return;
    L12:
        return;
    L7:
        r12 = false;
        goto L8
    L10:
        r0.setVisibility(8);
        this.a.Z().b(2131391449).f().setVisibility(8);
    }
}
