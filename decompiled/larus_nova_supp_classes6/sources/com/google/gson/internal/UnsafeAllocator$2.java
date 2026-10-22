package com.google.gson.internal;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class UnsafeAllocator$2 extends UnsafeAllocator {
    final /* synthetic */ int val$constructorId;
    final /* synthetic */ Method val$newInstance;

    public <T> T newInstance(Class<T> r4) throws Exception {
        UnsafeAllocator.access$000(r4);
        return (T) this.val$newInstance.invoke(null, new Object[]{r4, Integer.valueOf(this.val$constructorId)});
    }

    public UnsafeAllocator$2(Method r1, int r2) {
        this.val$newInstance = r1;
        this.val$constructorId = r2;
    }
}
