package com.larus.bmhome.chat.component.regen;

import com.larus.bmhome.chat.adapter.MessageAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ MessageAdapter a;
    public final /* synthetic */ int b;

    public /* synthetic */ f(MessageAdapter r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.notifyItemChanged(this.b);
    }
}
