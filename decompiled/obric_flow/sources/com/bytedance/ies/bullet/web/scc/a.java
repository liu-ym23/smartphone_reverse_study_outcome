package com.bytedance.ies.bullet.web.scc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6252a = null;

    static {
        f6252a = new a();
    }

    public static void a(String r5, HashMap r10) {
        JSONObject r11 = new JSONObject();
        Iterator r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry r13 = (Map.Entry) r12.next();
        r11.put((String) r13.getKey(), (String) r13.getValue());
        goto L4
    L6:
        Function2 r14 = b.f6254c;
        if (r14 == null) goto L11;
        ((SccDelegate$1$1) r14).mo2invoke(r5, r11);
        return;
    }
}
