package com.bytedance.applog.util;

import com.bytedance.bdinstall.util.Singleton;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Singleton<Boolean> f1887a = null;

    static {
        f1887a = new AnonymousClass1();
    }

    public static boolean a() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(f1887a.get(new Object[0]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }
}
