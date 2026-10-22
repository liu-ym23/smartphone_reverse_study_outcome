package com.larus.ugc.feed.impl.cache;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.platform.api.creation.CreationFeedCacheEntity;
import com.larus.platform.service.AccountService;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CreationListCacheDataSource {
    public static final CreationListCacheDataSource a = null;
    public static final ConcurrentHashMap<String, z0<CreationFeedCacheEntity>> b = null;
    public static final ConcurrentHashMap<String, Boolean> c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;

    public CreationListCacheDataSource() {
    }

    static {
        a = new CreationListCacheDataSource();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        d = LazyKt.lazy(new a());
        e = LazyKt.lazy(new b());
    }

    public static final void a(Ref.ObjectRef r2, boolean r3) {
        Function1 r4 = (Function1) r2.element;     // Catch: Throwable -> L6
        if (r4 == null) goto L11;
        r4.invoke(Boolean.valueOf(r3));     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        boolean r0 = w0a.a.a;
        w0a.a.b("CreationListCacheDataSource", "prefetch callback failed, updateCache:" + r3 + ", error:" + th.getMessage());
    }

    public final Object b(String r5, CreationFeedCacheEntity r6, Continuation<? super Unit> r7) {
        if ((r7 instanceof CreationListCacheDataSource$updateCreationCache$1) == false) goto L7;
        CreationListCacheDataSource$updateCreationCache$1 r0 = (CreationListCacheDataSource$updateCreationCache$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r9 = (String) r0.L$1;
        r6 = (CreationFeedCacheEntity) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L34:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L24
        Object r11 = Result.constructor-impl(((Gson) e.getValue()).toJson(r6));     // Catch: Throwable -> L24
    L27:
        if (Result.isFailure-impl(r11) == false) goto L29;
        r11 = null;
    L29:
        String r12 = (String) r11;
        if (r12 == null) goto L33;
        boolean r13 = w0a.a.a;
        w0a.a.c("CreationListCacheDataSource", "[updateLocalCreationCache] cacheKey = " + r9);
        a.getClass();
        ((Keva) d.getValue()).storeString(r9, r12);
    L33:
        return Unit.INSTANCE;
    L24:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        r9 = "creation_local_cache_" + AccountService.a.getSecUserId() + '_' + r5;
        ConcurrentHashMap<String, z0<CreationFeedCacheEntity>> r15 = b;
        if (r15.get(r9) != null) goto L17;
        r15.put(r9, j1.a(r6));
        goto L34
    L17:
        z0<CreationFeedCacheEntity> r16 = r15.get(r9);
        if (r16 == null) goto L34;
        r0.L$0 = r6;
        r0.L$1 = r9;
        r0.label = 1;
        if (r16.emit(r6, r0) != r2) goto L34;
        return r2;
    L7:
        r0 = new CreationListCacheDataSource$updateCreationCache$1(this, r7);
        goto L8
    }
}
