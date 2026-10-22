package com.bytedance.applog.l;

import com.bytedance.applog.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static String a(com.bytedance.applog.n.e r4, String r5) {
        e r0 = e.a(r4.b());
        if (r0 == null) goto L10;
        Iterator<d> r1 = r0.a().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        d r2 = (d) ZeusTransformUtils.preCheckCast(r1.next(), d.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, c.class) == false) goto L6;
        r5 = ((c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.memorydata.plugin")).a(r4, r5);
    L10:
        return r5;
    }

    public static JSONObject a(com.bytedance.applog.n.e r4, JSONObject r5) {
        e r0 = e.a(r4.b());
        if (r0 == null) goto L10;
        Iterator<d> r1 = r0.a().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        d r2 = (d) ZeusTransformUtils.preCheckCast(r1.next(), d.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, c.class) == false) goto L6;
        r5 = ((c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.memorydata.plugin")).a(r4, r5);
    L10:
        return r5;
    }

    public static void a(f r3) {
        f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L12;
        e r5 = r4.ai();
        if (r5 == null) goto L18;
        Iterator<d> r6 = r5.a().iterator();
    L8:
        if (r6.hasNext() == false) goto L19;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r6.next(), d.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L8;
        ((c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.memorydata.plugin")).a();
        goto L8
    L19:
        return;
    L18:
        return;
    }
}
