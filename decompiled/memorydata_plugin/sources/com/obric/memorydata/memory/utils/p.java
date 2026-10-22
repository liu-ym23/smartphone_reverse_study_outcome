package com.obric.memorydata.memory.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.bx;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\bH\u0096@¢\u0006\u0002\u0010\u0019J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\bH\u0082@¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\bH\u0002J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J\u001e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0$H\u0002J\u0010\u0010%\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u000bH\u0002J\u0010\u0010&\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u000bH\u0002J\u0018\u0010'\u001a\u00020!2\b\u0010\u0018\u001a\u0004\u0018\u00010\bH\u0096@¢\u0006\u0002\u0010\u0019J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0$2\u0006\u0010\u001e\u001a\u00020\u000bH\u0002J\u001e\u0010)\u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0$H\u0002J\u0018\u0010*\u001a\u00020!2\b\u0010\u0018\u001a\u0004\u0018\u00010\bH\u0096@¢\u0006\u0002\u0010\u0019J\b\u0010+\u001a\u00020!H\u0002J\u0018\u0010,\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\bH\u0096@¢\u0006\u0002\u0010\u0019J\b\u0010-\u001a\u00020.H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006/"}, d2 = {"Lcom/obric/memorydata/memory/utils/ReentrantMutexImpl;", "Lcom/obric/memorydata/memory/utils/ReentrantMutex;", "locked", "", "<init>", "(Z)V", "ownerRef", "Ljava/util/concurrent/atomic/AtomicReference;", "", "jobFamilies", "", "Lkotlinx/coroutines/Job;", "", "cleanupHandles", "Lkotlinx/coroutines/DisposableHandle;", "_holdCount", "", "waiters", "", "Lcom/obric/memorydata/memory/utils/Waiter;", "syncLock", "isLocked", "()Z", "holdsLock", "owner", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentOwner", "isOwnerOrChild", "candidate", "isJobDescendant", "job", "ancestor", "registerJobFamily", "", "primaryJob", "relatedJobs", "", "cleanupJobFromFamily", "cleanupJobFamily", "lock", "collectRelatedJobs", "acquireLock", "unlock", "wakeupNextWaiter", "holdCount", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class p implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference<Object> f11561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<bx, Set<bx>> f11562b;
    private final Map<bx, bc> c;
    private volatile int d;
    private final List<y> e;
    private final Object f;

    public p(boolean r4) {
        this.f11561a = new AtomicReference(null);
        this.f11562b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.c = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.d = r4 ? 1 : 0;
        this.e = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.f = new Object();
    }

    private static final Unit a(p r1, bx r2, Throwable r3) {
        bx r4 = (bx) ZeusTransformUtils.wrapperContextForParams(r2, bx.class, "com.obric.memorydata.plugin");
        Object r5 = r1.f;
        monitor-enter(r5);
        r1.a(r4);     // Catch: Throwable -> L8
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r5);
        return Unit.INSTANCE;
    L8:
        th = move-exception;
        throw th;
    }

    private final void a(Object r4, Set<? extends bx> r5) {
        Set<? extends bx> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        this.f11561a.set(r4);
        this.d = 1;
        if (ZeusTransformUtils.instanceOf(r4, bx.class) == true) goto L5;
        return;
    L5:
        if ((true ^ ((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L9;
        a((bx) ZeusTransformUtils.preCheckCast(r4, bx.class, "com.obric.memorydata.plugin"), r6);
        return;
    }

    private final void a(bx r5) {
        bx r6 = (bx) ZeusTransformUtils.wrapperContextForParams(r5, bx.class, "com.obric.memorydata.plugin");
        Set r0 = (Set) ZeusTransformUtils.preCheckCast(this.f11562b.get(r6), Set.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L12;
        r0.remove(r6);
        this.f11562b.remove(r6);
        if (r0.isEmpty() == false) goto L12;
        Iterator r1 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        bx r2 = (bx) ZeusTransformUtils.preCheckCast(r1.next(), bx.class, "com.obric.memorydata.plugin");
        this.f11562b.remove(r2);
        bc r3 = (bc) ZeusTransformUtils.preCheckCast(this.c.remove(r2), bc.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L8;
        r3.dispose();
    L12:
        bc r4 = (bc) ZeusTransformUtils.preCheckCast(this.c.remove(r6), bc.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L21;
        r4.dispose();
        return;
    }

    private final void a(bx r5, Set<? extends bx> r6) {
        bx r7 = (bx) ZeusTransformUtils.wrapperContextForParams(r5, bx.class, "com.obric.memorydata.plugin");
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        Set<bx> r0 = (Set) ZeusTransformUtils.preCheckCast(this.f11562b.get(r7), Set.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        r0 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
    L6:
        r0.add(r7);
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin"));
        Iterator<bx> r9 = r0.iterator();
    L8:
        if (r9.hasNext() == false) goto L12;
        final bx r10 = (bx) ZeusTransformUtils.preCheckCast(r9.next(), bx.class, "com.obric.memorydata.plugin");
        this.f11562b.put(r10, r0);
        if (this.c.containsKey(r10) == true) goto L8;
        bc r2 = r10.a(new $$Lambda$p$YiQOVQYIuXpQqELtkbf5S60Dkpw(this, r10));
        this.c.put(r10, r2);
        goto L8
    }

    private final boolean a(Object r7) {
        Object r0 = this.f11561a.get();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0 != r7) goto L9;
        return true;
    L9:
        if (ZeusTransformUtils.instanceOf(r0, bx.class) == true) goto L11;
    L27:
        return false;
    L11:
        if (ZeusTransformUtils.instanceOf(r7, bx.class) == false) goto L27;
        if (a((bx) ZeusTransformUtils.preCheckCast(r7, bx.class, "com.obric.memorydata.plugin"), (bx) ZeusTransformUtils.preCheckCast(r0, bx.class, "com.obric.memorydata.plugin")) == false) goto L16;
        return true;
    L16:
        if (a((bx) ZeusTransformUtils.preCheckCast(r0, bx.class, "com.obric.memorydata.plugin"), (bx) ZeusTransformUtils.preCheckCast(r7, bx.class, "com.obric.memorydata.plugin")) == false) goto L18;
        return true;
    L18:
        Set r3 = (Set) ZeusTransformUtils.preCheckCast(this.f11562b.get(r0), Set.class, "com.obric.memorydata.plugin");
        Set r6 = (Set) ZeusTransformUtils.preCheckCast(this.f11562b.get(r7), Set.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L21;
    L23:
        if (r6 == null) goto L27;
        if (r6.contains(r0) == false) goto L27;
        return true;
    L21:
        if (r3.contains(r7) == false) goto L23;
        return true;
    }

    private final boolean a(bx r2, bx r3) {
        bx r1 = (bx) ZeusTransformUtils.wrapperContextForParams(r2, bx.class, "com.obric.memorydata.plugin");
        bx r4 = (bx) ZeusTransformUtils.wrapperContextForParams(r3, bx.class, "com.obric.memorydata.plugin");
    L3:
        if (r1 == null) goto L8;
        if (r1 == r4) goto L5;
        r1 = r1.h();
        goto L3
    L5:
        return true;
    L8:
        return false;
    }

    private final void b() {
    L3:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.e, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L9;
        y r0 = (y) ZeusTransformUtils.preCheckCast(this.e.remove(0), y.class, "com.obric.memorydata.plugin");
        if (r0.b() == true) goto L3;
        if (kotlinx.coroutines.channels.m.a(r0.a().mo54trySendJP2dKIU(Unit.INSTANCE)) == false) goto L3;
        return;
    }

    private final void b(bx r4) {
        bx r5 = (bx) ZeusTransformUtils.wrapperContextForParams(r4, bx.class, "com.obric.memorydata.plugin");
        Set r6 = (Set) ZeusTransformUtils.preCheckCast(this.f11562b.remove(r5), Set.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L13;
        List r7 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin"));
        if (r7 == null) goto L19;
        Iterator r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L20;
        bx r0 = (bx) ZeusTransformUtils.preCheckCast(r8.next(), bx.class, "com.obric.memorydata.plugin");
        this.f11562b.remove(r0);
        bc r1 = (bc) ZeusTransformUtils.preCheckCast(this.c.remove(r0), bc.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        r1.dispose();
        goto L9
    L20:
        return;
    L19:
        return;
    }

    private final Set<bx> c(bx r3) {
        bx r2 = (bx) ZeusTransformUtils.wrapperContextForParams(r3, bx.class, "com.obric.memorydata.plugin");
        Set<bx> r4 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
    L3:
        r4.add(r2);
        r2 = r2.h();
        if (r2 != null) goto L3;
        return r4;
    }

    private final Object e(Object r2, Continuation<Object> r3) {
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L5;
        return r2;
    L5:
        return r1.getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ Unit lambda$YiQOVQYIuXpQqELtkbf5S60Dkpw(p r0, bx r1, Throwable r2) {
        return a(r0, r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v15, types: [com.obric.memorydata.memory.utils.y, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v27, types: [com.obric.memorydata.memory.utils.y] */
    /* JADX WARN: Type inference failed for: r9v29 */
    @Override // com.obric.memorydata.memory.utils.o
    public Object a(Object r10, Continuation<? super Unit> r11) {
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, ReentrantMutexImpl$lock$1.class) == false) goto L7;
        ReentrantMutexImpl$lock$1 r1 = (ReentrantMutexImpl$lock$1) ZeusTransformUtils.preCheckCast(r12, ReentrantMutexImpl$lock$1.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r13 = r1.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r1.label;
        if (r3 == 0) goto L22;
        if (r3 == 1) goto L21;
        if (r3 != 2) goto L20;
        y this = (y) ZeusTransformUtils.preCheckCast(r1.L$3, y.class, "com.obric.memorydata.plugin");
        Set<? extends bx> r14 = (Set) ZeusTransformUtils.preCheckCast(r1.L$2, Set.class, "com.obric.memorydata.plugin");
        Object r4 = r1.L$1;
        p r0 = (p) ZeusTransformUtils.preCheckCast(r1.L$0, p.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L15 CancellationException -> L17
        p r5 = r0;
        y r9 = this;
    L57:
        Object r15 = r5.f;     // Catch: Throwable -> L15 CancellationException -> L17
        monitor-enter(r15);     // Catch: Throwable -> L15 CancellationException -> L17
        r5.a(r4, r14);     // Catch: Throwable -> L62
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L62
        monitor-exit(r15);     // Catch: Throwable -> L15 CancellationException -> L17
        kotlinx.coroutines.channels.y.a.a((kotlinx.coroutines.channels.y) ZeusTransformUtils.preCheckCast(r9.a(), kotlinx.coroutines.channels.y.class, "com.obric.memorydata.plugin"), null, 1, null);
    L85:
        return Unit.INSTANCE;
    L62:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15 CancellationException -> L17
    L17:
        e = e;
    L69:
        Object r17 = r0.f;     // Catch: Throwable -> L15
        monitor-enter(r17);     // Catch: Throwable -> L15
        this.a(true);     // Catch: Throwable -> L79
        if (r0.e.remove(this) == false) goto L74;
    L76:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L79
        monitor-exit(r17);     // Catch: Throwable -> L15
        throw e;     // Catch: Throwable -> L15
    L74:
        if (r0.f11561a.get() != null) goto L76;
        r0.b();     // Catch: Throwable -> L79
    L79:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        p r18 = (p) ZeusTransformUtils.preCheckCast(r1.L$0, p.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);
        p r19 = r18;
    L25:
        if (r13 == null) goto L93;
        if (ZeusTransformUtils.instanceOf(r13, bx.class) == false) goto L29;
        r14 = r19.c((bx) ZeusTransformUtils.preCheckCast(r13, bx.class, "com.obric.memorydata.plugin"));
    L30:
        Object r7 = r19.f;
        monitor-enter(r7);
    L89:
        th = move-exception;
        throw th;
    L33:
        if (r19.a(r13) == false) goto L37;
        r19.d++;     // Catch: Throwable -> L89
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L89
        monitor-exit(r7);
        return r20;
    L37:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L89
        monitor-exit(r7);
        y r21 = new y();
        Object r22 = r19.f;
        monitor-enter(r22);
    L86:
        th = move-exception;
        throw th;
    L42:
        if (r19.a(r13) == false) goto L47;
        r19.d++;     // Catch: Throwable -> L86
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L86
        monitor-exit(r22);
        return r23;
    L47:
        if (r19.f11561a.get() != null) goto L49;
        r19.a(r13, r14);     // Catch: Throwable -> L86
        boolean r24 = true;
    L51:
        monitor-exit(r22);
        if (r24 == true) goto L85;
        kotlinx.coroutines.channels.i<Unit> r25 = r21.a();     // Catch: Throwable -> L65 CancellationException -> L67
        r1.L$0 = r19;     // Catch: Throwable -> L65 CancellationException -> L67
        r1.L$1 = r13;     // Catch: Throwable -> L65 CancellationException -> L67
        r1.L$2 = r14;     // Catch: Throwable -> L65 CancellationException -> L67
        r1.L$3 = r21;     // Catch: Throwable -> L65 CancellationException -> L67
        r1.label = 2;     // Catch: Throwable -> L65 CancellationException -> L67
        if (r25.a(r1) != r2) goto L56;
        return r2;
    L56:
        r4 = r13;
        r5 = r19;
        r9 = r21;
        goto L57
    L67:
        e = e;
        r0 = r19;
        this = r21;
    L65:
        th = th;
        this = r21;
    L82:
        kotlinx.coroutines.channels.y.a.a((kotlinx.coroutines.channels.y) ZeusTransformUtils.preCheckCast(this.a(), kotlinx.coroutines.channels.y.class, "com.obric.memorydata.plugin"), null, 1, null);
        throw th;
    L49:
        r19.e.add(r21);     // Catch: Throwable -> L86
        r24 = false;
        goto L51
    L29:
        r14 = SetsKt.emptySet();
        goto L30
    L93:
        throw new IllegalStateException("Cannot use ReentrantMutex without owner. Use explicit owner parameter or ensure Job is in coroutine context.".toString());
    L22:
        ResultKt.throwOnFailure(r13);
        r1.L$0 = this;
        r1.label = 1;
        r13 = e(r10, r1);
        this = this;
        if (r13 != r2) goto L25;
        return r2;
    L15:
        th = th;
    L7:
        r1 = new ReentrantMutexImpl$lock$1(this, r12);
        goto L8
    }

    public boolean a() {
        Object r0 = this.f;
        monitor-enter(r0);
        if (this.f11561a.get() == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);
        return r1;
    L7:
        r1 = false;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.memory.utils.o
    public Object b(Object r5, Continuation<? super Unit> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, ReentrantMutexImpl$unlock$1.class) == false) goto L7;
        ReentrantMutexImpl$unlock$1 r0 = (ReentrantMutexImpl$unlock$1) ZeusTransformUtils.preCheckCast(r7, ReentrantMutexImpl$unlock$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        p this = (p) ZeusTransformUtils.preCheckCast(r0.L$0, p.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r8);
    L17:
        if (r8 == null) goto L46;
        Object r9 = this.f;
        monitor-enter(r9);
        Object r3 = this.f11561a.get();     // Catch: Throwable -> L42
        if (r3 == null) goto L41;
        if (this.a(r8) == false) goto L39;
        if (this.d <= 0) goto L37;
        this.d--;     // Catch: Throwable -> L42
        if (this.d != 0) goto L32;
        Object r10 = this.f11561a.get();     // Catch: Throwable -> L42
        this.f11561a.set(null);     // Catch: Throwable -> L42
        if (ZeusTransformUtils.instanceOf(r10, bx.class) == false) goto L31;
        this.b((bx) ZeusTransformUtils.preCheckCast(r10, bx.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L42
    L31:
        this.b();     // Catch: Throwable -> L42
    L32:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L42
        monitor-exit(r9);
        return Unit.INSTANCE;
    L37:
        throw new IllegalStateException("Invalid hold count: " + this.d);     // Catch: Throwable -> L42
    L39:
        throw new IllegalStateException("This mutex is locked by " + r3 + ", but " + r8 + " is trying to unlock");     // Catch: Throwable -> L42
    L41:
        throw new IllegalStateException("Mutex is not locked");     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        throw th;
    L46:
        throw new IllegalStateException("Cannot unlock without owner. Use explicit owner parameter or ensure Job is in coroutine context.");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        r0.L$0 = this;
        r0.label = 1;
        r8 = e(r5, r0);
        if (r8 != r1) goto L17;
        return r1;
    L7:
        r0 = new ReentrantMutexImpl$unlock$1(this, r7);
        goto L8
    }

    public Object c(Object r5, Continuation<? super Boolean> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, ReentrantMutexImpl$holdsLock$1.class) == false) goto L7;
        ReentrantMutexImpl$holdsLock$1 r0 = (ReentrantMutexImpl$holdsLock$1) ZeusTransformUtils.preCheckCast(r7, ReentrantMutexImpl$holdsLock$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        p this = (p) ZeusTransformUtils.preCheckCast(r0.L$0, p.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r8);
    L17:
        Object r9 = this.f;
        monitor-enter(r9);
        if (r8 != null) goto L29;
        boolean r4 = false;
    L24:
        Boolean r10 = Boxing.boxBoolean(r4);     // Catch: Throwable -> L21
        monitor-exit(r9);
        return r10;
    L21:
        th = move-exception;
        throw th;
    L29:
        r4 = this.a(r8);     // Catch: Throwable -> L21
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        r0.L$0 = this;
        r0.label = 1;
        r8 = e(r5, r0);
        if (r8 != r1) goto L17;
        return r1;
    L7:
        r0 = new ReentrantMutexImpl$holdsLock$1(this, r7);
        goto L8
    }

    public Object d(Object r5, Continuation<? super Integer> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, ReentrantMutexImpl$holdCount$1.class) == false) goto L7;
        ReentrantMutexImpl$holdCount$1 r0 = (ReentrantMutexImpl$holdCount$1) ZeusTransformUtils.preCheckCast(r7, ReentrantMutexImpl$holdCount$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        p this = (p) ZeusTransformUtils.preCheckCast(r0.L$0, p.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r8);
    L17:
        Object r9 = this.f;
        monitor-enter(r9);
        if (r8 != null) goto L31;
    L25:
        int r4 = 0;
    L26:
        Integer r10 = Boxing.boxInt(r4);     // Catch: Throwable -> L23
        monitor-exit(r9);
        return r10;
    L23:
        th = move-exception;
        throw th;
    L31:
        if (this.a(r8) == false) goto L25;
        r4 = this.d;     // Catch: Throwable -> L23
        goto L26
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        r0.L$0 = this;
        r0.label = 1;
        r8 = e(r5, r0);
        if (r8 != r1) goto L17;
        return r1;
    L7:
        r0 = new ReentrantMutexImpl$holdCount$1(this, r7);
        goto L8
    }

    public String toString() {
        Object r0 = this.f;
        monitor-enter(r0);
        String r3 = "ReentrantMutex[isLocked=" + a() + ", owner=" + this.f11561a.get() + ", holdCount=" + this.d + ", waiters=" + this.e.size() + ']';     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }
}
