package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleExtensionType;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleRestrictionType;

/* JADX INFO: loaded from: classes7.dex */
public class SimpleContentDocumentImpl extends XmlComplexContentImpl implements SimpleContentDocument {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    public static class SimpleContentImpl extends AnnotatedImpl implements SimpleContentDocument.SimpleContent {
        private static final QName[] PROPERTY_QNAME = null;
        private static final long serialVersionUID = 1;

        static {
            PROPERTY_QNAME = new QName[]{new QName("http://www.w3.org/2001/XMLSchema", "restriction"), new QName("http://www.w3.org/2001/XMLSchema", "extension")};
        }

        public SimpleContentImpl(SchemaType r3) {
            super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
        }

        public SimpleExtensionType addNewExtension() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            SimpleExtensionType r3 = (SimpleExtensionType) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[1]), SimpleExtensionType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public SimpleRestrictionType addNewRestriction() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            SimpleRestrictionType r3 = (SimpleRestrictionType) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), SimpleRestrictionType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public SimpleExtensionType getExtension() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L9
            SimpleExtensionType r3 = (SimpleExtensionType) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[1], 0), SimpleExtensionType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            if (r3 != null) goto L7;
            r3 = null;
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r3;
        L9:
            th = move-exception;
            throw th;
        }

        public SimpleRestrictionType getRestriction() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L9
            SimpleRestrictionType r3 = (SimpleRestrictionType) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], 0), SimpleRestrictionType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            if (r3 != null) goto L7;
            r3 = null;
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r3;
        L9:
            th = move-exception;
            throw th;
        }

        public boolean isSetExtension() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            boolean r2 = true;
            if (get_store().count_elements(PROPERTY_QNAME[1]) != 0) goto L8;
            r2 = false;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r2;
        L10:
            th = move-exception;
            throw th;
        }

        public boolean isSetRestriction() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L9
            boolean r2 = false;
            if (get_store().count_elements(PROPERTY_QNAME[0]) == 0) goto L7;
            r2 = true;
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r2;
        L9:
            th = move-exception;
            throw th;
        }

        public void setExtension(SimpleExtensionType r4) {
            generatedSetterHelperImpl((SimpleExtensionType) ZeusTransformUtils.wrapperContextForParams(r4, SimpleExtensionType.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[1], 0, 1);
        }

        public void setRestriction(SimpleRestrictionType r4) {
            generatedSetterHelperImpl((SimpleRestrictionType) ZeusTransformUtils.wrapperContextForParams(r4, SimpleRestrictionType.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], 0, 1);
        }

        public void unsetExtension() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            get_store().remove_element(PROPERTY_QNAME[1], 0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void unsetRestriction() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            get_store().remove_element(PROPERTY_QNAME[0], 0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static {
        PROPERTY_QNAME = new QName[]{new QName("http://www.w3.org/2001/XMLSchema", "simpleContent")};
    }

    public SimpleContentDocumentImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    public SimpleContentDocument.SimpleContent addNewSimpleContent() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        SimpleContentDocument.SimpleContent r3 = (SimpleContentDocument.SimpleContent) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), SimpleContentDocument.SimpleContent.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public SimpleContentDocument.SimpleContent getSimpleContent() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        SimpleContentDocument.SimpleContent r3 = (SimpleContentDocument.SimpleContent) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], 0), SimpleContentDocument.SimpleContent.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public void setSimpleContent(SimpleContentDocument.SimpleContent r4) {
        generatedSetterHelperImpl((SimpleContentDocument.SimpleContent) ZeusTransformUtils.wrapperContextForParams(r4, SimpleContentDocument.SimpleContent.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], 0, 1);
    }
}
