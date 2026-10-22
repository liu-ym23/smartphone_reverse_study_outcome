package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import org.chromium.wschannel.TrafficChangedObservable;

/* JADX INFO: loaded from: classes2.dex */
public class i extends Observable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile i f2424a;

    public i() {
    }

    public static i a() {
        if (f2424a != null) goto L15;
        monitor-enter(i.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2424a != null) goto L9;
        f2424a = new i();     // Catch: Throwable -> L11
    L9:
        monitor-exit(i.class);     // Catch: Throwable -> L11
    L15:
        return f2424a;
    }

    private void a(Map<String, Object> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        setChanged();
        notifyObservers(r4);
    }

    public void a(String r3, long r4, long r6, String r8, String r9) {
        HashMap r0 = new HashMap();
        r0.put("url", r3);
        r0.put(TrafficChangedObservable.TRAFFICCHANGED_SENTBYTES, Long.valueOf(r4));
        r0.put(TrafficChangedObservable.TRAFFICCHANGED_RECEIVEDBYTES, Long.valueOf(r6));
        r0.put("content_type", r8);
        r0.put("request_log", r9);
        a(r0);
    }
}
