package org.apache.logging.log4j.simple;

import java.net.URI;
import org.apache.logging.log4j.spi.f;
import org.apache.logging.log4j.spi.g;

/* JADX INFO: loaded from: classes6.dex */
public class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f17893a = null;

    static {
        f17893a = new b();
    }

    public b() {
    }

    @Override // org.apache.logging.log4j.spi.g
    public f getContext(String r1, ClassLoader r2, Object r3, boolean r4) {
        return a.f17892a;
    }

    @Override // org.apache.logging.log4j.spi.g
    public f getContext(String r1, ClassLoader r2, Object r3, boolean r4, URI r5, String r6) {
        return a.f17892a;
    }
}
