package com.obric.widget.host.runtime;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.r1;
import kotlinx.coroutines.sync.e;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J^\u0010\u001d\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0012\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u001e\u0010\u0019\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00172\b\b\u0002\u0010\u001a\u001a\u00020\fH\u0086@¢\u0006\u0004\b\u001d\u0010\u001eJ\"\u0010\"\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u001fH\u0086@¢\u0006\u0004\b\"\u0010#J\u0018\u0010$\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b$\u0010%R \u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R(\u0010)\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00120&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010(R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetPayloadPrefetchCoordinator;", "", "<init>", "()V", "Lcom/obric/widget/host/runtime/WidgetPayloadCacheKey;", STGroup.DICT_KEY, "Lcom/obric/widget/host/runtime/PrefetchedWidgetPayload;", "peek", "(Lcom/obric/widget/host/runtime/WidgetPayloadCacheKey;)Lcom/obric/widget/host/runtime/PrefetchedWidgetPayload;", "", "clear", "(Lcom/obric/widget/host/runtime/WidgetPayloadCacheKey;)V", "", "hostId", "", "instanceId", "clearInstance", "(Ljava/lang/String;I)V", "Lkotlinx/coroutines/m0;", "getInFlightOrNull", "(Lcom/obric/widget/host/runtime/WidgetPayloadCacheKey;)Lkotlinx/coroutines/m0;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "request", "source", "Lkotlin/Pair;", "", "getOrStartPrefetch", "(Lkotlinx/coroutines/CoroutineScope;Lcom/obric/widget/host/runtime/WidgetPayloadCacheKey;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "timeoutMs", "Lcom/obric/widget/host/runtime/PayloadConsumeResult;", "awaitIfReady", "(Lcom/obric/widget/host/runtime/WidgetPayloadCacheKey;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "await", "(Lcom/obric/widget/host/runtime/WidgetPayloadCacheKey;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/concurrent/ConcurrentHashMap;", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "inFlight", "Lkotlinx/coroutines/sync/a;", "mutex", "Lkotlinx/coroutines/sync/a;", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWidgetPayloadPrefetchCoordinator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetPayloadPrefetchCoordinator.kt\ncom/obric/widget/host/runtime/WidgetPayloadPrefetchCoordinator\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,157:1\n774#2:158\n865#2,2:159\n1863#2,2:161\n1#3:163\n116#4,11:164\n*S KotlinDebug\n*F\n+ 1 WidgetPayloadPrefetchCoordinator.kt\ncom/obric/widget/host/runtime/WidgetPayloadPrefetchCoordinator\n*L\n48#1:158\n48#1:159,2\n50#1:161,2\n62#1:164,11\n*E\n"})
public final class WidgetPayloadPrefetchCoordinator {
    private final ConcurrentHashMap<WidgetPayloadCacheKey, PrefetchedWidgetPayload> cache;
    private final ConcurrentHashMap<WidgetPayloadCacheKey, m0> inFlight;
    private final kotlinx.coroutines.sync.a mutex;

