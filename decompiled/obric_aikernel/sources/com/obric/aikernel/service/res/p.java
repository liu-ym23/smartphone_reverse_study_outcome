package com.obric.aikernel.service.res;

import com.obric.aikernel.RequestTracker;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class p {
    public static final JSONObject a(com.obric.aikernel.res.update.h r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "result");
        Intrinsics.checkNotNullParameter(r11, "buildInfo");
        j r12 = b(r10, r11);
        JSONObject r13 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r14 = r12.a().entrySet().iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        Map.Entry<String, Object> r15 = r14.next();
        r13.put(r15.getKey(), r15.getValue());
        goto L4
    L6:
        JSONObject r16 = new JSONObject();
        Iterator<Map.Entry<String, Long>> r17 = r12.b().entrySet().iterator();
    L8:
        if (r17.hasNext() == false) goto L11;
        Map.Entry<String, Long> r18 = r17.next();
        r16.put(r18.getKey(), r18.getValue().longValue());
        goto L8
    L11:
        return RequestTracker.f4406c.b(r13, r16, null);
    }

    public static final j b(com.obric.aikernel.res.update.h r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "result");
        Intrinsics.checkNotNullParameter(r11, "buildInfo");
        Map r12 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("foreground", Integer.valueOf(r10.e())), TuplesKt.to("biz_name", r10.a()), TuplesKt.to("model_name", r10.g()), TuplesKt.to("model_version", r10.h()), TuplesKt.to("status", String.valueOf(r10.j())), TuplesKt.to("failure_reason", Integer.valueOf(r10.d())), TuplesKt.to("build_info", r11)});
        String r13 = r10.f();
        if (r13.length() <= 0) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == true) goto L9;
        r13 = null;
    L9:
        if (r13 == null) goto L12;
        r12.put("lora_type", r13);
    L12:
        return new j(r12, MapsKt.mapOf(new Pair[]{TuplesKt.to("duration", Long.valueOf(r10.c())), TuplesKt.to("download_duration", Long.valueOf(r10.b())), TuplesKt.to("pause_duration", Long.valueOf(r10.i()))}));
    L5:
        r14 = false;
        goto L6
    }

    public static final o c(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "updateCaller");
        Intrinsics.checkNotNullParameter(r11, "hostPackageName");
        String r12 = StringsKt.trim(r10).toString();
        boolean r13 = false;
        String r14 = null;
        if (StringsKt.startsWith$default(r12, ":", false, 2, null) == false) goto L5;
        String r15 = r12;
    L6:
        if (r15 == null) goto L8;
        r14 = StringsKt.removePrefix(r15, ":");
    L8:
        if (r14 != null) goto L11;
        r14 = "";
    L11:
        if (r14.length() != 0) goto L13;
        boolean r16 = true;
    L14:
        if (r16 == true) goto L23;
        String r17 = StringsKt.trim(r11).toString();
        if (r17.length() != 0) goto L19;
        r13 = true;
    L19:
        if (r13 == true) goto L23;
        r12 = r17;
    L23:
        return new o(r12, r14);
    L13:
        r16 = false;
        goto L14
    L5:
        r15 = null;
        goto L6
    }
}
