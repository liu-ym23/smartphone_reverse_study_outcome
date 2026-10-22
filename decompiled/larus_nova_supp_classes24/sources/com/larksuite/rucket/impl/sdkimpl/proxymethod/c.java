package com.larksuite.rucket.impl.sdkimpl.proxymethod;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.rustclient.api.l;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.rucket.core.proxymethod.BaseProxyMethod;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkPush;
import com.larksuite.rucket.job.compat.CallbackCompatRucketJob;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c extends BaseProxyMethod<SdkPush> {
    public final l d;
    public final int e;

    @Override // com.larksuite.rucket.core.proxymethod.BaseProxyMethod
    public final Class<SdkPush> b() {
        return SdkPush.class;
    }

    public c(l r2, Method r3) {
        Intrinsics.checkNotNullParameter(r2, "client");
        Intrinsics.checkNotNullParameter(r3, "origin");
        super(r3);
        this.d = r2;
        this.e = c().value();
    }

    @Override // com.larksuite.rucket.core.proxymethod.b
    public final void a(IGetDataCallback<?> r4, Object... r5) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "args");
        if ((r4 instanceof CallbackCompatRucketJob) == false) goto L7;
        new e38.b(Command.fromValue(this.e), e(), this.d, (CallbackCompatRucketJob) r4);
        return;
    L7:
        throw new BaseProxyMethod.GenerateProxyMethodError("Arguments Error! Callback should be subclass of CallbackCompactRucketJob");
    }
}
