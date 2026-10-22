package com.bytedance.android.ec.core.monitor;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetchResponse;
import com.bytedance.android.ec.core.utils.Json;
import com.bytedance.android.ec.model.BlenderResponse;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class w implements Interceptor {
    public w() {
    }

    public final SsResponse<?> intercept(Interceptor.Chain r10) {
        Intrinsics.checkNotNullParameter(r10, "chain");
        Request r0 = r10.request();
        SsResponse<?> r1 = r10.proceed(r0);
        LinkedHashMap<Object, SsResponse<?>> r11 = s.a;
        Intrinsics.checkNotNullParameter(r0, "request");
        boolean r12 = false;
        Object r13 = null;
        if (StringsKt.contains$default(r0.getPath(), "/ecom/product/detail/stream", false, 2, null) == false) goto L13;
        if (r1 == null) goto L8;
        Object r14 = r1.body();
        if (r14 == null) goto L8;
        s.a.put(r14, r1);
    L8:
        LinkedHashMap<Object, SsResponse<?>> r15 = s.a;
        if (r15.size() <= 3) goto L13;
        Object r16 = CollectionsKt.firstOrNull(r15.keySet());
        if (r16 == null) goto L13;
        r15.remove(r16);
    L13:
        int r17 = i.a;
        String r18 = r10.request().getPath();
        Lazy r19 = Json.a;
        List<String> r20 = ((ECPathWhiteLists) GsonProtectorUtils.fromJson((Gson) Json.a.getValue(), ECSettingKeys.L0(), ECPathWhiteLists.class)).getPaths();
        if (r20 == null) goto L25;
        Iterator<T> r21 = r20.iterator();
    L17:
        if (r21.hasNext() == false) goto L21;
        Object r22 = r21.next();
        if (Intrinsics.areEqual((String) r22, r18) == false) goto L17;
    L23:
        if (((String) r22) == null) goto L25;
        r12 = true;
        goto L25
    L21:
        r22 = null;
    L25:
        if (r12 == false) goto L49;
        if (r1 != null) goto L50;
    L32:
        Object r23 = null;
    L33:
        if (r1 == null) goto L36;
        r13 = r1.body();     // Catch: Exception -> L30
    L36:
        if ((r13 instanceof CommerceBaseResponse) == false) goto L39;
        ((CommerceBaseResponse) r13).setTtNetExtraInfo(r23);     // Catch: Exception -> L30
        ((CommerceBaseResponse) r13).setEcNetRequestEnd(Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L30
        goto L49
    L39:
        if ((r13 instanceof com.bytedance.android.ec.model.g) == false) goto L42;
        ((com.bytedance.android.ec.model.g) r13).ttNetExtraInfo = r23;     // Catch: Exception -> L30
        ((com.bytedance.android.ec.model.g) r13).ecNetRequestEnd = Long.valueOf(System.currentTimeMillis());     // Catch: Exception -> L30
        goto L49
    L42:
        if ((r13 instanceof NativePrefetchResponse) == false) goto L45;
        ((NativePrefetchResponse) r13).setTtNetExtraInfo(r23);     // Catch: Exception -> L30
        ((NativePrefetchResponse) r13).setEcNetRequestEnd(Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L30
        goto L49
    L45:
        if ((r13 instanceof BlenderResponse) == false) goto L49;
        ((BlenderResponse) r13).setTtNetExtraInfo(r23);     // Catch: Exception -> L30
        ((BlenderResponse) r13).setEcNetRequestEnd(Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L30
        goto L49
    L50:
        Response r24 = r1.raw();     // Catch: Exception -> L30
        if (r24 == null) goto L32;
        r23 = r24.getExtraInfo();     // Catch: Exception -> L30
    L30:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L49:
        return r1;
    }
}
