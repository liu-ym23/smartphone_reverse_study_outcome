package com.larus.bmhome.view.actionbar.custom.cache;

import android.os.SystemClock;
import android.util.LruCache;
import com.bytedance.keva.Keva;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.view.actionbar.custom.CustomActionBarViewModel;
import com.larus.bmhome.view.actionbar.custom.l;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ActionBarCacheStore {
    public static final ActionBarCacheStore a = null;
    public static final Keva b = null;
    public static final Lazy c = null;
    public static final LruCache<String, List<z0>> d = null;
    public static final Object e = null;
    public static final ConcurrentHashMap<String, CompletableDeferred<List<z0>>> f = null;
    public static final MutexImpl g = null;
    public static Pair<String, ? extends List<z0>> h;
    public static final LruCache<String, List<z0>> i = null;

    public ActionBarCacheStore() {
    }

    static {
        a = new ActionBarCacheStore();
        b = Keva.getRepo(CustomActionBarViewModel.CACHE_FILE);
        c = LazyKt.lazy(new a());
        d = new LruCache(10);
        e = new Object();
        f = new ConcurrentHashMap();
        g = kotlinx.coroutines.sync.b.a();
        i = new LruCache(10);
    }

    public static ConcurrentHashMap g() {
        return (ConcurrentHashMap) c.getValue();
    }

    public static List e(String r2) {
        Object r0 = e;
        monitor-enter(r0);
        List<z0> r3 = d.get(r2);     // Catch: Throwable -> L11
        if (r3 == null) goto L8;
        List r4 = CollectionsKt.toList(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);
        return r4;
    L8:
        r4 = null;
    L11:
        th = move-exception;
        throw th;
    }

    public static boolean i(String r5) {
        if (r5 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == true) goto L18;
        if (r5 != null) goto L11;
    L13:
        boolean r6 = false;
    L14:
        if (r6 == true) goto L19;
        return false;
    L19:
        return true;
    L11:
        if (StringsKt.contains$default(r5, "aippt", false, 2, null) != true) goto L13;
        r6 = true;
        goto L14
    L18:
        return true;
    L5:
        if (StringsKt.contains$default(r5, "doc", false, 2, null) != true) goto L7;
        r4 = true;
        goto L8
    }

    public static List d(String r9, boolean r10) {
        long r1 = SystemClock.elapsedRealtime();
        String r11 = b.getString(r9, "");
        if (r11 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if (r3 == false) goto L29;
        FLogger.a.i("ActionBarCacheStore", "getCacheConfig, has no cache");
        return null;
    L29:
        List r12 = (List) xt7.d.b.c(kuc.a.d(kuc.a.b(z0.Companion.serializer())), r11);     // Catch: Exception -> L24
        if (r12 != null) goto L16;
        r12 = CollectionsKt.emptyList();     // Catch: Exception -> L24
    L16:
        FLogger.a.d("ActionBarCacheStore", "get cache and json parse cache cost: " + (SystemClock.elapsedRealtime() - r1));     // Catch: Exception -> L24
        ArrayList r0 = new ArrayList();     // Catch: Exception -> L24
        Iterator r13 = r12.iterator();     // Catch: Exception -> L24
    L17:
        if (r13.hasNext() == false) goto L23;
        Object r2 = r13.next();     // Catch: Exception -> L24
        if (o0.d(((z0) r2).e) == false) goto L17;
        r0.add(r2);     // Catch: Exception -> L24
        goto L17
    L23:
        return r0;
    L24:
        e = move-exception;
        FLogger.a.e("ActionBarCacheStore", "getCacheConfig, err.msg=" + e.getMessage());
        if (r10 == true) goto L28;
        return null;
    L28:
        return new ArrayList();
    L5:
        if (r11.length() == 0) goto L8;
        r3 = false;
        goto L10
    }

    public static List h(String r2, l r3) {
        Intrinsics.checkNotNullParameter(r2, "content");
        Intrinsics.checkNotNullParameter(r3, "parseCallback");
        Pair<String, ? extends List<z0>> r0 = h;
        if (r0 == null) goto L5;
        String r1 = (String) r0.getFirst();
    L7:
        if (Intrinsics.areEqual(r2, r1) == false) goto L12;
        Pair<String, ? extends List<z0>> r4 = h;
        if (r4 != null) goto L11;
        return null;
    L11:
        return (List) r4.getSecond();
    L12:
        LruCache<String, List<z0>> r5 = i;
        List<z0> r6 = r5.get(r2);
        if (r6 != null) goto L17;
        r6 = (List) r3.invoke(r2);
        if (r6 == null) goto L17;
        r5.put(r2, r6);
    L17:
        h = TuplesKt.to(r2, r6);
        return r6;
    L5:
        r1 = null;
        goto L7
    }

    public final Object j(Function0<Unit> r8, Continuation<? super Unit> r9) {
        if ((r9 instanceof ActionBarCacheStore$runRemoteStoreOnIo$1) == false) goto L7;
        ActionBarCacheStore$runRemoteStoreOnIo$1 r0 = (ActionBarCacheStore$runRemoteStoreOnIo$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L18;
        kotlinx.coroutines.sync.a r11 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L15
    L27:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r11.unlock(null);
        return Unit.INSTANCE;
    L15:
        th = move-exception;
        kotlinx.coroutines.sync.a r13 = r11;
        th = th;
    L32:
        r13.unlock(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.sync.a r14 = (kotlinx.coroutines.sync.a) r0.L$1;
        Function0<Unit> r4 = (Function0) r0.L$0;
        ResultKt.throwOnFailure(r10);
        r13 = r14;
        r8 = r4;
    L36:
        CoroutineDispatcher r5 = Dispatchers.getIO();     // Catch: Throwable -> L31
        ActionBarCacheStore$runRemoteStoreOnIo$2$1 r6 = new ActionBarCacheStore$runRemoteStoreOnIo$2$1(r8, null);     // Catch: Throwable -> L31
        r0.L$0 = r13;     // Catch: Throwable -> L31
        r0.L$1 = null;     // Catch: Throwable -> L31
        r0.label = 2;     // Catch: Throwable -> L31
        if (BuildersKt.withContext(r5, r6, r0) != r2) goto L26;
        return r2;
    L26:
        r11 = r13;
    L31:
        th = th;
        goto L32
    L20:
        ResultKt.throwOnFailure(r10);
        r13 = g;
        r0.L$0 = r8;
        r0.L$1 = r13;
        r0.label = 1;
        if (r13.a(null, r0) != r2) goto L36;
        return r2;
    L7:
        r0 = new ActionBarCacheStore$runRemoteStoreOnIo$1(this, r9);
        goto L8
    }

    public static void a(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "langCode");
        String r0 = AccountService.a.getUserId();
        if (r3 != null) goto L5;
        return;
    L5:
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        String r5 = f(r0, r2, r3, r4);
        FLogger.a.i("ActionBarCacheStore", "clearMemoryCache, cacheKey=" + r5);
        g().remove(r5);
        Object r6 = e;
        monitor-enter(r6);
        List<z0> r7 = d.remove(r5);     // Catch: Throwable -> L12
        monitor-exit(r6);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static List b(String r5, String r6, String r7, Function1 r8) {
        Intrinsics.checkNotNullParameter(r5, "langCode");
        String r0 = AccountService.a.getUserId();
        if (r6 != null) goto L6;
        return null;
    L6:
        if (i(r7) == false) goto L8;
        return null;
    L8:
        if (r7 != null) goto L10;
        r7 = "";
    L10:
        String r9 = f(r0, r5, r6, r7);
        boolean r1 = false;
        if (com.larus.platform.exp.a.a == false) goto L50;
        List r10 = e(r9);
        if (r10 != null) goto L34;
        CompletableDeferred<List<z0>> r11 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        ConcurrentHashMap<String, CompletableDeferred<List<z0>>> r12 = f;
        if (r12.putIfAbsent(r9, r11) == null) goto L80;
        r10 = e(r9);
        goto L34
    L80:
        List r2 = e(r9);     // Catch: Throwable -> L46
        if (r2 != null) goto L31;
        List r3 = d(r9, false);     // Catch: Throwable -> L46
        if (r3 == null) goto L30;
        g().remove(r9);     // Catch: Throwable -> L46
        Object r4 = e;     // Catch: Throwable -> L46
        monitor-enter(r4);     // Catch: Throwable -> L46
        List<z0> r13 = d.put(r9, CollectionsKt.toList(r3));     // Catch: Throwable -> L27
        monitor-exit(r4);     // Catch: Throwable -> L46
    L32:
        r12.remove(r9, r11);     // Catch: Throwable -> L46
        r11.complete(r3);     // Catch: Throwable -> L46
        r10 = r3;
        goto L34
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L46
    L30:
        r3 = null;
        goto L32
    L31:
        r3 = r2;
    L46:
        th = move-exception;
        f.remove(r9, r11);
        r11.completeExceptionally(th);
        throw th;
    L34:
        if (r10 != null) goto L36;
        return null;
    L36:
        if (r8 == null) goto L44;
        ArrayList r14 = new ArrayList();
        Iterator r15 = r10.iterator();
    L39:
        if (r15.hasNext() == false) goto L43;
        Object r16 = r15.next();
        if (((Boolean) r8.invoke(r16)).booleanValue() == false) goto L39;
        r14.add(r16);
        goto L39
    L43:
        r10 = r14;
    L44:
        FLogger.a.i("ActionBarCacheStore", "getCacheConfig, cacheKey=" + r9 + ", result=" + r10.size());
        return r10;
    L50:
        if (g().containsKey(r9) == false) goto L54;
        FLogger.a.i("ActionBarCacheStore", "getCacheConfig, hit cache");
        ArrayList r17 = new ArrayList();
        List r18 = (List) g().get(r9);
        List r19 = r17;
        if (r18 == null) goto L55;
        r17.addAll(r18);
        r19 = r17;
    L55:
        if (r19 != null) goto L57;
    L58:
        r1 = true;
    L59:
        if (r1 == false) goto L61;
        r19 = d(r9, true);
    L61:
        FLogger r20 = FLogger.a;
        StringBuilder r21 = new StringBuilder("getCacheConfig, cacheKey=");
        r21.append(r9);
        r21.append(", result=");
        if (r19 == null) goto L64;
        Integer r22 = Integer.valueOf(r19.size());
    L65:
        r21.append(r22);
        r20.i("ActionBarCacheStore", r21.toString());
        List r23 = r19;
        if (r19 != null) goto L68;
        return null;
    L68:
        if (r8 == null) goto L76;
        ArrayList r24 = new ArrayList();
        Iterator r25 = r19.iterator();
    L71:
        if (r25.hasNext() == false) goto L75;
        Object r26 = r25.next();
        if (((Boolean) r8.invoke(r26)).booleanValue() == false) goto L71;
        r24.add(r26);
        goto L71
    L75:
        r23 = r24;
    L76:
        g().put(r9, r23);
        return r23;
    L64:
        r22 = null;
        goto L65
    L57:
        if (r19.isEmpty() == false) goto L59;
    L54:
        r19 = null;
        goto L55
    }

    public static String f(String r2, String r3, String r4, String r5) {
        if (r5.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L15;
        IActionBarService r6 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r6 == null) goto L11;
        String r7 = r6.n();
    L13:
        return r2 + '-' + r3 + '-' + r4 + r7;
    L11:
        r7 = null;
        goto L13
    L15:
        return r2 + '-' + r3 + '-' + r4 + '-' + r5;
    L5:
        r0 = false;
        goto L7
    }

    public static void k(String r2, String r3, String r4, List r5) {
        Intrinsics.checkNotNullParameter(r2, "langCode");
        Intrinsics.checkNotNullParameter(r5, "actionBarItemList");
        String r0 = AccountService.a.getUserId();
        if (r3 != null) goto L5;
        return;
    L5:
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        String r6 = f(r0, r2, r3, r4);
        FLogger.a.i("ActionBarCacheStore", "storeMemoryCache, cacheKey=" + r6 + " actionBarItemSize=" + r5.size());
        if (com.larus.platform.exp.a.a == false) goto L17;
        g().remove(r6);
        Object r7 = e;
        monitor-enter(r7);
        List<z0> r8 = d.put(r6, CollectionsKt.toList(r5));     // Catch: Throwable -> L14
        monitor-exit(r7);
        return;
    L14:
        th = move-exception;
        throw th;
    L17:
        g().put(r6, r5);
    }

    public static /* synthetic */ List c(String r2, String r3, String r4, com.larus.bmhome.view.actionbar.custom.k r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r5 = null;
    L12:
        return b(r2, r3, r4, r5);
    }
}
