package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.widget.TextView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ GuestApplyContentWidget a;

    public d(GuestApplyContentWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Integer r4 = (Integer) r3;
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.z() == true) goto L25;
        if (r4 != null) goto L7;
    L14:
        if (r4 != null) goto L17;
        return;
    L17:
        if (r4.intValue() != 2) goto L28;
        TextView r5 = this.a.i;
        if (r5 == null) goto L21;
        r5.setBackgroundResource(2131249221);
    L21:
        TextView r6 = this.a.i;
        if (r6 == null) goto L29;
        r6.setClickable(false);
        return;
    L29:
        return;
    L28:
        return;
    L7:
        if (r4.intValue() != 1) goto L14;
        TextView r7 = this.a.i;
        if (r7 == null) goto L11;
        r7.setBackgroundResource(2131249467);
    L11:
        TextView r8 = this.a.i;
        if (r8 == null) goto L26;
        r8.setClickable(true);
        return;
    L26:
        return;
    }
}
