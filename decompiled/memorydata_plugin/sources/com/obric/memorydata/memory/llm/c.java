package com.obric.memorydata.memory.llm;

import android.security.obric.guard.ObricSecurityGuardStub;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.AbsTaskRequest;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u000bJ\u000e\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\rJ\u000e\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\rJ\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u001a\u0010 \u001a\u00020\u00122\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120\u0011J\u0014\u0010\"\u001a\u00020\u00122\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014J\u001a\u0010#\u001a\u00020\u00122\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120\u0011J\u001a\u0010$\u001a\u00020\u001a2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120\u0011J\u001a\u0010&\u001a\u00020\u001a2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120\u0011J\u0006\u0010'\u001a\u00020\u0012J\u0006\u0010(\u001a\u00020\u0012J\u0010\u0010)\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\nX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00140\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006+"}, d2 = {"Lcom/obric/memorydata/memory/llm/MemoryBuildControl;", "", "<init>", "()V", "cancelled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "completed", "islandTerminal", "islandCancellationPublished", "task", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/obric/memorydata/task/AbsTaskRequest;", ObricMemoryConstants.KEY_SESSION_ID, "", "entityId", "entityListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function1;", "", "completionListeners", "Lkotlin/Function0;", "cancellationListeners", "operationId", "getOperationId", "()Ljava/lang/String;", "isCancelled", "", "bindTask", Ext.KEY_REQUEST, "bindSession", OaidModel.KEY_ID, "bindEntity", "onEntityAvailable", "listener", "onCompleted", "onCancelled", "publishIslandBegin", "publish", "publishIslandTerminal", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "complete", "interruptSession", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10278a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f10279b;
    private final AtomicBoolean c;
    private final AtomicBoolean d;
    private final AtomicBoolean e;
    private final AtomicReference<AbsTaskRequest> f;
    private final AtomicReference<String> g;
    private final AtomicReference<String> h;
    private final CopyOnWriteArrayList<Function1<String, Unit>> i;
    private final CopyOnWriteArrayList<Function0<Unit>> j;
    private final CopyOnWriteArrayList<Function1<String, Unit>> k;
    private final String l;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/llm/MemoryBuildControl$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f10278a = new a(null);
    }

    public c() {
        this.f10279b = new AtomicBoolean(false);
        this.c = new AtomicBoolean(false);
        this.d = new AtomicBoolean(false);
        this.e = new AtomicBoolean(false);
        this.f = new AtomicReference();
        this.g = new AtomicReference();
        this.h = new AtomicReference();
        this.i = new CopyOnWriteArrayList();
        this.j = new CopyOnWriteArrayList();
        this.k = new CopyOnWriteArrayList();
        String r0 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r0, "toString(...)");
        this.l = r0;
    }

    private final void c(String r7) {
        k.a(k.f10296a, r7, SessionStatus.FAILED, null, 4, null);
    }

    public final String a() {
        return this.l;
    }

    public final void a(AbsTaskRequest r2) {
        Intrinsics.checkNotNullParameter(r2, Ext.KEY_REQUEST);
        this.f.set(r2);
        if (this.f10279b.get() == false) goto L6;
        r2.cancel();
        return;
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, OaidModel.KEY_ID);
        this.g.set(r2);
        if (this.f10279b.get() == false) goto L6;
        c(r2);
        return;
    }

    public final void a(Function0<Unit> r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "listener");
        ((Collection) ZeusTransformUtils.preCheckCast(this.j, Collection.class, "com.obric.memorydata.plugin")).add(r5);
        if (this.c.get() == false) goto L6;
        r5.invoke();
        return;
    }

    public final void a(Function1<? super String, Unit> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "listener");
        ((Collection) ZeusTransformUtils.preCheckCast(this.i, Collection.class, "com.obric.memorydata.plugin")).add(r5);
        String r3 = (String) ZeusTransformUtils.preCheckCast(this.h.get(), String.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        r5.invoke(r3);
        return;
    }

    public final void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, OaidModel.KEY_ID);
        this.h.set(r4);
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.i, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((Function1) ZeusTransformUtils.preCheckCast(r3.next(), Function1.class, "com.obric.memorydata.plugin")).invoke(r4);
        goto L4
    }

    public final synchronized void b(Function1<? super String, Unit> r4) {
        monitor-enter(this);
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r5, "listener");     // Catch: Throwable -> L8
        ((Collection) ZeusTransformUtils.preCheckCast(this.k, Collection.class, "com.obric.memorydata.plugin")).add(r5);     // Catch: Throwable -> L8
        if (this.f10279b.get() == false) goto L6;
        r5.invoke(this.l);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final boolean b() {
        return this.f10279b.get();
    }

    public final String c() {
        return (String) ZeusTransformUtils.preCheckCast(this.h.get(), String.class, "com.obric.memorydata.plugin");
    }

    public final synchronized boolean c(Function1<? super String, Unit> r3) {
        monitor-enter(this);
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r4, "publish");     // Catch: Throwable -> L13
        if (this.f10279b.get() == false) goto L6;
    L12:
        boolean r5 = false;
    L10:
        monitor-exit(this);
        return r5;
    L6:
        if (this.d.get() == true) goto L12;
        r4.invoke(this.l);     // Catch: Throwable -> L13
        r5 = true;
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void d() {
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L4:
        if (this.f10279b.compareAndSet(false, true) == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        StringBuilder r0 = new StringBuilder().append("cancel task=");     // Catch: Throwable -> L28
        AbsTaskRequest r5 = (AbsTaskRequest) ZeusTransformUtils.preCheckCast(this.f.get(), AbsTaskRequest.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        if (r5 == null) goto L10;
        String r6 = r5.getId();     // Catch: Throwable -> L28
    L11:
        IRunLog.a.a(r3, "MemoryBuildControl", r0.append(r6).append(" session=").append((String) ZeusTransformUtils.preCheckCast(this.g.get(), String.class, "com.obric.memorydata.plugin")).append(" entity=").append((String) ZeusTransformUtils.preCheckCast(this.h.get(), String.class, "com.obric.memorydata.plugin")).toString(), false, 4, null);     // Catch: Throwable -> L28
        AbsTaskRequest r1 = (AbsTaskRequest) ZeusTransformUtils.preCheckCast(this.f.get(), AbsTaskRequest.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        if (r1 == null) goto L14;
        r1.cancel();     // Catch: Throwable -> L28
    L14:
        String r2 = (String) ZeusTransformUtils.preCheckCast(this.g.get(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        if (r2 == null) goto L18;
        c(r2);     // Catch: Throwable -> L28
    L18:
        if (this.c.get() == false) goto L20;
    L26:
        monitor-exit(this);
        return;
    L20:
        if (this.e.compareAndSet(false, true) == false) goto L26;
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.k, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L28
    L22:
        if (r4.hasNext() == false) goto L26;
        ((Function1) ZeusTransformUtils.preCheckCast(r4.next(), Function1.class, "com.obric.memorydata.plugin")).invoke(this.l);     // Catch: Throwable -> L28
        goto L22
    L10:
        r6 = null;
        goto L11
    }

    public final synchronized boolean d(Function1<? super String, Unit> r4) {
        monitor-enter(this);
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r5, "publish");     // Catch: Throwable -> L13
        if (this.f10279b.get() == false) goto L6;
    L11:
        monitor-exit(this);
        return false;
    L6:
        if (this.d.compareAndSet(false, true) == false) goto L11;
        r5.invoke(this.l);     // Catch: Throwable -> L13
        monitor-exit(this);
        return true;
    L13:
        th = move-exception;
        throw th;
    }

    public final void e() {
        if (this.c.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.j, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        ((Function0) ZeusTransformUtils.preCheckCast(r3.next(), Function0.class, "com.obric.memorydata.plugin")).invoke();
        goto L7
    }
}
