package com.bytedance.android.annie.xbridge.mix;

import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.protocol.XBridge3MethodFinder;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class s {
    public static final List<String> a = null;
    public static final List<MethodFinder> b = null;

    public s() {
    }

    static {
        a = AnnieConfigSettingKeys.LIVE_XBRIDGE_JSB_SUPPORT.a();
        ArrayList r0 = new ArrayList();
        r0.add(new XBridge3MethodFinder());
        r0.add(new com.bytedance.ies.bullet.base.bridge.p(new m16.b()));
        b = r0;
    }

    public static Map a() {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<T> r1 = a.iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        String r10 = (String) r1.next();
        Iterator r11 = ((ArrayList) b).iterator();
        IDLXBridgeMethod r12 = null;
    L7:
        if (r11.hasNext() == false) goto L10;
        r12 = ((MethodFinder) r11.next()).d("", r10);
        if (r12 == null) goto L7;
    L10:
        if (r12 == null) goto L4;
        r0.put(r10, new q(r12));
        goto L4
    L12:
        return r0;
    }
}
