package org.apache.xmlbeans.impl.values;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: loaded from: classes7.dex */
public abstract class JavaFloatHolderEx extends JavaFloatHolder {
    private final SchemaType _schemaType;

    public JavaFloatHolderEx(SchemaType r3, boolean r4) {
        this._schemaType = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        initComplexType(r4, false);
    }

    public static float validateLexical(String r4, SchemaType r5, ValidationContext r6) {
        SchemaType r7 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r5, SchemaType.class, "com.obric.memorydata.plugin");
        ValidationContext r8 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r6, ValidationContext.class, "com.obric.memorydata.plugin");
        float r0 = JavaFloatHolder.validateLexical(r4, r8);
        if (r7.matchPatternFacet(r4) == true) goto L5;
        r8.invalid("cvc-datatype-valid.1.1", new Object[]{TypedValues.Custom.S_FLOAT, r4, QNameHelper.readable(r7)});
    L5:
        return r0;
    }

    public static void validateValue(float r11, SchemaType r12, ValidationContext r13) {
        SchemaType r14 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r12, SchemaType.class, "com.obric.memorydata.plugin");
        ValidationContext r15 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r13, ValidationContext.class, "com.obric.memorydata.plugin");
        XmlAnySimpleType r2 = r14.getFacet(3);
        if (r2 == null) goto L7;
        float r3 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r2, XmlObjectBase.class, "com.obric.memorydata.plugin")).getFloatValue();
        if (compare(r11, r3) > 0) goto L7;
        r15.invalid("cvc-minExclusive-valid", new Object[]{TypedValues.Custom.S_FLOAT, Float.valueOf(r11), Float.valueOf(r3), QNameHelper.readable(r14)});
    L7:
        XmlAnySimpleType r4 = r14.getFacet(4);
        if (r4 == null) goto L12;
        float r5 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r4, XmlObjectBase.class, "com.obric.memorydata.plugin")).getFloatValue();
        if (compare(r11, r5) >= 0) goto L12;
        r15.invalid("cvc-minInclusive-valid", new Object[]{TypedValues.Custom.S_FLOAT, Float.valueOf(r11), Float.valueOf(r5), QNameHelper.readable(r14)});
    L12:
        XmlAnySimpleType r6 = r14.getFacet(5);
        if (r6 == null) goto L17;
        float r7 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r6, XmlObjectBase.class, "com.obric.memorydata.plugin")).getFloatValue();
        if (compare(r11, r7) <= 0) goto L17;
        r15.invalid("cvc-maxInclusive-valid", new Object[]{TypedValues.Custom.S_FLOAT, Float.valueOf(r11), Float.valueOf(r7), QNameHelper.readable(r14)});
    L17:
        XmlAnySimpleType r8 = r14.getFacet(6);
        if (r8 == null) goto L22;
        float r9 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r8, XmlObjectBase.class, "com.obric.memorydata.plugin")).getFloatValue();
        if (compare(r11, r9) < 0) goto L22;
        r15.invalid("cvc-maxExclusive-valid", new Object[]{TypedValues.Custom.S_FLOAT, Float.valueOf(r11), Float.valueOf(r9), QNameHelper.readable(r14)});
    L22:
        XmlAnySimpleType[] r10 = r14.getEnumerationValues();
        if (r10 == null) goto L34;
        int r16 = r10.length;
        int r17 = 0;
    L25:
        if (r17 >= r16) goto L30;
        if (compare(r11, ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r10[r17], XmlObjectBase.class, "com.obric.memorydata.plugin")).getFloatValue()) == 0) goto L28;
        r17 = r17 + 1;
        goto L25
    L28:
        return;
    L30:
        r15.invalid("cvc-enumeration-valid", new Object[]{TypedValues.Custom.S_FLOAT, Float.valueOf(r11), QNameHelper.readable(r14)});
        return;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaFloatHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaFloatHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_float(float r3) {
        if (_validateOnSet() == false) goto L5;
        validateValue(r3, this._schemaType, _voorVc);
    L5:
        super.set_float(r3);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String r3, ValidationContext r4) {
        ValidationContext r5 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r4, ValidationContext.class, "com.obric.memorydata.plugin");
        validateLexical(r3, schemaType(), r5);
        validateValue(getFloatValue(), schemaType(), r5);
    }
}
