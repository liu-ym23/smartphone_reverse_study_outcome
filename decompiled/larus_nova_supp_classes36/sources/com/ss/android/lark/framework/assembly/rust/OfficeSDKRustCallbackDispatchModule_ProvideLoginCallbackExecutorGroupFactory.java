package com.ss.android.lark.framework.assembly.rust;

import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeSDKRustCallbackDispatchModule_ProvideLoginCallbackExecutorGroupFactory implements Factory<com.bytedance.lark.rustclient.api.o> {

    public static final class a {
        public static final OfficeSDKRustCallbackDispatchModule_ProvideLoginCallbackExecutorGroupFactory a = null;

        static {
            a = new OfficeSDKRustCallbackDispatchModule_ProvideLoginCallbackExecutorGroupFactory();
        }
    }

    public OfficeSDKRustCallbackDispatchModule_ProvideLoginCallbackExecutorGroupFactory() {
    }

    public static com.bytedance.lark.rustclient.api.o provideLoginCallbackExecutorGroup() {
        q r0 = q.a;
        r0.getClass();
        PThreadPoolExecutor r9 = new PThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.larksuite.framework.thread.n("office-sdk-login-callback"));
        r9.allowCoreThreadTimeOut(true);
        StringBuilder r1 = new StringBuilder("register login callback executor group, commands=");
        Set<Integer> r2 = q.b;
        r1.append(r2.size());
        Log.i("OfficeSDKRustCallback", r1.toString());
        return (com.bytedance.lark.rustclient.api.o) Preconditions.checkNotNullFromProvides(new com.bytedance.lark.rustclient.api.o(r2, r9, new OfficeSDKRustCallbackDispatchModule$provideLoginCallbackExecutorGroup$1(r0)));
    }

    public com.bytedance.lark.rustclient.api.o get() {
        return provideLoginCallbackExecutorGroup();
    }

    public static OfficeSDKRustCallbackDispatchModule_ProvideLoginCallbackExecutorGroupFactory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m684get() {
        return get();
    }
}
