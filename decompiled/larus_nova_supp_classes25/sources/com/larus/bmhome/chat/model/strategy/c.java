package com.larus.bmhome.chat.model.strategy;

import com.larus.bmhome.chat.model.repo.ChatSender;
import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class c implements Function1 {
    public final /* synthetic */ ChatRetryStrategy a;
    public final /* synthetic */ Message b;

    public /* synthetic */ c(ChatRetryStrategy r1, Message r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r7) {
        ChatRetryStrategy r0 = this.a;
        Message r1 = this.b;
        mr9.k r8 = (mr9.k) r7;
        Intrinsics.checkNotNullParameter(r8, "it");
        Long r9 = r8.a;
        if (r9 == null) goto L9;
        ChatSender r2 = r0.a.e;
        String r3 = r1.getLocalMessageId();
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        r2.O(r3, r9.longValue() / ((long) 2));
    L9:
        return Unit.INSTANCE;
    }
}
