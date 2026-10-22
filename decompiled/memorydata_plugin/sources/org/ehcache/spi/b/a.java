package org.ehcache.spi.b;

import org.ehcache.config.ResourceType;
import org.ehcache.spi.service.MaintainableService;
import org.ehcache.spi.service.d;

/* JADX INFO: loaded from: classes7.dex */
@org.ehcache.spi.service.b
public interface a extends MaintainableService {

    /* JADX INFO: renamed from: org.ehcache.spi.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0896a<T extends a> extends d<T, Void> {
    }

    InterfaceC0896a<?> a(String r1, org.ehcache.config.b<?, ?> r2);

    void a(String r1);

    void a(InterfaceC0896a<?> r1);

    boolean a(ResourceType<?> r1);
}
