package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Calendar;
import java.util.Date;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDateBuilder;
import org.apache.xmlbeans.GDateSpecification;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: loaded from: classes7.dex */
public abstract class JavaGDateHolderEx extends XmlObjectBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final SchemaType _schemaType;
    private GDate _value;

    static {
    }

    public JavaGDateHolderEx(SchemaType r3, boolean r4) {
        this._schemaType = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        initComplexType(r4, false);
    }

    public static GDate lex(String r6, SchemaType r7, ValidationContext r8) {
        SchemaType r9 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r7, SchemaType.class, "com.obric.memorydata.plugin");
        ValidationContext r10 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r8, ValidationContext.class, "com.obric.memorydata.plugin");
        GDate r4 = new GDate(r6);     // Catch: Exception -> L5
    L6:
        if (r4 == null) goto L14;
        if (r4.getBuiltinTypeCode() == r9.getPrimitiveType().getBuiltinTypeCode()) goto L11;
        r10.invalid("date", new Object[]{"wrong type: " + r6});
        return null;
    L11:
        if (r4.isValid() == true) goto L14;
        r10.invalid("date", new Object[]{r6});
        return null;
    L14:
        return r4;
    L5:
        r10.invalid("date", new Object[]{r6});
        r4 = null;
        goto L6
    }

    public static GDate validateLexical(String r4, SchemaType r5, ValidationContext r6) {
        SchemaType r7 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r5, SchemaType.class, "com.obric.memorydata.plugin");
        ValidationContext r8 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r6, ValidationContext.class, "com.obric.memorydata.plugin");
        GDate r0 = lex(r4, r7, r8);
        if (r0 != null) goto L5;
    L9:
        return r0;
    L5:
        if (r7.hasPatternFacet() == false) goto L9;
        if (r7.matchPatternFacet(r4) == true) goto L9;
        r8.invalid("cvc-datatype-valid.1.1", new Object[]{"date", r4, QNameHelper.readable(r7)});
        goto L9
    }

    public static void validateValue(GDateSpecification r11, SchemaType r12, ValidationContext r13) {
        GDateSpecification r14 = (GDateSpecification) ZeusTransformUtils.wrapperContextForParams(r11, GDateSpecification.class, "com.obric.memorydata.plugin");
        SchemaType r15 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r12, SchemaType.class, "com.obric.memorydata.plugin");
        ValidationContext r16 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r13, ValidationContext.class, "com.obric.memorydata.plugin");
        if (r14.getBuiltinTypeCode() == r15.getPrimitiveType().getBuiltinTypeCode()) goto L5;
        r16.invalid("date", new Object[]{"Date (" + r14 + ") does not have the set of fields required for " + QNameHelper.readable(r15)});
    L5:
        XmlAnySimpleType r2 = r15.getFacet(3);
        if (r2 == null) goto L10;
        GDate r3 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r2, XmlObjectBase.class, "com.obric.memorydata.plugin")).getGDateValue();
        if (r14.compareToGDate(r3) > 0) goto L10;
        r16.invalid("cvc-minExclusive-valid", new Object[]{"date", r14, r3, QNameHelper.readable(r15)});
    L10:
        XmlAnySimpleType r4 = r15.getFacet(4);
        if (r4 == null) goto L15;
        GDate r5 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r4, XmlObjectBase.class, "com.obric.memorydata.plugin")).getGDateValue();
        if (r14.compareToGDate(r5) >= 0) goto L15;
        r16.invalid("cvc-minInclusive-valid", new Object[]{"date", r14, r5, QNameHelper.readable(r15)});
    L15:
        XmlAnySimpleType r6 = r15.getFacet(6);
        if (r6 == null) goto L20;
        GDate r7 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r6, XmlObjectBase.class, "com.obric.memorydata.plugin")).getGDateValue();
        if (r14.compareToGDate(r7) < 0) goto L20;
        r16.invalid("cvc-maxExclusive-valid", new Object[]{"date", r14, r7, QNameHelper.readable(r15)});
    L20:
        XmlAnySimpleType r8 = r15.getFacet(5);
        if (r8 == null) goto L25;
        GDate r9 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r8, XmlObjectBase.class, "com.obric.memorydata.plugin")).getGDateValue();
        if (r14.compareToGDate(r9) <= 0) goto L25;
        r16.invalid("cvc-maxInclusive-valid", new Object[]{"date", r14, r9, QNameHelper.readable(r15)});
    L25:
        XmlAnySimpleType[] r10 = r15.getEnumerationValues();
        if (r10 == null) goto L37;
        int r17 = r10.length;
        int r18 = 0;
    L28:
        if (r18 >= r17) goto L33;
        if (r14.compareToGDate(((XmlObjectBase) ZeusTransformUtils.preCheckCast(r10[r18], XmlObjectBase.class, "com.obric.memorydata.plugin")).getGDateValue()) == 0) goto L31;
        r18 = r18 + 1;
        goto L28
    L31:
        return;
    L33:
        r16.invalid("cvc-enumeration-valid", new Object[]{"date", r14, QNameHelper.readable(r15)});
        return;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int compare_to(XmlObject r3) {
        XmlObject r4 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin");
        return this._value.compareToGDate(((XmlObjectBase) ZeusTransformUtils.preCheckCast(r4, XmlObjectBase.class, "com.obric.memorydata.plugin")).getGDateValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager r3) {
        NamespaceManager r4 = (NamespaceManager) ZeusTransformUtils.wrapperContextForParams(r3, NamespaceManager.class, "com.obric.memorydata.plugin");
        GDate r2 = this._value;
        if (r2 != null) goto L6;
        return "";
    L6:
        return r2.toString();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject r3) {
        XmlObject r4 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin");
        return this._value.equals(((XmlObjectBase) ZeusTransformUtils.preCheckCast(r4, XmlObjectBase.class, "com.obric.memorydata.plugin")).getGDateValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public Calendar getCalendarValue() {
        check_dated();
        GDate r0 = this._value;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCalendar();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public Date getDateValue() {
        check_dated();
        GDate r0 = this._value;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDate();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public GDate getGDateValue() {
        check_dated();
        GDate r0 = this._value;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public int getIntValue() {
        int r0 = schemaType().getPrimitiveType().getBuiltinTypeCode();
        if (r0 == 20) goto L9;
        if (r0 == 21) goto L9;
        if (r0 == 18) goto L9;
        throw new XmlValueOutOfRangeException();
    L9:
        check_dated();
        GDate r4 = this._value;
        if (r4 != null) goto L13;
        return 0;
    L13:
        if (r0 == 18) goto L23;
        if (r0 == 20) goto L21;
        if (r0 != 21) goto L19;
        return r4.getMonth();
    L19:
        throw new IllegalStateException();
    L21:
        return r4.getDay();
    L23:
        return r4.getYear();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_Calendar(Calendar r3) {
        int r0 = schemaType().getPrimitiveType().getBuiltinTypeCode();
        GDateBuilder r1 = new GDateBuilder(r3);
        r1.setBuiltinTypeCode(r0);
        GDate r4 = r1.toGDate();
        if (_validateOnSet() == false) goto L5;
        validateValue(r4, this._schemaType, _voorVc);
    L5:
        this._value = r4;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_Date(Date r3) {
        int r0 = schemaType().getPrimitiveType().getBuiltinTypeCode();
        if (r0 != 16) goto L5;
    L6:
        if (r3 == null) goto L13;
        GDateBuilder r1 = new GDateBuilder(r3);
        r1.setBuiltinTypeCode(r0);
        GDate r4 = r1.toGDate();
        if (_validateOnSet() == false) goto L10;
        validateValue(r4, this._schemaType, _voorVc);
    L10:
        this._value = r4;
        return;
    L13:
        throw new XmlValueOutOfRangeException();
    L5:
        if (r0 != 14) goto L13;
        goto L6
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_GDate(GDateSpecification r4) {
        GDateSpecification r5 = (GDateSpecification) ZeusTransformUtils.wrapperContextForParams(r4, GDateSpecification.class, "com.obric.memorydata.plugin");
        int r0 = schemaType().getPrimitiveType().getBuiltinTypeCode();
        if (r5.isImmutable() == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r5, GDate.class) == false) goto L10;
        if (r5.getBuiltinTypeCode() != r0) goto L10;
        GDate r6 = (GDate) ZeusTransformUtils.preCheckCast(r5, GDate.class, "com.obric.memorydata.plugin");
    L14:
        if (_validateOnSet() == false) goto L16;
        validateValue(r6, this._schemaType, _voorVc);
    L16:
        this._value = r6;
        return;
    L10:
        if (r5.getBuiltinTypeCode() == r0) goto L12;
        GDateBuilder r1 = new GDateBuilder(r5);
        r1.setBuiltinTypeCode(r0);
        r5 = r1;
    L12:
        r6 = new GDate(r5);
        goto L14
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_int(int r6) {
        int r0 = schemaType().getPrimitiveType().getBuiltinTypeCode();
        if (r0 == 20) goto L9;
        if (r0 == 21) goto L9;
        if (r0 == 18) goto L9;
        throw new XmlValueOutOfRangeException();
    L9:
        GDateBuilder r4 = new GDateBuilder();
        if (r0 == 18) goto L16;
        if (r0 == 20) goto L15;
        if (r0 != 21) goto L18;
        r4.setMonth(r6);
    L18:
        if (_validateOnSet() == false) goto L20;
        validateValue(r4, this._schemaType, _voorVc);
    L20:
        this._value = r4.toGDate();
        return;
    L15:
        r4.setDay(r6);
        goto L18
    L16:
        r4.setYear(r6);
        goto L18
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
        this._value = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String r3) {
        if (_validateOnSet() == false) goto L5;
        GDate r4 = validateLexical(r3, this._schemaType, _voorVc);
    L7:
        if (_validateOnSet() == false) goto L10;
        if (r4 == null) goto L10;
        validateValue(r4, this._schemaType, _voorVc);
    L10:
        this._value = r4;
        return;
    L5:
        r4 = lex(r3, this._schemaType, _voorVc);
        goto L7
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String r3, ValidationContext r4) {
        ValidationContext r5 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r4, ValidationContext.class, "com.obric.memorydata.plugin");
        validateLexical(r3, schemaType(), r5);
        validateValue(getGDateValue(), schemaType(), r5);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int value_hash_code() {
        return this._value.hashCode();
    }
}
