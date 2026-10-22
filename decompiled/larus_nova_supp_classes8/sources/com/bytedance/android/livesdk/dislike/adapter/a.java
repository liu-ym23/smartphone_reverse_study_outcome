package com.bytedance.android.livesdk.dislike.adapter;

import android.view.View;
import com.bytedance.android.livesdk.dislike.action.OptionAction;
import com.bytedance.android.livesdk.dislike.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ j a;

    public a(j r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        j r0 = this.a;
        if (r0 == null) goto L8;
        OptionAction r1 = r0.b;
        if (r1 == null) goto L9;
        r1.b(r2);
        return;
    L9:
        return;
    }
}
