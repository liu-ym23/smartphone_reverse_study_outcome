package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupRef;
import org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.Facet;
import org.apache.xmlbeans.impl.xb.xsdschema.GroupRef;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
import org.apache.xmlbeans.impl.xb.xsdschema.NoFixedFacet;
import org.apache.xmlbeans.impl.xb.xsdschema.NumFacet;
import org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType;
import org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Wildcard;

/* JADX INFO: loaded from: classes7.dex */
public class RestrictionTypeImpl extends AnnotatedImpl implements RestrictionType {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    static {
        PROPERTY_QNAME = new QName[]{new QName("http://www.w3.org/2001/XMLSchema", "group"), new QName("http://www.w3.org/2001/XMLSchema", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL), new QName("http://www.w3.org/2001/XMLSchema", "choice"), new QName("http://www.w3.org/2001/XMLSchema", "sequence"), new QName("http://www.w3.org/2001/XMLSchema", "simpleType"), new QName("http://www.w3.org/2001/XMLSchema", XSDatatype.FACET_MINEXCLUSIVE), new QName("http://www.w3.org/2001/XMLSchema", XSDatatype.FACET_MININCLUSIVE), new QName("http://www.w3.org/2001/XMLSchema", XSDatatype.FACET_MAXEXCLUSIVE), new QName("http://www.w3.org/2001/XMLSchema", XSDatatype.FACET_MAXINCLUSIVE), new QName("http://www.w3.org/2001/XMLSchema", XSDatatype.FACET_TOTALDIGITS), new QName("http://www.w3.org/2001/XMLSchema", XSDatatype.FACET_FRACTIONDIGITS), new QName("http://www.w3.org/2001/XMLSchema", XSDatatype.FACET_LENGTH), new QName("http://www.w3.org/2001/XMLSchema", XSDatatype.FACET_MINLENGTH), new QName("http://www.w3.org/2001/XMLSchema", XSDatatype.FACET_MAXLENGTH), new QName("http://www.w3.org/2001/XMLSchema", XSDatatype.FACET_ENUMERATION), new QName("http://www.w3.org/2001/XMLSchema", XSDatatype.FACET_WHITESPACE), new QName("http://www.w3.org/2001/XMLSchema", XSDatatype.FACET_PATTERN), new QName("http://www.w3.org/2001/XMLSchema", "attribute"), new QName("http://www.w3.org/2001/XMLSchema", "attributeGroup"), new QName("http://www.w3.org/2001/XMLSchema", "anyAttribute"), new QName("", "base")};
    }

