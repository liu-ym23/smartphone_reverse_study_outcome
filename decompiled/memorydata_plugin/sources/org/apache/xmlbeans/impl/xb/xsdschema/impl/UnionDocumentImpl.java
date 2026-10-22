package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.values.XmlListImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
import org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument;

/* JADX INFO: loaded from: classes7.dex */
public class UnionDocumentImpl extends XmlComplexContentImpl implements UnionDocument {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    public static class UnionImpl extends AnnotatedImpl implements UnionDocument.Union {
        private static final QName[] PROPERTY_QNAME = null;
        private static final long serialVersionUID = 1;

        public static class MemberTypesImpl extends XmlListImpl implements UnionDocument.Union.MemberTypes {
            private static final long serialVersionUID = 1;

            public MemberTypesImpl(SchemaType r3) {
                super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), false);
            }

            public MemberTypesImpl(SchemaType r3, boolean r4) {
                super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
            }
        }

        static {
            PROPERTY_QNAME = new QName[]{new QName("http://www.w3.org/2001/XMLSchema", "simpleType"), new QName("", "memberTypes")};
        }

        public UnionImpl(SchemaType r3) {
            super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
        }

        public LocalSimpleType addNewSimpleType() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            LocalSimpleType r3 = (LocalSimpleType) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), LocalSimpleType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public List getMemberTypes() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[1]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            List<?> r4 = null;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r4;
        L7:
            r4 = r3.getListValue();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        public LocalSimpleType getSimpleTypeArray(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            LocalSimpleType r3 = (LocalSimpleType) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], r4), LocalSimpleType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 == null) goto L9;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        L9:
            throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        public LocalSimpleType[] getSimpleTypeArray() {
            return (LocalSimpleType[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[0], new LocalSimpleType[0]), LocalSimpleType[].class, "com.obric.memorydata.plugin");
        }

        public List<LocalSimpleType> getSimpleTypeList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$oISc_qe4XIKJAYrFmr6RdkfZBdo(this), new $$Lambda$Wx0uFKu5N85ujXHwL05TJdROUQE(this), new $$Lambda$uXtTQn9qBHQJuOg7whs16Fa6ik(this), new $$Lambda$ZSEk_k7DVCupGXCCjRHEHLI0Qis(this), new $$Lambda$GVV71wIGTS0H1mGfbPUGZlKzNZw(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        public LocalSimpleType insertNewSimpleType(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            LocalSimpleType r3 = (LocalSimpleType) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[0], r4), LocalSimpleType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean isSetMemberTypes() {
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

        public void removeSimpleType(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            get_store().remove_element(PROPERTY_QNAME[0], r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void setMemberTypes(List r7) {
            List<?> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[1]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[1]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.setListValue(r8);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void setSimpleTypeArray(int r3, LocalSimpleType r4) {
            generatedSetterHelperImpl((LocalSimpleType) ZeusTransformUtils.wrapperContextForParams(r4, LocalSimpleType.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], r3, 2);
        }

        public void setSimpleTypeArray(LocalSimpleType[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[0]);
        }

        public int sizeOfSimpleTypeArray() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            int r3 = get_store().count_elements(PROPERTY_QNAME[0]);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public void unsetMemberTypes() {
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

        public UnionDocument.Union.MemberTypes xgetMemberTypes() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            UnionDocument.Union.MemberTypes r3 = (UnionDocument.Union.MemberTypes) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[1]), UnionDocument.Union.MemberTypes.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public void xsetMemberTypes(UnionDocument.Union.MemberTypes r7) {
            UnionDocument.Union.MemberTypes r8 = (UnionDocument.Union.MemberTypes) ZeusTransformUtils.wrapperContextForParams(r7, UnionDocument.Union.MemberTypes.class, "com.obric.memorydata.plugin");
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            UnionDocument.Union.MemberTypes r3 = (UnionDocument.Union.MemberTypes) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[1]), UnionDocument.Union.MemberTypes.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (UnionDocument.Union.MemberTypes) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[1]), UnionDocument.Union.MemberTypes.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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
        PROPERTY_QNAME = new QName[]{new QName("http://www.w3.org/2001/XMLSchema", "union")};
    }

    public UnionDocumentImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    public UnionDocument.Union addNewUnion() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        UnionDocument.Union r3 = (UnionDocument.Union) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), UnionDocument.Union.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public UnionDocument.Union getUnion() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        UnionDocument.Union r3 = (UnionDocument.Union) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], 0), UnionDocument.Union.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public void setUnion(UnionDocument.Union r4) {
        generatedSetterHelperImpl((UnionDocument.Union) ZeusTransformUtils.wrapperContextForParams(r4, UnionDocument.Union.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], 0, 1);
    }
}
