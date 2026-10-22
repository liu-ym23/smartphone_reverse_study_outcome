package com.google.gson.internal;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class UnsafeAllocator$4 extends UnsafeAllocator {
    public UnsafeAllocator$4() {
    }

    public <T> T newInstance(Class<T> r4) {
        throw new UnsupportedOperationException("Cannot allocate " + r4 + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
    }
}
