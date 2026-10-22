package org.ehcache.core.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;

/* JADX INFO: loaded from: classes7.dex */
public class b {
    public static <T> Iterable<T> a(Class<T> r2) {
        final BundleContext r0 = a.a();     // Catch: InvalidSyntaxException -> L4
        Stream r3 = r0.getServiceReferences(r2, null).stream();     // Catch: InvalidSyntaxException -> L4
        r0.getClass();     // Catch: InvalidSyntaxException -> L4
        return (Iterable) ZeusTransformUtils.preCheckCast(r3.map(new $$Lambda$M0z8CG5Tji6pm0w0xAWtXtc_MVo(r0)).collect(Collectors.toList()), Iterable.class, "com.obric.memorydata.plugin");
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }
}
