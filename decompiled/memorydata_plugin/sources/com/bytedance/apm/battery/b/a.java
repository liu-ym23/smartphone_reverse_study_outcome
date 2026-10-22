package com.bytedance.apm.battery.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, b> f1132a;

    public a() {
        this.f1132a = new HashMap();
    }

    public void a() {
        if (this.f1132a.size() != 0) goto L5;
        return;
    L5:
        Class r0 = ZeusTransformUtils.forName("android.app.SystemServiceRegistry", "com.obric.memorydata.plugin");
        Field r2 = r0.getDeclaredField("SYSTEM_SERVICE_FETCHERS");
        r2.setAccessible(true);
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(r2.get(null), Map.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<String, b>> r11 = this.f1132a.entrySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin");
        b r6 = (b) ZeusTransformUtils.preCheckCast(r4.getValue(), b.class, "com.obric.memorydata.plugin");
        Object r7 = r3.get(r5);
        r3.put(r5, Proxy.newProxyInstance(r0.getClassLoader(), new Class[]{ZeusTransformUtils.forName("android.app.SystemServiceRegistry$ServiceFetcher", "com.obric.memorydata.plugin")}, new c(r7, r6)));
        goto L7
    }

    public void a(String r3, b r4) {
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
        this.f1132a.put(r3, r5);
    }
}
