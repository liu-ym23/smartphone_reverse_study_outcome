package com.microsoft.schemas.office.office.impl;

import com.microsoft.schemas.office.office.STOLEDrawAspect;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;

/* JADX INFO: loaded from: classes3.dex */
public class STOLEDrawAspectImpl extends JavaStringEnumerationHolderEx implements STOLEDrawAspect {
    private static final long serialVersionUID = 1;

    public STOLEDrawAspectImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), false);
    }

    public STOLEDrawAspectImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
