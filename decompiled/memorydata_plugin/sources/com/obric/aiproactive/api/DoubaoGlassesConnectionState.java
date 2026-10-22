package com.obric.aiproactive.api;

import com.obric.memorydata.memory.ui.list.PendingPersonalInfoNotificationTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001$B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000bJ.\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u000bJ\u0006\u0010\u0015\u001a\u00020\tJ\u0006\u0010\u0016\u001a\u00020\u000bJ\u0006\u0010\u0017\u001a\u00020\u000bJ\u0006\u0010\u0018\u001a\u00020\u000bJ\u0006\u0010\u0019\u001a\u00020\u000bJ\u000e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\rJ\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u000bJ\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0018\u0010\"\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/aiproactive/api/DoubaoGlassesConnectionState;", "", "<init>", "()V", "logger", "Lcom/obric/memorydata/middleware/api/logging/ModuleLogger;", "store", "Lcom/obric/aiproactive/api/DoubaoGlassesConnectionState$DoubaoGlassesConnectionStateStore;", "initializeFromHost", "Lcom/obric/aiproactive/api/DoubaoGlassesConnectionSnapshot;", "connected", "", "persistedGeneration", "", "wearing", "environmentMemoryEnabled", "everConnected", "updateFromHost", "updateWearingFromHost", "updateEnvironmentMemoryFromHost", "enabled", "currentSnapshot", "isConnected", "isWearing", "isEnvironmentMemoryEnabled", "hasEverConnected", "isConnectedGeneration", PendingPersonalInfoNotificationTask.KEY_GENERATION, "registerListener", "", "listener", "Lcom/obric/aiproactive/api/DoubaoGlassesConnectionListener;", "emitCurrent", "unregisterListener", "notifyListener", "snapshot", "DoubaoGlassesConnectionStateStore", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DoubaoGlassesConnectionState {
    public static final DoubaoGlassesConnectionState INSTANCE = null;
    private static final com.obric.memorydata.middleware.api.logging.o logger = null;
    private static final a store = null;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u000bJ\u0006\u0010\u0017\u001a\u00020\tJ\u0006\u0010\u0018\u001a\u00020\u000bJ\u0006\u0010\u0019\u001a\u00020\u000bJ\u0006\u0010\u001a\u001a\u00020\u000bJ\u0006\u0010\u001b\u001a\u00020\u000bJ\u000e\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000fJ\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u000bJ\u000e\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0007J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/aiproactive/api/DoubaoGlassesConnectionState$DoubaoGlassesConnectionStateStore;", "", "<init>", "()V", "lock", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/obric/aiproactive/api/DoubaoGlassesConnectionListener;", "snapshot", "Lcom/obric/aiproactive/api/DoubaoGlassesConnectionSnapshot;", "reportedWearing", "", "initialize", "connected", "persistedGeneration", "", "wearing", "environmentMemoryEnabled", "everConnected", com.obric.memorydata.BuildConfig.CHANNEL, "updateEnvironmentMemory", "enabled", "updateWearing", "currentSnapshot", "isConnected", "isWearing", "isEnvironmentMemoryEnabled", "hasEverConnected", "isConnectedGeneration", PendingPersonalInfoNotificationTask.KEY_GENERATION, "registerListener", "", "listener", "emitCurrent", "unregisterListener", "notifyListeners", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f6236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CopyOnWriteArraySet<ab> f6237b;
        private volatile DoubaoGlassesConnectionSnapshot c;
        private volatile boolean d;

        public a() {
            this.f6236a = new Object();
            this.f6237b = new CopyOnWriteArraySet();
            this.c = new DoubaoGlassesConnectionSnapshot(false, 0, false, 4, null);
        }

        private final void a(DoubaoGlassesConnectionSnapshot r4) {
            Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f6237b, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            ab r0 = (ab) ZeusTransformUtils.preCheckCast(r3.next(), ab.class, "com.obric.memorydata.plugin");
            DoubaoGlassesConnectionState r2 = DoubaoGlassesConnectionState.INSTANCE;
            Intrinsics.checkNotNull(r0);
            DoubaoGlassesConnectionState.access$notifyListener(r2, r0, r4);
            goto L4
        }

        public final DoubaoGlassesConnectionSnapshot a() {
            return this.c;
        }

        public final DoubaoGlassesConnectionSnapshot a(boolean r11) {
            Object r0 = this.f6236a;
            monitor-enter(r0);
            DoubaoGlassesConnectionSnapshot r1 = this.c;     // Catch: Throwable -> L14
            if (r1.getEnvironmentMemoryEnabled() != r11) goto L10;
            monitor-exit(r0);
            return null;
        L10:
            DoubaoGlassesConnectionSnapshot r12 = DoubaoGlassesConnectionSnapshot.copy$default(r1, false, 0, false, r11, false, 23, null);     // Catch: Throwable -> L14
            this.c = r12;     // Catch: Throwable -> L14
            monitor-exit(r0);
            a(r12);
            return r12;
        L14:
            th = move-exception;
            throw th;
        }

        public final DoubaoGlassesConnectionSnapshot a(boolean r10, long r11, boolean r13, boolean r14, boolean r15) {
            Object r0 = this.f6236a;
            monitor-enter(r0);
        L23:
            th = move-exception;
            throw th;
        L5:
            if (this.c.getGeneration() <= 0) goto L9;
            DoubaoGlassesConnectionSnapshot r9 = this.c;     // Catch: Throwable -> L23
            monitor-exit(r0);
            return r9;
        L9:
            this.d = r13;     // Catch: Throwable -> L23
            long r3 = RangesKt.coerceAtLeast(r11, 1);     // Catch: Throwable -> L23
            if (r10 == false) goto L13;
            if (r13 == false) goto L13;
            boolean r5 = true;
        L14:
            if (r15 == true) goto L18;
            if (r10 == true) goto L18;
            boolean r7 = false;
        L19:
            DoubaoGlassesConnectionSnapshot r8 = new DoubaoGlassesConnectionSnapshot(r10, r3, r5, r14, r7);     // Catch: Throwable -> L23
            this.c = r8;     // Catch: Throwable -> L23
            monitor-exit(r0);
            a(r8);
            return r8;
        L18:
            r7 = true;
        L13:
            r5 = false;
            goto L14
        }

        public final void a(ab r3) {
            ab r4 = (ab) ZeusTransformUtils.wrapperContextForParams(r3, ab.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "listener");
            this.f6237b.remove(r4);
        }

        public final void a(ab r5, boolean r6) {
            ab r7 = (ab) ZeusTransformUtils.wrapperContextForParams(r5, ab.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "listener");
            this.f6237b.add(r7);
            DoubaoGlassesConnectionSnapshot r4 = this.c;
            if (r6 == true) goto L5;
            return;
        L5:
            if (r4.getGeneration() <= 0) goto L9;
            DoubaoGlassesConnectionState.access$notifyListener(DoubaoGlassesConnectionState.INSTANCE, r7, r4);
            return;
        }

        public final boolean a(long r3) {
            DoubaoGlassesConnectionSnapshot r2 = this.c;
            if (r2.getConnected() == true) goto L5;
        L7:
            return false;
        L5:
            if (r2.getGeneration() != r3) goto L7;
            return true;
        }

        public final DoubaoGlassesConnectionSnapshot b(boolean r11) {
            Object r0 = this.f6236a;
            monitor-enter(r0);
            this.d = r11;     // Catch: Throwable -> L19
            DoubaoGlassesConnectionSnapshot r1 = this.c;     // Catch: Throwable -> L19
            if (r1.getConnected() == false) goto L8;
            if (r11 == false) goto L8;
            boolean r12 = true;
        L9:
            boolean r5 = r12;
            if (r1.getWearing() != r5) goto L15;
            monitor-exit(r0);
            return null;
        L15:
            DoubaoGlassesConnectionSnapshot r13 = DoubaoGlassesConnectionSnapshot.copy$default(r1, false, 0, r5, false, false, 27, null);     // Catch: Throwable -> L19
            this.c = r13;     // Catch: Throwable -> L19
            monitor-exit(r0);
            a(r13);
            return r13;
        L8:
            r12 = false;
        L19:
            th = move-exception;
            throw th;
        }

        public final boolean b() {
            return this.c.getConnected();
        }

        public final boolean c() {
            return this.c.getWearing();
        }

        public final boolean d() {
            return this.c.getEnvironmentMemoryEnabled();
        }

        public final boolean e() {
            return this.c.getEverConnected();
        }

        public final DoubaoGlassesConnectionSnapshot update(boolean r12) {
            Object r0 = this.f6236a;
            monitor-enter(r0);
            DoubaoGlassesConnectionSnapshot r1 = this.c;     // Catch: Throwable -> L30
            if (r1.getGeneration() > 0) goto L7;
        L11:
            long r3 = 1;
            if (r1.getGeneration() <= 0) goto L15;
            r3 = r1.getGeneration() + 1;     // Catch: Throwable -> L30
        L15:
            if (r12 == true) goto L17;
        L19:
            boolean r6 = false;
        L21:
            if (r1.getEverConnected() == true) goto L25;
            if (r12 == true) goto L25;
            boolean r8 = false;
        L26:
            DoubaoGlassesConnectionSnapshot r13 = DoubaoGlassesConnectionSnapshot.copy$default(r1, r12, r3, r6, false, r8, 8, null);     // Catch: Throwable -> L30
            this.c = r13;     // Catch: Throwable -> L30
            monitor-exit(r0);
            a(r13);
            return r13;
        L25:
            r8 = true;
            goto L26
        L17:
            if (this.d == false) goto L19;
            r6 = true;
            goto L21
        L7:
            if (r1.getConnected() != r12) goto L11;
            monitor-exit(r0);
            return null;
        L30:
            th = move-exception;
            throw th;
        }
    }

    static {
        INSTANCE = new DoubaoGlassesConnectionState();
        logger = com.obric.memorydata.middleware.api.logging.d.f11613a.a("DoubaoGlassesState");
        store = new a();
    }

    private DoubaoGlassesConnectionState() {
    }

    public static final /* synthetic */ void access$notifyListener(DoubaoGlassesConnectionState r2, ab r3, DoubaoGlassesConnectionSnapshot r4) {
        r2.notifyListener((ab) ZeusTransformUtils.wrapperContextForParams(r3, ab.class, "com.obric.memorydata.plugin"), r4);
    }

    public static /* synthetic */ DoubaoGlassesConnectionSnapshot initializeFromHost$default(DoubaoGlassesConnectionState r0, boolean r1, long r2, boolean r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r4 = false;
    L6:
        return r0.initializeFromHost(r1, r2, r4);
    }

    /* JADX INFO: renamed from: lambda$QziBeH-XJZypCrbHfnTuEZJyNRU, reason: not valid java name */
    public static /* synthetic */ Unit m205lambda$QziBeHXJZypCrbHfnTuEZJyNRU(Throwable r0, com.obric.memorydata.middleware.api.logging.g r1) {
        return notifyListener$lambda$2$lambda$1(r0, r1);
    }

    private final void notifyListener(ab r12, DoubaoGlassesConnectionSnapshot r13) {
        ab r14 = (ab) ZeusTransformUtils.wrapperContextForParams(r12, ab.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        DoubaoGlassesConnectionState r11 = (DoubaoGlassesConnectionState) ZeusTransformUtils.preCheckCast(this, DoubaoGlassesConnectionState.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        r14.onChanged(r13);     // Catch: Throwable -> L5
        Object r15 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        final Throwable r16 = Result.m1424exceptionOrNullimpl(r15);
        if (r16 == null) goto L13;
        com.obric.memorydata.middleware.api.logging.o.a(logger, "眼镜状态监听回调失败", "glasses_state_listener_failed", "listener_callback_failed", null, new com.obric.memorydata.middleware.api.logging.e(null, "connection_" + r13.getGeneration(), "listener", 1, null), new $$Lambda$DoubaoGlassesConnectionState$QziBeHXJZypCrbHfnTuEZJyNRU(r16), 8, null);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private static final Unit notifyListener$lambda$2$lambda$1(Throwable r1, com.obric.memorydata.middleware.api.logging.g r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$errorTrace");
        r2.a("error_type", r1.getClass().getSimpleName());
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void registerListener$default(DoubaoGlassesConnectionState r1, ab r2, boolean r3, int r4, Object r5) {
        ab r6 = (ab) ZeusTransformUtils.wrapperContextForParams(r2, ab.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = true;
    L5:
        r1.registerListener(r6, r3);
    }

    public final DoubaoGlassesConnectionSnapshot currentSnapshot() {
        return store.a();
    }

    public final boolean hasEverConnected() {
        return store.e();
    }

    public final DoubaoGlassesConnectionSnapshot initializeFromHost(boolean r8, long r9, boolean r11) {
        return initializeFromHost(r8, r9, r11, true, r8);
    }

    public final DoubaoGlassesConnectionSnapshot initializeFromHost(boolean r8, long r9, boolean r11, boolean r12, boolean r13) {
        return store.a(r8, r9, r11, r12, r13);
    }

    public final boolean isConnected() {
        return store.b();
    }

    public final boolean isConnectedGeneration(long r1) {
        return store.a(r1);
    }

    public final boolean isEnvironmentMemoryEnabled() {
        return store.d();
    }

    public final boolean isWearing() {
        return store.c();
    }

    public final void registerListener(ab r2, boolean r3) {
        ab r1 = (ab) ZeusTransformUtils.wrapperContextForParams(r2, ab.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "listener");
        store.a(r1, r3);
    }

    public final void unregisterListener(ab r2) {
        ab r1 = (ab) ZeusTransformUtils.wrapperContextForParams(r2, ab.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "listener");
        store.a(r1);
    }

    public final DoubaoGlassesConnectionSnapshot updateEnvironmentMemoryFromHost(boolean r1) {
        return store.a(r1);
    }

    public final DoubaoGlassesConnectionSnapshot updateFromHost(boolean r1) {
        return store.update(r1);
    }

    public final DoubaoGlassesConnectionSnapshot updateWearingFromHost(boolean r1) {
        return store.b(r1);
    }
}
