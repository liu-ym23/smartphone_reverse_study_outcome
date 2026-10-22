package org.apache.xmlbeans;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import javax.xml.stream.e;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes7.dex */
public interface XmlFactoryHook {

    public static final class ThreadContext {
        private static final ThreadLocal<SoftReference<XmlFactoryHook>> threadHook = null;

        static {
            threadHook = new ThreadLocal();
        }

        public static XmlFactoryHook getHook() {
            SoftReference r0 = (SoftReference) ZeusTransformUtils.preCheckCast(threadHook.get(), SoftReference.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L6;
            return null;
        L6:
            return (XmlFactoryHook) ZeusTransformUtils.preCheckCast(r0.get(), XmlFactoryHook.class, "com.obric.memorydata.plugin");
        }
    }

    XmlObject newInstance(SchemaTypeLoader r1, SchemaType r2, XmlOptions r3);

    XmlObject parse(SchemaTypeLoader r1, InputStream r2, SchemaType r3, XmlOptions r4);

    XmlObject parse(SchemaTypeLoader r1, String r2, SchemaType r3, XmlOptions r4);

    XmlObject parse(SchemaTypeLoader r1, e r2, SchemaType r3, XmlOptions r4);

    XmlObject parse(SchemaTypeLoader r1, Node r2, SchemaType r3, XmlOptions r4);
}
