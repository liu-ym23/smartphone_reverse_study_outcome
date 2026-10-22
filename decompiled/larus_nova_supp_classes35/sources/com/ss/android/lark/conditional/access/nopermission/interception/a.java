package com.ss.android.lark.conditional.access.nopermission.interception;

import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.security.compliance.infra.storage.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public static com.ss.android.lark.storage.kv.repo.a b() {
        return d.b("policy_center_interception_restore", 2);
    }

    public static void a() {
        if (b().contains("action_json") == false) goto L5;
    L7:
        b().remove("action_json");
        b().remove("no_permission_type");
        ScsLogger.d("SecurityPolicy_InterceptionPersistStore", "clear interception");
        return;
    L5:
        if (b().contains("no_permission_type") == true) goto L7;
    }
}
