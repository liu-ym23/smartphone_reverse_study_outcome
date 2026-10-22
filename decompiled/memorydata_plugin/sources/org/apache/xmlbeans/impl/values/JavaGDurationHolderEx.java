package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.GDurationSpecification;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: loaded from: classes7.dex */
public abstract class JavaGDurationHolderEx extends XmlObjectBase {
    private final SchemaType _schemaType;
    GDuration _value;

    public JavaGDurationHolderEx(SchemaType r3, boolean r4) {
        this._schemaType = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        initComplexType(r4, false);
    }

    public static GDuration lex(String r2, ValidationContext r3) {
        return new GDuration(r2);
    L5:
        ((ValidationContext) ZeusTransformUtils.wrapperContextForParams(r3, ValidationContext.class, "com.obric.memorydata.plugin")).invalid("duration", new Object[]{r2});
        return null;
    }

    public static GDuration validateLexical(String r4, SchemaType r5, ValidationContext r6) {
        SchemaType r7 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r5, SchemaType.class, "com.obric.memorydata.plugin");
        ValidationContext r8 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r6, ValidationContext.class, "com.obric.memorydata.plugin");
        GDuration r0 = lex(r4, r8);
        if (r0 != null) goto L5;
    L9:
        return r0;
    L5:
        if (r7.hasPatternFacet() == false) goto L9;
        if (r7.matchPatternFacet(r4) == true) goto L9;
        r8.invalid("cvc-datatype-valid.1.1", new Object[]{"duration", r4, QNameHelper.readable(r7)});
        goto L9
    }

    public static void validateValue(GDurationSpecification r11, SchemaType r12, ValidationContext r13) {
        GDurationSpecification r14 = (GDurationSpecification) ZeusTransformUtils.wrapperContextForParams(r11, GDurationSpecification.class, "com.obric.memorydata.plugin");
        SchemaType r15 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r12, SchemaType.class, "com.obric.memorydata.plugin");
        ValidationContext r16 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r13, ValidationContext.class, "com.obric.memorydata.plugin");
        XmlAnySimpleType r2 = r15.getFacet(3);
        if (r2 == null) goto L7;
        GDuration r3 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r2, XmlObjectBase.class, "com.obric.memorydata.plugin")).getGDurationValue();
        if (r14.compareToGDuration(r3) > 0) goto L7;
        r16.invalid("cvc-minExclusive-valid", new Object[]{"duration", r14, r3, QNameHelper.readable(r15)});
    L7:
        XmlAnySimpleType r4 = r15.getFacet(4);
        if (r4 == null) goto L12;
        GDuration r5 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r4, XmlObjectBase.class, "com.obric.memorydata.plugin")).getGDurationValue();
        if (r14.compareToGDuration(r5) >= 0) goto L12;
        r16.invalid("cvc-minInclusive-valid", new Object[]{"duration", r14, r5, QNameHelper.readable(r15)});
    L12:
        XmlAnySimpleType r6 = r15.getFacet(6);
        if (r6 == null) goto L17;
        GDuration r7 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r6, XmlObjectBase.class, "com.obric.memorydata.plugin")).getGDurationValue();
        if (r14.compareToGDuration(r7) < 0) goto L17;
        r16.invalid("cvc-maxExclusive-valid", new Object[]{"duration", r14, r7, QNameHelper.readable(r15)});
    L17:
        XmlAnySimpleType r8 = r15.getFacet(5);
        if (r8 == null) goto L22;
        GDuration r9 = ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r8, XmlObjectBase.class, "com.obric.memorydata.plugin")).getGDurationValue();
        if (r14.compareToGDuration(r9) <= 0) goto L22;
        r16.invalid("cvc-maxInclusive-valid", new Object[]{"duration", r14, r9, QNameHelper.readable(r15)});
    L22:
        XmlAnySimpleType[] r10 = r15.getEnumerationValues();
        if (r10 == null) goto L34;
        int r17 = r10.length;
        int r18 = 0;
    L25:
        if (r18 >= r17) goto L30;
        if (r14.compareToGDuration(((XmlObjectBase) ZeusTransformUtils.preCheckCast(r10[r18], XmlObjectBase.class, "com.obric.memorydata.plugin")).getGDurationValue()) == 0) goto L28;
        r18 = r18 + 1;
        goto L25
    L28:
        return;
    L30:
        r16.invalid("cvc-enumeration-valid", new Object[]{"duration", r14, QNameHelper.readable(r15)});
        return;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int compare_to(XmlObject r3) {
        XmlObject r4 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin");
        return this._value.compareToGDuration(((XmlObjectBase) ZeusTransformUtils.preCheckCast(r4, XmlObjectBase.class, "com.obric.memorydata.plugin")).getGDurationValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager r3) {
        NamespaceManager r4 = (NamespaceManager) ZeusTransformUtils.wrapperContextForParams(r3, NamespaceManager.class, "com.obric.memorydata.plugin");
        GDuration r2 = this._value;
        if (r2 != null) goto L6;
        return "";
    L6:
        return r2.toString();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject r3) {
        XmlObject r4 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin");
        return this._value.equals(((XmlObjectBase) ZeusTransformUtils.preCheckCast(r4, XmlObjectBase.class, "com.obric.memorydata.plugin")).getGDurationValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public GDuration getGDurationValue() {
        check_dated();
        GDuration r0 = this._value;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_GDuration(GDurationSpecification r4) {
        GDurationSpecification r5 = (GDurationSpecification) ZeusTransformUtils.wrapperContextForParams(r4, GDurationSpecification.class, "com.obric.memorydata.plugin");
        if (_validateOnSet() == false) goto L6;
        validateValue(r5, this._schemaType, _voorVc);
    L6:
        if (r5.isImmutable() == true) goto L8;
    L10:
        this._value = new GDuration(r5);
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r5, GDuration.class) == false) goto L10;
        this._value = (GDuration) ZeusTransformUtils.preCheckCast(r5, GDuration.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
        this._value = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String r3) {
        if (_validateOnSet() == false) goto L5;
        GDuration r4 = validateLexical(r3, this._schemaType, _voorVc);
    L7:
        if (_validateOnSet() == false) goto L10;
        if (r4 == null) goto L10;
        validateValue(r4, this._schemaType, _voorVc);
    L10:
        this._value = r4;
        return;
    L5:
        r4 = lex(r3, _voorVc);
        goto L7
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String r3, ValidationContext r4) {
        ValidationContext r5 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r4, ValidationContext.class, "com.obric.memorydata.plugin");
        validateLexical(r3, schemaType(), r5);
        validateValue(getGDurationValue(), schemaType(), r5);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int value_hash_code() {
        return this._value.hashCode();
    }
}
