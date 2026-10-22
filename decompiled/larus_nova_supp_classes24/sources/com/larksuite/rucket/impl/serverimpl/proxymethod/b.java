package com.larksuite.rucket.impl.serverimpl.proxymethod;

import com.bytedance.lark.sdk.StreamDataSource;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.rucket.impl.base.request.BaseCallProxyMethod;
import com.larksuite.rucket.impl.serverimpl.annotation.ServerCall;
import com.squareup.wire.Message;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.sdk.h;
import g38.c;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b extends BaseCallProxyMethod<ServerCall> {
    public final int d;

    @Override // com.larksuite.rucket.core.proxymethod.BaseProxyMethod
    public final Class<ServerCall> b() {
        return ServerCall.class;
    }

    public b(Method r2) {
        Intrinsics.checkNotNullParameter(r2, "origin");
        super(r2);
        this.d = ((ServerCall) c()).value();
    }

    @Override // com.larksuite.rucket.impl.base.request.BaseCallProxyMethod
    public final void f(Message r1, IGetDataCallback r2, String r3, c r4, StreamDataSource r5, h r6) {
        Intrinsics.checkNotNullParameter(r1, "request");
        Intrinsics.checkNotNullParameter(r2, "callback");
        Intrinsics.checkNotNullParameter(r3, "contextId");
        Intrinsics.checkNotNullParameter(r4, "parser");
        Intrinsics.checkNotNullParameter(r6, "params");
        SdkSender.sendPassThroughRequest(Command.fromValue(this.d), r1, r2, r4, r6);
    }
}
