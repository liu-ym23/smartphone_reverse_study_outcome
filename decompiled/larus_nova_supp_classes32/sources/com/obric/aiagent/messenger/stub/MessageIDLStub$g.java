package com.obric.aiagent.messenger.stub;

import bda.b$a;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class MessageIDLStub$g implements bda.b {
    public final /* synthetic */ String a;
    public final /* synthetic */ Map<Object, Object> b;

    public final String getScene() {
        return this.a;
    }

    public MessageIDLStub$g(String r1, Map<Object, Object> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Map<String, String> getExt(Map<String, String> r1, b$a r2) {
        Intrinsics.checkNotNullParameter(r1, "originExt");
        return com.obric.aiagent.ipc.utils.d.b(this.b);
    }
}
