package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.AllNNI;
import org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument;

/* JADX INFO: loaded from: classes7.dex */
public class AnyDocumentImpl extends XmlComplexContentImpl implements AnyDocument {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    public static class AnyImpl extends WildcardImpl implements AnyDocument.Any {
        private static final QName[] PROPERTY_QNAME = null;
        private static final long serialVersionUID = 1;

        static {
            PROPERTY_QNAME = new QName[]{new QName("", "minOccurs"), new QName("", "maxOccurs")};
        }

        public AnyImpl(SchemaType r3) {
            super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
        }

        public Object getMaxOccurs() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L12
            TypeStore r1 = get_store();     // Catch: Throwable -> L12
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L12
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[1]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
            if (r3 != null) goto L7;
            r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_default_attribute_value(r2[1]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        L7:
            if (r3 != null) goto L9;
            Object r6 = null;
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r6;
        L9:
            r6 = r3.getObjectValue();     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        public BigInteger getMinOccurs() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L12
            TypeStore r1 = get_store();     // Catch: Throwable -> L12
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L12
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[0]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
            if (r3 != null) goto L7;
            r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_default_attribute_value(r2[0]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        L7:
            if (r3 != null) goto L9;
            BigInteger r6 = null;
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r6;
        L9:
            r6 = r3.getBigIntegerValue();     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        public boolean isSetMaxOccurs() {
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

        public boolean isSetMinOccurs() {
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

        public void setMaxOccurs(Object r7) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[1]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[1]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.setObjectValue(r7);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void setMinOccurs(BigInteger r7) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[0]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[0]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.setBigIntegerValue(r7);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void unsetMaxOccurs() {
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

        public void unsetMinOccurs() {
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

        public AllNNI xgetMaxOccurs() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L9
            TypeStore r1 = get_store();     // Catch: Throwable -> L9
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L9
            AllNNI r3 = (AllNNI) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[1]), AllNNI.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            if (r3 != null) goto L7;
            r3 = (AllNNI) ZeusTransformUtils.preCheckCast(get_default_attribute_value(r2[1]), AllNNI.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r3;
        L9:
            th = move-exception;
            throw th;
        }

        public XmlNonNegativeInteger xgetMinOccurs() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L9
            TypeStore r1 = get_store();     // Catch: Throwable -> L9
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L9
            XmlNonNegativeInteger r3 = (XmlNonNegativeInteger) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[0]), XmlNonNegativeInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            if (r3 != null) goto L7;
            r3 = (XmlNonNegativeInteger) ZeusTransformUtils.preCheckCast(get_default_attribute_value(r2[0]), XmlNonNegativeInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r3;
        L9:
            th = move-exception;
            throw th;
        }

        public void xsetMaxOccurs(AllNNI r7) {
            AllNNI r8 = (AllNNI) ZeusTransformUtils.wrapperContextForParams(r7, AllNNI.class, "com.obric.memorydata.plugin");
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            AllNNI r3 = (AllNNI) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[1]), AllNNI.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (AllNNI) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[1]), AllNNI.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.set(r8);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void xsetMinOccurs(XmlNonNegativeInteger r7) {
            XmlNonNegativeInteger r8 = (XmlNonNegativeInteger) ZeusTransformUtils.wrapperContextForParams(r7, XmlNonNegativeInteger.class, "com.obric.memorydata.plugin");
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            XmlNonNegativeInteger r3 = (XmlNonNegativeInteger) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[0]), XmlNonNegativeInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (XmlNonNegativeInteger) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[0]), XmlNonNegativeInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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
        PROPERTY_QNAME = new QName[]{new QName("http://www.w3.org/2001/XMLSchema", "any")};
    }

    public AnyDocumentImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    public AnyDocument.Any addNewAny() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        AnyDocument.Any r3 = (AnyDocument.Any) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), AnyDocument.Any.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public AnyDocument.Any getAny() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        AnyDocument.Any r3 = (AnyDocument.Any) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], 0), AnyDocument.Any.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public void setAny(AnyDocument.Any r4) {
        generatedSetterHelperImpl((AnyDocument.Any) ZeusTransformUtils.wrapperContextForParams(r4, AnyDocument.Any.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], 0, 1);
    }
}
