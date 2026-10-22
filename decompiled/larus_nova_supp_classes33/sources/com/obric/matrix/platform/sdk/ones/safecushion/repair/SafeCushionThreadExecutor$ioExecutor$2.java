package com.obric.matrix.platform.sdk.ones.safecushion.repair;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class SafeCushionThreadExecutor$ioExecutor$2 extends Lambda implements Function0<ExecutorService> {
    public static final SafeCushionThreadExecutor$ioExecutor$2 INSTANCE = null;

    public static final class a implements ThreadFactory {
        public final AtomicInteger a;

        public a() {
            this.a = new AtomicInteger(0);
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r4) {
            Intrinsics.checkNotNullParameter(r4, "r");
            return new PthreadThreadV2(r4, "SafeCushionRepairThread-" + this.a.incrementAndGet());
        }
    }

    static {
        INSTANCE = new SafeCushionThreadExecutor$ioExecutor$2();
    }

    public SafeCushionThreadExecutor$ioExecutor$2() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final ExecutorService m66invoke() {
        return PThreadExecutorsUtils.newSingleThreadExecutor(new a());
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m66invoke();
    }
}
