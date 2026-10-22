package com.bytedance.android.anniex.ability;

import com.bytedance.sdk.xbridge.cn.network.XRequestMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d extends s26.a implements ga.c {
    public d() {
    }

    @Override // ga.c
    public final Map<String, IDLXBridgeMethod> providerMethod(String r10) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        LinkedHashMap r11 = new LinkedHashMap();
        r11.put("x.getAppInfo", new vd7.d());
        r11.put("x.getAPIParams", new de7.c());
        r11.put("x.getUserInfo", new jd7.e());
        r11.put("x.getSettings", new vd7.e());
        r11.put("x.setStorageItem", new ve7.h());
        r11.put("x.getStorageItem", new ve7.f());
        r11.put("x.getStorageInfo", new ve7.e());
        r11.put("x.removeStorageItem", new ve7.g());
        r11.put("x.reportAppLog", new wd7.h());
        r11.put("x.reportMonitorLog", new wd7.i());
        r11.put("x.reportALog", new wd7.g());
        r11.put("x.request", new XRequestMethod());
        int r0 = com.bytedance.ies.bullet.base.bridge.i.a;
        r11.put("x.subscribeEvent", com.bytedance.ies.bullet.base.bridge.i.c(new a66.c()));
        r11.put("x.unsubscribeEvent", com.bytedance.ies.bullet.base.bridge.i.c(new a66.d()));
        r11.put("x.publishEvent", com.bytedance.ies.bullet.base.bridge.i.c(new a66.a()));
        return r11;
    }
}
