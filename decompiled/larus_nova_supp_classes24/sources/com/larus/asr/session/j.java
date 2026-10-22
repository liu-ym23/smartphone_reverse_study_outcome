package com.larus.asr.session;

import com.larus.im.bean.message.Message;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class j implements Function1 {
    public final /* synthetic */ ComponentAsrSession a;

    public /* synthetic */ j(ComponentAsrSession r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        ComponentAsrSession r0 = this.a;
        Message r4 = (Message) r3;
        Intrinsics.checkNotNullParameter(r4, "message");
        Iterator<T> r1 = r0.d().iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        ((com.larus.asr.session.component.o0) r1.next()).j(r4);
        goto L4
    L7:
        return Unit.INSTANCE;
    }
}
