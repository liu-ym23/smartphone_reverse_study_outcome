package com.bytedance.android.ec.core.hybrid.prefetch;

import com.byted.cast.sink.api.ServerInfo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class NativeRequestCache {
    public final Lazy a;
    public final long b;
    public final AtomicBoolean c;
    public final String d;
    public final t e;
    public final String f;
    public final JSONObject g;

    public final Map<String, String> b(Map<String, String> r10, ParamsType r11) {
        Intrinsics.checkNotNullParameter(r11, "paramType");
        LinkedHashMap r0 = new LinkedHashMap();
        if (r10 == null) goto L33;
        Iterator<Map.Entry<String, String>> r12 = r10.entrySet().iterator();
    L6:
        if (r12.hasNext() == false) goto L33;
        Map.Entry<String, String> r1 = r12.next();
        int r13 = s.a[r11.ordinal()];
        if (r13 != 1) goto L10;
        com.bytedance.android.ec.core.opt.ab.l r14 = (com.bytedance.android.ec.core.opt.ab.l) this.a.getValue();
        if (r14 == null) goto L32;
        com.bytedance.android.ec.core.opt.ab.b r15 = r14.a();
        if (r15 == null) goto L32;
        List<String> r16 = r15.a();
        if (r16 == null) goto L32;
        if (r16.contains(r1.getKey()) == true) goto L6;
    L32:
        r0.put(r1.getKey(), r1.getValue());
        goto L6
    L10:
        if (r13 != 2) goto L12;
    L14:
        com.bytedance.android.ec.core.opt.ab.l r17 = (com.bytedance.android.ec.core.opt.ab.l) this.a.getValue();
        if (r17 == null) goto L32;
        com.bytedance.android.ec.core.opt.ab.b r18 = r17.a();
        if (r18 == null) goto L32;
        List<String> r19 = r18.b();
        if (r19 == null) goto L32;
        if (r19.contains(r1.getKey()) != true) goto L32;
    L12:
        if (r13 == 3) goto L14;
    L33:
        return r0;
    }

    public NativeRequestCache(t r10, String r11, JSONObject r12) {
        Intrinsics.checkNotNullParameter(r10, "nativeRequestConfig");
        Intrinsics.checkNotNullParameter(r11, "requestId");
        this.e = r10;
        this.f = r11;
        this.g = r12;
        this.a = LazyKt.lazy(NativeRequestCache$reuseConfig$2.INSTANCE);
        this.b = System.currentTimeMillis() + ((long) ServerInfo.ERROR_INVALID_MAC);
        this.c = new AtomicBoolean(false);
        this.d = "NativeRequestCache";
    }

    public final boolean a(Map<String, String> r10, Map<String, String> r11, ParamsType r12) {
        Intrinsics.checkNotNullParameter(r12, "paramType");
        Map<String, String> r13 = b(r10, r12);
        Map<String, String> r14 = b(r11, r12);
        if ((!Intrinsics.areEqual(Integer.valueOf(r13.size()), Integer.valueOf(r14.size()))) == false) goto L5;
        return false;
    L5:
        Iterator r15 = ((LinkedHashMap) r13).entrySet().iterator();
    L7:
        if (r15.hasNext() == false) goto L11;
        Map.Entry r16 = (Map.Entry) r15.next();
        if ((!Intrinsics.areEqual((String) r16.getValue(), (String) ((LinkedHashMap) r14).get(r16.getKey()))) == false) goto L7;
        return false;
    L11:
        return true;
    }
}
