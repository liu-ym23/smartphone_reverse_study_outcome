package org.bouncycastle.jcajce.provider.symmetric.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.AccessController;

/* JADX INFO: loaded from: classes7.dex */
public class ClassUtil {
    public static Class loadClass(Class r1, final String r2) {
        ClassLoader r3 = r1.getClassLoader();     // Catch: ClassNotFoundException -> L8
        if (r3 == null) goto L7;
        return r3.loadClass(r2);
    L7:
        return (Class) ZeusTransformUtils.preCheckCast(AccessController.doPrivileged(new AnonymousClass1(r2)), Class.class, "com.obric.memorydata.plugin");
    L8:
        return null;
    }
}
