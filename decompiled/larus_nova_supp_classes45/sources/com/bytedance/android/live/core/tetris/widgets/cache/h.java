package com.bytedance.android.live.core.tetris.widgets.cache;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class h {
    public final Map<String, Map<Class<? extends com.bytedance.android.live.core.tetris.widgets.a>, com.bytedance.android.live.core.tetris.widgets.a>> a;

    public void a() {
        Map<String, Map<Class<? extends com.bytedance.android.live.core.tetris.widgets.a>, com.bytedance.android.live.core.tetris.widgets.a>> r0 = this.a;
        if (r0 == null) goto L13;
        Collection r1 = ((LinkedHashMap) r0).values();
        if (r1 == null) goto L13;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        Iterator r3 = ((Map) r2.next()).values().iterator();
    L11:
        if (r3.hasNext() == false) goto L8;
        ((com.bytedance.android.live.core.tetris.widgets.a) r3.next()).clearAfterDestroyed();
    L13:
        ((LinkedHashMap) this.a).clear();
    }

    public h() {
        this.a = new LinkedHashMap();
    }

    public final void b(String r8) {
        Intrinsics.checkNotNullParameter(r8, "cacheKey");
        int r1 = b.a;
        Map<String, Map<Class<? extends com.bytedance.android.live.core.tetris.widgets.a>, com.bytedance.android.live.core.tetris.widgets.a>> r2 = this.a;
        Intrinsics.checkNotNullParameter(r2, "cache");
        Intrinsics.checkNotNullParameter(r8, "cacheKey");
        if (MultiRoomConfig.INSTANCE.enableComponentCacheFullLog() == false) goto L15;
        Iterator r0 = ((LinkedHashMap) r2).entrySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L18;
        Map.Entry r3 = (Map.Entry) r0.next();
        StringBuilder r4 = new StringBuilder("Cache is ");
        r4.append(r8);
        r4.append(" , ");
        r4.append((String) r3.getKey());
        r4.append(" , size = ");
        Map r5 = (Map) r3.getValue();
        if (r5 == null) goto L10;
        Integer r6 = Integer.valueOf(r5.size());
    L11:
        r4.append(r6.intValue());
        ALogger.i("ComponentCacheLog", r4.toString());
        Iterator r7 = ((Map) r3.getValue()).entrySet().iterator();
    L13:
        if (r7.hasNext() == false) goto L6;
        ALogger.i("ComponentCacheLog", "Cache is " + r8 + " , " + ((com.bytedance.android.live.core.tetris.widgets.a) ((Map.Entry) r7.next()).getValue()).getClass().getName());
        goto L13
    L10:
        r6 = null;
        goto L11
    L18:
        return;
    }

    public final void c(String r3, Map<Class<? extends com.bytedance.android.live.core.tetris.widgets.a>, ? extends com.bytedance.android.live.core.tetris.widgets.a> r4) {
        Intrinsics.checkNotNullParameter(r3, "uniqueID");
        Intrinsics.checkNotNullParameter(r4, "widgets");
        LinkedHashMap r0 = (LinkedHashMap) this.a;
        Object r1 = r0.get(r3);
        if (r1 != null) goto L5;
        r1 = new LinkedHashMap();
        r0.put(r3, r1);
    L5:
        ((Map) r1).putAll(r4);
    }
}
