package com.ss.android.ugc.aweme.framework.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class GroupBinding<T> {
    Map<Class<?>, Map<String, ServiceProvider<?>>> classProviderMaps;
    String groupName;
    Class<T> klass;
    ServiceProvider<T> serviceProvider;

    public GroupBinding<T> asSingleton() {
        if ((this.serviceProvider instanceof SingletonProvider) == true) goto L5;
        Map r0 = this.classProviderMaps.get(this.klass);
        r0.remove(this.serviceProvider);
        SingletonProvider r1 = new SingletonProvider(this.serviceProvider);
        this.serviceProvider = r1;
        r0.put(this.groupName, r1);
    L5:
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GroupBinding(Map<Class<?>, Map<String, ServiceProvider<?>>> r2, Class<T> r3, String r4, ServiceProvider<T> r5) {
        this.classProviderMaps = r2;
        this.groupName = r4;
        this.klass = r3;
        this.serviceProvider = r5;
        Map<String, ServiceProvider<?>> r6 = r2.get(r3);
        if (r6 != null) goto L5;
        r6 = Collections.synchronizedMap(new HashMap());
        this.classProviderMaps.put(r3, r6);
    L5:
        r6.put(r4, r5);
    }
}
