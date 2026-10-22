package com.ss.android.lark.conditional.access.auth.v2;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.reflect.TypeToken;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class o implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ Function1<Map<String, d>, Unit> b;

    /* JADX WARN: Multi-variable type inference failed */
    public o(String r1, Function1<? super Map<String, d>, Unit> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        com.ss.android.lark.storage.kv.repo.a r0 = y.c;
        if (r0 == null) goto L12;
        String r1 = this.a;
        Function1<Map<String, d>, Unit> r2 = this.b;
        String r3 = r0.getString("object_" + r1, null);
        Map r4 = MapsKt.emptyMap();
        Map r5 = (Map) GsonProtectorUtils.fromJson(com.ss.android.lark.security.compliance.infra.util.f.b(), r3, TypeToken.getParameterized(LinkedHashMap.class, new Type[]{String.class, d.class}).getType());     // Catch: Exception -> L9
        if (r5 != null) goto L8;
        r5 = MapsKt.emptyMap();     // Catch: Exception -> L9
    L8:
        r4 = r5;
    L11:
        r2.invoke(r4);
        return;
    L9:
        e = move-exception;
        int r6 = ScsLogger.a;
        ScsLogger.c("SecurityPolicy_PolicyStorage", "getDynamicObjectResult(), trans resultStr to result error, e:" + e.getMessage());
        goto L11
    L12:
        this.b.invoke(MapsKt.emptyMap());
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
