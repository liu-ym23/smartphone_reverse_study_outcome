package org.apache.xmlbeans.impl.values;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDateSpecification;
import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.GDurationSpecification;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.schema.SchemaTypeImpl;

/* JADX INFO: loaded from: classes7.dex */
public class XmlUnionImpl extends XmlObjectBase implements XmlAnySimpleType {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int JAVA_BYTEARRAY = 50;
    private static final int JAVA_CALENDAR = 49;
    private static final int JAVA_DATE = 48;
    private static final int JAVA_LIST = 51;
    private static final int JAVA_NUMBER = 47;
    private final SchemaType _schemaType;
    private String _textvalue;
    private XmlAnySimpleType _value;

    static {
    }

    public XmlUnionImpl(SchemaType r3, boolean r4) {
        SchemaType r5 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        this._textvalue = "";
        this._schemaType = r5;
        initComplexType(r4, false);
    }

    private static boolean check(XmlObject r5, SchemaType r6) {
        XmlObject r7 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r5, XmlObject.class, "com.obric.memorydata.plugin");
        XmlAnySimpleType[] r8 = ((SchemaType) ZeusTransformUtils.wrapperContextForParams(r6, SchemaType.class, "com.obric.memorydata.plugin")).getEnumerationValues();
        if (r8 == null) goto L11;
        int r1 = r8.length;
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L10;
        if (r8[r3].valueEquals(r7) == true) goto L8;
        r3 = r3 + 1;
        goto L5
    L8:
        return true;
    L10:
        return false;
    L11:
        return true;
    }

    private static boolean logical_overlap(SchemaType r3, int r4) {
        SchemaType r5 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        if (r4 <= 46) goto L5;
        switch(r4) {
            case 47: goto L45;
            case 48: goto L36;
            case 49: goto L29;
            case 50: goto L20;
            case 51: goto L15;
            default: goto L56;
        };
    L56:
        return false;
    L15:
        if (r5.getSimpleVariety() != 3) goto L18;
        return true;
    L18:
        return false;
    L20:
        if (r5.getSimpleVariety() == 1) goto L22;
        return false;
    L22:
        int r6 = r5.getPrimitiveType().getBuiltinTypeCode();
        if (r6 != 4) goto L25;
    L27:
        return true;
    L25:
        if (r6 == 5) goto L27;
        return false;
    L29:
        if (r5.getSimpleVariety() == 1) goto L32;
        return false;
    L32:
        switch(r5.getPrimitiveType().getBuiltinTypeCode()) {
            case 14: goto L34;
            case 15: goto L34;
            case 16: goto L34;
            case 17: goto L34;
            case 18: goto L34;
            case 19: goto L34;
            case 20: goto L34;
            case 21: goto L34;
            default: goto L33;
        };
    L33:
        return false;
    L34:
        return true;
    L36:
        if (r5.getSimpleVariety() == 1) goto L38;
        return false;
    L38:
        int r7 = r5.getPrimitiveType().getBuiltinTypeCode();
        if (r7 != 14) goto L41;
    L43:
        return true;
    L41:
        if (r7 == 16) goto L43;
        return false;
    L45:
        if (r5.getSimpleVariety() == 1) goto L47;
        return false;
    L47:
        int r8 = r5.getPrimitiveType().getBuiltinTypeCode();
        if (r8 != 18) goto L50;
    L55:
        return true;
    L50:
        if (r8 == 20) goto L55;
        if (r8 == 21) goto L55;
        switch(r8) {
            case 9: goto L55;
            case 10: goto L55;
            case 11: goto L55;
            default: goto L54;
        };
    L54:
        return false;
    L5:
        if (r5.getSimpleVariety() == 1) goto L8;
        return false;
    L8:
        if (r5.getPrimitiveType().getBuiltinTypeCode() != r4) goto L11;
        return true;
    L11:
        return false;
    }

    private void set_primitive(int r11, Object r12) {
        SchemaType[] r0 = this._schemaType.getUnionConstituentTypes();
        if (has_store() == false) goto L5;
        NamespaceContext.push(new NamespaceContext(get_store()));
        boolean r1 = true;
    L6:
        boolean r4 = true;
    L7:
        if (r4 == false) goto L33;
    L10:
        int r5 = r0.length;     // Catch: Throwable -> L26
        int r6 = 0;
    L11:
        if (r6 >= r5) goto L20;
        SchemaType r7 = r0[r6];     // Catch: Throwable -> L26
        if (logical_overlap(r7, r11) == false) goto L19;
        XmlAnySimpleType r13 = ((SchemaTypeImpl) ZeusTransformUtils.preCheckCast(r7, SchemaTypeImpl.class, "com.obric.memorydata.plugin")).newValue(r12, r4);     // Catch: Throwable -> L30 Throwable -> L26
        this._value = r13;     // Catch: Throwable -> L26
        this._textvalue = r13.getStringValue();     // Catch: Throwable -> L26
        if (r1 == false) goto L40;
        NamespaceContext.pop();
        return;
    L40:
        return;
    L26:
        th = move-exception;
        if (r1 == false) goto L29;
        NamespaceContext.pop();
    L29:
        throw th;
    L19:
        r6 = r6 + 1;
        goto L11
    L20:
        if (r4 == false) goto L21;
        r4 = false;
    L21:
        if (r1 == false) goto L24;
        NamespaceContext.pop();
    L24:
        throw new XmlValueOutOfRangeException("cvc-datatype-valid.1.2.3", new Object[]{r12.toString(), QNameHelper.readable(this._schemaType)});
    L33:
        if (_validateOnSet() == true) goto L21;
    L5:
        r1 = false;
        goto L6
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager r3) {
        NamespaceManager r4 = (NamespaceManager) ZeusTransformUtils.wrapperContextForParams(r3, NamespaceManager.class, "com.obric.memorydata.plugin");
        return this._textvalue;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject r3) {
        XmlObject r4 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin");
        return this._value.valueEquals(r4);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public BigDecimal getBigDecimalValue() {
        check_dated();
        XmlAnySimpleType r2 = this._value;
        if (r2 != null) goto L6;
        return null;
    L6:
        return ((SimpleValue) ZeusTransformUtils.preCheckCast(r2, SimpleValue.class, "com.obric.memorydata.plugin")).getBigDecimalValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public BigInteger getBigIntegerValue() {
        check_dated();
        XmlAnySimpleType r2 = this._value;
        if (r2 != null) goto L6;
        return null;
    L6:
        return ((SimpleValue) ZeusTransformUtils.preCheckCast(r2, SimpleValue.class, "com.obric.memorydata.plugin")).getBigIntegerValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public boolean getBooleanValue() {
        check_dated();
        XmlAnySimpleType r2 = this._value;
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (((SimpleValue) ZeusTransformUtils.preCheckCast(r2, SimpleValue.class, "com.obric.memorydata.plugin")).getBooleanValue() == false) goto L7;
        return true;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public byte[] getByteArrayValue() {
        check_dated();
        XmlAnySimpleType r2 = this._value;
        if (r2 != null) goto L6;
        return null;
    L6:
        return ((SimpleValue) ZeusTransformUtils.preCheckCast(r2, SimpleValue.class, "com.obric.memorydata.plugin")).getByteArrayValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public byte getByteValue() {
        check_dated();
        XmlAnySimpleType r2 = this._value;
        if (r2 != null) goto L6;
        return 0;
    L6:
        return ((SimpleValue) ZeusTransformUtils.preCheckCast(r2, SimpleValue.class, "com.obric.memorydata.plugin")).getByteValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public Calendar getCalendarValue() {
        check_dated();
        XmlAnySimpleType r2 = this._value;
        if (r2 != null) goto L6;
        return null;
    L6:
        return ((SimpleValue) ZeusTransformUtils.preCheckCast(r2, SimpleValue.class, "com.obric.memorydata.plugin")).getCalendarValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public Date getDateValue() {
        check_dated();
        XmlAnySimpleType r2 = this._value;
        if (r2 != null) goto L6;
        return null;
    L6:
        return ((SimpleValue) ZeusTransformUtils.preCheckCast(r2, SimpleValue.class, "com.obric.memorydata.plugin")).getDateValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public double getDoubleValue() {
        check_dated();
        XmlAnySimpleType r2 = this._value;
        if (r2 != null) goto L6;
        return 0.0d;
    L6:
        return ((SimpleValue) ZeusTransformUtils.preCheckCast(r2, SimpleValue.class, "com.obric.memorydata.plugin")).getDoubleValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public StringEnumAbstractBase getEnumValue() {
        check_dated();
        XmlAnySimpleType r2 = this._value;
        if (r2 != null) goto L6;
        return null;
    L6:
        return ((SimpleValue) ZeusTransformUtils.preCheckCast(r2, SimpleValue.class, "com.obric.memorydata.plugin")).getEnumValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public float getFloatValue() {
        check_dated();
        XmlAnySimpleType r2 = this._value;
        if (r2 != null) goto L6;
        return 0.0f;
    L6:
        return ((SimpleValue) ZeusTransformUtils.preCheckCast(r2, SimpleValue.class, "com.obric.memorydata.plugin")).getFloatValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public GDate getGDateValue() {
        check_dated();
        XmlAnySimpleType r2 = this._value;
        if (r2 != null) goto L6;
        return null;
    L6:
        return ((SimpleValue) ZeusTransformUtils.preCheckCast(r2, SimpleValue.class, "com.obric.memorydata.plugin")).getGDateValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public GDuration getGDurationValue() {
        check_dated();
        XmlAnySimpleType r2 = this._value;
        if (r2 != null) goto L6;
        return null;
    L6:
        return ((SimpleValue) ZeusTransformUtils.preCheckCast(r2, SimpleValue.class, "com.obric.memorydata.plugin")).getGDurationValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public int getIntValue() {
        check_dated();
        XmlAnySimpleType r2 = this._value;
        if (r2 != null) goto L6;
        return 0;
    L6:
        return ((SimpleValue) ZeusTransformUtils.preCheckCast(r2, SimpleValue.class, "com.obric.memorydata.plugin")).getIntValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public List<?> getListValue() {
        check_dated();
        XmlAnySimpleType r2 = this._value;
        if (r2 != null) goto L6;
        return null;
    L6:
        return ((SimpleValue) ZeusTransformUtils.preCheckCast(r2, SimpleValue.class, "com.obric.memorydata.plugin")).getListValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public long getLongValue() {
        check_dated();
        XmlAnySimpleType r2 = this._value;
        if (r2 != null) goto L6;
        return 0;
    L6:
        return ((SimpleValue) ZeusTransformUtils.preCheckCast(r2, SimpleValue.class, "com.obric.memorydata.plugin")).getLongValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public QName getQNameValue() {
        check_dated();
        XmlAnySimpleType r2 = this._value;
        if (r2 != null) goto L6;
        return null;
    L6:
        return ((SimpleValue) ZeusTransformUtils.preCheckCast(r2, SimpleValue.class, "com.obric.memorydata.plugin")).getQNameValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public short getShortValue() {
        check_dated();
        XmlAnySimpleType r2 = this._value;
        if (r2 != null) goto L6;
        return 0;
    L6:
        return ((SimpleValue) ZeusTransformUtils.preCheckCast(r2, SimpleValue.class, "com.obric.memorydata.plugin")).getShortValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public String getStringValue() {
        check_dated();
        XmlAnySimpleType r0 = this._value;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getStringValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int get_wscanon_rule() {
        return 1;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public SchemaType instanceType() {
        check_dated();
        XmlAnySimpleType r2 = this._value;
        if (r2 != null) goto L6;
        return null;
    L6:
        return ((SimpleValue) ZeusTransformUtils.preCheckCast(r2, SimpleValue.class, "com.obric.memorydata.plugin")).instanceType();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean is_defaultable_ws(String r2) {
        XmlAnySimpleType r0 = this._value;     // Catch: XmlValueOutOfRangeException -> L5
        set_text(r2);     // Catch: XmlValueOutOfRangeException -> L5
        this._value = r0;     // Catch: XmlValueOutOfRangeException -> L5
        return false;
    L5:
        return true;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_BigDecimal(BigDecimal r2) {
        set_primitive(47, r2);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_BigInteger(BigInteger r2) {
        set_primitive(47, r2);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_ByteArray(byte[] r2) {
        set_primitive(50, r2);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_Calendar(Calendar r2) {
        set_primitive(49, r2);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_Date(Date r2) {
        set_primitive(48, r2);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_GDate(GDateSpecification r3) {
        GDateSpecification r4 = (GDateSpecification) ZeusTransformUtils.wrapperContextForParams(r3, GDateSpecification.class, "com.obric.memorydata.plugin");
        int r0 = r4.getBuiltinTypeCode();
        if (r0 <= 0) goto L7;
        set_primitive(r0, r4);
        return;
    L7:
        throw new XmlValueOutOfRangeException();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_GDuration(GDurationSpecification r3) {
        set_primitive(13, (GDurationSpecification) ZeusTransformUtils.wrapperContextForParams(r3, GDurationSpecification.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_QName(QName r2) {
        set_primitive(7, r2);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_b64(byte[] r2) {
        set_primitive(50, r2);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_boolean(boolean r2) {
        set_primitive(3, Boolean.valueOf(r2));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_byte(byte r2) {
        set_primitive(47, Byte.valueOf(r2));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_double(double r1) {
        set_primitive(47, Double.valueOf(r1));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_enum(StringEnumAbstractBase r2) {
        set_primitive(12, r2);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_float(float r2) {
        set_primitive(47, Float.valueOf(r2));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_hex(byte[] r2) {
        set_primitive(50, r2);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_int(int r2) {
        set_primitive(47, Integer.valueOf(r2));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_list(List<?> r3) {
        set_primitive(51, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_long(long r1) {
        set_primitive(47, Long.valueOf(r1));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
        this._value = null;
        this._textvalue = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_short(short r2) {
        set_primitive(47, Short.valueOf(r2));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String r13) {
        if (this._schemaType.matchPatternFacet(r13) == false) goto L5;
    L9:
        String r0 = this._textvalue;
        this._textvalue = r13;
        SchemaType[] r4 = this._schemaType.getUnionConstituentTypes();
        if (has_store() == false) goto L12;
        NamespaceContext.push(new NamespaceContext(get_store()));
        boolean r5 = true;
    L13:
        boolean r6 = true;
    L14:
        if (r6 == false) goto L42;
    L17:
        int r7 = r4.length;     // Catch: Throwable -> L37
        int r8 = 0;
    L18:
        if (r8 >= r7) goto L31;
        XmlAnySimpleType r9 = ((SchemaTypeImpl) ZeusTransformUtils.preCheckCast(r4[r8], SchemaTypeImpl.class, "com.obric.memorydata.plugin")).newValue(r13, r6);     // Catch: Exception -> L27 XmlValueOutOfRangeException -> L41 Throwable -> L37
        if (check(r9, this._schemaType) == false) goto L30;
        this._value = r9;     // Catch: Exception -> L27 XmlValueOutOfRangeException -> L41 Throwable -> L37
        goto L30
    L24:
        if (r5 == false) goto L50;
        NamespaceContext.pop();
        return;
    L50:
        return;
    L27:
        e = move-exception;
        throw new RuntimeException("Troublesome union exception caused by unexpected " + e, e);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        if (r5 == false) goto L40;
        NamespaceContext.pop();
    L40:
        throw th;
    L30:
        r8 = r8 + 1;
        goto L18
    L31:
        if (r6 == false) goto L32;
        r6 = false;
    L32:
        if (r5 == false) goto L34;
        NamespaceContext.pop();
    L34:
        this._textvalue = r0;
        throw new XmlValueOutOfRangeException("cvc-datatype-valid.1.2.3", new Object[]{r13, QNameHelper.readable(this._schemaType)});
    L42:
        if (_validateOnSet() == true) goto L32;
    L12:
        r5 = false;
        goto L13
    L5:
        if (_validateOnSet() == false) goto L9;
        throw new XmlValueOutOfRangeException("cvc-datatype-valid.1.1", new Object[]{TypedValues.Custom.S_STRING, r13, QNameHelper.readable(this._schemaType)});
    }

    public void set_xmldate(XmlObject r3) {
        set_primitive(16, (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin"));
    }

    public void set_xmldatetime(XmlObject r3) {
        set_primitive(14, (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin"));
    }

    public void set_xmldecimal(XmlObject r3) {
        set_primitive(11, (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin"));
    }

    public void set_xmldouble(XmlObject r3) {
        set_primitive(10, (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin"));
    }

    public void set_xmlduration(XmlObject r3) {
        set_primitive(13, (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin"));
    }

    public void set_xmlfloat(XmlObject r3) {
        set_primitive(9, (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin"));
    }

    public void set_xmlgday(XmlObject r3) {
        set_primitive(20, (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin"));
    }

    public void set_xmlgmonth(XmlObject r3) {
        set_primitive(21, (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin"));
    }

    public void set_xmlgmonthday(XmlObject r3) {
        set_primitive(19, (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin"));
    }

    public void set_xmlgyear(XmlObject r3) {
        set_primitive(18, (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin"));
    }

    public void set_xmlgyearmonth(XmlObject r3) {
        set_primitive(17, (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin"));
    }

    public void set_xmltime(XmlObject r3) {
        set_primitive(15, (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String r8, ValidationContext r9) {
        ValidationContext r10 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r9, ValidationContext.class, "com.obric.memorydata.plugin");
        check_dated();     // Catch: Exception -> L10
        XmlAnySimpleType r6 = this._value;
        if (r6 != null) goto L8;
        r10.invalid("union", new Object[]{"'" + r8 + "' does not match any of the member types for " + QNameHelper.readable(schemaType())});
        return;
    L8:
        ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r6, XmlObjectBase.class, "com.obric.memorydata.plugin")).validate_simpleval(r8, r10);
        return;
    L10:
        r10.invalid("union", new Object[]{"'" + r8 + "' does not match any of the member types for " + QNameHelper.readable(schemaType())});
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int value_hash_code() {
        return this._value.hashCode();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public List<? extends XmlAnySimpleType> xgetListValue() {
        check_dated();
        XmlAnySimpleType r2 = this._value;
        if (r2 != null) goto L6;
        return null;
    L6:
        return ((SimpleValue) ZeusTransformUtils.preCheckCast(r2, SimpleValue.class, "com.obric.memorydata.plugin")).xgetListValue();
    }
}
