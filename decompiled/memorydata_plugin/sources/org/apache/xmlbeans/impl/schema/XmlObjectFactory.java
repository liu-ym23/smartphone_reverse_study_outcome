package org.apache.xmlbeans.impl.schema;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import javax.xml.stream.e;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlOptions;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes7.dex */
public class XmlObjectFactory<T> extends DocumentFactory<T> {
    private final boolean isAnyType;

    public XmlObjectFactory(String r2) {
        this(XmlBeans.getBuiltinTypeSystem(), r2);
    }

    public XmlObjectFactory(SchemaTypeSystem r3, String r4) {
        super((SchemaTypeSystem) ZeusTransformUtils.wrapperContextForParams(r3, SchemaTypeSystem.class, "com.obric.memorydata.plugin"), r4);
        this.isAnyType = "_BI_anyType".equals(r4);
    }

    private SchemaType getInnerType() {
        if (this.isAnyType == false) goto L6;
        return null;
    L6:
        return getType();
    }

    @Override // org.apache.xmlbeans.impl.schema.DocumentFactory, org.apache.xmlbeans.impl.schema.ElementFactory
    public T newInstance() {
        return (T) XmlBeans.getContextTypeLoader().newInstance(getInnerType(), null);
    }

    @Override // org.apache.xmlbeans.impl.schema.DocumentFactory, org.apache.xmlbeans.impl.schema.ElementFactory
    public T newInstance(XmlOptions r2) {
        return (T) XmlBeans.getContextTypeLoader().newInstance(getInnerType(), r2);
    }

    @Override // org.apache.xmlbeans.impl.schema.AbstractDocumentFactory
    public T parse(InputStream r3) {
        return (T) XmlBeans.getContextTypeLoader().parse(r3, getInnerType(), null);
    }

    @Override // org.apache.xmlbeans.impl.schema.AbstractDocumentFactory
    public T parse(InputStream r2, XmlOptions r3) {
        return (T) XmlBeans.getContextTypeLoader().parse(r2, getInnerType(), r3);
    }

    @Override // org.apache.xmlbeans.impl.schema.AbstractDocumentFactory
    public T parse(String r3) {
        return (T) XmlBeans.getContextTypeLoader().parse(r3, getInnerType(), null);
    }

    @Override // org.apache.xmlbeans.impl.schema.AbstractDocumentFactory
    public T parse(String r2, XmlOptions r3) {
        return (T) XmlBeans.getContextTypeLoader().parse(r2, getInnerType(), r3);
    }

    @Override // org.apache.xmlbeans.impl.schema.AbstractDocumentFactory
    public T parse(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        return (T) XmlBeans.getContextTypeLoader().parse(r4, getInnerType(), null);
    }

    @Override // org.apache.xmlbeans.impl.schema.AbstractDocumentFactory
    public T parse(e r3, XmlOptions r4) {
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        return (T) XmlBeans.getContextTypeLoader().parse(r5, getInnerType(), r4);
    }

    @Override // org.apache.xmlbeans.impl.schema.AbstractDocumentFactory
    public T parse(Node r3, XmlOptions r4) {
        Node r5 = (Node) ZeusTransformUtils.wrapperContextForParams(r3, Node.class, "com.obric.memorydata.plugin");
        return (T) XmlBeans.getContextTypeLoader().parse(r5, getInnerType(), r4);
    }
}
