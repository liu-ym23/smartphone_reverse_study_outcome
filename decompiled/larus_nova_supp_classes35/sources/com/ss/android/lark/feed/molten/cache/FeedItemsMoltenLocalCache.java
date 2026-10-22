package com.ss.android.lark.feed.molten.cache;

import com.google.gson.Gson;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.molten.cache.user.FeedUserHolderLocalCache;
import com.ss.android.lark.feed.molten.cache.utils.FeedItemsLocalCacheUtil;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import geb.c;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Singleton
public final class FeedItemsMoltenLocalCache implements com.ss.android.lark.feed.molten.cache.b {
    public static final com.ss.android.lark.storage.a i = null;
    public final AtomicBoolean a;
    public final Lazy b;
    public final ConcurrentHashMap<String, FeedUserHolderLocalCache> c;
    public final Object d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final AtomicBoolean h;

    /* JADX INFO: renamed from: com.ss.android.lark.feed.molten.cache.FeedItemsMoltenLocalCache$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.feed.molten.cache.FeedItemsMoltenLocalCache$1", f = "FeedItemsMoltenLocalCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ FeedItemsMoltenLocalCache this$0;

        public AnonymousClass1(FeedItemsMoltenLocalCache r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L18;
            ResultKt.throwOnFailure(r7);
            CoroutineScope r8 = (CoroutineScope) this.L$0;
            FeedItemsMoltenLocalCache r9 = this.this$0;
            com.ss.android.lark.storage.a r0 = FeedItemsMoltenLocalCache.i;
            Set<String> r10 = r9.j();
            c.d("FeedItemsMoltenLocalCache", "preload known uids size=" + r10.size());
            FeedItemsMoltenLocalCache r1 = this.this$0;
            Iterator<T> r11 = r10.iterator();
        L6:
            if (r11.hasNext() == false) goto L15;
            String r2 = (String) r11.next();
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L10
            Object r4 = Result.constructor-impl(r1.g(r2));     // Catch: Throwable -> L10
        L12:
            Throwable r5 = Result.exceptionOrNull-impl(r4);
            if (r5 == null) goto L6;
            c.b("FeedItemsMoltenLocalCache", "preload ensureHolder failed, uid=" + r2, r5);
        L10:
            th = move-exception;
            Result.Companion r6 = Result.Companion;
            r4 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L12
        L15:
            this.this$0.h();
            return Unit.INSTANCE;
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class a {
    }

    public static final class b implements ttb.a {
        public final /* synthetic */ FeedItemsMoltenLocalCache a;

        public b(FeedItemsMoltenLocalCache r1) {
            this.a = r1;
        }

        public final void a(String r5) {
            Intrinsics.checkNotNullParameter(r5, "uid");
            if (r5.length() != 0) goto L5;
            boolean r0 = true;
        L7:
            if (r0 == false) goto L10;
            c.a("FeedItemsMoltenLocalCache", "callback onUserOnline skip, uid is empty");
            return;
        L10:
            c.c("FeedItemsMoltenLocalCache", "callback onUserOnline uid=" + r5);
            FeedItemsMoltenLocalCache r1 = this.a;
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
            com.ss.android.lark.storage.a r3 = FeedItemsMoltenLocalCache.i;     // Catch: Throwable -> L13
            Object r4 = Result.constructor-impl(r1.g(r5));     // Catch: Throwable -> L13
        L15:
            Throwable r6 = Result.exceptionOrNull-impl(r4);
            if (r6 == null) goto L21;
            c.b("FeedItemsMoltenLocalCache", "onUserOnline ensureHolder failed, uid=" + r5, r6);
            return;
        L21:
            return;
        L13:
            th = move-exception;
            Result.Companion r7 = Result.Companion;
            r4 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L15
        L5:
            r0 = false;
            goto L7
        }

