package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.component.bottom.reference.a;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class r0 implements Function1 {
    public final /* synthetic */ ChatListComponent a;
    public final /* synthetic */ List b;
    public final /* synthetic */ Function0 c;

    public /* synthetic */ r0(ChatListComponent r1, List r2, Function0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r6) {
        ChatListComponent r0 = this.a;
        List r1 = this.b;
        Function0 r2 = this.c;
        boolean r7 = ((Boolean) r6).booleanValue();
        Iterator r3 = r0.P1.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        te8.c r4 = (te8.c) r3.next();
        if (r4 == null) goto L4;
        r4.v(r1);
        goto L4
    L8:
        if (r7 == false) goto L10;
        FLogger.a.w(r0.n, "delete message force refresh list");
        r0.C90();
    L10:
        Iterator r8 = r1.iterator();
    L12:
        if (r8.hasNext() == false) goto L16;
        Message r5 = (Message) r8.next();
        a r9 = (a) r0.T2.getValue();
        if (r9 == null) goto L12;
        r9.xo(r5, false);
        goto L12
    L16:
        if (r2 == null) goto L19;
        r2.invoke();
    L19:
        return Unit.INSTANCE;
    }
}
