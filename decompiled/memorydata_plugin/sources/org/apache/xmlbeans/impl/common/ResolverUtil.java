package org.apache.xmlbeans.impl.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SystemProperties;
import org.xml.sax.EntityResolver;

/* JADX INFO: loaded from: classes7.dex */
public class ResolverUtil {
    private static EntityResolver _entityResolver;

    static {
        String r1 = SystemProperties.getProperty("xmlbean.entityResolver");     // Catch: Exception -> L7
        if (r1 == null) goto L11;
        _entityResolver = (EntityResolver) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName(r1, "com.obric.memorydata.plugin").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), EntityResolver.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L7
        return;
    L11:
        return;
    L7:
        _entityResolver = null;
    }

    public static EntityResolver getGlobalEntityResolver() {
        return _entityResolver;
    }
}
