package org.apache.xmlbeans.impl.schema;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import javax.xml.stream.e;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlOptions;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes7.dex */
public class AbstractDocumentFactory<T> extends ElementFactory<T> {
    public AbstractDocumentFactory(SchemaTypeSystem r3, String r4) {
        super((SchemaTypeSystem) ZeusTransformUtils.wrapperContextForParams(r3, SchemaTypeSystem.class, "com.obric.memorydata.plugin"), r4);
    }

    public T parse(InputStream r3) {
        return (T) getTypeLoader().parse(r3, getType(), null);
    }

    public T parse(InputStream r2, XmlOptions r3) {
        return (T) getTypeLoader().parse(r2, getType(), r3);
    }

    public T parse(String r3) {
        return (T) getTypeLoader().parse(r3, getType(), null);
    }

    public T parse(String r2, XmlOptions r3) {
        return (T) getTypeLoader().parse(r2, getType(), r3);
    }

    public T parse(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        return (T) getTypeLoader().parse(r4, getType(), null);
    }

    public T parse(e r3, XmlOptions r4) {
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        return (T) getTypeLoader().parse(r5, getType(), r4);
    }

    public T parse(Node r3, XmlOptions r4) {
        Node r5 = (Node) ZeusTransformUtils.wrapperContextForParams(r3, Node.class, "com.obric.memorydata.plugin");
        return (T) getTypeLoader().parse(r5, getType(), r4);
    }
}
