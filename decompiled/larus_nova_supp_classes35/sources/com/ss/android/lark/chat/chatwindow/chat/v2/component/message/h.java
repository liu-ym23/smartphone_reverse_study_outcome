package com.ss.android.lark.chat.chatwindow.chat.v2.component.message;

import androidx.lifecycle.Observer;
import com.ss.android.lark.chat.chatwindow.biz.component.banner.IBannerComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.titlebar.ITitlebarComponent;
import com.ss.android.lark.chat.entity.chat.Chat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ d.a a;
    public final /* synthetic */ IMessageListComponent b;

    public h(d.C0062d r1, IMessageListComponent r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r4) {
        Chat r5 = (Chat) r4;
        IBannerComponent r6 = (IBannerComponent) this.a.a(IBannerComponent.class);
        if (r6 == null) goto L10;
        ITitlebarComponent r0 = (ITitlebarComponent) this.a.a(ITitlebarComponent.class);
        if (r0 == null) goto L11;
        d.c r1 = new d.c(this.b);
        r6.jx(r1);
        r0.kq(r1);
        r0.sm(r1);
        r0.OY(r1);
        return;
    L11:
        return;
    }
}
