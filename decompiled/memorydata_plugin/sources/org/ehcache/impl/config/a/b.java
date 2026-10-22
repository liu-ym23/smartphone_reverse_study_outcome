package org.ehcache.impl.config.a;

import java.io.File;
import org.ehcache.spi.service.e;

/* JADX INFO: loaded from: classes7.dex */
public class b implements e<org.ehcache.core.spi.a.b, File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f18066a;

    public b(File r1) {
        this.f18066a = r1;
    }

    @Override // org.ehcache.spi.service.e
    public Class<org.ehcache.core.spi.a.b> a() {
        return org.ehcache.core.spi.a.b.class;
    }
}
