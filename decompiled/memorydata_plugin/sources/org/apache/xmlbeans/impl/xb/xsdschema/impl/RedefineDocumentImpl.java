package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedAttributeGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelComplexType;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelSimpleType;

/* JADX INFO: loaded from: classes7.dex */
public class RedefineDocumentImpl extends XmlComplexContentImpl implements RedefineDocument {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    public static class RedefineImpl extends OpenAttrsImpl implements RedefineDocument.Redefine {
        private static final QName[] PROPERTY_QNAME = null;
        private static final long serialVersionUID = 1;

        static {
            PROPERTY_QNAME = new QName[]{new QName("http://www.w3.org/2001/XMLSchema", "annotation"), new QName("http://www.w3.org/2001/XMLSchema", "simpleType"), new QName("http://www.w3.org/2001/XMLSchema", "complexType"), new QName("http://www.w3.org/2001/XMLSchema", "group"), new QName("http://www.w3.org/2001/XMLSchema", "attributeGroup"), new QName("", "schemaLocation"), new QName("", OaidModel.KEY_ID)};
        }

        public RedefineImpl(SchemaType r3) {
            super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
        }

        public AnnotationDocument.Annotation addNewAnnotation() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            AnnotationDocument.Annotation r3 = (AnnotationDocument.Annotation) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), AnnotationDocument.Annotation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public NamedAttributeGroup addNewAttributeGroup() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            NamedAttributeGroup r3 = (NamedAttributeGroup) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[4]), NamedAttributeGroup.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public TopLevelComplexType addNewComplexType() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            TopLevelComplexType r3 = (TopLevelComplexType) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[2]), TopLevelComplexType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public NamedGroup addNewGroup() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            NamedGroup r3 = (NamedGroup) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[3]), NamedGroup.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public TopLevelSimpleType addNewSimpleType() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            TopLevelSimpleType r3 = (TopLevelSimpleType) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[1]), TopLevelSimpleType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public AnnotationDocument.Annotation getAnnotationArray(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            AnnotationDocument.Annotation r3 = (AnnotationDocument.Annotation) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], r4), AnnotationDocument.Annotation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 == null) goto L9;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        L9:
            throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        public AnnotationDocument.Annotation[] getAnnotationArray() {
            return (AnnotationDocument.Annotation[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[0], new AnnotationDocument.Annotation[0]), AnnotationDocument.Annotation[].class, "com.obric.memorydata.plugin");
        }

        public List<AnnotationDocument.Annotation> getAnnotationList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$5_HEJXpGmieCjpS6RZT7ZkKQV4(this), new $$Lambda$jHaABOMLlLXJRn6GRylUp1yKOY(this), new $$Lambda$zpdjQXy8oR4aXdjcvOiiGFDKt0(this), new $$Lambda$4_j3ve8mZQX49geihuDdmv4qwrk(this), new $$Lambda$ARC4u48S1W9KByTOaWz98HkHrEc(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        public NamedAttributeGroup getAttributeGroupArray(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            NamedAttributeGroup r3 = (NamedAttributeGroup) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[4], r4), NamedAttributeGroup.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 == null) goto L9;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        L9:
            throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        public NamedAttributeGroup[] getAttributeGroupArray() {
            return (NamedAttributeGroup[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[4], new NamedAttributeGroup[0]), NamedAttributeGroup[].class, "com.obric.memorydata.plugin");
        }

        public List<NamedAttributeGroup> getAttributeGroupList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$jEQ_y7ZWDWr2n4Sn7HsM6rmpVyo(this), new $$Lambda$krKqSlmx40Z8aHj_1w2nc4vEZI(this), new $$Lambda$D_skGuTQc8pyxt50Y3AdMdC400(this), new $$Lambda$Wt77NItTtTt3JZPKpcRqQwcedtc(this), new $$Lambda$flWjMguBC2NVK5TcklqoCyxKfBo(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        public TopLevelComplexType getComplexTypeArray(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TopLevelComplexType r3 = (TopLevelComplexType) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[2], r4), TopLevelComplexType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 == null) goto L9;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        L9:
            throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        public TopLevelComplexType[] getComplexTypeArray() {
            return (TopLevelComplexType[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[2], new TopLevelComplexType[0]), TopLevelComplexType[].class, "com.obric.memorydata.plugin");
        }

        public List<TopLevelComplexType> getComplexTypeList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$zcBysKrAmcdMr6O5Hu_IngxPl2I(this), new $$Lambda$JiKI0wMpvSrfrlXTYnQ3JxjGUvI(this), new $$Lambda$W39cwwY_XkRDLjeIsKPFB_5BhiE(this), new $$Lambda$2UdBz5I0v7XD5wbR3ITRXmg29zs(this), new $$Lambda$Mb1sV6md7ODvXM7r0SYlk45Q2U(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        public NamedGroup getGroupArray(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            NamedGroup r3 = (NamedGroup) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[3], r4), NamedGroup.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 == null) goto L9;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        L9:
            throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        public NamedGroup[] getGroupArray() {
            return (NamedGroup[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[3], new NamedGroup[0]), NamedGroup[].class, "com.obric.memorydata.plugin");
        }

        public List<NamedGroup> getGroupList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$_svEpcS0y4Diay1BQMZTwwEur0(this), new $$Lambda$z1u333WN0UWpZzBe6xQOrHjQ9c(this), new $$Lambda$uOZbK5SFQiVjrpgC7pEL_7WG8AI(this), new $$Lambda$PDcXk6iMZZfIXeUSdFougz5icg0(this), new $$Lambda$suulF5smeA0rhZM65r_hbzw0daM(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        public String getId() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[6]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[5]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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

        public TopLevelSimpleType getSimpleTypeArray(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TopLevelSimpleType r3 = (TopLevelSimpleType) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[1], r4), TopLevelSimpleType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 == null) goto L9;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        L9:
            throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        public TopLevelSimpleType[] getSimpleTypeArray() {
            return (TopLevelSimpleType[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[1], new TopLevelSimpleType[0]), TopLevelSimpleType[].class, "com.obric.memorydata.plugin");
        }

        public List<TopLevelSimpleType> getSimpleTypeList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$zmHYUSYXwQzqWjHo6XqyUo8YopE(this), new $$Lambda$JW3OmF8TnSWWXw8iKKllKXLKOnc(this), new $$Lambda$Z4wIZK5quKXQ9iFl45EGiGjYU(this), new $$Lambda$MR5ev5ByWMjMvprIQRMoqyFIN7g(this), new $$Lambda$njOYCQxgQ2FRGnSwWyH_ZAQtlAE(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        public AnnotationDocument.Annotation insertNewAnnotation(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            AnnotationDocument.Annotation r3 = (AnnotationDocument.Annotation) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[0], r4), AnnotationDocument.Annotation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public NamedAttributeGroup insertNewAttributeGroup(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            NamedAttributeGroup r3 = (NamedAttributeGroup) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[4], r4), NamedAttributeGroup.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public TopLevelComplexType insertNewComplexType(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            TopLevelComplexType r3 = (TopLevelComplexType) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[2], r4), TopLevelComplexType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public NamedGroup insertNewGroup(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            NamedGroup r3 = (NamedGroup) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[3], r4), NamedGroup.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public TopLevelSimpleType insertNewSimpleType(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            TopLevelSimpleType r3 = (TopLevelSimpleType) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[1], r4), TopLevelSimpleType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean isSetId() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            if (get_store().find_attribute_user(PROPERTY_QNAME[6]) == null) goto L7;
            boolean r3 = true;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        L7:
            r3 = false;
        L10:
            th = move-exception;
            throw th;
        }

        public void removeAnnotation(int r4) {
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

        public void removeAttributeGroup(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            get_store().remove_element(PROPERTY_QNAME[4], r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void removeComplexType(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            get_store().remove_element(PROPERTY_QNAME[2], r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void removeGroup(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            get_store().remove_element(PROPERTY_QNAME[3], r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void removeSimpleType(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            get_store().remove_element(PROPERTY_QNAME[1], r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void setAnnotationArray(int r3, AnnotationDocument.Annotation r4) {
            generatedSetterHelperImpl((AnnotationDocument.Annotation) ZeusTransformUtils.wrapperContextForParams(r4, AnnotationDocument.Annotation.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], r3, 2);
        }

        public void setAnnotationArray(AnnotationDocument.Annotation[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[0]);
        }

        public void setAttributeGroupArray(int r3, NamedAttributeGroup r4) {
            generatedSetterHelperImpl((NamedAttributeGroup) ZeusTransformUtils.wrapperContextForParams(r4, NamedAttributeGroup.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[4], r3, 2);
        }

        public void setAttributeGroupArray(NamedAttributeGroup[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[4]);
        }

        public void setComplexTypeArray(int r3, TopLevelComplexType r4) {
            generatedSetterHelperImpl((TopLevelComplexType) ZeusTransformUtils.wrapperContextForParams(r4, TopLevelComplexType.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[2], r3, 2);
        }

        public void setComplexTypeArray(TopLevelComplexType[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[2]);
        }

        public void setGroupArray(int r3, NamedGroup r4) {
            generatedSetterHelperImpl((NamedGroup) ZeusTransformUtils.wrapperContextForParams(r4, NamedGroup.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[3], r3, 2);
        }

        public void setGroupArray(NamedGroup[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[3]);
        }

        public void setId(String r7) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[6]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[6]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[5]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[5]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.setStringValue(r7);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void setSimpleTypeArray(int r3, TopLevelSimpleType r4) {
            generatedSetterHelperImpl((TopLevelSimpleType) ZeusTransformUtils.wrapperContextForParams(r4, TopLevelSimpleType.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[1], r3, 2);
        }

        public void setSimpleTypeArray(TopLevelSimpleType[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[1]);
        }

        public int sizeOfAnnotationArray() {
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

        public int sizeOfAttributeGroupArray() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            int r3 = get_store().count_elements(PROPERTY_QNAME[4]);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public int sizeOfComplexTypeArray() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            int r3 = get_store().count_elements(PROPERTY_QNAME[2]);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public int sizeOfGroupArray() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            int r3 = get_store().count_elements(PROPERTY_QNAME[3]);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public int sizeOfSimpleTypeArray() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            int r3 = get_store().count_elements(PROPERTY_QNAME[1]);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public void unsetId() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            get_store().remove_attribute(PROPERTY_QNAME[6]);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public XmlID xgetId() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            XmlID r3 = (XmlID) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[6]), XmlID.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            XmlAnyURI r3 = (XmlAnyURI) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[5]), XmlAnyURI.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public void xsetId(XmlID r7) {
            XmlID r8 = (XmlID) ZeusTransformUtils.wrapperContextForParams(r7, XmlID.class, "com.obric.memorydata.plugin");
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            XmlID r3 = (XmlID) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[6]), XmlID.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (XmlID) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[6]), XmlID.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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
            XmlAnyURI r3 = (XmlAnyURI) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[5]), XmlAnyURI.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (XmlAnyURI) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[5]), XmlAnyURI.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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
        PROPERTY_QNAME = new QName[]{new QName("http://www.w3.org/2001/XMLSchema", "redefine")};
    }

    public RedefineDocumentImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    public RedefineDocument.Redefine addNewRedefine() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        RedefineDocument.Redefine r3 = (RedefineDocument.Redefine) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), RedefineDocument.Redefine.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public RedefineDocument.Redefine getRedefine() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        RedefineDocument.Redefine r3 = (RedefineDocument.Redefine) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], 0), RedefineDocument.Redefine.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public void setRedefine(RedefineDocument.Redefine r4) {
        generatedSetterHelperImpl((RedefineDocument.Redefine) ZeusTransformUtils.wrapperContextForParams(r4, RedefineDocument.Redefine.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], 0, 1);
    }
}
