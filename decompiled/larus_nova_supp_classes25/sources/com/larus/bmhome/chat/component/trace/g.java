package com.larus.bmhome.chat.component.trace;

import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class g implements Function0 {
    public final /* synthetic */ ChatScreenRecordTraceComponent a;

    public /* synthetic */ g(ChatScreenRecordTraceComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ChatScreenRecordTraceComponent r0 = this.a;
        IChatMessageShareAbility r1 = (IChatMessageShareAbility) r0.j.getValue();
        if (r1 == null) goto L10;
        u7 r2 = (u7) r0.h.getValue();
        if (r2 == null) goto L7;
        MessageAdapter r3 = r2.MF();
    L8:
        r1.S00(r3);
        goto L10
    L7:
        r3 = null;
    L10:
        return Unit.INSTANCE;
    }
}
