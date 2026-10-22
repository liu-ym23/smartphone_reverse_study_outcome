package com.larksuite.rucket.impl.sdkimpl.proxymethod;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.sdk.StreamDataSource;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.rucket.impl.base.request.BaseCallProxyMethod;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkCall;
import com.squareup.wire.Message;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.sdk.h;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b extends BaseCallProxyMethod<SdkCall> {
    public final int d;

    @Override // com.larksuite.rucket.core.proxymethod.BaseProxyMethod
    public final Class<SdkCall> b() {
        return SdkCall.class;
    }

    public b(Method r2) {
        Intrinsics.checkNotNullParameter(r2, "origin");
        super(r2);
        this.d = ((SdkCall) c()).value();
    }

    @Override // com.larksuite.rucket.impl.base.request.BaseCallProxyMethod
    public final void f(Message r10, IGetDataCallback r11, String r12, g38.c r13, StreamDataSource r14, h r15) {
        Intrinsics.checkNotNullParameter(r10, "request");
        Intrinsics.checkNotNullParameter(r11, "callback");
        Intrinsics.checkNotNullParameter(r12, "contextId");
        Intrinsics.checkNotNullParameter(r13, "parser");
        Intrinsics.checkNotNullParameter(r15, "params");
        SdkSender.asynSendRequestNonWrap(Command.fromValue(this.d), r10.encode(), r11, false, r12, r13, r14, r15);
    }
}
