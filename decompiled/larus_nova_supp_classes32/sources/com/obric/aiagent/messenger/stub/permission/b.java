package com.obric.aiagent.messenger.stub.permission;

import com.larus.im.bean.message.Message;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class b implements Function1 {
    public final /* synthetic */ boolean a;

    public /* synthetic */ b(boolean r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        return FlowPermissionIDLStub.a(this.a, (Message) r2);
    }
}
