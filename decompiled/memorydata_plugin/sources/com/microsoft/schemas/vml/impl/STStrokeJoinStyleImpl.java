package com.microsoft.schemas.vml.impl;

import com.microsoft.schemas.vml.STStrokeJoinStyle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;

/* JADX INFO: loaded from: classes3.dex */
public class STStrokeJoinStyleImpl extends JavaStringEnumerationHolderEx implements STStrokeJoinStyle {
    private static final long serialVersionUID = 1;

    public STStrokeJoinStyleImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), false);
    }

    public STStrokeJoinStyleImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
