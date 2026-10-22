package com.bytedance.android.debug;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ DebugLocalResourceListAdapter a;
    public final /* synthetic */ String b;

    public k(DebugLocalResourceListAdapter r1, String r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        DebugLocalResourceListAdapter.b r11 = this.a.c;
        if (r11 == null) goto L6;
        r11.a(this.b);
        return;
    }
}
