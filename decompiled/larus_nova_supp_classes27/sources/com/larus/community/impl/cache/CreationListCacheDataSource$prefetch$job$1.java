package com.larus.community.impl.cache;

import com.larus.platform.api.creation.CreationFeedCacheEntity;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.random.RandomKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.z0;
import zp9.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.cache.CreationListCacheDataSource$prefetch$job$1", f = "CreationListCacheDataSource.kt", i = {0}, l = {184, 202}, m = "invokeSuspend", n = {"requestRandomSeed"}, s = {"J$0"})
final class CreationListCacheDataSource$prefetch$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cacheKey;
    final /* synthetic */ n $creationFeedRepository;
    final /* synthetic */ String $creationRecommendType;
    final /* synthetic */ Ref.ObjectRef<Function1<Boolean, Unit>> $prefetchCallback;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public CreationListCacheDataSource$prefetch$job$1(String r1, n r2, String r3, Ref.ObjectRef<Function1<Boolean, Unit>> r4, Continuation<? super CreationListCacheDataSource$prefetch$job$1> r5) {
        this.$cacheKey = r1;
        this.$creationFeedRepository = r2;
        this.$creationRecommendType = r3;
        this.$prefetchCallback = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CreationListCacheDataSource$prefetch$job$1(this.$cacheKey, this.$creationFeedRepository, this.$creationRecommendType, this.$prefetchCallback, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r110) {
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = this.label;
        if (r5 == 0) goto L14;
        if (r5 == 1) goto L11;
        if (r5 != 2) goto L10;
        Ref.ObjectRef<Function1<Boolean, Unit>> r0 = (Ref.ObjectRef) this.L$2;
        String r6 = (String) this.L$1;
        zp9.c r7 = (zp9.c) this.L$0;
        ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L46 CancellationException -> L53
    L45:
        CreationListCacheDataSource.a(r0, true);     // Catch: Throwable -> L46 CancellationException -> L53
        boolean r1 = m29.a.a;     // Catch: Throwable -> L46 CancellationException -> L53
        m29.a.c("CreationListCacheDataSource", "prefetch success, cacheKey:" + r6);     // Catch: Throwable -> L46 CancellationException -> L53
    L51:
        this.$prefetchCallback.element = null;
        return Unit.INSTANCE;
    L55:
        th = move-exception;
        this.$prefetchCallback.element = null;
        throw th;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        long r11 = this.J$0;
        ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L46 CancellationException -> L53
        Object r2 = r110;
    L23:
        zp9.c r3 = (zp9.c) ((Pair) r2).getFirst();     // Catch: Throwable -> L46 CancellationException -> L53
        if (r3 == null) goto L30;
        List r8 = r3.c();     // Catch: Throwable -> L46 CancellationException -> L53
        if (r8 == null) goto L30;
        if (r8.isEmpty() != true) goto L30;
        boolean r9 = true;
    L31:
        if (r9 == false) goto L40;
        List r10 = r3.b();     // Catch: Throwable -> L46 CancellationException -> L53
        if (r10 != null) goto L35;
    L37:
        boolean r12 = false;
    L38:
        if (r12 == false) goto L40;
        m29.a.c("CreationListCacheDataSource", "prefetch: resultList is empty");     // Catch: Throwable -> L46 CancellationException -> L53
        CreationListCacheDataSource.a(this.$prefetchCallback, false);     // Catch: Throwable -> L46 CancellationException -> L53
        goto L51
    L35:
        if (r10.isEmpty() != true) goto L37;
        r12 = true;
    L40:
        if (r3 == null) goto L51;
        String r13 = this.$creationRecommendType;     // Catch: Throwable -> L46 CancellationException -> L53
        String r14 = this.$cacheKey;     // Catch: Throwable -> L46 CancellationException -> L53
        Ref.ObjectRef<Function1<Boolean, Unit>> r15 = this.$prefetchCallback;     // Catch: Throwable -> L46 CancellationException -> L53
        CreationFeedCacheEntity r16 = new CreationFeedCacheEntity(r13, r3, Boxing.boxLong(r11), Boxing.boxLong(System.currentTimeMillis()));     // Catch: Throwable -> L46 CancellationException -> L53
        CreationListCacheDataSource r17 = CreationListCacheDataSource.a;     // Catch: Throwable -> L46 CancellationException -> L53
        this.L$0 = r3;     // Catch: Throwable -> L46 CancellationException -> L53
        this.L$1 = r14;     // Catch: Throwable -> L46 CancellationException -> L53
        this.L$2 = r15;     // Catch: Throwable -> L46 CancellationException -> L53
        this.label = 2;     // Catch: Throwable -> L46 CancellationException -> L53
        if (r17.e(r13, r16, this) != r4) goto L44;
        return r4;
    L44:
        r6 = r14;
        r0 = r15;
    L30:
        r9 = false;
        goto L31
    L14:
        ResultKt.throwOnFailure(r110);
        z0<CreationFeedCacheEntity> r18 = CreationListCacheDataSource.b.get(this.$cacheKey);     // Catch: Throwable -> L46 CancellationException -> L53
        if (r18 == null) goto L18;
        CreationFeedCacheEntity r20 = (CreationFeedCacheEntity) r18.getValue();     // Catch: Throwable -> L46 CancellationException -> L53
    L19:
        if (r20 != null) goto L48;
        r11 = RandomKt.Random(System.currentTimeMillis()).nextLong();     // Catch: Throwable -> L46 CancellationException -> L53
        n r21 = this.$creationFeedRepository;     // Catch: Throwable -> L46 CancellationException -> L53
        Long r22 = Boxing.boxLong(r11);     // Catch: Throwable -> L46 CancellationException -> L53
        this.J$0 = r11;     // Catch: Throwable -> L46 CancellationException -> L53
        this.label = 1;     // Catch: Throwable -> L46 CancellationException -> L53
        r2 = n.a.a(r21, r22, this);     // Catch: Throwable -> L46 CancellationException -> L53
        if (r2 != r4) goto L23;
        return r4;
    L48:
        boolean r23 = m29.a.a;     // Catch: Throwable -> L46 CancellationException -> L53
        m29.a.c("CreationListCacheDataSource", "has cache before ,so not creationRecommendType:" + this.$creationRecommendType);     // Catch: Throwable -> L46 CancellationException -> L53
        CreationListCacheDataSource.a(this.$prefetchCallback, false);     // Catch: Throwable -> L46 CancellationException -> L53
        goto L51
    L18:
        r20 = null;
    L53:
        e = move-exception;
        throw e;     // Catch: Throwable -> L55
    L46:
        th = move-exception;
        boolean r24 = m29.a.a;     // Catch: Throwable -> L55
        m29.a.b("CreationListCacheDataSource", "prefetch failed, cacheKey:" + this.$cacheKey + ", creationRecommendType:" + this.$creationRecommendType + ", error:" + th.getMessage());     // Catch: Throwable -> L55
        CreationListCacheDataSource.a(this.$prefetchCallback, false);     // Catch: Throwable -> L55
        goto L51
    }
}
