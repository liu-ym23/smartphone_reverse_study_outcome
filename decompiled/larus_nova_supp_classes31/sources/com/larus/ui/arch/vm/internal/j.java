package com.larus.ui.arch.vm.internal;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j {
    public static final Lazy a = null;

    public static final class a implements ThreadFactory {
        public final ThreadFactory a;

        public a() {
            this.a = Executors.defaultThreadFactory();
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r3) {
            Thread r4 = this.a.newThread(r3);
            ThreadMethodProxy.setName(r4, "ui-arch#" + r4.getName());
            Intrinsics.checkNotNull(r4);
            return r4;
        }
    }

    static {
        a = LazyKt.lazy(new i());
    }
}
