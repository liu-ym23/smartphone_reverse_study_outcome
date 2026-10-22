package com.larus.bmhome.view.actionbar.edit.component;

import android.os.SystemClock;
import com.bytedance.keva.Keva;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class n2 {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(new k2());
        b = LazyKt.lazy(new l2());
    }

    public static Map a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "languageCode");
        String r11 = "style_prompt_list_" + r10;
        Lazy r0 = b;
        Integer r3 = null;
        if (((ConcurrentHashMap) r0.getValue()).containsKey(r11) == false) goto L5;
        FLogger.a.i("StylePromptListCacheStore", "getCacheConfig, hit cache");
        Map r1 = (Map) ((ConcurrentHashMap) r0.getValue()).get(r11);
    L6:
        boolean r2 = true;
        if (r1 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == false) goto L40;
        long r6 = SystemClock.elapsedRealtime();
        String r7 = ((Keva) a.getValue()).getString(r11, "");
        if (r7 != null) goto L17;
    L20:
        if (r2 == false) goto L49;
        FLogger.a.i("StylePromptListCacheStore", "getCacheConfig, has no cache");
        r1 = null;
        goto L40
    L49:
        List r4 = (List) HttpExtKt.f.fromJson(r7, new m2().getType());     // Catch: Exception -> L38
        FLogger.a.d("StylePromptListCacheStore", "get cache and json parse cache cost: " + (SystemClock.elapsedRealtime() - r6));     // Catch: Exception -> L38
        if (r4 == null) goto L34;
        ArrayList r8 = new ArrayList();     // Catch: Exception -> L38
        Iterator r9 = r4.iterator();     // Catch: Exception -> L38
    L26:
        if (r9.hasNext() == false) goto L33;
        StylePromptListApi.StylePromptInfo r12 = (StylePromptListApi.StylePromptInfo) r9.next();     // Catch: Exception -> L38
        Long r13 = r12.getId();     // Catch: Exception -> L38
        if (r13 == null) goto L30;
        Pair r14 = TuplesKt.to(Long.valueOf(r13.longValue()), r12);     // Catch: Exception -> L38
    L31:
        if (r14 == null) goto L26;
        r8.add(r14);     // Catch: Exception -> L38
        goto L26
    L30:
        r14 = null;
        goto L31
    L33:
        r1 = MapsKt.toMap(r8);     // Catch: Exception -> L38
    L35:
        if (r1 != null) goto L40;
        r1 = MapsKt.emptyMap();     // Catch: Exception -> L38
        goto L40
    L34:
        r1 = null;
    L38:
        e = move-exception;
        FLogger.a.e("StylePromptListCacheStore", "getCacheConfig, err.msg=" + e.getMessage());
        r1 = MapsKt.emptyMap();
        goto L40
    L17:
        if (r7.length() == 0) goto L20;
        r2 = false;
    L40:
        FLogger r15 = FLogger.a;
        StringBuilder r16 = new StringBuilder("getCacheConfig, cacheKey=");
        r16.append(r11);
        r16.append(", result=");
        if (r1 == null) goto L43;
        r3 = Integer.valueOf(r1.size());
    L43:
        r16.append(r3);
        r15.i("StylePromptListCacheStore", r16.toString());
        if (r1 == null) goto L46;
        ((ConcurrentHashMap) b.getValue()).put(r11, r1);
        return r1;
    L46:
        return MapsKt.emptyMap();
    L9:
        if (r1.isEmpty() == true) goto L12;
        r5 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }
}
