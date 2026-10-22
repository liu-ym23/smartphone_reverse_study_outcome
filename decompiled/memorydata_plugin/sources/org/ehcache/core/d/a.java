package org.ehcache.core.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.ehcache.core.spi.store.Store;

/* JADX INFO: loaded from: classes7.dex */
public class a<K> implements org.ehcache.spi.resilience.a<K> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Store<K, ?> f18015a;

    public a(Store<K, ?> r3) {
        this.f18015a = (Store) ZeusTransformUtils.wrapperContextForParams(r3, Store.class, "com.obric.memorydata.plugin");
    }
}
