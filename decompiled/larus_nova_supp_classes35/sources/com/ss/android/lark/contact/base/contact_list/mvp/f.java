package com.ss.android.lark.contact.base.contact_list.mvp;

import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ g a;
    public final /* synthetic */ w8b.a b;

    public /* synthetic */ f(g r1, w8b.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g r0 = this.a;
        final w8b.a r1 = this.b;
        r0.getClass();
        Log.i("ExternalContactView2", "long click chatterId: " + r1.e);
        final ExternalContactView2 r2 = r0.a;
        r2.getClass();
        new UDDialogBuilder(r2.a).title(2131890557).addActionButton(2131391777, 2131891628, new c(r2, r1)).addActionButton(2131391778, 2131891541, null).show();
    }
}
