package com.ss.android.lark.chat.chatwindow.chat.preloaderv2;

import android.util.LruCache;
import com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.DataPreLoaderType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.r;
import com.ss.android.lark.passportc.dwarf.UserScope;
import f0c.h;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class DataPreloadEngineV2 implements c, r {
    public static final int i = 0;
    public final m a;
    public final Map<DataPreLoaderType, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<? extends w3b.d<?>, ?>>> b;
    public CoroutineScope c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lock h;

    public static final class a {
    }

    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    static {
        i = Runtime.getRuntime().availableProcessors() + 3;
    }

    public final m getPassport() {
        return this.a;
    }

    public final void onUserOffline(h r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r3, "state");
        CoroutineScope r4 = this.c;
        if (r4 == null) goto L5;
        CoroutineScopeKt.cancel$default(r4, null, 1, null);
    L5:
        this.c = null;
    }

    @Inject
    public DataPreloadEngineV2(m r2, Map<DataPreLoaderType, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<? extends w3b.d<?>, ?>>> r3) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        Intrinsics.checkNotNullParameter(r3, "loaders");
        this.a = r2;
        this.b = r3;
        r2.d(this);
        LazyThreadSafetyMode r4 = LazyThreadSafetyMode.SYNCHRONIZED;
        this.d = LazyKt.lazy(r4, DataPreloadEngineV2$preloaderExecutor$2.INSTANCE);
        this.e = LazyKt.lazy(r4, new DataPreloadEngineV2$dispatcher$2(this));
        this.f = LazyKt.lazy(r4, DataPreloadEngineV2$preloadResultCache$2.INSTANCE);
        this.g = LazyKt.lazy(r4, DataPreloadEngineV2$dataPreLoadJobPool$2.INSTANCE);
        this.h = new ReentrantLock();
    }

    public final <S> void b(w3b.c<S> r13, com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<w3b.d<S>, S> r14) {
        Intrinsics.checkNotNullParameter(r13, "job");
        Intrinsics.checkNotNullParameter(r14, "loader");
        String r5 = r13.a;
        ((LruCache) this.g.getValue()).put(r5, r13);
        Log.i("DataPreloadEngineV2", "Execute：" + r5);
        if (this.c != null) goto L5;
        this.c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus((ExecutorCoroutineDispatcher) this.e.getValue()));
    L5:
        CoroutineScope r0 = this.c;
        if (r0 == null) goto L9;
        BuildersKt.launch$default(r0, (ExecutorCoroutineDispatcher) this.e.getValue(), null, new DataPreloadEngineV2$load$1(r14, r13, this, r5, null), 2, null);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.preloaderv2.c
    public final <S> void a(String r7, w3b.d<S> r8, Function1<? super Result<? extends S>, Unit> r9) {
        Intrinsics.checkNotNullParameter(r7, "key");
        Intrinsics.checkNotNullParameter(r8, "task");
        Intrinsics.checkNotNullParameter(r9, "callback");
        ((ReentrantLock) this.h).lock();
        Object r3 = ((Map) this.f.getValue()).remove(r7);     // Catch: Throwable -> L34
        com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<w3b.d<S>, S> r5 = null;
        if ((r3 instanceof Result) == false) goto L7;
        Result r4 = (Result) r3;     // Catch: Throwable -> L34
    L9:
        if (r4 != null) goto L11;
        Object r1 = ((LruCache) this.g.getValue()).get(r7);     // Catch: Throwable -> L34
        if ((r1 instanceof w3b.c) == false) goto L18;
        w3b.c r2 = (w3b.c) r1;     // Catch: Throwable -> L34
    L19:
        if (r2 == null) goto L21;
        r2.c = r9;     // Catch: Throwable -> L34
    L30:
        ((ReentrantLock) this.h).unlock();
        return;
    L21:
        Log.e("DataPreloadEngineV2", "Failed to find task when fetch data：" + r7);     // Catch: Throwable -> L34
        w3b.c<S> r0 = new w3b.c(r7, r8, r9);     // Catch: Throwable -> L34
        Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<? extends w3b.d<?>, ?>> r10 = this.b.get(r8.type());     // Catch: Throwable -> L34
        if (r10 == null) goto L24;
        com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<w3b.d<S>, S> r11 = (com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c) r10.get();     // Catch: Throwable -> L34
    L26:
        if ((r11 instanceof com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c) == false) goto L28;
        r5 = r11;
    L28:
        if (r5 != null) goto L32;
        Log.e("DataPreloaderV2", "Could not find a loader for target task");     // Catch: Throwable -> L34
        goto L30
    L32:
        b(r0, r5);     // Catch: Throwable -> L34
        goto L30
    L24:
        r11 = null;
        goto L26
    L18:
        r2 = null;
        goto L19
    L11:
        if (Result.isSuccess-impl(r4.unbox-impl()) == false) goto L13;
        Log.i("DataPreloadEngineV2", "Task:" + r7 + " Fetch data after task finish, return result");     // Catch: Throwable -> L34
    L14:
        r9.invoke(r4);     // Catch: Throwable -> L34
        goto L30
    L13:
        Log.e("DataPreloadEngineV2", "Task: " + r7 + " Fetch data after task finish, return error:" + Result.exceptionOrNull-impl(r4.unbox-impl()));     // Catch: Throwable -> L34
        goto L14
    L7:
        r4 = null;
    L34:
        th = move-exception;
        ((ReentrantLock) this.h).unlock();
        throw th;
    }
}
