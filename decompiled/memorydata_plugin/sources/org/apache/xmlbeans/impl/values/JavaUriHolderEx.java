package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: loaded from: classes7.dex */
public class JavaUriHolderEx extends JavaUriHolder {
    private final SchemaType _schemaType;

    public JavaUriHolderEx(SchemaType r3, boolean r4) {
        this._schemaType = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        initComplexType(r4, false);
    }

    private static boolean check(String r5, SchemaType r6) {
        SchemaType r7 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r6, SchemaType.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        int r8 = 0;
    L6:
        XmlAnySimpleType r2 = r7.getFacet(0);
        if (r2 != null) goto L9;
    L11:
        XmlAnySimpleType r3 = r7.getFacet(1);
        if (r3 != null) goto L14;
    L16:
        XmlAnySimpleType r9 = r7.getFacet(2);
        if (r9 != null) goto L19;
    L21:
        return true;
    L19:
        if (r8 <= ((SimpleValue) ZeusTransformUtils.preCheckCast(r9, SimpleValue.class, "com.obric.memorydata.plugin")).getBigIntegerValue().intValue()) goto L21;
        return false;
    L14:
        if (r8 >= ((SimpleValue) ZeusTransformUtils.preCheckCast(r3, SimpleValue.class, "com.obric.memorydata.plugin")).getBigIntegerValue().intValue()) goto L16;
        return false;
    L9:
        if (r8 != ((SimpleValue) ZeusTransformUtils.preCheckCast(r2, SimpleValue.class, "com.obric.memorydata.plugin")).getBigIntegerValue().intValue()) goto L11;
        return false;
    L5:
        r8 = r5.length();
        goto L6
    }

    public static void validateLexical(String r10, SchemaType r11, ValidationContext r12) {
        SchemaType r13 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r11, SchemaType.class, "com.obric.memorydata.plugin");
        ValidationContext r14 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r12, ValidationContext.class, "com.obric.memorydata.plugin");
        XmlAnyUriImpl.validateLexical(r10, r14);
        XmlAnySimpleType[] r0 = r13.getEnumerationValues();
        if (r0 == null) goto L15;
        int r7 = 0;
    L6:
        if (r7 >= r0.length) goto L12;
        if (((SimpleValue) ZeusTransformUtils.preCheckCast(r0[r7], SimpleValue.class, "com.obric.memorydata.plugin")).getStringValue().equals(r10) == true) goto L12;
        r7 = r7 + 1;
    L12:
        if (r7 < r0.length) goto L15;
        r14.invalid("cvc-enumeration-valid", new Object[]{"anyURI", r10, QNameHelper.readable(r13)});
    L15:
        if (r13.hasPatternFacet() == true) goto L17;
    L19:
        XmlAnySimpleType r1 = r13.getFacet(0);
        if (r1 == null) goto L24;
        int r2 = ((SimpleValue) ZeusTransformUtils.preCheckCast(r1, SimpleValue.class, "com.obric.memorydata.plugin")).getBigIntegerValue().intValue();
        if (r2 == r10.length()) goto L24;
        r14.invalid("cvc-length-valid.1.1", new Object[]{"anyURI", r10, Integer.valueOf(r2), QNameHelper.readable(r13)});
    L24:
        XmlAnySimpleType r3 = r13.getFacet(1);
        if (r3 == null) goto L29;
        int r4 = ((SimpleValue) ZeusTransformUtils.preCheckCast(r3, SimpleValue.class, "com.obric.memorydata.plugin")).getBigIntegerValue().intValue();
        if (r4 <= r10.length()) goto L29;
        r14.invalid("cvc-minLength-valid.1.1", new Object[]{"anyURI", r10, Integer.valueOf(r4), QNameHelper.readable(r13)});
    L29:
        XmlAnySimpleType r5 = r13.getFacet(2);
        if (r5 == null) goto L37;
        int r6 = ((SimpleValue) ZeusTransformUtils.preCheckCast(r5, SimpleValue.class, "com.obric.memorydata.plugin")).getBigIntegerValue().intValue();
        if (r6 >= r10.length()) goto L38;
        r14.invalid("cvc-maxLength-valid.1.1", new Object[]{"anyURI", r10, Integer.valueOf(r6), QNameHelper.readable(r13)});
        return;
    L38:
        return;
    L37:
        return;
    L17:
        if (r13.matchPatternFacet(r10) == true) goto L19;
        r14.invalid("cvc-datatype-valid.1.1", new Object[]{"anyURI", r10, QNameHelper.readable(r13)});
        goto L19
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int get_wscanon_rule() {
        return schemaType().getWhiteSpaceRule();
    }

    @Override // org.apache.xmlbeans.impl.values.JavaUriHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaUriHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String r2) {
        if (_validateOnSet() == true) goto L5;
    L13:
        super.set_text(r2);
        return;
    L5:
        if (check(r2, this._schemaType) == false) goto L12;
        if (this._schemaType.matchPatternFacet(r2) == true) goto L13;
        throw new XmlValueOutOfRangeException();
    L12:
        throw new XmlValueOutOfRangeException();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String r2, ValidationContext r3) {
        ValidationContext r4 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r3, ValidationContext.class, "com.obric.memorydata.plugin");
        validateLexical(getStringValue(), schemaType(), r4);
    }
}
