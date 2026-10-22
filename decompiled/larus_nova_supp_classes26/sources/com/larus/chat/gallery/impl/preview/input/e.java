package com.larus.chat.gallery.impl.preview.input;

import com.larus.im.bean.bot.BotModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ g a;
    public final /* synthetic */ BotModel b;

    public /* synthetic */ e(g r1, BotModel r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g r0 = this.a;
        BotModel r1 = this.b;
        Function1<? super BotModel, Unit> r2 = r0.d;
        if (r2 == null) goto L6;
        r2.invoke(r1);
        return;
    }
}
