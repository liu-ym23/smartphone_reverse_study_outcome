package com.google.gson.internal;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class UnsafeAllocator$3 extends UnsafeAllocator {
    final /* synthetic */ Method val$newInstance;

    public UnsafeAllocator$3(Method r1) {
        this.val$newInstance = r1;
    }

    public <T> T newInstance(Class<T> r4) throws Exception {
        UnsafeAllocator.access$000(r4);
        return (T) this.val$newInstance.invoke(null, new Object[]{r4, Object.class});
    }
}
