package com.lynx.canvas;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class KryptonServiceLazyLoader extends KryptonService {
    public abstract <T extends KryptonService> T createServiceInstance(Class<T> r1);

    public KryptonServiceLazyLoader() {
    }
}
