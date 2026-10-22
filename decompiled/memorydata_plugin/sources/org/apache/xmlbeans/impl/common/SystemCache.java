package org.apache.xmlbeans.impl.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.SoftReference;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SystemProperties;

/* JADX INFO: loaded from: classes7.dex */
public class SystemCache {
    private static SystemCache INSTANCE;
    private ThreadLocal<SoftReference> tl_saxLoaders;

    static {
        INSTANCE = initCache();
    }

    public SystemCache() {
        this.tl_saxLoaders = new ThreadLocal();
    }

    public static synchronized SystemCache get() {
        monitor-enter(SystemCache.class);
        SystemCache r1 = INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(SystemCache.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private static SystemCache initCache() {
        String r1 = SystemProperties.getProperty("xmlbean.systemcacheimpl");
        if (r1 == null) goto L5;
        String r2 = "Could not instantiate class " + r1 + " as specified by \"xmlbean.systemcacheimpl\". ";
        return (SystemCache) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName(r1, "com.obric.memorydata.plugin").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), SystemCache.class, "com.obric.memorydata.plugin");
    L15:
        e = move-exception;
        throw new RuntimeException(r2 + "Class was not found.", e);
    L9:
        e = move-exception;
        throw new RuntimeException(r2 + "A public empty constructor may be missing.", e);
    L12:
        e = move-exception;
        throw new RuntimeException(r2 + "An empty constructor may be missing.", e);
    L19:
        throw new ClassCastException(r2 + "Class does not derive from SystemCache.");
    L5:
        return new SystemCache();
    }

    public static synchronized void set(SystemCache r1) {
        monitor-enter(SystemCache.class);
        INSTANCE = r1;     // Catch: Throwable -> L7
        monitor-exit(SystemCache.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addToTypeLoaderCache(SchemaTypeLoader r1, ClassLoader r2) {
        SchemaTypeLoader r0 = (SchemaTypeLoader) ZeusTransformUtils.wrapperContextForParams(r1, SchemaTypeLoader.class, "com.obric.memorydata.plugin");
    }

    public SchemaTypeLoader getFromTypeLoaderCache(ClassLoader r1) {
        return null;
    }

    public void setSaxLoader(Object r2) {
        this.tl_saxLoaders.set(new SoftReference(r2));
    }
}
