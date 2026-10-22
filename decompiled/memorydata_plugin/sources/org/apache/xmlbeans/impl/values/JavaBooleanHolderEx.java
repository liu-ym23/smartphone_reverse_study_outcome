package org.apache.xmlbeans.impl.values;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: loaded from: classes7.dex */
public abstract class JavaBooleanHolderEx extends JavaBooleanHolder {
    private final SchemaType _schemaType;

    public JavaBooleanHolderEx(SchemaType r3, boolean r4) {
        this._schemaType = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        initComplexType(r4, false);
    }

    public static boolean validateLexical(String r2, SchemaType r3, ValidationContext r4) {
        SchemaType r5 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        ValidationContext r6 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r4, ValidationContext.class, "com.obric.memorydata.plugin");
        boolean r0 = JavaBooleanHolder.validateLexical(r2, r6);
        validatePattern(r2, r5, r6);
        return r0;
    }

    public static void validatePattern(String r3, SchemaType r4, ValidationContext r5) {
        SchemaType r6 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
        ValidationContext r7 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r5, ValidationContext.class, "com.obric.memorydata.plugin");
        if (r6.matchPatternFacet(r3) == true) goto L6;
        r7.invalid("cvc-datatype-valid.1.1", new Object[]{TypedValues.Custom.S_BOOLEAN, r3, QNameHelper.readable(r6)});
        return;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaBooleanHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaBooleanHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String r3) {
        if (_validateOnSet() == false) goto L5;
        validatePattern(r3, this._schemaType, _voorVc);
    L5:
        super.set_text(r3);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String r3, ValidationContext r4) {
        ValidationContext r5 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r4, ValidationContext.class, "com.obric.memorydata.plugin");
        validateLexical(r3, schemaType(), r5);
    }
}
