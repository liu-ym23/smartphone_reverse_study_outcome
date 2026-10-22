package org.apache.xmlbeans.impl.values;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlPositiveInteger;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: loaded from: classes7.dex */
public class JavaIntegerHolderEx extends JavaIntegerHolder {
    private final SchemaType _schemaType;

    public JavaIntegerHolderEx(SchemaType r3, boolean r4) {
        this._schemaType = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        initComplexType(r4, false);
    }

    private static BigInteger getBigIntegerValue(XmlObject r3) {
        XmlObject r4 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin");
        SchemaType r0 = r4.schemaType();
        switch(r0.getDecimalSize()) {
            case 1000000: goto L9;
            case 1000001: goto L7;
            default: goto L5;
        };
    L5:
        throw new IllegalStateException("Bad facet type for Big Int: " + r0);
    L7:
        return ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r4, XmlObjectBase.class, "com.obric.memorydata.plugin")).getBigDecimalValue().toBigInteger();
    L9:
        return ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r4, XmlObjectBase.class, "com.obric.memorydata.plugin")).getBigIntegerValue();
    }

    public static void validateLexical(String r4, SchemaType r5, ValidationContext r6) {
        SchemaType r7 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r5, SchemaType.class, "com.obric.memorydata.plugin");
        ValidationContext r8 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r6, ValidationContext.class, "com.obric.memorydata.plugin");
        JavaDecimalHolder.validateLexical(r4, r8);
        if (r4.lastIndexOf(46) < 0) goto L6;
        r8.invalid(TypedValues.Custom.S_INT, new Object[]{r4});
    L6:
        if (r7.hasPatternFacet() == true) goto L8;
        return;
    L8:
        if (r7.matchPatternFacet(r4) == true) goto L12;
        r8.invalid("cvc-datatype-valid.1.1", new Object[]{TypedValues.Custom.S_INT, r4, QNameHelper.readable(r7)});
        return;
    }

    private static void validateValue(BigInteger r10, SchemaType r11, ValidationContext r12) {
        SchemaType r13 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r11, SchemaType.class, "com.obric.memorydata.plugin");
        ValidationContext r14 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r12, ValidationContext.class, "com.obric.memorydata.plugin");
        XmlPositiveInteger r0 = (XmlPositiveInteger) ZeusTransformUtils.preCheckCast(r13.getFacet(7), XmlPositiveInteger.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L13;
        String r6 = r10.toString();
        int r7 = r6.length();
        if (r7 <= 0) goto L10;
        if (r6.charAt(0) != '-') goto L10;
        r7 = r7 - 1;
    L10:
        if (r7 <= r0.getBigIntegerValue().intValue()) goto L13;
        r14.invalid("cvc-totalDigits-valid", new Object[]{Integer.valueOf(r7), r6, Integer.valueOf(r0.getBigIntegerValue().intValue()), QNameHelper.readable(r13)});
        return;
    L13:
        XmlAnySimpleType r1 = r13.getFacet(3);
        if (r1 == null) goto L19;
        BigInteger r2 = getBigIntegerValue(r1);
        if (r10.compareTo(r2) > 0) goto L19;
        r14.invalid("cvc-minExclusive-valid", new Object[]{TypedValues.Custom.S_INT, r10, r2, QNameHelper.readable(r13)});
        return;
    L19:
        XmlAnySimpleType r3 = r13.getFacet(4);
        if (r3 == null) goto L25;
        BigInteger r4 = getBigIntegerValue(r3);
        if (r10.compareTo(r4) >= 0) goto L25;
        r14.invalid("cvc-minInclusive-valid", new Object[]{TypedValues.Custom.S_INT, r10, r4, QNameHelper.readable(r13)});
        return;
    L25:
        XmlAnySimpleType r5 = r13.getFacet(5);
        if (r5 == null) goto L31;
        BigInteger r8 = getBigIntegerValue(r5);
        if (r10.compareTo(r8) <= 0) goto L31;
        r14.invalid("cvc-maxInclusive-valid", new Object[]{TypedValues.Custom.S_INT, r10, r8, QNameHelper.readable(r13)});
        return;
    L31:
        XmlAnySimpleType r9 = r13.getFacet(6);
        if (r9 == null) goto L37;
        BigInteger r15 = getBigIntegerValue(r9);
        if (r10.compareTo(r15) < 0) goto L37;
        r14.invalid("cvc-maxExclusive-valid", new Object[]{TypedValues.Custom.S_INT, r10, r15, QNameHelper.readable(r13)});
        return;
    L37:
        XmlAnySimpleType[] r16 = r13.getEnumerationValues();
        if (r16 == null) goto L49;
        int r17 = r16.length;
        int r18 = 0;
    L40:
        if (r18 >= r17) goto L45;
        if (r10.equals(getBigIntegerValue(r16[r18])) == true) goto L43;
        r18 = r18 + 1;
        goto L40
    L43:
        return;
    L45:
        r14.invalid("cvc-enumeration-valid", new Object[]{TypedValues.Custom.S_INT, r10, QNameHelper.readable(r13)});
        return;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaIntegerHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaIntegerHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_BigInteger(BigInteger r3) {
        if (_validateOnSet() == false) goto L5;
        validateValue(r3, this._schemaType, _voorVc);
    L5:
        super.set_BigInteger(r3);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaIntegerHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String r4) {
        BigInteger r0 = lex(r4, _voorVc);
        if (_validateOnSet() == false) goto L6;
        validateValue(r0, this._schemaType, _voorVc);
    L6:
        if (_validateOnSet() == false) goto L8;
        validateLexical(r4, this._schemaType, _voorVc);
    L8:
        super.set_BigInteger(r0);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String r3, ValidationContext r4) {
        ValidationContext r5 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r4, ValidationContext.class, "com.obric.memorydata.plugin");
        validateLexical(r3, schemaType(), r5);
        validateValue(getBigIntegerValue(), schemaType(), r5);
    }
}
