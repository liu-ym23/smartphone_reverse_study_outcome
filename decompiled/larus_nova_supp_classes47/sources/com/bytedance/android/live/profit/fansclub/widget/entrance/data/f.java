package com.bytedance.android.live.profit.fansclub.widget.entrance.data;

import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.profit.fansclub.widget.entrance.facade.EntranceMVIFacade;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ i a;

    public f(i r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        if (((UserEvent) r3).isLogin() == false) goto L10;
        i r4 = this.a;
        if (r4.d == false) goto L11;
        EntranceMVIFacade r5 = fu0.b.b(i.a(r4));
        if (r5 == null) goto L12;
        r5.a(new eu0.c(i.a(this.a)));
        return;
    L12:
        return;
    L11:
        return;
    }
}
