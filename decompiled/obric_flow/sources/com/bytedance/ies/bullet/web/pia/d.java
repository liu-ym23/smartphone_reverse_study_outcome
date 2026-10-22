package com.bytedance.ies.bullet.web.pia;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f6224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet f6225c;

    public d(String r20, Map r21) {
        Intrinsics.checkNotNullParameter("", "userAgent");
        Intrinsics.checkNotNullParameter(r21, "globalProps");
        Intrinsics.checkNotNullParameter(r20, "bid");
        this.f6223a = "";
        this.f6224b = r21;
        LinkedHashMap r5 = i.f6234a;
        HashSet r10 = new HashSet();
        tc.c r11 = tc.c.f22119c;
        if (tc.c.f22119c.a(p3.f.class, r20) != null) goto L14;
        List r12 = CollectionsKt.mutableListOf(new String[]{"x.getAppInfo", "x.getAPIParams", "x.getUserInfo", "x.getSettings", "x.setStorageItem", "x.getStorageItem", "x.getStorageInfo", "x.removeStorageItem", "x.reportAppLog", "x.reportMonitorLog", "x.reportALog", "x.request", "x.subscribeEvent", "x.unsubscribeEvent", "x.publishEvent"});
        if (Intrinsics.areEqual(r20, "webcast") == false) goto L7;
        r12.add("fetch");
    L7:
        Iterator r13 = r12.iterator();
    L9:
        if (r13.hasNext() == false) goto L11;
        String r14 = (String) r13.next();
        goto L9
    L11:
        this.f6225c = r10;
        return;
    L14:
        throw new ClassCastException();
    }
}
