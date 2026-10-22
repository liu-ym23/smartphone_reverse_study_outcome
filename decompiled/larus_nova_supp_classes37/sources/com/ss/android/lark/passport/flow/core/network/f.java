package com.ss.android.lark.passport.flow.core.network;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f {
    public final int a;
    public final String b;
    public final Map<String, List<String>> c;
    public final byte[] d;

    public static final class a {
    }

    static {
    }

    public final void c() {
        int r0 = this.a;
        if (200 <= r0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L58;
        return;
    L58:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        Object r3 = Result.constructor-impl(a(this));     // Catch: Throwable -> L11
    L13:
        String r4 = null;
        if (Result.isFailure-impl(r3) == false) goto L16;
        r3 = null;
    L16:
        String r8 = (String) r3;
        if (r8 != null) goto L19;
    L31:
        JSONObject r5 = null;
    L32:
        int r6 = this.a;
        String r7 = this.b;
        String r9 = b("x-tt-logid");
        if (r5 == null) goto L35;
        Integer r10 = r5.getInteger("code");
    L36:
        if (r5 == null) goto L38;
        Integer r11 = r5.getInteger(UniContext.KEY_OF_BIZ_CODE);
    L39:
        if (r5 == null) goto L41;
        String r12 = r5.getString("message");
    L43:
        if (r5 == null) goto L50;
        JSONObject r13 = r5.getJSONObject("data");
        if (r13 == null) goto L50;
        String r14 = r13.getString("next_step");
        if (r14 == null) goto L50;
        String r15 = r14;
    L54:
        throw new PassportHttpStatusException(r6, r7, r9, r8, r10, r11, r12, r15);
    L50:
        if (r5 == null) goto L52;
        r4 = r5.getString("next_step");
    L52:
        r15 = r4;
        goto L54
    L41:
        r12 = null;
        goto L43
    L38:
        r11 = null;
        goto L39
    L35:
        r10 = null;
        goto L36
    L19:
        if ((!StringsKt.isBlank(r8)) == false) goto L21;
        String r16 = r8;
    L22:
        if (r16 == null) goto L31;
        Object r17 = Result.constructor-impl(JSON.parseObject(r16));     // Catch: Throwable -> L25
    L28:
        if (Result.isFailure-impl(r17) == false) goto L30;
        r17 = null;
    L30:
        r5 = (JSONObject) r17;
    L25:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L21:
        r16 = null;
    L11:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L5:
        if (r0 >= 300) goto L7;
        r1 = true;
        goto L8
    }

    public static String a(f r2) {
        Charset r0 = Charsets.UTF_8;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r0, "charset");
        return new String(r2.d, r0);
    }

    public final String b(String r6) {
        Intrinsics.checkNotNullParameter(r6, AppbrandHostConstants.Schema_Meta.NAME);
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (StringsKt.equals((String) ((Map.Entry) r1).getKey(), r6, true) == false) goto L4;
    L9:
        Map.Entry r2 = (Map.Entry) r1;
        if (r2 == null) goto L18;
        List r7 = (List) r2.getValue();
        if (r7 != null) goto L14;
        return null;
    L14:
        return (String) CollectionsKt.firstOrNull(r7);
    L18:
        return null;
    L8:
        r1 = null;
        goto L9
    }

    public f(int r2, Map<String, ? extends List<String>> r3, byte[] r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "headers");
        Intrinsics.checkNotNullParameter(r4, "body");
        Intrinsics.checkNotNullParameter(r5, "requestId");
        this.a = r2;
        this.b = r5;
        LinkedHashMap r6 = new LinkedHashMap(MapsKt.mapCapacity(r3.size()));
        Iterator r7 = ((LinkedHashMap) r3).entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Map.Entry r8 = (Map.Entry) r7.next();
        r6.put(r8.getKey(), CollectionsKt.toList((Iterable) r8.getValue()));
        goto L4
    L6:
        this.c = r6;
        this.d = Arrays.copyOf(r4, r4.length);
    }
}