    /* JADX INFO: renamed from: com.obric.widget.host.runtime.WidgetPayloadPrefetchCoordinator$await$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.runtime.WidgetPayloadPrefetchCoordinator", f = "WidgetPayloadPrefetchCoordinator.kt", i = {}, l = {150}, m = "await", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ WidgetPayloadPrefetchCoordinator this$0;

        public AnonymousClass1(WidgetPayloadPrefetchCoordinator r5, Continuation<? super AnonymousClass1> r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.result = r5;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.await(null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.runtime.WidgetPayloadPrefetchCoordinator$awaitIfReady$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.runtime.WidgetPayloadPrefetchCoordinator", f = "WidgetPayloadPrefetchCoordinator.kt", i = {}, l = {117, 121}, m = "awaitIfReady", n = {}, s = {})
    public static final class C01991 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ WidgetPayloadPrefetchCoordinator this$0;

        public C01991(WidgetPayloadPrefetchCoordinator r5, Continuation<? super C01991> r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.result = r5;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.awaitIfReady(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.runtime.WidgetPayloadPrefetchCoordinator$getOrStartPrefetch$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.runtime.WidgetPayloadPrefetchCoordinator", f = "WidgetPayloadPrefetchCoordinator.kt", i = {0, 0, 0, 0, 0, 0}, l = {164}, m = "getOrStartPrefetch", n = {"this", "scope", STGroup.DICT_KEY, "request", "source", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    public static final class C02001 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ WidgetPayloadPrefetchCoordinator this$0;

        public C02001(WidgetPayloadPrefetchCoordinator r5, Continuation<? super C02001> r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getOrStartPrefetch(null, null, null, null, this);
        }
    }

    public WidgetPayloadPrefetchCoordinator() {
        this.cache = new ConcurrentHashMap();
        this.inFlight = new ConcurrentHashMap();
        this.mutex = e.a();
    }

    public static final /* synthetic */ ConcurrentHashMap access$getCache$p(WidgetPayloadPrefetchCoordinator r5) {
        return r5.cache;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getInFlight$p(WidgetPayloadPrefetchCoordinator r5) {
        return r5.inFlight;
    }

    public static /* synthetic */ Object awaitIfReady$default(WidgetPayloadPrefetchCoordinator r5, WidgetPayloadCacheKey r10, long r11, Continuation r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = 0;
    L6:
        return r5.awaitIfReady(r10, r11, r12);
    }

    public static /* synthetic */ Object getOrStartPrefetch$default(WidgetPayloadPrefetchCoordinator r10, CoroutineScope r11, WidgetPayloadCacheKey r12, Function1 r13, String r14, Continuation r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L6;
        r14 = "remote";
    L6:
        return r10.getOrStartPrefetch(r11, r12, r13, r14, r15);
    }

    public final Object await(WidgetPayloadCacheKey r10, Continuation<? super PayloadConsumeResult> r11) {
        if ((r11 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r5 = (AnonymousClass1) r11;
        int r12 = r5.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r5.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r5.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L26:
        return new PayloadConsumeResult((PrefetchedWidgetPayload) r13, false, true, true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        PrefetchedWidgetPayload r16 = this.cache.get(r10);
        if (r16 != null) goto L17;
        m0 r17 = this.inFlight.get(r10);
        if (r17 == null) goto L21;
        r5.label = 1;
        r13 = r17.d(r5);
        if (r13 != r14) goto L26;
        return r14;
    L21:
        return new PayloadConsumeResult(null, false, false, false);
    L17:
        return new PayloadConsumeResult(r16, true, false, true);
    L7:
        r5 = new AnonymousClass1(this, r11);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object awaitIfReady(WidgetPayloadCacheKey r10, long r11, Continuation<? super PayloadConsumeResult> r12) {
        if ((r12 instanceof C01991) == false) goto L7;
        C01991 r5 = (C01991) r12;
        int r13 = r5.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r5.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r5.label;
        if (r16 == 0) goto L16;
        if (r16 == 1) goto L15;
        if (r16 != 2) goto L14;
        ResultKt.throwOnFailure(r14);
    L38:
        PrefetchedWidgetPayload r17 = (PrefetchedWidgetPayload) r14;
    L40:
        if (r17 == null) goto L42;
        boolean r18 = true;
    L44:
        return new PayloadConsumeResult(r17, false, true, r18);
    L42:
        r18 = false;
        goto L44
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r14);
    L34:
        r17 = (PrefetchedWidgetPayload) r14;
        goto L40
    L16:
        ResultKt.throwOnFailure(r14);
        PrefetchedWidgetPayload r19 = this.cache.get(r10);
        if (r19 != null) goto L19;
        m0 r20 = this.inFlight.get(r10);
        if (r20 != 0) goto L25;
        return new PayloadConsumeResult(null, false, false, false);
    L25:
        if (r11 == 0) goto L27;
    L30:
        if (r11 <= 0) goto L35;
        WidgetPayloadPrefetchCoordinator$awaitIfReady$payload$1 r110 = new WidgetPayloadPrefetchCoordinator$awaitIfReady$payload$1(r20, null);
        r5.label = 1;
        r14 = e2.b(r11, r110, r5);
        if (r14 != r15) goto L34;
        return r15;
    L35:
        r5.label = 2;
        r14 = r20.d(r5);
        if (r14 != r15) goto L38;
        return r15;
    L27:
        if (((r1) r20).isCompleted() == true) goto L30;
        return new PayloadConsumeResult(null, false, true, false);
    L19:
        return new PayloadConsumeResult(r19, true, false, true);
    L7:
        r5 = new C01991(this, r12);
        goto L8
    }

    public final void clear(WidgetPayloadCacheKey r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        this.cache.remove(r5);
        Job r10 = (m0) this.inFlight.remove(r5);
        if (r10 == null) goto L6;
        ((r1) r10).cancel(null);
        return;
    }

    public final void clearInstance(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "hostId");
        Set r5 = SetsKt.plus(this.cache.keySet(), this.inFlight.keySet());
        ArrayList r12 = new ArrayList();
        Iterator r13 = r5.iterator();
    L4:
        if (r13.hasNext() == false) goto L10;
        Object r14 = r13.next();
        WidgetPayloadCacheKey r15 = (WidgetPayloadCacheKey) r14;
        if (Intrinsics.areEqual(r15.getHostId(), r10) == false) goto L4;
        if (r15.getInstanceId() != r11) goto L4;
        r12.add(r14);
        goto L4
    L10:
        Iterator r16 = CollectionsKt.distinct(r12).iterator();
    L12:
        if (r16.hasNext() == false) goto L14;
        clear((WidgetPayloadCacheKey) r16.next());
        goto L12
    }

    public final m0 getInFlightOrNull(WidgetPayloadCacheKey r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        return this.inFlight.get(r5);
    }

    public final Object getOrStartPrefetch(CoroutineScope r11, WidgetPayloadCacheKey r12, Function1<? super Continuation<? super String>, ? extends Object> r13, String r14, Continuation<? super Pair<? extends m0, Boolean>> r15) {
        if ((r15 instanceof C02001) == false) goto L7;
        C02001 r5 = (C02001) r15;
        int r10 = r5.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r10 - Integer.MIN_VALUE;
    L8:
        Object r16 = r5.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r18 = r5.label;
        if (r18 == 0) goto L14;
        if (r18 != 1) goto L13;
        kotlinx.coroutines.sync.a r19 = (kotlinx.coroutines.sync.a) r5.L$5;
        String r110 = (String) r5.L$4;
        Function1<? super Continuation<? super String>, ? extends Object> r111 = (Function1) r5.L$3;
        r12 = (WidgetPayloadCacheKey) r5.L$2;
        r11 = (CoroutineScope) r5.L$1;
        WidgetPayloadPrefetchCoordinator r20 = (WidgetPayloadPrefetchCoordinator) r5.L$0;
        ResultKt.throwOnFailure(r16);
        kotlinx.coroutines.sync.a r112 = r19;
        Function1<? super Continuation<? super String>, ? extends Object> r21 = r111;
        String r22 = r110;
        WidgetPayloadPrefetchCoordinator this = r20;
    L33:
        m0 r113 = this.inFlight.get(r12);     // Catch: Throwable -> L26
        if (r113 == null) goto L28;
        Pair r114 = TuplesKt.to(r113, Boxing.boxBoolean(true));     // Catch: Throwable -> L26
    L29:
        ((kotlinx.coroutines.sync.d) r112).d(null);
        return r114;
    L28:
        CoroutineScope r23 = r11;
        m0 r115 = BuildersKt.async$default(r23, null, null, new WidgetPayloadPrefetchCoordinator$getOrStartPrefetch$3$deferred$1(r21, r22, this, r12, null), 3, null);     // Catch: Throwable -> L26
        this.inFlight.put(r12, r115);     // Catch: Throwable -> L26
        r114 = TuplesKt.to(r115, Boxing.boxBoolean(false));     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        ((kotlinx.coroutines.sync.d) r112).d(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        m0 r116 = this.inFlight.get(r12);
        if (r116 != null) goto L17;
        kotlinx.coroutines.sync.a r117 = this.mutex;
        r5.L$0 = this;
        r5.L$1 = r11;
        r5.L$2 = r12;
        r5.L$3 = r13;
        r5.L$4 = r14;
        r5.L$5 = r117;
        r5.label = 1;
        kotlinx.coroutines.sync.d r118 = (kotlinx.coroutines.sync.d) r117;
        if (r118.c(r5) != r17) goto L21;
        return r17;
    L21:
        r21 = r13;
        r22 = r14;
        r112 = r118;
        goto L33
    L17:
        return TuplesKt.to(r116, Boxing.boxBoolean(true));
    L7:
        r5 = new C02001(this, r15);
        goto L8
    }

    public final PrefetchedWidgetPayload peek(WidgetPayloadCacheKey r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        return this.cache.get(r5);
    }
}
