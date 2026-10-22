package com.ss.android.lark.feed.molten.cache.user;

import com.google.gson.Gson;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.molten.cache.utils.FeedItemsLocalCacheUtil;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FeedUserHolderLocalCache {
    public static final /* synthetic */ int p = 0;
    public final String a;
    public final Gson b;
    public final ExecutorCoroutineDispatcher c;
    public final CoroutineScope d;
    public final Channel<Unit> e;
    public final AtomicReference<List<UIFeedCard>> f;
    public final Channel<Unit> g;
    public final AtomicReference<com.ss.android.lark.feed.molten.cache.a> h;
    public final Lazy i;
    public volatile List<String> j;
    public volatile Map<String, ? extends UIFeedCard> k;
    public volatile List<? extends UIFeedCard> l;
    public final CompletableDeferred<List<UIFeedCard>> m;
    public final CompletableDeferred<com.ss.android.lark.feed.molten.cache.a> n;
    public volatile com.ss.android.lark.feed.molten.cache.a o;

    public static final class a {
    }

    public static final class b implements ThreadFactory {
        public final /* synthetic */ FeedUserHolderLocalCache a;

        public b(FeedUserHolderLocalCache r1) {
            this.a = r1;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r4) {
            PthreadThreadV2 r0 = new PthreadThreadV2(r4, "feed-molten-local-cache-" + this.a.a);
            r0.setDaemon(true);
            return r0;
        }
    }

    static {
    }

    public final void d() {
        geb.c.d("FeedUserHolderLocalCache", "UserHolder dispose");
        if (this.m.isCompleted() == true) goto L6;
        this.m.complete(CollectionsKt.emptyList());
    L6:
        if (this.n.isCompleted() == true) goto L8;
        this.n.complete(null);
    L8:
        SendChannel.a.a(this.e);
        SendChannel.a.a(this.g);
        CoroutineScopeKt.cancel$default(this.d, null, 1, null);
        this.c.close();
    }

    public final KVRepo e() {
        return (KVRepo) this.i.getValue();
    }

    public final com.ss.android.lark.feed.molten.cache.a g() {
        com.ss.android.lark.feed.molten.cache.a r0 = this.o;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return (com.ss.android.lark.feed.molten.cache.a) BuildersKt.runBlocking$default(null, new FeedUserHolderLocalCache$restoreHumanSidebarFeedItems$1(this, null), 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<UIFeedCard> h() {
        List r0 = this.l;
        boolean r1 = !r0.isEmpty();
        List r2 = r0;
        if (r1 == true) goto L6;
        r2 = null;
    L6:
        if (r2 == null) goto L8;
        return r2;
    L8:
        return (List) BuildersKt.runBlocking$default(null, new FeedUserHolderLocalCache$restoreLatestFeedItems$2(this, null), 1, null);
    }

    public final void i() {
        geb.c.d("FeedUserHolderLocalCache", "UserHolder start");
        BuildersKt.launch$default(this.d, null, null, new FeedUserHolderLocalCache$start$1(this, null), 3, null);
        BuildersKt.launch$default(this.d, null, null, new FeedUserHolderLocalCache$start$2(this, null), 3, null);
    }

    public FeedUserHolderLocalCache(String r4, Gson r5) {
        Intrinsics.checkNotNullParameter(r4, "uid");
        Intrinsics.checkNotNullParameter(r5, "gson");
        this.a = r4;
        this.b = r5;
        ExecutorCoroutineDispatcher r6 = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new b(this)));
        this.c = r6;
        this.d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(r6));
        this.e = ChannelKt.Channel$default(-1, null, null, 6, null);
        this.f = new AtomicReference(null);
        this.g = ChannelKt.Channel$default(-1, null, null, 6, null);
        this.h = new AtomicReference(null);
        this.i = LazyKt.lazy(new FeedUserHolderLocalCache$repo$2(this));
        this.j = CollectionsKt.emptyList();
        this.k = MapsKt.emptyMap();
        this.l = CollectionsKt.emptyList();
        this.m = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.n = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004a -> B:18:0x004d). Please report as a decompilation issue!!! */
    public static final Object a(FeedUserHolderLocalCache r7, Continuation r8) {
        r7.getClass();
        if ((r8 instanceof FeedUserHolderLocalCache$consumeHumanSidebarSyncRequests$1) == false) goto L7;
        FeedUserHolderLocalCache$consumeHumanSidebarSyncRequests$1 r0 = (FeedUserHolderLocalCache$consumeHumanSidebarSyncRequests$1) r8;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ChannelIterator r4 = (ChannelIterator) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L19:
        if (((Boolean) r9).booleanValue() == false) goto L35;
        r4.next();
    L21:
        com.ss.android.lark.feed.molten.cache.a r10 = r7.h.getAndSet(null);
        if (r10 == null) goto L15;
        if (Intrinsics.areEqual(r7.o, r10) == true) goto L21;
        r7.o = r10;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L29
        r7.e().putString("human_sidebar:snapshot:v1", r7.b.toJson(r10));     // Catch: Throwable -> L29
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L21;
        geb.c.b("FeedUserHolderLocalCache", "syncHumanSidebarFeedItems failed", r12);
    L29:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L15:
        r0.L$0 = r4;
        r0.label = 1;
        r9 = r4.hasNext(r0);
        if (r9 != r2) goto L19;
        return r2;
    L35:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        r4 = r7.g.iterator();
    L7:
        r0 = new FeedUserHolderLocalCache$consumeHumanSidebarSyncRequests$1(r7, r8);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0063 -> B:13:0x0032). Please report as a decompilation issue!!! */
    public static final Object b(FeedUserHolderLocalCache r7, Continuation r8) {
        r7.getClass();
        if ((r8 instanceof FeedUserHolderLocalCache$consumeSyncRequests$1) == false) goto L7;
        FeedUserHolderLocalCache$consumeSyncRequests$1 r0 = (FeedUserHolderLocalCache$consumeSyncRequests$1) r8;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L17;
        if (r3 == 1) goto L16;
        if (r3 != 2) goto L15;
        ChannelIterator r4 = (ChannelIterator) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L13:
        ChannelIterator r10 = r4;
    L25:
        List<UIFeedCard> r5 = r7.f.getAndSet(null);
        if (r5 == null) goto L18;
        r0.L$0 = r10;
        r0.label = 2;
        if (r7.j(r5, r0) != r2) goto L25;
        return r2;
    L18:
        r0.L$0 = r10;
        r0.label = 1;
        Object r6 = r10.hasNext(r0);
        if (r6 == r2) goto L36;
        r4 = r10;
        r9 = r6;
    L23:
        if (((Boolean) r9).booleanValue() == false) goto L32;
        r4.next();
        goto L13
    L32:
        return Unit.INSTANCE;
    L36:
        return r2;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r4 = (ChannelIterator) r0.L$0;
        ResultKt.throwOnFailure(r9);
        goto L23
    L17:
        ResultKt.throwOnFailure(r9);
        r10 = r7.e.iterator();
    L7:
        r0 = new FeedUserHolderLocalCache$consumeSyncRequests$1(r7, r8);
        goto L8
    }

    public static final Object c(FeedUserHolderLocalCache r19, Continuation r20) {
        r19.getClass();
        if ((r20 instanceof FeedUserHolderLocalCache$restoreLatestFeedItemsActual$1) == false) goto L7;
        FeedUserHolderLocalCache$restoreLatestFeedItemsActual$1 r2 = (FeedUserHolderLocalCache$restoreLatestFeedItemsActual$1) r20;
        int r3 = r2.label;
        if ((r3 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r2.label = r3 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        long r6 = r2.J$0;
        List r7 = (List) r2.L$0;
        ResultKt.throwOnFailure(r0);
    L60:
        LinkedHashMap r8 = new LinkedHashMap();
        Iterator r1 = ((List) r0).iterator();
    L62:
        if (r1.hasNext() == false) goto L66;
        Pair r9 = (Pair) r1.next();
        String r10 = (String) r9.component1();
        UIFeedCard r11 = (UIFeedCard) r9.component2();
        if (r11 == null) goto L62;
        r11.setFlowDisplayType(UIFeedCard.FlowDisplayType.KV_STORAGE);
        r8.put(r10, r11);
        goto L62
    L66:
        ArrayList r12 = new ArrayList();
        Iterator r13 = r7.iterator();
    L68:
        if (r13.hasNext() == false) goto L72;
        Object r14 = r13.next();
        if (r8.containsKey((String) r14) == false) goto L68;
        r12.add(r14);
        goto L68
    L72:
        ArrayList r15 = new ArrayList();
        Iterator r16 = r12.iterator();
    L74:
        if (r16.hasNext() == false) goto L78;
        UIFeedCard r17 = (UIFeedCard) r8.get((String) r16.next());
        if (r17 == null) goto L74;
        r15.add(r17);
        goto L74
    L78:
        r19.k(r12, r8);
        TimedValue r18 = new TimedValue(r15, TimeSource.Monotonic.ValueTimeMark.elapsedNow-UwyO8pc(r6), null);
        List r21 = (List) r18.component1();
        geb.c.d("FeedUserHolderLocalCache", "restoreLatestFeedItemsActual finish, size:" + r21.size() + ", cost:" + Duration.toString-impl(r18.component2-UwyO8pc()));
        if (r19.m.isCompleted() == true) goto L82;
        r19.m.complete(r21);
    L82:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        long r22 = TimeSource.Monotonic.INSTANCE.markNow-z9LOYto();
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L17
        Object r24 = Result.constructor-impl(r19.e().getString("order:v2", null));     // Catch: Throwable -> L17
    L19:
        Throwable r25 = Result.exceptionOrNull-impl(r24);
        if (r25 == null) goto L23;
        geb.c.a("FeedUserHolderLocalCache", "readOrderIdsFromStorage failed: " + r25);
    L23:
        if (Result.isFailure-impl(r24) == false) goto L25;
        r24 = null;
    L25:
        String r26 = (String) r24;
        if (r26 != null) goto L83;
        List r27 = null;
    L31:
        Object r28 = Result.constructor-impl(r27);     // Catch: Throwable -> L28
    L34:
        Throwable r29 = Result.exceptionOrNull-impl(r28);
        if (r29 == null) goto L38;
        geb.c.a("FeedUserHolderLocalCache", "readOrderIdsFromStorage fromJson failed: " + r29);
    L38:
        if (Result.isFailure-impl(r28) == false) goto L40;
        r28 = null;
    L40:
        List r30 = (List) r28;
        if (r30 != null) goto L43;
        r30 = CollectionsKt.emptyList();
    L43:
        ArrayList r31 = new ArrayList();
        Iterator r32 = r30.iterator();
    L45:
        if (r32.hasNext() == false) goto L52;
        Object r110 = r32.next();
        if (((String) r110).length() <= 0) goto L49;
        boolean r111 = true;
    L50:
        if (r111 == false) goto L45;
        r31.add(r110);
        goto L45
    L49:
        r111 = false;
        goto L50
    L52:
        List r33 = CollectionsKt.distinct(r31);
        List r34 = r33;
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r34, 10));
        Iterator r35 = r34.iterator();
    L54:
        if (r35.hasNext() == false) goto L56;
        r112.add(BuildersKt.async$default(r19.d, Dispatchers.getIO(), null, new FeedUserHolderLocalCache$restoreLatestFeedItemsActual$2$readResults$1$1((String) r35.next(), r19, null), 2, null));
        goto L54
    L56:
        r2.L$0 = r33;
        r2.J$0 = r22;
        r2.label = 1;
        Object r36 = AwaitKt.a(r112, r2);
        if (r36 == r4) goto L108;
        r6 = r22;
        r7 = r33;
        r0 = r36;
        goto L60
    L108:
        return r4;
    L28:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r28 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L34
    L83:
        r27 = (List) r19.b.fromJson(r26, new com.ss.android.lark.feed.molten.cache.user.b().getType());     // Catch: Throwable -> L28
    L17:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r2 = new FeedUserHolderLocalCache$restoreLatestFeedItemsActual$1(r19, r20);
        goto L8
    }

    public final Object f(feb.a r21, Continuation<? super Unit> r22) {
        feb.a r0 = r21;
        if ((r22 instanceof FeedUserHolderLocalCache$persistPlan$1) == false) goto L7;
        FeedUserHolderLocalCache$persistPlan$1 r3 = (FeedUserHolderLocalCache$persistPlan$1) r22;
        int r4 = r3.label;
        if ((r4 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r3.label = r4 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L15;
        if (r6 != 1) goto L14;
        long r7 = r3.J$0;
        r0 = (feb.a) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L12:
        Object r19 = r2;
        feb.a r8 = r0;
        geb.c.d("FeedUserHolderLocalCache", "persistPlan put items finish, count:" + r8.b.size() + ", cost:" + Duration.toString-impl(new TimedValue((List) r19, TimeSource.Monotonic.ValueTimeMark.elapsedNow-UwyO8pc(r7), null).getDuration-UwyO8pc()));
        long r9 = TimeSource.Monotonic.INSTANCE.markNow-z9LOYto();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L26
        Object r10 = Result.constructor-impl(this.b.toJson(r8.a));     // Catch: Throwable -> L26
    L28:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L32;
        geb.c.a("FeedUserHolderLocalCache", "persistPlan order toJson failed, error:" + r11);
    L32:
        if (Result.isFailure-impl(r10) == false) goto L34;
        r10 = null;
    L34:
        String r12 = (String) r10;
        if (r12 != null) goto L37;
        geb.c.d("FeedUserHolderLocalCache", "persistPlan abort put order because orderJson is null");
    L38:
        geb.c.d("FeedUserHolderLocalCache", "persistPlan put order cost:" + Duration.toString-impl(new TimedValue(Unit.INSTANCE, TimeSource.Monotonic.ValueTimeMark.elapsedNow-UwyO8pc(r9), null).getDuration-UwyO8pc()));
        long r13 = TimeSource.Monotonic.INSTANCE.markNow-z9LOYto();
        Iterator<T> r14 = r8.c.iterator();
    L40:
        if (r14.hasNext() == false) goto L42;
        e().remove("item:v2:" + ((String) r14.next()));
        goto L40
    L42:
        Unit r15 = Unit.INSTANCE;
        geb.c.d("FeedUserHolderLocalCache", "persistPlan remove items finish, count:" + r8.c.size() + ", cost:" + Duration.toString-impl(new TimedValue(r15, TimeSource.Monotonic.ValueTimeMark.elapsedNow-UwyO8pc(r13), null).getDuration-UwyO8pc()));
        geb.c.d("FeedUserHolderLocalCache", "persistPlan finish");
        return r15;
    L37:
        e().putString("order:v2", r12);
    L26:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r2);
        geb.c.d("FeedUserHolderLocalCache", "persistPlan start, finalOrder:" + r0.a + ", upsertIds:" + r0.b.keySet() + ", removeIds:" + r0.c);
        long r17 = TimeSource.Monotonic.INSTANCE.markNow-z9LOYto();
        Map<String, UIFeedCard> r18 = r0.b;
        ArrayList r20 = new ArrayList(r18.size());
        Iterator<Map.Entry<String, UIFeedCard>> r23 = r18.entrySet().iterator();
    L17:
        if (r23.hasNext() == false) goto L19;
        Map.Entry<String, UIFeedCard> r110 = r23.next();
        r20.add(BuildersKt.async$default(this.d, Dispatchers.getIO(), null, new FeedUserHolderLocalCache$persistPlan$putItemsDuration$1$taskList$1$1(this, r110.getKey(), r110.getValue(), null), 2, null));
        goto L17
    L19:
        r3.L$0 = r0;
        r3.J$0 = r17;
        r3.label = 1;
        r2 = AwaitKt.a(r20, r3);
        if (r2 != r5) goto L22;
        return r5;
    L22:
        r7 = r17;
    L7:
        r3 = new FeedUserHolderLocalCache$persistPlan$1(this, r22);
        goto L8
    }

    public final Object j(List<? extends UIFeedCard> r12, Continuation<? super Unit> r13) {
        if ((r13 instanceof FeedUserHolderLocalCache$syncSnapshotInternal$1) == false) goto L7;
        FeedUserHolderLocalCache$syncSnapshotInternal$1 r0 = (FeedUserHolderLocalCache$syncSnapshotInternal$1) r13;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        feb.a r15 = (feb.a) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L50:
        geb.c.d("FeedUserHolderLocalCache", "syncSnapshotInternal finish, finalOrder:" + r15.a + ", upsertIds:" + r15.b.keySet() + ", removeIds:" + r15.c);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        List<String> r16 = this.j;
        Map<String, ? extends UIFeedCard> r4 = this.k;
        List<? extends UIFeedCard> r17 = r12;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator<T> r7 = r17.iterator();
    L16:
        if (r7.hasNext() == false) goto L18;
        r5.add(((UIFeedCard) r7.next()).getId());
        goto L16
    L18:
        LinkedHashMap r8 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r17, 10)), 16));
        Iterator<T> r18 = r17.iterator();
    L20:
        if (r18.hasNext() == false) goto L23;
        Object r6 = r18.next();
        r8.put(((UIFeedCard) r6).getId(), r6);
        goto L20
    L23:
        if (Intrinsics.areEqual(r16, r5) == false) goto L37;
        int r19 = FeedItemsLocalCacheUtil.a;
        Intrinsics.checkNotNullParameter(r4, "oldItemMap");
        Intrinsics.checkNotNullParameter(r8, "newItemMap");
        Intrinsics.checkNotNullParameter(r5, "orderIds");
        if (r5.isEmpty() == true) goto L33;
        Iterator r110 = r5.iterator();
    L29:
        if (r110.hasNext() == false) goto L33;
        String r9 = (String) r110.next();
        if (Intrinsics.areEqual(r4.get(r9), r8.get(r9)) == true) goto L29;
        boolean r111 = false;
    L34:
        if (r111 == false) goto L37;
        geb.c.c("FeedUserHolderLocalCache", "syncSnapshotInternal skip because snapshot unchanged");
        k(r5, r8);
        return Unit.INSTANCE;
    L33:
        r111 = true;
    L37:
        int r112 = FeedItemsLocalCacheUtil.a;
        Intrinsics.checkNotNullParameter(r16, "oldOrderIds");
        Intrinsics.checkNotNullParameter(r4, "oldItemMap");
        Intrinsics.checkNotNullParameter(r5, "newOrderIds");
        Intrinsics.checkNotNullParameter(r8, "newItemMap");
        Set r113 = SetsKt.minus(CollectionsKt.toSet(r16), CollectionsKt.toSet(r5));
        LinkedHashMap r114 = new LinkedHashMap();
        Iterator r10 = r5.iterator();
    L39:
        if (r10.hasNext() == false) goto L46;
        String r11 = (String) r10.next();
        UIFeedCard r20 = (UIFeedCard) r8.get(r11);
        if (r20 == null) goto L39;
        if (Intrinsics.areEqual(r4.get(r11), r20) == true) goto L39;
        r114.put(r11, r20);
        goto L39
    L46:
        feb.a r21 = new feb.a(r5, r114, r113);
        k(r5, r8);
        r0.L$0 = r21;
        r0.label = 1;
        if (f(r21, r0) != r2) goto L49;
        return r2;
    L49:
        r15 = r21;
    L7:
        r0 = new FeedUserHolderLocalCache$syncSnapshotInternal$1(this, r13);
        goto L8
    }

    public final void k(List<String> r3, Map<String, ? extends UIFeedCard> r4) {
        this.j = CollectionsKt.toList(r3);
        this.k = MapsKt.toMap(r4);
        List<String> r5 = this.j;
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        String r0 = (String) r7.next();
        UIFeedCard r1 = this.k.get(r0);
        if (r1 == null) goto L4;
        r6.add(r1);
        goto L4
    L8:
        this.l = r6;
    }
}
