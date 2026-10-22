package com.obric.aiagent.messenger.stub;

import com.larus.im.bean.message.Message;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class s0 implements Function1 {
    public final /* synthetic */ String a;

    public /* synthetic */ s0(String r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        return MessageIDLStub.h(this.a, (Message) r2);
    }
}
