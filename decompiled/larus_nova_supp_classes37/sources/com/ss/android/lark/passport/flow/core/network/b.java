package com.ss.android.lark.passport.flow.core.network;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public static void a(JSONObject r1, Map r2, String r3) {
        String r4 = r1.getString(r3);
        if (r4 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L12;
        r2.put(r3, r4);
        return;
    L12:
        return;
    L5:
        if (StringsKt.isBlank(r4) == true) goto L8;
        r0 = false;
        goto L9
    }

    public static Object b(FlowPassportAccountsHttpClient r9, String r10, String r11, Map r12, Map r13, ContinuationImpl r14) {
        PassportHttpMethod r3 = PassportHttpMethod.POST;
        int r0 = e.i;
        String r15 = JSON.toJSONString(r13);
        Intrinsics.checkNotNullParameter(r15, "value");
        return FlowPassportAccountsHttpClient.c(r9, r10, r11, r3, null, r12, r15.getBytes(Charsets.UTF_8), r14, 456);
    }

    public static /* synthetic */ Object c(b r6, FlowPassportAccountsHttpClient r7, String r8, String r9, Map r10, ContinuationImpl r11) {
        Map r3 = MapsKt.emptyMap();
        r6.getClass();
        return b(r7, r8, r9, r3, r10, r11);
    }
}
