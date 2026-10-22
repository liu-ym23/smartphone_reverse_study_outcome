package com.obric.aiagent.messenger.stub;

import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class q0 implements Function1 {
    public final /* synthetic */ Map a;

    public /* synthetic */ q0(Map r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        return MessageIDLStub.g(this.a, (Message) r2);
    }
}
