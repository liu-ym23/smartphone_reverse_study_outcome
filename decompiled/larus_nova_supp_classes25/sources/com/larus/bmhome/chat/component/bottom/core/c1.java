package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatControlTraceService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class c1 implements Function0 {
    public final /* synthetic */ CoreInputAbility a;

    public /* synthetic */ c1(CoreInputAbility r1) {
        this.a = r1;
    }

    public final Object invoke() {
        CoreInputAbility r0 = this.a;
        com.larus.bmhome.chat.component.list.u7 r1 = r0.A().u3();
        if (r1 == null) goto L15;
        MessageAdapter r2 = r1.MF();
        if (r2 == null) goto L15;
        Message r3 = r2.I2();
        if (r3 == null) goto L15;
        IAIChatControlTraceService.Companion r4 = IAIChatControlTraceService.a;
        Object r5 = r0.f.ni();
        if ((r5 instanceof String) == false) goto L12;
        String r6 = (String) r5;
    L13:
        r4.lb(r3, r6);
        ICoreInputAbility.b.a(r0, 3);
        return Unit.INSTANCE;
    L12:
        r6 = null;
    L15:
        return Unit.INSTANCE;
    }
}
