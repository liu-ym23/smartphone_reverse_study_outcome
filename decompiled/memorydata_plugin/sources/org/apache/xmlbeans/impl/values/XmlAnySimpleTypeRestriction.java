package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;

/* JADX INFO: loaded from: classes7.dex */
public class XmlAnySimpleTypeRestriction extends XmlAnySimpleTypeImpl {
    private SchemaType _schemaType;

    public XmlAnySimpleTypeRestriction(SchemaType r3, boolean r4) {
        this._schemaType = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        initComplexType(r4, false);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlAnySimpleTypeImpl, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }
}
