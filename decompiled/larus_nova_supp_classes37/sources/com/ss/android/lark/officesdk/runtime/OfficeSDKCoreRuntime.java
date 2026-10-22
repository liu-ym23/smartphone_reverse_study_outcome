package com.ss.android.lark.officesdk.runtime;

import com.ss.android.lark.officesdk.api.init.IOfficeSDKRuntime;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSDKCoreRuntime implements IOfficeSDKRuntime {
    public static final Lazy<OfficeSerialThreadExecutor> a = null;
    public static final Lazy<OfficeSerialThreadExecutor> b = null;

    public static final class OfficeSerialThreadExecutor implements c {
        public final Lazy a;

        public OfficeSerialThreadExecutor(final int r3) {
            this.a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new OfficeSDKCoreRuntime$OfficeSerialThreadExecutor$executor$2(r3));
        }
    }

    public static final class a {
    }

    public static final class b implements ThreadFactory {
        public final int a;
        public final ThreadFactory b;

        public b(int r1) {
            this.a = r1;
            this.b = Executors.defaultThreadFactory();
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r2) {
            Thread r3 = this.b.newThread(r2);
            ThreadMethodProxy.setPriority(r3, this.a);
            ThreadMethodProxy.setName(r3, "OfficeSDK_CoreRuntime");
            return r3;
        }
    }

    public interface c {
    }

    static {
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.SYNCHRONIZED;
        a = LazyKt.lazy(r0, OfficeSDKCoreRuntime$Companion$highPriorityExecutor$2.INSTANCE);
        b = LazyKt.lazy(r0, OfficeSDKCoreRuntime$Companion$normalPriorityExecutor$2.INSTANCE);
    }
}
