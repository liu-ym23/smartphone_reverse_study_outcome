package org.ehcache.spi.service;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.ehcache.spi.service.c;

/* JADX INFO: loaded from: classes7.dex */
public interface e<T extends c, R> {
    Class<T> a();

    default boolean a(e<?, ?> r3) {
        return !ZeusTransformUtils.instanceOf(getClass(), (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin"));
    }
}
