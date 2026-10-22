package com.bytedance.android.annie.lynx.service.latch;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.annie.service.data.DataProviderService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements com.bytedance.android.latch.a.b {
    public static final /* synthetic */ int i = 0;
    public final Context a;
    public final Uri b;
    public final String c;
    public final Long d;
    public final com.bytedance.android.annie.param.a e;
    public final Map<String, Object> f;
    public final Map<String, com.bytedance.android.annie.api.data.subscribe.g<?>> g;
    public final Lazy h;

    public static final class a {
        public a() {
        }

        public static final JsonObject a(Uri r10) {
            int r0 = c.i;
            JsonObject r1 = new JsonObject();
            Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L9
            Iterator r12 = UriProtector.getQueryParameterNames(r10).iterator();     // Catch: Throwable -> L9
        L5:
            if (r12.hasNext() == false) goto L7;
            String r13 = (String) r12.next();     // Catch: Throwable -> L9
            r1.addProperty(r13, UriProtector.getQueryParameter(r10, r13));     // Catch: Throwable -> L9
            goto L5
        L7:
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
        L11:
            return r1;
        L9:
            th = move-exception;
            Result.Companion r14 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L11
        }
    }

    static {
        new a();
    }

    public final Map<String, Object> getGlobalProps() {
        return (Map) this.h.getValue();
    }

    public final Object a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Object r0 = ((LinkedHashMap) this.f).get(r10);
        if (r0 == null) goto L5;
        return r0;
    L5:
        DataProviderService.ImitateRedisEngine r1 = DataProviderService.g;
        Pair r11 = DataProviderService.a.b(r10);
        if (r11 != null) goto L8;
        return null;
    L8:
        String r12 = (String) r11.component1();
        String r13 = (String) r11.component2();
        com.bytedance.android.annie.api.data.subscribe.g<?> r14 = (com.bytedance.android.annie.api.data.subscribe.g) ((LinkedHashMap) this.g).get(r12);
        if (r14 != null) goto L15;
        com.bytedance.android.annie.api.data.subscribe.g r15 = (com.bytedance.android.annie.api.data.subscribe.g) ((ConcurrentHashMap) com.bytedance.android.annie.service.data.b.b).get(r12);
        if (r15 != null) goto L14;
        r14 = null;
        goto L15
    L14:
        r14 = r15.c();
        this.g.put(r12, r14);
    L15:
        if (r14 != null) goto L17;
        return null;
    L17:
        JsonPrimitive r16 = r14.a(r13);
        if ((r16 instanceof JsonPrimitive) == false) goto L32;
        JsonPrimitive r17 = r16;
        if (r17.isString() == false) goto L23;
        Object r18 = r17.getAsString();
    L38:
        if (r18 == null) goto L41;
        this.f.put(r10, r18);
        return r18;
    L41:
        return null;
    L23:
        if (r17.isNumber() == false) goto L29;
        double r19 = r17.getAsDouble();
        if ((r19 - Math.floor(r19)) >= 1.0E-10d) goto L27;
        r18 = Long.valueOf((long) r19);
        goto L38
    L27:
        r18 = Double.valueOf(r19);
        goto L38
    L29:
        if (r17.isBoolean() == false) goto L37;
        r18 = Boolean.valueOf(r17.getAsBoolean());
    L37:
        r18 = null;
        goto L38
    L32:
        if ((r16 instanceof JsonObject) == false) goto L35;
        r18 = UtilsKt.i((JsonObject) r16);
        goto L38
    L35:
        if ((r16 instanceof JsonArray) == false) goto L37;
        r18 = CollectionsKt.toList((Iterable) r16);
        goto L38
    }

    public c(Context r10, Uri r11, String r12, Long r13) {
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_URL);
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = null;
        this.f = new LinkedHashMap();
        this.g = new LinkedHashMap();
        this.h = LazyKt.lazy(new LatchDataHolderImpl$globalProps$2(this));
    }
}
