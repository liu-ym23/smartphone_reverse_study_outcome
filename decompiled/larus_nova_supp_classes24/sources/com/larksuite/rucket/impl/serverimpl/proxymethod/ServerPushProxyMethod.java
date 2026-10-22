package com.larksuite.rucket.impl.serverimpl.proxymethod;

import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.rucket.core.proxymethod.BaseProxyMethod;
import com.larksuite.rucket.impl.serverimpl.annotation.ServerPush;
import com.larksuite.rucket.job.compat.CallbackCompatRucketJob;
import com.ss.android.lark.pb.improto.Command;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class ServerPushProxyMethod extends BaseProxyMethod<ServerPush> {
    public final int d;

    @Override // com.larksuite.rucket.core.proxymethod.BaseProxyMethod
    public final Class<ServerPush> b() {
        return ServerPush.class;
    }

    public ServerPushProxyMethod(Method r2) {
        Intrinsics.checkNotNullParameter(r2, "origin");
        super(r2);
        this.d = c().value();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.larksuite.rucket.core.proxymethod.b
    public final void a(IGetDataCallback<?> r4, Object... r5) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "args");
        if ((r4 instanceof CallbackCompatRucketJob) == false) goto L10;
        final Command r6 = Command.fromValue(this.d);
        ConcurrentHashMap<Object, com.larksuite.rucket.impl.base.push.a<?>> r0 = com.larksuite.rucket.impl.base.push.b.a;
        Intrinsics.checkNotNull(r6);
        com.larksuite.rucket.impl.base.push.a r7 = com.larksuite.rucket.impl.base.push.b.a(r6, new ServerPushProxyMethod$invokeWithCallback$1(r6, this));
        CallbackCompatRucketJob r8 = (CallbackCompatRucketJob) r4;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "rucketJob");
        if (r7.c.compareAndSet(false, true) == false) goto L7;
        r7.b();
    L7:
        r8.setPrevJob(r7);
        r7.b.add(r8);
        return;
    L10:
        throw new BaseProxyMethod.GenerateProxyMethodError("Arguments Error! Callback should be subclass of CallbackCompactJob");
    }
}
