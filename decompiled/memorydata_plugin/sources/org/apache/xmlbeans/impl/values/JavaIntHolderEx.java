package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.util.XsTypeConverter;

/* JADX INFO: loaded from: classes7.dex */
public abstract class JavaIntHolderEx extends JavaIntHolder {
    private final SchemaType _schemaType;

    public JavaIntHolderEx(SchemaType r3, boolean r4) {
        this._schemaType = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        initComplexType(r4, false);
    }

    private static int getIntValue(XmlObject r3) {
        XmlObject r4 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin");
        int r0 = r4.schemaType().getDecimalSize();
        if (r0 == 64) goto L12;
        switch(r0) {
            case 1000000: goto L10;
            case 1000001: goto L8;
            default: goto L6;
        };
    L6:
        return ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r4, XmlObjectBase.class, "com.obric.memorydata.plugin")).getIntValue();
    L8:
        return ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r4, XmlObjectBase.class, "com.obric.memorydata.plugin")).getBigDecimalValue().intValue();
    L10:
        return ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r4, XmlObjectBase.class, "com.obric.memorydata.plugin")).getBigIntegerValue().intValue();
    L12:
        return (int) ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r4, XmlObjectBase.class, "com.obric.memorydata.plugin")).getLongValue();
    }

    public static void validateLexical(String r3, SchemaType r4, ValidationContext r5) {
        SchemaType r6 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
        ValidationContext r7 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r5, ValidationContext.class, "com.obric.memorydata.plugin");
        JavaDecimalHolder.validateLexical(r3, r7);
        if (r6.hasPatternFacet() == true) goto L5;
        return;
    L5:
        if (r6.matchPatternFacet(r3) == true) goto L9;
        r7.invalid("cvc-datatype-valid.1.1", new Object[]{"int", r3, QNameHelper.readable(r6)});
        return;
    }

    private static void validateValue(int r10, SchemaType r11, ValidationContext r12) {
        SchemaType r13 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r11, SchemaType.class, "com.obric.memorydata.plugin");
        ValidationContext r14 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r12, ValidationContext.class, "com.obric.memorydata.plugin");
        XmlAnySimpleType r0 = r13.getFacet(7);
        if (r0 == null) goto L13;
        String r6 = Integer.toString(r10);
        int r7 = r6.length();
        if (r7 <= 0) goto L10;
        if (r6.charAt(0) != '-') goto L10;
        r7 = r7 - 1;
    L10:
        if (r7 <= getIntValue(r0)) goto L13;
        r14.invalid("cvc-totalDigits-valid", new Object[]{Integer.valueOf(r7), r6, Integer.valueOf(getIntValue(r0)), QNameHelper.readable(r13)});
        return;
    L13:
        XmlAnySimpleType r1 = r13.getFacet(3);
        if (r1 == null) goto L19;
        int r2 = getIntValue(r1);
        if (r10 > r2) goto L19;
        r14.invalid("cvc-minExclusive-valid", new Object[]{"int", Integer.valueOf(r10), Integer.valueOf(r2), QNameHelper.readable(r13)});
        return;
    L19:
        XmlAnySimpleType r3 = r13.getFacet(4);
        if (r3 == null) goto L25;
        int r4 = getIntValue(r3);
        if (r10 >= r4) goto L25;
        r14.invalid("cvc-minInclusive-valid", new Object[]{"int", Integer.valueOf(r10), Integer.valueOf(r4), QNameHelper.readable(r13)});
        return;
    L25:
        XmlAnySimpleType r5 = r13.getFacet(5);
        if (r5 == null) goto L31;
        int r8 = getIntValue(r5);
        if (r10 <= r8) goto L31;
        r14.invalid("cvc-maxExclusive-valid", new Object[]{"int", Integer.valueOf(r10), Integer.valueOf(r8), QNameHelper.readable(r13)});
        return;
    L31:
        XmlAnySimpleType r9 = r13.getFacet(6);
        if (r9 == null) goto L37;
        int r15 = getIntValue(r9);
        if (r10 < r15) goto L37;
        r14.invalid("cvc-maxExclusive-valid", new Object[]{"int", Integer.valueOf(r10), Integer.valueOf(r15), QNameHelper.readable(r13)});
        return;
    L37:
        XmlAnySimpleType[] r16 = r13.getEnumerationValues();
        if (r16 == null) goto L49;
        int r17 = r16.length;
        int r18 = 0;
    L40:
        if (r18 >= r17) goto L45;
        if (r10 == getIntValue(r16[r18])) goto L43;
        r18 = r18 + 1;
        goto L40
    L43:
        return;
    L45:
        r14.invalid("cvc-enumeration-valid", new Object[]{"int", Integer.valueOf(r10), QNameHelper.readable(r13)});
        return;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaIntHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaIntHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_int(int r3) {
        if (_validateOnSet() == false) goto L5;
        validateValue(r3, this._schemaType, _voorVc);
    L5:
        super.set_int(r3);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaIntHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String r4) {
        int r0 = XsTypeConverter.lexInt(r4);     // Catch: Exception -> L8
        if (_validateOnSet() == false) goto L6;
        validateValue(r0, this._schemaType, _voorVc);
        validateLexical(r4, this._schemaType, _voorVc);
    L6:
        super.set_int(r0);
        return;
    L9:
        throw new XmlValueOutOfRangeException();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String r3, ValidationContext r4) {
        ValidationContext r5 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r4, ValidationContext.class, "com.obric.memorydata.plugin");
        validateLexical(r3, schemaType(), r5);
        validateValue(getIntValue(), schemaType(), r5);
    }
}
