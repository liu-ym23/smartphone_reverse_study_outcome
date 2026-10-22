package org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTrueFalse;

/* JADX INFO: loaded from: classes8.dex */
public class STTrueFalseImpl extends JavaStringEnumerationHolderEx implements STTrueFalse {
    private static final long serialVersionUID = 1;

    public STTrueFalseImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), false);
    }

    public STTrueFalseImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
