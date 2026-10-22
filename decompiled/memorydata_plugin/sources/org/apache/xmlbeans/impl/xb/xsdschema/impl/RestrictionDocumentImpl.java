package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.Facet;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
import org.apache.xmlbeans.impl.xb.xsdschema.NoFixedFacet;
import org.apache.xmlbeans.impl.xb.xsdschema.NumFacet;
import org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument;

/* JADX INFO: loaded from: classes7.dex */
public class RestrictionDocumentImpl extends XmlComplexContentImpl implements RestrictionDocument {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    public static class RestrictionImpl extends AnnotatedImpl implements RestrictionDocument.Restriction {
        private static final QName[] PROPERTY_QNAME = null;
        private static final long serialVersionUID = 1;

        static {
            PROPERTY_QNAME = new QName[]{new QName("http://www.w3.org/2001/XMLSchema", "simpleType"), new QName("http://www.w3.org/2001/XMLSchema", XSDatatype.FACET_MINEXCLUSIVE), new QName("http://www.w3.org/2001/XMLSchema", XSDatatype.FACET_MININCLUSIVE), new QName("http://www.w3.org/2001/XMLSchema", XSDatatype.FACET_MAXEXCLUSIVE), new QName("http://www.w3.org/2001/XMLSchema", XSDatatype.FACET_MAXINCLUSIVE), new QName("http://www.w3.org/2001/XMLSchema", XSDatatype.FACET_TOTALDIGITS), new QName("http://www.w3.org/2001/XMLSchema", XSDatatype.FACET_FRACTIONDIGITS), new QName("http://www.w3.org/2001/XMLSchema", XSDatatype.FACET_LENGTH), new QName("http://www.w3.org/2001/XMLSchema", XSDatatype.FACET_MINLENGTH), new QName("http://www.w3.org/2001/XMLSchema", XSDatatype.FACET_MAXLENGTH), new QName("http://www.w3.org/2001/XMLSchema", XSDatatype.FACET_ENUMERATION), new QName("http://www.w3.org/2001/XMLSchema", XSDatatype.FACET_WHITESPACE), new QName("http://www.w3.org/2001/XMLSchema", XSDatatype.FACET_PATTERN), new QName("", "base")};
        }

        public RestrictionImpl(SchemaType r3) {
            super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
        }

