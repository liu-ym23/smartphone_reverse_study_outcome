package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute;
import org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.BlockSet;
import org.apache.xmlbeans.impl.xb.xsdschema.FormChoice;
import org.apache.xmlbeans.impl.xb.xsdschema.FullDerivationSet;
import org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedAttributeGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelAttribute;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelComplexType;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelSimpleType;

/* JADX INFO: loaded from: classes7.dex */
public class SchemaDocumentImpl extends XmlComplexContentImpl implements SchemaDocument {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    public static class SchemaImpl extends OpenAttrsImpl implements SchemaDocument.Schema {
        private static final QName[] PROPERTY_QNAME = null;
        private static final long serialVersionUID = 1;

        static {
            PROPERTY_QNAME = new QName[]{new QName("http://www.w3.org/2001/XMLSchema", "include"), new QName("http://www.w3.org/2001/XMLSchema", "import"), new QName("http://www.w3.org/2001/XMLSchema", "redefine"), new QName("http://www.w3.org/2001/XMLSchema", "annotation"), new QName("http://www.w3.org/2001/XMLSchema", "simpleType"), new QName("http://www.w3.org/2001/XMLSchema", "complexType"), new QName("http://www.w3.org/2001/XMLSchema", "group"), new QName("http://www.w3.org/2001/XMLSchema", "attributeGroup"), new QName("http://www.w3.org/2001/XMLSchema", "element"), new QName("http://www.w3.org/2001/XMLSchema", "attribute"), new QName("http://www.w3.org/2001/XMLSchema", "notation"), new QName("", "targetNamespace"), new QName("", "version"), new QName("", "finalDefault"), new QName("", "blockDefault"), new QName("", "attributeFormDefault"), new QName("", "elementFormDefault"), new QName("", OaidModel.KEY_ID), new QName("http://www.w3.org/XML/1998/namespace", "lang")};
        }

        public SchemaImpl(SchemaType r3) {
            super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
        }

