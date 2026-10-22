package com.bytedance.frameworks.plugin.proxy;

import java.lang.reflect.InvocationHandler;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends android.support.v4.media.a implements InvocationHandler {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<String, android.support.v4.media.a> f3943c = null;

    static {
        f3943c = new HashMap();
        HashMap r8 = new HashMap();
        r8.put(Boolean.class, Boolean.TYPE);
        r8.put(Byte.class, Byte.TYPE);
        r8.put(Character.class, Character.TYPE);
        r8.put(Short.class, Short.TYPE);
        r8.put(Integer.class, Integer.TYPE);
        r8.put(Long.class, Long.TYPE);
        r8.put(Double.class, Double.TYPE);
        r8.put(Float.class, Float.TYPE);
    }
}
