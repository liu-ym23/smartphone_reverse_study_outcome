package com.bytedance.bdlocation.utils.json;

import ha.a;
import ha.b;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class SuperclassExclusionStrategy implements a {
    public SuperclassExclusionStrategy() {
    }

    private Field getField(Class<?> r8, String r10) {
        return r8.getDeclaredField(r10);
    L4:
        return null;
    }

    private boolean isFieldInSuperclass(Class<?> r8, String r10) {
    L2:
        r8 = r8.getSuperclass();
        if (r8 == null) goto L8;
        if (getField(r8, r10) == null) goto L2;
        return true;
    L8:
        return false;
    }

    @Override // ha.a
    public boolean shouldSkipClass(Class<?> r8) {
        return false;
    }

    @Override // ha.a
    public boolean shouldSkipField(b r8) {
        String r10 = r8.f7962a.getName();
        return isFieldInSuperclass(r8.f7962a.getDeclaringClass(), r10);
    }
}
