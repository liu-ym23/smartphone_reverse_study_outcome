package com.obric.memorydata.task;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\r¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/task/TagLock;", "", "<init>", "()V", "TAG", "", "lockMap", "", "Ljava/util/concurrent/locks/ReentrantLock;", "withTagLock", ExifInterface.GPS_DIRECTION_TRUE, LocationMonitorConst.TAG, "action", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f12912a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, ReentrantLock> f12913b = null;

    static {
        f12912a = new d();
        f12913b = (Map) ZeusTransformUtils.preCheckCast(new ConcurrentHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    private d() {
    }

    public final <T> T a(String r10, Function0<? extends T> r11) {
        Function0 r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r11, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r9, "action");
        Map<String, ReentrantLock> r12 = f12913b;
        ReentrantLock r1 = r12.get(r10);
        if (r1 != null) goto L5;
        r1 = new ReentrantLock();
        r12.put(r10, r1);
    L5:
        ReentrantLock r2 = (ReentrantLock) ZeusTransformUtils.preCheckCast(r1, ReentrantLock.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TagLock", "LOCK BY : " + r2 + " TAG: " + r10, false, 4, null);
        Lock r0 = (Lock) ZeusTransformUtils.preCheckCast(r2, Lock.class, "com.obric.memorydata.plugin");
        r0.lock();
        T r13 = (T) r9.invoke();
    L8:
        if (r2.hasQueuedThreads() == true) goto L10;
        r12.remove(r10);     // Catch: Throwable -> L12
    L10:
        r0.unlock();
        return r13;
    L12:
        th = move-exception;
        r0.unlock();
        throw th;
    L14:
        th = move-exception;
        if (r2.hasQueuedThreads() == true) goto L18;
        f12913b.remove(r10);     // Catch: Throwable -> L12
    L18:
        throw th;     // Catch: Throwable -> L12
    }
}
