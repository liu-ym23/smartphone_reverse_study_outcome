package com.microsoft.schemas.office.office.impl;

import com.microsoft.schemas.office.office.STOLEType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;

/* JADX INFO: loaded from: classes3.dex */
public class STOLETypeImpl extends JavaStringEnumerationHolderEx implements STOLEType {
    private static final long serialVersionUID = 1;

    public STOLETypeImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), false);
    }

    public STOLETypeImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
