package com.larus.community.impl.cache;

import android.os.Looper;
import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.community.impl.repository.CommunityCreationRecommendRepository;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class CreationListCacheDataSource {
    public static final CreationListCacheDataSource a = null;
    public static final ConcurrentHashMap<String, z0<CreationFeedCacheEntity>> b = null;
    public static final ConcurrentHashMap<String, Boolean> c = null;
    public static final Keva d = null;
    public static final Lazy e = null;
    public static Job f;

    public CreationListCacheDataSource() {
    }

    static {
        a = new CreationListCacheDataSource();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        d = Keva.getRepo("creation_feed_local_cache", 0);
        e = LazyKt.lazy(new a());
    }

    public static String b(String r2) {
        return "creation_local_cache_" + AccountService.a.getSecUserId() + '_' + r2;
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
        boolean r0 = m29.a.a;
        m29.a.b("CreationListCacheDataSource", "prefetch callback failed, updateCache:" + r3 + ", error:" + th.getMessage());
    }

    public static void d(String r13, CommunityCreationRecommendRepository r14, Function1 r15) {
        Intrinsics.checkNotNullParameter(r14, "creationFeedRepository");
        if (r13 != null) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L15;
        boolean r16 = m29.a.a;
        m29.a.c("CreationListCacheDataSource", "prefetch fail creationRecommendType is " + r13);
        if (r15 == null) goto L17;
        r15.invoke(Boolean.FALSE);
        return;
    L17:
        return;
    L15:
        boolean r1 = m29.a.a;
        m29.a.c("CreationListCacheDataSource", "start prefetch, creationRecommendType:" + r13);
        String r3 = b(r13);
        b.put(r3, j1.a(null));
        d.storeString(r3, "");
        Ref.ObjectRef r6 = new Ref.ObjectRef();
        r6.element = r15;
        final Job r17 = BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new CreationListCacheDataSource$prefetch$job$1(r3, r14, r13, r6, null), 2, null);
        f = r17;
        r17.invokeOnCompletion(new b(r17));
        return;
    L5:
        if (r13.length() == 0) goto L8;
        r0 = false;
        goto L10
    }

    public final Object e(String r5, CreationFeedCacheEntity r6, Continuation<? super Unit> r7) {
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
        boolean r13 = m29.a.a;
        m29.a.c("CreationListCacheDataSource", "[updateLocalCreationCache] cacheKey = " + r9);
        d.storeString(r9, r12);
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
        r9 = b(r5);
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

    public static CreationFeedCacheEntity c(CreationListCacheDataSource r2, String r3, boolean r4, boolean r5, int r6) {
        boolean r1 = true;
        if ((r6 & 2) == 0) goto L6;
        r4 = true;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = true;
    L8:
        r2.getClass();
        if (r4 == false) goto L14;
        Job r7 = f;
        if (r7 == null) goto L13;
        Job.DefaultImpls.cancel$default(r7, null, 1, null);
    L13:
        f = null;
    L14:
        if (r3 == null) goto L55;
        String r8 = b(r3);
        boolean r9 = m29.a.a;
        m29.a.c("CreationListCacheDataSource", "[getCreationFromCache] cacheKey = " + r8);
        z0<CreationFeedCacheEntity> r10 = b.get(r8);
        if (r10 == null) goto L19;
        CreationFeedCacheEntity r11 = (CreationFeedCacheEntity) r10.getValue();
    L20:
        if (r11 != null) goto L46;
        if (r5 == true) goto L24;
    L44:
        m29.a.a("CreationListCacheDataSource", new c());
    L45:
        r11 = null;
        goto L46
    L24:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L44;
        m29.a.c("CreationListCacheDataSource", "[getCreationFromLocal] cacheKey = " + r8);
        String r12 = d.getString(r8, "");
        if (r12 != null) goto L29;
    L32:
        if (r1 == false) goto L51;
        r11 = null;
    L42:
        if (r11 == null) goto L45;
    L51:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L36
        Object r14 = Result.constructor-impl((CreationFeedCacheEntity) ((Gson) e.getValue()).fromJson(r12, CreationFeedCacheEntity.class));     // Catch: Throwable -> L36
    L39:
        if (Result.isFailure-impl(r14) == false) goto L41;
        r14 = null;
    L41:
        r11 = (CreationFeedCacheEntity) r14;
    L36:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    L29:
        if (r12.length() == 0) goto L32;
        r1 = false;
    L46:
        if (r11 != null) goto L48;
        return null;
    L48:
        if (Intrinsics.areEqual(r11.getCreationRecommendType(), r3) == true) goto L50;
        return null;
    L50:
        return r11;
    L19:
        r11 = null;
        goto L20
    L55:
        return null;
    }
}
