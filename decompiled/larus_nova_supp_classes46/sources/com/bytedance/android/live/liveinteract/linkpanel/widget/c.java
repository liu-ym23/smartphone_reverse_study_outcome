package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.widget.TextView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ GuestApplyContentWidget a;

    public c(GuestApplyContentWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if (((cj0.k) r2).a == true) goto L5;
    L9:
        SimpleDateFormat r3 = com.bytedance.android.live.liveinteract.linkpanel.util.o.a;
        TextView r4 = this.a.i;
        if (r4 == null) goto L15;
        r4.setOnClickListener(new b(this));
        return;
    L15:
        return;
    L5:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.x(this.a.r) == false) goto L9;
        TextView r5 = this.a.i;
        if (r5 == null) goto L13;
        r5.setOnClickListener(new a(this));
        return;
    }
}
