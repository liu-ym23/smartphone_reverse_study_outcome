package com.microsoft.schemas.office.excel.impl;

import com.microsoft.schemas.office.excel.STObjectType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;

/* JADX INFO: loaded from: classes3.dex */
public class STObjectTypeImpl extends JavaStringEnumerationHolderEx implements STObjectType {
    private static final long serialVersionUID = 1;

    public STObjectTypeImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), false);
    }

    public STObjectTypeImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
