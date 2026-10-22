package com.bytedance.ttnet.cronet;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class b extends Observable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f3278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f3279b;
    private CopyOnWriteArrayList<Integer> c;

    public b() {
        this.c = new CopyOnWriteArrayList();
    }

    public static b a() {
        if (f3278a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f3278a != null) goto L9;
        f3278a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f3278a;
    }

    private void a(Map<String, Object> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        setChanged();
        notifyObservers(r4);
    }

    public void a(boolean r3, List<Integer> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.f3279b = r3;
        this.c.clear();
        this.c.addAll(r5);
        HashMap r6 = new HashMap();
        r6.put("user_blocked_state", Boolean.valueOf(this.f3279b));
        r6.put("drop_reason_list", this.c);
        a(r6);
    }
}
