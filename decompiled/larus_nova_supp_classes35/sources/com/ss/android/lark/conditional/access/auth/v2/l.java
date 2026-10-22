package com.ss.android.lark.conditional.access.auth.v2;

import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.tencent.wcdb.core.Database;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l {
    public final Object a;
    public final HashMap<String, Long> b;

    public l() {
        this.a = new Object();
        this.b = new HashMap();
    }

    public final void a(PolicyModel r10) {
        Intrinsics.checkNotNullParameter(r10, "model");
        if (idb.f.a().isEnable("lark.security.android_disable_policy_req_opt") == false) goto L5;
        return;
    L5:
        Object r0 = this.a;
        monitor-enter(r0);
    L20:
        th = move-exception;
        throw th;
    L8:
        if (this.b.size() <= 20) goto L17;
        Iterator<Map.Entry<String, Long>> r1 = this.b.entrySet().iterator();     // Catch: Throwable -> L20
        String r2 = null;
        long r3 = Database.DictDefaultMatchValue;
    L11:
        if (r1.hasNext() == false) goto L15;
        Map.Entry<String, Long> r5 = r1.next();     // Catch: Throwable -> L20
        String r6 = r5.getKey();     // Catch: Throwable -> L20
        long r7 = r5.getValue().longValue();     // Catch: Throwable -> L20
        if (r7 >= r3) goto L11;
        r2 = r6;
        r3 = r7;
        goto L11
    L15:
        if (r2 == null) goto L17;
        this.b.remove(r2);     // Catch: Throwable -> L20
    L17:
        this.b.put(r10.getTaskId(), Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L20
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r0);
    }
}
