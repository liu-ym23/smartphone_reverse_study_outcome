package com.obric.aiagent.messenger;

import com.larus.applog.api.IApplog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f {
    public static final ConcurrentHashMap<String, String> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "messageId");
        String r5 = a.remove(r4);
        IApplog.Companion r0 = IApplog.a;
        JSONObject r1 = new JSONObject();
        if (r5 == null) goto L5;
        r1.put("res", "fail");
        r1.put("msg", r5);
    L6:
        Unit r6 = Unit.INSTANCE;
        r0.reportEvent("obric_pcc_encrypt_result", r1);
        return;
    L5:
        r1.put("res", "success");
        goto L6
    }

    public static void a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "messageId");
        Intrinsics.checkNotNullParameter(r2, "msg");
        a.put(r1, r2);
    }
}
