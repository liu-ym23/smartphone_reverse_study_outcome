package com.larus.bmhome.chat.model.strategy;

import com.larus.bmhome.chat.helper.n0;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class d implements Function1 {
    public final /* synthetic */ Message a;
    public final /* synthetic */ Function2 b;
    public final /* synthetic */ ChatRetryStrategy c;

    public /* synthetic */ d(Message r1, a r2, ChatRetryStrategy r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r6) {
        final Message r0 = this.a;
        Function2 r1 = this.b;
        final ChatRetryStrategy r2 = this.c;
        mr9.l r7 = (mr9.l) r6;
        Intrinsics.checkNotNullParameter(r7, "it");
        n0 r3 = n0.a;
        Map r4 = r0.getExt();
        r3.getClass();
        r1.invoke(n0.j(r4, r7), new h(r2, r0));
        return Unit.INSTANCE;
    }
}
