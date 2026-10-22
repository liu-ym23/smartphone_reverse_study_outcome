package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: loaded from: classes7.dex */
public abstract class JavaDoubleHolderEx extends JavaDoubleHolder {
    private final SchemaType _schemaType;

    public JavaDoubleHolderEx(SchemaType r3, boolean r4) {
        this._schemaType = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        initComplexType(r4, false);
    }

    public static double validateLexical(String r5, SchemaType r6, ValidationContext r7) {
        SchemaType r8 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r6, SchemaType.class, "com.obric.memorydata.plugin");
        ValidationContext r9 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r7, ValidationContext.class, "com.obric.memorydata.plugin");
        double r0 = JavaDoubleHolder.validateLexical(r5, r9);
        if (r8.matchPatternFacet(r5) == true) goto L5;
        r9.invalid("cvc-datatype-valid.1.1", new Object[]{"double", r5, QNameHelper.readable(r8)});
    L5:
        return r0;
    }

    public static void validateValue(double r11, SchemaType r13, ValidationContext r14) {
        SchemaType r15 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r13, SchemaType.class, "com.obric.memorydata.plugin");
        ValidationContext r16 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r14, ValidationContext.class, "com.obric.memorydata.plugin");
        XmlAnySimpleType r2 = r15.getFacet(3);
        if (r2 == null) goto L7;
        double r8 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r2, XmlObjectBase.class, "com.obric.memorydata.plugin")).getDoubleValue();
        if (compare(r11, r8) > 0) goto L7;
        r16.invalid("cvc-minExclusive-valid", new Object[]{"double", Double.valueOf(r11), Double.valueOf(r8), QNameHelper.readable(r15)});
    L7:
        XmlAnySimpleType r3 = r15.getFacet(4);
        if (r3 == null) goto L12;
        double r9 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r3, XmlObjectBase.class, "com.obric.memorydata.plugin")).getDoubleValue();
        if (compare(r11, r9) >= 0) goto L12;
        r16.invalid("cvc-minInclusive-valid", new Object[]{"double", Double.valueOf(r11), Double.valueOf(r9), QNameHelper.readable(r15)});
    L12:
        XmlAnySimpleType r4 = r15.getFacet(5);
        if (r4 == null) goto L17;
        double r10 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r4, XmlObjectBase.class, "com.obric.memorydata.plugin")).getDoubleValue();
        if (compare(r11, r10) <= 0) goto L17;
        r16.invalid("cvc-maxInclusive-valid", new Object[]{"double", Double.valueOf(r11), Double.valueOf(r10), QNameHelper.readable(r15)});
    L17:
        XmlAnySimpleType r5 = r15.getFacet(6);
        if (r5 == null) goto L22;
        double r12 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r5, XmlObjectBase.class, "com.obric.memorydata.plugin")).getDoubleValue();
        if (compare(r11, r12) < 0) goto L22;
        r16.invalid("cvc-maxExclusive-valid", new Object[]{"double", Double.valueOf(r11), Double.valueOf(r12), QNameHelper.readable(r15)});
    L22:
        XmlAnySimpleType[] r6 = r15.getEnumerationValues();
        if (r6 == null) goto L34;
        int r7 = r6.length;
        int r17 = 0;
    L25:
        if (r17 >= r7) goto L30;
        if (compare(r11, ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r6[r17], XmlObjectBase.class, "com.obric.memorydata.plugin")).getDoubleValue()) == 0) goto L28;
        r17 = r17 + 1;
        goto L25
    L28:
        return;
    L30:
        r16.invalid("cvc-enumeration-valid", new Object[]{"double", Double.valueOf(r11), QNameHelper.readable(r15)});
        return;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaDoubleHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaDoubleHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_double(double r3) {
        if (_validateOnSet() == false) goto L5;
        validateValue(r3, this._schemaType, _voorVc);
    L5:
        super.set_double(r3);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String r3, ValidationContext r4) {
        ValidationContext r5 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r4, ValidationContext.class, "com.obric.memorydata.plugin");
        validateLexical(r3, schemaType(), r5);
        validateValue(getDoubleValue(), schemaType(), r5);
    }
}
