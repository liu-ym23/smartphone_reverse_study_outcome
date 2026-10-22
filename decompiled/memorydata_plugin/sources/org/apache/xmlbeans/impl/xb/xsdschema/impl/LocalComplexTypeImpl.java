package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalComplexType;

/* JADX INFO: loaded from: classes7.dex */
public class LocalComplexTypeImpl extends ComplexTypeImpl implements LocalComplexType {
    private static final long serialVersionUID = 1;

    public LocalComplexTypeImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }
}
