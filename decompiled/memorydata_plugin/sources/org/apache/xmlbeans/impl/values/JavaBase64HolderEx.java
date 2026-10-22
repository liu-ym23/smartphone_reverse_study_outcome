package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: loaded from: classes7.dex */
public abstract class JavaBase64HolderEx extends JavaBase64Holder {
    private final SchemaType _schemaType;

    public JavaBase64HolderEx(SchemaType r3, boolean r4) {
        this._schemaType = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        initComplexType(r4, false);
    }

    public static void validateValue(byte[] r11, SchemaType r12, ValidationContext r13) {
        SchemaType r14 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r12, SchemaType.class, "com.obric.memorydata.plugin");
        ValidationContext r15 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r13, ValidationContext.class, "com.obric.memorydata.plugin");
        XmlAnySimpleType r2 = r14.getFacet(0);
        if (r2 == null) goto L7;
        int r3 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r2, XmlObjectBase.class, "com.obric.memorydata.plugin")).getBigIntegerValue().intValue();
        if (r3 == r11.length) goto L7;
        r15.invalid("cvc-length-valid.1.2", new Object[]{"base64Binary", Integer.valueOf(r11.length), Integer.valueOf(r3), QNameHelper.readable(r14)});
    L7:
        XmlAnySimpleType r4 = r14.getFacet(1);
        if (r4 == null) goto L12;
        int r5 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r4, XmlObjectBase.class, "com.obric.memorydata.plugin")).getBigIntegerValue().intValue();
        if (r5 <= r11.length) goto L12;
        r15.invalid("cvc-minLength-valid.1.2", new Object[]{"base64Binary", Integer.valueOf(r11.length), Integer.valueOf(r5), QNameHelper.readable(r14)});
    L12:
        XmlAnySimpleType r6 = r14.getFacet(2);
        if (r6 == null) goto L17;
        int r7 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r6, XmlObjectBase.class, "com.obric.memorydata.plugin")).getBigIntegerValue().intValue();
        if (r7 >= r11.length) goto L17;
        r15.invalid("cvc-maxLength-valid.1.2", new Object[]{"base64Binary", Integer.valueOf(r11.length), Integer.valueOf(r7), QNameHelper.readable(r14)});
    L17:
        XmlAnySimpleType[] r8 = r14.getEnumerationValues();
        if (r8 == null) goto L40;
        int r9 = 0;
    L21:
        if (r9 >= r8.length) goto L33;
        byte[] r10 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r8[r9], XmlObjectBase.class, "com.obric.memorydata.plugin")).getByteArrayValue();
        if (r10.length != r11.length) goto L30;
        int r16 = 0;
    L27:
        if (r16 >= r10.length) goto L33;
        if (r10[r16] != r11[r16]) goto L30;
        r16 = r16 + 1;
    L30:
        r9 = r9 + 1;
    L33:
        if (r9 < r8.length) goto L41;
        r15.invalid("cvc-enumeration-valid.b", new Object[]{"base64Binary", QNameHelper.readable(r14)});
        return;
    L41:
        return;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int get_wscanon_rule() {
        return schemaType().getWhiteSpaceRule();
    }

    @Override // org.apache.xmlbeans.impl.values.JavaBase64Holder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaBase64Holder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_ByteArray(byte[] r3) {
        if (_validateOnSet() == false) goto L5;
        validateValue(r3, schemaType(), _voorVc);
    L5:
        super.set_ByteArray(r3);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaBase64Holder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String r3) {
        if (_validateOnSet() == false) goto L5;
        byte[] r4 = validateLexical(r3, schemaType(), _voorVc);
    L6:
        if (r4 != null) goto L8;
    L10:
        if (r4 == null) goto L13;
        super.set_ByteArray(r4);
        return;
    L13:
        return;
    L8:
        if (_validateOnSet() == false) goto L10;
        validateValue(r4, schemaType(), XmlObjectBase._voorVc);
        goto L10
    L5:
        r4 = lex(r3, _voorVc);
        goto L6
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String r3, ValidationContext r4) {
        ValidationContext r5 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r4, ValidationContext.class, "com.obric.memorydata.plugin");
        validateLexical(r3, schemaType(), r5);
        validateValue(getByteArrayValue(), schemaType(), r5);
    }
}
