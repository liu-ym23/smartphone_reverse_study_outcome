package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument;

/* JADX INFO: loaded from: classes7.dex */
public class IncludeDocumentImpl extends XmlComplexContentImpl implements IncludeDocument {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    public static class IncludeImpl extends AnnotatedImpl implements IncludeDocument.Include {
        private static final QName[] PROPERTY_QNAME = null;
        private static final long serialVersionUID = 1;

        static {
            PROPERTY_QNAME = new QName[]{new QName("", "schemaLocation")};
        }

        public IncludeImpl(SchemaType r3) {
            super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
        }

        public String getSchemaLocation() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[0]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            String r4 = null;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r4;
        L7:
            r4 = r3.getStringValue();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        public void setSchemaLocation(String r7) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[0]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[0]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.setStringValue(r7);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public XmlAnyURI xgetSchemaLocation() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            XmlAnyURI r3 = (XmlAnyURI) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[0]), XmlAnyURI.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public void xsetSchemaLocation(XmlAnyURI r7) {
            XmlAnyURI r8 = (XmlAnyURI) ZeusTransformUtils.wrapperContextForParams(r7, XmlAnyURI.class, "com.obric.memorydata.plugin");
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            XmlAnyURI r3 = (XmlAnyURI) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[0]), XmlAnyURI.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (XmlAnyURI) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[0]), XmlAnyURI.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.set(r8);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    static {
        PROPERTY_QNAME = new QName[]{new QName("http://www.w3.org/2001/XMLSchema", "include")};
    }

    public IncludeDocumentImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    public IncludeDocument.Include addNewInclude() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        IncludeDocument.Include r3 = (IncludeDocument.Include) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), IncludeDocument.Include.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public IncludeDocument.Include getInclude() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        IncludeDocument.Include r3 = (IncludeDocument.Include) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], 0), IncludeDocument.Include.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public void setInclude(IncludeDocument.Include r4) {
        generatedSetterHelperImpl((IncludeDocument.Include) ZeusTransformUtils.wrapperContextForParams(r4, IncludeDocument.Include.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], 0, 1);
    }
}
