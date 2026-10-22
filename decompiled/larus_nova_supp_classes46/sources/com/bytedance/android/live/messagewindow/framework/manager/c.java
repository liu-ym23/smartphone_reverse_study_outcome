package com.bytedance.android.live.messagewindow.framework.manager;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ a.e a;

    public c(a.e r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        a r0 = this.a.c;
        String r5 = "getPublicScreenDataSource " + this.a.hashCode() + ' ' + ((i32.a) r4);
        int r1 = a.d;
        r0.getClass();
        a.a(r5);
    }
}