        public final void b(String r4) {
            Intrinsics.checkNotNullParameter(r4, "uid");
            if (r4.length() != 0) goto L5;
            boolean r0 = true;
        L7:
            if (r0 == false) goto L10;
            c.a("FeedItemsMoltenLocalCache", "callback onUserOffline skip, uid is empty");
            return;
        L10:
            c.d("FeedItemsMoltenLocalCache", "callback onUserOffline uid=" + r4);
            this.a.f(r4);
            return;
        L5:
            r0 = false;
            goto L7
        }
    }

    static {
        i = new com.ss.android.lark.storage.a("feed::molten::index");
    }

    @Override // com.ss.android.lark.feed.molten.cache.b
    public final boolean c() {
        return this.a.get();
    }

    public final void h() {
        if (this.h.compareAndSet(false, true) == true) goto L20;
        return;
    L20:
        stb.a r1 = (stb.a) LarkContext.spiByDwarf(stb.a.class);     // Catch: Throwable -> L7
    L9:
        if (r1 != null) goto L22;
        c.a("FeedItemsMoltenLocalCache", "ensureUserIdListener skip, officeSDKUserApi is null");
        this.h.set(false);
        return;
    L22:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
        r1.Y0(new b(this));     // Catch: Throwable -> L14
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r4 = Result.exceptionOrNull-impl(r2);
        if (r4 == null) goto L24;
        c.b("FeedItemsMoltenLocalCache", "registerUserIdChanged failed", r4);
        this.h.set(false);
        return;
    L24:
        return;
    L14:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        th = move-exception;
        c.b("FeedItemsMoltenLocalCache", "spiByDwarf(officeSDKUserApi) failed", th);
        r1 = null;
        goto L9
    }

    public final FeedUserHolderLocalCache i() {
        stb.a r2 = (stb.a) LarkContext.spiByDwarf(stb.a.class);     // Catch: Throwable -> L5
    L7:
        if (r2 == null) goto L9;
        String r3 = r2.a();
    L10:
        boolean r4 = false;
        if (r3 != null) goto L13;
    L18:
        if (r4 == true) goto L21;
        c.a("FeedItemsMoltenLocalCache", "hostUid is empty, register user id listener");
        h();
        return null;
    L21:
        c.c("FeedItemsMoltenLocalCache", "hostUid=" + r3);
        return g(r3);
    L13:
        if (r3.length() != 0) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == true) goto L18;
        r4 = true;
        goto L18
    L15:
        r5 = false;
        goto L16
    L9:
        r3 = null;
    L5:
        th = move-exception;
        c.b("FeedItemsMoltenLocalCache", "spiByDwarf(officeSDKUserApi) failed", th);
        r2 = null;
        goto L7
    }

    public final Set<String> j() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Set r1 = ((KVRepo) this.e.getValue()).getStringSet("known_uids", SetsKt.emptySet());     // Catch: Throwable -> L7
        if (r1 != null) goto L5;
        r1 = SetsKt.emptySet();     // Catch: Throwable -> L7
    L5:
        Object r2 = Result.constructor-impl(r1);     // Catch: Throwable -> L7
    L9:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L12;
        c.b("FeedItemsMoltenLocalCache", "readKnownUids failed", r3);
    L12:
        Set r4 = SetsKt.emptySet();
        if (Result.isFailure-impl(r2) == false) goto L16;
        r2 = r4;
    L16:
        return (Set) r2;
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    @Inject
    public FeedItemsMoltenLocalCache() {
        this.a = new AtomicBoolean(false);
        this.b = LazyKt.lazy(FeedItemsMoltenLocalCache$gson$2.INSTANCE);
        this.c = new ConcurrentHashMap();
        this.d = new Object();
        this.e = LazyKt.lazy(FeedItemsMoltenLocalCache$indexRepo$2.INSTANCE);
        this.f = LazyKt.lazy(FeedItemsMoltenLocalCache$clearScope$2.INSTANCE);
        Lazy r0 = LazyKt.lazy(FeedItemsMoltenLocalCache$preloadScope$2.INSTANCE);
        this.g = r0;
        this.h = new AtomicBoolean(false);
        c.c("FeedItemsMoltenLocalCache", "preload all known uids");
        BuildersKt.launch$default((CoroutineScope) r0.getValue(), null, null, new AnonymousClass1(this, null), 3, null);
    }

    @Override // com.ss.android.lark.feed.molten.cache.b
    public final com.ss.android.lark.feed.molten.cache.a b() {
        FeedUserHolderLocalCache r0 = i();
        if (r0 != null) goto L7;
        c.d("FeedItemsMoltenLocalCache", "restoreHumanSidebarFeedItems skip, no current uid");
        return null;
    L7:
        return r0.g();
    }

    @Override // com.ss.android.lark.feed.molten.cache.b
    public final List<UIFeedCard> d() {
        FeedUserHolderLocalCache r0 = i();
        if (r0 != null) goto L5;
        c.d("FeedItemsMoltenLocalCache", "restoreLatestFeedItems skip, no current uid");
        List<UIFeedCard> r1 = CollectionsKt.emptyList();
    L7:
        if ((!r1.isEmpty()) == false) goto L9;
        this.a.compareAndSet(false, true);
    L9:
        return r1;
    L5:
        r1 = r0.h();
        goto L7
    }

    @Override // com.ss.android.lark.feed.molten.cache.b
    public final void f(String r8) {
        Intrinsics.checkNotNullParameter(r8, "uid");
        boolean r1 = true;
        if (r8.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        c.a("FeedItemsMoltenLocalCache", "clearLocalCacheData skip, uid is empty");
        return;
    L9:
        c.c("FeedItemsMoltenLocalCache", "clearLocalCacheData uid = " + r8);
        Object r2 = this.d;
        monitor-enter(r2);
        FeedUserHolderLocalCache r3 = this.c.remove(r8);     // Catch: Throwable -> L19
        if (r3 == null) goto L15;
        r3.d();     // Catch: Throwable -> L19
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L16:
        monitor-exit(r2);
        c.d("FeedItemsMoltenLocalCache", "clearLocalCacheData enqueue, uid=" + r8 + ", disposedActive=" + r1);
        this.a.set(false);
        BuildersKt.launch$default((CoroutineScope) this.f.getValue(), null, null, new FeedItemsMoltenLocalCache$clearLocalCacheData$2(this, r8, null), 3, null);
        return;
    L15:
        r1 = false;
    L19:
        th = move-exception;
        throw th;
    L5:
        r0 = false;
        goto L6
    }

    public final FeedUserHolderLocalCache g(String r7) {
        FeedUserHolderLocalCache r2 = this.c.get(r7);
        if (r2 == null) goto L5;
        return r2;
    L5:
        Object r3 = this.d;
        monitor-enter(r3);
        FeedUserHolderLocalCache r4 = this.c.get(r7);     // Catch: Throwable -> L23
        if (r4 != null) goto L21;
        r4 = new FeedUserHolderLocalCache(r7, (Gson) this.b.getValue());     // Catch: Throwable -> L23
        r4.i();     // Catch: Throwable -> L23
        this.c.put(r7, r4);     // Catch: Throwable -> L23
        c.d("FeedItemsMoltenLocalCache", "ensureHolder created for uid=".concat(r7));     // Catch: Throwable -> L23
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L16
        Set<String> r5 = j();     // Catch: Throwable -> L16
        if (r5.contains(r7) == true) goto L14;
        ((KVRepo) this.e.getValue()).putStringSet("known_uids", SetsKt.plus(r5, r7));     // Catch: Throwable -> L16
    L14:
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r8 = Result.exceptionOrNull-impl(r6);     // Catch: Throwable -> L23
        if (r8 == null) goto L21;
        c.b("FeedItemsMoltenLocalCache", "addKnownUid failed, uid=".concat(r7), r8);     // Catch: Throwable -> L23
        goto L21
    L16:
        th = move-exception;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L23
        r6 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L23
    L21:
        monitor-exit(r3);
        return r4;
    L23:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.feed.molten.cache.b
    public final void e(List<? extends UIFeedCard> r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "latestItems");
        FeedUserHolderLocalCache r1 = i();
        if (r1 != null) goto L6;
        c.a("FeedItemsMoltenLocalCache", "syncLatestFeedItems skip, no current uid");
        return;
    L6:
        Intrinsics.checkNotNullParameter(r4, "latestItems");
        List<UIFeedCard> r6 = FeedItemsLocalCacheUtil.b(r4, r5);
        r1.f.set(r6);
        Object r0 = r1.e.trySend-JP2dKIU(Unit.INSTANCE);
        StringBuilder r2 = new StringBuilder("syncLatestFeedItems enqueue, inputSize:");
        r2.append(r4.size());
        r2.append(", normalizedSize:");
        r2.append(r6.size());
        r2.append(", success:");
        g.c r7 = g.b;
        r2.append(!(r0 instanceof g.c));
        r2.append(", closed:");
        r2.append(r0 instanceof g.a);
        c.c("FeedUserHolderLocalCache", r2.toString());
    }

    @Override // com.ss.android.lark.feed.molten.cache.b
    public final void a(List r4, boolean r5, long r6) {
        Intrinsics.checkNotNullParameter(r4, "latestItems");
        FeedUserHolderLocalCache r1 = i();
        if (r1 != null) goto L6;
        c.a("FeedItemsMoltenLocalCache", "syncHumanSidebarFeedItems skip, no current uid");
        return;
    L6:
        Intrinsics.checkNotNullParameter(r4, "latestItems");
        r1.h.set(new com.ss.android.lark.feed.molten.cache.a(FeedItemsLocalCacheUtil.a(r4), r5, r6));
        r1.g.trySend-JP2dKIU(Unit.INSTANCE);
    }
}
