package org.apache.xmlbeans.impl.values;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: loaded from: classes7.dex */
public abstract class JavaStringHolderEx extends JavaStringHolder {
    private final SchemaType _schemaType;

    public JavaStringHolderEx(SchemaType r3, boolean r4) {
        this._schemaType = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        initComplexType(r4, false);
    }

    public static void validateLexical(String r9, SchemaType r10, ValidationContext r11) {
        SchemaType r12 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r10, SchemaType.class, "com.obric.memorydata.plugin");
        ValidationContext r13 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r11, ValidationContext.class, "com.obric.memorydata.plugin");
        if (r12.matchPatternFacet(r9) == true) goto L6;
        r13.invalid("cvc-datatype-valid.1.1", new Object[]{TypedValues.Custom.S_STRING, r9, QNameHelper.readable(r12)});
        return;
    L6:
        XmlAnySimpleType r0 = r12.getFacet(0);
        if (r0 == null) goto L12;
        int r1 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r0, XmlObjectBase.class, "com.obric.memorydata.plugin")).getBigIntegerValue().intValue();
        if (r9.length() == r1) goto L12;
        r13.invalid("cvc-length-valid.1.1", new Object[]{TypedValues.Custom.S_STRING, Integer.valueOf(r9.length()), Integer.valueOf(r1), QNameHelper.readable(r12)});
        return;
    L12:
        XmlAnySimpleType r2 = r12.getFacet(1);
        if (r2 == null) goto L18;
        int r3 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r2, XmlObjectBase.class, "com.obric.memorydata.plugin")).getBigIntegerValue().intValue();
        if (r9.length() >= r3) goto L18;
        r13.invalid("cvc-minLength-valid.1.1", new Object[]{TypedValues.Custom.S_STRING, Integer.valueOf(r9.length()), Integer.valueOf(r3), QNameHelper.readable(r12)});
        return;
    L18:
        XmlAnySimpleType r4 = r12.getFacet(2);
        if (r4 == null) goto L24;
        int r5 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r4, XmlObjectBase.class, "com.obric.memorydata.plugin")).getBigIntegerValue().intValue();
        if (r9.length() <= r5) goto L24;
        r13.invalid("cvc-maxLength-valid.1.1", new Object[]{TypedValues.Custom.S_STRING, Integer.valueOf(r9.length()), Integer.valueOf(r5), QNameHelper.readable(r12)});
        return;
    L24:
        XmlAnySimpleType[] r6 = r12.getEnumerationValues();
        if (r6 == null) goto L36;
        int r7 = r6.length;
        int r8 = 0;
    L27:
        if (r8 >= r7) goto L32;
        if (r9.equals(r6[r8].getStringValue()) == true) goto L30;
        r8 = r8 + 1;
        goto L27
    L30:
        return;
    L32:
        r13.invalid("cvc-enumeration-valid", new Object[]{TypedValues.Custom.S_STRING, r9, QNameHelper.readable(r12)});
        return;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaStringHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public int get_wscanon_rule() {
        return schemaType().getWhiteSpaceRule();
    }

    @Override // org.apache.xmlbeans.impl.values.JavaStringHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean is_defaultable_ws(String r2) {
        validateLexical(r2, this._schemaType, _voorVc);     // Catch: XmlValueOutOfRangeException -> L5
        return false;
    L5:
        return true;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaStringHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaStringHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String r3) {
        if (_validateOnSet() == false) goto L5;
        validateLexical(r3, this._schemaType, _voorVc);
    L5:
        super.set_text(r3);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String r2, ValidationContext r3) {
        ValidationContext r4 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r3, ValidationContext.class, "com.obric.memorydata.plugin");
        validateLexical(getStringValue(), schemaType(), r4);
    }
}
