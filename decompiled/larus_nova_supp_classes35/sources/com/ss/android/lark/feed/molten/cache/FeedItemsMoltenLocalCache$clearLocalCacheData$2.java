package com.ss.android.lark.feed.molten.cache;

import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.storage.kv.repo.KVRepoConfig;
import com.ss.android.lark.storage.transformer.EncryptTransformer;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import geb.c;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.feed.molten.cache.FeedItemsMoltenLocalCache$clearLocalCacheData$2", f = "FeedItemsMoltenLocalCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FeedItemsMoltenLocalCache$clearLocalCacheData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $uid;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FeedItemsMoltenLocalCache this$0;

    public FeedItemsMoltenLocalCache$clearLocalCacheData$2(FeedItemsMoltenLocalCache r1, String r2, Continuation<? super FeedItemsMoltenLocalCache$clearLocalCacheData$2> r3) {
        this.this$0 = r1;
        this.$uid = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        FeedItemsMoltenLocalCache$clearLocalCacheData$2 r0 = new FeedItemsMoltenLocalCache$clearLocalCacheData$2(this.this$0, this.$uid, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L30;
        ResultKt.throwOnFailure(r6);
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        FeedItemsMoltenLocalCache r8 = this.this$0;
        String r0 = this.$uid;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        com.ss.android.lark.storage.a r2 = FeedItemsMoltenLocalCache.i;     // Catch: Throwable -> L11
        Set<String> r3 = r8.j();     // Catch: Throwable -> L11
        if (r3.contains(r0) == false) goto L9;
        ((KVRepo) r8.e.getValue()).putStringSet("known_uids", SetsKt.minus(r3, r0));     // Catch: Throwable -> L11
    L9:
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        String r4 = this.$uid;
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L16;
        c.b("FeedItemsMoltenLocalCache", "clearLocalCacheData removeKnownUid failed, uid=" + r4, r10);
    L16:
        String r11 = this.$uid;
        LarkKVStorage r5 = LarkKVStorage.a;     // Catch: Throwable -> L19
        LarkAppContext.Companion.getClass();     // Catch: Throwable -> L19
        LarkKVStorage.KVStorageBuilder r12 = new LarkKVStorage.KVStorageBuilder(LarkAppContext.access$getInstance$cp().getContext());     // Catch: Throwable -> L19
        LarkKVStorage.KVStorageBuilder.c(r12, r11);     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(KVRepoConfig.Mode.SINGLE_PROCESS, "mode");     // Catch: Throwable -> L19
        EncryptTransformer.b r13 = new EncryptTransformer.b(false);     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r13, "proxyProvider");     // Catch: Throwable -> L19
        r12.c.add(r13);     // Catch: Throwable -> L19
        LarkKVStorage.d(r5, r12.b(), new com.ss.android.lark.storage.a("feed::molten"), "feed:items").clear();     // Catch: Throwable -> L19
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        String r15 = this.$uid;
        Throwable r16 = Result.exceptionOrNull-impl(r14);
        if (r16 == null) goto L24;
        c.a("FeedItemsMoltenLocalCache", "clearLocalCacheData clear failed, uid=" + r15 + ", error=" + r16);
    L24:
        String r17 = this.$uid;
        if (Result.isSuccess-impl(r14) == false) goto L28;
        Unit r18 = (Unit) r14;
        c.d("FeedItemsMoltenLocalCache", "clearLocalCacheData clear finish, uid=" + r17);
    L28:
        return Unit.INSTANCE;
    L19:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
    L11:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L30:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
