package com.bytedance.android.ec.common.impl.sku.presenter;

import android.widget.TextView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class z0<T> implements Observer {
    public final /* synthetic */ f1 a;

    public z0(f1 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        TextView r0 = (TextView) this.a.Z().b(2131391463).f();
        r0.setText((String) r10);
    }
}
