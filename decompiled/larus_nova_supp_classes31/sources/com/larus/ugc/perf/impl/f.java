package com.larus.ugc.perf.impl;

import android.text.TextUtils;
import android.util.LruCache;
import com.google.gson.reflect.TypeToken;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.delegate.c0;
import com.tencent.open.log.TraceLevel;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f {
    public static final f a = null;
    public static final LruCache<String, e> b = null;
    public static final HashMap<Integer, d> c = null;
    public static final ConcurrentHashMap<String, Function2<String, Integer, Unit>> d = null;

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class a extends TypeToken<List<? extends com.larus.ugc.perf.impl.a>> {
        public a() {
        }
    }

    public f() {
    }

    static {
        a = new f();
        b = new LruCache(10);
        c = new HashMap();
        d = new ConcurrentHashMap();
    }

    public static List a(Message r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        String r7 = tz9.a.b(r6);
        if (r7 != null) goto L26;
        return null;
    L26:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L23
        zd9.h r3 = zd9.h.a;     // Catch: Throwable -> L23
        if (StringsKt.isBlank(r7) == false) goto L28;
    L20:
        Object r8 = null;
    L21:
        return (List) r8;
    L28:
        r3.getClass();     // Catch: Throwable -> L13
        r8 = Result.constructor-impl(zd9.h.b.fromJson(r7, new a().getType()));     // Catch: Throwable -> L13
    L15:
        Throwable r4 = Result.exceptionOrNull-impl(r8);     // Catch: Throwable -> L23
        if (r4 == null) goto L19;
        c0 r5 = c0.b;     // Catch: Throwable -> L23
        StringBuilder r9 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r4, "<this>");     // Catch: Throwable -> L23
        r9.append(ExceptionsKt.stackTraceToString(r4));     // Catch: Throwable -> L23
        r5.e("GsonHolder", r9.toString());     // Catch: Throwable -> L23
    L19:
        if (Result.isFailure-impl(r8) == false) goto L21;
    L13:
        th = move-exception;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L23
        r8 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return null;
    }

    public static e b(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return null;
    L5:
        if (r2 != null) goto L7;
        return null;
    L7:
        return b.get(r2);
    }

    public static void c(int r1, d r2) {
        Intrinsics.checkNotNullParameter(r2, "tracker");
        Integer r3 = Integer.valueOf(r1);
        c.put(r3, r2);
    }
}
