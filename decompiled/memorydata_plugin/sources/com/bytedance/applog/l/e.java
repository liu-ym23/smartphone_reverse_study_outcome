package com.bytedance.applog.l;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<d> f1624a;

    public e() {
        this.f1624a = new CopyOnWriteArrayList();
    }

    public static e a(String r0) {
        com.bytedance.applog.b r1 = com.bytedance.applog.a.b(r0);
        if (r1 != null) goto L5;
        return null;
    L5:
        return r1.ai();
    }

    public List<d> a() {
        return this.f1624a;
    }

    public void a(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        this.f1624a.add(r4);
    }
}
