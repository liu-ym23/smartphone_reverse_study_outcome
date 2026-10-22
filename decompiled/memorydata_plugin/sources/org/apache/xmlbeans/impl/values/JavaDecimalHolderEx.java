package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: loaded from: classes7.dex */
public abstract class JavaDecimalHolderEx extends JavaDecimalHolder {
    private final SchemaType _schemaType;

    public JavaDecimalHolderEx(SchemaType r3, boolean r4) {
        this._schemaType = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        initComplexType(r4, false);
    }

    public static void validateLexical(String r3, SchemaType r4, ValidationContext r5) {
        SchemaType r6 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
        ValidationContext r7 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r5, ValidationContext.class, "com.obric.memorydata.plugin");
        JavaDecimalHolder.validateLexical(r3, r7);
        if (r6.hasPatternFacet() == true) goto L5;
        return;
    L5:
        if (r6.matchPatternFacet(r3) == true) goto L9;
        r7.invalid("cvc-datatype-valid.1.1", new Object[]{"decimal", r3, QNameHelper.readable(r6)});
        return;
    }

    public static void validateValue(BigDecimal r16, SchemaType r17, ValidationContext r18) {
        SchemaType r1 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r17, SchemaType.class, "com.obric.memorydata.plugin");
        ValidationContext r3 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r18, ValidationContext.class, "com.obric.memorydata.plugin");
        XmlAnySimpleType r4 = r1.getFacet(8);
        if (r4 == null) goto L9;
        int r5 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r4, XmlObjectBase.class, "com.obric.memorydata.plugin")).getBigIntegerValue().intValue();
        r16.setScale(r5, RoundingMode.UNNECESSARY);     // Catch: ArithmeticException -> L7
    L7:
        r3.invalid("cvc-fractionDigits-valid", new Object[]{Integer.valueOf(r16.scale()), r16.toString(), Integer.valueOf(r5), QNameHelper.readable(r1)});
        return;
    L9:
        XmlAnySimpleType r6 = r1.getFacet(7);
        if (r6 == null) goto L28;
        String r10 = r16.unscaledValue().toString();
        int r7 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r6, XmlObjectBase.class, "com.obric.memorydata.plugin")).getBigIntegerValue().intValue();
        int r11 = r10.length();
        if (r11 > 0) goto L14;
    L24:
        if (r11 <= r7) goto L27;
        r3.invalid("cvc-totalDigits-valid", new Object[]{Integer.valueOf(r11), r16.toString(), Integer.valueOf(r7), QNameHelper.readable(r1)});
        return;
    L27:
        int r8 = 3;
    L29:
        XmlAnySimpleType r9 = r1.getFacet(r8);
        if (r9 == null) goto L35;
        BigDecimal r12 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r9, XmlObjectBase.class, "com.obric.memorydata.plugin")).getBigDecimalValue();
        if (r16.compareTo(r12) > 0) goto L35;
        r3.invalid("cvc-minExclusive-valid", new Object[]{"decimal", r16, r12, QNameHelper.readable(r1)});
        return;
    L35:
        XmlAnySimpleType r13 = r1.getFacet(4);
        if (r13 == null) goto L41;
        BigDecimal r14 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r13, XmlObjectBase.class, "com.obric.memorydata.plugin")).getBigDecimalValue();
        if (r16.compareTo(r14) >= 0) goto L41;
        r3.invalid("cvc-minInclusive-valid", new Object[]{"decimal", r16, r14, QNameHelper.readable(r1)});
        return;
    L41:
        XmlAnySimpleType r15 = r1.getFacet(5);
        if (r15 == null) goto L47;
        BigDecimal r19 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r15, XmlObjectBase.class, "com.obric.memorydata.plugin")).getBigDecimalValue();
        if (r16.compareTo(r19) <= 0) goto L47;
        r3.invalid("cvc-maxInclusive-valid", new Object[]{"decimal", r16, r19, QNameHelper.readable(r1)});
        return;
    L47:
        XmlAnySimpleType r20 = r1.getFacet(6);
        if (r20 == null) goto L53;
        BigDecimal r21 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r20, XmlObjectBase.class, "com.obric.memorydata.plugin")).getBigDecimalValue();
        if (r16.compareTo(r21) < 0) goto L53;
        r3.invalid("cvc-maxExclusive-valid", new Object[]{"decimal", r16, r21, QNameHelper.readable(r1)});
        return;
    L53:
        XmlAnySimpleType[] r22 = r1.getEnumerationValues();
        if (r22 == null) goto L70;
        int r23 = r22.length;
        int r110 = 0;
    L56:
        if (r110 >= r23) goto L61;
        if (r16.compareTo(((XmlObjectBase) ZeusTransformUtils.preCheckCast(r22[r110], XmlObjectBase.class, "com.obric.memorydata.plugin")).getBigDecimalValue()) == 0) goto L59;
        r110 = r110 + 1;
        goto L56
    L59:
        return;
    L61:
        r3.invalid("cvc-enumeration-valid", new Object[]{"decimal", r16, QNameHelper.readable(r1)});
        return;
    L70:
        return;
    L14:
        if (r10.charAt(0) != '-') goto L16;
        int r111 = r11 - 1;
    L17:
        int r112 = r16.scale();
        int r113 = r11 - 1;
        int r114 = 0;
    L19:
        if (r10.charAt(r113) != '0') goto L23;
        if (r113 <= 0) goto L23;
        if (r114 >= r112) goto L23;
        r114 = r114 + 1;
        r113 = r113 - 1;
    L23:
        r11 = r111 - r114;
        goto L24
    L16:
        r111 = r11;
        goto L17
    L28:
        r8 = 3;
        goto L29
    }

    @Override // org.apache.xmlbeans.impl.values.JavaDecimalHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaDecimalHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_BigDecimal(BigDecimal r3) {
        if (_validateOnSet() == false) goto L5;
        validateValue(r3, this._schemaType, _voorVc);
    L5:
        super.set_BigDecimal(r3);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaDecimalHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String r5) {
        if (_validateOnSet() == false) goto L5;
        validateLexical(r5, this._schemaType, _voorVc);
    L5:
        BigDecimal r0 = null;
        r0 = new BigDecimal(r5);     // Catch: NumberFormatException -> L8
    L10:
        if (_validateOnSet() == false) goto L12;
        validateValue(r0, this._schemaType, _voorVc);
    L12:
        super.set_BigDecimal(r0);
        return;
    L8:
        _voorVc.invalid("decimal", new Object[]{r5});
        goto L10
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String r3, ValidationContext r4) {
        ValidationContext r5 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r4, ValidationContext.class, "com.obric.memorydata.plugin");
        validateLexical(r3, schemaType(), r5);
        validateValue(getBigDecimalValue(), schemaType(), r5);
    }
}
