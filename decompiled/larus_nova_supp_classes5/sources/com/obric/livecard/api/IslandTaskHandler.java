package com.obric.livecard.api;

import android.os.Handler;
import android.os.HandlerThread;
import com.obric.livecard.api.utils.GlobalCommonUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001'BB\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00120\u0010\u0004\u001a,\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\b0\u0005ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fH\u0002J\u0006\u0010\u0018\u001a\u00020\bJL\u0010\u0019\u001a\u00020\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u00162\u001c\u0010\u001c\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u001dJO\u0010\u001e\u001a\u00020\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u00162\u001c\u0010\u001c\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJl\u0010 \u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00162\u001c\u0010\u001c\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00062\"\u0010!\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\"H\u0002ø\u0001\u0000¢\u0006\u0002\u0010#J\u0018\u0010$\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u0010H\u0002J\u000e\u0010&\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R;\u0010\u0004\u001a,\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lcom/obric/livecard/api/IslandTaskHandler;", "", "handlerThreadName", "", "blockRunner", "Lkotlin/Function2;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "aliveSession", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "pendingGroupMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/livecard/api/IslandTaskHandler$IslandTask;", "taskHandler", "Landroid/os/Handler;", "taskThread", "Landroid/os/HandlerThread;", "cancelGroup", "", "sessionId", "destroy", "enqueue", "markAlive", "markDead", "block", "(Ljava/lang/Long;ZZLkotlin/jvm/functions/Function1;)V", "enqueueAndAwait", "(Ljava/lang/Long;ZZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "makeTask", "onFinished", "Lkotlin/Function3;", "(Ljava/lang/Long;ZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Lcom/obric/livecard/api/IslandTaskHandler$IslandTask;", "removeFromGroup", "task", "shouldSkipDestroy", "IslandTask", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IslandTaskHandler {
    private final CopyOnWriteArrayList<Long> aliveSession;
    private final Function2<Function1<? super Continuation<? super Unit>, ? extends Object>, String, Unit> blockRunner;
    private final ConcurrentHashMap<Long, List<IslandTask>> pendingGroupMap;
    private final Handler taskHandler;
    private final HandlerThread taskThread;

    public final void destroy() {
        this.taskHandler.removeCallbacksAndMessages(null);     // Catch: Exception -> L4
        this.pendingGroupMap.clear();     // Catch: Exception -> L4
        this.aliveSession.clear();     // Catch: Exception -> L4
        this.taskThread.quitSafely();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getAliveSession$p(IslandTaskHandler r0) {
        return r0.aliveSession;
    }

    public static final /* synthetic */ Function2 access$getBlockRunner$p(IslandTaskHandler r0) {
        return r0.blockRunner;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getPendingGroupMap$p(IslandTaskHandler r0) {
        return r0.pendingGroupMap;
    }

    public static final /* synthetic */ Handler access$getTaskHandler$p(IslandTaskHandler r0) {
        return r0.taskHandler;
    }

    private final boolean cancelGroup(long r6) {
        List<IslandTask> r7 = this.pendingGroupMap.remove(Long.valueOf(r6));
        boolean r8 = false;
        if (r7 != null) goto L5;
        return false;
    L5:
        monitor-enter(r7);
        List<IslandTask> r0 = r7;     // Catch: Throwable -> L23
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));     // Catch: Throwable -> L23
        Iterator<T> r2 = r0.iterator();     // Catch: Throwable -> L23
    L8:
        if (r2.hasNext() == false) goto L14;
        Runnable r3 = (IslandTask) r2.next();     // Catch: Throwable -> L23
        boolean r4 = r3.cancel();     // Catch: Throwable -> L23
        if (r4 == false) goto L12;
        this.taskHandler.removeCallbacks(r3);     // Catch: Throwable -> L23
    L12:
        r1.add(Boolean.valueOf(r4));     // Catch: Throwable -> L23
        goto L8
    L14:
        if (r1.isEmpty() == false) goto L16;
    L15:
        r8 = true;
    L21:
        monitor-exit(r7);
        return r8;
    L16:
        Iterator r5 = r1.iterator();     // Catch: Throwable -> L23
    L17:
        if (r5.hasNext() == false) goto L15;
        if (((Boolean) r5.next()).booleanValue() == true) goto L17;
    L23:
        th = move-exception;
        throw th;
    }

    public final boolean shouldSkipDestroy(long r2) {
        if (cancelGroup(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.aliveSession.contains(Long.valueOf(r2)) == true) goto L7;
        return true;
    }

    public IslandTaskHandler(String r2, Function2<? super Function1<? super Continuation<? super Unit>, ? extends Object>, ? super String, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "handlerThreadName");
        Intrinsics.checkNotNullParameter(r3, "blockRunner");
        this.blockRunner = r3;
        PthreadHandlerThreadV2 r4 = new PthreadHandlerThreadV2(r2);
        ThreadMethodProxy.start(r4);
        this.taskThread = r4;
        this.taskHandler = new Handler(r4.getLooper());
        this.pendingGroupMap = new ConcurrentHashMap();
        this.aliveSession = new CopyOnWriteArrayList();
    }

    private final void removeFromGroup(long r3, IslandTask r5) {
        List<IslandTask> r0 = this.pendingGroupMap.get(Long.valueOf(r3));
        if (r0 != null) goto L5;
        return;
    L5:
        monitor-enter(r0);
        r0.remove(r5);     // Catch: Throwable -> L12
        if (r0.isEmpty() == false) goto L9;
        this.pendingGroupMap.remove(Long.valueOf(r3), r0);     // Catch: Throwable -> L12
    L9:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ void access$removeFromGroup(IslandTaskHandler r0, long r1, IslandTask r3) {
        r0.removeFromGroup(r1, r3);
    }

    public final void enqueue(Long r8, boolean r9, boolean r10, Function1<? super Continuation<? super Unit>, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r11, "block");
        IslandTask r12 = makeTask(r8, r9, r10, r11, null);
        if (r8 != null) goto L5;
    L20:
        this.taskHandler.post(r12);
        return;
    L5:
        if (r8.longValue() <= 0) goto L20;
        ConcurrentHashMap<Long, List<IslandTask>> r13 = this.pendingGroupMap;
        List<IslandTask> r14 = r13.get(r8);
        if (r14 != null) goto L12;
        r14 = Collections.synchronizedList(new ArrayList());
        List<IslandTask> r15 = r13.putIfAbsent(r8, r14);
        if (r15 == null) goto L12;
        r14 = r15;
    L12:
        List<IslandTask> r16 = r14;
        monitor-enter(r16);
        r16.add(r12);     // Catch: Throwable -> L17
        monitor-exit(r16);
    L17:
        th = move-exception;
        throw th;
    }

    private final IslandTask makeTask(Long r12, boolean r13, boolean r14, Function1<? super Continuation<? super Unit>, ? extends Object> r15, Function3<? super Long, ? super IslandTask, ? super Boolean, Unit> r16) {
        String r10 = GlobalCommonUtils.getThreadStackInfo$default(GlobalCommonUtils.INSTANCE, 0, 1, null);
        makeTask.finishedCallback.1 r0 = new makeTask.finishedCallback.1(this, r16);
        return new IslandTask(r12, new makeTask.1(r12, r13, this, r14, r15, r10), r0);
    }

    public final Object enqueueAndAwait(Long r10, boolean r11, boolean r12, Function1<? super Continuation<? super Unit>, ? extends Object> r13, Continuation<? super Unit> r14) {
        j r0 = new j(IntrinsicsKt.intercepted(r14), 1);
        r0.C();
        Runnable r15 = access$makeTask(this, r10, r11, r12, r13, new enqueueAndAwait.2.task.1(new AtomicBoolean(false), r0));
        if (r10 != null) goto L5;
    L20:
        r0.i(new enqueueAndAwait.2.2(r15, this, r10));
        access$getTaskHandler$p(this).post(r15);
        Object r16 = r0.B();
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L24;
        DebugProbesKt.probeCoroutineSuspended(r14);
    L24:
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        return r16;
    L27:
        return Unit.INSTANCE;
    L5:
        if (r10.longValue() <= 0) goto L20;
        ConcurrentHashMap r17 = access$getPendingGroupMap$p(this);
        Object r18 = r17.get(r10);
        if (r18 != null) goto L12;
        r18 = Collections.synchronizedList(new ArrayList());
        Object r19 = r17.putIfAbsent(r10, r18);
        if (r19 == null) goto L12;
        r18 = r19;
    L12:
        List r110 = (List) r18;
        monitor-enter(r110);
        r110.add(r15);     // Catch: Throwable -> L17
        monitor-exit(r110);
    L17:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ IslandTask access$makeTask(IslandTaskHandler r0, Long r1, boolean r2, boolean r3, Function1 r4, Function3 r5) {
        return r0.makeTask(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void enqueue$default(IslandTaskHandler r1, Long r2, boolean r3, boolean r4, Function1 r5, int r6, Object r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r6 & 4) == 0) goto L11;
        r4 = false;
    L11:
        r1.enqueue(r2, r3, r4, r5);
    }

    public static /* synthetic */ Object enqueueAndAwait$default(IslandTaskHandler r6, Long r7, boolean r8, boolean r9, Function1 r10, Continuation r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = null;
    L5:
        Long r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        boolean r2 = false;
    L10:
        if ((r12 & 4) == 0) goto L12;
        boolean r3 = false;
    L14:
        return r6.enqueueAndAwait(r1, r2, r3, r10, r11);
    L12:
        r3 = r9;
        goto L14
    L8:
        r2 = r8;
        goto L10
    }
}
