package com.bytedance.apm.agent.a;

import com.bytedance.apm.internal.ApmDelegate;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static void a(Object r4, boolean r5) {
        if (com.bytedance.apm.agent.v2.a.f1097a == true) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L8;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
    L9:
        JSONObject r2 = new JSONObject();
        if (ZeusTransformUtils.instanceOf(r4, a.class) == false) goto L13;
        r2.put(AnnotatedPrivateKey.LABEL, ((a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.memorydata.plugin")).a());     // Catch: Exception -> L22
    L13:
        if (r5 == false) goto L15;
        String r6 = "page_show";
    L16:
        if (r5 == true) goto L18;
    L20:
        com.bytedance.apm.agent.c.a.a(r6, r0, r2);
        return;
    L18:
        if (ApmDelegate.a().b().b() == null) goto L20;
        ApmDelegate.a().b().b().a(r0, true);
        goto L20
    L15:
        r6 = "page_hide";
        goto L16
    L8:
        r0 = r4.getClass().getName();
        goto L9
    }
}
