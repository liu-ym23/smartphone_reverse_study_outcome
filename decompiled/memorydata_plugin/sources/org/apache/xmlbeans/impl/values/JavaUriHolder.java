package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;

/* JADX INFO: loaded from: classes7.dex */
public abstract class JavaUriHolder extends XmlObjectBase {
    private String _value;

    public JavaUriHolder() {
    }

    public static void validateLexical(String r2, ValidationContext r3) {
        ValidationContext r4 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r3, ValidationContext.class, "com.obric.memorydata.plugin");
        if (r2.startsWith("##") == false) goto L6;
        r4.invalid("anyURI", new Object[]{r2});
        return;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager r3) {
        NamespaceManager r4 = (NamespaceManager) ZeusTransformUtils.wrapperContextForParams(r3, NamespaceManager.class, "com.obric.memorydata.plugin");
        String r2 = this._value;
        if (r2 != null) goto L6;
        return "";
    L6:
        return r2;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject r3) {
        XmlObject r4 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin");
        return this._value.equals(((XmlAnyURI) ZeusTransformUtils.preCheckCast(r4, XmlAnyURI.class, "com.obric.memorydata.plugin")).getStringValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return BuiltinSchemaTypeSystem.ST_ANY_URI;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
        this._value = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String r2) {
        if (_validateOnSet() == false) goto L5;
        validateLexical(r2, _voorVc);
    L5:
        this._value = r2;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int value_hash_code() {
        return this._value.hashCode();
    }
}
