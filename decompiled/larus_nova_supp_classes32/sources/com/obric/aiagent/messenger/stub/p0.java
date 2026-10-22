package com.obric.aiagent.messenger.stub;

import com.larus.im.bean.message.Message;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class p0 implements Function1 {
    public final /* synthetic */ IMMessage a;
    public final /* synthetic */ MessageIDLStub b;

    public /* synthetic */ p0(IMMessage r1, MessageIDLStub r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r3) {
        return MessageIDLStub.d(this.a, this.b, (Message) r3);
    }
}