        public AnnotationDocument.Annotation addNewAnnotation() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            AnnotationDocument.Annotation r3 = (AnnotationDocument.Annotation) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[3]), AnnotationDocument.Annotation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public TopLevelAttribute addNewAttribute() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            TopLevelAttribute r3 = (TopLevelAttribute) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[9]), TopLevelAttribute.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            NamedAttributeGroup r3 = (NamedAttributeGroup) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[7]), NamedAttributeGroup.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            TopLevelComplexType r3 = (TopLevelComplexType) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[5]), TopLevelComplexType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public TopLevelElement addNewElement() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            TopLevelElement r3 = (TopLevelElement) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[8]), TopLevelElement.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            NamedGroup r3 = (NamedGroup) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[6]), NamedGroup.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public ImportDocument.Import addNewImport() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            ImportDocument.Import r3 = (ImportDocument.Import) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[1]), ImportDocument.Import.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
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

        public NotationDocument.Notation addNewNotation() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            NotationDocument.Notation r3 = (NotationDocument.Notation) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[10]), NotationDocument.Notation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public RedefineDocument.Redefine addNewRedefine() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            RedefineDocument.Redefine r3 = (RedefineDocument.Redefine) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[2]), RedefineDocument.Redefine.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            TopLevelSimpleType r3 = (TopLevelSimpleType) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[4]), TopLevelSimpleType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            AnnotationDocument.Annotation r3 = (AnnotationDocument.Annotation) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[3], r4), AnnotationDocument.Annotation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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
            return (AnnotationDocument.Annotation[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[3], new AnnotationDocument.Annotation[0]), AnnotationDocument.Annotation[].class, "com.obric.memorydata.plugin");
        }

        public List<AnnotationDocument.Annotation> getAnnotationList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$_QuvUPnuZ5eQrVFbPEeJMdGSj7k(this), new $$Lambda$T_3KgkaLGhBCsEWfb9p4fjsY5Dw(this), new $$Lambda$TsmBVXTIeHhJgdEQjKzvsrp7H3g(this), new $$Lambda$VFuBjr6hXCdEfTLXC7hHxHy6bk(this), new $$Lambda$EsdV3GPzP0fvMl8JfuM4EIOoWH0(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        public TopLevelAttribute getAttributeArray(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TopLevelAttribute r3 = (TopLevelAttribute) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[9], r4), TopLevelAttribute.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 == null) goto L9;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        L9:
            throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        public TopLevelAttribute[] getAttributeArray() {
            return (TopLevelAttribute[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[9], new TopLevelAttribute[0]), TopLevelAttribute[].class, "com.obric.memorydata.plugin");
        }

        public FormChoice.Enum getAttributeFormDefault() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L12
            TypeStore r1 = get_store();     // Catch: Throwable -> L12
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L12
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[15]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
            if (r3 != null) goto L7;
            r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_default_attribute_value(r2[15]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        L7:
            if (r3 != null) goto L9;
            FormChoice.Enum r6 = null;
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r6;
        L9:
            r6 = (FormChoice.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), FormChoice.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        public NamedAttributeGroup getAttributeGroupArray(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            NamedAttributeGroup r3 = (NamedAttributeGroup) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[7], r4), NamedAttributeGroup.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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
            return (NamedAttributeGroup[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[7], new NamedAttributeGroup[0]), NamedAttributeGroup[].class, "com.obric.memorydata.plugin");
        }

        public List<NamedAttributeGroup> getAttributeGroupList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$xtFv9_ovao5ZHV6pW7eZyHN5lSQ(this), new $$Lambda$mb3UYTOH2lXYANM_4w6mXXzqBc(this), new $$Lambda$N1l52OozvWZgx5qO2VJLyqk6DiU(this), new $$Lambda$BdbkRzqMKYZUWLIsSYjSFzK0YBo(this), new $$Lambda$qZIahbAHhE0jtEIUjUvu5exbaNo(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        public List<TopLevelAttribute> getAttributeList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$SCXai2df63_3wP4_HEBGpguchis(this), new $$Lambda$gG8wwRcECNNChOiwMaGA2YNdk9E(this), new $$Lambda$_JQrR9uByKaE577PU6ltw0GwWns(this), new $$Lambda$bAU9iVPx_N_3p5OPu1WjxtC1YIg(this), new $$Lambda$QbqQAG9QbdiNYXUnaDUT93YwOs8(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        public Object getBlockDefault() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L12
            TypeStore r1 = get_store();     // Catch: Throwable -> L12
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L12
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[14]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
            if (r3 != null) goto L7;
            r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_default_attribute_value(r2[14]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
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

        public TopLevelComplexType getComplexTypeArray(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TopLevelComplexType r3 = (TopLevelComplexType) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[5], r4), TopLevelComplexType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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
            return (TopLevelComplexType[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[5], new TopLevelComplexType[0]), TopLevelComplexType[].class, "com.obric.memorydata.plugin");
        }

        public List<TopLevelComplexType> getComplexTypeList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$8fIhmiqkJZxHQFNS3coeiEiYY94(this), new $$Lambda$SRiShqVvpTW_MrMYhjFnMHhJeJA(this), new $$Lambda$FbHqd5LAJZMekDs7DkBLLr_Q8yA(this), new $$Lambda$aEB07ubENtRd87oxfbAEkBLVdKY(this), new $$Lambda$KIlGmx5tnS6pGSawXsK8Gkdmm5c(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        public TopLevelElement getElementArray(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TopLevelElement r3 = (TopLevelElement) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[8], r4), TopLevelElement.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 == null) goto L9;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        L9:
            throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        public TopLevelElement[] getElementArray() {
            return (TopLevelElement[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[8], new TopLevelElement[0]), TopLevelElement[].class, "com.obric.memorydata.plugin");
        }

        public FormChoice.Enum getElementFormDefault() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L12
            TypeStore r1 = get_store();     // Catch: Throwable -> L12
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L12
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[16]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
            if (r3 != null) goto L7;
            r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_default_attribute_value(r2[16]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        L7:
            if (r3 != null) goto L9;
            FormChoice.Enum r6 = null;
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r6;
        L9:
            r6 = (FormChoice.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), FormChoice.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        public List<TopLevelElement> getElementList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$FwagBTAo6bZjRKJVLlFoUmhE44(this), new $$Lambda$gdJUkiBOSQmrPC3fLdHwPYbwoH4(this), new $$Lambda$BUep3zKwj_k5Up1HrR6dKUnfk(this), new $$Lambda$JRp0tIFKo3zULyTeG4KFzBJKIeM(this), new $$Lambda$aXxEMy_8gqJZBugeMENHahro(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        public Object getFinalDefault() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L12
            TypeStore r1 = get_store();     // Catch: Throwable -> L12
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L12
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[13]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
            if (r3 != null) goto L7;
            r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_default_attribute_value(r2[13]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
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

        public NamedGroup getGroupArray(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            NamedGroup r3 = (NamedGroup) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[6], r4), NamedGroup.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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
            return (NamedGroup[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[6], new NamedGroup[0]), NamedGroup[].class, "com.obric.memorydata.plugin");
        }

        public List<NamedGroup> getGroupList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$hOlh9XNee5xjxWEtnRWdkODY1o(this), new $$Lambda$mr1IDqt0Un0olFHuLP263fdeBuU(this), new $$Lambda$OVtsd8O8EF9bDl0znwvfqBeoubs(this), new $$Lambda$PlQ1sNKKKkWbRzcjcJRJjCzrius(this), new $$Lambda$n1Gqq3SC3LHWGHgLQNujzG_3Jxk(this));     // Catch: Throwable -> L7
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
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[17]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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

        public ImportDocument.Import getImportArray(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            ImportDocument.Import r3 = (ImportDocument.Import) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[1], r4), ImportDocument.Import.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 == null) goto L9;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        L9:
            throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        public ImportDocument.Import[] getImportArray() {
            return (ImportDocument.Import[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[1], new ImportDocument.Import[0]), ImportDocument.Import[].class, "com.obric.memorydata.plugin");
        }

        public List<ImportDocument.Import> getImportList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$BTMewC42u_7uqeCLjHIyH8qVQM(this), new $$Lambda$8yfU89ISnfCzfi1nDiDIgP1TdI(this), new $$Lambda$ffsioI6JcEZeYGTaDrkbbg6hUb8(this), new $$Lambda$kFS272YHSXQLG_ZAk2bf1vqh9U(this), new $$Lambda$Vq6KEhJroZ3qy_RwRXHqm2h7DA(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        public IncludeDocument.Include getIncludeArray(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            IncludeDocument.Include r3 = (IncludeDocument.Include) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], r4), IncludeDocument.Include.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 == null) goto L9;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        L9:
            throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        public IncludeDocument.Include[] getIncludeArray() {
            return (IncludeDocument.Include[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[0], new IncludeDocument.Include[0]), IncludeDocument.Include[].class, "com.obric.memorydata.plugin");
        }

        public List<IncludeDocument.Include> getIncludeList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$4ufjSbx_Zdtra7pDkGQ53VgEUp8(this), new $$Lambda$C8441a39xgB4c6XCEb_zufj5jNc(this), new $$Lambda$8GwpcA2A2lQcY3vLeM4sSjQpcUg(this), new $$Lambda$iFVrlTHcSAGsdfGV9XofPjgeuUs(this), new $$Lambda$xQBb3QPRcldjJFNEPJdLx_Y966Q(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        public String getLang() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[18]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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

        public NotationDocument.Notation getNotationArray(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            NotationDocument.Notation r3 = (NotationDocument.Notation) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[10], r4), NotationDocument.Notation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 == null) goto L9;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        L9:
            throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        public NotationDocument.Notation[] getNotationArray() {
            return (NotationDocument.Notation[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[10], new NotationDocument.Notation[0]), NotationDocument.Notation[].class, "com.obric.memorydata.plugin");
        }

        public List<NotationDocument.Notation> getNotationList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$8xAzU1TIGZAAyAOSp7QG5skVoPA(this), new $$Lambda$B6vt4icA_1CWWnC75z7LaTuxzGo(this), new $$Lambda$RiE3eSuc9vqARmNMggCSIoFow(this), new $$Lambda$M0AO_bAzs4fcNo81u8qheml3lwI(this), new $$Lambda$nnpYzaSexqIujNpj1MTsdILfxeI(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        public RedefineDocument.Redefine getRedefineArray(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            RedefineDocument.Redefine r3 = (RedefineDocument.Redefine) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[2], r4), RedefineDocument.Redefine.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 == null) goto L9;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        L9:
            throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        public RedefineDocument.Redefine[] getRedefineArray() {
            return (RedefineDocument.Redefine[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[2], new RedefineDocument.Redefine[0]), RedefineDocument.Redefine[].class, "com.obric.memorydata.plugin");
        }

        public List<RedefineDocument.Redefine> getRedefineList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$MjUElpht80UN1ZstBlUeODQwQ(this), new $$Lambda$SmV3BeRWdktZxjS81bP2MRXP4(this), new $$Lambda$HAgXcem3PMfoJz9TI494Dn7l4Fk(this), new $$Lambda$LGw0bf19p21jEDgiaTTwmap7VI4(this), new $$Lambda$_d8jqqEnA8xp2KbduXORL3GgJTg(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        public TopLevelSimpleType getSimpleTypeArray(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TopLevelSimpleType r3 = (TopLevelSimpleType) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[4], r4), TopLevelSimpleType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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
            return (TopLevelSimpleType[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[4], new TopLevelSimpleType[0]), TopLevelSimpleType[].class, "com.obric.memorydata.plugin");
        }

        public List<TopLevelSimpleType> getSimpleTypeList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$w2LagFzsrDisa6Ap3LSEG5ngO2k(this), new $$Lambda$HbouvDPmxh2GWXG3kSM21rHtDGc(this), new $$Lambda$6AJA1Q8zZMqhEPxUdyyNPrVTSZ0(this), new $$Lambda$r7J11WkfjDwXTH9zWZwlaNG4V4(this), new $$Lambda$ixGdHXo0EUiwsg1KTNWigEWYY(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        public String getTargetNamespace() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[11]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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

        public String getVersion() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[12]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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

        public AnnotationDocument.Annotation insertNewAnnotation(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            AnnotationDocument.Annotation r3 = (AnnotationDocument.Annotation) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[3], r4), AnnotationDocument.Annotation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public TopLevelAttribute insertNewAttribute(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            TopLevelAttribute r3 = (TopLevelAttribute) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[9], r4), TopLevelAttribute.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            NamedAttributeGroup r3 = (NamedAttributeGroup) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[7], r4), NamedAttributeGroup.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            TopLevelComplexType r3 = (TopLevelComplexType) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[5], r4), TopLevelComplexType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public TopLevelElement insertNewElement(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            TopLevelElement r3 = (TopLevelElement) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[8], r4), TopLevelElement.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            NamedGroup r3 = (NamedGroup) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[6], r4), NamedGroup.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public ImportDocument.Import insertNewImport(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            ImportDocument.Import r3 = (ImportDocument.Import) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[1], r4), ImportDocument.Import.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public IncludeDocument.Include insertNewInclude(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            IncludeDocument.Include r3 = (IncludeDocument.Include) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[0], r4), IncludeDocument.Include.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public NotationDocument.Notation insertNewNotation(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            NotationDocument.Notation r3 = (NotationDocument.Notation) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[10], r4), NotationDocument.Notation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public RedefineDocument.Redefine insertNewRedefine(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            RedefineDocument.Redefine r3 = (RedefineDocument.Redefine) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[2], r4), RedefineDocument.Redefine.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            TopLevelSimpleType r3 = (TopLevelSimpleType) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[4], r4), TopLevelSimpleType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean isSetAttributeFormDefault() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            if (get_store().find_attribute_user(PROPERTY_QNAME[15]) == null) goto L7;
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

        public boolean isSetBlockDefault() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            if (get_store().find_attribute_user(PROPERTY_QNAME[14]) == null) goto L7;
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

        public boolean isSetElementFormDefault() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            if (get_store().find_attribute_user(PROPERTY_QNAME[16]) == null) goto L7;
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

        public boolean isSetFinalDefault() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            if (get_store().find_attribute_user(PROPERTY_QNAME[13]) == null) goto L7;
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

        public boolean isSetId() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            if (get_store().find_attribute_user(PROPERTY_QNAME[17]) == null) goto L7;
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

        public boolean isSetLang() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            if (get_store().find_attribute_user(PROPERTY_QNAME[18]) == null) goto L7;
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

        public boolean isSetTargetNamespace() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            if (get_store().find_attribute_user(PROPERTY_QNAME[11]) == null) goto L7;
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

        public boolean isSetVersion() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            if (get_store().find_attribute_user(PROPERTY_QNAME[12]) == null) goto L7;
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
            get_store().remove_element(PROPERTY_QNAME[3], r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void removeAttribute(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            get_store().remove_element(PROPERTY_QNAME[9], r4);     // Catch: Throwable -> L7
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
            get_store().remove_element(PROPERTY_QNAME[7], r4);     // Catch: Throwable -> L7
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
            get_store().remove_element(PROPERTY_QNAME[5], r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void removeElement(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            get_store().remove_element(PROPERTY_QNAME[8], r4);     // Catch: Throwable -> L7
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
            get_store().remove_element(PROPERTY_QNAME[6], r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void removeImport(int r4) {
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

        public void removeInclude(int r4) {
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

        public void removeNotation(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            get_store().remove_element(PROPERTY_QNAME[10], r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void removeRedefine(int r4) {
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

        public void removeSimpleType(int r4) {
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

        public void setAnnotationArray(int r3, AnnotationDocument.Annotation r4) {
            generatedSetterHelperImpl((AnnotationDocument.Annotation) ZeusTransformUtils.wrapperContextForParams(r4, AnnotationDocument.Annotation.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[3], r3, 2);
        }

        public void setAnnotationArray(AnnotationDocument.Annotation[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[3]);
        }

        public void setAttributeArray(int r3, TopLevelAttribute r4) {
            generatedSetterHelperImpl((TopLevelAttribute) ZeusTransformUtils.wrapperContextForParams(r4, TopLevelAttribute.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[9], r3, 2);
        }

        public void setAttributeArray(TopLevelAttribute[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[9]);
        }

        public void setAttributeFormDefault(FormChoice.Enum r7) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[15]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[15]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.setEnumValue(r7);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void setAttributeGroupArray(int r3, NamedAttributeGroup r4) {
            generatedSetterHelperImpl((NamedAttributeGroup) ZeusTransformUtils.wrapperContextForParams(r4, NamedAttributeGroup.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[7], r3, 2);
        }

        public void setAttributeGroupArray(NamedAttributeGroup[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[7]);
        }

        public void setBlockDefault(Object r7) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[14]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[14]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.setObjectValue(r7);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void setComplexTypeArray(int r3, TopLevelComplexType r4) {
            generatedSetterHelperImpl((TopLevelComplexType) ZeusTransformUtils.wrapperContextForParams(r4, TopLevelComplexType.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[5], r3, 2);
        }

        public void setComplexTypeArray(TopLevelComplexType[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[5]);
        }

        public void setElementArray(int r3, TopLevelElement r4) {
            generatedSetterHelperImpl((TopLevelElement) ZeusTransformUtils.wrapperContextForParams(r4, TopLevelElement.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[8], r3, 2);
        }

        public void setElementArray(TopLevelElement[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[8]);
        }

        public void setElementFormDefault(FormChoice.Enum r7) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[16]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[16]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.setEnumValue(r7);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void setFinalDefault(Object r7) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[13]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[13]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.setObjectValue(r7);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void setGroupArray(int r3, NamedGroup r4) {
            generatedSetterHelperImpl((NamedGroup) ZeusTransformUtils.wrapperContextForParams(r4, NamedGroup.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[6], r3, 2);
        }

        public void setGroupArray(NamedGroup[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[6]);
        }

        public void setId(String r7) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[17]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[17]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.setStringValue(r7);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void setImportArray(int r3, ImportDocument.Import r4) {
            generatedSetterHelperImpl((ImportDocument.Import) ZeusTransformUtils.wrapperContextForParams(r4, ImportDocument.Import.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[1], r3, 2);
        }

        public void setImportArray(ImportDocument.Import[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[1]);
        }

        public void setIncludeArray(int r3, IncludeDocument.Include r4) {
            generatedSetterHelperImpl((IncludeDocument.Include) ZeusTransformUtils.wrapperContextForParams(r4, IncludeDocument.Include.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], r3, 2);
        }

        public void setIncludeArray(IncludeDocument.Include[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[0]);
        }

        public void setLang(String r7) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[18]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[18]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.setStringValue(r7);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void setNotationArray(int r3, NotationDocument.Notation r4) {
            generatedSetterHelperImpl((NotationDocument.Notation) ZeusTransformUtils.wrapperContextForParams(r4, NotationDocument.Notation.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[10], r3, 2);
        }

        public void setNotationArray(NotationDocument.Notation[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[10]);
        }

        public void setRedefineArray(int r3, RedefineDocument.Redefine r4) {
            generatedSetterHelperImpl((RedefineDocument.Redefine) ZeusTransformUtils.wrapperContextForParams(r4, RedefineDocument.Redefine.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[2], r3, 2);
        }

        public void setRedefineArray(RedefineDocument.Redefine[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[2]);
        }

        public void setSimpleTypeArray(int r3, TopLevelSimpleType r4) {
            generatedSetterHelperImpl((TopLevelSimpleType) ZeusTransformUtils.wrapperContextForParams(r4, TopLevelSimpleType.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[4], r3, 2);
        }

        public void setSimpleTypeArray(TopLevelSimpleType[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[4]);
        }

        public void setTargetNamespace(String r7) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[11]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[11]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.setStringValue(r7);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void setVersion(String r7) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[12]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[12]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.setStringValue(r7);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public int sizeOfAnnotationArray() {
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

        public int sizeOfAttributeArray() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            int r3 = get_store().count_elements(PROPERTY_QNAME[9]);     // Catch: Throwable -> L7
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
            int r3 = get_store().count_elements(PROPERTY_QNAME[7]);     // Catch: Throwable -> L7
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
            int r3 = get_store().count_elements(PROPERTY_QNAME[5]);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public int sizeOfElementArray() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            int r3 = get_store().count_elements(PROPERTY_QNAME[8]);     // Catch: Throwable -> L7
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
            int r3 = get_store().count_elements(PROPERTY_QNAME[6]);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public int sizeOfImportArray() {
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

        public int sizeOfIncludeArray() {
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

        public int sizeOfNotationArray() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            int r3 = get_store().count_elements(PROPERTY_QNAME[10]);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public int sizeOfRedefineArray() {
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

        public int sizeOfSimpleTypeArray() {
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

        public void unsetAttributeFormDefault() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            get_store().remove_attribute(PROPERTY_QNAME[15]);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void unsetBlockDefault() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            get_store().remove_attribute(PROPERTY_QNAME[14]);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void unsetElementFormDefault() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            get_store().remove_attribute(PROPERTY_QNAME[16]);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void unsetFinalDefault() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            get_store().remove_attribute(PROPERTY_QNAME[13]);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void unsetId() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            get_store().remove_attribute(PROPERTY_QNAME[17]);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void unsetLang() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            get_store().remove_attribute(PROPERTY_QNAME[18]);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void unsetTargetNamespace() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            get_store().remove_attribute(PROPERTY_QNAME[11]);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void unsetVersion() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            get_store().remove_attribute(PROPERTY_QNAME[12]);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public FormChoice xgetAttributeFormDefault() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L9
            TypeStore r1 = get_store();     // Catch: Throwable -> L9
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L9
            FormChoice r3 = (FormChoice) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[15]), FormChoice.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            if (r3 != null) goto L7;
            r3 = (FormChoice) ZeusTransformUtils.preCheckCast(get_default_attribute_value(r2[15]), FormChoice.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r3;
        L9:
            th = move-exception;
            throw th;
        }

        public BlockSet xgetBlockDefault() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L9
            TypeStore r1 = get_store();     // Catch: Throwable -> L9
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L9
            BlockSet r3 = (BlockSet) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[14]), BlockSet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            if (r3 != null) goto L7;
            r3 = (BlockSet) ZeusTransformUtils.preCheckCast(get_default_attribute_value(r2[14]), BlockSet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r3;
        L9:
            th = move-exception;
            throw th;
        }

        public FormChoice xgetElementFormDefault() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L9
            TypeStore r1 = get_store();     // Catch: Throwable -> L9
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L9
            FormChoice r3 = (FormChoice) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[16]), FormChoice.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            if (r3 != null) goto L7;
            r3 = (FormChoice) ZeusTransformUtils.preCheckCast(get_default_attribute_value(r2[16]), FormChoice.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r3;
        L9:
            th = move-exception;
            throw th;
        }

        public FullDerivationSet xgetFinalDefault() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L9
            TypeStore r1 = get_store();     // Catch: Throwable -> L9
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L9
            FullDerivationSet r3 = (FullDerivationSet) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[13]), FullDerivationSet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            if (r3 != null) goto L7;
            r3 = (FullDerivationSet) ZeusTransformUtils.preCheckCast(get_default_attribute_value(r2[13]), FullDerivationSet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r3;
        L9:
            th = move-exception;
            throw th;
        }

        public XmlID xgetId() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            XmlID r3 = (XmlID) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[17]), XmlID.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public LangAttribute.Lang xgetLang() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            LangAttribute.Lang r3 = (LangAttribute.Lang) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[18]), LangAttribute.Lang.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public XmlAnyURI xgetTargetNamespace() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            XmlAnyURI r3 = (XmlAnyURI) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[11]), XmlAnyURI.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public XmlToken xgetVersion() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            XmlToken r3 = (XmlToken) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[12]), XmlToken.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public void xsetAttributeFormDefault(FormChoice r7) {
            FormChoice r8 = (FormChoice) ZeusTransformUtils.wrapperContextForParams(r7, FormChoice.class, "com.obric.memorydata.plugin");
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            FormChoice r3 = (FormChoice) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[15]), FormChoice.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (FormChoice) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[15]), FormChoice.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.set(r8);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void xsetBlockDefault(BlockSet r7) {
            BlockSet r8 = (BlockSet) ZeusTransformUtils.wrapperContextForParams(r7, BlockSet.class, "com.obric.memorydata.plugin");
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            BlockSet r3 = (BlockSet) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[14]), BlockSet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (BlockSet) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[14]), BlockSet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.set(r8);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void xsetElementFormDefault(FormChoice r7) {
            FormChoice r8 = (FormChoice) ZeusTransformUtils.wrapperContextForParams(r7, FormChoice.class, "com.obric.memorydata.plugin");
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            FormChoice r3 = (FormChoice) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[16]), FormChoice.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (FormChoice) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[16]), FormChoice.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.set(r8);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void xsetFinalDefault(FullDerivationSet r7) {
            FullDerivationSet r8 = (FullDerivationSet) ZeusTransformUtils.wrapperContextForParams(r7, FullDerivationSet.class, "com.obric.memorydata.plugin");
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            FullDerivationSet r3 = (FullDerivationSet) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[13]), FullDerivationSet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (FullDerivationSet) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[13]), FullDerivationSet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.set(r8);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
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
            XmlID r3 = (XmlID) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[17]), XmlID.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (XmlID) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[17]), XmlID.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.set(r8);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void xsetLang(LangAttribute.Lang r7) {
            LangAttribute.Lang r8 = (LangAttribute.Lang) ZeusTransformUtils.wrapperContextForParams(r7, LangAttribute.Lang.class, "com.obric.memorydata.plugin");
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            LangAttribute.Lang r3 = (LangAttribute.Lang) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[18]), LangAttribute.Lang.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (LangAttribute.Lang) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[18]), LangAttribute.Lang.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.set(r8);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void xsetTargetNamespace(XmlAnyURI r7) {
            XmlAnyURI r8 = (XmlAnyURI) ZeusTransformUtils.wrapperContextForParams(r7, XmlAnyURI.class, "com.obric.memorydata.plugin");
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            XmlAnyURI r3 = (XmlAnyURI) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[11]), XmlAnyURI.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (XmlAnyURI) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[11]), XmlAnyURI.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.set(r8);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void xsetVersion(XmlToken r7) {
            XmlToken r8 = (XmlToken) ZeusTransformUtils.wrapperContextForParams(r7, XmlToken.class, "com.obric.memorydata.plugin");
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            XmlToken r3 = (XmlToken) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[12]), XmlToken.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (XmlToken) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[12]), XmlToken.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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
        PROPERTY_QNAME = new QName[]{new QName("http://www.w3.org/2001/XMLSchema", "schema")};
    }

    public SchemaDocumentImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    public SchemaDocument.Schema addNewSchema() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        SchemaDocument.Schema r3 = (SchemaDocument.Schema) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), SchemaDocument.Schema.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public SchemaDocument.Schema getSchema() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        SchemaDocument.Schema r3 = (SchemaDocument.Schema) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], 0), SchemaDocument.Schema.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public void setSchema(SchemaDocument.Schema r4) {
        generatedSetterHelperImpl((SchemaDocument.Schema) ZeusTransformUtils.wrapperContextForParams(r4, SchemaDocument.Schema.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], 0, 1);
    }
}
