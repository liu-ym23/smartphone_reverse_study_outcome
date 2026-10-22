package com.bytedance.ies.abmock.datacenter;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final e f2677a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile DataStorageProvider f2678b;
    private boolean c;
    private boolean d;

    static {
        f2677a = new e();
    }

    private e() {
        this.f2678b = new h();
        this.d = true;
    }

    public static e a() {
        return f2677a;
    }

    public void a(DataStorageProvider.a r3) {
        DataStorageProvider.a r4 = (DataStorageProvider.a) ZeusTransformUtils.wrapperContextForParams(r3, DataStorageProvider.a.class, "com.obric.memorydata.plugin");
        DataStorageProvider r2 = this.f2678b;
        if (r2 == null) goto L6;
        r2.a(r4);
        return;
    }

    public boolean b() {
        return this.c;
    }

    public DataStorageProvider c() {
        return this.f2678b;
    }
}
