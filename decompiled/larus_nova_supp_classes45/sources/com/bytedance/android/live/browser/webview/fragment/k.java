package com.bytedance.android.live.browser.webview.fragment;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ HybridDebugConsoleDialog$HybridDebugConsoleAdapter a;
    public final /* synthetic */ HybridDebugConsoleDialog$HybridDebugConsoleViewHolder b;

    public k(HybridDebugConsoleDialog$HybridDebugConsoleAdapter r1, HybridDebugConsoleDialog$HybridDebugConsoleViewHolder r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (this.a.a != this.b.getAdapterPosition()) goto L5;
        HybridDebugConsoleDialog$HybridDebugConsoleAdapter r3 = this.a;
        r3.a = -1;
        r3.notifyItemChanged(this.b.getAdapterPosition());
        return;
    L5:
        HybridDebugConsoleDialog$HybridDebugConsoleAdapter r4 = this.a;
        r4.notifyItemChanged(r4.a);
        HybridDebugConsoleDialog$HybridDebugConsoleAdapter r5 = this.a;
        r5.a = this.b.getAdapterPosition();
        HybridDebugConsoleDialog$HybridDebugConsoleAdapter r6 = this.a;
        r6.notifyItemChanged(r6.a);
    }
}