        public NoFixedFacet addNewEnumeration() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            NoFixedFacet r3 = (NoFixedFacet) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[10]), NoFixedFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            NumFacet r3 = (NumFacet) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[6]), NumFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            NumFacet r3 = (NumFacet) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[7]), NumFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            Facet r3 = (Facet) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[3]), Facet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            Facet r3 = (Facet) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[4]), Facet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            NumFacet r3 = (NumFacet) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[9]), NumFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            Facet r3 = (Facet) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[1]), Facet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            Facet r3 = (Facet) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[2]), Facet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            NumFacet r3 = (NumFacet) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[8]), NumFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            PatternDocument.Pattern r3 = (PatternDocument.Pattern) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[12]), PatternDocument.Pattern.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            LocalSimpleType r3 = (LocalSimpleType) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), LocalSimpleType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            TotalDigitsDocument.TotalDigits r3 = (TotalDigitsDocument.TotalDigits) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[5]), TotalDigitsDocument.TotalDigits.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            WhiteSpaceDocument.WhiteSpace r3 = (WhiteSpaceDocument.WhiteSpace) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[11]), WhiteSpaceDocument.WhiteSpace.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public QName getBase() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[13]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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

        public NoFixedFacet getEnumerationArray(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            NoFixedFacet r3 = (NoFixedFacet) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[10], r4), NoFixedFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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
            return (NoFixedFacet[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[10], new NoFixedFacet[0]), NoFixedFacet[].class, "com.obric.memorydata.plugin");
        }

        public List<NoFixedFacet> getEnumerationList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$EBjbghGwTH5u1afs87pTQasY0Y(this), new $$Lambda$GcOmdH04SZ8TksIx3jsbFmvE8bc(this), new $$Lambda$DXT4loCCw_WLMuOGpwinDYLZJg(this), new $$Lambda$lOSQTXgCCRmbRvCdF5u111ZXUQ(this), new $$Lambda$UrGYdapQHvdvxxeT4CYgQFwKOQ(this));     // Catch: Throwable -> L7
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
            NumFacet r3 = (NumFacet) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[6], r4), NumFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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
            return (NumFacet[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[6], new NumFacet[0]), NumFacet[].class, "com.obric.memorydata.plugin");
        }

        public List<NumFacet> getFractionDigitsList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$P3x1jqrkIaTyaUoKb6m7VhpetxU(this), new $$Lambda$RTAPC_Jw1FDhqVQ6uEqTsp2Hiro(this), new $$Lambda$tgJhcFl7uxTVZ2tslkS7sWTrHPY(this), new $$Lambda$NQakFgd_vuYZxfgpSPievYMzD5s(this), new $$Lambda$OCPKK4uQ7RZCNx2_OW6mkZkJrE(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        public NumFacet getLengthArray(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            NumFacet r3 = (NumFacet) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[7], r4), NumFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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
            return (NumFacet[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[7], new NumFacet[0]), NumFacet[].class, "com.obric.memorydata.plugin");
        }

        public List<NumFacet> getLengthList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$pJUBtgzmUPcjUItD8Jo653POyp8(this), new $$Lambda$2vYxG7z6mUZQJ_Fx5APXkY5GM6I(this), new $$Lambda$_X3TmmbGVcnLfqMg8znGFm9C0o(this), new $$Lambda$JOF_kwlH_5LlzGcTA81nfrdL8dI(this), new $$Lambda$kgtJ6TbDp2klsQeC68bX3msek(this));     // Catch: Throwable -> L7
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
            Facet r3 = (Facet) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[3], r4), Facet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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
            return (Facet[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[3], new Facet[0]), Facet[].class, "com.obric.memorydata.plugin");
        }

        public List<Facet> getMaxExclusiveList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$wa2P2fiN1qO4DjHxlxXkTeqKGQ4(this), new $$Lambda$tN7PNuS5r_21wOz5cuP0zogxxJA(this), new $$Lambda$GLqwkL4LbJ4WEy8tHMG6eZqVPec(this), new $$Lambda$bi77L06iA4acTIlbRytvSkqCj4(this), new $$Lambda$8jNXzV_DL5ZvNRxy1WV7EyJ4eAs(this));     // Catch: Throwable -> L7
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
            Facet r3 = (Facet) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[4], r4), Facet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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
            return (Facet[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[4], new Facet[0]), Facet[].class, "com.obric.memorydata.plugin");
        }

        public List<Facet> getMaxInclusiveList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$RTjtEUf4nfOVrTrxnWOzNimXIkI(this), new $$Lambda$QzRb1Yz05IclKNHGjCEOAArjC18(this), new $$Lambda$XeMiO4FLJOSr5dUtCVR0tUZVffw(this), new $$Lambda$_N6PTLHQl3iurnPZ8RNysNJ7g0(this), new $$Lambda$kHkuQQ3uaBqG7v5xMNkU2OUjtI(this));     // Catch: Throwable -> L7
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
            NumFacet r3 = (NumFacet) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[9], r4), NumFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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
            return (NumFacet[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[9], new NumFacet[0]), NumFacet[].class, "com.obric.memorydata.plugin");
        }

        public List<NumFacet> getMaxLengthList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$1vmK0mpjCfFzfi0ej1ShxiRFQh8(this), new $$Lambda$DlP3omYXhF52lldN1LGRIgFJ1U(this), new $$Lambda$gM2Uy9Plw8166BLfuSlrl6EGPAE(this), new $$Lambda$O4Q9dbJevTtEhwSMKGTtusJi3M(this), new $$Lambda$zJMLoYNRGTbNqlocAqISA4Zhkg(this));     // Catch: Throwable -> L7
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
            Facet r3 = (Facet) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[1], r4), Facet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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
            return (Facet[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[1], new Facet[0]), Facet[].class, "com.obric.memorydata.plugin");
        }

        public List<Facet> getMinExclusiveList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$51HKdR_3wwgTGlr5dL52SKffuto(this), new $$Lambda$zhj5jNm4BPNnBbXnNVVgkqu1MM(this), new $$Lambda$akmg8iK0HKfBuoWWRC5b2wHke8(this), new $$Lambda$PeoFGq7YYb8GW7WJ4Zrd7FXH8(this), new $$Lambda$zwlAl7jShNvd3ZyJXI5hbtNL2Y(this));     // Catch: Throwable -> L7
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
            Facet r3 = (Facet) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[2], r4), Facet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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
            return (Facet[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[2], new Facet[0]), Facet[].class, "com.obric.memorydata.plugin");
        }

        public List<Facet> getMinInclusiveList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$IjCx1bw4mCcD8XrHtHPr_NusvU(this), new $$Lambda$jw5TSMhXm4Odqf2iyhfYzbjpn70(this), new $$Lambda$JDagWzie_UoUlPnn4IpBHhBL8(this), new $$Lambda$jDM9l4LFOW2w2j75VNkA_heVFHI(this), new $$Lambda$INPxrrjO4FFp3Gjo_kW_7byPXcc(this));     // Catch: Throwable -> L7
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
            NumFacet r3 = (NumFacet) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[8], r4), NumFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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
            return (NumFacet[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[8], new NumFacet[0]), NumFacet[].class, "com.obric.memorydata.plugin");
        }

        public List<NumFacet> getMinLengthList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$U24SmrX9spF6Nk_Wn5ovClTGsKc(this), new $$Lambda$6vk7t9vQxJdm28Lhw1QbKzMaWo(this), new $$Lambda$V8aOllTuosK8UTF1L3pjzCFA(this), new $$Lambda$2UBbBrVHMAZJJTfa0OxyupZDa6g(this), new $$Lambda$9oIlpNctay_RpQKTarZgb1E0(this));     // Catch: Throwable -> L7
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
            PatternDocument.Pattern r3 = (PatternDocument.Pattern) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[12], r4), PatternDocument.Pattern.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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
            return (PatternDocument.Pattern[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[12], new PatternDocument.Pattern[0]), PatternDocument.Pattern[].class, "com.obric.memorydata.plugin");
        }

        public List<PatternDocument.Pattern> getPatternList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$WfYYCjguTe5LMz_y8TTKkJElQC4(this), new $$Lambda$ceom16MzhuYx3n9yDAyJfXSWY(this), new $$Lambda$fZeOLq2vdj5ugQXLZ6O6o6SV7Q(this), new $$Lambda$s7XlFFTVMKeLyYE21IS8TwzFaNI(this), new $$Lambda$_UF6L_WT_UDKUs3HbZBxRhzNa8(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        public LocalSimpleType getSimpleType() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L9
            LocalSimpleType r3 = (LocalSimpleType) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], 0), LocalSimpleType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
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
            TotalDigitsDocument.TotalDigits r3 = (TotalDigitsDocument.TotalDigits) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[5], r4), TotalDigitsDocument.TotalDigits.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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
            return (TotalDigitsDocument.TotalDigits[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[5], new TotalDigitsDocument.TotalDigits[0]), TotalDigitsDocument.TotalDigits[].class, "com.obric.memorydata.plugin");
        }

        public List<TotalDigitsDocument.TotalDigits> getTotalDigitsList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$LxcStwOWVqeCbFp800RnGoIyzSE(this), new $$Lambda$UAQ8zUkE9r8b7XYLHFll6uI_Oo(this), new $$Lambda$HYYvbnVyjJEwRqQec_iVFjzVkOk(this), new $$Lambda$tgaF3gktzzgEVGKyEJKpGclXhao(this), new $$Lambda$Xw_ENi1QMyVrZBv6fg8jDMwynpk(this));     // Catch: Throwable -> L7
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
            WhiteSpaceDocument.WhiteSpace r3 = (WhiteSpaceDocument.WhiteSpace) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[11], r4), WhiteSpaceDocument.WhiteSpace.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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
            return (WhiteSpaceDocument.WhiteSpace[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[11], new WhiteSpaceDocument.WhiteSpace[0]), WhiteSpaceDocument.WhiteSpace[].class, "com.obric.memorydata.plugin");
        }

        public List<WhiteSpaceDocument.WhiteSpace> getWhiteSpaceList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$CKIUQNrlTx8X3KjYJcFF_Gxhtg(this), new $$Lambda$tsuPdzwHdKVgPfHm_p5BxqnxVYU(this), new $$Lambda$q7305GeFLxPnOh47XabAp8VMCuk(this), new $$Lambda$yPG8LNTg_2B7pjupcRTPX9Ql4pE(this), new $$Lambda$I8re98fiS5E4d6AcQZKQuqb_0w(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        public NoFixedFacet insertNewEnumeration(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            NoFixedFacet r3 = (NoFixedFacet) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[10], r4), NoFixedFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            NumFacet r3 = (NumFacet) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[6], r4), NumFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            NumFacet r3 = (NumFacet) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[7], r4), NumFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            Facet r3 = (Facet) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[3], r4), Facet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            Facet r3 = (Facet) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[4], r4), Facet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            NumFacet r3 = (NumFacet) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[9], r4), NumFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            Facet r3 = (Facet) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[1], r4), Facet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            Facet r3 = (Facet) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[2], r4), Facet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            NumFacet r3 = (NumFacet) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[8], r4), NumFacet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            PatternDocument.Pattern r3 = (PatternDocument.Pattern) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[12], r4), PatternDocument.Pattern.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            TotalDigitsDocument.TotalDigits r3 = (TotalDigitsDocument.TotalDigits) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[5], r4), TotalDigitsDocument.TotalDigits.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            WhiteSpaceDocument.WhiteSpace r3 = (WhiteSpaceDocument.WhiteSpace) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[11], r4), WhiteSpaceDocument.WhiteSpace.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean isSetBase() {
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

        public boolean isSetSimpleType() {
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

        public void removeEnumeration(int r4) {
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

        public void removeFractionDigits(int r4) {
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

        public void removeLength(int r4) {
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

        public void removeMaxExclusive(int r4) {
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

        public void removeMaxInclusive(int r4) {
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

        public void removeMaxLength(int r4) {
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

        public void removeMinExclusive(int r4) {
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

        public void removeMinInclusive(int r4) {
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

        public void removeMinLength(int r4) {
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

        public void removePattern(int r4) {
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

        public void removeTotalDigits(int r4) {
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

        public void removeWhiteSpace(int r4) {
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

        public void setBase(QName r7) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[13]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[13]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.setQNameValue(r7);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void setEnumerationArray(int r3, NoFixedFacet r4) {
            generatedSetterHelperImpl((NoFixedFacet) ZeusTransformUtils.wrapperContextForParams(r4, NoFixedFacet.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[10], r3, 2);
        }

        public void setEnumerationArray(NoFixedFacet[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[10]);
        }

        public void setFractionDigitsArray(int r3, NumFacet r4) {
            generatedSetterHelperImpl((NumFacet) ZeusTransformUtils.wrapperContextForParams(r4, NumFacet.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[6], r3, 2);
        }

        public void setFractionDigitsArray(NumFacet[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[6]);
        }

        public void setLengthArray(int r3, NumFacet r4) {
            generatedSetterHelperImpl((NumFacet) ZeusTransformUtils.wrapperContextForParams(r4, NumFacet.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[7], r3, 2);
        }

        public void setLengthArray(NumFacet[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[7]);
        }

        public void setMaxExclusiveArray(int r3, Facet r4) {
            generatedSetterHelperImpl((Facet) ZeusTransformUtils.wrapperContextForParams(r4, Facet.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[3], r3, 2);
        }

        public void setMaxExclusiveArray(Facet[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[3]);
        }

        public void setMaxInclusiveArray(int r3, Facet r4) {
            generatedSetterHelperImpl((Facet) ZeusTransformUtils.wrapperContextForParams(r4, Facet.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[4], r3, 2);
        }

        public void setMaxInclusiveArray(Facet[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[4]);
        }

        public void setMaxLengthArray(int r3, NumFacet r4) {
            generatedSetterHelperImpl((NumFacet) ZeusTransformUtils.wrapperContextForParams(r4, NumFacet.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[9], r3, 2);
        }

        public void setMaxLengthArray(NumFacet[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[9]);
        }

        public void setMinExclusiveArray(int r3, Facet r4) {
            generatedSetterHelperImpl((Facet) ZeusTransformUtils.wrapperContextForParams(r4, Facet.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[1], r3, 2);
        }

        public void setMinExclusiveArray(Facet[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[1]);
        }

        public void setMinInclusiveArray(int r3, Facet r4) {
            generatedSetterHelperImpl((Facet) ZeusTransformUtils.wrapperContextForParams(r4, Facet.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[2], r3, 2);
        }

        public void setMinInclusiveArray(Facet[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[2]);
        }

        public void setMinLengthArray(int r3, NumFacet r4) {
            generatedSetterHelperImpl((NumFacet) ZeusTransformUtils.wrapperContextForParams(r4, NumFacet.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[8], r3, 2);
        }

        public void setMinLengthArray(NumFacet[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[8]);
        }

        public void setPatternArray(int r3, PatternDocument.Pattern r4) {
            generatedSetterHelperImpl((PatternDocument.Pattern) ZeusTransformUtils.wrapperContextForParams(r4, PatternDocument.Pattern.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[12], r3, 2);
        }

        public void setPatternArray(PatternDocument.Pattern[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[12]);
        }

        public void setSimpleType(LocalSimpleType r4) {
            generatedSetterHelperImpl((LocalSimpleType) ZeusTransformUtils.wrapperContextForParams(r4, LocalSimpleType.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], 0, 1);
        }

        public void setTotalDigitsArray(int r3, TotalDigitsDocument.TotalDigits r4) {
            generatedSetterHelperImpl((TotalDigitsDocument.TotalDigits) ZeusTransformUtils.wrapperContextForParams(r4, TotalDigitsDocument.TotalDigits.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[5], r3, 2);
        }

        public void setTotalDigitsArray(TotalDigitsDocument.TotalDigits[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[5]);
        }

        public void setWhiteSpaceArray(int r3, WhiteSpaceDocument.WhiteSpace r4) {
            generatedSetterHelperImpl((WhiteSpaceDocument.WhiteSpace) ZeusTransformUtils.wrapperContextForParams(r4, WhiteSpaceDocument.WhiteSpace.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[11], r3, 2);
        }

        public void setWhiteSpaceArray(WhiteSpaceDocument.WhiteSpace[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[11]);
        }

        public int sizeOfEnumerationArray() {
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

        public int sizeOfFractionDigitsArray() {
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

        public int sizeOfLengthArray() {
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

        public int sizeOfMaxExclusiveArray() {
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

        public int sizeOfMaxInclusiveArray() {
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

        public int sizeOfMaxLengthArray() {
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

        public int sizeOfMinExclusiveArray() {
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

        public int sizeOfMinInclusiveArray() {
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

        public int sizeOfMinLengthArray() {
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

        public int sizeOfPatternArray() {
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

        public int sizeOfTotalDigitsArray() {
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

        public int sizeOfWhiteSpaceArray() {
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

        public void unsetBase() {
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

        public void unsetSimpleType() {
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

        public XmlQName xgetBase() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            XmlQName r3 = (XmlQName) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[13]), XmlQName.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
            XmlQName r3 = (XmlQName) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[13]), XmlQName.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (XmlQName) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[13]), XmlQName.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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
        PROPERTY_QNAME = new QName[]{new QName("http://www.w3.org/2001/XMLSchema", "restriction")};
    }

    public RestrictionDocumentImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    public RestrictionDocument.Restriction addNewRestriction() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        RestrictionDocument.Restriction r3 = (RestrictionDocument.Restriction) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), RestrictionDocument.Restriction.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public RestrictionDocument.Restriction getRestriction() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        RestrictionDocument.Restriction r3 = (RestrictionDocument.Restriction) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], 0), RestrictionDocument.Restriction.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public void setRestriction(RestrictionDocument.Restriction r4) {
        generatedSetterHelperImpl((RestrictionDocument.Restriction) ZeusTransformUtils.wrapperContextForParams(r4, RestrictionDocument.Restriction.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], 0, 1);
    }
}
