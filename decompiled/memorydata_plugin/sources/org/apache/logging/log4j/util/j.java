package org.apache.logging.log4j.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.invoke.MethodHandles;
import java.util.stream.Stream;
import org.apache.logging.log4j.status.StatusLogger;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

/* JADX INFO: loaded from: classes6.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f17928a = false;

    static {
        f17928a = b();
    }

    public static <T> Stream<T> a(Class<T> r2, MethodHandles.Lookup r3, boolean r4) {
        Bundle r5 = FrameworkUtil.getBundle(r3.lookupClass());
        if (r5 == null) goto L11;
        final BundleContext r6 = r5.getBundleContext();
        Stream r0 = r6.getServiceReferences(r2, null).stream();     // Catch: Throwable -> L7
        r6.getClass();     // Catch: Throwable -> L7
        return r0.map(new $$Lambda$M0z8CG5Tji6pm0w0xAWtXtc_MVo(r6));
    L7:
        th = move-exception;
        if (r4 == false) goto L11;
        StatusLogger.getLogger().error("Unable to load OSGI services for service {}", r2, th);
    L11:
        return Stream.empty();
    }

    public static boolean a() {
        return f17928a;
    }

    private static boolean b() {
        ZeusTransformUtils.forName("org.osgi.framework.Bundle", "com.obric.memorydata.plugin");     // Catch: Throwable -> L6 Throwable -> L9
        return true;
    L6:
        th = move-exception;
        h.a("Unknown error checking for existence of class: org.osgi.framework.Bundle", th);
    L8:
        return false;
    }
}
