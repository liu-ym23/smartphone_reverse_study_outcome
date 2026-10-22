package com.larus.bmhome.chat.trace.appreciable;

import com.google.gson.reflect.TypeToken;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class z {
    public static final Type a = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/bmhome/chat/trace/appreciable/ChatMobUtilKt$ANY_MAP_TYPE$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<Map<Object, ? extends Object>> {
        public a() {
        }
    }

    static {
        a = new a().getType();
    }

    public static final Map<String, String> a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "logTag");
        LinkedHashMap r0 = new LinkedHashMap();     // Catch: Throwable -> L11
        zd9.h.a.getClass();     // Catch: Throwable -> L11
        Map r5 = (Map) zd9.h.b.fromJson(r3, a);     // Catch: Throwable -> L11
        if (r5 != null) goto L6;
        r5 = MapsKt.emptyMap();     // Catch: Throwable -> L11
    L6:
        Iterator r6 = r5.entrySet().iterator();     // Catch: Throwable -> L11
    L7:
        if (r6.hasNext() == false) goto L17;
        Map.Entry r1 = (Map.Entry) r6.next();     // Catch: Throwable -> L11
        r0.put(String.valueOf(r1.getKey()), String.valueOf(r1.getValue()));     // Catch: Throwable -> L11
        goto L7
    L17:
        return r0;
    L11:
        th = move-exception;
        FLogger.a.e(r4, "toStringMap err=" + th.getMessage());
        return new LinkedHashMap();
    }
}
