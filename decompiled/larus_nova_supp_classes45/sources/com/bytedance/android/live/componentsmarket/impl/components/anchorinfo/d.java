package com.bytedance.android.live.componentsmarket.impl.components.anchorinfo;

import android.widget.TextView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ CommonMergeAnchorInfoWidget a;

    public d(CommonMergeAnchorInfoWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        String r3 = (String) r2;
        TextView r0 = this.a.e;
        if (r0 == null) goto L6;
        r0.setText(r3);
        return;
    }
}
