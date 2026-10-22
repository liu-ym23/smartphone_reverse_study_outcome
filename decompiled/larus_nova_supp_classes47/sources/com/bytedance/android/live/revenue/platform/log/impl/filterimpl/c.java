package com.bytedance.android.live.revenue.platform.log.impl.filterimpl;

import am2.t;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.filter.s;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.google.gson.JsonElement;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mz0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends a implements g {
    public c(o<Object> r2) {
        Intrinsics.checkNotNullParameter(r2, FileUtils.FILTER);
        super(r2);
    }

    @Override // mz0.g
    public final Map<String, String> a(IRoom r6) {
        s r0 = this.a;
        if ((r0 instanceof s) == true) goto L5;
        s r1 = null;
    L7:
        if (r1 == null) goto L32;
        t r2 = r0.getData();
        if (r2 == null) goto L27;
        Map r3 = r2.d;
        if (r3 == null) goto L27;
        if (r6 == null) goto L14;
        long r4 = r6.getRoomId();
    L15:
        String r7 = (String) r3.get(Long.valueOf(r4));
        if (r7 == null) goto L27;
        HashMap r5 = new HashMap();
        Iterator r8 = GsonHelper.parser().parse(r7).getAsJsonObject().entrySet().iterator();     // Catch: Throwable -> L23
    L20:
        if (r8.hasNext() == false) goto L26;
        Map.Entry r9 = (Map.Entry) r8.next();     // Catch: Throwable -> L23
        r5.put(r9.getKey(), ((JsonElement) r9.getValue()).getAsString());     // Catch: Throwable -> L23
    L26:
        return Collections.synchronizedMap(r5);
    L23:
        th = move-exception;
        th.getMessage();
        goto L26
    L14:
        r4 = 0;
    L27:
        t r10 = this.a.getData();
        if (r10 != null) goto L30;
        return null;
    L30:
        return r10.b();
    L32:
        return MapsKt.emptyMap();
    L5:
        r1 = r0;
        goto L7
    }
}
