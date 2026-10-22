package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.util.XsTypeConverter;

/* JADX INFO: loaded from: classes7.dex */
public abstract class JavaLongHolderEx extends JavaLongHolder {
    private final SchemaType _schemaType;

    public JavaLongHolderEx(SchemaType r3, boolean r4) {
        this._schemaType = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        initComplexType(r4, false);
    }

    private static long getLongValue(XmlObject r4) {
        XmlObject r5 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r4, XmlObject.class, "com.obric.memorydata.plugin");
        SchemaType r0 = r5.schemaType();
        int r2 = r0.getDecimalSize();
        if (r2 == 64) goto L12;
        switch(r2) {
            case 1000000: goto L10;
            case 1000001: goto L8;
            default: goto L6;
        };
    L6:
        throw new IllegalStateException("Bad facet type: " + r0);
    L8:
        return ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r5, XmlObjectBase.class, "com.obric.memorydata.plugin")).getBigDecimalValue().longValue();
    L10:
        return ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r5, XmlObjectBase.class, "com.obric.memorydata.plugin")).getBigIntegerValue().longValue();
    L12:
        return ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r5, XmlObjectBase.class, "com.obric.memorydata.plugin")).getLongValue();
    }

    public static void validateLexical(String r3, SchemaType r4, ValidationContext r5) {
        SchemaType r6 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
        ValidationContext r7 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r5, ValidationContext.class, "com.obric.memorydata.plugin");
        JavaDecimalHolder.validateLexical(r3, r7);
        if (r6.hasPatternFacet() == true) goto L5;
        return;
    L5:
        if (r6.matchPatternFacet(r3) == true) goto L9;
        r7.invalid("cvc-datatype-valid.1.1", new Object[]{"long", r3, QNameHelper.readable(r6)});
        return;
    }

    private static void validateValue(long r11, SchemaType r13, ValidationContext r14) {
        SchemaType r15 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r13, SchemaType.class, "com.obric.memorydata.plugin");
        ValidationContext r16 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r14, ValidationContext.class, "com.obric.memorydata.plugin");
        XmlAnySimpleType r0 = r15.getFacet(7);
        if (r0 == null) goto L13;
        long r6 = getLongValue(r0);
        String r1 = Long.toString(r11);
        int r8 = r1.length();
        if (r8 <= 0) goto L10;
        if (r1.charAt(0) != '-') goto L10;
        r8 = r8 - 1;
    L10:
        if (r8 <= r6) goto L13;
        r16.invalid("cvc-totalDigits-valid", new Object[]{Integer.valueOf(r8), r1, Long.valueOf(r6), QNameHelper.readable(r15)});
        return;
    L13:
        XmlAnySimpleType r2 = r15.getFacet(3);
        if (r2 == null) goto L19;
        long r7 = getLongValue(r2);
        if (r11 > r7) goto L19;
        r16.invalid("cvc-minExclusive-valid", new Object[]{"long", Long.valueOf(r11), Long.valueOf(r7), QNameHelper.readable(r15)});
        return;
    L19:
        XmlAnySimpleType r3 = r15.getFacet(4);
        if (r3 == null) goto L25;
        long r9 = getLongValue(r3);
        if (r11 >= r9) goto L25;
        r16.invalid("cvc-minInclusive-valid", new Object[]{"long", Long.valueOf(r11), Long.valueOf(r9), QNameHelper.readable(r15)});
        return;
    L25:
        XmlAnySimpleType r4 = r15.getFacet(5);
        if (r4 == null) goto L31;
        long r10 = getLongValue(r4);
        if (r11 <= r10) goto L31;
        r16.invalid("cvc-maxInclusive-valid", new Object[]{"long", Long.valueOf(r11), Long.valueOf(r10), QNameHelper.readable(r15)});
        return;
    L31:
        XmlAnySimpleType r5 = r15.getFacet(6);
        if (r5 == null) goto L37;
        long r12 = getLongValue(r5);
        if (r11 < r12) goto L37;
        r16.invalid("cvc-maxExclusive-valid", new Object[]{"long", Long.valueOf(r11), Long.valueOf(r12), QNameHelper.readable(r15)});
        return;
    L37:
        XmlAnySimpleType[] r17 = r15.getEnumerationValues();
        if (r17 == null) goto L49;
        int r18 = r17.length;
        int r19 = 0;
    L40:
        if (r19 >= r18) goto L45;
        if (r11 == getLongValue(r17[r19])) goto L43;
        r19 = r19 + 1;
        goto L40
    L43:
        return;
    L45:
        r16.invalid("cvc-enumeration-valid", new Object[]{"long", Long.valueOf(r11), QNameHelper.readable(r15)});
        return;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaLongHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaLongHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_long(long r3) {
        if (_validateOnSet() == false) goto L5;
        validateValue(r3, this._schemaType, _voorVc);
    L5:
        super.set_long(r3);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaLongHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String r5) {
        long r0 = XsTypeConverter.lexLong(r5);     // Catch: Exception -> L8
        if (_validateOnSet() == false) goto L6;
        validateValue(r0, this._schemaType, _voorVc);
        validateLexical(r5, this._schemaType, _voorVc);
    L6:
        super.set_long(r0);
        return;
    L9:
        throw new XmlValueOutOfRangeException();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String r3, ValidationContext r4) {
        ValidationContext r5 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r4, ValidationContext.class, "com.obric.memorydata.plugin");
        validateLexical(r3, schemaType(), r5);
        validateValue(getLongValue(), schemaType(), r5);
    }
}
