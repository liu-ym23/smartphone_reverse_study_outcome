package com.obric.capabilitykit.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bo;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/obric/capabilitykit/entity/EntityThreadContainer;", "", "()V", "Companion", "CustomThreadFactory", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityThreadContainer {
    public static final Companion Companion = null;
    private static final int corePoolSize = 0;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/EntityThreadContainer$Companion;", "", "()V", "corePoolSize", "", "getScope", "Lkotlinx/coroutines/CoroutineScope;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final al getScope() {
            return am.a(bo.a(new ThreadPoolExecutor(EntityThreadContainer.access$getCorePoolSize$cp(), 50, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(300), new a(""))));
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/capabilitykit/entity/EntityThreadContainer$CustomThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "prefix", "", "(Ljava/lang/String;)V", "group", "Ljava/lang/ThreadGroup;", "threadNamePrefix", "threadNumber", "Ljava/util/concurrent/atomic/AtomicInteger;", "newThread", "Ljava/lang/Thread;", "r", "Ljava/lang/Runnable;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ThreadGroup f7537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f7538b;
        private AtomicInteger c;

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "prefix");
            this.f7538b = r2;
            this.c = new AtomicInteger(1);
            SecurityManager r3 = System.getSecurityManager();
            if (r3 == null) goto L5;
            ThreadGroup r4 = r3.getThreadGroup();
        L6:
            this.f7537a = r4;
            return;
        L5:
            r4 = Thread.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r7) {
            Runnable r2 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.memorydata.plugin");
            StringBuilder r8 = new StringBuilder().append(this.f7538b).append('-');
            AtomicInteger r0 = this.c;
            Intrinsics.checkNotNull(r0);
            String r3 = r8.append(r0.getAndIncrement()).toString();
            Thread r9 = new Thread(this.f7537a, r2, r3, 0);
            if (r9.isDaemon() == false) goto L5;
            r9.setDaemon(false);
        L5:
            return r9;
        }
    }

    static {
        Companion = new Companion(null);
        corePoolSize = Runtime.getRuntime().availableProcessors() + 1;
    }

    public EntityThreadContainer() {
    }

    public static final /* synthetic */ int access$getCorePoolSize$cp() {
        return corePoolSize;
    }
}
