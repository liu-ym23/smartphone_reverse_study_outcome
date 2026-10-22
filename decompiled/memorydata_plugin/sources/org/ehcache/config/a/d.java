package org.ehcache.config.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;

/* JADX INFO: loaded from: classes7.dex */
public final class d extends org.ehcache.core.a.a<d> {
    public d() {
    }

    public d(d r3, Collection<org.ehcache.spi.service.e<?, ?>> r4) {
        super(r3, (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin"));
    }

    public static d b() {
        return new d();
    }

    public d a(Collection<org.ehcache.spi.service.e<?, ?>> r3) {
        return new d(this, (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.ehcache.core.a.a
    public /* synthetic */ org.ehcache.core.a.a b(Collection r3) {
        return a((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
    }
}
