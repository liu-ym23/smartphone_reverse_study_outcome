package org.apache.xmlbeans.impl.values;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: loaded from: classes7.dex */
public abstract class JavaStringEnumerationHolderEx extends JavaStringHolderEx {
    private StringEnumAbstractBase _val;

    public JavaStringEnumerationHolderEx(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }

    public static void validateLexical(String r2, SchemaType r3, ValidationContext r4) {
        JavaStringHolderEx.validateLexical(r2, (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r4, ValidationContext.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public StringEnumAbstractBase getEnumValue() {
        check_dated();
        return this._val;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_enum(StringEnumAbstractBase r3) {
        Class<? extends StringEnumAbstractBase> r0 = schemaType().getEnumJavaClass();
        if (r0 != null) goto L5;
    L9:
        super.set_text(r3.toString());
        this._val = r3;
        return;
    L5:
        if (r3.getClass().equals(r0) == true) goto L9;
        throw new XmlValueOutOfRangeException();
    }

    @Override // org.apache.xmlbeans.impl.values.JavaStringHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
        this._val = null;
        super.set_nil();
    }

    @Override // org.apache.xmlbeans.impl.values.JavaStringHolderEx, org.apache.xmlbeans.impl.values.JavaStringHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String r5) {
        StringEnumAbstractBase r0 = schemaType().enumForString(r5);
        if (r0 == null) goto L7;
        super.set_text(r5);
        this._val = r0;
        return;
    L7:
        throw new XmlValueOutOfRangeException("cvc-enumeration-valid", new Object[]{TypedValues.Custom.S_STRING, r5, QNameHelper.readable(schemaType())});
    }
}
