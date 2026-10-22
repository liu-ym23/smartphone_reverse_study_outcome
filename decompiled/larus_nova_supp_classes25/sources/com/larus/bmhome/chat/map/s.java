package com.larus.bmhome.chat.map;

import com.google.gson.Gson;
import com.larus.bmhome.chat.layout.item.w1;
import com.larus.utils.cache.DiskCache;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import wq9.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s {
    public static final Gson a = null;
    public static final CoroutineScope b = null;
    public static final DiskCache c = null;
    public static final Map<String, List<a>> d = null;

    static {
        a = new Gson();
        b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        c = new DiskCache("plugin-data-map");
        d = new LinkedHashMap();
    }

    public static void a(String r7, w1 r8) {
        Intrinsics.checkNotNullParameter(r7, "messageId");
        Intrinsics.checkNotNullParameter(r8, "callback");
        Map<String, List<a>> r1 = d;
        if (r1.containsKey(r7) == false) goto L5;
        FLogger.a.d("PoiRouteStore", "[readPolylineByMessageId] from memory with messageId:".concat(r7));
        r8.invoke(((LinkedHashMap) r1).get(r7));
        return;
    L5:
        Intrinsics.checkNotNullParameter(r7, "messageId");
        if (c.b(r7) == false) goto L10;
        BuildersKt.launch$default(b, null, null, new PoiRouteStore$readPolylineByMessageId$1(r7, r8, null), 3, null);
        return;
    }
}
