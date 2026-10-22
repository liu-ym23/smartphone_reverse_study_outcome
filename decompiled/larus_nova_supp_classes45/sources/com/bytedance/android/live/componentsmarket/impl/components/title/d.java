package com.bytedance.android.live.componentsmarket.impl.components.title;

import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ TitleTetris a;

    public d(TitleTetris r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        String r4 = (String) r3;
        TitleTetris r0 = this.a;
        TextView r1 = r0.u;
        if (r1 == null) goto L5;
        UtilityKotlinExtentionsKt.w(r1);
    L5:
        TextView r2 = r0.u;
        if (r2 == null) goto L9;
        r2.setText(r4);
        return;
    }
}
