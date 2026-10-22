package com.bytedance.reparo.core;

import dalvik.system.BaseDexClassLoader;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class j extends BaseDexClassLoader {
    public final Class<?> a(String r1) throws ClassNotFoundException {
        return super.findClass(r1);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final Class<?> findClass(String r1) throws ClassNotFoundException {
        return super.findClass(r1);
    }

    public j(String r2, String r3, ClassLoader r4) {
        super(r2, null, r3, r4);
    }
}
