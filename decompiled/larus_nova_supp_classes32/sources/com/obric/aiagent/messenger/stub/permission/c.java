package com.obric.aiagent.messenger.stub.permission;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class c implements Function1 {
    public final /* synthetic */ FlowPermissionIDLStub a;
    public final /* synthetic */ String b;

    public /* synthetic */ c(FlowPermissionIDLStub r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r3) {
        return FlowPermissionIDLStub.b(this.a, this.b, ((Boolean) r3).booleanValue());
    }
}
