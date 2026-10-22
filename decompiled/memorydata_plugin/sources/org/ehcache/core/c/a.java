package org.ehcache.core.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicReference;
import org.osgi.framework.BundleContext;
import org.slf4j.d;

/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final org.slf4j.c f18012a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicReference<BundleContext> f18013b = null;

    static {
        f18012a = d.a(a.class);
        f18013b = new AtomicReference();
    }

    public a() {
    }

    public static BundleContext a() {
        return (BundleContext) ZeusTransformUtils.preCheckCast(f18013b.get(), BundleContext.class, "com.obric.memorydata.plugin");
    }
}
