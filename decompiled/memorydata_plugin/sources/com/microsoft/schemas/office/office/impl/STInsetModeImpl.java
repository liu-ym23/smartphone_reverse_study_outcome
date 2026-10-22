package com.microsoft.schemas.office.office.impl;

import com.microsoft.schemas.office.office.STInsetMode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;

/* JADX INFO: loaded from: classes3.dex */
public class STInsetModeImpl extends JavaStringEnumerationHolderEx implements STInsetMode {
    private static final long serialVersionUID = 1;

    public STInsetModeImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), false);
    }

    public STInsetModeImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
