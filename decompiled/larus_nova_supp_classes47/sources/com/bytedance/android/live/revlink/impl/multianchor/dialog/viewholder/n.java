package com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder;

import android.view.View;
import androidx.lifecycle.MutableLiveData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n implements View.OnClickListener {
    public final /* synthetic */ TabTitleItemViewHolder a;

    public n(TabTitleItemViewHolder r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        TabTitleItemViewHolder r3 = this.a;
        MutableLiveData<Integer> r0 = r3.d;
        if (r0 == null) goto L10;
        Integer r4 = r3.c;
        if (r4 == null) goto L7;
        int r5 = r4.intValue();
    L8:
        r0.setValue(Integer.valueOf(r5));
        return;
    L7:
        r5 = 0;
        goto L8
    }
}
