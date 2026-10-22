package com.microsoft.schemas.office.excel.impl;

import com.microsoft.schemas.office.excel.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaStringHolderEx;

/* JADX INFO: loaded from: classes3.dex */
public class STCFImpl extends JavaStringHolderEx implements b {
    private static final long serialVersionUID = 1;

    public STCFImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), false);
    }

    public STCFImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
