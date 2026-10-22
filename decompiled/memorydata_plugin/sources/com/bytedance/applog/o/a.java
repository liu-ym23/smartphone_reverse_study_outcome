package com.bytedance.applog.o;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.bytedance.applog.log.b<b> f1737a = null;

    static {
        f1737a = new AnonymousClass1();
    }

    public a() {
    }

    public static b a() {
        return (b) ZeusTransformUtils.preCheckCast(f1737a.c(new Object[0]), b.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.applog.o.b
    public long b() {
        return 1209600000;
    }

    @Override // com.bytedance.applog.o.b
    public int c() {
        return -1;
    }
}
