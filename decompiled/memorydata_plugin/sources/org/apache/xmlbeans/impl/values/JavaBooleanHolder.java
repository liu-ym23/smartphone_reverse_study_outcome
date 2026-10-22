package org.apache.xmlbeans.impl.values;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;

/* JADX INFO: loaded from: classes7.dex */
public abstract class JavaBooleanHolder extends XmlObjectBase {
    private boolean _value;

    public JavaBooleanHolder() {
    }

    public static boolean validateLexical(String r3, ValidationContext r4) {
        ValidationContext r5 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r4, ValidationContext.class, "com.obric.memorydata.plugin");
        if (r3.equals("true") == false) goto L5;
    L14:
        return true;
    L5:
        if (r3.equals("1") == true) goto L14;
        if (r3.equals("false") == false) goto L10;
    L13:
        return false;
    L10:
        if (r3.equals("0") == true) goto L13;
        r5.invalid(TypedValues.Custom.S_BOOLEAN, new Object[]{r3});
        goto L13
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int compare_to(XmlObject r3) {
        XmlObject r4 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin");
        if (this._value != ((XmlBoolean) ZeusTransformUtils.preCheckCast(r4, XmlBoolean.class, "com.obric.memorydata.plugin")).getBooleanValue()) goto L5;
        return 0;
    L5:
        return 2;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager r3) {
        NamespaceManager r4 = (NamespaceManager) ZeusTransformUtils.wrapperContextForParams(r3, NamespaceManager.class, "com.obric.memorydata.plugin");
        if (this._value == false) goto L5;
        return "true";
    L5:
        return "false";
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject r3) {
        XmlObject r4 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin");
        if (this._value != ((XmlBoolean) ZeusTransformUtils.preCheckCast(r4, XmlBoolean.class, "com.obric.memorydata.plugin")).getBooleanValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public boolean getBooleanValue() {
        check_dated();
        return this._value;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return BuiltinSchemaTypeSystem.ST_BOOLEAN;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_boolean(boolean r1) {
        this._value = r1;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
        this._value = false;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String r2) {
        this._value = validateLexical(r2, _voorVc);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int value_hash_code() {
        if (this._value == false) goto L5;
        return 957379554;
    L5:
        return 676335975;
    }
}
