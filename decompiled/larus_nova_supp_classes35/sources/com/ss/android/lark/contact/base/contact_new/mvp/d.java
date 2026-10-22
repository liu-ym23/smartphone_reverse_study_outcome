package com.ss.android.lark.contact.base.contact_new.mvp;

import android.view.View;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.contact.base.dto.ChatApplication;
import com.ss.android.lark.contact.base.service.a0;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.ViewUtils;
import com.ss.android.lark.utils.r0;
import com.ss.android.lark.widget.listener.OnSingleClickListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends OnSingleClickListener {
    public final /* synthetic */ ChatApplication.Status a;
    public final /* synthetic */ NewContactView.a b;
    public final /* synthetic */ int c;
    public final /* synthetic */ NewContactAdapter d;

    public final void onSingleClick(View r5) {
        if (this.a != ChatApplication.Status.PEDING) goto L6;
        final NewContactAdapter r6 = this.d;
        NewContactView.a r0 = this.b;
        final int r1 = this.c;
        r6.getClass();
        a0.c(true);
        UIGetDataCallback r2 = new UIGetDataCallback(new NewContactAdapter.AnonymousClass3(r6, r1));
        Statistics.sendEvent("newcontact_add_click");
        ViewUtils.runOnUiThread(new r0(r6.a, new f(r6, r0, r2)));
        return;
    L6:
        NewContactAdapter.a r7 = this.d.b;
        if (r7 == null) goto L10;
        NewContactView.a r3 = this.b;
        String r4 = r3.b;
        String r8 = r3.a;
        ((m) r7).a.b.t0(r4, r8);
        return;
    }

    public d(NewContactAdapter r1, ChatApplication.Status r2, NewContactView.a r3, int r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
