package com.bytedance.android.live.liveinteract.voicechat.match.view;

import android.widget.TextView;
import com.bytedance.android.live.base.model.message.a5;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ ChatMatchDialog a;

    public d(ChatMatchDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        a5 r5 = (a5) r4;
        ChatMatchDialog r0 = this.a;
        r0.j = r5;
        if (r5 == null) goto L8;
        TextView r1 = r0.x;
        if (r1 == null) goto L9;
        r1.setText(sb2.a.h(r5, "", false));
        return;
    L9:
        return;
    }
}
