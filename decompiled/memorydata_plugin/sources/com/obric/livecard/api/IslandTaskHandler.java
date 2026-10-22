package com.obric.livecard.api;

import android.os.Handler;
import android.os.HandlerThread;
import android.security.obric.guard.ObricSecurityGuardStub;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.livecard.api.utils.GlobalCommonUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001'BB\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00120\u0010\u0004\u001a,\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\b0\u0005ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fH\u0002J\u0006\u0010\u0018\u001a\u00020\bJL\u0010\u0019\u001a\u00020\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u00162\u001c\u0010\u001c\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u001dJO\u0010\u001e\u001a\u00020\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u00162\u001c\u0010\u001c\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJl\u0010 \u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00162\u001c\u0010\u001c\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00062\"\u0010!\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\"H\u0002ø\u0001\u0000¢\u0006\u0002\u0010#J\u0018\u0010$\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u0010H\u0002J\u000e\u0010&\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R;\u0010\u0004\u001a,\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lcom/obric/livecard/api/IslandTaskHandler;", "", "handlerThreadName", "", "blockRunner", "Lkotlin/Function2;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "aliveSession", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "pendingGroupMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/livecard/api/IslandTaskHandler$IslandTask;", "taskHandler", "Landroid/os/Handler;", "taskThread", "Landroid/os/HandlerThread;", "cancelGroup", "", ObricMemoryConstants.KEY_SESSION_ID, "destroy", "enqueue", "markAlive", "markDead", "block", "(Ljava/lang/Long;ZZLkotlin/jvm/functions/Function1;)V", "enqueueAndAwait", "(Ljava/lang/Long;ZZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "makeTask", "onFinished", "Lkotlin/Function3;", "(Ljava/lang/Long;ZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Lcom/obric/livecard/api/IslandTaskHandler$IslandTask;", "removeFromGroup", "task", "shouldSkipDestroy", "IslandTask", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IslandTaskHandler {
    private final CopyOnWriteArrayList<Long> aliveSession;
    private final Function2<Function1<? super Continuation<? super Unit>, ? extends Object>, String, Unit> blockRunner;
    private final ConcurrentHashMap<Long, List<IslandTask>> pendingGroupMap;
    private final Handler taskHandler;
    private final HandlerThread taskThread;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001BE\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012$\b\u0002\u0010\u0007\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u0006\u0010\u0013\u001a\u00020\tJ\b\u0010\u0014\u001a\u00020\u0006H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR*\u0010\u0007\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/obric/livecard/api/IslandTaskHandler$IslandTask;", "Ljava/lang/Runnable;", ObricMemoryConstants.KEY_SESSION_ID, "", "block", "Lkotlin/Function0;", "", "onFinished", "Lkotlin/Function3;", "", "(Ljava/lang/Long;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)V", "cancelled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "finished", "isRunning", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "getSessionId", "()Ljava/lang/Long;", "Ljava/lang/Long;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "run", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class IslandTask implements Runnable {
        private final Function0<Unit> block;
        private final AtomicBoolean cancelled;
        private final AtomicBoolean finished;
        private final AtomicBoolean isRunning;
        private final Function3<Long, IslandTask, Boolean, Unit> onFinished;
        private final Long sessionId;

        public IslandTask(Long r3, Function0<Unit> r4, Function3<? super Long, ? super IslandTask, ? super Boolean, Unit> r5) {
            Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
            Function3<Long, IslandTask, Boolean, Unit> r7 = (Function3) ZeusTransformUtils.wrapperContextForParams(r5, Function3.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "block");
            this.sessionId = r3;
            this.block = r6;
            this.onFinished = r7;
            this.cancelled = new AtomicBoolean(false);
            this.finished = new AtomicBoolean(false);
            this.isRunning = new AtomicBoolean(false);
        }

        public /* synthetic */ IslandTask(Long r2, Function0 r3, Function3 r4, int r5, DefaultConstructorMarker r6) {
            Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
            Function3 r8 = (Function3) ZeusTransformUtils.wrapperContextForParams(r4, Function3.class, "com.obric.memorydata.plugin");
            if ((r5 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r5 & 4) == 0) goto L8;
            r8 = null;
        L8:
            this(r2, r7, r8);
        }

        public final boolean cancel() {
            if (this.isRunning.get() == false) goto L5;
            return false;
        L5:
            this.cancelled.compareAndSet(false, true);
            if (this.finished.compareAndSet(false, true) == false) goto L11;
            Function3<Long, IslandTask, Boolean, Unit> r0 = this.onFinished;
            if (r0 == null) goto L10;
            r0.invoke(this.sessionId, this, true);
        L10:
            return true;
        L11:
            return false;
        }

        public final Long getSessionId() {
            return this.sessionId;
        }

        public final AtomicBoolean isRunning() {
            return this.isRunning;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.isRunning.compareAndSet(false, true);     // Catch: Throwable -> L11
            if (this.cancelled.get() == true) goto L7;
            this.block.invoke();     // Catch: Throwable -> L11
        L7:
            if (this.finished.compareAndSet(false, true) == false) goto L16;
            Function3<Long, IslandTask, Boolean, Unit> r0 = this.onFinished;
            if (r0 == null) goto L19;
        L10:
            r0.invoke(this.sessionId, this, Boolean.valueOf(this.cancelled.get()));
            return;
        L19:
            return;
        L16:
            return;
        L12:
            if (this.finished.compareAndSet(false, true) == false) goto L21;
            r0 = this.onFinished;
            if (r0 != null) goto L10;
            return;
        }
    }

    public IslandTaskHandler(String r3, Function2<? super Function1<? super Continuation<? super Unit>, ? extends Object>, ? super String, Unit> r4) {
        Function2<Function1<? super Continuation<? super Unit>, ? extends Object>, String, Unit> r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "handlerThreadName");
        Intrinsics.checkNotNullParameter(r5, "blockRunner");
        this.blockRunner = r5;
        HandlerThread r6 = new HandlerThread(r3);
        r6.start();
        this.taskThread = r6;
        this.taskHandler = new Handler(r6.getLooper());
        this.pendingGroupMap = new ConcurrentHashMap();
        this.aliveSession = new CopyOnWriteArrayList();
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

    public static final /* synthetic */ IslandTask access$makeTask(IslandTaskHandler r8, Long r9, boolean r10, boolean r11, Function1 r12, Function3 r13) {
        return r8.makeTask(r9, r10, r11, (Function1) ZeusTransformUtils.wrapperContextForParams(r12, Function1.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.wrapperContextForParams(r13, Function3.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$removeFromGroup(IslandTaskHandler r0, long r1, IslandTask r3) {
        r0.removeFromGroup(r1, r3);
    }

    private final boolean cancelGroup(long r8) {
        List r9 = (List) ZeusTransformUtils.preCheckCast(this.pendingGroupMap.remove(Long.valueOf(r8)), List.class, "com.obric.memorydata.plugin");
        boolean r10 = false;
        if (r9 != null) goto L5;
        return false;
    L5:
        monitor-enter(r9);
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        Iterator r2 = r0.iterator();     // Catch: Throwable -> L27
    L8:
        if (r2.hasNext() == false) goto L13;
        IslandTask r3 = (IslandTask) ZeusTransformUtils.preCheckCast(r2.next(), IslandTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        boolean r4 = r3.cancel();     // Catch: Throwable -> L27
        if (r4 == false) goto L12;
        this.taskHandler.removeCallbacks((Runnable) ZeusTransformUtils.preCheckCast(r3, Runnable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L27
    L12:
        r1.add(Boolean.valueOf(r4));     // Catch: Throwable -> L27
        goto L8
    L13:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L16;
    L18:
        Iterator r11 = r7.iterator();     // Catch: Throwable -> L27
    L19:
        if (r11.hasNext() == false) goto L24;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r11.next(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L19;
    L25:
        monitor-exit(r9);
        return r10;
    L24:
        r10 = true;
        goto L25
    L16:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L18;
    L27:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void enqueue$default(IslandTaskHandler r1, Long r2, boolean r3, boolean r4, Function1 r5, int r6, Object r7) {
        Function1<? super Continuation<? super Unit>, ? extends Object> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r6 & 4) == 0) goto L11;
        r4 = false;
    L11:
        r1.enqueue(r2, r3, r4, r8);
    }

    public static /* synthetic */ Object enqueueAndAwait$default(IslandTaskHandler r7, Long r8, boolean r9, boolean r10, Function1 r11, Continuation r12, int r13, Object r14) {
        Function1<? super Continuation<? super Unit>, ? extends Object> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if ((r13 & 1) == 0) goto L5;
        r8 = null;
    L5:
        Long r2 = r8;
        if ((r13 & 2) == 0) goto L8;
        boolean r3 = false;
    L10:
        if ((r13 & 4) == 0) goto L12;
        boolean r4 = false;
    L14:
        return r7.enqueueAndAwait(r2, r3, r4, r5, r6);
    L12:
        r4 = r10;
        goto L14
    L8:
        r3 = r9;
        goto L10
    }

    private final IslandTask makeTask(final Long r10, final boolean r11, final boolean r12, Function1<? super Continuation<? super Unit>, ? extends Object> r13, Function3<? super Long, ? super IslandTask, ? super Boolean, Unit> r14) {
        final Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r13, Function1.class, "com.obric.memorydata.plugin");
        final Function3 r15 = (Function3) ZeusTransformUtils.wrapperContextForParams(r14, Function3.class, "com.obric.memorydata.plugin");
        final String r8 = GlobalCommonUtils.getThreadStackInfo$default(GlobalCommonUtils.INSTANCE, 0, 1, null);
        Function3 r16 = (Function3) ZeusTransformUtils.preCheckCast(new IslandTaskHandler$makeTask$finishedCallback$1(this, r15), Function3.class, "com.obric.memorydata.plugin");
        return new IslandTask(r10, (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r10, r11, this, r12, r7, r8), Function0.class, "com.obric.memorydata.plugin"), r16);
    }

    private final void removeFromGroup(long r4, IslandTask r6) {
        List r0 = (List) ZeusTransformUtils.preCheckCast(this.pendingGroupMap.get(Long.valueOf(r4)), List.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        monitor-enter(r0);
        r0.remove(r6);     // Catch: Throwable -> L12
        if (r0.isEmpty() == false) goto L9;
        this.pendingGroupMap.remove(Long.valueOf(r4), r0);     // Catch: Throwable -> L12
    L9:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
        return;
    L12:
        th = move-exception;
        throw th;
    }

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

    public final void enqueue(Long r7, boolean r8, boolean r9, Function1<? super Continuation<? super Unit>, ? extends Object> r10) {
        Function1<? super Continuation<? super Unit>, ? extends Object> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "block");
        IslandTask r11 = makeTask(r7, r8, r9, r4, null);
        if (r7 != null) goto L5;
    L20:
        this.taskHandler.post((Runnable) ZeusTransformUtils.preCheckCast(r11, Runnable.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        if (r7.longValue() <= 0) goto L20;
        ConcurrentMap r12 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(this.pendingGroupMap, ConcurrentMap.class, "com.obric.memorydata.plugin");
        Object r13 = r12.get(r7);
        if (r13 != null) goto L12;
        r13 = Collections.synchronizedList((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));
        Object r14 = r12.putIfAbsent(r7, r13);
        if (r14 == null) goto L12;
        r13 = r14;
    L12:
        List r15 = (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r15, Constants.KEY_LIST);
        monitor-enter(r15);
        r15.add(r11);     // Catch: Throwable -> L17
        monitor-exit(r15);
    L17:
        th = move-exception;
        throw th;
    }

    public final Object enqueueAndAwait(final Long r8, boolean r9, boolean r10, Function1<? super Continuation<? super Unit>, ? extends Object> r11, Continuation<? super Unit> r12) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        o r14 = new o(IntrinsicsKt.intercepted(r13), 1);
        r14.e();
        final n r6 = (n) ZeusTransformUtils.preCheckCast(r14, n.class, "com.obric.memorydata.plugin");
        final AtomicBoolean r0 = new AtomicBoolean(false);
        final IslandTask r15 = access$makeTask(this, r8, r9, r10, r4, (Function3) ZeusTransformUtils.preCheckCast(new IslandTaskHandler$enqueueAndAwait$2$task$1(r0, r6), Function3.class, "com.obric.memorydata.plugin"));
        if (r8 != null) goto L5;
    L20:
        r6.a((Function1) ZeusTransformUtils.preCheckCast(new IslandTaskHandler$enqueueAndAwait$2$2(r15, this, r8), Function1.class, "com.obric.memorydata.plugin"));
        access$getTaskHandler$p(this).post((Runnable) ZeusTransformUtils.preCheckCast(r15, Runnable.class, "com.obric.memorydata.plugin"));
        Object r7 = r14.h();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L24;
        DebugProbesKt.probeCoroutineSuspended(r13);
    L24:
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        return r7;
    L27:
        return Unit.INSTANCE;
    L5:
        if (r8.longValue() <= 0) goto L20;
        ConcurrentMap r16 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(access$getPendingGroupMap$p(this), ConcurrentMap.class, "com.obric.memorydata.plugin");
        Object r1 = r16.get(r8);
        if (r1 != null) goto L12;
        r1 = Collections.synchronizedList((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));
        Object r17 = r16.putIfAbsent(r8, r1);
        if (r17 == null) goto L12;
        r1 = r17;
    L12:
        List r18 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r18, Constants.KEY_LIST);
        monitor-enter(r18);
        r18.add(r15);     // Catch: Throwable -> L17
        monitor-exit(r18);
    L17:
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
}
