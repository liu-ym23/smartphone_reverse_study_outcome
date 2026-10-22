package com.larus.utils.cache;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.GlobalScope;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class DiskCache {
    public static final ExecutorCoroutineDispatcher d = null;
    public final String a;
    public final long b;
    public final Lazy c;

    public static final class a {
    }

    static {
        d = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new com.larus.utils.cache.a()));
    }

    public DiskCache(String r3) {
        Intrinsics.checkNotNullParameter(r3, "dir");
        this.a = r3;
        this.b = 10485760;
        this.c = LazyKt.lazy(new b(this));
    }

    public static String a(String r1) {
        ByteString.Companion.getClass();
        return ByteString.a.b(r1).md5().hex();
    }

    public final boolean b(String r11) {
        Intrinsics.checkNotNullParameter(r11, "key");
        Intrinsics.checkNotNullParameter(r11, "key");
        boolean r1 = true;
        if (r11.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L20;
        Object r2 = null;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L12
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new DiskCache$getCacheFileSync$1$1$1(this, r11, null), 3, null);     // Catch: Throwable -> L12
        String r12 = AppHost.a.getApplication().getCacheDir() + '/' + this.a + '/' + a(r11) + ".0";     // Catch: Throwable -> L12
        if (new PolarisFileWrapper(r12).exists() == false) goto L20;
    L22:
        if (r12.length() == 0) goto L25;
        r1 = false;
    L25:
        if (r1 == false) goto L28;
        return false;
    L28:
        return new PolarisFileWrapper(r12).exists();
    L12:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Object r13 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r13) == true) goto L17;
        r2 = r13;
    L17:
        Object r5 = (Void) r2;
        if (r5 == null) goto L20;
        r12 = (String) r5;
    L20:
        r12 = "";
        goto L22
    L5:
        r0 = false;
        goto L6
    }

    public final Object c(String r4, Continuation<? super String> r5) {
        return BuildersKt.withContext(d, new DiskCache$getString$2(r4, this, null), r5);
    }

    public final Object e(String r4, Continuation<? super Boolean> r5) {
        return BuildersKt.withContext(d, new DiskCache$remove$2(this, r4, null), r5);
    }

    public final Object d(String r4, String r5, Continuation<Object> r6) {
        return BuildersKt.withContext(d, new DiskCache$put$4(r4, this, r5, null), r6);
    }
}
