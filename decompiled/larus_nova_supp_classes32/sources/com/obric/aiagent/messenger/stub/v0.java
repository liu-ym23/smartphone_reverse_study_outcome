package com.obric.aiagent.messenger.stub;

import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class v0 implements Function1 {
    public final /* synthetic */ MessageIDLStub a;
    public final /* synthetic */ Map b;

    public /* synthetic */ v0(MessageIDLStub r1, Map r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r3) {
        return MessageIDLStub.e(this.a, this.b, (Message) r3);
    }
}
