package com.obric.aee.impl.loop;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.concurrent.ThreadsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH$J\b\u0010\u0010\u001a\u00020\u000fH$J\u0006\u0010\u0011\u001a\u00020\u000fJ%\u0010\u0012\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0015H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\n\u0010\u0014\u001a\u00060\nj\u0002`\u000bH\u0002J\u0006\u0010\u0019\u001a\u00020\u000fJ\u0014\u0010\u001a\u001a\u00020\u00182\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\f\u0012\b\u0012\u00060\nj\u0002`\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/obric/aee/impl/loop/TaskQueueThread;", "", ActivityLifecycle.NAME, "", "(Ljava/lang/String;)V", "TAG", "running", "Ljava/util/concurrent/atomic/AtomicBoolean;", "taskQueue", "Ljava/util/concurrent/BlockingQueue;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "workerThread", "Ljava/lang/Thread;", "active", "", "idle", "join", Constants.LAUNCH_TAG, ExifInterface.GPS_DIRECTION_TRUE, "task", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pushTask", "", "shutdown", LocationMonitorConst.SUBMIT, "Aee_cryptLiteRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BlockingQueue<Runnable> f5889b;
    private final AtomicBoolean c;
    private final Thread d;

    public a(final String r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        this.f5888a = "TaskQueueThread";
        this.f5889b = (BlockingQueue) ZeusTransformUtils.preCheckCast(new LinkedBlockingQueue(), BlockingQueue.class, "com.obric.memorydata.plugin");
        this.c = new AtomicBoolean(true);
        this.d = ThreadsKt.thread$default(true, false, null, r10, 0, (Function0) ZeusTransformUtils.preCheckCast(new TaskQueueThread$workerThread$1(r10, this), Function0.class, "com.obric.memorydata.plugin"), 22, null);
    }

    public static final /* synthetic */ BlockingQueue a(a r0) {
        return r0.f5889b;
    }

    private static final void a(w r2, Function0 r3) {
        w r4 = (w) ZeusTransformUtils.wrapperContextForParams(r2, w.class, "com.obric.memorydata.plugin");
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "$deferred");
        Intrinsics.checkNotNullParameter(r5, "$task");
        r4.a(r5.invoke());     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r4.a(th);
    }

    private final boolean a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (this.c.get() == false) goto L6;
        this.f5889b.offer(r4);
        a();
        return true;
    L6:
        return false;
    }

    public static final /* synthetic */ AtomicBoolean b(a r0) {
        return r0.c;
    }

    public static /* synthetic */ void lambda$LUuKPhPFWPEptBMi6dVEKyZHurY(w r0, Function0 r1) {
        a(r0, r1);
    }

    public final <T> Object a(Function0<? extends T> r3, Continuation<? super T> r4) {
        final Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Continuation<? super T> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        final w r0 = y.a(null, 1, null);
        a(new $$Lambda$a$LUuKPhPFWPEptBMi6dVEKyZHurY(r0, r5));
        return r0.a(r6);
    }

    public abstract void a();

    public abstract void b();
}
