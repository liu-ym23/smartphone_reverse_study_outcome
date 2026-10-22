package org.ehcache.spi.service;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.ehcache.spi.service.c;

/* JADX INFO: loaded from: classes7.dex */
public interface d<T extends c, R> {
    default boolean a(d<?, ?> r3) {
        return !ZeusTransformUtils.instanceOf(getClass(), (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin"));
    }

    Class<T> b();
}
