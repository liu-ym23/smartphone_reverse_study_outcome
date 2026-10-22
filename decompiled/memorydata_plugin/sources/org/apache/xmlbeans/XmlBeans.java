package org.apache.xmlbeans;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;
import org.apache.xmlbeans.impl.schema.SchemaTypeLoaderImpl;

/* JADX INFO: loaded from: classes7.dex */
public final class XmlBeans {
    public static final SchemaType NO_TYPE = null;
    private static String XMLBEANS_TITLE = "org.apache.xmlbeans";
    private static String XMLBEANS_VENDOR = "Apache Software Foundation";
    private static String XMLBEANS_VERSION = "unknown";
    private static final ThreadLocal _threadLocalLoaderQNameCache = null;

    static {
        Package r0 = XmlBeans.class.getPackage();
        if (r0 != null) goto L5;
    L7:
        _threadLocalLoaderQNameCache = new AnonymousClass1();
        NO_TYPE = getNoType();
        return;
    L5:
        if (r0.getImplementationVersion() == null) goto L7;
        XMLBEANS_TITLE = r0.getImplementationTitle();
        XMLBEANS_VERSION = r0.getImplementationVersion();
        XMLBEANS_VENDOR = r0.getImplementationVendor();
        goto L7
    }

    private XmlBeans() {
    }

    public static SchemaTypeSystem getBuiltinTypeSystem() {
        return BuiltinSchemaTypeSystem.get();
    }

    public static SchemaTypeLoader getContextTypeLoader() {
        return SchemaTypeLoaderImpl.getContextTypeLoader();
    }

    private static SchemaType getNoType() {
        return BuiltinSchemaTypeSystem.getNoType();
    }

    public static QNameCache getQNameCache() {
        ThreadLocal r0 = _threadLocalLoaderQNameCache;
        QNameCache r1 = (QNameCache) ZeusTransformUtils.preCheckCast(((SoftReference) ZeusTransformUtils.preCheckCast(r0.get(), SoftReference.class, "com.obric.memorydata.plugin")).get(), QNameCache.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        QNameCache r2 = new QNameCache(32);
        r0.set(new SoftReference(r2));
        return r2;
    L6:
        return r1;
    }

    public static String getTitle() {
        return XMLBEANS_TITLE;
    }

    public static String getVersion() {
        return XMLBEANS_VERSION;
    }

    public static SchemaType typeForClass(Class r3) {
        if (r3 != null) goto L5;
    L12:
        return null;
    L5:
        if (XmlObject.class.isAssignableFrom(r3) == false) goto L12;
        Field r4 = r3.getField("type");     // Catch: Exception -> L13
        if (r4 != null) goto L10;
        return null;
    L10:
        return (SchemaType) ZeusTransformUtils.preCheckCast(r4.get(null), SchemaType.class, "com.obric.memorydata.plugin");
    }

    public static SchemaTypeLoader typeLoaderForClassLoader(ClassLoader r1) {
        return SchemaTypeLoaderImpl.build(null, null, r1);
    }
}
