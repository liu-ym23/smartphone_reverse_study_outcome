package org.ehcache.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
class c implements org.ehcache.core.spi.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final org.ehcache.core.spi.store.c f18011a;

    c(org.ehcache.core.spi.store.c r3) {
        this.f18011a = (org.ehcache.core.spi.store.c) ZeusTransformUtils.wrapperContextForParams(r3, org.ehcache.core.spi.store.c.class, "com.obric.memorydata.plugin");
    }

    @Override // org.ehcache.spi.service.c
    public void a() {
    }

    @Override // org.ehcache.spi.service.c
    public void a(org.ehcache.spi.service.g<org.ehcache.spi.service.c> r2) {
        org.ehcache.spi.service.g r1 = (org.ehcache.spi.service.g) ZeusTransformUtils.wrapperContextForParams(r2, org.ehcache.spi.service.g.class, "com.obric.memorydata.plugin");
    }
}
