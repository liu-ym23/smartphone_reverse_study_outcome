package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument;

/* JADX INFO: loaded from: classes7.dex */
public class ImportDocumentImpl extends XmlComplexContentImpl implements ImportDocument {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    public static class ImportImpl extends AnnotatedImpl implements ImportDocument.Import {
        private static final QName[] PROPERTY_QNAME = null;
        private static final long serialVersionUID = 1;

        static {
            PROPERTY_QNAME = new QName[]{new QName("", "namespace"), new QName("", "schemaLocation")};
        }

        public ImportImpl(SchemaType r3) {
            super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
        }

        public String getNamespace() {
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

        public String getSchemaLocation() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[1]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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

        public boolean isSetNamespace() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L9
            boolean r2 = false;
            if (get_store().find_attribute_user(PROPERTY_QNAME[0]) == null) goto L7;
            r2 = true;
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r2;
        L9:
            th = move-exception;
            throw th;
        }

        public boolean isSetSchemaLocation() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            boolean r2 = true;
            if (get_store().find_attribute_user(PROPERTY_QNAME[1]) != null) goto L8;
            r2 = false;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r2;
        L10:
            th = move-exception;
            throw th;
        }

        public void setNamespace(String r7) {
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

        public void setSchemaLocation(String r7) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[1]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[1]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.setStringValue(r7);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void unsetNamespace() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            get_store().remove_attribute(PROPERTY_QNAME[0]);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void unsetSchemaLocation() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            get_store().remove_attribute(PROPERTY_QNAME[1]);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public XmlAnyURI xgetNamespace() {
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

        public XmlAnyURI xgetSchemaLocation() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            XmlAnyURI r3 = (XmlAnyURI) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[1]), XmlAnyURI.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public void xsetNamespace(XmlAnyURI r7) {
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

        public void xsetSchemaLocation(XmlAnyURI r7) {
            XmlAnyURI r8 = (XmlAnyURI) ZeusTransformUtils.wrapperContextForParams(r7, XmlAnyURI.class, "com.obric.memorydata.plugin");
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            XmlAnyURI r3 = (XmlAnyURI) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[1]), XmlAnyURI.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (XmlAnyURI) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[1]), XmlAnyURI.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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
        PROPERTY_QNAME = new QName[]{new QName("http://www.w3.org/2001/XMLSchema", "import")};
    }

    public ImportDocumentImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    public ImportDocument.Import addNewImport() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ImportDocument.Import r3 = (ImportDocument.Import) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), ImportDocument.Import.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ImportDocument.Import getImport() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        ImportDocument.Import r3 = (ImportDocument.Import) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], 0), ImportDocument.Import.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public void setImport(ImportDocument.Import r4) {
        generatedSetterHelperImpl((ImportDocument.Import) ZeusTransformUtils.wrapperContextForParams(r4, ImportDocument.Import.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], 0, 1);
    }
}
