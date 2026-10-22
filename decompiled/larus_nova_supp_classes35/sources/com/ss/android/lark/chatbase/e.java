package com.ss.android.lark.chatbase;

import q3b.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ BasePageStore a;
    public final /* synthetic */ f5b.b b;

    public /* synthetic */ e(BasePageStore r1, f5b.b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BasePageStore r0 = this.a;
        f5b.b r1 = this.b;
        r0.getClass();
        r0.m(s3b.c.a(new o(r1.getMessage()), new BasePageStore.a(r1)));
    }
}
