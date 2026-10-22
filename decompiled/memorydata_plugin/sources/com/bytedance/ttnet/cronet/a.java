package com.bytedance.ttnet.cronet;

import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/* JADX INFO: loaded from: classes2.dex */
public class a extends Observable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f3276a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile String f3277b = "";
    private static volatile String c = "";
    private static volatile String d = "";
    private static volatile String e = "";
    private static volatile String f = "";

    static {
    }

    public a() {
    }

    public static a a() {
        if (f3276a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f3276a != null) goto L9;
        f3276a = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f3276a;
    }

    private void a(Map<String, Object> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        setChanged();
        notifyObservers(r4);
    }

    public void a(String r3, String r4, String r5, String r6, String r7, String r8) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDataStorageAccess", "onStoreIdcChanged idc: " + r3 + " region: " + r4 + " source: " + r5 + " sec_uid:" + r7 + " logid:" + r8);
    L5:
        f3277b = r3;
        c = r4;
        d = r5;
        e = r6;
        f = r7;
        HashMap r0 = new HashMap();
        r0.put("store_idc", r3);
        r0.put("store_region", r4);
        r0.put("region_source", r5);
        r0.put("region_legacy_user", r6);
        r0.put("sec_uid", r7);
        r0.put("logid", r8);
        a(r0);
    }
}
