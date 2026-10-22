package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: loaded from: classes7.dex */
public abstract class JavaQNameHolderEx extends JavaQNameHolder {
    private SchemaType _schemaType;

    public JavaQNameHolderEx(SchemaType r3, boolean r4) {
        this._schemaType = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        initComplexType(r4, false);
    }

    public static QName validateLexical(String r3, SchemaType r4, ValidationContext r5, PrefixResolver r6) {
        SchemaType r7 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
        ValidationContext r8 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r5, ValidationContext.class, "com.obric.memorydata.plugin");
        QName r9 = JavaQNameHolder.validateLexical(r3, r8, (PrefixResolver) ZeusTransformUtils.wrapperContextForParams(r6, PrefixResolver.class, "com.obric.memorydata.plugin"));
        if (r7.hasPatternFacet() == true) goto L5;
    L7:
        return r9;
    L5:
        if (r7.matchPatternFacet(r3) == true) goto L7;
        r8.invalid("cvc-datatype-valid.1.1", new Object[]{"QName", r3, QNameHelper.readable(r7)});
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
        r10.invalid("cvc-enumeration-valid", new Object[]{"QName", r6, QNameHelper.readable(r9)});
        return;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public int get_wscanon_rule() {
        return schemaType().getWhiteSpaceRule();
    }

    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_QName(QName r3) {
        if (_validateOnSet() == false) goto L5;
        validateValue(r3, this._schemaType, _voorVc);
    L5:
        super.set_QName(r3);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String r4) {
        PrefixResolver r0 = NamespaceContext.getCurrent();
        if (r0 != null) goto L8;
        if (has_store() == false) goto L8;
        r0 = get_store();
    L8:
        if (_validateOnSet() == false) goto L12;
        QName r5 = validateLexical(r4, this._schemaType, _voorVc, r0);
        if (r5 == null) goto L13;
        validateValue(r5, this._schemaType, _voorVc);
    L13:
        super.set_QName(r5);
        return;
    L12:
        r5 = JavaQNameHolder.validateLexical(r4, _voorVc, r0);
        goto L13
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
        r7 = JavaQNameHolder.validateLexical(r6, _voorVc, NamespaceContext.getCurrent());
        goto L8
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String r2, ValidationContext r3) {
        ValidationContext r4 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r3, ValidationContext.class, "com.obric.memorydata.plugin");
        validateValue(getQNameValue(), schemaType(), r4);
    }
}