    public RestrictionTypeImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    public All addNewAll() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        All r3 = (All) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[1]), All.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public Wildcard addNewAnyAttribute() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        Wildcard r3 = (Wildcard) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[19]), Wildcard.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public Attribute addNewAttribute() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        Attribute r3 = (Attribute) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[17]), Attribute.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public AttributeGroupRef addNewAttributeGroup() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        AttributeGroupRef r3 = (AttributeGroupRef) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[18]), AttributeGroupRef.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ExplicitGroup addNewChoice() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ExplicitGroup r3 = (ExplicitGroup) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[2]), ExplicitGroup.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public NoFixedFacet addNewEnumeration() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        NoFixedFacet r3 = (NoFixedFacet) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[14]), NoFixedFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public NumFacet addNewFractionDigits() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        NumFacet r3 = (NumFacet) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[10]), NumFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public GroupRef addNewGroup() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        GroupRef r3 = (GroupRef) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), GroupRef.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public NumFacet addNewLength() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        NumFacet r3 = (NumFacet) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[11]), NumFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public Facet addNewMaxExclusive() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        Facet r3 = (Facet) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[7]), Facet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public Facet addNewMaxInclusive() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        Facet r3 = (Facet) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[8]), Facet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public NumFacet addNewMaxLength() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        NumFacet r3 = (NumFacet) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[13]), NumFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public Facet addNewMinExclusive() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        Facet r3 = (Facet) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[5]), Facet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public Facet addNewMinInclusive() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        Facet r3 = (Facet) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[6]), Facet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public NumFacet addNewMinLength() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        NumFacet r3 = (NumFacet) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[12]), NumFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public PatternDocument.Pattern addNewPattern() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        PatternDocument.Pattern r3 = (PatternDocument.Pattern) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[16]), PatternDocument.Pattern.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ExplicitGroup addNewSequence() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ExplicitGroup r3 = (ExplicitGroup) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[3]), ExplicitGroup.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public LocalSimpleType addNewSimpleType() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        LocalSimpleType r3 = (LocalSimpleType) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[4]), LocalSimpleType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public TotalDigitsDocument.TotalDigits addNewTotalDigits() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        TotalDigitsDocument.TotalDigits r3 = (TotalDigitsDocument.TotalDigits) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[9]), TotalDigitsDocument.TotalDigits.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public WhiteSpaceDocument.WhiteSpace addNewWhiteSpace() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        WhiteSpaceDocument.WhiteSpace r3 = (WhiteSpaceDocument.WhiteSpace) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[15]), WhiteSpaceDocument.WhiteSpace.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public All getAll() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        All r3 = (All) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[1], 0), All.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public Wildcard getAnyAttribute() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        Wildcard r3 = (Wildcard) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[19], 0), Wildcard.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public Attribute getAttributeArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        Attribute r3 = (Attribute) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[17], r4), Attribute.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public Attribute[] getAttributeArray() {
        return (Attribute[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[17], new Attribute[0]), Attribute[].class, "com.obric.memorydata.plugin");
    }

    public AttributeGroupRef getAttributeGroupArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        AttributeGroupRef r3 = (AttributeGroupRef) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[18], r4), AttributeGroupRef.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public AttributeGroupRef[] getAttributeGroupArray() {
        return (AttributeGroupRef[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[18], new AttributeGroupRef[0]), AttributeGroupRef[].class, "com.obric.memorydata.plugin");
    }

    public List<AttributeGroupRef> getAttributeGroupList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$mn96t0BHpYLfv4DLH7pZDI8sun8(this), new $$Lambda$oYd9UUtTUHnYUVqGcIkPUUfRUX0(this), new $$Lambda$qcOlLCqYfAEkr2XpFSbQyokBsC8(this), new $$Lambda$KS1q6QqheE1Z5omOYWSx8aMWk(this), new $$Lambda$hCnoLVB43yWiJvBjlxX5hSnL7Y(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public List<Attribute> getAttributeList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$VzvvtA6Gm_W42s0DUH9tsItKA(this), new $$Lambda$ESogIjs6NI0VmpwoqXf_sHoc4(this), new $$Lambda$h8glSV_gBGczHitZITE3BpGInYA(this), new $$Lambda$Yx2T6teSvFN9e3XYdQaghIzQ2Zw(this), new $$Lambda$dATBNXlhb9ZFVk0RWLOPQ5gn1F0(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public QName getBase() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[20]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        QName r4 = null;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r4;
    L7:
        r4 = r3.getQNameValue();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public ExplicitGroup getChoice() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        ExplicitGroup r3 = (ExplicitGroup) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[2], 0), ExplicitGroup.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public NoFixedFacet getEnumerationArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        NoFixedFacet r3 = (NoFixedFacet) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[14], r4), NoFixedFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public NoFixedFacet[] getEnumerationArray() {
        return (NoFixedFacet[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[14], new NoFixedFacet[0]), NoFixedFacet[].class, "com.obric.memorydata.plugin");
    }

    public List<NoFixedFacet> getEnumerationList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$Xn7JeeZxOxJJY0cVJeWtcspca6Y(this), new $$Lambda$s0v_UP1ozoUjHVGuqJjEURrlinM(this), new $$Lambda$FFBIWGReW4BDJ_3UwqrHA85J8Ks(this), new $$Lambda$vv5zA4Q68WR8Tca1zV2PerEPcXM(this), new $$Lambda$j5CAeLipl0zHDQPcNnVyNdC0qs(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public NumFacet getFractionDigitsArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        NumFacet r3 = (NumFacet) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[10], r4), NumFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public NumFacet[] getFractionDigitsArray() {
        return (NumFacet[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[10], new NumFacet[0]), NumFacet[].class, "com.obric.memorydata.plugin");
    }

    public List<NumFacet> getFractionDigitsList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$oW2jZZzx1My1J8fG4YypAk5gbKE(this), new $$Lambda$eoCyW85WQP6QrhRv4ThVnQ9VXKg(this), new $$Lambda$m91aQv7hIc9bM8XnA9IySd62xc(this), new $$Lambda$7TfygpawyFBI4NKdPyOVyzJn3Ls(this), new $$Lambda$znTSsGRwteuuDjuG7R080kKCHFQ(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public GroupRef getGroup() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        GroupRef r3 = (GroupRef) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], 0), GroupRef.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public NumFacet getLengthArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        NumFacet r3 = (NumFacet) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[11], r4), NumFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public NumFacet[] getLengthArray() {
        return (NumFacet[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[11], new NumFacet[0]), NumFacet[].class, "com.obric.memorydata.plugin");
    }

    public List<NumFacet> getLengthList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$o_yJC9xXqXcDMqhpZIp6up1RMUk(this), new $$Lambda$X_R932dKUFGLMBvVLO7BZNkXjQY(this), new $$Lambda$gk8X3vAmml4Xay6QUIgbfHP8Nig(this), new $$Lambda$iVU8V4lQ8N0vgM44JoSPWtpAzI(this), new $$Lambda$wHyGRLLUziLFhZbSY0b8euy8Ro(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public Facet getMaxExclusiveArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        Facet r3 = (Facet) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[7], r4), Facet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public Facet[] getMaxExclusiveArray() {
        return (Facet[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[7], new Facet[0]), Facet[].class, "com.obric.memorydata.plugin");
    }

    public List<Facet> getMaxExclusiveList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$xyiexsIg2D_hZglf24y8PGJqRG4(this), new $$Lambda$iHpw0dJgGM1Q_QlJiDUw2ths_B0(this), new $$Lambda$oHsR6eQo4eArDDZGmwx0dMyj_U(this), new $$Lambda$RtHmmcWePdh8ZvsfkTh4wLD4vP0(this), new $$Lambda$EmO2k0Nocx0WJhMZpNrAnLWOMQ(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public Facet getMaxInclusiveArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        Facet r3 = (Facet) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[8], r4), Facet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public Facet[] getMaxInclusiveArray() {
        return (Facet[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[8], new Facet[0]), Facet[].class, "com.obric.memorydata.plugin");
    }

    public List<Facet> getMaxInclusiveList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$ByMSOIPFHwWlNwycPH6CFiEE_Cg(this), new $$Lambda$sl4AwRholac0MaqLqZiqbMdrs(this), new $$Lambda$UGVzTzCAGiGpPh5h_7zpgx8sepY(this), new $$Lambda$SS32bVByNgms2NZs80cDyLI9GFI(this), new $$Lambda$J_HfqwPrzRYBCOmAlEhMWEfC4E8(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public NumFacet getMaxLengthArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        NumFacet r3 = (NumFacet) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[13], r4), NumFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public NumFacet[] getMaxLengthArray() {
        return (NumFacet[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[13], new NumFacet[0]), NumFacet[].class, "com.obric.memorydata.plugin");
    }

    public List<NumFacet> getMaxLengthList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$sETSHEdCcejapz3P_xOuEb086fI(this), new $$Lambda$BSfO2P7kGaGj5PuydJrZNLDkU7M(this), new $$Lambda$ZyfkjnVsgDz2TTZXNF3Ri9edQ(this), new $$Lambda$GCdqRLqM3iIARuP6A4zmxi9J5Qg(this), new $$Lambda$uROhBbv5de3vTnLLO_pHCVMDK8(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public Facet getMinExclusiveArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        Facet r3 = (Facet) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[5], r4), Facet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public Facet[] getMinExclusiveArray() {
        return (Facet[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[5], new Facet[0]), Facet[].class, "com.obric.memorydata.plugin");
    }

    public List<Facet> getMinExclusiveList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$KhebiRmpuXyyePMwhbsFAztRAp8(this), new $$Lambda$Hc8vN0vGhkRMprDZKlZ4TWSRIY0(this), new $$Lambda$J2voC69lJqVa_g7igp2frqa6YI0(this), new $$Lambda$Bs_WlbKE4lqvso9ALu689GaGOY(this), new $$Lambda$A4h39GjR8H7Lf2L4E6X9FFbF0(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public Facet getMinInclusiveArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        Facet r3 = (Facet) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[6], r4), Facet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public Facet[] getMinInclusiveArray() {
        return (Facet[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[6], new Facet[0]), Facet[].class, "com.obric.memorydata.plugin");
    }

    public List<Facet> getMinInclusiveList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$QVgv7lgDM0eFw5CyAO4u3Ohvb2E(this), new $$Lambda$C612UmPhhe4mDDzDjBtYIjk4SLQ(this), new $$Lambda$i03ecC6KjWddq13m7Km0Qs9WD4(this), new $$Lambda$fxnbkMfhkKzpTLyf6DuJkYpUE(this), new $$Lambda$DHNrrXKOAlo_TdiVNxLhxZPNDWw(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public NumFacet getMinLengthArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        NumFacet r3 = (NumFacet) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[12], r4), NumFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public NumFacet[] getMinLengthArray() {
        return (NumFacet[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[12], new NumFacet[0]), NumFacet[].class, "com.obric.memorydata.plugin");
    }

    public List<NumFacet> getMinLengthList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$Cdakw1FY_AawX7_i_Wm2FY4pUs(this), new $$Lambda$vPuQ6oeIWMYv2N33JsS67f3ZAZg(this), new $$Lambda$lSh9c1SbI9X3edXOHCZdlC0r4B0(this), new $$Lambda$EnbHiZnGkRkATK8uPxhxvUlMnt8(this), new $$Lambda$g1pmItoyMrEbEQFFZT53xW4_RY(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public PatternDocument.Pattern getPatternArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        PatternDocument.Pattern r3 = (PatternDocument.Pattern) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[16], r4), PatternDocument.Pattern.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public PatternDocument.Pattern[] getPatternArray() {
        return (PatternDocument.Pattern[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[16], new PatternDocument.Pattern[0]), PatternDocument.Pattern[].class, "com.obric.memorydata.plugin");
    }

    public List<PatternDocument.Pattern> getPatternList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$VWeiCH8UpBHIc0HubENEZEJSv4(this), new $$Lambda$fmDRHZ9ZfsxqsfrCvrNOrrk2Fmw(this), new $$Lambda$rDSwdrpqBUMVF_erpu7GmKR5CIk(this), new $$Lambda$oYquBmS2Saqt6gPQF4S7RAaRmpw(this), new $$Lambda$vA6eFg5nW1x7QBhI07jX8cvGKI(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public ExplicitGroup getSequence() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        ExplicitGroup r3 = (ExplicitGroup) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[3], 0), ExplicitGroup.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public LocalSimpleType getSimpleType() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        LocalSimpleType r3 = (LocalSimpleType) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[4], 0), LocalSimpleType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public TotalDigitsDocument.TotalDigits getTotalDigitsArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TotalDigitsDocument.TotalDigits r3 = (TotalDigitsDocument.TotalDigits) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[9], r4), TotalDigitsDocument.TotalDigits.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public TotalDigitsDocument.TotalDigits[] getTotalDigitsArray() {
        return (TotalDigitsDocument.TotalDigits[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[9], new TotalDigitsDocument.TotalDigits[0]), TotalDigitsDocument.TotalDigits[].class, "com.obric.memorydata.plugin");
    }

    public List<TotalDigitsDocument.TotalDigits> getTotalDigitsList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$8Xp5hpnyT9V5HxNkmlbcViXLDac(this), new $$Lambda$FTZgipYC1kwuVIZ6eBnQuHnDMjg(this), new $$Lambda$psxInjLAzwWtTX2xypfCR8LcL_c(this), new $$Lambda$Znm12siPXbFvICdOqitgVDNBFU(this), new $$Lambda$rOWqclqmXKVG9_vslwWUkEifHpo(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public WhiteSpaceDocument.WhiteSpace getWhiteSpaceArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        WhiteSpaceDocument.WhiteSpace r3 = (WhiteSpaceDocument.WhiteSpace) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[15], r4), WhiteSpaceDocument.WhiteSpace.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public WhiteSpaceDocument.WhiteSpace[] getWhiteSpaceArray() {
        return (WhiteSpaceDocument.WhiteSpace[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[15], new WhiteSpaceDocument.WhiteSpace[0]), WhiteSpaceDocument.WhiteSpace[].class, "com.obric.memorydata.plugin");
    }

    public List<WhiteSpaceDocument.WhiteSpace> getWhiteSpaceList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$E_HFQBwrpej7T7NbsSgBgTyoZP4(this), new $$Lambda$srr4GOeRc7J7XsRC_nTOjNcu4I(this), new $$Lambda$pKQkkAZW45D6xmBx1PEJFUiYE(this), new $$Lambda$CJGeJWv1zAJv6BweYF66khWeKU(this), new $$Lambda$CQFlt2PMivYORPxzWSvqa3ZEIU(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public Attribute insertNewAttribute(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        Attribute r3 = (Attribute) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[17], r4), Attribute.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public AttributeGroupRef insertNewAttributeGroup(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        AttributeGroupRef r3 = (AttributeGroupRef) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[18], r4), AttributeGroupRef.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public NoFixedFacet insertNewEnumeration(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        NoFixedFacet r3 = (NoFixedFacet) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[14], r4), NoFixedFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public NumFacet insertNewFractionDigits(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        NumFacet r3 = (NumFacet) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[10], r4), NumFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public NumFacet insertNewLength(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        NumFacet r3 = (NumFacet) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[11], r4), NumFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public Facet insertNewMaxExclusive(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        Facet r3 = (Facet) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[7], r4), Facet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public Facet insertNewMaxInclusive(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        Facet r3 = (Facet) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[8], r4), Facet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public NumFacet insertNewMaxLength(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        NumFacet r3 = (NumFacet) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[13], r4), NumFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public Facet insertNewMinExclusive(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        Facet r3 = (Facet) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[5], r4), Facet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public Facet insertNewMinInclusive(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        Facet r3 = (Facet) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[6], r4), Facet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public NumFacet insertNewMinLength(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        NumFacet r3 = (NumFacet) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[12], r4), NumFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public PatternDocument.Pattern insertNewPattern(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        PatternDocument.Pattern r3 = (PatternDocument.Pattern) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[16], r4), PatternDocument.Pattern.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public TotalDigitsDocument.TotalDigits insertNewTotalDigits(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        TotalDigitsDocument.TotalDigits r3 = (TotalDigitsDocument.TotalDigits) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[9], r4), TotalDigitsDocument.TotalDigits.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public WhiteSpaceDocument.WhiteSpace insertNewWhiteSpace(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        WhiteSpaceDocument.WhiteSpace r3 = (WhiteSpaceDocument.WhiteSpace) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[15], r4), WhiteSpaceDocument.WhiteSpace.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isSetAll() {
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

    public boolean isSetAnyAttribute() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        if (get_store().count_elements(PROPERTY_QNAME[19]) == 0) goto L7;
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

    public boolean isSetChoice() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        if (get_store().count_elements(PROPERTY_QNAME[2]) == 0) goto L7;
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

    public boolean isSetGroup() {
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

    public boolean isSetSequence() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        if (get_store().count_elements(PROPERTY_QNAME[3]) == 0) goto L7;
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

    public boolean isSetSimpleType() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        if (get_store().count_elements(PROPERTY_QNAME[4]) == 0) goto L7;
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

    public void removeAttribute(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[17], r4);     // Catch: Throwable -> L7
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
        get_store().remove_element(PROPERTY_QNAME[18], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeEnumeration(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[14], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeFractionDigits(int r4) {
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

    public void removeLength(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[11], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeMaxExclusive(int r4) {
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

    public void removeMaxInclusive(int r4) {
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

    public void removeMaxLength(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[13], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeMinExclusive(int r4) {
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

    public void removeMinInclusive(int r4) {
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

    public void removeMinLength(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[12], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removePattern(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[16], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeTotalDigits(int r4) {
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

    public void removeWhiteSpace(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[15], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setAll(All r4) {
        generatedSetterHelperImpl((All) ZeusTransformUtils.wrapperContextForParams(r4, All.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[1], 0, 1);
    }

    public void setAnyAttribute(Wildcard r4) {
        generatedSetterHelperImpl((Wildcard) ZeusTransformUtils.wrapperContextForParams(r4, Wildcard.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[19], 0, 1);
    }

    public void setAttributeArray(int r3, Attribute r4) {
        generatedSetterHelperImpl((Attribute) ZeusTransformUtils.wrapperContextForParams(r4, Attribute.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[17], r3, 2);
    }

    public void setAttributeArray(Attribute[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[17]);
    }

    public void setAttributeGroupArray(int r3, AttributeGroupRef r4) {
        generatedSetterHelperImpl((AttributeGroupRef) ZeusTransformUtils.wrapperContextForParams(r4, AttributeGroupRef.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[18], r3, 2);
    }

    public void setAttributeGroupArray(AttributeGroupRef[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[18]);
    }

    public void setBase(QName r7) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[20]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[20]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.setQNameValue(r7);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void setChoice(ExplicitGroup r4) {
        generatedSetterHelperImpl((ExplicitGroup) ZeusTransformUtils.wrapperContextForParams(r4, ExplicitGroup.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[2], 0, 1);
    }

    public void setEnumerationArray(int r3, NoFixedFacet r4) {
        generatedSetterHelperImpl((NoFixedFacet) ZeusTransformUtils.wrapperContextForParams(r4, NoFixedFacet.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[14], r3, 2);
    }

    public void setEnumerationArray(NoFixedFacet[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[14]);
    }

    public void setFractionDigitsArray(int r3, NumFacet r4) {
        generatedSetterHelperImpl((NumFacet) ZeusTransformUtils.wrapperContextForParams(r4, NumFacet.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[10], r3, 2);
    }

    public void setFractionDigitsArray(NumFacet[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[10]);
    }

    public void setGroup(GroupRef r4) {
        generatedSetterHelperImpl((GroupRef) ZeusTransformUtils.wrapperContextForParams(r4, GroupRef.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], 0, 1);
    }

    public void setLengthArray(int r3, NumFacet r4) {
        generatedSetterHelperImpl((NumFacet) ZeusTransformUtils.wrapperContextForParams(r4, NumFacet.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[11], r3, 2);
    }

    public void setLengthArray(NumFacet[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[11]);
    }

    public void setMaxExclusiveArray(int r3, Facet r4) {
        generatedSetterHelperImpl((Facet) ZeusTransformUtils.wrapperContextForParams(r4, Facet.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[7], r3, 2);
    }

    public void setMaxExclusiveArray(Facet[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[7]);
    }

    public void setMaxInclusiveArray(int r3, Facet r4) {
        generatedSetterHelperImpl((Facet) ZeusTransformUtils.wrapperContextForParams(r4, Facet.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[8], r3, 2);
    }

    public void setMaxInclusiveArray(Facet[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[8]);
    }

    public void setMaxLengthArray(int r3, NumFacet r4) {
        generatedSetterHelperImpl((NumFacet) ZeusTransformUtils.wrapperContextForParams(r4, NumFacet.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[13], r3, 2);
    }

    public void setMaxLengthArray(NumFacet[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[13]);
    }

    public void setMinExclusiveArray(int r3, Facet r4) {
        generatedSetterHelperImpl((Facet) ZeusTransformUtils.wrapperContextForParams(r4, Facet.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[5], r3, 2);
    }

    public void setMinExclusiveArray(Facet[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[5]);
    }

    public void setMinInclusiveArray(int r3, Facet r4) {
        generatedSetterHelperImpl((Facet) ZeusTransformUtils.wrapperContextForParams(r4, Facet.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[6], r3, 2);
    }

    public void setMinInclusiveArray(Facet[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[6]);
    }

    public void setMinLengthArray(int r3, NumFacet r4) {
        generatedSetterHelperImpl((NumFacet) ZeusTransformUtils.wrapperContextForParams(r4, NumFacet.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[12], r3, 2);
    }

    public void setMinLengthArray(NumFacet[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[12]);
    }

    public void setPatternArray(int r3, PatternDocument.Pattern r4) {
        generatedSetterHelperImpl((PatternDocument.Pattern) ZeusTransformUtils.wrapperContextForParams(r4, PatternDocument.Pattern.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[16], r3, 2);
    }

    public void setPatternArray(PatternDocument.Pattern[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[16]);
    }

    public void setSequence(ExplicitGroup r4) {
        generatedSetterHelperImpl((ExplicitGroup) ZeusTransformUtils.wrapperContextForParams(r4, ExplicitGroup.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[3], 0, 1);
    }

    public void setSimpleType(LocalSimpleType r4) {
        generatedSetterHelperImpl((LocalSimpleType) ZeusTransformUtils.wrapperContextForParams(r4, LocalSimpleType.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[4], 0, 1);
    }

    public void setTotalDigitsArray(int r3, TotalDigitsDocument.TotalDigits r4) {
        generatedSetterHelperImpl((TotalDigitsDocument.TotalDigits) ZeusTransformUtils.wrapperContextForParams(r4, TotalDigitsDocument.TotalDigits.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[9], r3, 2);
    }

    public void setTotalDigitsArray(TotalDigitsDocument.TotalDigits[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[9]);
    }

    public void setWhiteSpaceArray(int r3, WhiteSpaceDocument.WhiteSpace r4) {
        generatedSetterHelperImpl((WhiteSpaceDocument.WhiteSpace) ZeusTransformUtils.wrapperContextForParams(r4, WhiteSpaceDocument.WhiteSpace.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[15], r3, 2);
    }

    public void setWhiteSpaceArray(WhiteSpaceDocument.WhiteSpace[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[15]);
    }

    public int sizeOfAttributeArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[17]);     // Catch: Throwable -> L7
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
        int r3 = get_store().count_elements(PROPERTY_QNAME[18]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfEnumerationArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[14]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfFractionDigitsArray() {
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

    public int sizeOfLengthArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[11]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfMaxExclusiveArray() {
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

    public int sizeOfMaxInclusiveArray() {
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

    public int sizeOfMaxLengthArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[13]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfMinExclusiveArray() {
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

    public int sizeOfMinInclusiveArray() {
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

    public int sizeOfMinLengthArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[12]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfPatternArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[16]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfTotalDigitsArray() {
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

    public int sizeOfWhiteSpaceArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[15]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public void unsetAll() {
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

    public void unsetAnyAttribute() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[19], 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unsetChoice() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[2], 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unsetGroup() {
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

    public void unsetSequence() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[3], 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unsetSimpleType() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[4], 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlQName xgetBase() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlQName r3 = (XmlQName) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[20]), XmlQName.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetBase(XmlQName r7) {
        XmlQName r8 = (XmlQName) ZeusTransformUtils.wrapperContextForParams(r7, XmlQName.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        XmlQName r3 = (XmlQName) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[20]), XmlQName.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (XmlQName) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[20]), XmlQName.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.set(r8);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
