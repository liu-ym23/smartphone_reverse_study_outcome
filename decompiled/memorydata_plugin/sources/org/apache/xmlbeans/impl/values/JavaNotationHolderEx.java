package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: loaded from: classes7.dex */
public abstract class JavaNotationHolderEx extends JavaNotationHolder {
    private SchemaType _schemaType;

    public JavaNotationHolderEx(SchemaType r3, boolean r4) {
        this._schemaType = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        initComplexType(r4, false);
    }

    private static boolean check(String r5, SchemaType r6) {
        SchemaType r7 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r6, SchemaType.class, "com.obric.memorydata.plugin");
        XmlAnySimpleType r2 = r7.getFacet(0);
        if (r2 == null) goto L7;
        int r3 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r2, XmlObjectBase.class, "com.obric.memorydata.plugin")).getBigIntegerValue().intValue();
        if (r5.length() != r3) goto L7;
        return false;
    L7:
        XmlAnySimpleType r4 = r7.getFacet(1);
        if (r4 == null) goto L12;
        int r8 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r4, XmlObjectBase.class, "com.obric.memorydata.plugin")).getBigIntegerValue().intValue();
        if (r5.length() >= r8) goto L12;
        return false;
    L12:
        XmlAnySimpleType r9 = r7.getFacet(2);
        if (r9 == null) goto L17;
        int r10 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r9, XmlObjectBase.class, "com.obric.memorydata.plugin")).getBigIntegerValue().intValue();
        if (r5.length() <= r10) goto L17;
        return false;
    L17:
        return true;
    }

    public static QName validateLexical(String r3, SchemaType r4, ValidationContext r5, PrefixResolver r6) {
        SchemaType r7 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
        ValidationContext r8 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r5, ValidationContext.class, "com.obric.memorydata.plugin");
        QName r9 = JavaQNameHolder.validateLexical(r3, r8, (PrefixResolver) ZeusTransformUtils.wrapperContextForParams(r6, PrefixResolver.class, "com.obric.memorydata.plugin"));
        if (r7.hasPatternFacet() == true) goto L5;
    L7:
        check(r3, r7);
        return r9;
    L5:
        if (r7.matchPatternFacet(r3) == true) goto L7;
        r8.invalid("cvc-datatype-valid.1.1", new Object[]{"NOTATION", r3, QNameHelper.readable(r7)});
        goto L7
    }

    public static void validateValue(QName r6, SchemaType r7, ValidationContext r8) {
        SchemaType r9 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r7, SchemaType.class, "com.obric.memorydata.plugin");
        ValidationContext r10 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r8, ValidationContext.class, "com.obric.memorydata.plugin");
        XmlAnySimpleType[] r0 = r9.getEnumerationValues();
        if (r0 == null) goto L15;
        int r3 = 0;
    L6:
        if (r3 >= r0.length) goto L11;
        if (r6.equals(((XmlObjectBase) ZeusTransformUtils.preCheckCast(r0[r3], XmlObjectBase.class, "com.obric.memorydata.plugin")).getQNameValue()) == true) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return;
    L11:
        r10.invalid("cvc-enumeration-valid", new Object[]{"NOTATION", r6, QNameHelper.readable(r9)});
        return;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public int get_wscanon_rule() {
        return schemaType().getWhiteSpaceRule();
    }

    @Override // org.apache.xmlbeans.impl.values.JavaNotationHolder, org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_notation(String r1) {
        set_text(r1);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
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

    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_xmlanysimple(XmlAnySimpleType r4) {
        XmlAnySimpleType r5 = (XmlAnySimpleType) ZeusTransformUtils.wrapperContextForParams(r4, XmlAnySimpleType.class, "com.obric.memorydata.plugin");
        boolean r0 = _validateOnSet();
        String r6 = r5.getStringValue();
        if (r0 == false) goto L7;
        QName r7 = validateLexical(r6, this._schemaType, _voorVc, NamespaceContext.getCurrent());
        if (r7 == null) goto L8;
        validateValue(r7, this._schemaType, _voorVc);
    L8:
        super.set_QName(r7);
        return;
    L7:
        r7 = JavaNotationHolder.validateLexical(r6, _voorVc, NamespaceContext.getCurrent());
        goto L8
    }
}
